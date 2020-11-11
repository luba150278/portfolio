package com.shpp.p2p.cs.lmyetolkina.assignment11;

/**
 * Create the some check for formula
 */
public class CheckFormula implements Constants{
    private static final StringBuilder commentString = new StringBuilder();
    /**
     * Create the some check for formula
     * @param str - the start formula
     */
    public static void check(String str) {

        String formula = Common.deleteSpace(str);  //Delete all spaces.
        formula = correctFormula(formula); //Replace "," with "." and ":" with "/".
        checkSymbolsInFormula(formula); //Check the characters of the formula,there should be only letters, numbers, bods,
        // math symbols and the underscore character.
        checkExistMathSymbol(formula); //The formula must contain at least one math symbol
        checkPairOfParentheses(formula); //The formula must contain the same number of opening and closing parentheses
        Assignment11Part1.formula = formula;
        Assignment11Part1.commentString.append(commentString);
    }

    /**
     * Replace ":" from "/" and "," from "."
     * @param formula the formula before correction
     * @return the corrected formula string
     */
    private static String correctFormula(String formula) {
        String str = formula.replaceAll("[:]", "/");
        return str.replaceAll("[,]", ".");
    }

    /**
     * The formula should not contain characters that are not specified in the regular expression
     * @param formula - the checking formula
     */
    private static void checkSymbolsInFormula(String formula) {
        String str = formula.replaceAll("[a-z0-9:._+-/*^()%!]", "");
        if (str.length() > 0) {
            commentString.append("Error. Unacceptable symbols in the formula: ").append(str).append("\n");
        }
    }

    /**
     * The formula must contain at least one mathematical symbol
     * @param formula - the checking formula
     */
    private static void checkExistMathSymbol(String formula) {
        String str = formula.replaceAll(NOT_MATH_SYMBOLS_AND_FUNC, "");
        if (str.length() == 0) {
            commentString.append("Error. The formula hasn't any math symbols.\n");
        }
    }

    /**
     * The formula must contain the same number of opening and closing parentheses. Check it.
     * @param formula - the checking formula
     */
    private static void checkPairOfParentheses(String formula) {
        int openParentheses=0;
        int closeParentheses = 0;
        for (char element : formula.toCharArray()){
            if (element == '(') openParentheses++;
            if (element == ')') closeParentheses++;
        }
        if (openParentheses != closeParentheses) {
            commentString.append("Error. The formula must contain the same number of opening and closing parentheses! "
                    + "But formula has ").append(openParentheses).append(" the opening parentheses and ")
                    .append(closeParentheses).append(" closing parentheses\n");
        }
    }
}
