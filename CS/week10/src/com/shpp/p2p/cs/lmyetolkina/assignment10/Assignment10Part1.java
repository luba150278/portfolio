package com.shpp.p2p.cs.lmyetolkina.assignment10;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Get an array of arguments from the terminal.  The first argument is a mathematical formula.
 * *The rest of the arguments are formula variables.  It is necessary to find the value of the
 * *formula by doing all the necessary checks. Use the next math symbol: +-/*^
 */
public class Assignment10Part1 {

    /*The main formula*/
    private static String formula;
    /*Unique variables from the formula*/
    private static final Set<String> formulaVariables = new HashSet<>();
    /*Hashmap saves the formula variables and them values*/
    private static final HashMap<String, Double> variables = new HashMap<>();
    /*The array math symbols*/
    private static final char[] mathSymbols = new char[]{'+', '-', '*', '/', '^'};


    public static void main(String[] args) {
        String[] variables;
        /* The program performs many checks on the correctness of the input data and the result of calculations,
        but it is difficult to foresee all the options, the first "catch" catches non-standard situations,
        for example, the following numbers: "2.,5" etc. */
        try {
            /* Extract the formula and check its applicability for calculations*/
            if (!extractAndCheckFormula(args[0])) return;
            /*Extract variables from formula*/
            extractVariablesFromFormula(formula);
            /*Get variables from input data array (args)*/
            variables = arrayVariables(args);
            /* Extract the variables from input arguments and check them applicability for calculations*/
            if (!extractAndCheckVariablesFromInputArgs(variables)) return;
            /*Compare variables in a formula and in the input data. If the formula contains variables
            that are not represented in the input array, add them to the hashmap with a value of 0.0*/
            variablesWithoutValue();
            /*Get result of the calculation*/
            getResult(args);

        } catch (NumberFormatException e) {
            System.out.println("Please, check your formula and/or variables names.");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("The empty input data array! Please input formula and variables with data.");
        }
    }

    /**
     * Extract formula and make some checks.
     *
     * @return true if formula is correct, otherwise return false
     * @str - a string containing a formula
     */
    private static boolean extractAndCheckFormula(String str) {
        formula = deleteSpace(str);  //Delete all spaces.
        if (!checkLength(formula)) return false; //Check string length. Formula must contain at least three characters.
        formula = correctFormula(formula); //Replace "," with "." and ":" with "/".
        if (!checkSymbolsInFormula(formula)) return false; //Check the characters of the formula,
        // there should be only letters, numbers, bods,
        // math symbols and the underscore character.
        if (!checkExistMathSymbol(formula)) return false; //The formula must contain at least one math symbol
        return checkOrderMathSymbols(formula); //Two or more mathematical symbols must not appear
        // one after the other in a formula.
    }

    /**
     * Delete all spaces in the string
     *
     * @return - the string without  spaces
     * @str - the start string
     */
    private static String deleteSpace(String str) {
        return str.replaceAll("\\s+", "").toLowerCase();
    }

    /**
     * Formula must contain at least three characters.
     *
     * @return false if the count of characters less then 3, otherwise return true
     * @formula - the checked formula
     */
    private static boolean checkLength(String formula) {
        if (formula.length() < 3) {
            System.out.println("Error. The length of a formula is less than 3 symbol.");
            return false;
        }
        return true;
    }

    /**
     * Replace "," with "." and ":" with "/" in the formula string
     *
     * @return replaced formula string
     * @formula - the current formula
     */
    private static String correctFormula(String formula) {
        String str = formula.replaceAll("[:]", "/");

        return str.replaceAll("[,]", ".");
    }

    /**
     * Check the characters of the formula, there should be only letters, numbers, bods,
     * math symbols and the underscore character.
     *
     * @return false - if formula contains the inappropriate characters
     * @formula - the current formula
     */
    private static boolean checkSymbolsInFormula(String formula) {
        String str = formula.replaceAll("[a-z0-9:._+-/*^]", "");
        if (str.length() > 0) {
            System.out.println("Error. Unacceptable symbols in the formula: " + str);
            return false;
        }
        return true;
    }

    /**
     * The formula must contain at least one math symbol
     *
     * @return false if formula doesn't contain math symbols
     * @formula - the checked formula
     */
    private static boolean checkExistMathSymbol(String formula) {
        String str = formula.replaceAll("[^+-/*^]", "");
        if (str.length() == 0) {
            System.out.println("Error. The formula hasn't any math symbols.");
            return false;
        }
        return true;
    }

    /**
     * Two or more mathematical symbols must not appear one after the other in a formula
     *
     * @return false - if checked wrong math symbols order
     * @formula - - the current formula
     */
    private static boolean checkOrderMathSymbols(String formula) {
        boolean prev = mathSymbol(formula.charAt(0));
        boolean next;

        for (int i = 1; i < formula.length(); i++) {
            next = mathSymbol(formula.charAt(i)); //get true if the symbol equals one of the symbols: +-/*^
            if (next && prev) {
                System.out.println("Error. You can't use two mathematical symbols together");
                return false;
            }
            prev = next;
            if (prev && i == formula.length() - 1) {
                System.out.println("Error. The last formula symbol can't be to equal math symbol");
                return false;
            }
        }
        return true;
    }

    /**
     * Check the character is math symbol
     *
     * @return - true if the character equals one of the symbols: +-/*^
     * @ch - the character
     */
    private static boolean mathSymbol(char ch) {
        for (char mathSymbol : mathSymbols) {
            if (mathSymbol == ch) return true;
        }
        return false;
    }

    /**
     * Get the variables from the input data array
     * @param args - the input data array
     * @return - the new array, which start from index = 1
     */
    private static String[] arrayVariables(String[] args){
        String[] s= new String[args.length - 1];
        if (args.length - 1 >= 0) System.arraycopy(args, 1, s, 0, args.length - 1);
        return  s;
    }
    /**
     * Extract the all unique variables from formula to HashSet
     *
     * @formula - the current formula
     */
    private static void extractVariablesFromFormula(String formula) {
        String pattern = "[a-z]+";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(formula);

        /*For the found alphabetic characters, we determine the variable name,
        checking the characters before and after the character.*/
        while (m.find()) {
            formulaVariables.add(defineNameVariable(formula, m.start()));
        }
    }

    /**
     * Define the name variables in the formula.
     * Checking characters before letter should be to equal _ or number and after should be equal letter, number or _
     *
     * @return - the name of variable in the formula
     * @formula - the formula
     * @index index the letter symbol
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

    /**
     * Extract variables and their values ​​from the input array to Hashmap and do some data validation:
     * 1. Check to exist the name of the variable.
     * 2. Check the name of the variable. The name can have just letters, numbers and _
     * 3. The value of the variable should be a double number.
     *
     * @return true if a number of conditions are met.
     */
    private static boolean extractAndCheckVariablesFromInputArgs(String[] args) {

        String variable;
        String[] parts;

        for (String arg : args) {
            /*Delete all spaces*/
            variable = deleteSpace(arg);
            /*Check #1*/
            if (variable.charAt(0) == '=') {
                System.out.println("Error. You try to entry number without variable!");
                return false;
            }
            parts = variable.split("=");

            /*Check #3*/
            try {
                /*Check #2*/
                if (!checkNameVariable(parts[0])) return false;
                /*We add to the array only those variables that are in the formula*/
                if (formulaVariables.contains(parts[0])) {
                    variables.put(parts[0], Double.parseDouble(parts[1].replaceAll("[,]", ".")));
                }
            } catch (NumberFormatException e) {
                System.out.println("Error. Not double value: " + parts[1]);
                return false;
            }
        }
        return true;
    }

    /**
     * Check the name of the variable. The name can have just letters, numbers and _
     *
     * @return true -  if the name of the variable is correct.
     * @variable - the variable in the input data array
     */
    private static boolean checkNameVariable(String variable) {
        String resultString = variable.replaceAll("[a-z0-9_]", "");

        if (resultString.length() > 0) {
            System.out.println("Error. Unacceptable symbols in one of the variable: " + resultString);
            return false;
        }
        return true;
    }

    /**
     * Compare variables in a formula and in the input data. If the formula contains variables
     * that are not represented in the input array, put them to the hashmap with a value of 0.0
     */
    private static void variablesWithoutValue() {
        for (String item : formulaVariables) {
            if (!variables.containsKey(item)) variables.put(item, 0.0);
        }
    }


    /**
     * Get parts of a formula using regular expressions.
     *
     */
    private static void getResult(String[] args) {
        StringBuilder result = new StringBuilder();
        String correctFormula = formula;
        boolean firstChar = false; //Check first char in the formula.
        String[] partsFormula; //The array of terms contained in the formula
        String[] plusAndMinus; //The array of "+-" chars contained in the formula

        /*If the first character in the string is a minus, exclude it from the terms array */
        if(formula.charAt(0) == '-'){
            firstChar = true;
            correctFormula = formula.substring(1);
        }

        partsFormula = correctFormula.split("[+-]"); //extract the all terms from the formula
        plusAndMinus = plusAndMinus(correctFormula); //create the array with "+-" characters from the formula

        /*Generate of the result string*/
        result.append("Formula: ").append(args[0]).append("\n");
        result.append("Arguments:" + "\n");
        for (int i = 1; i < args.length; i++) {
            result.append(i).append(": ").append(args[i]).append("\n");
        }
        /*Calculate the formula result*/
        result.append("RESULT: ").append(calculate(partsFormula, plusAndMinus, firstChar)).append("\n");
        System.out.print(result);
    }

    /**
     * Create the array with "+-" characters from the formula
     *
     * @return - array with "+-" characters in the order of their appearance
     * @formula - the current formula
     */
    private static String[] plusAndMinus(String formula) {
        String[] result;
        String pattern = "[+-]+";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(formula);
        int j = 0;
        int size = formula.split(pattern).length - 1;
        result = new String[size];

        while (m.find()) {
            result[j] = m.group(0);
            j++;
        }
        return result;
    }

    /**
     * Calculate the formula result
     *
     * @return the formula result
     * @partsFormula - the array of the terms
     * @plusAndMinus - the array of "+-" characters
     * @firstChar - if the first char of the formula equals "-" this parameter equals true
     */
    private static double calculate(String[] partsFormula, String[] plusAndMinus, boolean firstChar) {
        double result;
        String[] replaceVariables = new String[partsFormula.length]; //Replace the variables their values
        int i = 0;
        String numVal;

        /*Replace variables by values in the formula*/
        for (String x : partsFormula) {
            numVal = x;
            if(i ==0 && firstChar) numVal = "-" + numVal;

            for (String key : variables.keySet()) {
                numVal = numVal.replaceAll(key, String.valueOf(variables.get(key)));
            }
            replaceVariables[i] = numVal;
            i++;
        }

        double[] terms = findTerms(replaceVariables); //Calculate the values ​​of all terms and put them in array

        /*Calculate of the final result*/
        result = terms[0];
        for (int j = 1; j < terms.length; j++) {
            if (plusAndMinus[j - 1].equals("+")) {
                result += terms[j];
            } else {
                result -= terms[j];
            }
        }
        return result;
    }

    /**
     * Split the terms into numeric and calculate their values
     *
     * @return double array of the all terms
     * @formula - the currant formula
     */
    private static double[] findTerms(String[] termsOfFormula) {
        String pattern = "[*/^]+";
        Pattern r = Pattern.compile(pattern);

        double[] result = new double[termsOfFormula.length];
        String[] numbers;
        String[] math;
        Matcher m;
        int i = 0;
        int j;
        int size;
        /*Split each term into numeric values*/
        for (String x : termsOfFormula) {
            j = 0;
            numbers = x.split(pattern); //Create the numeric array
            size = numbers.length - 1;
            math = new String[size]; //Create the math symbol array (/*^)
            m = r.matcher(x);

            while (m.find()) {
                math[j] = m.group(0);
                j++;
            }

            result[i] = calculateTerm(numbers, math); //Calculate the value of the term
            i++;
        }
        return result;
    }

    /**
     * Calculate the value of the term. Check division by zero and use fractional power with negative numbers
     *
     * @return result of the calculation
     * @numbers - the numeric array
     * @math - the math symbol array (/*^)
     */
    private static double calculateTerm(String[] numbers, String[] math) {
        double result = Double.parseDouble(numbers[0]);
        double currentValue;
        double roundValue;
        int roundInt;
        int powerRound = 10000;//Use for round number to 0.0

        /*Calculate multiplication, division, or exponentiation*/
        for (int i = 1; i < numbers.length; i++) {
            currentValue = Double.parseDouble(numbers[i]);
            if (math[i - 1].equals("*")) result *= currentValue;
            if (math[i - 1].equals("/")) {
                roundInt = (int) Math.round(currentValue * powerRound);
                roundValue = (double) roundInt / powerRound;

                if (roundValue == 0.0) System.out.println("ATTENTION! Division by zero!");
                result /= currentValue;
            }
            if (math[i - 1].equals("^")) {
                if (currentValue % 1 != 0.0 && result < 0)
                    System.out.println("ATTENTION! You can't raise a negative number to a fractional power!");
                result = Math.pow(result, currentValue);
            }
        }
        return result;
    }
}

