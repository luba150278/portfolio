package com.shpp.p2p.cs.lmyetolkina.assignment2;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part6 extends WindowProgram {

    /* Number of ovals which the caterpillar contains*/
    private static final int NUM_OVALS = 10;
    /* Number of ovals which the caterpillar contains*/
    private static final double OVAL_SIZE = 120;
    /*Color of border the caterpillar body*/
    private static final Color COLOR_BORDER = Color.RED;
    /*Color of body the caterpillar*/
    private static final Color COLOR_BODY = Color.GREEN;

    /*Method draw the caterpillar*/
    public void run() {

        double y;  /* Coordinate y for ovals of the caterpillar*/
        /*Use the cycle "for" to draw the caterpillar's body
         * Also using external method Add_Oval().
         * It has some methods for setting the properties of the oval and one method to add a oval.*/
        for (int i = 0; i < NUM_OVALS; i++) {
            /*
             * For imitation of move the caterpillar we will use different y-coordinate to even and odd ovals.
             */
            if (i % 2 == 0) {
                y = getHeight() - OVAL_SIZE;
            } else {
                y = getHeight() - OVAL_SIZE * 1.3;
            }
            /* Remove a few pixels from y-coordinate and get flying caterpillar :-)  */
            y = y - 5;
            /*Draw the one part of the caterpillar*/
            Add_Oval(i * OVAL_SIZE / 2 + 10, y);
        }
    }

    /*Add the oval*/
    void Add_Oval(double x, double y) {
        GOval Oval = new GOval(x, y, OVAL_SIZE, OVAL_SIZE);
        Oval.setColor(COLOR_BORDER);
        Oval.setFilled(true);
        Oval.setFillColor(COLOR_BODY);
        add(Oval);
    }
}
