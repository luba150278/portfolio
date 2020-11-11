package com.shpp.p2p.cs.asadov.assignment12ext;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;

import static com.shpp.p2p.cs.asadov.assignment12ext.Service.readFile;
public class Scanner {

    protected static final int COLOR_PRECISION = 40;
    protected static final double SIZE_PROPORTION = 5.0;

    protected final BufferedImage imageToDraw, imageToRead;

    protected final boolean [][] img;
    protected final int width, height;
    protected int size;
    protected int fgColor, bgColor;
    protected ArrayList<Integer> sizes;


    public Scanner(String fileName, String filePath, BufferedImage imageToDraw) {
        this.imageToDraw = imageToDraw;
        width = imageToDraw.getWidth();
        height = imageToDraw.getHeight();
        img = new boolean[height][width];
        imageToRead = readFile(filePath, fileName);
        sizes = new ArrayList<>();
        fgColor = (255 << 24) | (255 << 8);
        bgColor = (255<<24) | (100<<16) | (140<<8) | 135;
    }

    public int scanImage() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                img[row][col] = true;
                if (!testPoint(row, col)) {
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

    protected int getResultFromTrash() {
        if (sizes.size() == 0)
            return 0;
        Collections.sort(sizes);
        Collections.reverse(sizes);
        int silhouettes = 0;

        int maxSize = sizes.get(0);
        for (int s: sizes)
            if (maxSize / (double)s < SIZE_PROPORTION)
                silhouettes++;
            else
                break;
        return silhouettes;
    }

    protected boolean isColorSimilar(int p1, int p2) {
        int a1 = (p1>>24)&0xff, r1 = (p1>>16)&0xff, g1 = (p1>>8)&0xff, b1 = p1&0xff;
        int a2 = (p2>>24)&0xff, r2 = (p2>>16)&0xff, g2 = (p2>>8)&0xff, b2 = p2&0xff;
        return (Math.abs(a1-a2) < COLOR_PRECISION) && (Math.abs(r1-r2) < COLOR_PRECISION)
                && (Math.abs(g1-g2) < COLOR_PRECISION) && (Math.abs(b1-b2) < COLOR_PRECISION);
    }

    protected void recursiveTestPoint(int col, int row) {
    }

    protected boolean testPoint(int row, int col) {
        return false;
    }

}
