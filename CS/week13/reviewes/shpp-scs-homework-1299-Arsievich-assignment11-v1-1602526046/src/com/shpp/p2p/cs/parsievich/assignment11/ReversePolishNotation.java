package com.shpp.p2p.cs.parsievich.assignment11;

import java.util.ArrayList;
import java.util.Stack;

import static com.shpp.p2p.cs.parsievich.assignment11.AdditionalMethods.*;

/**
 * This class stores methods related to Reverse Polish Notation
 */
public class ReversePolishNotation {
    /**
     * @param splitFormula split and rewriting formula;
     * @return Formula rewritten in RPN(Reverse Polish notation) style
     */
    public static ArrayList<String> rewriteFormulaToRPNStyle(ArrayList<String> splitFormula) {
        int priority;
        ArrayList<String> outputString = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for (String element : splitFormula) {
            priority = determinationPriorityOf(element);
            if (priority == 0) {
                outputString.add(element);
            }
            if (priority == 1) {
                stack.push(element);
            }
            if (priority > 1) {
                while (!stack.empty()) {
                    if (determinationPriorityOf(stack.peek()) >= priority) {
                        outputString.add(stack.pop());
                    } else break;
                }
                stack.push(element);
            }

            if (priority == -1) {
                while (determinationPriorityOf(stack.peek()) != 1) {
                    outputString.add(stack.pop());
                }
                stack.pop();
            }
        }
        while (!stack.empty()) {
            outputString.add(stack.pop());
        }
        return outputString;
    }

    /**
     * @param formulaRPN Formula rewritten in RPN style
     * @return the result that came out in the calculations
     */
    public static double answer(ArrayList<String> formulaRPN) {
        Stack<Double> stack = new Stack<>();
        double firstNumber, secondNumber;
        String element;
        for (String s : formulaRPN) {
            element = s;
            if (determinationPriorityOf(element) == 0) {
                stack.push(convertToDouble(element));
            }
            if (determinationPriorityOf(element) > 1 && determinationPriorityOf(element) <= 4) {
                secondNumber = stack.pop();
                firstNumber = stack.pop();
                stack.push(doBinaryOperation(firstNumber, secondNumber, element));
            }
            if (determinationPriorityOf(element) == 5) {
                firstNumber = stack.pop();
                stack.push(doUnaryOperation(firstNumber, element));
            }
        }
        return stack.peek();
    }

    /**
     * @param element some element from the formula
     * @return the priority of this element, or "-2" if the character is unknown
     */
    public static int determinationPriorityOf(String element) {
        if (element.equals("sin") || element.equals("cos") || element.equals("tan") || element.equals("atan") ||
                element.equals("log10") || element.equals("log2") || element.equals("sqrt")) {
            return 5;
        } else if (element.equals("^")) {
            return 4;
        } else if (element.equals("*") || element.equals("/")) {
            return 3;
        } else if (element.equals("+") || element.equals("-")) {
            return 2;
        } else if (element.equals("(")) {
            return 1;
        } else if (element.equals(")")) {
            return -1;
        } else if (isLetter(element.charAt(0)) && element.length() == 1) {
            return 0;
        } else if (isNumericString(element)) {
            return 0;
        }
        return -2;
    }

    /**
     * @param firstNumber  some double number
     * @param secondNumber some double number
     * @param operation    (^, *, /, +, -)
     * @return result of this operation
     */
    private static double doBinaryOperation(double firstNumber, double secondNumber, String operation) {
        return switch (operation) {
            case "^" -> Math.pow(firstNumber, secondNumber);
            case "*" -> (firstNumber * secondNumber);
            case "/" -> (firstNumber / secondNumber);
            case "+" -> (firstNumber + secondNumber);
            case "-" -> (firstNumber - secondNumber);
            default -> 404;
        };
    }

    /**
     * @param number    some double number
     * @param operation (sin, cos, tan, atan, log10, log2, sqrt)
     * @return result of this operation
     */
    private static double doUnaryOperation(double number, String operation) {
        return switch (operation) {
            case "sin" -> Math.sin(number);
            case "cos" -> Math.cos(number);
            case "tan" -> Math.tan(number);
            case "atan" -> Math.atan(number);
            case "log10" -> Math.log(number);
            case "log2" -> Math.log10(number);
            case "sqrt" -> Math.sqrt(number);
            default -> 404;
        };
    }
}
