package com.shpp.p2p.cs.lmyetolkina.assignment5;

import com.shpp.cs.a.console.TextProgram;
/**
 * Sum of two positive numbers with arbitrary length
 */
public class Assignment5Part2 extends TextProgram {

    public void run() {
        /*If user wants to stop program, he enter <q>*/
        println("Enter <q> to finish program.");
        /* Sit in a loop, reading numbers and adding them. */
        while (true) {
            String n1 = readLine("Enter first number:  ");
            String n2 = readLine("Enter second number: ");
            if(n1.toLowerCase().equals("q") || n2.toLowerCase().equals("q")) break;
            println(n1 + " + " + n2 + " = " + addNumericStrings(n1, n2));
            println();
        }
    }

    /**
     * Given two string representations of nonnegative integers, adds the
     * numbers represented by those strings and returns the result.
     *
     * @param n1 The first number.
     * @param n2 The second number.
     * @return A String representation of n1 + n2
     */
    private String addNumericStrings(String n1, String n2) {
        String regex = "\\d+"; //Check regex-string

        /*Check the n1, n2 strings. They should have just numbers.*/
        if (!n1.matches(regex) || !n2.matches(regex))
            return "Indefinite :-) In this task you can use just positive numbers strings";

        /*Reverse n1, n2 strings*/
        String n1Reversed = new StringBuffer(n1).reverse().toString();
        String n2Reversed = new StringBuffer(n2).reverse().toString();

        /*Find string with max length*/
        int maxLength = n1.length() - 1;
        int minLength = n2.length() - 1;
        String maxString = n1Reversed;
        String minString = n2Reversed;

        /*Replace strings if is needed*/
        if (maxLength < minLength) {
            maxLength = minLength;
            maxString = minString;
            minLength = n1.length() - 1;
            minString = n1Reversed;
        }

        //Find sum of numbers
        return sumTwoNumbers(minLength, maxLength, maxString, minString);
    }

    /**
     * Use school method of sum two numbers
     *
     * @param min    - The minimum size of two strings
     * @param max    - The maximum size of two strings
     * @param maxStr - Larger string
     * @param minStr - Smaller string
     * @return The result string
     */
    private String sumTwoNumbers(int min, int max, String maxStr, String minStr) {
        StringBuilder result = new StringBuilder();
        int inMemory = 0;

        /*Sum first digits of both numbers. If the result is less than 10, then we save the result, write 0 into memory.
        If the result is more than 9, then we save the last digit of the two-digit number,
        and the first digit of this number is saved into memory to be used in the next iteration.*/
        for (int i = 0; i <= max; i++) {
            int firstDigitMaxNumber = charToInt(maxStr.charAt(i));
            int firstDigitMinNumber;
            int lastDigitResultNumber;
            String sumOfDigits;

            firstDigitMinNumber = (i <= min) ? charToInt(minStr.charAt(i)) : 0;
            lastDigitResultNumber = firstDigitMaxNumber + firstDigitMinNumber + inMemory;

            if (lastDigitResultNumber <= 9) {
                inMemory = 0;
            } else {
                sumOfDigits = Integer.toString(lastDigitResultNumber);
                lastDigitResultNumber = charToInt(sumOfDigits.charAt(1));
                inMemory = charToInt(sumOfDigits.charAt(0));
            }
            result.insert(0, lastDigitResultNumber);
        }

        if (inMemory > 0) result.insert(0, inMemory);
        return result.toString();
    }

    /**
     * Convert char to integer
     *
     * @param ch char value
     * @return integer value of number
     */
    private int charToInt(char ch) {
        return Character.getNumericValue(ch);
    }
}
