package com.shpp.p2p.cs.lmyetolkina.assignment11;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Print the result and comments. A repeat of the calculation if needed.
 */
public class PrintAndRepeat implements Constants {
    public static void main(String formula, StringBuilder commentString, double finishResult) {
        printResult(formula, finishResult, commentString); //Print result to the user
        //Check the result and, if variables are used, prompt the user to repeat the calculation
        if (Assignment11Part1.commentString.indexOf("Error") != -1) return;
        if (Assignment11Part1.commentString.indexOf("Please") != -1) return;
        //Use the parsing formula to calculate new variables values.
        if (variables.size() > 0) useNewValueOfArguments(formula);
    }

    /**
     * Print the result of the calculation for user
     *
     * @param formula - the start formula
     */
    private static void printResult(String formula, double finishResult, StringBuilder commentString) {
        DecimalFormat df = new DecimalFormat("###.######");
        String result = df.format(finishResult);

        String s = "--------------------\n";
        StringBuilder finishText = new StringBuilder("FORMULA: " + formula + "\n");
        finishText.append(s);
        finishText.append("ARGUMENTS:\n");
        if (variables.size() == 0) {
            finishText.append("Not used\n");
        }
        for (String key : variables.keySet()) {
            finishText.append(key).append(": ").append(variables.get(key)).append("\n");
        }
        finishText.append(s);
        finishText.append("RESULT*: ").append(result).append("\n");
        finishText.append("*If the formula contains variables for which no numeric values are specified,\n" +
                "then the value 0 is substituted when calculating the result.\n");
        finishText.append(s);
        finishText.append((commentString.length() != 0) ? "COMMENTS:\n" + commentString
                + "Result may consist a wrong value!\n" + s : "");
        System.out.println(finishText);
    }

    /**
     * After parsing the formula, we can use it many times for other arguments that are prompted for the user to enter.
     *
     * @param formula - the start formula
     */
    private static void useNewValueOfArguments(String formula) {
        Assignment11Part1.commentString = new StringBuilder();
        try {
            Scanner in = new Scanner(System.in);
            while (true) {

                System.out.print("Do you want to calculate the formula for another arguments? Y/N:");
                if (in.next().toLowerCase().equals("n")) return;

                for (String key : variables.keySet()) {
                    System.out.print("Input a value for variable " + key + ":");
                    variables.put(key, Double.parseDouble(in.next().replaceAll("[,]", ".")));
                }
                Calculator.calc();
                printResult(formula, Assignment11Part1.finishResult, Assignment11Part1.commentString);
            }
        } catch (NumberFormatException e) {
            System.out.println("You input non-numeric argument value.Please, try again.");
        }
    }
}
