package com.shpp.p2p.cs.smakarenko.assignment13;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Read image from file, check format, delete transparency, resize
 */
public class FileProcessing {

    private static BufferedImage image;

    /**  Maximum of image height or width */
    public static int MAX_IMAGE_SIZE = 200;
    /**  Supported formats */
    private static final String[] IMAGE_EXTENSIONS = new String[]{".png", ".bmp", ".jpg", ".jpeg", ".tif"};

    /**
     * Read image from file
     * @param fileName - picture name
     */
    public FileProcessing (String fileName) throws IOException {
        if (checkExt(fileName)) {
            File file = new File("assets/"+fileName);
            image = ImageIO.read(file);
            deleteTransparency(image);
            if (Math.max(image.getHeight(), image.getWidth()) > MAX_IMAGE_SIZE) resize();
        } else {
            System.out.println("[" + fileName + "] Not supported format file.");
        }
    }

    public BufferedImage getImage() {
        return image;
    }

    /**
     * Check supported extension
     * @param file picture name
     * @return true if file supported
     */
    private static boolean checkExt(String file) {
        for (String ext: IMAGE_EXTENSIONS) {
            if (file.endsWith(ext))
                return true;
        }
        return false;
    }

    /**
     * Delete transparency
     * @param inputImage BufferedImage
     */
    private static void deleteTransparency(BufferedImage inputImage) {
        if (inputImage.getTransparency() == Transparency.TRANSLUCENT) {
            Graphics2D graphics = inputImage.createGraphics();
            try {
                graphics.setComposite(AlphaComposite.DstOver);
                graphics.setPaint(Color.WHITE);
                graphics.fillRect(0, 0, inputImage.getWidth(), inputImage.getHeight());
            } finally {
                graphics.dispose();
            }
        }
    }

    /**
     *  Resize image (Bufferedimage)
     * https://stackoverflow.com/questions/9417356/bufferedimage-resize
     * @return - resized image (Bufferedimage)
     */
    public static BufferedImage resize() {
        int newW = MAX_IMAGE_SIZE, newH = MAX_IMAGE_SIZE;
        if (image.getHeight() >= image.getWidth()) {
            newW = (int) ((double) MAX_IMAGE_SIZE / image.getHeight() * image.getWidth());
        } else {
            newH = (int) ((double) MAX_IMAGE_SIZE / image.getWidth() * image.getHeight());
        }
        Image tmp = image.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage resize = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = resize.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resize;
    }
}