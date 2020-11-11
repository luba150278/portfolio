package com.shpp.p2p.cs.lmyetolkina.assignment15;

import java.io.*;

/**
 * The task is an archive/unarchive files using bit coding.
 */
public class Assignment15Part1 implements Constants {

    /**
     * Read the input string. Define what operation needs to be performed (archiving or unarchiving) and
     * define the input and output files names.
     * Perform the operation, generate an output file and a response to the console
     * If operation == 0 is archive; 1 - unarchive
     * @param args flag and names files to archive/unarchive.
     */
    public static void main(String[] args) throws IOException {
        long startTimer = System.currentTimeMillis(); //Use for find program execution time
        File file;
        try {
            ReadInputString ris = new ReadInputString(args);
            int operation = ris.getOperation();
            String inputFileName = ris.getInputFileName();
            String outputFileName = ris.getOutputFileName();

            file = new File(inputFileName);
            WriteFileAndReply wf = new WriteFileAndReply();

            if (operation == 0) {
                Archive af = new Archive(inputFileName, file.length());
                wf.writeToFile(outputFileName, af.getArchive());
            }

            if (operation == 1) {
                Unarchive uf = new Unarchive(inputFileName);
                wf.writeToFile(outputFileName, uf.getDecodedText());
            }

            wf.createReply(outputFileName,file.length(),startTimer);

        } catch (FileNotFoundException e) {
            System.out.println(NOT_FOUND);
        }
    }
}
