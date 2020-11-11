package com.shpp.p2p.cs.lmyetolkina.assignment15;

/**
 * Depending on the content of the input line, we form the names of the input and output files.
 * We also define which operation will be performed (archive or unarchive).
 */
public class ReadInputString implements Constants {
    private boolean isFlag;
    private String extension;
    private final String inputFileName;
    private final String outputFileName;
    private final int operation;

    /**
     * Type of operation (0 - archive, 1 - unarchive)
     *
     * @param args input string
     */
    public ReadInputString(String[] args) {
        operation = definitionOperation(args);
        inputFileName = definitionInputFileName(args);
        outputFileName = definitionOutputFileName(args);
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
            isFlag = isFlag(args[0]);
            if (isFlag) {
                if (args.length > 1) extension = findExtension(args[1]);
                if (args[0].equals("-a")) return 0;
            } else {
                extension = findExtension(args[0]);
                if (extension == null || !extension.equals(END_ARCHIVE)) return 0;
            }
            return 1;
        }
        return 0;
    }

    /**
     * If arguments not exists use default file name ("text.txt"), otherwise check files extension and form name file.
     *
     * @param args - input string
     * @return name input file
     */
    private String definitionInputFileName(String[] args) {
        if (args.length > 0 && args.length <= 2) {
            return ifTwoOrLessArguments(args);
        }
        if (args.length > 2) {
            return ifThreeOrMoreArguments(args);
        }
        return DEFAULT_FILE_NAME;
    }

    /**
     * If first argument is not flag form the input file name based on first argument. Otherwise use the second argument
     * to form input file name
     * @param args'
     * @return the name input file
     */
    private String ifTwoOrLessArguments(String[] args) {
        if (isFlag) {
            if (args.length == 1) {
                return args[0].equals("-a") ? DEFAULT_FILE_NAME : DEFAULT_FILE_NAME + "." + END_ARCHIVE;
            }
            return formFileName(args[1]);
        }
        return formFileName(args[0]);
    }

    /**
     * Check flag and extension of input file. Correct the input file name for invalid extension
     * @param args'
     * @return the name input file
     */
    private String ifThreeOrMoreArguments(String[] args) {
        if (!args[1].contains(".") || args[1].indexOf(".") == args.length - 1) {
            return (operation == 0) ? args[1] + "." + END_TXT : args[1] + "." + END_TXT + "." + END_ARCHIVE;
        }
        if (args[0].equals("-u")) {
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

    /**
     * If arguments not exists use default file name ("text.txt.par"), otherwise check files extension and form name file.
     *
     * @param args input string
     * @return name output file
     */
    private String definitionOutputFileName(String[] args) {
        if (args.length > 0 && args.length <= 2) {
            return (operation == 0) ? inputFileName + "." + END_ARCHIVE :
                    inputFileName.substring(0, inputFileName.lastIndexOf("."));
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
    private String findExtension(String fileName) {
        int existBod = fileName.indexOf(".");
        return (existBod == -1) ? null : fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    /**
     * Check the flag parameter
     *
     * @param flag - flag should be equal "-a" or "-u"
     * @return true - correct flag, false - un-correct flag
     */
    private boolean isFlag(String flag) {
        return flag.equals("-a") || flag.equals("-u");
    }

    /**
     * Check extension and form file name
     *
     * @param arg - file name
     * @return extension file
     */
    private String formFileName(String arg) {
        if (extension != null) {
            return arg;
        }

        return (operation == 0) ? arg + "." + END_TXT : arg + "." + END_TXT + "." + END_ARCHIVE;
    }

    /**
     * Getter for name output file
     *
     * @return name output file
     */
    public String getOutputFileName() {
        return outputFileName;
    }

    /**
     * Getter for name input file
     *
     * @return name input file
     */
    public String getInputFileName() {
        return inputFileName;
    }

    /**
     * Getter for operation (0 - archive/ 1- unarchive)
     *
     * @return int value
     */
    public int getOperation() {
        return operation;
    }
}
