package com.shpp.p2p.cs.parsievich.assignment11;

import java.util.ArrayList;

import static com.shpp.p2p.cs.parsievich.assignment11.AdditionalMethods.*;
import static com.shpp.p2p.cs.parsievich.assignment11.ReversePolishNotation.*;

/**
 * This class receives the formula,
 * checks it for some errors and prepares it for further work with the formula
 * (separated into elements (variables, operators, numbers) and save in ArrayList).
 */
public class FormulaValidationAndSplitting {
    public static ArrayList<String> validationOfFormulaAndSplitToElements(String formula) {
        String replaceMinus = replaceUnaryMinus(formula);
        ArrayList<String> splitFormula = splitFormulaIntoElements(replaceMinus);
        errorCheck(splitFormula);
        return splitFormula;
    }

    /**
     * method replaces minuses at the beginning of a line or after an open parenthesis with "(0-1)*"
     *
     * @param formula entered formula;
     * @return rewriting formula
     */
    private static String replaceUnaryMinus(String formula) {
        formula = formula.replaceAll("\\s", "") + " ";
        String rewrittenFormula = "";
        if (formula.length() > 1) {
            if (formula.charAt(0) == ('-')) {
                rewrittenFormula += "(0-1)*";
            } else {
                rewrittenFormula += formula.charAt(0);
            }

            for (int i = 1; i < formula.length(); i++) {
                if (formula.charAt(i) == '-' && formula.charAt(i - 1) == '(') {
                    rewrittenFormula += "(0-1)*";
                } else {
                    rewrittenFormula += formula.charAt(i);
                }
            }
        } else {
            System.out.println("Formula too short!");
            System.exit(0);
        }
        return rewrittenFormula;
    }


    /**
     * @param formula entered formula;
     * @return Formula separated into elements (variables, operators, numbers) and save in ArrayList
     */
    private static ArrayList<String> splitFormulaIntoElements(String formula) {
        ArrayList<String> splitFormula = new ArrayList<>();
        char thisElement;
        char nextElement;
        String str = "";
        for (int i = 0; i < formula.length() - 1; i++) {
            thisElement = formula.charAt(i);
            nextElement = formula.charAt(i + 1);

            if (thisElement == '*' || thisElement == '/' || thisElement == '+' || thisElement == '-' ||
                    thisElement == '^' || thisElement == '(' || thisElement == ')') {
                splitFormula.add(String.valueOf(thisElement));
            } else if (isNumericChar(thisElement) || isLetter(thisElement) || thisElement == 46) {
                str += thisElement;
            } else {
                System.out.println("You entered an invalid character: " + thisElement);
                System.exit(0);
            }
            if (!isNumericChar(nextElement) && !isLetter(nextElement) && nextElement != 46 && !str.equals("")) {
                splitFormula.add(str);
                str = "";
            }
        }
        return splitFormula;
    }

    /**
     * @param formula separated into elements
     *   checks for errors:
     * - are there any unknown elements
     * - are the logical signs in the wrong order
     */
    private static void errorCheck(ArrayList<String> formula){

        for (String s : formula) {
            if (determinationPriorityOf(s) == -2) {
                System.out.println("You entered an invalid character: " + s);
                System.exit(0);
            }
        }

        for (int i = 1; i < formula.size(); i++) {
            if (determinationPriorityOf(formula.get(i)) > 1 && determinationPriorityOf(formula.get(i)) < 5
                    && determinationPriorityOf(formula.get(i - 1)) > 1) {
                System.out.println("Error! Logical symbols cannot stand side by side!");
                System.exit(0);
            }
        }
    }
}
