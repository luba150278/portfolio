package com.shpp.p2p.cs.lmyetolkina.assignment11;

import java.util.*;

public interface Constants {
    String MATH_FUNC = "(sin)|(cos)|(asin)|(acos)|(ln)|(log)|(tan)|(atan)|(sqrt)|(exp)|(!)";
    String MATH_SYMBOLS_AND_FUNC =
            "(sin)|(cos)|(asin)|(acos)|(ln)|(log)|(tan)|(atan)|(sqrt)|(exp)|[-+/*^%!]";
    String MATH_SYMBOLS="[-+/*^%!]";
    String NOT_MATH_SYMBOLS_AND_FUNC =
            "^(sin)|^(cos)|^(asin)|^(acos)|^(ln)|^(log)|^(tan)|^(atan)|^(sqrt)|^(exp)|[^-+/*^%!]";
    String[] MATH_FUNCTIONS =
            new String[]{"sin", "cos", "asin", "acos", "ln", "log", "tan", "atan", "sqrt", "exp", "!"};
    String PARSE_STRING =
            "(sin)|(cos)|(tan)|(asin)|(acos)|(atan)|(sqrt)|(exp)|(ln)|(log)|((-)?([0-9]+)(\\.[0-9]+)?)|[+-]|" +
                    "[/*]|[%^!]|[)(]|([a-z0-9_]+)";
    /*The arrays and strings with the regular expressions used to realise the task*/
    Set<String> FUNCTIONS =
            new HashSet<>(Arrays.asList("sin", "cos", "tan", "asin", "acos", "atan", "exp", "sqrt", "ln", "log", "!"));
    /*The parsing formula*/
    ArrayList<String> parsingFormula = new ArrayList<>();
    /*Unique variables from the formula*/
    Set<String> formulaVariables = new HashSet<>();
    /*Hashmap saves the formula variables and them values*/
    HashMap<String, Double> variables = new HashMap<>();
}
