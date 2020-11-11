package com.shpp.p2p.cs.lmyetolkina.assignment15;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.*;

/**
 * Unarchive file to int array
 */
public class Unarchive implements Constants {
    int sizeTable; // The size of code table (integer value)
    int numberFinishBits; //The number of valid bits in the last byte of the encoded text
    private final TreeMap<Byte, Integer> frequencies; //The table unique text symbols in byte value and their text
    // frequencies
    ArrayList<Integer> decodedArray = new ArrayList<>(); //The helped array list. First add the decoded characters here,
    // and then convert to an int array
    int minLengthCodeString; //The minimal length of the code string

    TreeMap<String, Byte> convertedTable;

    private final int[] decodedText; //Final byte array with decoded text which can write to file

    /**
     * Getter to final byte array
     *
     * @return decoded text array
     */
    public int[] getDecodedText() {
        return decodedText;
    }

    /**
     * Convert compress code text to initial state. Convert based on the code table included to the archive
     *
     * @param inputFileName - the file which needs to unarchive
     */
    public Unarchive(String inputFileName) throws IOException {
        //Read file to byte array
        File archiveFile = new File(inputFileName);
        byte[] bytesFromFile = readArchive(inputFileName);

        //Extract the frequencies table and convert it to TreeMap for further use
        byte[] tableFromFile = getTableFromFile(bytesFromFile);
        frequencies = getFrequenciesTable(tableFromFile);

        convertedTable = getConvertedTable();

        //Decode text
        byte[] mainText = readFileSegment(bytesFromFile, START_TABLE_BYTE + sizeTable,
                (int) archiveFile.length() - (START_TABLE_BYTE + sizeTable));
        minLengthCodeString = minLengthCodeString(convertedTable);
        decodedText = unarchive(mainText);

    }

    /**
     * Use buffered file stream to read bytes from file
     *
     * @param fileName '
     * @return '
     * @throws IOException can't read file
     */
    private byte[] readArchive(String fileName) throws IOException {
        byte[] byteArray;
        FileInputStream stream = new FileInputStream(fileName);
        BufferedInputStream bufferStream = new BufferedInputStream(stream, CLUSTER);
        byteArray = new byte[bufferStream.available()];
        bufferStream.read(byteArray);

        return byteArray;
    }

    /**
     * @param bytesFromFile'
     * @return the frequencies table
     */

    private byte[] getTableFromFile(byte[] bytesFromFile) {

        byte[] sizeTableData = readFileSegment(bytesFromFile, 0, TABLE_SIZE);
        sizeTable = readIntegerValueFromBytes(sizeTableData);
        byte[] lastBits = readFileSegment(bytesFromFile, TABLE_SIZE, TABLE_SIZE);
        numberFinishBits = readIntegerValueFromBytes(lastBits);
        return readFileSegment(bytesFromFile, START_TABLE_BYTE, sizeTable);
    }

    /**
     * @param bytesFromFile'
     * @param index          - the start index
     * @param count          - the count of read byte
     * @return - the part of array
     */
    private byte[] readFileSegment(byte[] bytesFromFile, int index, int count) {

        byte[] segmentFile = new byte[count];
        if (count >= 0) System.arraycopy(bytesFromFile, index, segmentFile, 0, count);
        return segmentFile;
    }

    /**
     * @param bytes'
     * @return int value from byte array
     */
    private int readIntegerValueFromBytes(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getInt();
    }

    /**
     * Use Haffaman algorithm to get the code table
     *
     * @return TreeMap - String: the binary code string, Byte: symbol
     */
    private TreeMap<String, Byte> getConvertedTable() {
        Haffman hm = new Haffman(frequencies);
        ArrayList<BinaryTree> treeNodes = hm.findTreeNodes();
        BinaryTree tree = hm.huffman(treeNodes);
        return convertedTree(tree);
    }

    /**
     * @param table byte array with unique symbols, them frequencies
     * @return TreeMap -  Byte: symbol, Integer - the symbol frequency
     */
    private TreeMap<Byte, Integer> getFrequenciesTable(byte[] table) {

        TreeMap<Byte, Integer> decodeTable = new TreeMap<>();
        String binaryString;
        int intFrequencyValue;

        for (int i = 0; i < table.length - 1; i = i + 3) {

            intFrequencyValue = table[i + 1];
            if (table[i + 2] != 0) {
                if (intFrequencyValue < 0) intFrequencyValue += NUMBER_BITS_IN_BYTE;
                intFrequencyValue = intFrequencyValue + table[i + 2] * NUMBER_BITS_IN_BYTE;
            }
            if (intFrequencyValue < 0) {
                binaryString = Integer.toBinaryString(intFrequencyValue);
                binaryString = binaryString.substring(binaryString.length() - NUMBER_BITS);
                intFrequencyValue = Integer.parseInt(binaryString, 2);
            }
            decodeTable.put(table[i], intFrequencyValue);
        }

        return decodeTable;
    }

    /**
     * Use "getCodeForByte" method from "BinaryTree" class to get binary code each symbol based on it frequency
     *
     * @param tree - Binary tree
     * @return the binary codes table
     */
    private TreeMap<String, Byte> convertedTree(BinaryTree tree) {
        TreeMap<String, Byte> convertedTree = new TreeMap<>();
        for (Byte symbol : frequencies.keySet()) {
            convertedTree.put(tree.getCodeForSymbol(symbol, ""), symbol);
        }
        return convertedTree;
    }


    /**
     * Get decoded text byte array. It can be write to file.
     * Decoded algorithm:
     * Convert the first byte to a binary string. Next, we read this string symbolically ("findCodeString" method)
     * and look for a suitable code string ("addItemToDecodeArrayList" method). If the code string is ​​found,
     * enter the corresponding character into the ArrayList.
     * Cut the found code from the string. Check the new string in the same way. If the string contains characters
     * that are not a code or the length of the string is less than the shortest code string,
     * then we attach the next byte represented by a binary string to these characters and repeat the cycle
     * until we go through the whole text. In the last byte, we use only the bits included in the "numberFinishBits".
     *
     * @param text - array with coded text
     * @return - byte array with decoded text
     */
    private int[] unarchive(byte[] text) {
        StringBuilder unionBits = new StringBuilder();
        StringBuilder binaryString;

        for (int i = 0; i < text.length; i++) {
            binaryString = getStringFromByte(text[i]);
            if (i == text.length - 1) {
                binaryString = new StringBuilder(binaryString.substring(0, binaryString.length() - numberFinishBits));
            }
            unionBits.append(binaryString);
            unionBits = findCodeString(unionBits);
        }
        //Convert decoded ArrayList to int array
        return getIntArrayFromArrayList(decodedArray);
    }

    /**
     * If the byte is negative, we take the last 8 characters from its binary representation.
     * If the binary string is less than 8 characters long, add zeros to the beginning of the string
     *
     * @param item current byte value
     * @return new string
     */
    private StringBuilder getStringFromByte(byte item) {
        StringBuilder itemString = new StringBuilder(Integer.toBinaryString(item));

        if (itemString.length() > NUMBER_BITS) {
            itemString = new StringBuilder(itemString.substring(itemString.length() - NUMBER_BITS));
        }
        while (itemString.length() < NUMBER_BITS) {
            itemString.insert(0, "0");
        }
        return itemString;
    }

    /**
     * @param unionBits - binary string whose characters are sequentially checked for coincidence
     *                  with one of the code string of the "convertedTable" TreeMap
     * @return rest of the string for which no code sequence was found
     */
    private StringBuilder findCodeString(StringBuilder unionBits) {
        int foundKey = 0;
        StringBuilder symbols = new StringBuilder();
        while (unionBits.length() >= minLengthCodeString) {
            for (int j = 0; j < unionBits.length(); j++) {
                symbols.append(unionBits.substring(j, j + 1));
                foundKey = addItemToDecodeArrayList(symbols);
                if (foundKey == 1) {
                    if (symbols.length() <= unionBits.length()) {
                        unionBits = new StringBuilder(unionBits.substring(symbols.length()));
                        symbols = new StringBuilder();
                        j = -1;
                    }
                }
            }
            if (foundKey == 0) break;
        }

        return unionBits;
    }

    /**
     * @param symbols - a sequence of characters from the main string, which is passed to check for a match
     *                with one of the code strings. If the code string is found, add the corresponding int value to the decoded ArrayList.
     * @return 1 - if code string was find, 0 - if code string wasn't find
     */
    private int addItemToDecodeArrayList(StringBuilder symbols) {
        for (String x : convertedTable.keySet()) {
            if (symbols.indexOf(x) == 0 && symbols.length() >= minLengthCodeString) {
                decodedArray.add((int) convertedTable.get(x));
                return 1;
            }
        }
        return 0;
    }

    /**
     * Finding the minimum length of a code string
     *
     * @param convertedTree - table with binary code strings
     * @return integer value presents minimum length
     */
    private int minLengthCodeString(TreeMap<String, Byte> convertedTree) {

        int minLength = MINIMUM;
        for (String s : convertedTree.keySet()) {
            if (s.length() < minLength) minLength = s.length();
        }
        return minLength;
    }

    /**
     * Convert ArrayList to int array
     *
     * @return - int array
     */
    private int[] getIntArrayFromArrayList(ArrayList<Integer> arrayList) {
        int[] intArray = new int[arrayList.size()];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = arrayList.get(i);
        }
        return intArray;
    }
}
