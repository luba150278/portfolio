package com.shpp.p2p.cs.sserheiev.assignment15;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;


/*
    Strongly recommend to change FILE_PATH below.
    I guess, you have another directory for your resources / assets.
 */
public class Assignment15 {
    private static String FILE_PATH = "resources/assignment15/";
    private static String FILE_NAME_IN;
    private static String FILE_NAME_OUT;

    /*
        If you look at validateArguments(String... args) in the bottom,
        you will se, that program operate with certain types of file for
        each arguments length.
        If args.length = 0, then text.txt will be encoded.
        If args.length = 1, and if it *.par, then it will be decoded into **.txt!!!
                          , and if it not *.par, then it will be encoded into *.par.
        If args.length = 2, then it will encode only *.txt or decode *.par.
        If args.length = 3, then using markers "-a" and "-u" you can encode and decode
                            whatever you want (I think so) into everything (or, almost everything).
     */
    public static void main(String[] args) {
        if (!validateArguments(args)) {
            System.out.println("Not valid arguments.");
            System.exit(-1);
        }
        switch (args.length) {
            case 0:
                encodeTestFile();
                break;
            case 1:
                if (args[0].matches("[a-zA-Z0-9]*\\.par")) {
                    decodeParIntoFile(args[0]);
                } else {
                    encodeFileIntoPar(args[0]);
                }
                break;
            case 2:
                if (args[0].matches("[a-zA-Z0-9]*\\.txt")) {
                    encodeFileIntoParWithSpecificName(args[0], args[1]);
                } else {
                    decodeParIntoFileWithSpecificName(args[0], args[1]);
                }
                break;
            case 3:
                switch (args[0]) {
                    case "-a":
                        encodeSpecificFileIntoArchive(args[1], args[2]);
                        break;
                    case "-u":
                        decodeSpecificArchiveIntoFile(args[1], args[2]);
                        break;
                }
        }
    }

    /**
     * If there are no arguments, compress test.txt into test.par
     */
    private static void encodeTestFile() {
        FILE_NAME_IN = "test.txt";
        FILE_NAME_OUT = "test.par";
        encode();
    }

    /**
     * If there is one argument (.txt expected) it will be compress into fileName.par.
     */
    private static void encodeFileIntoPar(String fileName) {
        FILE_NAME_IN = fileName;
        int dotIndex = fileName.lastIndexOf(".");
        FILE_NAME_OUT = fileName.substring(0, dotIndex) + ".par";
        encode();
    }

    /**
     * If there is one argument of .par format it will be decompress into archiveName.uar.
     */
    private static void decodeParIntoFile(String archiveName) {
        FILE_NAME_IN = archiveName;
        int dotIndex = archiveName.lastIndexOf(".");
        FILE_NAME_OUT = archiveName.substring(0, dotIndex) + ".uar";
        decode();
    }

    /**
     * If there are two arguments, and first is .txt, then it will be compress into
     * archiveName.par.
     */
    private static void encodeFileIntoParWithSpecificName(String fileName, String archiveName) {
        FILE_NAME_IN = fileName;
        if (archiveName.contains(".")) {
            archiveName = archiveName.substring(0, archiveName.lastIndexOf("."));
        }
        FILE_NAME_OUT = archiveName + ".par";
        encode();
    }

    /**
     * If there are two arguments, and first is .par, then it will be decompress into
     * fileName.txt.
     */
    private static void decodeParIntoFileWithSpecificName(String archiveName, String fileName) {
        FILE_NAME_IN = archiveName;
        int dotIndex = archiveName.lastIndexOf(".");
        FILE_NAME_OUT = fileName.substring(0, dotIndex) + ".txt";
        decode();
    }

    /**
     * If there are three arguments, and first if -a, then fileName.fileFormat will be compress into
     * archiveName.archiveFormat. Caution, this approach may cause a problem!
     */
    private static void encodeSpecificFileIntoArchive(String fileName, String archiveName) {
        FILE_NAME_IN = fileName;
        FILE_NAME_OUT = archiveName;
        encode();
    }

    /**
     * If there are three arguments, and first if -u, then archiveName.archiveFormat will be decompress into
     * fileName.fileFormat. Caution, this approach may cause a problem!
     */
    private static void decodeSpecificArchiveIntoFile(String archiveName, String fileName) {
        FILE_NAME_IN = archiveName;
        FILE_NAME_OUT = fileName;
        decode();
    }

    private static void encode() {
        Map<Integer, Integer> symbolsCounterMap = Preprocessor.countSymbolsInFile(FILE_PATH + FILE_NAME_IN);
        PriorityQueue<TreeNode> allNodes = Preprocessor.makeSortedQueue(symbolsCounterMap);

        if (allNodes.size() == 0) {
            System.out.println("File is empty.");
            System.exit(0);
        }

        TreeNode root = CodeTreeWorker.buildCodeTree(allNodes);
        Set<Integer> symbols = symbolsCounterMap.keySet();
        Map<Integer, String> glossary = EncodeMapWorker.makeEncodeGlossary(symbols, root);

        try {
            Encoder encoder = new Encoder();
            encoder.encode(FILE_PATH + FILE_NAME_IN, FILE_PATH + FILE_NAME_OUT, glossary, symbolsCounterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void decode() {
        try {
            Decoder decoder = new Decoder();
            decoder.decode(FILE_PATH + FILE_NAME_IN, FILE_PATH + FILE_NAME_OUT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static boolean validateArguments(String... args) {
        if (args.length == 0) return true;

        if (args.length == 1) {
            if (args[0].matches("[a-zA-Z0-9]*\\.par")
                    || args[0].matches("[a-zA-Z0-9]*\\.txt")) return true;
        }

        if (args.length == 2) {
            if (args[0].matches("[a-zA-Z0-9]*\\.txt") && args[1].length() > 0) return true;
            if (args[0].matches("[a-zA-Z0-9]*\\.par") && args[1].length() > 0) return true;
        }

        if (args.length == 3) {
            if (args[0].equals("-a") == args[0].equals("-u")) return false;
            if (!args[1].matches("[a-zA-Z0-9]*\\.[a-zA-Z0-9]*")
                    && !args[2].matches("[a-zA-Z0-9]*\\.[a-zA-Z0-9]*")) return false;
            return true;
        }

        return false;
    }
}
