package com.shpp.p2p.cs.lmyetolkina.assignment3;

import acm.graphics.GRect;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/**I'll be to create animation inscription "P2P".
The inscription hand-transforms to array from 0 and 1.
The values of the array equal 1 will create colored cells. These cell colors will randomly generate.
The values of the array equal 0 will create white cells.
Cells are rectangles.
*/
public class Assignment3Part6 extends WindowProgram {
    /* The number of rows and columns in the grid, respectively. */
    private static final int NUM_ROWS = 9;
    private static final int NUM_COLS = 20;
    /* The width and height of each cell. */
    private static final int CELL_SIZE = 50;
    /* The horizontal and vertical spacing between the cells. */
    private static final int CELL_SPACING = 1;
    /* The sum the cell size and cell space is the distance between the left-top corner of previous and next cells. */
    private static final int STEP = CELL_SIZE + CELL_SPACING;
    /* Summary width and height of all cells */
    private static final int WIDTH_FIELD = NUM_COLS * CELL_SIZE + (NUM_COLS - 1) * CELL_SPACING;
    private static final int HEIGHT_FIELD = NUM_ROWS * CELL_SIZE + (NUM_ROWS - 1) * CELL_SPACING;
    /*Summary application size*/
    private static final int APP_WIDTH = WIDTH_FIELD + 100;
    private static final int APP_HEIGHT = HEIGHT_FIELD + 100;
    /*Create the inscription "P2P" using 0 and 1. It is array from 9 (NUM_ROWS) rows and 20 columns (NUM_COLS)*/
    private static final byte[][] DATA_CELLS;

    static {
        DATA_CELLS = new byte[][]{
                {1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0},
                {1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1},
                {1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1},
                {1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1},
                {1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0}
        };
    }

    /*Array "DATA_CELL" consists of 100 values to equal 1*/
    private static final int COUNT_COLOR_CELL = 100;
    /*How long time will be duration animation*/
    private static final int TIMER_DURATION = 5000;
    /*Pause between draw colored cells */
    private static final int PAUSE_TIME = TIMER_DURATION / COUNT_COLOR_CELL;

    /**
     * Draw and animate the inscription "P2P"
     */
    public void run() {

        setSize(APP_WIDTH, APP_HEIGHT);                            /*Resize application sizes*/
        drawAnimate();                                             /*Draw and animate the cells of the inscription*/
    }

    /**
     *Draw and animate the cells of the inscription
     */
    private void drawAnimate() {
        /*Coordinates of the first cell(rectangle)*/
        double x = (getWidth() - WIDTH_FIELD) / 2;
        double y = (getHeight() - HEIGHT_FIELD) / 2;

        /*Use two cycles to draw a rectangle. Check array values.
        If the value is 1 we draw a random colored rectangle and makes a pause ,
        else we make a white-colored rectangle and no make pause.*/
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                addRectangle(x + j * STEP, y + i * STEP, DATA_CELLS[i][j]);
                if (DATA_CELLS[i][j] == 1) {
                    pause(PAUSE_TIME);
                }
            }
        }
    }

    /**
     * Add rectangle. In depending on DATA_CELLS array value use white or random-generate color
     * @param x - x-coordinate of rectangle
     * @param y - y-coordinate of rectangle
     * @param notZeroValueCell - The value of cell DATA_CELLS array. If it equal 0 fill the rectangle white color,
     *                         otherwise use random-generated color
     */
    private void addRectangle(double x, double y, int notZeroValueCell) {
        GRect rectangle = new GRect(x, y, CELL_SIZE, CELL_SIZE);
        Color color;
        if (notZeroValueCell == 1) {
            color = generate_color();
        } else {
            color = Color.WHITE;
        }
        rectangle.setFilled(true);
        rectangle.setColor(color);
        add(rectangle);
    }

    /**
     * Generate color using random generator
     */
    private Color generate_color() {
        return new Color(random(), random(), random());
    }

    /**
     * Random generator integer number from 0 to 255
     */
    private int random(){
        return RandomGenerator.getInstance().nextInt(255);
    }
}
