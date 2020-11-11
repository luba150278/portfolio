package com.shpp.p2p.cs.asadov.assignment12ext;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ScannerBlocks extends Scanner {
    protected int delta;
    private Graphics graphics;
    protected int bgPointColor;

    public ScannerBlocks(String fileName, String filePath, BufferedImage image) {
        super(fileName,filePath, image);

        graphics = image.getGraphics();
        graphics.setColor(Color.RED);
        int max = Math.max(width, height);
        delta = max > 300 ? max / 100 : 3;
        fgColor = (255 << 24) | (255 << 16);
        bgPointColor = findBgColor();
    }

    private int findBgColor() {
        int color1 = 0, num1 = 0, num2 = 0;
        int color2 = imageToDraw.getRGB(delta, delta);
        for (int col = 0; col < width; col+= delta) {
            int tmp = imageToDraw.getRGB(col, delta);
            if (isColorSimilar(color2, tmp))
                num2++;
            else {
                if (color1 == 0)
                    color1 = tmp;
                num1++;
            }
        }
        if (num1 > num2)
            return color1;
        else
            return color2;
    }

    public int scanImage() {
        for (int row = 0; row < height; row+= delta) {
            for (int col = 0; col < width; col+= delta) {
                img[row][col] = true;
                if (testPoint(row, col)) {
                    imageToDraw.setRGB(col, row, bgColor);
                } else {
                    imageToDraw.setRGB(col, row, fgColor);
                    size = 0;
                    recursiveTestPoint(col, row);
                    if (size != 0)
                        sizes.add(size);
                }
            }
        }
        return getResultFromTrash();
    }


    protected void recursiveTestPoint(int col, int row) {
        for (int c = col- delta; c <= col + delta; c+= delta)
            for (int r = row- delta; r <= row + delta; r+= delta) {
                if (c <= 0 || r <= 0 || c >= width - 1 ||
                        r >= height - 1 || img[r][c])
                    continue;
                img[r][c] = true;
                if (!testPoint(r, c)) {
                    size++;
                    imageToDraw.setRGB(c, r, fgColor);
                    graphics.drawLine(col, row, c, r);
                    recursiveTestPoint(c, r);
                }
            }
    }

    protected boolean testPoint(int row, int col) {
        int p = imageToRead.getRGB(col, row);
        return isColorSimilar(p, bgPointColor);
    }

}
