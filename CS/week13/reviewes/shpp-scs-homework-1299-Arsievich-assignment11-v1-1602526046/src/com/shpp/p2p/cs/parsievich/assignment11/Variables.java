package com.shpp.p2p.cs.parsievich.assignment11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/**
 * This class stores methods for processing (searching, saving and changing) variables.
 */
import static com.shpp.p2p.cs.parsievich.assignment11.AdditionalMethods.*;

public class Variables {

    /**
     * The method loops through the array of arguments and stores the found variables
     *
     * @param args some arguments
     * @return HashMap with name and value of variables
     */
    public static HashMap<String, String> findAndSaveVariables(String[] args) {
        HashMap<String, String> variables = new HashMap<>();
        if (args.length > 1) {
            String name;
            String value;
            for (int i = 1; i < args.length; i++) {
                name = "";
                value = "";
                for (int j = 0; j < args[i].length(); j++) {
                    if (isLetter(args[i].charAt(j))) {
                        name += args[i].charAt(j);
                    }
                    if (isNumericChar(args[i].charAt(j))) {
                        value += args[i].charAt(j);
                    }
                }

                if (name.length() != 1) {
                    System.out.println("A variable name can be only one letter!!!");
                    System.exit(0);
                } else if (value.length() > 0) {
                    variables.put(name, value);
                } else {
                    System.out.println("Value can't be empty!!!");
                }

            }
        }
        return variables;
    }

    /**
     * this method replaces all variables in the formula with values, if any in the HashMap
     *
     * @param formula   some formula
     * @param variables list of variables
     * @return formula without variables
     */
    public static ArrayList<String> ReplaceVariablesWithValues(ArrayList<String> formula, HashMap<String, String> variables) {
        ArrayList<String> newFormula = new ArrayList<>();
        for (int i = 0; i < formula.size(); i++) {
            if ((variables.containsKey(formula.get(i)))) {
                newFormula.add(i, variables.get(formula.get(i)));
            } else {
                newFormula.add(formula.get(i));
            }
        }
        return newFormula;
    }

    /**
     * this method replaces variables by asking the user which variable to replace the value
     *
     * @param variables list of variables
     * @return new list of variables
     */
    public static HashMap<String, String> newVariables(HashMap<String, String> variables) {
        Scanner in = new Scanner(System.in);
        String name = "";
        while (!name.equals("nextstep")) {
            System.out.print("Enter the name of the variable you want to replace! Or press Enter to exit : ");

            name = in.nextLine().replaceAll("\\s", "");
            if (name.equals("exit")) {
                System.exit(0);
            } else if (name.equals("")) {
                name = "nextstep";
            } else if (variables.containsKey(name)) {
                System.out.print("Enter the value of the '" + name + "' : ");
                String value = in.nextLine().replaceAll("\\s", "");
                if (isNumericString(value)) {
                    variables.put(name, value);
                } else {
                    System.out.println("Incorrect value!");
                }
            } else {
                System.out.println("Name not found!");
            }
        }
        return variables;
    }
}
