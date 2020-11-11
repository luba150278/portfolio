package com.shpp.p2p.cs.asadov.assignment12ext;

import java.awt.image.BufferedImage;

public class ScannerEdge extends Scanner {

    public ScannerEdge(String fileName, String filePath, BufferedImage image) {
        super(fileName, filePath, image);
    }

   protected void recursiveTestPoint(int col, int row) {
        for (int c = col-1; c <= col+1; c++)
            for (int r = row-1; r <= row +1; r++) {
                if (c <= 0 || r <= 0 ||
                        c >= width - 1 || r >= height - 1 || img[r][c])
                    continue;
                img[r][c] = true;
                if (testPoint(r, c)) {
                    size++;
                    imageToDraw.setRGB(c, r, fgColor);
                    recursiveTestPoint(c, r);
                }
            }
    }

    protected boolean testPoint(int row, int col) {
        int p = imageToRead.getRGB(col, row), counter = 0;
        for (int c = col-1; c <= col + 1; c++)
            for (int r = row-1; r <= row + 1; r++)
                if (r >= 0 && c >= 0 && c < width && r < height) {
                    if(isColorSimilar(imageToRead.getRGB(c, r), p))
                        counter++;
                } else
                    counter++;
        return counter < 8;
    }



}
