package com.shpp.p2p.cs.vkolisnichenko.assignment11;

/**
 * An enumeration that defines all trigonometric
 * functions and their named constructor
 */
public enum Functions {
    SIN("sin"), COS("cos"), TAN("tan"),
    ATAN("atan"), LOG2("log"),
    LOG10("log10"), SQRT("sqrt");
    private String name;

    /**
     * The constructor from which we get the name
     * @param name - object name
     */
    Functions(String name) {
        this.name = name;
    }

    /**
     * Method that returns name
     * @return - name
     */
    public String getName() {
        return name;
    }
}
