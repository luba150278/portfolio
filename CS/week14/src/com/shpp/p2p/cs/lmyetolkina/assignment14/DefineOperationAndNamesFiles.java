package com.shpp.p2p.cs.lmyetolkina.assignment14;

/**
 * Depending on the content of the input line, we form the names of the input and output files.
 * We also define which operation will be performed (archive or unarchive).
 */
public class DefineOperationAndNamesFiles implements Constants {
    private int checkFlag;
    private String flag;
    private String extension;
    private final String inputFileName;
    private final String outputFileName;
    private final int operation;

    /**
     * Type of operation (0 - archive, 1 - unarchive)
     * @param args input string
     */
    public DefineOperationAndNamesFiles(String[] args) {
        operation = definitionOperation(args);
        inputFileName = definitionInputFileName(operation, args);
        outputFileName = definitionOutputFileName(operation, args);
    }

    /**
     * Check exists arguments. If arguments not exists will be archive.
     * Otherwise we check the presence and validity of the flag. Define the operation by the valid flag.
     * If there is no flag or it is invalid, we define the operation by the file name extension
     *
     * @param args input string
     * @return 0 - archive or 1 - unarchive
     */
    private int definitionOperation(String[] args) {

        if (args.length != 0) {
            checkFlag = checkFlag(args[0]);
            if (checkFlag == 0) {
                flag = args[0];
                if (args.length > 1) extension = checkEnd(args[1]);
                if (flag.equals("-a")) return 0;
            } else {
                extension = checkEnd(args[0]);
                if (extension == null) return 0;
                if (!extension.equals(END_ARCHIVE)) return 0;
            }
            return 1;
        }
        return 0;
    }

    /**
     * If arguments not exists use default file name ("text.txt"), otherwise check files extension and form name file.
     *
     * @param operation (0 - archive, 1 - unarchive)
     * @param args      - input string
     * @return name input file
     */
    private String definitionInputFileName(int operation, String[] args) {
        if (args.length > 0 && args.length <= 2) {
            if (checkFlag == 0) {
                if (args.length == 1) {
                    if (flag.equals("-a")) {
                        return DEFAULT_FILE_NAME;
                    }
                    return DEFAULT_FILE_NAME + "." + END_ARCHIVE;
                } else {
                    return formFileName(extension, args[1]);
                }
            } else {
                return formFileName(extension, args[0]);
            }
        }
        if (args.length > 2) {
            if (!args[1].contains(".") || (args[1].indexOf(".") == args.length - 1)) {
                if (operation == 0) {
                    return args[1] + "." + END_TXT;
                }
                return args[1] + "." + END_TXT + "." + END_ARCHIVE;
            }
            if (flag.equals("-u")) {
                if (!extension.equals(END_ARCHIVE)) {
                    return args[1] + "." + END_ARCHIVE;
                }
            } else {
                if (!extension.equals(END_TXT)) {
                    return args[1] + "." + END_TXT;
                }
            }
            return args[1];
        }

        return DEFAULT_FILE_NAME;
    }

    /**
     * If arguments not exists use default file name ("text.txt.par"), otherwise check files extension and form name file.
     *
     * @param operation (0 - archive, 1 - unarchive)
     * @param args      input string
     * @return name output file
     */
    private String definitionOutputFileName(int operation, String[] args) {
        if (args.length > 0 && args.length <= 2) {

            if (operation == 0) {
                return inputFileName + "." + END_ARCHIVE;
            }
            return inputFileName.substring(0, inputFileName.lastIndexOf("."));

        } else if (args.length > 2) {
            return args[2];
        }
        return DEFAULT_FILE_NAME + "." + END_ARCHIVE;
    }


    /**
     * Check the format of file
     *
     * @param fileName - the file name
     * @return - format file: "txt", "png" etc
     */
    private String checkEnd(String fileName) {
        int existBod = fileName.indexOf(".");
        if (existBod == -1) return null;
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    /**
     * Check the flag parameter
     *
     * @param flag - flag should be equal "-a" or "-u"
     * @return true - correct flag, false - un-correct flag
     */
    private int checkFlag(String flag) {
        if (!flag.equals("-a") && !flag.equals("-u")) {
            return 1;
        }
        return 0;
    }

    /**
     * Check extension and form file name
     * @param extension file extension
     * @param arg - file name
     * @return extension file
     */
    private String formFileName(String extension, String arg) {
        if (extension != null) {
            return arg;
        } else {
            if (operation == 0) {
                return arg + "." + END_TXT;
            }
            return arg + "." + END_TXT + "." + END_ARCHIVE;
        }
    }

    /**
     * Getter for name output file
     * @return name output file
     */
    public String getOutputFileName() {
        return outputFileName;
    }

    /**
     * Getter for name input file
     * @return name input file
     */
    public String getInputFileName() {
        return inputFileName;
    }

    /**
     * Getter for operation (0 - archive/ 1- unarchive)
     * @return int value
     */
    public int getOperation() {
        return operation;
    }
}
