package com.shpp.p2p.cs.lmyetolkina.assignment8;

import acm.graphics.GObject;
import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Create X balls on the diagonal of the window app. Moving balls by click.
 * If count clicks more then N stop the first ball in the queue.
 */
public class Assignment8Part1 extends WindowProgram {
    /* Create Array of moving balls. Has ovals, direction (horizontal or not) and reverse if ball hit any wall   */
    private static class MovingBalls {
        private final GOval oval;
        private final boolean direction;
        private final int reverse;

        private MovingBalls(GOval oval, boolean direction, int reverse) {
            this.oval = oval;
            this.direction = direction;
            this.reverse = reverse;
        }
    }

    private final int COUNT_BALL = 20;                             /*Common balls count*/
    private final int MOVING_BALL = 2;                            /*Moving balls count*/
    private final Color HORIZONTAL_MOVE_COLOR = Color.CYAN;       /*The ball's color which move by the horizontal direction*/
    private final Color VERTICAL_MOVE_COLOR = Color.GREEN;        /*The ball's color which move by the vertical direction*/
    private double diameterBall;                                  /*Diameter of ball*/
    private final int VELOCITY = 5;                               /*Velocity of the balls*/
    private final ArrayList<MovingBalls> movingBalls = new ArrayList<>(); /* Array of moving balls*/
    private final static int PAUSE_TIME = 100;                             /*Animation rang time*/

    public void run() {
        addMouseListeners();
        /*Set diameter balls and create them*/
        setUpApp();
        /*Start the animation*/
        waitForClick();
        while (true) {
            for (int i = 0; i < movingBalls.size(); i++) {
                moveBall(i);
            }
            pause(PAUSE_TIME);
        }
    }

    @Override
    /**
     * Add a ball to the array if clicked by it
     */
    public void mouseClicked(MouseEvent mouseEvent) {
        double getX = mouseEvent.getX();
        double getY = mouseEvent.getY();

        GOval ballClicked = getCollidingObject(getX, getY);
        if (ballClicked != null) {
            arrayMovingBalls(ballClicked);
        }
    }

    /**
     * Define the width and height of the one cell. The minimal value will equal the diameter ball.
     * x, y - the offset step
     */
    private void setUpApp() {
        double x = getWidth() / (double) COUNT_BALL;
        double y = getHeight() / (double) COUNT_BALL;
        diameterBall = Math.min(x, y);
        for (int i = 0; i < COUNT_BALL; i++) {
            createBalls(x, y, i);
        }
    }

    /**
     * Create balls. (x - diameterBall) / 2 and (y - diameterBall) / 2 need for centering ball into cell
     * @param x the offset step by x
     * @param y the offset step by y
     * @param i ball number
     */
    private void createBalls(double x, double y, int i) {
        GOval oval = new GOval(i * x + (x - diameterBall) / 2,
                i * y + (y - diameterBall) / 2,
                diameterBall, diameterBall);

        oval.setFilled(true);
        oval.setFillColor(HORIZONTAL_MOVE_COLOR);
        add(oval);
    }

    /**
     * Check if the click mouse by ball or not
     * @param x coordinate
     * @param y coordinate
     * @return null or the found oval
     */
    private GOval getCollidingObject(double x, double y) {
        GObject object = getElementAt(x, y);
        if (object != null) return (GOval) object;
        return null;
    }

    /**
     * Move ball, set the vertical/horizontal direction, color and velocity.
     * @index ball index in the array
     * */
    private void moveBall(int index) {
        double vx, vy;                                        /* Velocity by x and y direction*/
        GOval oval = movingBalls.get(index).oval;             /* Current ball*/
        boolean direction = movingBalls.get(index).direction; /* Vertical (true) or horizontal (false) direction*/
        double x = oval.getX() + diameterBall;                /* x coordinate of the ball*/
        double y = oval.getY() + diameterBall;                /* y coordinate of the ball*/

        if (direction) {
            vx = 0;
            /*Check if the ball hits wall change direction of velocity. Also set the ball color */
            changeColorCheckWalls(oval, index, y, true, getHeight(), VERTICAL_MOVE_COLOR);
            vy = movingBalls.get(index).reverse;

        } else {
            vy = 0;
            /*Check if the ball hits wall change direction of velocity. Also set the ball color */
            changeColorCheckWalls(oval, index, x, false, getWidth(), HORIZONTAL_MOVE_COLOR);
            vx = movingBalls.get(index).reverse;
        }
        oval.move(vx, vy);
    }

    /**
     * Check if the ball hits wall change direction of velocity. Also set the ball color
     * @param oval current oval
     * @param index index oval in array
     * @param coordinate x or y
     * @param direction true - vertical, false - horizontal
     * @param size getWidth (direction = false) or getHeight (direction = true)
     * @param clr the ball color
     */
    private void changeColorCheckWalls(GOval oval, int index, double coordinate,
                                       boolean direction, double size, Color clr) {
        MovingBalls item = new MovingBalls(oval, direction, -movingBalls.get(index).reverse);
        oval.setFillColor(clr);
        if (coordinate < diameterBall || coordinate >= size) {
            movingBalls.set(index, item);
        }
    }

    /**
     * Find index of the ball in the array
     * @param oval - current oval
     * @return index ball in the array
     */
    private int returnIndex(GOval oval) {
        for (int i = 0; i < movingBalls.size(); i++) {
            if (movingBalls.get(i).oval.equals(oval)) return i;
        }
        return -1;
    }

    /**
     * Fill the array of the moving balls
     * @param ballClicked clicked ball
     */
    private void arrayMovingBalls(GOval ballClicked) {
        MovingBalls item; /*Item in the moving ball array*/

        if (movingBalls.size() == 0) {
            item = new MovingBalls(ballClicked, false, VELOCITY);
            movingBalls.add(item);
        } else addNextMovingBall(movingBalls.size() >= MOVING_BALL, ballClicked);
    }

    /**
     * Add ball in the array. Before adding checks if the current ball exists in the array, just change its direction.
     * If the current ball doesn't exist in the array, checks the size of the array.
     * If the array size equals maximum, remove the first item and add the current ball.
     * @param fullArray
     * @param ballClicked
     */
    private void addNextMovingBall(boolean fullArray, GOval ballClicked) {
        MovingBalls item;
        boolean direction;
        int indexMovingBall = returnIndex(ballClicked);
        if (indexMovingBall != -1) {
            direction = !movingBalls.get(indexMovingBall).direction;
            item = new MovingBalls(ballClicked, direction, VELOCITY);
            movingBalls.set(indexMovingBall, item);
        } else {
            if (fullArray) movingBalls.remove(0);
            item = new MovingBalls(ballClicked, false, VELOCITY);
            movingBalls.add(item);
        }
    }
}
