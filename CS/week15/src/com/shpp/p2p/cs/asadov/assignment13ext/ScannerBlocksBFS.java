package com.shpp.p2p.cs.asadov.assignment13ext;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class ScannerBlocksBFS extends ScannerBlocksDFS {
    

    public ScannerBlocksBFS(String fileName, String filePath, BufferedImage image) {
        super(fileName,filePath, image);
    }


    protected void scanPoints(int col, int row) {
        LinkedList<Point> points = new LinkedList<>();
        points.add(new Point(col, row));

        while(true) {
            Point p = points.pollFirst();
            if (p != null) {
                col = (int)p.getX();
                row = (int)p.getY();
            } else
                break;
            for (int c = col - delta; c <= col + delta; c += delta)
                for (int r = row - delta; r <= row + delta; r += delta) {
                    if (c <= 0 || r <= 0 || c >= width - 1 ||
                            r >= height - 1 || img[r][c])
                        continue;
                    img[r][c] = true;
                    if (!testPoint(r, c)) {
                        size++;
                        imageToDraw.setRGB(c, r, fgColor);
                        graphics.drawLine(col, row, c, r);
                        points.add(new Point(c, r));
                    }
                }
        }
    }


}
