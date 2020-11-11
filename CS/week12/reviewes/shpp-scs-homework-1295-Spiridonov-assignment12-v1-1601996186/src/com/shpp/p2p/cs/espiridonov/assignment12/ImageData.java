package com.shpp.p2p.cs.espiridonov.assignment12;

import javax.imageio.ImageIO;
;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * ImageData class.
 * Read image files(jpg or png) and contains info about file.
 * Getters:
 * 1.width, heights pixels
 * 2.representation matrix colors of image.
 */
public class ImageData {

    private String REGEX_FILE_EXTENSION = ".(png|jpg)$";
    private String localPath;
    private File fileImage;

    private int width;
    private int height;
    private Color[][] colorPixel;

    ImageData(String localPath) {
        this.localPath = localPath;
        fileImage = new File(localPath);
        readLocalImage();
    }

    /**
     * Read origin image and scaled to 100x100 size.
     * Supported only jpg or png extensions.
     */
    private void readLocalImage() {
        if (isCorrectFileExtension()) {
            try {
                BufferedImage originImage = ImageIO.read(fileImage);

                BufferedImage resizeImage = ImageResize.resizeImage(originImage, 100, 100);
                ImageIO.write(resizeImage, "png", new File("resource/images/OUT.png"));
                colorPixel = new Color[resizeImage.getWidth()][resizeImage.getHeight()];
                width = resizeImage.getWidth();
                height = resizeImage.getHeight();

                for (int x = 0; x < resizeImage.getWidth(); x++) {
                    for (int y = 0; y < resizeImage.getHeight(); y++) {
                        Color color = new Color(resizeImage.getRGB(x, y));
                        colorPixel[x][y] = color;
                    }
                }
            } catch (IOException e) {
                System.out.println("Incorrect file path");
            }
        } else {
            System.out.println("Incorrect file extension, supported only .png .jpg");
        }
    }


    /**
     * Checking all four corners and get max color matches.
     *
     * @return Color
     */
    public Color getBackgroundColor() {

        HashMap<Color, Integer> pixels = new HashMap<>();

        Color[] colors = new Color[]{colorPixel[0][0],//north-west corner
                colorPixel[0][height - 1],//north-east corner
                colorPixel[width - 1][0],//south-west corner
                colorPixel[width - 1][height - 1]};//south-east corner

        for (Color color : colors) {
            if (!pixels.containsKey(color)) {
                pixels.put(color, 1);
            } else {
                pixels.replace(color, pixels.get(color), pixels.get(color) + 1);
            }
        }

        int max = 0;
        Color color = null;

        for (Map.Entry entry : pixels.entrySet()) {
            if ((Integer) entry.getValue() > max) {
                color = (Color) entry.getKey();
                max = (Integer) entry.getValue();
            }
        }

        return color;
    }

    /**
     * Check matches file extension(jpg or png).
     *
     * @return boolean
     */
    private boolean isCorrectFileExtension() {
        String extension = localPath.substring(localPath.lastIndexOf("."));
        return extension.matches(REGEX_FILE_EXTENSION);
    }

    public Color[][] getColorPixel() {
        return colorPixel;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}