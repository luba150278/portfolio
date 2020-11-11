package com.shpp.p2p.cs.lmyetolkina.assignment11;

/**
 * Put the all variables and their values to an HashMap
 */
public class ExtractVariables implements Constants {

    /**
     * Put the all variables and their values to an HashMap
     * @param args - the start data array
     * @return the variables data array
     */
    public static void extract(String[] args) {
        String[] s = new String[args.length - 1];
        if (args.length - 1 >= 0) System.arraycopy(args, 1, s, 0, args.length - 1);
        partsOfVariables(s);
        variablesWithoutValue();//Check exists the formula variables without values and use 0.0 value for it
    }
    /**
     * Extract variables and their values ​​from the input array to Hashmap and do some data validation:
     * 1. Check to exist the name of the variable (before "=" symbol).
     * 2. Check the name of the variable. The name can have just letters, numbers and _
     * 3. The value of the variable should be a double number.
     *
     * @param args - the start variables
     */
    private static void partsOfVariables(String[] args) {
        String variable;
        String[] parts;

        for (String arg : args) {
            /*Delete all spaces*/
            variable = Common.deleteSpace(arg);
            /*Check #1*/
            if (variable.charAt(0) == '=') {
                Assignment11Part1.commentString.append("Error. You try to entry number without variable!\n");
            }
            parts = variable.split("=");
            /*Check #3*/
            try {
                /*Check #2*/
                checkNameVariable(parts[0]);
                /*We add to the array only those variables that are in the formula*/
                if (formulaVariables.contains(parts[0])) {
                    variables.put(parts[0], Double.parseDouble(parts[1].replaceAll("[,]", ".")));
                }
            } catch (NumberFormatException e) {
                Assignment11Part1.commentString.append("Error. The Variable ").append(parts[0])
                        .append(" hasn't the numeric value: ")
                        .append(parts[1]).append("\n");
            }
        }
    }

    /**
     * Check the name of the variable. The name can have just letters, numbers and _
     * @param variable - the variable in the input data array
     */
    private static void checkNameVariable(String variable) {
        String resultString = variable.replaceAll("[a-z0-9_]", "");

        if (resultString.length() > 0) {
            Assignment11Part1.commentString.append("Error. Unacceptable symbols in one of the variable: ")
                    .append(resultString).append("\n");
        }
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
}
