package com.shpp.p2p.cs.dbobrovnitskiy.assignment13;

import java.util.ArrayList;

/**
 * This class counts the number of objects in a binary image
 * which is represented as an array of bytes arrays
 */
public class CountingObjects {

    private static final double GARBAGE_INDEX = 0.2; // percentage(%) of image area

    private byte[][] binaryImage;
    private ArrayList<int[]> queue;
    public int largestObject;

    /**
     * Class constructor
     *
     * @param binaryImage - array of bytes arrays containing a binary image
     */
    public CountingObjects(byte[][] binaryImage) {
        this.binaryImage = binaryImage;
        if (isItBackgroundWhite()) {
            invertBackground();
        }
//        getObjectsCount();                                                         //used for stuck together objects
//        this.binaryImage = Erosion.getErosionOfObjects(binaryImage, largestObject);//used for stuck together objects
    }

    /**
     * This method inverts the image
     */
    private void invertBackground() {
        for (int width = 0; width < binaryImage.length; width++) {
            for (int height = 0; height < binaryImage[0].length; height++) {
                if (binaryImage[width][height] == 1) {
                    binaryImage[width][height] = 0;
                } else {
                    binaryImage[width][height] = 1;
                }
            }
        }
    }

    /**
     * This method returns true if the background is white or false if the background is black
     * Uses the "howManyWhitePixels" method to determine the background
     *
     * @return true if the background is white
     */
    private boolean isItBackgroundWhite() {
        return getWhitePixelsCount() > binaryImage[0].length + binaryImage[0].length;             // Background - white
    }

    /**
     * This method calculates how many white pixels are around the perimeter
     *
     * @return - number of white pixels
     */
    private int getWhitePixelsCount() {
        int result = 0;
        // left and right side
        for (int i = 0; i < binaryImage.length; i = i + (binaryImage.length - 1)) {
            for (int height = 0; height < binaryImage[0].length; height++) {
                if (binaryImage[i][height] == 1) {
                    result++;
                }
            }
        }
        // top and bottom side
        for (int i = 0; i < binaryImage[0].length; i = i + (binaryImage[0].length - 1)) {
            for (int width = 0; width < binaryImage.length; width++) {
                if (binaryImage[width][i] == 1) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * This method finds and processes objects
     * For this it uses the method "processObject"
     * Weeds out garbage using a variable "processedPixelCounter"
     * The area of the largest object is written to the variable "largestObject"
     *
     * @return - number of objects in the picture
     */
    public int getObjectsCount() {
        int result = 0;
        for (int width = 0; width < binaryImage.length; width++) {
            for (int height = 0; height < binaryImage[0].length; height++) {
                if (binaryImage[width][height] == 1) {
                    int processedPixelCounter = processObject(width, height);
                    if (processedPixelCounter > (binaryImage.length * binaryImage[0].length) * (GARBAGE_INDEX / 100)) {
                        result++;
                    }
                    if (processedPixelCounter > largestObject) {
                        largestObject = processedPixelCounter;
                    }
                }
            }
        }
        return result;
    }

    /**
     * Processes pixels taken from the queue
     * Which is formed using the "processPixel" method
     *
     * @param coordinateX - X-axis coordinates in the image
     * @param coordinateY - Y-axis coordinates in the image
     * @return - object area
     */
    private int processObject(int coordinateX, int coordinateY) {
        queue = new ArrayList<>();
        queue.add(new int[]{coordinateX, coordinateY});
        for (int i = 0; i < queue.size(); i++) {
            processPixel(queue.get(i)[0], queue.get(i)[1]);
        }
        return queue.size();
    }

    /**
     * Adds adjacent pixels to the queue in turn
     * The exception is - if the pixel is already in the queue
     *
     * @param coordinateX - X-axis coordinates in the image
     * @param coordinateY - Y-axis coordinates in the image
     */
    private void processPixel(int coordinateX, int coordinateY) {
        binaryImage[coordinateX][coordinateY] = 2;
        if (binaryImage[0].length - 1 != coordinateY && binaryImage[coordinateX][coordinateY + 1] == 1) {    //step down
            binaryImage[coordinateX][coordinateY + 1] = 2;
            queue.add(new int[]{coordinateX, coordinateY + 1});
        }
        if (0 != coordinateY && (binaryImage[coordinateX][coordinateY - 1] == 1)) {                          //step up
            binaryImage[coordinateX][coordinateY - 1] = 2;
            queue.add(new int[]{coordinateX, coordinateY - 1});
        }
        if (binaryImage.length - 1 != coordinateX && binaryImage[coordinateX + 1][coordinateY] == 1) {       //step right
            binaryImage[coordinateX + 1][coordinateY] = 2;
            queue.add(new int[]{coordinateX + 1, coordinateY});
        }
        if (0 != coordinateX && binaryImage[coordinateX - 1][coordinateY] == 1) {                            //step left
            binaryImage[coordinateX - 1][coordinateY] = 2;
            queue.add(new int[]{coordinateX - 1, coordinateY});
        }
    }
}
