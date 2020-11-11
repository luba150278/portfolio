package com.shpp.p2p.cs.lmyetolkina.assignment14;

import java.io.*;

/**
 * The task is an archive/unarchive files using bit coding.
 */
public class Assignment14Part1 implements Constants {
    private static final long startTimer = System.currentTimeMillis(); //Use for find program execution time

    /**
     * Check the input string. Check what operation needs to be performed (archiving or unarchiving) and
     * define the input and output files names.
     * Perform the operation, generate an output file and a response to the console
     * If operation == 0 is archive; 1 - unarchive
     * @param args flag and names files to archive/unarchive.
     */
    public static void main(String[] args) throws IOException {

        File file;
        try {
            DefineOperationAndNamesFiles aid = new DefineOperationAndNamesFiles(args);
            int operation = aid.getOperation();
            String inputFileName = aid.getInputFileName();
            String outputFileName = aid.getOutputFileName();

            if (operation == 0) {
                file = new File(inputFileName);
                Archive af = new Archive(inputFileName, file.length());
                new WriteFileAndReply(inputFileName, outputFileName, 0, startTimer, null, af.getArchive());
            }
            if (operation == 1) {
                Unarchive uf = new Unarchive(inputFileName);
                new WriteFileAndReply(inputFileName, outputFileName, 1, startTimer, uf.getDecodedText(), null);
            }

        } catch (FileNotFoundException e) {
            System.out.println(NOT_FOUND);
        }
    }
}
