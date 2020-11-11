package com.shpp.p2p.cs.espiridonov.assignment12;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * ImageResize:
 * Constructor is private.
 * Has only static method: resizeImage.
 * Scale image to custom size.
 */
public class ImageResize {

    //Does not allow to create an instance of the current class.
    private ImageResize() {
    }

    /**
     * Draws as much of the specified image as has already been scaled, to fit inside the specified rectangle.
     * @param originalImage origin image in buffer.
     * @param width         set scale width
     * @param height        set scale height
     * @return BufferedImage
     */
    public static BufferedImage resizeImage(BufferedImage originalImage, int width, int height) {
        Dimension scaledSize = getScaledDimension(new Dimension(originalImage.getWidth(),originalImage.getHeight()),
                new Dimension(width,height)).getSize();
        int scaledWidth = (int) scaledSize.getWidth();
        int scaledHeight = (int)scaledSize.getHeight();

        BufferedImage resizedImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_USHORT_GRAY);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, new Color(255, 255, 255), null);
        graphics2D.dispose();
        return resizedImage;
    }

    /**
     * Scaled image to custom size with saved proportion.
     * @param imageSize Dimension origin image
     * @param boundary Dimension new scaled image
     * @return Dimension
     */
    static private Dimension getScaledDimension(Dimension imageSize, Dimension boundary) {

        double widthRatio = boundary.getWidth() / imageSize.getWidth();
        double heightRatio = boundary.getHeight() / imageSize.getHeight();
        double ratio = Math.min(widthRatio, heightRatio);

        return new Dimension((int) (imageSize.width  * ratio),
                (int) (imageSize.height * ratio));
    }
}
