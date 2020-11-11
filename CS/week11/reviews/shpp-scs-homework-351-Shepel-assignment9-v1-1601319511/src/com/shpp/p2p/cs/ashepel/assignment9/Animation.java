package com.shpp.p2p.cs.ashepel.assignment9;

import acm.graphics.GLabel;
import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/**
 * Launches the animation.
 */
public class Animation extends WindowProgram {

    /* Describes window parameters. */
    public static final int APPLICATION_WIDTH = 800;
    public static final int APPLICATION_HEIGHT = 800;

    /* Describes initial ball's parameters. */
    public static final double INITIAL_X_VELOCITY = 10;
    public static final double INITIAL_Y_VELOCITY = 20;
    public static final double INITIAL_SIZE = 200;

    /* Describes the animation parameters. */
    public static final int SIMULATION_TIME = 5000;
    public static final double INCREASING_COEFFICIENT = 1.3;
    public static final double DECREASING_COEFFICIENT = 0.8;

    /**
     * Launches the application.
     */
    public void run() {
        playWithBall();
    }

    /**
     * -- Creates the ball.
     * -- Adds ball to the window.
     * -- Animates ball.
     */
    private void playWithBall() {
        GOval ball = createBall();
        add(ball);
        playWith(ball);
        GLabel label = createLabel();
        add(label);
    }

    /**
     * Creates the ball from the GOval object.
     *
     * @return The ball that is the GOval object.
     */
    private GOval createBall() {
        double xCenter = (double) getWidth() / 2 - INITIAL_SIZE / 2;
        double yCenter = (double) getHeight() / 2 - INITIAL_SIZE / 2;
        GOval ball = new GOval(xCenter, yCenter, INITIAL_SIZE, INITIAL_SIZE);
        ball.setFilled(true);
        ball.setColor(Color.PINK);
        return ball;
    }

    /**
     * Creates the label in the center of the window.
     *
     * @return The label.
     */
    private GLabel createLabel() {
        GLabel label = new GLabel("To continue with the animation send SMS to 0506466057. " +
                "Use the secret promo code: 42.");
        label.setFont("Arial-20");
        double labelXCoordinate = (double) getWidth() / 2 - label.getWidth() / 2;
        double labelYCoordinate = (double) getHeight() / 2 - label.getAscent() / 2;
        label.setLocation(labelXCoordinate, labelYCoordinate);
        return label;
    }

    /**
     * Launches and stops the animation.
     *
     * The Animation stops when simulation time is left.
     * By default: @param SIMULATION_TIME = 5 seconds.
     *
     * @param ball The ball, that we are playing with.
     */
    private void playWith(GOval ball) {
        double xVelocity = INITIAL_X_VELOCITY;
        double yVelocity = INITIAL_Y_VELOCITY;
        boolean isBallIncreasing = true;
        double initialTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - initialTime < SIMULATION_TIME) {
            animate(ball, xVelocity, yVelocity, isBallIncreasing);
            xVelocity = changeXVelocity(ball, xVelocity);
            yVelocity = changeYVelocity(ball, yVelocity);
            isBallIncreasing = changeIncreasing(ball, isBallIncreasing);
        }
    }

    /**
     * Replaces the ball's x-component velocity by the reversed value,
     * when ball drops the wall.
     *
     * @param ball      The ball, that we are playing with.
     * @param xVelocity The x-component of the ball's velocity.
     *
     * @return The x-component of the ball's velocity.
     */
    private double changeXVelocity(GOval ball, double xVelocity) {
        if (isLeftWall(ball) || isRightWall(ball)) {
            return - 1 * xVelocity;
        }
        return xVelocity;
    }

    /**
     * Replaces the ball's y-component velocity by the reversed value,
     * when ball drops the wall.
     *
     * @param ball      The ball, that we are playing with.
     * @param yVelocity The y-component of the ball's velocity.
     *
     * @return The y-component of the ball's velocity.
     */
    private double changeYVelocity(GOval ball, double yVelocity) {
        if (isUpperWall(ball) || isLowerWall(ball)) {
            return - 1 * yVelocity;
        }
        return yVelocity;
    }

    /**
     * Controls the increasing of the ball.
     *
     * If ball is increasing at the moment and meets the wall,
     * it starts to decrease.
     *
     * If ball is decreasing at the moment and meets the wall,
     * it starts to increase.
     *
     * @param ball             The ball, that we are playing with.
     * @param isBallIncreasing The parameter that describes the ball.
     *                         If "true" the ball is increasing.
     *                         If "false" the ball is decreasing.
     *
     * @return The boolean value. Is ball increasing at the moment or not.
     */
    private boolean changeIncreasing(GOval ball, boolean isBallIncreasing) {
        if (isWallMet(ball)) {
            return !isBallIncreasing;
        }
        return isBallIncreasing;
    }

    /**
     * Animates the ball.
     *  -- Moves the ball.
     *  -- Increases or decreases the ball.
     *
     * @param ball             The ball, that we are playing with.
     * @param xVelocity        The x-component of the ball's velocity.
     * @param yVelocity        The y-component of the ball's velocity.
     * @param isBallIncreasing The parameter that describes the ball.
     *                         If "true" the ball is increasing.
     *                         If "false" the ball is decreasing.
     */
    private void animate(GOval ball, double xVelocity, double yVelocity, boolean isBallIncreasing) {
        ball.move(xVelocity, yVelocity);
        changeSize(ball, isBallIncreasing);
        pause(42);
    }

    /**
     * Changes the size of the ball.
     *
     * @param ball             The ball, that we are playing with.
     * @param isBallIncreasing The parameter that describes the ball.
     *                         If "true" the ball is increasing.
     *                         If "false" the ball is decreasing.
     */
    private void changeSize(GOval ball, boolean isBallIncreasing) {
        double oldSize = ball.getWidth();
        if (isBallIncreasing) {
            ball.setSize( INCREASING_COEFFICIENT * ball.getWidth(), INCREASING_COEFFICIENT * ball.getHeight());
        }
        else {
            ball.setSize( DECREASING_COEFFICIENT * ball.getWidth(), DECREASING_COEFFICIENT * ball.getHeight());
        }
        fixPosition(ball, oldSize);
    }

    /**
     * Fixes the ball's position.
     *
     * When ball's size is changed, its coordinates are still the same.
     * It makes animation less pleasant. Method calculates the offset
     * to improve this bug. The offset centers the ball relatively to
     * its previous size.
     *
     * @param ball    The ball, that we are playing with.
     * @param oldSize The previous size of the ball.
     */
    private void fixPosition(GOval ball, double oldSize) {
        ball.move((oldSize - ball.getWidth()) / 2, (oldSize - ball.getHeight()) / 2);
    }

    /**
     * Answers if ball is hitting the wall at the moment.
     *
     * @param ball The ball, that we are playing with.
     *
     * @return The boolean value that answers
     *         if ball is hitting the wall at the moment.
     */
    private boolean isWallMet(GOval ball) {
        return isLeftWall(ball) || isRightWall(ball) || isUpperWall(ball) || isLowerWall(ball);
    }

    /**
     * Answers if ball is hitting the left wall at the moment.
     *
     * @param ball The ball, that we are playing with.
     *
     * @return The boolean value that answers
     *         if ball is hitting the left wall at the moment.
     */
    private boolean isLeftWall(GOval ball) {
        return ball.getX() < 0;
    }

    /**
     * Answers if ball is hitting the right wall at the moment.
     *
     * @param ball The ball, that we are playing with.
     *
     * @return The boolean value that answers
     *         if ball is hitting the right wall at the moment.
     */
    private boolean isRightWall(GOval ball) {
        return ball.getX() > getWidth() - ball.getWidth();
    }

    /**
     * Answers if ball is hitting the upper wall at the moment.
     *
     * @param ball The ball, that we are playing with.
     *
     * @return The boolean value that answers
     *         if ball is hitting the upper wall at the moment.
     */
    private boolean isUpperWall(GOval ball) {
        return ball.getY() < 0;
    }

    /**
     * Answers if ball is hitting the lower wall at the moment.
     *
     * @param ball The ball, that we are playing with.
     *
     * @return The boolean value that answers
     *         if ball is hitting the lower wall at the moment.
     */
    private boolean isLowerWall(GOval ball) {
        return ball.getY() > getHeight() - ball.getHeight();
    }

}
