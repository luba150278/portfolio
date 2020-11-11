package com.shpp.p2p.cs.vkolisnicheno.assignment12;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

/**
 * A class that implements the depth-first
 * search algorithm, and will count the
 * number of people in the image
 */
public class Assignment12Part1 {

    //Variable counters that are needed to implement the algorithm
    private static int i, j;

    /**
     * A method in which we find the number of
     * silhouettes of people or throw an error
     *
     * @param args - program arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println(findSilhouettes(args));
        } catch (Exception e) {
            System.err.println("File not found");
        }

    }

    /**
     * The method in which we go through the array,
     * and using the depth-to-depth algorithm,
     * we determine the number of silhouettes
     * of people in the image
     *
     * @param args - program arguments
     * @return - number of silhouettes
     * @throws Exception - method can throw exception
     */
    private static int findSilhouettes(String[] args) throws Exception {
        //variable which is responsible for the number of silhouettes
        int numberOfSilhouettes = 1;

        //Get an array of rgb values
        int[][] rgbValues = convertToGetRGB((BufferedImage) (image(args)));

        // The array with which we mark the passed pixels
        boolean[][] used = new boolean[rgbValues.length][rgbValues[0].length];

        //We go through the array of rgb values
        for (i = 0; i < rgbValues.length; i++) {
            for (j = 0; j < rgbValues[i].length; j++) {
                //check if the pixel is equal to the background color
                if (rgbValues[i][j] != backgroundColor(rgbValues) && !used[i][j]) {
                    depthFirstSearch(rgbValues, used);
                    if (i > 0 && j > 0)
                        if (!used[i - 1][j] && !used[i][j - 1])
                            numberOfSilhouettes++;
                }
            }
        }
        return numberOfSilhouettes;
    }

    /**
     * A method that implements the depth-first
     * search algorithm, marking all passed pixels
     * and going deeper until there is a background
     *
     * @param rgb  - Rgb picture values
     * @param used - a boolean array which marks the passed pixels
     */
    private static void depthFirstSearch(int[][] rgb, boolean[][] used) {
        //go deeper along the x coordinate
        if (i < rgb.length - 1)
            if (rgb[i + 1][j] != backgroundColor(rgb) && !used[i + 1][j]) {
                used[i][j] = true;
                i++;
                depthFirstSearch(rgb, used);
            }

        //go deeper along the y coordinate
        if (j < rgb[0].length - 1)
            if (rgb[i][j + 1] != backgroundColor(rgb) && !used[i][j + 1]) {
                used[i][j] = true;
                j++;
                depthFirstSearch(rgb, used);
            }

        //go deeper diagonally
        if (i < rgb.length - 1 && j < rgb[0].length - 1)
            if (rgb[i + 1][j + 1] != backgroundColor(rgb) && !used[i + 1][j + 1]) {
                used[i][j] = true;
                i++;
                j++;
                depthFirstSearch(rgb, used);
            }

        //mark the pixel
        if (!used[i][j]) used[i][j] = true;
    }

    /**
     * The method in which we get the rgb value
     * of the background in the image starting
     * from the rgb values of the 1st row
     *
     * @param rgb - Rgb array of image values
     * @return - Background value
     */
    private static int backgroundColor(int[][] rgb) {
        int[] row = new int[rgb[1].length];

        //Create sheets for storing values
        ArrayList<Integer> background = new ArrayList<Integer>();
        ArrayList<Integer> otherBackground = new ArrayList<>();

        //We write values to the array
        for (int i = 1; i < 2; i++) {
            for (int j = 0; j < rgb[1].length; j++) {
                row[j] = rgb[i][j];
            }
        }

        //Create variables that we will return
        int mainBackground = row[0];
        int reservBackground = 0;

        //We fulfill the necessary conditions for determining the background color
        for (int i = 0; i < row.length; i++) {
            if (row[i] == mainBackground)
                background.add(i);
            else if (row[i] != mainBackground) {
                otherBackground.add(row[i]);
                reservBackground = row[i];
            }
        }
        if (background.size() > rgb[1].length / 2) return mainBackground;
        else if (background.size() < rgb[1].length / 2) return reservBackground;

        return -100;
    }

    /**
     * Method in which the name for the file
     * with the image is set depending on the parameters
     *
     * @param args - program arguments
     * @return - return image
     * @throws Exception - The file may not be found
     */
    private static Image image(String[] args) throws Exception {
        if (args.length == 0) return ImageIO.read(new File("test.jpg"));
        else if (args.length == 1) return ImageIO.read(new File(args[0]));
        else return null;
    }


    /**
     * A method that takes an image as an input,
     * and writes rgb values to a two-dimensional
     * array, and then returns them
     *
     * @param image - The image that comes to the entrance
     * @return - Array of rgb values
     */
    private static int[][] convertToGetRGB(BufferedImage image) {
        //Get the height and width of the array
        int width = image.getWidth();
        int height = image.getHeight();

        int[][] result = new int[height][width];

        //We write to the array
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                result[i][j] = image.getRGB(j, i);
            }
        }
        return result;
    }
}
