package com.shpp.p2p.cs.lmyetolkina.assignment11;

/**
 * The task implements the calculation of the value of the function passed as an argument to the "main" method.
 * A function can contain variables whose values are also passed as arguments.
 * To calculate the function, an algorithm called "Reverse Polish Notation" is used.
 * The function is parsed once, and then it can be used repeatedly.
 */
public class Assignment11Part1 extends Common implements Constants {
    /*The start formula*/
    static String formula;
    /*The calculated finish result*/
    static double finishResult;
    /*Additional comments for the user*/
    static StringBuilder commentString;
    static String[] mes;

    public static void main(String[] args) {
        mes=args;
        commentString = new StringBuilder();
        find(); //Find result of the calculation
        PrintAndRepeat.main(mes[0], commentString, finishResult); /*Print result and repeat calculation from another
                                                                     variables data*/
    }

    /**
     * Do some steps from start to finish
     */
    private static void find(){
        try {
            CheckFormula.check(mes[0]); //Check the formula validity
            ExtractFormula.extract(formula);//Extract the formula variables
            ExtractVariables.extract(mes); //Extract the values of the formula variables
            ParsingFormula.parser(formula); //Parsing formula. Create "reverse polish notation".
            Calculator.calc(); //Place numeric values to the parsing formula and calculate the result
        } catch (NumberFormatException e) {
            commentString.append("Please, check your formula and/or variables names.\n");
        } catch (ArrayIndexOutOfBoundsException e) {
            commentString.append("The empty input data array! Please input formula and variables with data.\n");
        }
    }
}
