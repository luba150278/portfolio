package com.shpp.p2p.cs.parsievich.assignment11;

/**
 * This class contains some useful functions for use in other classes of this program.
 */
public class AdditionalMethods {

    /**
     * @param str some string
     * @return numerical value or error
     */
    public static double convertToDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            System.out.println("Sorry! Value of " + "'" + str + "'" + " not found!");
            System.exit(0);
            return 0;
        }
    }

    /**
     * @param str some string
     * @return are all symbols numeric in this string - true/false
     */
    public static boolean isNumericString(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * @param ch some char
     * @return is this character a number - true/false
     */
    public static boolean isNumericChar(char ch) {
        return ch >= 48 && ch <= 57;
    }

    /**
     * @param ch some char
     * @return is this character a letter - true/false
     */
    public static boolean isLetter(char ch) {
        return ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122;
    }
}
