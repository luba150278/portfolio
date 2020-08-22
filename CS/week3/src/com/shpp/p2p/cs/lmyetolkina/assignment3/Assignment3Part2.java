package com.shpp.p2p.cs.lmyetolkina.assignment3;

import com.shpp.cs.a.console.TextProgram;

public class Assignment3Part2 extends TextProgram {
    /**
     * Check if a number is a hail number
     */
    public void run() {
        try {
            checkHailNumber();
        } catch (Exception e) {
            println("Please, use only integer numbers from 1 to 715827882. Try to start again." + e.getMessage());
        }
    }

    /**
     * Ask user input the number. If the number is negative, ask user input new positive number.
     * Use next algorithm:
     * 1. If number is positive check odd/even.
     * 2. If number is take half, otherwise use "3*n+1".
     * 3. Repeat while we won't get one.
     */
    private void checkHailNumber() throws Exception {

        int n = readInt("Please, enter positive integer from 1 to 715827882:");
        String result = "";
        if(n % 2 !=0 && (double)n*3+1 >= 2147483647){
            println("Please, use only positive integers from 1 to 715827882. Try to start again.");
            return;
        }
        if (n <= 0) {
            println("Please, use only positive integers. Try to start again.");
        } else {
            while (n != 1) {
                result = result + n;
                if (n % 2 == 0) {
                    result += " is even. So I take half: ";
                    n = n / 2;
                } else {
                    result += " is odd. So I take 3*n+1: ";
                    n = n * 3 + 1;
                }
                result = result + n + ".\n";
            }
            println(result + "I got one. So it's finish!");
        }
    }
}
