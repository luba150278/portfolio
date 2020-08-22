package com.shpp.p2p.cs.lmyetolkina.assignment2;

import acm.graphics.GLabel;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part4 extends WindowProgram {
    /* We define each color of flag sections */
    private static final Color FIRST_COLOR = Color.RED;
    private static final Color SECOND_COLOR = Color.GREEN;
    private static final Color THIRD_COLOR = Color.YELLOW;
    /* We define a string where we will write the country name  */
    private static final String DESCRIPTION = "Flag of New country";
    /*The default width and height of the flag. Here I use 70% from the width and height of the window */
    private static final double FLAG_WIDTH = 400;
    private static final double FLAG_HEIGHT = 300;
    /*Vertical or horizontal sections place*/
    private static final boolean VERT = false;

    /*Draw three-color flag. The color sections can be vertical (VERT=true) or horizontal (VERT = false) position
    * Using the "Add_RECT" method for paint flag sections*/
    public void run() {

        if (VERT == true) {
            Add_Rect((getWidth() - FLAG_WIDTH) / 2, (getHeight() - FLAG_HEIGHT) / 2,
                    FLAG_WIDTH / 3.0, FLAG_HEIGHT, FIRST_COLOR);
            Add_Rect((getWidth() - FLAG_WIDTH) / 2 + FLAG_WIDTH / 3.0, (getHeight() - FLAG_HEIGHT) / 2,
                    FLAG_WIDTH / 3.0, FLAG_HEIGHT, SECOND_COLOR);
            Add_Rect((getWidth() - FLAG_WIDTH) / 2 + 2 * FLAG_WIDTH / 3.0, (getHeight() - FLAG_HEIGHT) / 2,
                    FLAG_WIDTH / 3.0, FLAG_HEIGHT, THIRD_COLOR);
        } else {
            Add_Rect((getWidth() - FLAG_WIDTH) / 2, (getHeight() - FLAG_HEIGHT) / 2,
                    FLAG_WIDTH, FLAG_HEIGHT / 3.0, FIRST_COLOR);
            Add_Rect((getWidth() - FLAG_WIDTH) / 2, (getHeight() - FLAG_HEIGHT) / 2 + FLAG_HEIGHT / 3.0,
                    FLAG_WIDTH, FLAG_HEIGHT / 3.0, SECOND_COLOR);
            Add_Rect((getWidth() - FLAG_WIDTH) / 2, (getHeight() - FLAG_HEIGHT) / 2 + 2 * FLAG_HEIGHT / 3.0,
                    FLAG_WIDTH, FLAG_HEIGHT / 3.0, THIRD_COLOR);
        }
        Add_Label();
    }

    /*Adding the rectangle - flag section*/
    void Add_Rect(double x, double y, double w, double h, Color clr) {
        GRect Rect = new GRect(x, y, w, h);
        Rect.setColor(clr);
        Rect.setFilled(true);
        Rect.setFillColor(clr);
        add(Rect);
    }

    /*Adding the label with the description of a flag*/
    void Add_Label() {
        GLabel label = new GLabel(DESCRIPTION, 0, 0);
        label.setFont("Arial-20");
        double widthLabel = label.getWidth();
        double heightLabel = label.getHeight();
        label.move(getWidth() - widthLabel, getHeight() - 0.5 * heightLabel);
        add(label);
    }
}
