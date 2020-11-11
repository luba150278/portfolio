package com.shpp.p2p.cs.lmyetolkina.assignment9;

import com.shpp.cs.a.graphics.WindowProgram;
import acm.graphics.GOval;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import java.awt.*;

/**
 * Take a screenshot the app window without borders and window header
 */
public class Assignment9Part1 extends WindowProgram {
    /* Number of ovals which the caterpillar contains*/
    private static final int NUM_OVALS = 10;
    /* Number of ovals which the caterpillar contains*/
    private static final double OVAL_SIZE = 120;
    /*Color of border the caterpillar body*/
    private static final Color COLOR_BORDER = Color.RED;
    /*Color of body the caterpillar*/
    private static final Color COLOR_BODY = Color.GREEN;


    public void run() {
        /*Draw the caterpillar*/
        drawCaterpillar();
        /*Take a 1-second long pause for loading the app window*/
        pause(1000);
        /*Take a screenshot the app window without borders and window header*/
        captureCanvas();
    }

    /**
     * Draw the caterpillar
     */
    private void drawCaterpillar() {
        double y;  /* Coordinate y for ovals of the caterpillar*/

        /*Use the cycle "for" to draw the caterpillar's body
         * Also using external method Add_Oval().
         * It has some methods for setting the properties of the oval and one method to add a oval.*/
        for (int i = 0; i < NUM_OVALS; i++) {
            /* For imitation of move the caterpillar we will use different y-coordinate to even and odd ovals. */
            y = (i % 2 == 0) ? getHeight() - OVAL_SIZE : getHeight() - OVAL_SIZE * 1.3;
            /*Draw the one part of the caterpillar*/
            addOval(i * OVAL_SIZE / 2 + 10, y);
        }
    }

    /**
     * Add the oval
     */
    private void addOval(double x, double y) {
        GOval oval = new GOval(x, y, OVAL_SIZE, OVAL_SIZE);
        oval.setColor(COLOR_BORDER);
        oval.setFilled(true);
        oval.setFillColor(COLOR_BODY);
        add(oval);
    }

    /**
     * Take a screenshot the app window without borders and window header
     */
    private void captureCanvas() {
        Window desktopWindow = Window.getWindows()[0];

        int deltaY = desktopWindow.getHeight() - getHeight();
        int deltaX = desktopWindow.getWidth() - getWidth();
        Point pnt = desktopWindow.getLocation();
        int x = pnt.x + deltaX / 2;
        int y = pnt.y + deltaY - 6; /*Why is 6? See in 636 line of Program.class*/

        try {
            Robot robot = new Robot();
            BufferedImage screenShot = robot.createScreenCapture(new Rectangle(x, y, getWidth(), getHeight()));
            ImageIO.write(screenShot, "PNG", new File("caterpillar.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
