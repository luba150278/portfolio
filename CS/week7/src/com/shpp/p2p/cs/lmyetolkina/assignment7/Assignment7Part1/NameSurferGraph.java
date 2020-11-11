package com.shpp.p2p.cs.lmyetolkina.assignment7.Assignment7Part1;

/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes
 * or the window is resized.
 */

import acm.graphics.*;

import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
        implements NameSurferConstants, ComponentListener {

    private final HashMap<NameSurferEntry, Color> entryListColor = new HashMap<>();
    private final Color[] colors = new Color[]{Color.BLUE, Color.RED, Color.MAGENTA, Color.BLACK};
    private int widthChart;
    private int widthCell;
    private int heightCell;
    /*If was deleted one of the graphs, use color the last deleted graph for the next graph */
    private Color lastColor;
    /*Checking the list entry deletion*/
    boolean deleteEntry = false;
    private String labelText;
    /*max y-coordinate for chart */
    private double maxY;

    /**
     * Creates a new NameSurferGraph object that displays the data.
     */
    public NameSurferGraph() {
        addComponentListener(this);
    }

    /**
     * Clears the list of name and graph
     */
    public void clear() {
        lastColor = colors[0];
        /*Clear list */
        entryListColor.clear();
        /*Repaint grid*/
        update();
    }

    /**
     * Adds a new NameSurferEntry to the list of entries on the display.
     * Choose a color for each entry.
     * Note that this method does not actually draw the graph, but
     * simply stores the entry; the graph is drawn by calling update.
     */
    public void addEntry(NameSurferEntry entry) {
        /*Use the if-construction to exclude the duplicate records */
        if (entryListColor.size() == 0 || entryListColor.get(entry) == null) {
            /*If was deleted one of the graphs, use color the last deleted graph for the next graph
            or find the color use "findColor" function*/
            //if (!deleteEntry) {
            lastColor = findColor(entryListColor.size());
            // }
            /*Add new item to the hashmap*/
            entryListColor.put(entry, lastColor);
            /*Repaint grid and graphs*/
            update();
        }
    }


    /**
     * Updates the display image by deleting all the graphical objects
     * from the canvas and then reassembling the display according to
     * the list of entries. Your application must call update after
     * calling either clear or addEntry; update is also called whenever
     * the size of the canvas changes.
     */
    public void update() {
        /*Clear canvas*/
        removeAll();
        /*Find the width and height of the chart*/
        widthChart = getWidth() - GRAPH_MARGIN_SIZE * 3;
        int heightChart = getHeight();
        /*Find the width and height one of the cells into the chart*/
        widthCell = widthChart / NDECADES;
        heightCell = heightChart / MAX_RANK_X;
        /*Draw the grid and the text labels on the chart*/
        drawGrid();
        /*Draw the graphs for all entries*/
        if (entryListColor.size() != 0) {
            drawGraphs();
            deleteEntry = false;
        }
    }

    /* Implementation of the ComponentListener interface */
    public void componentHidden(ComponentEvent e) {
    }

    public void componentMoved(ComponentEvent e) {
    }

    /*Clear the canvas and repaint all*/
    public void componentResized(ComponentEvent e) {
       update();
    }

    public void componentShown(ComponentEvent e) {
    }

    /**
     * Draw the chart grid and text labels
     */
    private void drawGrid() {
        maxY = (double) (heightCell * MAX_RANK) / 100.0;
        String lbText;
        Color clr;
        double x;
        double y;

        /*Vertical lines and labels*/
        y = START_POINT + maxY;
        for (int i = 0; i < NDECADES; i++) {
            x = START_POINT + i * widthCell;
            drawLines(x, START_POINT, x, y, Color.BLACK);

            lbText = String.valueOf(START_DECADE + i * 10);
            clr = new Color(20, 63, 2);
            drawLabels(lbText, i * widthCell, y, clr, true);
        }

        /*Horizontal lines and labels*/
        x = START_POINT + MAX_RANK_X * widthCell;
        for (int i = 0; i < MAX_RANK_X; i++) {
            y = START_POINT + i * heightCell;
            drawLines(START_POINT, y, x, y, Color.BLACK);

            lbText = String.valueOf(i * 100);
            clr = new Color(7, 52, 81);
            drawLabels(lbText, 0, y, clr, false);
        }
    }

    /**
     * Draw graphs for all entry list. The graphs contain the points, lines and text labels.
     * Use the "rankPoints" function for drawing.
     */
    private void drawGraphs() {

        Color clr;
        String name;

        /*Navigate to hashmap use the name, ranks and color information to draw graphs*/
        for (Map.Entry<NameSurferEntry, Color> entry : entryListColor.entrySet()) {
            clr = entry.getValue(); /*The text label, point anf line color */
            name = entry.getKey().getName();
            rankPoints(clr, name, entry.getKey());
        }
    }

    /**
     * Navigate for all ranks and draw he points, lines and text labels.
     * If the value of rank equals zero, points doesn't draw.
     *
     * @param clr   - color
     * @param name  - name
     * @param entry - entry from hashmap
     */
    void rankPoints(Color clr, String name, NameSurferEntry entry) {

        int rank1;
        int rank2;
        double x1;
        double y1;
        double x2;
        double y2 = 0;

        for (int i = 0; i < NDECADES; i++) {
            /*Find x-coordinate for point.*/
            x1 = START_POINT + i * widthCell;
            /*Find rank for the first point*/
            rank1 = entry.getRank(i);

            /*Find y-coordinate for point, draw point and define the label text*/
            y1 = findY(rank1, name, true);
            drawPoints(x1 - POINT_RADIUS, y1 - POINT_RADIUS, clr);

            /*Find the second point for line and draw line*/
            if (i < NDECADES - 1) {
                rank2 = entry.getRank(i + 1);
                y2 = findY(rank2, "", false);
                x2 = START_POINT + (i + 1) * widthCell;
                drawLines(x1, y1, x2, y2, clr);
            }

            /*Define shift the labels so that they do not intersect with lines and draw them*/
            x1 += POINT_DIAMETER;
            if (!(y2 > y1 || rank1 == 0)) {
                y1 += POINT_DIAMETER * 2;
            }
            drawLabels(labelText, x1, y1, clr, false);
        }
    }

    /**
     * Find y-coordinate for points
     *
     * @param rank            - use integer value to convert the pixels.
     * @param name            - name for text label
     * @param createTextLabel - if equals true create label text
     * @return y-coordinate by pixel
     */
    private double findY(int rank, String name, boolean createTextLabel) {
        if (rank == 0) {
            if (createTextLabel) labelText = name + "*";
            return maxY + START_POINT;
        } else {
            if (createTextLabel) labelText = name + " " + rank;
            return (double) rank / 1000.0 * maxY + START_POINT;
        }
    }

    /**
     * Draw the all lines: grid line and graphs line
     *
     * @param x1  - x-coordinate the first point
     * @param y1  - y-coordinate the first point
     * @param x2  - x-coordinate the second point
     * @param y2  - y-coordinate the second point
     * @param clr - the color of the line
     */
    private void drawLines(double x1, double y1, double x2, double y2, Color clr) {
        GLine line = new GLine(x1, y1, x2, y2);
        line.setColor(clr);
        add(line);
    }

    /**
     * Draw the all text labels
     *
     * @param lbText - label text
     * @param x      - x-coordinate
     * @param y      - y-coordinate
     * @param clr    - the label color
     * @param move   - boolean: true - shift label
     */
    private void drawLabels(String lbText, double x, double y, Color clr, boolean move) {
        int fontSize = (widthChart <= 800) ? (int) (widthCell * 0.2) : (int) (widthCell * 0.15);
        Font font = new Font("Arial", Font.PLAIN, fontSize);
        GLabel lb = new GLabel(lbText, x, y);
        if (move) lb.move(START_POINT, lb.getHeight());
        lb.setColor(clr);
        lb.setFont(font);
        add(lb);
    }

    /**
     * Draw the points. Points are the ovals. Draw them for more visibility.
     *
     * @param x   - x-coordinate
     * @param y   - y-coordinate
     * @param clr - the point color
     */
    private void drawPoints(double x, double y, Color clr) {
        GOval oval = new GOval(x, y, POINT_DIAMETER, POINT_DIAMETER);
        oval.setFilled(true);
        oval.setColor(clr);
        add(oval);
    }

    /**
     * Use the four colors that are defined in the array.
     * The function determines the alternation of these colors.
     *
     * @param size - the hashmap size
     * @return the color points, lines and labels each entry
     */
    private Color findColor(int size) {
        if (deleteEntry) return lastColor;
        int index = size - size / 4 * 4;
        return colors[index];
    }

    /**
     * Remove one of entry from hashmap. After remove repaint grid and graphs.
     * Save the color of deleted item.
     *
     * @param name - text from "name" field
     */
    public void removeEntry(String name) {
        String nameInList;
        NameSurferEntry itemDataBase;

        for (Map.Entry<NameSurferEntry, Color> entry : entryListColor.entrySet()) {
            itemDataBase = entry.getKey();
            nameInList = itemDataBase.getName().toLowerCase();
            if (name.toLowerCase().equals(nameInList)) {
                lastColor = entry.getValue();
                entryListColor.remove(itemDataBase);
                update();
                deleteEntry = true;
                break;
            }
        }
    }
}
