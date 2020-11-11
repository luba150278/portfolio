package com.shpp.p2p.cs.lmyetolkina.assignment7.Assignment7Part1;

/*
 * File: NameSurferConstants.java
 * ------------------------------
 * This file declares several constants that are shared by the
 * different modules in the NameSurfer application.  Any class
 * that implements this interface can use these constants.
 */

public interface NameSurferConstants {

    /**
     * The width of the application window
     */
    public static final int APPLICATION_WIDTH = 800;

    /**
     * The height of the application window
     */
    public static final int APPLICATION_HEIGHT = 600;

    /**
     * The name of the file containing the data
     */
    public static final String NAMES_DATA_FILE = "names-data.txt";

    /**
     * The first decade in the database
     */
    public static final int START_DECADE = 1900;

    /**
     * The number of decades
     */
    public static final int NDECADES = 12;

    /**
     * The maximum rank in the database
     */
    public static final int MAX_RANK = 1000;

    /**
     * The number of pixels to reserve at the top and bottom
     */
    public static final int GRAPH_MARGIN_SIZE = 20;


    public static final int MAX_RANK_X = MAX_RANK / 100 + 1;
    public static final double HALF_MARGIN = 0.5*GRAPH_MARGIN_SIZE;
    public static final int START_POINT = GRAPH_MARGIN_SIZE+(int)HALF_MARGIN;
    public static final double POINT_DIAMETER = 5.0;
    public static final double POINT_RADIUS = POINT_DIAMETER / 2;
}
