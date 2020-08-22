package com.shpp.p2p.cs.lmyetolkina.assignment2;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;


/* TODO: Replace these file comments with a description of what your program
 * does.
 */

public class Assignment2Part3 extends WindowProgram {
    /* Constants controlling the relative positions of the
     * three toes to the upper-left corner of the drawPawprint.
     *
     * (Yes, I know that actual drawPawprint have four toes.
     * Just pretend it's a cartoon animal. ^_^)
     */
    private static final double FIRST_TOE_OFFSET_X = 0;
    private static final double FIRST_TOE_OFFSET_Y = 20;
    private static final double SECOND_TOE_OFFSET_X = 30;
    private static final double SECOND_TOE_OFFSET_Y = 0;
    private static final double THIRD_TOE_OFFSET_X = 60;
    private static final double THIRD_TOE_OFFSET_Y = 20;
    /* The position of the heel relative to the upper-left
     * corner of the drawPawprint.
     */
    private static final double HEEL_OFFSET_X = 20;
    private static final double HEEL_OFFSET_Y = 40;
    /* Each toe is an oval with this width and height. */
    private static final double TOE_WIDTH = 20;
    private static final double TOE_HEIGHT = 30;
    /* The heel is an oval with this width and height. */
    private static final double HEEL_WIDTH = 40;
    private static final double HEEL_HEIGHT = 60;
    /* The default width and height of the window. These constants will tell Java to
     * create a window whose size is *approximately* given by these dimensions. You should
     * not directly use these constants in your program; instead, use getWidth() and
     * getHeight(), which return the *exact* width and height of the window.
     */
    public static final int APPLICATION_WIDTH = 300;
    public static final int APPLICATION_HEIGHT = 300;

    /* Method for draw 2 heels and 3 toes for each heel*/
    public void run() {
        /*Resize application*/
        this.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
        /*Draw two heels with toes*/
        drawPawprint(20, 20);
        drawPawprint(180, 70);
    }

    /**
     * Draws a pawprint. The parameters should specify the upper-left corner of the
     * bounding box containing that pawprint.
     *
     * @param x The x coordinate of the upper-left corner of the bounding box for the pawprint.
     * @param y The y coordinate of the upper-left corner of the bounding box for the pawprint.
     */
    private void drawPawprint(double x, double y) {
        /* To paint heel*/
        Add_oval(x, y, true, 0);
        /* To paint the toes*/
        Add_oval(x, y, false, 1);
        Add_oval(x, y, false, 2);
        Add_oval(x, y, false, 3);
    }

    /*Add oval. Method use parameters for depending coordinates and size of the oval*/
    void Add_oval(double x, double y, boolean heel_or_toe, int toe) {
        GOval Oval;
        double x_toe = 0;
        double y_toe = 0;

        if (heel_or_toe == true) {
            Oval = new GOval(x + HEEL_OFFSET_X, y + HEEL_OFFSET_Y, HEEL_WIDTH, HEEL_HEIGHT);
        } else {
            switch (toe) {
                case 1:
                    x_toe = x + FIRST_TOE_OFFSET_X;
                    y_toe = y + FIRST_TOE_OFFSET_Y;
                    break;
                case 2:
                    x_toe = x + SECOND_TOE_OFFSET_X;
                    y_toe = y + SECOND_TOE_OFFSET_Y;
                    break;
                case 3:
                    x_toe = x + THIRD_TOE_OFFSET_X;
                    y_toe = y + THIRD_TOE_OFFSET_Y;
                    break;
            }
            Oval = new GOval(x_toe, y_toe, TOE_WIDTH, TOE_HEIGHT);
        }
        /*Here we fill the oval with the black color*/
        Oval.setFilled(true);
        Oval.setFillColor(Color.BLACK);
        add(Oval);
    }
}

