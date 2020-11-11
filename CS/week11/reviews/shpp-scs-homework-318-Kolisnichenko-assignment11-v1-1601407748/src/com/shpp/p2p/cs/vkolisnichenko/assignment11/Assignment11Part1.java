package com.shpp.p2p.cs.vkolisnichenko.assignment11;

import java.util.HashMap;
import java.util.Stack;

/**
 * The class in which the calculator is implemented
 * with the following capabilities: + - * / sin cos tan atan sqrt ( ) log2 log10
 */
public class Assignment11Part1 {

    /**
     * The method in which the console calculator
     * is called and handles the exception
     *
     * @param args - arguments
     */
    public static void main(String[] args) {
        try {
            parseExpression(args[0], readParameters(args));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The method in which mathematical calculations
     * are performed to obtain a result
     *
     * @param numbers   - stack for storing numbers
     * @param operation - stack for storing operations
     * @return - result
     */
    public static double calculate(Stack<Double> numbers, Stack<Character> operation) {
        //Pulling two numbers from the stack
        double number1 = numbers.pop();
        double number2 = numbers.pop();

        //We take the operator from the stack
        char ch = operation.pop();

        System.out.println(number2 + " " + ch + " " + number1);

        //We get the result of a mathematical expression
        double result = switch (ch) {
            case '*' -> number2 * number1;
            case '/' -> number2 / number1;
            case '+' -> number2 + number1;
            case '-' -> number2 - number1;
            case '^' -> Math.pow(number2, number1);
            case '%' -> number2 % number1;
            default -> 0;
        };

        //Push the result onto the stack and return it
        numbers.push(result);
        return result;
    }

    /**
     * The method in which the formula is parsed,
     * after which it is checked for
     * trigonometry, brackets, priorities.
     * After that, method calculate is called
     *
     * @param str - String that comes in input
     * @param var - Variables in which the value is stored
     * @throws Exception - Method can throw Exception
     */
    public static void parseExpression(String str, HashMap<String, Double> var)
            throws Exception {
        StringBuilder s = new StringBuilder();
        //Stack for numbers
        Stack<Double> numbers = new Stack<>();
        //Operation stack
        Stack<Character> operation = new Stack<>();
        //Counter for brackets
        int count = 0;

        char[] ch = str.toCharArray();

        //If parameters are missing
        if (str.equals("")) {
            throw new Exception("You entered an incorrect expression");
        }
        for (int i = 0; i < ch.length; i++) {
            if (isDigit(ch[i])) {
                s.append(ch[i]);
            }
            //Code that is executed if trigonometric function or logarithm
            if (Trigonometry.isFunction(ch, i)) {
                double number;
                StringBuilder n = new StringBuilder();
                while (ch[i] != '(') {
                    i++;
                }
                i++;
                //If there is a match in the hashmap
                if (var.containsKey(Character.toString(ch[i]))) {
                    number = var.get(Character.toString(ch[i]));
                    i += 1;
                } else {
                    while (ch[i] != ')') {
                        n.append(ch[i]);
                        i++;
                    }
                    number = Integer.parseInt(n.toString());
                }

                numbers.push(Trigonometry.getOperation(Trigonometry.getFunc(), number));
                //Add an operation to the stack if it is not
                // ) and the variable is less than the length of the array
                if (i < ch.length - 1 && ch[i + 1] != ')') {
                    i++;
                    operation.push(ch[i]);
                }
            }
            if (ch[i] == '(' && i != 0) {
                operation.push(ch[i]);
                count++;
                continue;
            }
            //Push the number onto the stack, if there is such a map
            if (var.containsKey(Character.toString(ch[i]))) {
                numbers.push(var.get(Character.toString(ch[i])));
                if (i != str.length() - 1) operation.push(ch[i + 1]);
            } else if (!isDigit(ch[i]) || i == ch.length - 1) {
                if (s.toString().isEmpty()) continue;
                numbers.push(Double.parseDouble(s.toString()));
                s = new StringBuilder();
            }
            //Condition if operator
            if (!isDigit(ch[i]) && ch[i] == '+' || ch[i] == '-' ||
                    ch[i] == '*' || ch[i] == '/' || ch[i] == '^') {
                if (!operation.empty()) {
                    //The priority of the current operation is
                    // less than the one on the stack, and it is not (
                    if (priority(ch[i]) <= priority(operation.peek()) && operation.peek() != '(') {
                        System.out.println(calculate(numbers, operation));
                        operation.push(ch[i]);
                        continue;
                    }
                }
                operation.push(ch[i]);
            }
            //Current element (and counter is less than array size
            if (ch[i] == ')' && i < ch.length - 1) {
                while (!operation.empty()) {
                    System.out.println(calculate(numbers, operation));
                    if (count > 1 && operation.peek() == '(') operation.pop();
                }
                operation.push(ch[i + 1]);
            }
        }
        //until the stack is empty, perform calculations
        while (!operation.empty()) {
            if (operation.peek() == '(') {
                operation.pop();
            }
            System.out.println(calculate(numbers, operation));
        }
    }

    /**
     * The method in which the user is given
     * to enter parameters (for example, a = 4)
     */
    private static HashMap<String, Double> readParameters(String[] args) {
        //Hashmap which contains the name of the parameter and its value
        HashMap<String, Double> variables = new HashMap<>();
        char[] chars;
        String number = "";
        for (int i = 1; i < args.length; i++) {
            chars = args[i].toCharArray();
            for (int j = 2; j < chars.length; j++) {
                number += chars[j];
                variables.put(Character.toString(chars[0]), Double.parseDouble(number));
            }
            number = "";
        }
        return variables;
    }

    /**
     * Checks if a character is a number
     *
     * @param ch - character
     * @return - true or false
     */
    public static boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }

    /**
     * A method that determines the priority for each operation
     *
     * @param ch - Operation symbol
     * @return - priority
     */
    public static int priority(char ch) {
        return switch (ch) {
            case '(' -> 5;
            case '^' -> 4;
            case '*', '/' -> 3;
            case '+', '-' -> 2;
            case ')' -> 1;
            default -> 0;
        };
    }
}