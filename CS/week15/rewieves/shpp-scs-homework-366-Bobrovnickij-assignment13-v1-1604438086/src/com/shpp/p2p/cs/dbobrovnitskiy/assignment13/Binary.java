package com.shpp.p2p.cs.dbobrovnitskiy.assignment13;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This class converts the image to a binary form
 * And returns array of bytes arrays containing a binary image,
 * where each color equals:
 * "1" - if color is white
 * "0" - if color is black
 */
public class Binary {

    private static final int CONTRAST_THRESHOLD = 180;
    private static final int WHITE = 255;
    private static final int BLACK = 0;

    /**
     * This method returns an image as a matrix of bytes
     * Where each color equals:
     * - "1" - if color is white
     * - "0" - if color is black
     *
     * @param fileName - Name image file
     * @return - matrix of boolean operations
     * @throws IOException - possible error when working with the image file
     */
    public static byte[][] getImage(String fileName) throws IOException {
        BufferedImage image = downloadImage(fileName);
        image = getBinaryImage(image);
        return getBooleanBinaryImage(image);
    }

    /**
     * This method creates an image as a matrix of bytes
     * each pixel is assigned the value "1" if the color is white,
     * or "0" if the color is black
     *
     * @param image - binary image without alpha channel
     * @return - array of bytes arrays containing a binary image
     */
    private static byte[][] getBooleanBinaryImage(BufferedImage image) {
        byte[][] result = new byte[image.getWidth()][image.getHeight()];
        byte byteColor;
        int binaryColor;
        Color color;
        for (int width = 0; width < image.getWidth(); width++) {
            for (int height = 0; height < image.getHeight(); height++) {
                color = new Color(image.getRGB(width, height));
                binaryColor = color.getRed();
                if (binaryColor == WHITE) {
                    byteColor = 1;                               //color is white
                } else {
                    byteColor = 0;                               //color is black
                }
                result[width][height] = byteColor;
            }
        }
        return result;
    }

    /**
     * This method creates a binary image from a color
     * The boundary between black and white is the value "CONTRAST_THRESHOLD"
     * Also, to avoid problems with the alpha channel, a white background "background" is created
     * and combines with the binary image using the "combineImages" method
     *
     * @param image - uploaded image
     * @return - binary image without alpha channel
     */
    private static BufferedImage getBinaryImage(BufferedImage image) {
        BufferedImage background = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int width = 0; width < image.getWidth(); width++) {
            for (int height = 0; height < image.getHeight(); height++) {
                Color getColor = new Color(image.getRGB(width, height), true);
                int red = getColor.getRed();
                int green = getColor.getGreen();
                int blue = getColor.getBlue();

                int newColor;

                //If we cross the contrast threshold we set black
                if (red < CONTRAST_THRESHOLD || green < CONTRAST_THRESHOLD || blue < CONTRAST_THRESHOLD) {
                    newColor = BLACK;
                } else {
                    newColor = WHITE;
                }
                image.setRGB(width, height, new Color(newColor, newColor, newColor, getColor.getAlpha()).getRGB());
                background.setRGB(width, height, new Color(WHITE, WHITE, WHITE).getRGB());
            }
        }
        return substituteWhiteBackground(image, background);
    }

    /**
     * This method combines the background and image into one picture
     *
     * @param image      - a binary image in which an alpha channel may be present
     * @param background - background image
     * @return - binary image without alpha channel
     */
    private static BufferedImage substituteWhiteBackground(BufferedImage image, BufferedImage background) {
        BufferedImage binary = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
        Graphics combine = binary.getGraphics();
        combine.drawImage(background, 0, 0, null);
        combine.drawImage(image, 0, 0, null);
        return binary;
    }

    /**
     * This method loads the image
     *
     * @param fileName - Name image file
     * @return - BufferedImage - uploaded image
     * @throws IOException - possible error when working with the image file
     */
    private static BufferedImage downloadImage(String fileName) throws IOException {
        return ImageIO.read(new File(fileName));
    }
}
