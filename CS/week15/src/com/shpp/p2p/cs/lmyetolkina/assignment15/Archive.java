package com.shpp.p2p.cs.lmyetolkina.assignment15;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.*;

/**
 * Get byte array with compress code text and code table
 */
public class Archive implements Constants {
    //The frequencies table for each symbol
    private final TreeMap<Byte, Integer> frequencies = new TreeMap<>();

    /**
     * Getter for output byte array
     *
     * @return final byte array
     */
    public byte[] getArchive() {
        return archive;
    }

    //Number of bits in last byte. This parameter is needed to correctly determine the last characters
    // in the unzipped array. We write it to the output byte array.
    int endedBits;

    //Final byte array to write into file
    private final byte[] archive;

    /**
     * Create archive byte array.
     *
     * @param fileName'
     * @param fileLength'
     * @throws IOException can't read file
     */
    public Archive(String fileName, long fileLength) throws IOException {
        //Read the text from the file and in parallel we determine the frequency with which each character occurs
        byte[] textToArchive = extractTextAndSymbolsFrequencies(fileName, fileLength);
        //Based on the resulting frequency table, we build a binary tree and find the code table with binary code string
        // for each character. We use the Huffman algorithm.
        TreeMap<Byte, String> codesMap = formCodesMap();
        //Form the output array

        archive = archive(getCodedText(codesMap, textToArchive));
    }

    /**
     * Read the text from the file and in parallel we determine the frequency with which each character occurs
     *
     * @param fileName   ''
     * @param fileLength ''
     * @return Text from file as byte array
     * @throws IOException can't read file
     */
    private byte[] extractTextAndSymbolsFrequencies(String fileName, long fileLength) throws IOException {
        byte[] textFromFile = new byte[(int) fileLength];
        int count = 0;
        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedInputStream buffer = new BufferedInputStream(fileInputStream, CLUSTER);
        int i;

        while ((i = buffer.read()) != -1) {
            if (frequencies.size() == 0 || !frequencies.containsKey((byte) i)) {
                frequencies.put((byte) i, 1);
            } else {
                if (frequencies.containsKey((byte) i)) frequencies.put((byte) i, frequencies.get((byte) i) + 1);
            }
            textFromFile[count++] = (byte) i;
        }

        buffer.close();
        fileInputStream.close();
        return textFromFile;
    }

    /**
     * Based on the resulting frequency table, we build a binary tree and find the code table with binary code string
     * for each character. We use the Huffman algorithm.
     *
     * @return table where each byte corresponds to a binary code
     */
    private TreeMap<Byte, String> formCodesMap() {
        Haffman hm = new Haffman(frequencies);
        ArrayList<BinaryTree> treeNodes = hm.findTreeNodes();
        BinaryTree tree = hm.huffman(treeNodes);
        return hm.findAllCodes(tree);
    }

    /**
     * Encode the text in parallel by combining characters into bytes of 8 bits
     *
     * @param codes - the code table
     * @param text  - the start text
     * @return - the coded byte array
     */
    private byte[] getCodedText(TreeMap<Byte, String> codes, byte[] text) {
        ArrayList<Byte> helpedArray = new ArrayList<>();
        StringBuilder unionBits = new StringBuilder();

        for (byte b : text) {
            unionBits.append(codes.get(b));

            while (unionBits.length() >= NUMBER_BITS) {
                helpedArray.add((byte) Integer.parseInt(unionBits.substring(0, NUMBER_BITS), 2));
                unionBits = new StringBuilder(unionBits.substring(NUMBER_BITS));
            }
        }

        if (unionBits.length() > 0) {
            endedBits = NUMBER_BITS - unionBits.length();
            while (unionBits.length() < NUMBER_BITS) {
                unionBits.append("1");
            }
            helpedArray.add((byte) Integer.parseInt(unionBits.toString(), 2));
        }

        return convertArrayListToByteArray(helpedArray);
    }

    /**
     * Convert ArrayList to array
     *
     * @param arrayList'
     * @return byte array
     */
    private byte[] convertArrayListToByteArray(ArrayList<Byte> arrayList) {
        byte[] byteArr = new byte[arrayList.size()];

        for (int i = 0; i < byteArr.length; i++) {
            byteArr[i] = arrayList.get(i);
        }
        return byteArr;
    }

    /**
     * In the final array we place information about the size of the table, the number of text bits in the last byte,
     * the table itself and the encoded text
     *
     * @param codeText the coded text
     * @return - the final byte array to write into the file
     */
    private byte[] archive(byte[] codeText) {
        byte[] frequenciesTable = convertFrequenciesTreeMapToBytes();
        int tableSize = frequenciesTable.length;
        byte[] tableSizeToByte = ByteBuffer.allocate(4).putInt(tableSize).array();
        byte[] lastBits = ByteBuffer.allocate(4).putInt(endedBits).array();

        //Form final byte array for archive
        byte[] finalBytesArray = unionArrays(tableSizeToByte, lastBits);
        finalBytesArray = unionArrays(finalBytesArray, frequenciesTable);
        finalBytesArray = unionArrays(finalBytesArray, codeText);

        return finalBytesArray;
    }

    /**
     * The array will store information about the symbol, its frequency and frequency multiples of the byte size.
     * The third value is needed for subsequent unzipping.
     *
     * @return the code table converted to byte array
     */
    private byte[] convertFrequenciesTreeMapToBytes() {

        byte[] map = new byte[frequencies.size() * 3];
        int count = 0;
        int frequency;

        for (Byte key : frequencies.keySet()) {
            map[count++] = key;
            frequency = frequencies.get(key);
            map[count++] = (byte) frequency;
            if (frequency >= NUMBER_BITS_IN_BYTE) {
                map[count++] = (byte) (frequency / NUMBER_BITS_IN_BYTE);
            } else {
                map[count++] = 0;
            }
        }
        return map;
    }

    /**
     * Union two byte arrays
     *
     * @param firstArray  - the first array
     * @param secondArray - the second array
     * @return the union array
     */
    private byte[] unionArrays(byte[] firstArray, byte[] secondArray) {
        byte[] both = Arrays.copyOf(firstArray, firstArray.length + secondArray.length);
        System.arraycopy(secondArray, 0, both, firstArray.length, secondArray.length);

        return both;
    }
}
