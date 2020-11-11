package com.shpp.p2p.cs.smakarenko.assignment13;

import acm.graphics.GImage;
import java.awt.image.BufferedImage;

/**
 * Create graph with pixels equivalent
 *
 */
public class Graph {
    /** Count colors: white, red, green, blue, magenta, cyan, yellow, black; */
    private static int w, r, g, b, m, c, y, bl;
    private static int[] colorsCount = new int[8];
    private static int max;
    private static double GARBAGE = 0.25;

    /**
     * Create graph
     * @param image - picture name
     * @return count of objects
     */
    public static int[][] CreateGraph(BufferedImage image) {
        w=0; r=0; g=0; b=0; m=0; c=0; y=0; bl=0;
        colorsCount = new int[8];
        int[][] pixels = new int[image.getWidth()][image.getHeight()];
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j <pixels[i].length ; j++) {
                pixels[i][j] = getPixelEquivalent(image.getRGB(i,j));
            }
        }
        pixels = newPixels(pixels,sumColors(pixels, getBackground()), getBackground());
        return pixels;
    }

    /**
     * Get pixel, bring to the closest color and return equivalent
     * @param pixel
     * @return pixel equivalent
     */
    private static int getPixelEquivalent(int pixel) {
        int red = (GImage.getRed(pixel) > 255/2 ? 255 : 0);
        int green = (GImage.getGreen(pixel) > 255/2 ? 255 : 0);
        int blue = (GImage.getBlue(pixel) > 255/2 ? 255 : 0);

        switch (red + " " + green + " " + blue) {
            case "255 255 255": colorsCount[1]++; return 1;   // [255][255][255] - white

            case "255 0 0": colorsCount[2]++; return 2;       // [255][0][0] - red
            case "0 255 0": colorsCount[3]++; return 3;       // [0][255][0] - green
            case "0 0 255": colorsCount[4]++; return 4;       // [0][0][255] - blue

            case "255 0 255": colorsCount[5]++; return 5;     // [255][0][255] - magenta
            case "0 255 255": colorsCount[6]++; return 6;     // [0][255][255] - cyan
            case "255 255 0": colorsCount[7]++; return 7;     // [255][255][0] - yellow

            default: colorsCount[0]++; return 0;             // [0][0][0] - black
        }
    }

    /**
     * Get background color
     * @return id background color
     */
    public static int getBackground(){
        int [] el = {bl,w,r,g,b,m,c,y};
        int maxTemp = colorsCount[0];
        int maxID = 0;
        for (int i = 0; i < colorsCount.length; i++) {
            if (colorsCount[i] > maxTemp) {
                maxTemp = colorsCount[i];
                maxID = i;
            }
        }
        return maxID;
    }

    /**
     * Get sum of pixels != background
     * @param pixels graph
     * @param back background color
     * @return array of numbers colors != background
     */
    public static int[] sumColors(int[][] pixels, int back) {
        int[] numColor = new int[pixels.length];
        int count = 0;
        max = 0;
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                if (pixels[i][j] != back)
                    count++;
            }
            if (count>max)
                max = count;
            numColor[i] = count;
            count = 0;
        }
        return numColor;
    }

    /**
     * Drop from graph stuck together objects
     * @param pixels graph
     * @param numColor array of numbers colors != background
     * @param back background color
     * @return
     */
    public static int[][] newPixels(int[][] pixels, int[] numColor, int back) {
        for (int i = 0; i < pixels.length; i++) {
            if (numColor[i] < max * GARBAGE) {
                for (int j = 0; j < pixels[i].length; j++) {
                    pixels[i][j] = back;
                }
            }
        }
        return pixels;
    }
}