package com.shpp.p2p.cs.lmyetolkina.assignment14;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * Unarchive file to int array
 */
public class Unarchive implements Constants {
    private final int[] decodedText;

    /**
     * Getter to final byte array
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
        File archiveFile = new File(inputFileName);

        //Read info from file to the byte array
        byte[] bytesFromFile = readArchive(inputFileName);

        //Get array list with code table
        byte[] sizeTableData = readFileSegment(bytesFromFile, 0, TABLE_SIZE);
        int sizeTable = readIntegerValueFromBytes(sizeTableData);
        byte[] table = readFileSegment(bytesFromFile, START_TABLE_BYTE, sizeTable);
        ArrayList<Integer> codeTable = convertByteArrayToArrayList(table);

        //Get length start file
        byte[] startFileSize = readFileSegment(bytesFromFile, TABLE_SIZE, FILE_SIZE);
        long unarchiveFileLength = readLongValueFromBytes(startFileSize);

        //Create array with unarchived text
        byte[] mainText = readFileSegment(bytesFromFile, START_TABLE_BYTE + sizeTable,
                (int) archiveFile.length() - (START_TABLE_BYTE + sizeTable));
        int countBits = findCountBits(codeTable.size());
        int[] mainTextToUnarchive = convertByteArrayToIntArray(mainText, unarchiveFileLength, countBits);
        decodedText = unarchive(mainTextToUnarchive, codeTable);

    }

    /**
     * Use buffered file stream to read bytes from file
     * @param fileName '
     * @return '
     * @throws IOException can't read file
     */
    private byte[] readArchive(String fileName) throws IOException {
        byte[] buffer;
        FileInputStream fin = new FileInputStream(fileName);
        BufferedInputStream bufIn = new BufferedInputStream(fin, CLUSTER);
        buffer = new byte[bufIn.available()];
        bufIn.read(buffer);

        return buffer;
    }

    /**
     * Get part of byte array
     * @param bytesFromFile'
     * @param index start position
     * @param count count bytes to read
     * @return byte array - part of start byte array
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
     * @param bytes'
     * @return long value from byte array
     */
    private long readLongValueFromBytes(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getLong();
    }

    /**
     * @param table with unique symbols
     * @return '
     */
    private ArrayList<Integer> convertByteArrayToArrayList(byte[] table) {
        ArrayList<Integer> decodeTable = new ArrayList<>();

        for (byte b : table) {
            decodeTable.add((int) b);
        }
        return decodeTable;
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
     * Reduce all negative byte values to 8 digits. Next, we form new numerical values.
     * These values in binary form are equal in length to the size of the code bit sequence
     * @param startArray'
     * @param fileLength'
     * @param countBits'
     * @return int array with text
     */
    private int[] convertByteArrayToIntArray(byte[] startArray, long fileLength, int countBits) {
        int[] convertedArray = new int[(int) fileLength];
        StringBuilder binaryString;
        String ost = "";
        int count = 0;

        for (int i = 0; i < startArray.length; i++) {

            binaryString = new StringBuilder(Integer.toBinaryString(startArray[i]));
            binaryString = checkBinaryString(startArray[i], startArray.length, binaryString, i, countBits);

            if (countBits == NUMBER_BITS) {
                convertedArray[count++] = convertBinToInt(binaryString.toString());
            } else {
                binaryString.insert(0, ost);
                convertedArray[count++] = convertBinToInt(binaryString.substring(0, countBits));

                ost = binaryString.substring(countBits);
                while (ost.length() > countBits) {
                    convertedArray[count++] = convertBinToInt(ost.substring(0, countBits));
                    ost = ost.substring(countBits);
                }
            }
        }

        if (ost.length() > 0 && ost.length() == countBits) {
            convertedArray[count] = convertBinToInt(ost);
        }

        return convertedArray;
    }

    /**
     * Reduce all negative byte values to 8 digits. All values of the array except the last one,
     * if necessary, are supplemented to 8 characters in binary representation (insert zeros at the beginning).
     * The last element of the array is padded with zeros to the length of the bit sequence
     * @param item'
     * @param arrayLength'
     * @param startString'
     * @param index'
     * @param countBits'
     * @return converted string
     */
    private StringBuilder checkBinaryString(byte item, int arrayLength, StringBuilder startString, int index,
                                            int countBits){
        StringBuilder binaryString = new StringBuilder(startString);
        if (item < 0) {
            binaryString = new StringBuilder(binaryString.substring(binaryString.length() - NUMBER_BITS));

        } else {
            if (index < arrayLength - 1) {
                while (binaryString.length() < NUMBER_BITS) {
                    binaryString.insert(0, "0");
                }
            } else {
                while (binaryString.length() < countBits) {
                    binaryString.insert(0, "0");
                }
            }
        }

        return binaryString;
    }

    /**
     * @param binaryString'
     * @return '
     */
    private int convertBinToInt(String binaryString){
        return Integer.parseInt(binaryString,2);
    }

    /**
     * Decode compress text array
     * @param codeText '
     * @param decodeTable '
     * @return decoded byte array
     */
    private int[] unarchive(int[] codeText, ArrayList<Integer> decodeTable) {

        int[] unarchive = new int[codeText.length];
        String negativeValues;

        for (int i = 0; i < codeText.length; i++) {
            negativeValues = Integer.toBinaryString(decodeTable.get(codeText[i]));
            if (negativeValues.length() > NUMBER_BITS) {
                unarchive[i] = convertBinToInt(negativeValues.substring(negativeValues.length() - NUMBER_BITS));
            } else {
                unarchive[i] = convertBinToInt(negativeValues);
            }
        }
        return unarchive;
    }

}
