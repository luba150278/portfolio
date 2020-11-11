package com.shpp.p2p.cs.asadov.assignment13ext;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class ScannerEdgeBFS extends Scanner {

    public ScannerEdgeBFS(String fileName, String filePath, BufferedImage image) {
        super(fileName, filePath, image);
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
        return counter < 9;
    }

    protected void scanPoints(int col, int row) {
        LinkedList<Point> points = new LinkedList<>();
        points.add(new Point(col, row));

        while(true) {
            Point p = points.pollFirst();
            if (p != null) {
                col = (int) p.getX();
                row = (int) p.getY();
            } else
                break;
            for (int c = col - 1; c <= col + 1; c++)
                for (int r = row - 1; r <= row + 1; r++) {
                    if (c <= 0 || r <= 0 ||
                            c >= width - 1 || r >= height - 1 || img[r][c])
                        continue;
                    img[r][c] = true;
                    if (testPoint(r, c)) {
                        size++;
                        imageToDraw.setRGB(c, r, fgColor);
                        points.add(new Point(c, r));
                    }
                }
        }
    }
}
