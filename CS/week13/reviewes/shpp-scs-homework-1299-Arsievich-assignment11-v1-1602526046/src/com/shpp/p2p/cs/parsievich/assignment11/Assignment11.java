package com.shpp.p2p.cs.parsievich.assignment11;

import java.util.ArrayList;
import java.util.HashMap;

import static com.shpp.p2p.cs.parsievich.assignment11.ReversePolishNotation.*;
import static com.shpp.p2p.cs.parsievich.assignment11.FormulaValidationAndSplitting.*;
import static com.shpp.p2p.cs.parsievich.assignment11.Variables.*;

public class Assignment11 {
    public static HashMap<String, String> variables = new HashMap<>();
    public static ArrayList<String> validFormula = new ArrayList<>();
    public static ArrayList<String> formulaToRPN = new ArrayList<>();
    public static ArrayList<String> finishFormula = new ArrayList<>();


    /**
     * The main algorithm:
     * 1.Check for arguments.
     *      1.1. We check the validity of the formula and divide it into elements.
     *      1.2. Rewriting the formula in RPN style.
     *      1.3. We look for variables in the arguments and save them in the HashMap.
     *      1.4. We replace the variables in the formula with values.
     *      1.5. We display a list of variables.
     *      1.6. We display the formula and the calculated result.
     *
     * 2. The cycle of changing the values of variables.
     *      2.1. We replace the variables in the formula with new values.
     *      2.2. We display a list of variables.
     *      2.3. We display the formula and the calculated result.
     *
     * @param args first args - formula, next - variables
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            validFormula = validationOfFormulaAndSplitToElements(args[0]);
            formulaToRPN = rewriteFormulaToRPNStyle(validFormula);
            variables = findAndSaveVariables(args);
            finishFormula = ReplaceVariablesWithValues(formulaToRPN, variables);
            System.out.println(variables);
            System.out.println(args[0] + "=" + answer(finishFormula));

            while (true) {
                finishFormula = ReplaceVariablesWithValues(formulaToRPN, newVariables(variables));
                System.out.println(variables);
                System.out.println(args[0] + "=" + answer(finishFormula));
                System.out.println("Write an 'exit' to shutdown the program!");
            }

        } else {
            System.out.println("You have not entered any arguments!");
        }

    }
}
