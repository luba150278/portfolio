package com.shpp.p2p.cs.lmyetolkina.assignment12;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 * The class in which we define the frequency with which each color appears in the image.
 * For pictures with a transparent background, replace the background with white
 */
public class Colormap {
    /*The hashmap consists of all image colors and their pixel frequencies*/
    public static final HashMap<Color, Integer> colorsMap = new HashMap<>();
    /*Sizes of the image in pixels*/
    public static int rowsImage;
    public static int columnsImage;
    /*The color array is created from the image.*/
    public static Color[][] imageColors;

    /*The image*/
    private static final BufferedImage image = Assignment12Part1.image;

    /**
     * The main method calls helper methods that sequentially solve the problem described for the class
     */
    public static void main() {
        Assignment12Part1.image = deleteTransparency(image); //
        getColorsMap();

        if (colorsMap.size() == 1) {
            System.out.println("The people count is zero :-) Your picture has just one color.");
        }
    }

    /**
     * Replace the transparent background with white. This method was found on the internet.
     * @param inputImage the start image
     * @return the image with white background color
     */
    private static BufferedImage deleteTransparency(BufferedImage inputImage) {
        // Make any transparent parts white
        if (inputImage.getTransparency() == Transparency.TRANSLUCENT) {
            // Fill background  with white
            Graphics2D graphics = inputImage.createGraphics();
            try {
                graphics.setComposite(AlphaComposite.DstOver); // Set composite rules to paint "behind"
                graphics.setPaint(Color.WHITE);
                graphics.fillRect(0, 0, inputImage.getWidth(), inputImage.getHeight());
            } finally {
                graphics.dispose();
            }
        }
        return inputImage;
    }

    /**
     * We calculate with what frequency each color occurs. We create a hashmap.
     * We enter information about the color of each pixel into an array.
     */
    private static void getColorsMap() {
        rowsImage = image.getHeight();
        columnsImage = image.getWidth();
        imageColors = new Color[rowsImage][columnsImage];

        for (int i = 0; i < rowsImage; i++) {
            for (int j = 0; j < columnsImage; j++) {
                imageColors[i][j] = new Color(image.getRGB(j, i));
                if (colorsMap.get(imageColors[i][j]) == null) {
                    colorsMap.put(imageColors[i][j], 1);
                } else {
                    colorsMap.put(imageColors[i][j], colorsMap.get(imageColors[i][j]) + 1);
                }
            }
        }
    }
}
