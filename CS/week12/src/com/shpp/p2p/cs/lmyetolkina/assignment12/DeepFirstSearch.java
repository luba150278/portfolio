package com.shpp.p2p.cs.lmyetolkina.assignment12;

import java.awt.*;
import java.util.*;

/**
 * The class in which we create the graph and adjust it.
 *Next, we use the depth-first search algorithm to determine the number of people (objects) in the image.
 */
public class DeepFirstSearch {
    /*The hashmap consists of all image colors and their pixel frequencies. It was found in the "Colormap" class.*/
    private static final HashMap<Color, Integer> colorsMap = Colormap.colorsMap;
    private static final Color back = FindColors.back; //Background color
    private static final Color main = FindColors.main; //The main color
    private static final Color[][] imageColors = Colormap.imageColors; //The color array is created from the image.
    /*The sum of the integer value red, green, blue channels for the back and main colors*/
    private static final int rgbBack = FindColors.rgbBack;
    private static final int rgbMain = FindColors.rgbMain;

    private static final Set<Integer> visited = new HashSet<>(); //Visited graph vertexes.
    /*The vertices of the graph are only pixels painted in the primary color. The edges of the graph are colored pixels
     adjoining a given vertex (pixel). The number of pixels in contact with the vertex is determined by
     the location of the colored pixel and whether its "neighbors" are colored in the main color*/
    private static final TreeMap<Integer, ArrayList<Integer>> graph = new TreeMap<>();
    /*Sizes of the image in pixels. They were found in the "Colormap" class.*/
    private static final int rowsImage = Colormap.rowsImage;
    private static final int columnsImage = Colormap.columnsImage;

    /**
     * The main method calls helper methods that sequentially solve the problem described for the class
     */
    public static void main() {
        createGraph(); //Create graph
        correctGraph(); //Correct graph (delete vertexes with back color)
        System.out.println("The silhouettes count is " + findSilhouettes()); //Find the silhouettes.
                                                                         // This method call "deep first search" method.

    }

    /**
     * 1. We analyze the number of pixels with the main color.
     * 2. If there are less than 5% of the number of background pixels, then we consider that all these pixels
     * belong to the main color and add them to the graph.
     * 3. If the number of pixels of the primary color is more than 5%, then add to the graph those pixels
     * that either have the primary color, or have a color close to the primary one.
     * !We use continuous numbering of pixels ("index" variable), so it will be easier to determine the "neighbors".
     */
    private static void createGraph() {

        Color currentColor;
        int rgbColor;
        double deltaBack, deltaMain;
        int backColorCountPixels = Collections.max(colorsMap.values());
        int mainColorCountPixels = colorsMap.get(main);
        double colorsRatio = (double) mainColorCountPixels / (double) backColorCountPixels * 100;

        int index = 0;

        for (int i = 0; i < rowsImage; i++) {
            for (int j = 0; j < columnsImage; j++) {
                currentColor = imageColors[i][j];

                if (colorsRatio < 5) {
                    if (!currentColor.equals(back)) {
                        filterData(i, j, index);
                    }
                } else {
                    if (!currentColor.equals(back)) {
                        if (currentColor.equals(main)) {
                            filterData(i, j, index);
                        } else {
                            rgbColor = currentColor.getRed() + currentColor.getGreen() + currentColor.getBlue();
                            deltaBack = (rgbBack != 0)?Math.abs((rgbColor - rgbBack) / rgbBack):Math.abs((rgbBack - rgbColor) / rgbColor);
                            deltaMain = (rgbMain != 0) ? Math.abs((rgbColor - rgbBack) / rgbMain) :
                                    Math.abs((rgbColor - rgbBack) / rgbColor);
                            if (deltaMain > deltaBack) {
                                filterData(i, j, index);
                            }
                        }
                    }
                }
                index++;
            }
        }
    }

    /**
     * Filter data before adding to graph:
     *1. Corner pixels can touch three pixels.
     * 2. Edge pixels but not corner pixels can touch 5 pixels.
     * 3. Inner pixels can touch 8 pixels.
     * At the first stage, we use all neighboring pixels as the vertices associated with the colored pixel.
     * Next, we will remove the uncolored pixels from the graph.
     * @param i - Pixel position in row
     * @param j - Pixel position in column
     * @param index Pixel through number (index)
     */
    private static void filterData(int i, int j, int index) {
        int col = columnsImage;
        int rows = rowsImage;
        if (i == 0 && j == 0) {
            fillGraph(index, 1, 1, 3, 0); //Top left corner
        } else if (i == 0 && j == col - 1) {
            fillGraph(index, -1, 1, 3, 0); //Top right corner
        } else if (j == 0 && i == rows - 1) {
            fillGraph(index, 1, -1, 3, 0);//Down left corner
        } else if (j == col - 1 && i == rows - 1) {
            fillGraph(index, -1, -1, 3, 0);//Down right corner
        } else if (i == 0 && j != col - 1) {
            fillGraph(index, 1, 1, 5, 0);//Top edge cells (except for corner cells)
        } else if (i == rows - 1 && j != 0 && j != col - 1) {
            fillGraph(index, 1, -1, 5, 0);//Down edge cells (except for corner cells)
        } else if (j == 0 && i != rows - 1) {
            fillGraph(index, 1, 1, 5, 1);//Left edge cells (except for corner cells)
        } else if (j == col - 1 && i != 0 && i != rows - 1) {
            fillGraph(index, -1, 1, 5, 1);//Right edge cells (except for corner cells)
        } else {
            fillGraph(index, 1, 1, 8, 0);//Middle cells
        }
    }

    /**
     * Calculate the index of pixels associated with a colored pixel. Create graph.
     * @param index - Pixel through number (index)
     * @param h = -1 for left pixel, 1 to right pixel
     * @param v = - 1 for top pixel, 1 to down pixel
     * @param countCells - Count of possible connections
     * @param orient - 1 to left and right non-corner pixels, 0 - for all others
     */
    private static void fillGraph(int index, int h, int v, int countCells, int orient) {
        int col = columnsImage;
        ArrayList<Integer> ribs = new ArrayList<>();
        if (countCells == 3)//
        {
            ribs.add(index + h);
            ribs.add(index + col * v);
            ribs.add(index + col * v + h);
        }

        if (countCells == 5 && orient == 0) {
            ribs.add(index + col * v);
            for (int step = -1; step <= 1; step = step + 2) {
                ribs.add(index + h * step);
                ribs.add(index + col * v + h * step);
            }
        }

        if (countCells == 5 && orient == 1) {
            ribs.add(index + h);
            for (int step = -1; step <= 1; step = step + 2) {
                ribs.add(index + col * step);
                ribs.add(index + col * step + h);
            }
        }

        if (countCells == 8) {
            for (int step = -1; step <= 1; step = step + 2) {
                ribs.add(index + step);
                ribs.add(index + col * step);
                ribs.add(index + step * col - 1);
                ribs.add(index + step * col + 1);
            }
        }
        graph.put(index, ribs);
    }

    /**
     * Delete all non-colored to main color pixels from graph.
     */
    private static void correctGraph() {
        for (Integer x : graph.keySet()) {
            deleteBackPixels(graph.get(x), x);
        }
    }

    /**
     * Delete non-colored pixels connected with current colored pixel
     * @param connectedVertexes the array with connected vertexes
     * @param key current colored pixel
     */
    private static void deleteBackPixels(ArrayList<Integer> connectedVertexes, int key) {
        int countRemove = 0;

        Iterator<Integer> arrayIterator = connectedVertexes.iterator();
        while (arrayIterator.hasNext()) {
            Integer item = arrayIterator.next();
            if (!graph.containsKey(item)) {
                arrayIterator.remove();
                countRemove++;
            }
        }

        if (countRemove > 0 && connectedVertexes.size() > 0) graph.put(key, connectedVertexes);
    }

    /**
     * Start "deep first search" method. The method is recursive.
     * After executing the method, we remove small objects.
     *
     * @return count of people silhouettes
     */
    private static int findSilhouettes() {
        int object = 0;
        Set<Integer> sizeObjects = new HashSet<>(); //Length of number sum pixels - 100=3, 1000=4 etc
        int max; //max length of number
        ArrayList<Integer> objectCountPixels = new ArrayList<>(); //Count of the pixels in the each object

        int countPixels = visited.size();
        for (Integer key : graph.keySet()) {
            if (!visited.contains(key) && graph.size() != visited.size()) {
                deepFirstSearch(key);
                objectCountPixels.add(visited.size() - countPixels);
                countPixels = visited.size();
                if (graph.size() == countPixels) break;
            }
        }

        Collections.sort(objectCountPixels);

        for (Integer x : objectCountPixels) {
            sizeObjects.add(String.valueOf(x).length());
        }
        max = Collections.max(sizeObjects);

        for (Integer x : objectCountPixels) {
            if (String.valueOf(x).length() == max) object++;
        }

        return object;
    }

    /**
     * We iterate over the colored vertices in sequence. We move from the first colored vertex
     * to the vertices associated with it. We mark all the visited peaks.
     * After passing one edge, we return to the starting vertex and repeat the cycle.
     * If there are no vertices connected to the first vertex, then we have selected the first object.
     * We check the number of visited vertices and the total number of painted pixels.
     * If the values ​​do not match, then there are more objects in the image,
     * we repeat the algorithm for the next ones that are not associated with the first (or subsequent) vertex, if any.
     * @param vertex - the first or next colored (main color) pixel
     */
    private static void deepFirstSearch(int vertex) {
        visited.add(vertex);
        Iterator<Integer> connectedVertexes = graph.get(vertex).listIterator();
        int point;
        while (connectedVertexes.hasNext()) {
            point = connectedVertexes.next();
            if (graph.get(point) != null) {
                if (!visited.contains(point)) {
                    deepFirstSearch(point);
                }
            }
        }
    }
}
