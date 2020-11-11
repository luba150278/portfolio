package com.shpp.p2p.cs.dbobrovnitskiy.assignment13;

/**
 * This method is subject to erosion all objects of the binary image
 * Works with an image represented as an array of byte arrays
 */
public class Erosion {

    private static final double PERCENTAGE_OF_EROSION = 0.014;

    /**
     * This method is subject to erosion all objects of the binary image
     * Works with an image represented as an array of byte arrays
     *
     * @param image   - array of byte arrays containing a binary image
     * @param bigSize - area of an object in a binary image
     * @return - new array of byte arrays containing a binary image
     */
    public static byte[][] getErosionOfObjects(byte[][] image, int bigSize) {
        image = restoreBinaryView(image);
        return erosion(image, bigSize);
    }

    /**
     * Returns the value "1" to a white pixel
     *
     * @param image - array of byte arrays containing a binary image
     * @return - array of byte arrays containing a binary image
     */
    private static byte[][] restoreBinaryView(byte[][] image) {
        for (int y = 0; y < image[0].length; y++) {
            for (int x = 0; x < image.length; x++) {
                if (image[x][y] == 2) {
                    image[x][y] = 1;
                }
            }
        }
        return image;
    }

    /**
     * This method is subject to erosion all objects of the binary image
     *
     * @param image      - array of byte arrays containing a binary image
     * @param objectSize - area of an object in a binary image
     * @return - new array of byte arrays containing a binary image
     */
    private static byte[][] erosion(byte[][] image, int objectSize) {
        double cropSize = objectSize * PERCENTAGE_OF_EROSION / 100;
        for (int i = 0; i < (int) cropSize; i++) {
            erosionCycle(image);
            removeTracesOfErosion(image);
        }
        return image;
    }

    /**
     * This method does one iteration of erosion
     *
     * @param image - array of byte arrays containing a binary image
     */
    private static void erosionCycle(byte[][] image) {
        for (int x = 1; x < image.length - 1; x++) {
            for (int y = 1; y < image[0].length - 1; y++) {
                if (image[x][y] == 1 && AreTheNeighborsBlack(image, x, y)) {
                    image[x][y] = 2;
                }
            }
        }
    }

    /**
     * Determines if there is a black pixel in the neighborhood
     *
     * @param image       - array of byte arrays containing a binary image
     * @param coordinateX - X-axis coordinates in the image
     * @param coordinateY - Y-axis coordinates in the image
     * @return - true if present or false
     */
    private static boolean AreTheNeighborsBlack(byte[][] image, int coordinateX, int coordinateY) {
        if (image[coordinateX + 1][coordinateY] == 0) {                                        // Neighbor on the right
            return true;
        }
        if (image[coordinateX - 1][coordinateY] == 0) {                                        // Neighbor on the left
            return true;
        }
        if (image[coordinateX][coordinateY + 1] == 0) {                                        // Upstairs neighbor
            return true;
        }
        return image[coordinateX][coordinateY - 1] == 0;                                       //Downstairs neighbor
    }

    /**
     * Returns the black pixel value "0"
     *
     * @param image - array of byte arrays containing a binary image
     */
    private static void removeTracesOfErosion(byte[][] image) {
        for (int y = 0; y < image[0].length; y++) {
            for (int x = 0; x < image.length; x++) {
                if (image[x][y] == 2) {
                    image[x][y] = 0;
                }
            }
        }
    }
}
