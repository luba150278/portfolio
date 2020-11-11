package com.shpp.p2p.cs.sserheiev.assignment12;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;

/**
 * This class responsible for reading image, converting it into black-n-white image,
 * resize image depending to square of (STANDARD_TOTAL_PIXELS / total_pixels_of_image).
 * It also remove alpha-channel from image.
 */
public class ImageWorker {
    public static final int STANDARD_IMAGE_WIDTH = 640;
    public static final int STANDARD_IMAGE_HEIGHT = 360;
    public static final int STANDARD_TOTAL_PIXELS = STANDARD_IMAGE_WIDTH * STANDARD_IMAGE_HEIGHT;

    public static Color[][] readImage(String imagePath) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (bufferedImage.getTransparency() == Transparency.TRANSLUCENT) {
            removeAlphaContent(bufferedImage);
        }

        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        double scaleCoefficient;
        if (width * height > STANDARD_TOTAL_PIXELS) {
            scaleCoefficient = (double) STANDARD_TOTAL_PIXELS / (width * height);
            int newWidth = (int) (width * scaleCoefficient);
            int newHeight = (int) (height * scaleCoefficient);
            bufferedImage = resize(bufferedImage, newWidth, newHeight);
        }

        int arrayWidth = bufferedImage.getWidth();
        int arrayHeight = bufferedImage.getHeight();
        convertToBnW(bufferedImage);
        Color[][] pixelMatrix = new Color[arrayHeight][arrayWidth];


        for (int i = 0; i < arrayHeight; i++) {
            for (int j = 0; j < arrayWidth; j++) {
                pixelMatrix[i][j] = new Color(bufferedImage.getRGB(j, i));
            }
        }

        return pixelMatrix;
    }

    private static void convertToBnW(BufferedImage bufferedImage) {
        ColorConvertOp converter = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        converter.filter(bufferedImage, bufferedImage);
    }

    public static int[][] getLuminanceMatrix(Color[][] pixelMatrix) {
        int width = pixelMatrix[0].length;
        int height = pixelMatrix.length;
        int[][] luminanceMatrix = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                luminanceMatrix[i][j] = pixelMatrix[i][j].getRGB() & 255;
            }
        }

        return luminanceMatrix;
    }

    private static BufferedImage resize(BufferedImage img, int newWidth, int newHeight) {
        Image tempImage = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newWidth, newHeight, img.getType());

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tempImage, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

    private static void removeAlphaContent(BufferedImage inputImage) {
        Graphics2D graphics = inputImage.createGraphics();
        try {
            graphics.setComposite(AlphaComposite.DstOver);
            graphics.setPaint(Color.WHITE);
            graphics.fillRect(0, 0, inputImage.getWidth(), inputImage.getHeight());
        }
        finally {
            graphics.dispose();
        }
    }

}
