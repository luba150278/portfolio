package com.shpp.p2p.cs.lmyetolkina.assignment2;

import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part2 extends WindowProgram {
    /* The default width and height of the window.*/
    public static final int APPLICATION_WIDTH = 700;
    public static final int APPLICATION_HEIGHT = 300;
    /*The circle diameter*/
    public static final int CIRCLE_DIAMETER = 100;

    /*Method for draw 4 circles and a rectangle atop*/
    public void run() {
        /*Resize application*/
        this.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
        /*Use cycles for added circles */
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Add_circle((getWidth() - CIRCLE_DIAMETER) * j,
                        (getHeight() - CIRCLE_DIAMETER) * i,
                        CIRCLE_DIAMETER,
                        CIRCLE_DIAMETER);
            }
        }
        Add_rect();/*We add a rectangle on the middle of the application*/
    }

    /*Add circle method*/
    void Add_circle(double x, double y, double w, double h) {
        GOval Circle = new GOval(x, y, w, h);
        Circle.setFilled(true);
        Circle.setFillColor(Color.BLACK);
        add(Circle);
    }

    /*Add rectangle method*/
    void Add_rect() {
        GRect Rect = new GRect(
                CIRCLE_DIAMETER / 2,
                CIRCLE_DIAMETER / 2,
                getWidth() - CIRCLE_DIAMETER,
                getHeight() - CIRCLE_DIAMETER);
        Rect.setColor(Color.WHITE);
        Rect.setFilled(true);
        Rect.setFillColor(Color.WHITE);
        add(Rect);
    }
}

