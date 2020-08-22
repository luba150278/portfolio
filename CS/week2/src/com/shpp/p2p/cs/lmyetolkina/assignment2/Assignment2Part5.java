package com.shpp.p2p.cs.lmyetolkina.assignment2;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part5 extends WindowProgram {

    /* The number of rows and columns in the grid, respectively. */
    private static final int NUM_ROWS = 15;
    private static final int NUM_COLS = 17;
    /* The width and height of each box. */
    private static final double BOX_SIZE = 30;
    /* The horizontal and vertical spacing between the boxes. */
    private static final double BOX_SPACING = 10;
    /* The sum the box size and box space is the distance between the left-top corner of previous and next boxes. */
    private static final double STEP = BOX_SIZE + BOX_SPACING;
    /* The color of the border and fill rectangle*/
    private static final Color CLR = Color.GREEN;
    /* Summary width and height of all boxes */
    private static final double WIDTH_FIELD = NUM_COLS * BOX_SIZE + (NUM_COLS - 1) * BOX_SPACING;
    private static final double HEIGHT_FIELD = NUM_ROWS * BOX_SIZE + (NUM_ROWS - 1) * BOX_SPACING;
    /*Summary Application sizes - add 20% to summary width and height of all boxes*/
    public static final int APPLICATION_WIDTH = (int) (WIDTH_FIELD * 1.2);
    public static final int APPLICATION_HEIGHT = (int) (HEIGHT_FIELD * 1.2);

    /*The method draws rectangles, placing them on a given number of rows and columns*/
    public void run() {
        /*Resize application*/
        this.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
        /* The x, y coordinates of the first box*/
        double x = (getWidth() - WIDTH_FIELD) / 2;
        double y = (getHeight() - HEIGHT_FIELD) / 2;

        /* We drawing the boxes using two cycles.
         * Also using external method Add_Rect(). */
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                /*Add new rectangle*/
                Add_Rect(x + j * STEP, y + i * STEP);
            }
        }
    }

    /*Add the rectangle*/
    void Add_Rect(double x, double y) {
        GRect Rect = new GRect(x, y, BOX_SIZE, BOX_SIZE);
        Rect.setColor(CLR);
        Rect.setFilled(true);
        Rect.setFillColor(CLR);
        add(Rect);
    }
}
