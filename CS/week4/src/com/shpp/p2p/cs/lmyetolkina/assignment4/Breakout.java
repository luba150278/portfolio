package com.shpp.p2p.cs.lmyetolkina.assignment4;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class Breakout extends WindowProgram {
    // Width and height of application window in pixels
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;
    // Dimensions of game board (usually the same)
    private static final int WIDTH = APPLICATION_WIDTH;
    //Dimensions of the paddle
    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_HEIGHT = 10;
    //Offset of the paddle up from the bottom
    private static final int PADDLE_Y_OFFSET = 30;
    // Number of bricks per row
    private static final int NBRICKS_PER_ROW = 10;
    //Number of rows of bricks
    private static final int NBRICK_ROWS = 10;
    //Separation between bricks
    private static final int BRICK_SEP = 4;
    // Width of a brick
    private static final int BRICK_WIDTH =
            (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;
    // Height of a brick
    private static final int BRICK_HEIGHT = 8;
    //Radius of the ball in pixels
    private static final int BALL_RADIUS = 10;
    // Offset of the top brick row from the top
    private static final int BRICK_Y_OFFSET = 70;
    // Number of turns
    private static final int NTURNS = 3;
    //Summary width the all bricks
    private static final double WIDTH_ALL_BRICKS =
            NBRICKS_PER_ROW * BRICK_WIDTH + (NBRICKS_PER_ROW - 1) * BRICK_SEP;
    //x, y coordinate of the brick
    private static final double X_BRICK_COORD = BRICK_WIDTH + BRICK_SEP;
    private static final double Y_BRICK_COORD = BRICK_HEIGHT + BRICK_SEP;
    //Start pause time
    private static final double PAUSE_TIME = 15;
    //The velocity of the ball by y-coordinate
    private static final double VELOCITY_BY_Y = 4.0;
    //The velocity of the ball by x-coordinate (minimum and maximum value)
    private static final double MIN_VELOCITY_BY_X = 1.0;
    private static final double MAX_VELOCITY_BY_X = 3.0;
    //The change probability of the ball direction
    private static final double PROBABILITY_CHANGE_DIRECTION = 0.5;
    //Create paddle object
    private GRect paddle;
    //Create labels
    private GLabel remainBallsLabel, scoresLabel;
    //Create ball
    private GOval ball;
    //The counter of the remaining balls
    private int brickCounter = 0;
    //The game score counter
    private int gameScoreCounter = 0;
    //Define pause in the start moment
    private double pauseTime = PAUSE_TIME;
    //The velocity of ball by x, y coordinates
    private double vx, vy;
    //Color Array
    private HashMap<Integer, Color> colorMap = new HashMap<Integer, Color>();

    @Override
    /**
     * Change the paddle position with mouse move
     */
    public void mouseMoved(MouseEvent e) {
        //Get mouse position and define paddle coordinates
        double newX = e.getX() - paddle.getWidth() / 2;
        double newY = getHeight() - PADDLE_Y_OFFSET;
        //Don't let paddle goes out off app
        if (newX > 0 && (newX + PADDLE_WIDTH) < getWidth()) {
            paddle.setLocation(newX, newY);
            //Under the paddle we place information about the remaining balls and the game score
            remainBallsLabel.setLocation(newX, newY + 14 * 2);
            scoresLabel.setLocation(newX + remainBallsLabel.getWidth() + 10, newY + 14 * 2);
        }
    }

    /**
     * Run "Breakout" game
     */
    public void run() {
        addMouseListeners();                // Add mouse-events methods
        setColor();                         // Add colors to array
        while (true) {
            setGame();                         //Set bricks, score label, knocked-balls label
            playGame();                       //Start game
            finishGame();                      //Finish game
        }
    }

    /**
     * Create a color array. It will be used for set brick color.
     */
    private void setColor() {
        Color clr[] = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN};
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 2; j++) {
                int n;
                if (j % 2 != 0) {
                    n = 2 * i * j - 1;
                } else {
                    n = i * j;
                }
                colorMap.put(n, clr[i - 1]);
            }
        }
    }

    /**
     * Set the main game parameters and objects
     */
    private void setGame() {
        brickCounter = NBRICK_ROWS * NBRICKS_PER_ROW;                   //The starting value of the brick counter
        gameScoreCounter = 0;                                           //The starting value of the game score counter
        createBricks();                                                 //Create bricks
        paddle = createRectangle((getWidth() - PADDLE_WIDTH) / 2,    //Create paddle
                getHeight() - PADDLE_Y_OFFSET,
                PADDLE_WIDTH, PADDLE_HEIGHT, Color.BLACK);

        // Create label with knocked out balls
        remainBallsLabel = createLabel("" + brickCounter, Color.RED, 3);
        // Create label with scores of game
        scoresLabel = createLabel("" + gameScoreCounter, Color.GREEN, 3);
    }

    /**
     * Create bricks
     */
    private void createBricks() {

        double x = (getWidth() - WIDTH_ALL_BRICKS) / 2;                  //The x-position of the first brick
        double y = BRICK_Y_OFFSET;                                       //The y-position of the first brick

        //Create bricks and set the brick color depending on the number of the row
        for (int i = 0; i < NBRICK_ROWS; i++) {
            for (int j = 0; j < NBRICKS_PER_ROW; j++) {
                Color clr = colorMap.get(i + 1);
                createRectangle(x + j * X_BRICK_COORD, y + i * Y_BRICK_COORD, BRICK_WIDTH, BRICK_HEIGHT, clr);
            }
        }
    }

    /**
     * Create paddle and bricks
     *
     * @param x   - x-coordinate of a rectangle
     * @param y   - y-coordinate of a rectangle
     * @param w   - width of a rectangle
     * @param h   - height of a rectangle
     * @param clr - color and border-color of a rectangle
     * @return rectangle object
     */
    private GRect createRectangle(double x, double y, double w, double h, Color clr) {
        GRect Rect = new GRect(x, y, w, h);
        Rect.setFilled(true);
        Rect.setColor(clr);
        add(Rect);
        return Rect;
    }

    /**
     * Create labels. This method uses to create the all program labels.
     *
     * @param label_text - text of the label
     * @param clr        - color of the label
     * @param position   - place of the label: 1 - place on the center of window, 2 - between paddle and center,
     *                   3 - under paddle
     * @return label object
     */
    private GLabel createLabel(String label_text, Color clr, int position) {
        GLabel label = new GLabel(label_text, 0, 0);
        label.setColor(clr);
        double widthLabel = label.getWidth();
        double heightLabel = label.getHeight();
        label.setFont("Arial-14");
        if (position == 1) {                                                    //Use for the end game labels
            label.setFont("Arial-24");
            label.move((getWidth() - widthLabel) / 2, getHeight() / 2);
        } else if (position == 2) {                                              //Use for start game label
            label.move((getWidth() - widthLabel) / 2, getHeight() * 0.75 - heightLabel / 2);
            label.setFont("Arial-18");
        }
        add(label);
        return label;
    }

    /**
     * Create ball
     */
    private GOval createBall() {
        GOval Oval = new GOval((getWidth() - BALL_RADIUS * 2) / 2, getHeight() - PADDLE_Y_OFFSET - BALL_RADIUS * 3,
                BALL_RADIUS * 2, BALL_RADIUS * 2);
        Oval.setFilled(true);
        Oval.setColor(Color.RED);
        add(Oval);
        return Oval;
    }

    /**
     * Start the game
     */
    private void playGame() {

        for (int i = 0; i < NTURNS; i++) {
            //Create the label for the user about the start game and remove it when the game is starting.
            GLabel startGameLabel = createLabel("Click mouse to start " + (i + 1) + " of 3 games",
                    Color.RED, 2);

            if (i > 0) {
                remove(ball);                                   //Remove the ball from previous game
            }

            ball = createBall();                                //Create a ball

            waitForClick();                                     //Wait while the user click the mouse to start the game
            remove(startGameLabel);                             //Remove start game label
            moveBall();                                //Move the ball
            if (brickCounter == 0) {                            //Stop the game if all bricks are removed
                break;
            }
        }
    }

    /**
     * Finish the game
     */
    private void finishGame() {
        if (ball != null) remove(ball);
        //Choose finish label depending of the brick counter value
        if (brickCounter != 0) {
            createLabel("You fail!", Color.RED, 1);
        } else {
            createLabel("You win!", Color.GREEN, 1);
        }

        pause(2000);           //Make a two-second pause and propose the user start the next game
        removeAll();              //Delete all object before starting the new game
    }

    /**
     * Move the ball
     */
    private void moveBall() {
        setVelocity();
        //Move the ball while the bricks exist
        while (true) {
            ball.move(vx, vy);
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    //Check x,y-coordinates of the vertices of the square in which the circle (ball) is inscribed
                    double x = ball.getX() + 2 * BALL_RADIUS * j;
                    double y = ball.getY() + 2 * BALL_RADIUS * i;
                    //Create a collider object for checking kick the ball in other objects on canvas
                    GObject collider = getCollidingObject(x, y);
                    //A check if an object under x,y-coordinates. If object is paddle we change y-coordinate direction
                    // of the ball else we remove a brick and change y-coordinate direction
                    if (!checkBrickOrPaddleHit(collider)) break;
                }
            }
            //Break while cycle if break counter has value 0
            if (brickCounter == 0) break;
            if (!checkWallHit()) break;
            //Make pause for animation the ball
            pause(pauseTime);
        }
    }

    /**
     * Get the object under the x,y - coordinates
     *
     * @param x - x-coordinate of an object
     * @param y - y-coordinate of an object
     * @return object or null
     */
    private GObject getCollidingObject(double x, double y) {
        return getElementAt(x, y);
    }

    /**
     * Define the score for the current bricks level
     *
     * @param object
     * @return score for the current bricks level
     */
    private int gameScore(GObject object) {
        int maxScore = 10;
        int score = 0;
        Color clr = object.getColor();
        for (Map.Entry<Integer, Color> entry : colorMap.entrySet()) {
            if (entry.getValue().equals(clr)) {
                if (entry.getKey() % 2 == 0) {
                    score = maxScore - entry.getKey() + 2;
                } else {
                    score = maxScore - (entry.getKey() + 1);
                }
            }
        }
        return score;
    }

    /**
     * Set the x,y velocity of ball
     */
    private void setVelocity() {
        //Define y-coordinate velocity
        vy = VELOCITY_BY_Y;
        //Use the random generator to define x-coordinate velocity
        RandomGenerator rgen = RandomGenerator.getInstance();
        vx = rgen.nextDouble(MIN_VELOCITY_BY_X, MAX_VELOCITY_BY_X);
        if (rgen.nextBoolean(PROBABILITY_CHANGE_DIRECTION)) {
            vx = -vx;
        }
    }

    /**
     * Check if the ball hits one of the walls
     * @return false If the ball goes below the paddle
     */
    private boolean checkWallHit() {
        double x = ball.getX() + BALL_RADIUS;
        double y = ball.getY() + BALL_RADIUS;
        if (x > getWidth() - BALL_RADIUS || x < BALL_RADIUS) {
            vx = -vx;
        }
        if (y > getHeight() - PADDLE_Y_OFFSET || y < BALL_RADIUS) {
            if (y > getHeight() - PADDLE_Y_OFFSET) {
                return false;
            }
            vy = -vy;
        }
        return true;
    }

    /**
     * Check hit object. If it is brick, delete it and change game score label and count of brick label
     * @param collider - the object which was hit
     * @return
     */
    private boolean checkBrickOrPaddleHit(GObject collider) {
        if (collider != null) {
            if (collider != paddle) {
                brickCounter--;
                remainBallsLabel.setLabel("" + brickCounter);   //Change label with the count of brick
                gameScoreCounter += gameScore(collider);        //Find the game score
                scoresLabel.setLabel("" + gameScoreCounter);    //Change label with the game score
                remove(collider);                               //Delete the brick

                //Increase the velocity of the ball after deleting 10 bricks on 10 percent
                if (brickCounter % 10 == 0) {
                    pauseTime = pauseTime / 1.1;
                }
            }
            vy = -vy;
            return false;
        }
        return true;
    }
}
