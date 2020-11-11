package com.shpp.p2p.cs.lmyetolkina.assignment15;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Write information to file and form reply to console
 */
public class WriteFileAndReply implements Constants {

    /**
     * Write byte array to file
     * @param fileName'
     * @param array'
     * @throws IOException can't write info to file
     */
    public void writeToFile(String fileName, byte[] array) throws IOException {

        FileOutputStream stream = new FileOutputStream(fileName);
        BufferedOutputStream buffer = new BufferedOutputStream(stream, CLUSTER);
        buffer.write(array);

        buffer.close();
        stream.close();
    }

    /**
     * Write int array to file
     * @param fileName'
     * @param array'
     * @throws IOException can't write info to file
     */
    public void writeToFile(String fileName, int[] array) throws IOException {
        FileOutputStream stream = new FileOutputStream(fileName);
        BufferedOutputStream buffer = new BufferedOutputStream(stream, CLUSTER);

        for (int aByte : array) {
            buffer.write(aByte);
        }

        buffer.close();
        stream.close();
    }

    /**
     * Input info to console - Efficiency of archive/unarchive, the program execution time, the sizes input/output files
     * @param fileName'
     * @param fileLength'
     * @param startTimer'
     */
    public void createReply(String fileName, long fileLength, double startTimer) {
        File outPutFile = new File(fileName);
        StringBuilder strOutPut = new StringBuilder();
        double time = System.currentTimeMillis() - startTimer;

        strOutPut.append(EFFICIENCY);
        strOutPut.append(Math.round((double) fileLength / (double) outPutFile.length() * 100)).append(" %\n");
        strOutPut.append(TIME_IS).append(time).append(TIME_UNITS);
        strOutPut.append(INPUT_INFO).append(fileLength).append(FILE_UNITS);
        strOutPut.append(OUTPUT_INFO).append(outPutFile.length()).append(FILE_UNITS);
        System.out.println(strOutPut);
    }
}
