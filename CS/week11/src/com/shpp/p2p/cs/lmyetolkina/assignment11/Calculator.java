package com.shpp.p2p.cs.lmyetolkina.assignment11;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Calculate the numeric value of a function
 */
public class Calculator extends Common implements Constants {
    private static final StringBuilder commentString = new StringBuilder();

    public static void calc() {

        /*Replace all variables in a formula with numeric values*/
        String[] rpnString = addVariableValue();

        try {
            Assignment11Part1.finishResult = 0;
            /*Use stack to save the intermediate values*/
            Stack<Double> numbersStack = new Stack<>();
            double firstNumber, secondNumber;

            for (int i = 0; i < rpnString.length; i++) {

                if (isDigit(rpnString[i]))
                    numbersStack.push(Double.parseDouble(rpnString[i]));  /*If the part of formula is digit put it
                                                                            to the stack*/
                else {
                    if (FUNCTIONS.contains(rpnString[i])) {
                        /*If the part of formula is function find it value*/
                        if (!rpnString[i].equals("!")) {
                            numbersStack.push(findFunctions(rpnString[i], numbersStack.pop()));
                            //i++;
                        } else {
                            /*For the factorial, we swap the parameters*/
                            numbersStack.pop();
                            numbersStack.push(findFunctions(rpnString[i], Double.parseDouble(rpnString[i - 1])));
                        }

                    } else {
                        /*If the part of formula is the math symbol find result*/
                        secondNumber = numbersStack.pop();
                        firstNumber = numbersStack.pop();
                        numbersStack.push(findOperation(rpnString[i], firstNumber, secondNumber));
                    }
                }
            }
            Assignment11Part1.finishResult = numbersStack.pop();
        } catch (NullPointerException e) {
            commentString.append("Error! Please, check your formula and/or the arguments values.\n");
        } catch (EmptyStackException e) {
            commentString.append("Error! Please, check your formula.\n");
        }
        Assignment11Part1.commentString.append(commentString);
    }

    /**
     * Find the result of calculation the math functions
     *
     * @param function - the function
     * @param number   - the start number
     * @return the result of the calculation
     */
    private static double findFunctions(String function, double number) {

        switch (function) {
            case "sin":
                return Math.sin(number);
            case "cos":
                return Math.cos(number);
            case "tan":
                return Math.tan(number);
            case "asin":
                return Math.asin(number);
            case "acos":
                return Math.acos(number);
            case "atan":
                return Math.atan(number);
            case "sqrt":
                return Math.sqrt(number);
            case "exp":
                return Math.exp(number);
            case "ln":
            case "log2":
                return Math.log(number);
            case "log":
            case "log10":
                return Math.log10(number);
            case "!":
                int numberInt = (int) number;
                return factorial(numberInt);
            default:
                return 0;
        }
    }

    /**
     * Find the result of calculation the math operations
     *
     * @param operation    - the math operation
     * @param firstNumber  - the first number value
     * @param secondNumber - the second number value
     * @return - the result of the calculation
     */
    private static double findOperation(String operation, double firstNumber, double secondNumber) {
        switch (operation) {
            case "+":
                return (firstNumber + secondNumber);
            case "-":
                return (firstNumber - secondNumber);
            case "*":
                return (firstNumber * secondNumber);
            case "/":
                return (firstNumber / secondNumber);
            case "%":
                return (firstNumber % secondNumber);
            case "^":
                return (Math.pow(firstNumber, secondNumber));
            default:
                return 0;
        }
    }

    /**
     * Calculate the factorial
     *
     * @param number - the start number value
     * @return - the result of calculation
     */
    private static int factorial(int number) {
        int result = 1;
        if (number == 1 || number == 0) {
            return result;
        }
        result = number * factorial(number - 1);
        return result;
    }

    /**
     * Substituting numeric values into function variables
     *
     * @return The finish array for calculation
     */
    private static String[] addVariableValue() {
        String[] result = new String[parsingFormula.size()];
        int i = 0;
        for (String x : parsingFormula) {
            if (variables.containsKey(x)) {
                result[i] = String.valueOf(variables.get(x));
            } else {
                result[i] = x;
            }
            i++;
        }
        return result;
    }
}
