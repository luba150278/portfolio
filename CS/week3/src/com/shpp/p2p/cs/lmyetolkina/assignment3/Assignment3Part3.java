package com.shpp.p2p.cs.lmyetolkina.assignment3;

import com.shpp.cs.a.console.TextProgram;

public class Assignment3Part3 extends TextProgram {

    /**
     * The method makes exponentiation some number.
     */
    public void run() {
        try {
            double base = readDouble("Please enter a decimal number (for example 2,0):");
            int degree = readInt("Please, enter integer number (the degree of the number):");
            double result = raiseToPower(base, degree);/**"raiseToPower" return exponentiation of the number */
            if(result == 0.0){
                println("Too much number");
            }else{
            println("Number: " + base + " degree:" + degree +" Result:" + result);}
        } catch (Exception e) {
            println("Please, check your numbers and try again." + e.getMessage());
        }
    }

    /**
     * If exponent equal 0 return 1
     * Else multiple number by itself N-times. N = |exponent|.
     * If exponent is negative number we divide the unit by the result
     */
    private double raiseToPower(double number, int degree) {

        if (degree == 0) {
            return 1;
        }

        double multiplicationCount = number;
        int absoluteExponent = (degree > 0 ) ? degree : -degree;

        for (int i = 2; i <= absoluteExponent; i++) {
            if(multiplicationCount + 1 >= 1.7e+308){
                return 0.0;
            }
            multiplicationCount *= number;
        }

        if (degree < 0) {
            multiplicationCount = 1 / multiplicationCount;
        }

        return multiplicationCount;
    }
}
