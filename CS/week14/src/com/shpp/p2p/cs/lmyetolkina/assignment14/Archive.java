package com.shpp.p2p.cs.lmyetolkina.assignment14;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Get byte array with compress code text and code table
 */
public class Archive implements Constants {

    private final ArrayList<Integer> uniqueSymbols = new ArrayList<>();
    private final byte[] archive;

    /**
     * Create archive byte array.
     * @param fileName'
     * @param fileLength'
     * @throws IOException can't read file
     */
    public Archive(String fileName, long fileLength) throws IOException {
        //Read file, form bytes array with all text symbols and  array list with unique symbols.
        byte[] textToArchive = extractAllSymbolsAndUniqueSymbols(fileName, fileLength);
        //Find the count of bit sequence
        int countBits = findCountBits(uniqueSymbols.size());
       //Compress text byte array
        byte[] codeText = codeText(textToArchive, countBits);
        //Convert array list with unique symbols to byte array
        byte[] codeTable = convertArrayListToByteArray();
        //Union some bytes arrays
        archive = createFinalArchiveArray(codeTable, codeText, fileLength);
    }

    /**
     * Read file and form ArrayList with unique symbols and byte array with all symbols
     *
     * @param fileName   ''
     * @param fileLength ''
     * @return text symbols in byte array
     * @throws IOException can't read file
     */
    private byte[] extractAllSymbolsAndUniqueSymbols(String fileName, long fileLength) throws IOException {

        byte[] textFromFile = new byte[(int) fileLength];
        int count = 0;
        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedInputStream buffer = new BufferedInputStream(fileInputStream, CLUSTER);

        int i;

        while ((i = buffer.read()) != -1) {
            if (uniqueSymbols.size() == 0 || !uniqueSymbols.contains(i)) {
                uniqueSymbols.add(i);
            }
            textFromFile[count] = (byte) uniqueSymbols.indexOf(i);
            count++;
        }

        buffer.close();
        fileInputStream.close();

        return textFromFile;
    }

    /**
     * @param numberUniqueSymbols - size of array list with unique symbols
     * @return count of bit for code text
     */
    private int findCountBits(int numberUniqueSymbols){
        int countBits;

        countBits = (int) (Math.log(numberUniqueSymbols) / Math.log(2));
        if (Math.log(numberUniqueSymbols) % Math.log(2) != 0) {
            countBits++;
        }
        return countBits;
    }

    /**
     * Compress start bytes array to code array.
     *
     * @param text  - start byte array
     * @param countBits -
     * @return code byte array
     */
    private byte[] codeText(byte[] text, int countBits) {

        int sizeBytesArray;
        byte[] codeText;
        StringBuilder bitsString;
        StringBuilder unionString = new StringBuilder();
        int counter = 0;

        if (countBits == NUMBER_BITS) {
            return text;
        }

        sizeBytesArray = text.length * countBits / NUMBER_BITS;

        if ((text.length * countBits) % NUMBER_BITS != 0) {
            sizeBytesArray++;
        }

        codeText = new byte[sizeBytesArray];

        for (byte item : text) {
            bitsString = createBitsString(item, countBits);
            unionString.append(bitsString);

            if (unionString.length() > NUMBER_BITS) {
                codeText[counter++] = (byte) convertBinToInt(unionString.substring(0, NUMBER_BITS));
                unionString = new StringBuilder(unionString.substring(NUMBER_BITS));
            }

            if (unionString.length() == NUMBER_BITS) {
                codeText[counter++] = (byte) convertBinToInt(unionString.toString());
                unionString = new StringBuilder();
            }
        }

        if (!unionString.toString().equals("")) {
            codeText[counter] = (byte) convertBinToInt(unionString.toString());
        }

        return codeText;
    }

    /**
     * Reduce all negative byte values to 8 digits. Add "0" to begin binary string
     * if the length of the binary string less than the length of count bits sequence.
     * @param item'
     * @param countBits'
     * @return converted string
     */
    private StringBuilder createBitsString(byte item, int countBits){
        StringBuilder bitsString = new StringBuilder(Integer.toBinaryString(item));
        if (bitsString.length() > NUMBER_BITS) {
            bitsString = new StringBuilder(bitsString.substring(bitsString.length() - NUMBER_BITS));
        }
        while (bitsString.length() % countBits != 0) {
            bitsString.insert(0, "0");
        }
        return bitsString;
    }

    /**
     * @param binaryString'
     * @return '
     */
    private int convertBinToInt(String binaryString){
        return Integer.parseInt(binaryString,2);
    }

    /**
     * @return byte array unique symbols
     */
    private byte[] convertArrayListToByteArray() {
        byte[] convertedArray = new byte[uniqueSymbols.size()];
        int item;
        for (int i = 0; i < convertedArray.length; i++) {
            item = uniqueSymbols.get(i);
            convertedArray[i] = (byte) item;
        }
        return convertedArray;
    }

    /**
     * Union all info to final byte array
     * @param codeTable ''
     * @param codeText ''
     * @param fileLength ''
     * @return final byte array
     */
    private byte[] createFinalArchiveArray(byte[] codeTable, byte[] codeText, long fileLength) {
        byte[] codeTableSize = ByteBuffer.allocate(TABLE_SIZE).putInt(codeTable.length).array();
        byte[] fileLengthToByte = ByteBuffer.allocate(NUMBER_BITS).putLong(fileLength).array();
        byte[] archive = unionArrays(codeTableSize, fileLengthToByte);
        archive = unionArrays(archive, codeTable);
        archive = unionArrays(archive, codeText);

        return archive;
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

    /**
     * Getter to final byte array
     * @return '
     */
    public byte[] getArchive() {
        return archive;
    }
}
