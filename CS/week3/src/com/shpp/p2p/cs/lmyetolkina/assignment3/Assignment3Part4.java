package com.shpp.p2p.cs.lmyetolkina.assignment3;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment3Part4 extends WindowProgram {
    /*Height of the one brick*/
    private static final int BRICK_HEIGHT = 20;
    /*Width of the one brick*/
    private static final int BRICK_WIDTH = 50;
    /*Count of the bricks in the base of a pyramid*/
    private static final int BRICKS_IN_BASE = 20;
    /*Width of the application window*/
    private static final int APP_WIDTH = BRICK_WIDTH * BRICKS_IN_BASE + 2 * BRICK_WIDTH;
    /*Height of the application window*/
    private static final int APP_HEIGHT = BRICK_HEIGHT * BRICKS_IN_BASE + 2 * BRICK_WIDTH;
    /*Colors of the brick and his border*/
    private static final Color BRICK_COLOR = Color.GREEN;
    private static final Color BORDER_BRICK_COLOR = Color.RED;

    /**
     * Build the pyramid
     */
    public void run() {
        /*Resize the application window */
        setSize(APP_WIDTH, APP_HEIGHT);
        /*Build the pyramid*/
        buildPyramid();
    }

    /**
     * Build the pyramid.
     */
    private void buildPyramid(){
        /*Find the x-coordinate for the first brick*/
        double firstBrickXcoordinate = (getWidth() - BRICK_WIDTH * BRICKS_IN_BASE) / 2;
        /*Use cycle to find x and y coordinates of all bricks and place them in a pyramid shape*/
        for (int i = 0; i < BRICKS_IN_BASE; i++) {
            int count_bases = BRICKS_IN_BASE - i;
            for (int j = 0; j < count_bases; j++) {
                double y = getHeight() - i * BRICK_HEIGHT - BRICK_HEIGHT;
                double x = firstBrickXcoordinate + BRICK_WIDTH / 2 * i + j * BRICK_WIDTH;
                /*Add rectangle (brick) in the pyramid*/
                addRectangle(x, y);
            }
        }
    }

    /**
     * Add the bricks on the pyramid
     * @param x - coordinate of the brick
     * @param y - coordinate of the brick
     */
    private void addRectangle(double x, double y) {
        GRect Rectangle = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
        Rectangle.setColor(BORDER_BRICK_COLOR);
        Rectangle.setFilled(true);
        Rectangle.setFillColor(BRICK_COLOR);
        add(Rectangle);
    }
}
