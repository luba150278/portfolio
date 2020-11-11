package com.shpp.p2p.cs.asadov.assignment12ext;

import java.awt.image.BufferedImage;

public class ScannerColor extends ScannerBlocks {
    private int fgp;
    protected static final int COLOR_BG_PRECISION = 90;
    public ScannerColor(String fileName, String filePath, BufferedImage image) {
        super(fileName, filePath, image);
    }

    public int scanImage() {
        for (int row = 0; row < height; row+= delta) {
            for (int col = 0; col < width; col+= delta) {
                img[row][col] = true;
                if (!testPointBg(row, col)) {
                    imageToDraw.setRGB(col, row, bgColor);
                } else {
                    fgp = imageToRead.getRGB(col, row);
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

    protected boolean testPointBg(int row, int col) {
        int p = imageToRead.getRGB(col, row);
        return isColorSimilarBg(p, bgPointColor);
    }

    protected boolean testPoint(int row, int col) {
        int p = imageToRead.getRGB(col, row);
        return !isColorSimilar(p, fgp);
    }

    protected boolean isColorSimilarBg(int p1, int p2) {
        int a1 = (p1>>24)&0xff, r1 = (p1>>16)&0xff, g1 = (p1>>8)&0xff, b1 = p1&0xff;
        int a2 = (p2>>24)&0xff, r2 = (p2>>16)&0xff, g2 = (p2>>8)&0xff, b2 = p2&0xff;
        return (Math.abs(a1-a2) > COLOR_BG_PRECISION) || (Math.abs(r1-r2) > COLOR_BG_PRECISION)
                || (Math.abs(g1-g2) > COLOR_BG_PRECISION) || (Math.abs(b1-b2) > COLOR_BG_PRECISION);
    }
}
