package com.shpp.p2p.cs.lmyetolkina.assignment13;

import java.awt.*;
import java.util.*;

/**
 * The class in which we create the graph and adjust it.
 * Next, we use the depth-first search algorithm to determine the number of people (objects) in the image.
 */
public class FindObjects {
    private final Set<Integer> visited = new HashSet<>(); //Visited graph vertices.
    /*The vertices are only pixels painted in the primary color.*/
    private final Set<Integer> vertices = new HashSet<>();
    int columns; //Count of the image columns
    private int[] queue; //the queue with the vertices

    /**
     * 1. We analyze the number of pixels with the main color.
     * 2. If there are less than 5% of the number of custom count pixels and size of image less than 1000px, then we consider that all these pixels
     * belong to the main color and add them to the vertex array.
     * 3. If the number of pixels of the primary color is more than 5% or size image more then 1000px, then add to the vertex array those pixels
     * that either have the primary color, or have a color close to the primary one.
     * !We use continuous numbering of pixels ("index" variable), so it will be easier to determine the "neighbors".
     */
    public void createVerticesArray(Color[][] imageColors, HashMap<Color, Integer> colorsMap, int rows, int cols,
                                    Color main, Color back, double rgbMain, double rgbBack) {
        /*Check the size image. If it <1000px use simplified algorithm finding the main/back colors*/
        int SIZE_IMAGE = 1000;
        /*The ratio of the pixels of the main color to the total number of pixels. If it < 5% use simplified algorithm
         finding the main/back colors.*/
        double COLOR_RATIO = 0.05;

        columns = cols;
        Color currentColor;
        double rgbColor;
        double deltaBack, deltaMain;
        int mainColorCountPixels = colorsMap.get(main);
        double colorsRatio = (double) mainColorCountPixels / (double) (rows * cols);
        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                currentColor = imageColors[i][j];

                if (colorsRatio < COLOR_RATIO && colorsMap.size() < SIZE_IMAGE) {
                    if (!currentColor.equals(back)) {
                        vertices.add(index);
                    }
                } else {
                    if (!currentColor.equals(back)) {
                        if (currentColor.equals(main)) {
                            vertices.add(index);
                        } else {
                            rgbColor = currentColor.getRed() + currentColor.getGreen() + currentColor.getBlue();
                            if (rgbColor > rgbBack) {
                                deltaBack = Math.abs(rgbBack - rgbColor) / rgbColor;
                            } else {
                                deltaBack = Math.abs(rgbBack - rgbColor) / rgbBack;
                            }

                            if (rgbColor > rgbMain) {
                                deltaMain = Math.abs(rgbMain - rgbColor) / rgbColor;
                            } else {
                                deltaMain = Math.abs(rgbMain - rgbColor) / rgbMain;
                            }

                            if (deltaMain < deltaBack)
                                vertices.add(index);
                        }
                    }
                }
                index++;
            }
        }
    }

    /**
     * Call the "Breadth First Search" method. The method is non-recursive.
     * After executing the method, we remove small objects.
     *
     * @return count of people silhouettes
     */
    public int findSilhouettes() {

        ArrayList<Integer> objectCountPixels = new ArrayList<>();//Count of the pixels in each object


        int countVisitedVertices = visited.size();//
        queue = new int[vertices.size()]; // the queue for all colored vertices

        /*Find the all objects*/
        for (int key : vertices) {
            if (!visited.contains(key) && vertices.size() != visited.size()) {
                breadthFirstSearch(key); // Call the "Breadth First Search" method
                //deepFirstSearch(key);
                /*Find the count of pixels in each of the object*/
                objectCountPixels.add(visited.size() - countVisitedVertices);
                countVisitedVertices = visited.size();
                if (vertices.size() == countVisitedVertices)
                    break;
            }
        }

        return filterObjects(objectCountPixels);
    }

    /**
     * Find the object with the max numbers of pixels. Compare all objects with the max object and sum just objects
     * with the count of pixels more than 10% from the max object.
     *
     * @param objectCountPixels - the array with all objects
     * @return the number of the "big" objects
     */
    private int filterObjects(ArrayList<Integer> objectCountPixels) {
        double FILTER = 0.1; //Calculate just objects >= 10% size from the max object
        int objects = 0; //The count of image objects
        int max; //max count pixels in object
        /*Filtered the objects by size*/
        Collections.sort(objectCountPixels);//sort
        max = Collections.max(objectCountPixels);
        Collections.reverse(objectCountPixels);

        /*The filter only leaves objects with at least 10% pixels than an object with the maximum number of pixels.*/
        for (Integer x : objectCountPixels) {
            if (FILTER < Double.valueOf(x) / (double) max)
                objects++;
        }
        return objects;
    }

    /**
     * Find the colored vertex connected with the current vertex
     *
     * @param vertex - the main vertex
     */
    private Set<Integer> findConnectedVertices(int vertex) {
        Set<Integer> connectedVertices = new HashSet<>();

        if (vertices.contains(vertex - 1)) {
            connectedVertices.add(vertex - 1);
        }
        if (vertices.contains(vertex + 1)) {
            connectedVertices.add(vertex + 1);
        }
        if (vertices.contains(vertex - columns)) {
            connectedVertices.add(vertex - columns);
        }
        if (vertices.contains(vertex + columns)) {
            connectedVertices.add(vertex + columns);
        }

        return connectedVertices;
    }

    /**
     * Go to the first colored vertex. We add it to the queue and to the array of visited vertices.
     * Find all the vertices connected with the current vertex. We also add them to the queue and
     * to the array of visited vertices. We move while we have unvisited connected vertices.
     *
     * @param vertex - the current vertex
     */
    private void breadthFirstSearch(int vertex) {
        Set<Integer> connectedVertices;
        visited.add(vertex);
        int countVerticesInHead = 0;
        int countVerticesInTail = 0;

        queue[countVerticesInTail++] = vertex; //Add the vertex to queue

        /*While have connected vertices*/
        while (countVerticesInHead < countVerticesInTail) {

            vertex = queue[countVerticesInHead++]; //the current vertex

            connectedVertices = findConnectedVertices(vertex); //Find colored vertices connected to the current vertex

            /*Add found colored connected vertices to visited vertices array and to queue*/
            for (int i : connectedVertices) {
                if (!visited.contains(i)) {
                    visited.add(i);
                    queue[countVerticesInTail++] = i;
                }
            }
        }
    }


    /**
     * We iterate over the colored vertices in sequence. We move from the first colored vertex
     * to the vertices associated with it. We mark all the visited peaks.
     * After passing one edge, we return to the starting vertex and repeat the cycle.
     * If there are no vertices connected to the first vertex, then we have selected the first object.
     * We check the number of visited vertices and the total number of painted pixels.
     * If the values ​​do not match, then there are more objects in the image,
     * we repeat the algorithm for the next ones that are not associated with the first (or subsequent) vertex, if any.
     *
     * @param vertex - the first or next colored (main color) pixel
     */
    private void deepFirstSearch(int vertex) {
        Set<Integer> connectedVertices;
        visited.add(vertex);
        connectedVertices = findConnectedVertices(vertex); //Find the colored vertex connected with main vertex

        for (int i : connectedVertices) {
            if (!visited.contains(i)) deepFirstSearch(i);
        }
    }
}
