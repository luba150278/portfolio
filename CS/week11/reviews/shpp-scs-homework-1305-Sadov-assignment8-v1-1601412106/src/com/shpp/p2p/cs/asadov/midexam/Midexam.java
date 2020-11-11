package com.shpp.p2p.cs.asadov.midexam;

import acm.graphics.GRect;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Midexam extends WindowProgram {

    /**
     * Width and height of application window in pixels
     */
    public static final int APPLICATION_WIDTH = 650;
    public static final int APPLICATION_HEIGHT = 350;

    /**
     * Number of cells per row
     */
    private static final int CELLS_PER_ROW = 30;

    /**
     * Number of rows of cells
     */
    private static final int CELLS_ROWS = 20;

    /**
     * number of grains
     */
    private static final int GRAINS_NUMBER = 15;

    /**
     * Pause duration between frames
     */
    private static final int PAUSE = 1000;

    /**
     * Colors of cells
     */
    private static final Color[] COLORS = {Color.WHITE, Color.BLACK, Color.BLUE, Color.GREEN};

    /**
     * Mnemonics of colors
     */
    private static final int AIR = 0;
    private static final int GRANE = 1;
    private static final int WATER = 2;
    private static final int PLANT = 3;

    // Random generator
    RandomGenerator rgen = RandomGenerator.getInstance();
    // cell dimension
    private double cellDimension;
    // matrix of cells
    private int[][] matrix;

    // offset from windows edges to matrix
    private double xOffset;
    private double yOffset;

    /**
     * This method starts the program
     */
    public void run() {
        initialize();
        addMouseListeners();
        while (true)
            animate();
    }

    /**
     * This method initialises program.
     * init() not used because we need real dimensions of window
     */
    private void initialize() {
        calcInitialParameters();
        setBackground(Color.DARK_GRAY);
        initMatrix();
        setGrains();
    }

    /**
     * Calcs cell dimension and offsets of matrix from window edges
     */
    private void calcInitialParameters() {
        double cellWidth = (double) getWidth() / CELLS_PER_ROW;
        double cellHeight = (double) getHeight() / CELLS_ROWS;
        cellDimension = Math.min(cellWidth, cellHeight);
        //set matrix to center
        xOffset = (getWidth() - cellDimension * CELLS_PER_ROW) / 2.0;
        yOffset = (getHeight() - cellDimension * CELLS_ROWS) / 2.0;

    }

    /**
     * This method initialise matrix array and draws matrix of air
     */
    private void initMatrix() {
        matrix = new int[CELLS_PER_ROW][CELLS_ROWS];
        for (int i = 0; i < CELLS_ROWS; i++) {
            for (int j = 0; j < CELLS_PER_ROW; j++) {
                drawCell(xOffset + j * cellDimension, yOffset + i * cellDimension, COLORS[AIR]);
                matrix[j][i] = AIR;
            }
        }
    }

    /**
     * This method sets grains randomly
     */
    public void setGrains() {
        int i = 0;
        while (i < GRAINS_NUMBER) {
            int col = rgen.nextInt(CELLS_PER_ROW);
            int row = rgen.nextInt(CELLS_ROWS);
            // not in same cell
            if (matrix[col][row] == GRANE)
                continue;
            setCellValueByMatrix(col, row, GRANE);
            i++;
        }
    }


    /**
     * This method redraws matrix
     */
    // TODO: method needs in decomposition
    private void animate() {
        for (int i = CELLS_ROWS - 1; i >= 0; i--) {                    // starts from bottom
            for (int j = 0; j < CELLS_PER_ROW; j++) {
                if (matrix[j][i] == GRANE && i != CELLS_ROWS - 1) {    // grain animation
                    setCellValueByMatrix(j, i, AIR);
                    if (matrix[j][i + 1] != AIR)
                        continue;
                    setCellValueByMatrix(j, i + 1, GRANE);
                } else if (matrix[j][i] == WATER) {                     // water animation
                    if (i == CELLS_ROWS - 1) {                          // last row
                        setCellValueByMatrix(j, i, AIR);
                        continue;
                    }
                    if (matrix[j][i + 1] == AIR) {                      // next cell is empty
                        setCellValueByMatrix(j, i, AIR);
                        setCellValueByMatrix(j, i + 1, WATER);
                        continue;
                    }
                                                                        // next cell is grane or plant
                    if (matrix[j][i + 1] == GRANE || matrix[j][i + 1] == PLANT) {
                        setCellValueByMatrix(j, i, PLANT);
                        if (matrix[j][i + 1] == GRANE)
                            setCellValueByMatrix(j, i + 1, PLANT);
                    }
                }
            }
        }
        pause(PAUSE);
    }

    /**
     * This method returns GRect that related to element of array [column][row]
     * @param column
     * @param row
     * @return
     */
    private GRect getCellByMatrix(int column, int row) {
        return (GRect) getElementAt(xOffset + column * cellDimension + 1,
                yOffset + row * cellDimension + 1);
    }

    /**
     * This method set value to array and set color of GRect
     * that related to element of array [column][row]
     * @param column
     * @param row
     * @param value
     */
    private void setCellValueByMatrix(int column, int row, int value) {
        matrix[column][row] = value;
        GRect obj = getCellByMatrix(column, row);
        obj.setFillColor(COLORS[value]);
    }

    /**
     * This method draws cell in coordinates x, y with color
     * @param x
     * @param y
     * @param color
     */
    private void drawCell(double x, double y, Color color) {
        GRect cell = new GRect(x, y, cellDimension, cellDimension);
        cell.setFilled(true);
        cell.setFillColor(color);
        add(cell);
    }

    public void mouseClicked(MouseEvent e) {
        GRect obj = (GRect) getElementAt(e.getX(), e.getY());
        if (obj != null && getMatrixValueByCoords(e.getX(), e.getY()) == AIR) {
            obj.setFillColor(COLORS[WATER]);
            setMatrixValueByCoords(e.getX(), e.getY(), WATER);
        }
    }

    private int getMatrixValueByCoords(double x, double y) {
        int column = (int) ((x - xOffset) / cellDimension);
        int row = (int) ((y - yOffset) / cellDimension);
        return matrix[column][row];
    }

    private void setMatrixValueByCoords(double x, double y, int value) {
        int column = (int) ((x - xOffset) / cellDimension);
        int row = (int) ((y - yOffset) / cellDimension);
        matrix[column][row] = value;
    }

}
