package com.shpp.p2p.cs.sserheiev.assignment15;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Decoder {
    private int bufferSize = 128;
    long currentReadByte = 0;

    public void decode (String inputFile, String outputFile) throws IOException {
        StringBuilder byteAccumulator = new StringBuilder();
        StringBuilder temporaryBits = new StringBuilder();

        try (FileInputStream fatherFis      = new FileInputStream(inputFile);
             BufferedInputStream motherFis  = new BufferedInputStream(fatherFis, bufferSize);
             DataInputStream fis            = new DataInputStream(motherFis);
             FileOutputStream fatherFos     = new FileOutputStream(outputFile);
             BufferedOutputStream motherFos = new BufferedOutputStream(fatherFos, bufferSize);
             DataOutputStream fos           = new DataOutputStream(motherFos)) {

            Map<Integer, Integer> frequencyMap = new HashMap<>();
            long fileSize = readHeader(fis, frequencyMap);
            PriorityQueue<TreeNode> nodesQueue = Preprocessor.makeSortedQueue(frequencyMap);
            TreeNode root = CodeTreeWorker.buildCodeTree(nodesQueue);
            Map<String, Integer> decodeGlossary = EncodeMapWorker.makeDecodeGlossary(frequencyMap.keySet(), root);

            int readValue;
            while ((readValue = fis.read()) != -1) {
                appendTemporaryBits(byteAccumulator, temporaryBits);
                appendReadValue(byteAccumulator, temporaryBits, readValue);
                decodeBitSequence(byteAccumulator, temporaryBits, decodeGlossary, fos, fileSize);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Decode a certain bit sequence. Bit sequence is a read byte and, perhaps,
     * some temporary bits from previous iteration.
     * @param byteAccumulator current bit sequence.
     * @param temporaryBits in this function it's a storage for bits, until the key is formed.
     * @param decodeGlossary glossary of codes.
     * @param fos output Stream to write decoded symbols.
     * @param fileSize size of original data.
     * @throws IOException
     */
    private void decodeBitSequence(StringBuilder byteAccumulator, StringBuilder temporaryBits,
                                   Map<String, Integer> decodeGlossary, DataOutputStream fos, long fileSize) throws IOException {

        while (byteAccumulator.length() != 0) {
            temporaryBits.append(byteAccumulator.substring(0, 1));
            byteAccumulator.delete(0, 1);

            if (decodeGlossary.containsKey(temporaryBits.toString())) {
                int decodedSymbol = decodeGlossary.get(temporaryBits.toString());
                if (currentReadByte < fileSize) fos.write(decodedSymbol);
                currentReadByte++;
                temporaryBits.setLength(0);
            }
        }
    }

    /**
     * Append read value into byte accumulator. If length of binary string of read byte, it will
     * be filled to all 8 bits.
     * @param byteAccumulator byte storage.
     * @param temporaryBits temporary storage of read value.
     * @param readValue current read value from InputStream.
     */
    private void appendReadValue(StringBuilder byteAccumulator, StringBuilder temporaryBits, int readValue) {
        temporaryBits.append(Integer.toBinaryString(readValue));
        if (temporaryBits.length() < 8) {
            ByteBuilderHelper.appendBitsToTheStart(temporaryBits);
        }
        byteAccumulator.append(temporaryBits);
        temporaryBits.setLength(0);
    }

    /**
     * Append temporary bits into byte accumulator.
     * @param byteAccumulator byte storage.
     * @param temporaryBits bits storage of previous data.
     */
    private void appendTemporaryBits(StringBuilder byteAccumulator, StringBuilder temporaryBits) {
        byteAccumulator.append(temporaryBits);
        temporaryBits.setLength(0);
    }

    /**
     * Header is:
     *      [4B: frequency map size] [... {1B: symbol} {4B: frequency} ...] [8B: file size], where
     *      [xB: ] - part of data, where x - how much bytes used for this data part,
     *      [... {xB:} ...] - sequence of some data {xB: }.
     * @param fis DataInputStream which read file.
     * @param frequencyMap map of frequency for each symbol in origin text.
     * @return long origin file size.
     * @throws IOException
     */
    private long readHeader(DataInputStream fis, Map<Integer, Integer> frequencyMap) throws IOException {
        int frequencyMapSize = fis.readInt();

        int key = 0;
        int value = 0;
        for (int i = 0; i < frequencyMapSize; i++) {
            if (i % 5 == 0) {
                key = fis.read();
            } else {
                i += 3;
                value = fis.readInt();
                frequencyMap.put(key, value);
            }
        }

        return fis.readLong();
    }
}
