package com.shpp.p2p.cs.lmyetolkina.assignment11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class consist methods used in several other classes
 */
public class Common implements Constants{
    /**
     * Delete spaces in the string
     *
     * @param str - The string from which all spaces are removed
     * @return The string without spaces
     */
    public static String deleteSpace(String str) {
        return str.replaceAll("\\s+", "").toLowerCase();
    }

    /**
     * Check if the part of the formula is a number.
     * First, we check if the string is a variable name that can contain numbers
     * @param partOfFormula - the checked string
     * @return true if the string is digit
     */
    public static boolean isDigit(String partOfFormula) {
        if (variables.containsKey(partOfFormula)) return false;
        Pattern r = Pattern.compile("((-)?([0-9])(\\.[0-9])?)");
        Matcher m = r.matcher(partOfFormula);
        return m.find();
    }
    /**
     * Check if the part of the formula is a math operation or function
     * @param partOfFormula - the checked string
     * @return true if string is the math operation or formula
     */
    public static boolean isOperation(String partOfFormula) {
        Pattern r = Pattern.compile(MATH_SYMBOLS);
        Matcher m = r.matcher(partOfFormula);
        return m.find();
    }

    /**
     * Check if the part of the formula is a math operation or function
     * @param partOfFormula - the checked string
     * @return true if string is the math operation or formula
     */
    public static boolean isFunction(String partOfFormula) {
        Pattern r = Pattern.compile(MATH_FUNC);
        Matcher m = r.matcher(partOfFormula);
        return m.find();
    }


}
