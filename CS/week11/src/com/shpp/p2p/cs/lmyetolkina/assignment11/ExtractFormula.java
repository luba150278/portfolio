package com.shpp.p2p.cs.lmyetolkina.assignment11;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Extract variables from formula to Set-array
 */
public class ExtractFormula implements Constants{

    public static void extract(String formula){
        String pattern = "[a-z]+";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(formula);
        /*For the found alphabetic characters, we determine the variable name,
        checking the characters before and after the character.*/
        while (m.find()) {
            formulaVariables.add(defineNameVariable(formula, m.start()));
        }

        formulaVariables.removeAll(Arrays.asList(MATH_FUNCTIONS));  //Remove all functions from array
    }

    /**
     * Define the name variables in the formula.
     * Checking characters before letter should be to equal _ or number and after should be equal letter, number or _
     *
     * @param formula - the formula
     * @param index   index the letter symbol
     * @return - the name of variable in the formula
     */
    private static String defineNameVariable(String formula, int index) {
        StringBuilder result = new StringBuilder(formula.substring(index, index + 1));
        String prev;
        String next;

        /*Check characters before letter*/
        for (int i = index - 1; i >= 0; i--) {
            prev = formula.substring(i, i + 1);

            if (prev.equals("_")) {
                result.insert(0, "_");
            } else if (Character.isDigit(prev.charAt(0))) {
                result.insert(0, prev.charAt(0));
            } else {
                break;
            }
        }

        /*Check characters after letter*/
        for (int i = index + 1; i < formula.length(); i++) {
            next = formula.substring(i, i + 1);

            if (Character.isDigit(next.charAt(0)) || next.charAt(0) == '_' || Character.isLetter(next.charAt(0))) {
                result.append(next);
            } else {
                break;
            }
        }
        return result.toString();
    }
}
