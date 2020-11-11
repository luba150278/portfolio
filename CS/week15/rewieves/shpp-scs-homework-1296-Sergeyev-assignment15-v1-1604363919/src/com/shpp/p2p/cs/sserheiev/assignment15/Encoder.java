package com.shpp.p2p.cs.sserheiev.assignment15;

import java.io.*;
import java.util.Map;

/*
 * This class I also didn't comment, coz I think it's quite obvious.
 */
public class Encoder {
    private int bufferSize = 128;

    public void encode(String inputFile, String outputFile, Map<Integer, String> glossary, Map<Integer, Integer> frequencyMap) throws IOException {
        StringBuilder byteBuilder = new StringBuilder();
        StringBuilder temporaryBits = new StringBuilder();

        try (FileInputStream parentFis      = new FileInputStream(inputFile);
             BufferedInputStream fis        = new BufferedInputStream(parentFis, bufferSize);
             FileOutputStream fatherFos     = new FileOutputStream(outputFile);
             BufferedOutputStream motherFos = new BufferedOutputStream(fatherFos, bufferSize);
             DataOutputStream fos           = new DataOutputStream(motherFos)) {

            writeHeader(fos, frequencyMap);

            int readValue;
            while ((readValue = fis.read()) != -1) {
                appendTemporaryBits(byteBuilder, temporaryBits);
                appendReadValueCode(byteBuilder, readValue, glossary);
                subtractRedundantBits(byteBuilder, temporaryBits);
                writeByteBuilderIntoFile(byteBuilder, fos);
            }
            if (byteBuilder.length() != 0 || temporaryBits.length() != 0) {
                doLastIteration(byteBuilder, temporaryBits, fos);
            }
            fos.flush();

        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void doLastIteration (StringBuilder byteBuilder, StringBuilder temporaryBits, DataOutputStream fos) throws IOException {
        byteBuilder.append(temporaryBits);
        temporaryBits.setLength(0);
        if (byteBuilder.length() < 8) {
            ByteBuilderHelper.appendBitsToTheEnd(byteBuilder);
        }
        writeByteBuilderIntoFile(byteBuilder, fos);
    }

    /**
     * Convert byteBuilder into byte and write it into archive, if it's length is 8.
     * @param byteBuilder current bit sequence.
     * @param fos DataOutputStream.
     * @throws IOException
     */
    private void writeByteBuilderIntoFile (StringBuilder byteBuilder, DataOutputStream fos) throws IOException {
        if (byteBuilder.length() == Byte.SIZE) {
            int writeValue = Integer.parseInt(byteBuilder.toString(), 2);
            fos.write(writeValue);
            byteBuilder.setLength(0);
        }
    }

    /**
     * Subtract redundant bits into temporaryBits. Redundant - it more then 8.
     * @param byteBuilder current bit sequence.
     * @param temporaryBits temporary storage for redundant bits.
     */
    private void subtractRedundantBits (StringBuilder byteBuilder, StringBuilder temporaryBits) {
        if (byteBuilder.length() > Byte.SIZE) {
            temporaryBits.append(byteBuilder.substring(Byte.SIZE, byteBuilder.length()));
            byteBuilder.setLength(Byte.SIZE);
        }
    }

    private void appendReadValueCode (StringBuilder byteBuilder, int readValue, Map<Integer, String> glossary) {
        byteBuilder.append(glossary.get(readValue));
    }

    private void appendTemporaryBits(StringBuilder byteBuilder, StringBuilder temporaryBits) {
        byteBuilder.append(temporaryBits);
        temporaryBits.setLength(0);
    }

    /**
     * Header is:
     *      [4B: frequency map size] [... {1B: symbol} {4B: frequency} ...] [8B: file size], where
     *      [xB: ] - part of data, where x - how much bytes used for this data part,
     *      [... {xB:} ...] - sequence of some data {xB: }.
     * @param fos DataOutputStream that write frequency map of each symbol into archive.
     * @param frequencyMap map of frequency for each symbol.
     * @throws IOException
     */
    private void writeHeader (DataOutputStream fos, Map<Integer, Integer> frequencyMap) throws IOException {
        long fileSize = calculateFileSize(frequencyMap);
        int frequencyMapSize = frequencyMap.keySet().size() * 5;

        fos.writeInt(frequencyMapSize);
        for (Integer key : frequencyMap.keySet()) {
            int value = frequencyMap.get(key);
            fos.write(key);
            fos.writeInt(value);
        }
        fos.writeLong(fileSize);
    }

    private long calculateFileSize(Map<Integer, Integer> frequencyMap) {
        long size = 0;
        for(Integer key : frequencyMap.keySet()) {
            size += frequencyMap.get(key);
        }
        return size;
    }

}
