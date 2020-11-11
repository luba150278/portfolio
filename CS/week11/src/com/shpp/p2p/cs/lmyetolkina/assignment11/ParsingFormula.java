package com.shpp.p2p.cs.lmyetolkina.assignment11;

import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Get parts of the formula using regular expressions.
 * Add a zero before the unary minus to make the formula work correctly.
 */
public class ParsingFormula extends Common implements Constants {

    public static void parser(String formula) {
        ArrayList<String> result = new ArrayList<>();
        formula = correctedFormula(formula);
        Pattern r = Pattern.compile(PARSE_STRING);
        Matcher m = r.matcher(formula);

        while (m.find()) {
            result.add(m.group(0));
        }
        result=checkUnaryMinus(result);
        getParsingFormula(result);
    }

    private static String correctedFormula(String formula) {
        String str = formula;
        str = str.replaceAll("(log10)", "log");
        str = str.replaceAll("(log2)", "ln");
        str = str.replaceAll("\\(-", "(0-");
        str = str.replaceAll("(/-)", "*(-1)/");
        str = str.replaceAll("(\\*-)", "*(-1)*");
        str = str.replaceAll("(\\+-)|(-\\+)", "-");
        str = str.replaceAll("(--)", "+");

        if (str.startsWith("-")) {
            str = "(-1)*" + str.substring(1);
        }
        return str;
    }

    private static ArrayList<String> checkUnaryMinus(ArrayList<String> start) {
        String prev;
        prev = start.get(0);

        /*Additional check for unary minus*/
        for (int i = 1; i < start.size(); i++) {
            if (!isFunction(prev)) {
                if (isDigit(start.get(i)) && isDigit(prev) || (isDigit(start.get(i)) && prev.equals(")"))
                        || (isDigit(start.get(i)) && Character.isLetter(prev.charAt(prev.length() - 1)))) {
                    start.add(i, "+");
                }
            }
            prev = start.get(i);
        }

        for (int i = 1; i < start.size() - 1; i++) {
            if (isDigit(start.get(i)) && start.get(i + 1).equals("^")) {
                if (Double.parseDouble(start.get(i)) < 0 && start.get(i - 1).equals("+")) {
                    start.set(i, start.get(i).substring(1));
                    start.set(i - 1, "-");
                    start.add(i, "0");
                    start.add("-");
                }
            }
            if (start.get(i).equals("^") && start.get(i + 1).equals("-")) {
                start.add(i + 1, "(");
                start.remove(i + 2);
                start.add(i + 3, "*");
                start.add(i + 4, "-1");
                start.add(i + 5, ")");
            }
        }
        return start;
    }

    /**
     * Get parsing formula by used "Reverse Polish Notation" algorithm
     *
     * @param partOfFormula - the array with parts of the formula
     */
    private static void getParsingFormula(ArrayList<String> partOfFormula) {
        Stack<String> operationsStack = new Stack<>();
        String lastOperation;

        for (String part : partOfFormula) {
            /*If the part of formula is digit put it to the result array*/
            if (isDigit(part)) {
                parsingFormula.add(String.valueOf(Double.parseDouble(part)));
            }
            /*If the part of the formula is function push it to stack*/
            else if (isFunction(part)) {
                operationsStack.push(part);
            }
            /*If the part of the formula is the math operations make next steps*/
            else if (isOperation(part)) {
                /*If the part of the formula is a first operation put it to stack*/
                if (operationsStack.size() == 0) {
                    operationsStack.push(part);
                    continue;
                } else {
                    /*Otherwise save the operation as value of "last operation" and make next step*/
                    lastOperation = operationsStack.peek();
                    //System.out.println(lastOperation);
                }
                /*Compare the priorities of the current and last operations.
                  If the priority of the current operation is higher
                  than the priority of the last one stored on the stack, then we put it on the stack.
                  Otherwise, we push the last operation and push the current one onto the stack.
                 */
                if (getOperationPriority(lastOperation) >= getOperationPriority(part)) {
                    parsingFormula.add(operationsStack.pop());
                }
                operationsStack.push(part);
            }
            /*If the part of the formula is a '(' put it to stack*/
            else if (part.equals("(")) {
                operationsStack.push(part);
            }
            /*If the current part of the formula is ')', then we pop all operations from the stack
            into the resulting string until we meet the sign '(', do not put it in the string.*/
            else if (part.equals(")")) {
                while (!operationsStack.peek().equals("(")) {
                    parsingFormula.add(operationsStack.pop());
                }
                operationsStack.pop();
                if (operationsStack.size() != 0) {
                    if (isFunction(operationsStack.peek())) {
                        parsingFormula.add(operationsStack.pop());
                    }
                }

            } else {
                parsingFormula.add(part);
            }
        }

        /*We put all the remaining data from the stack into an array*/
        while (!(operationsStack.size() == 0)) {
            parsingFormula.add(operationsStack.pop());
        }

        System.out.println(parsingFormula);
    }

    /**
     * Get priority to all math operations
     *
     * @param operation - the math operation
     * @return the integer value of priority
     */
    private static int getOperationPriority(String operation) {
        switch (operation) {
            case ")":
            case "(":
                return 0;
            case "+":
            case "-":
                return 2;
            case "*":
            case "/":
                return 3;
            case "%":
            case "^":
                return 4;

            default:
                return 1;
        }
    }

}
