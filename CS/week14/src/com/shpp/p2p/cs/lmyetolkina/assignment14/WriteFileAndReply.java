package com.shpp.p2p.cs.lmyetolkina.assignment14;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Write information to file and form reply to console
 */
public class WriteFileAndReply implements Constants {

    public WriteFileAndReply(String inputFileName, String outputFileName, int flag, long startTimer, int[] intArray,
                             byte[] byteArray) throws IOException {
        File file = new File(inputFileName);
        long fileLength = file.length();

        if (flag == 0) {
            writeByteArrayToFile(outputFileName, byteArray);
        } else {
            writeIntArrayToFile(outputFileName, intArray);
        }
        createReply(outputFileName, flag, fileLength, startTimer);
    }

    private void writeByteArrayToFile(String fileName, byte[] bytes) throws IOException {

        FileOutputStream stream = new FileOutputStream(fileName);
        BufferedOutputStream buffer = new BufferedOutputStream(stream, CLUSTER);
        buffer.write(bytes);
        buffer.close();
        stream.close();
    }

    private void writeIntArrayToFile(String fileName, int[] bytes) throws IOException {
        FileOutputStream stream = new FileOutputStream(fileName);
        BufferedOutputStream buffer = new BufferedOutputStream(stream, CLUSTER);

        for (int aByte : bytes) {
            buffer.write(aByte);
        }

        buffer.close();
        stream.close();
    }

    private void createReply(String fileName, int flag, long fileLength, double startTimer) {
        File outPutFile = new File(fileName);
        StringBuilder strOutPut = new StringBuilder();
        double time = System.currentTimeMillis() - startTimer;

        if (flag == 0) {
            strOutPut.append(EFFICIENCY);
            strOutPut.append(outPutFile.length() >= fileLength ? NEGATIVE : POSITIVE);
        }

        strOutPut.append(TIME_IS).append(time).append(TIME_UNITS);
        strOutPut.append(INPUT_INFO).append(fileLength).append(FILE_UNITS);
        strOutPut.append(OUTPUT_INFO).append(outPutFile.length()).append(FILE_UNITS);

        System.out.println(strOutPut);
    }
}
