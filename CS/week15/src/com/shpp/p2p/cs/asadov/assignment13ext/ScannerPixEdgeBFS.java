package com.shpp.p2p.cs.asadov.assignment13ext;

import java.awt.image.BufferedImage;

public class ScannerPixEdgeBFS extends ScannerPixBFS {

    public ScannerPixEdgeBFS(String fileName, String filePath, BufferedImage image) {

        super(fileName,filePath, image);
    }


    @Override
    protected boolean testPoint(int row, int col) {

        return super.testPoint(row, col) || testPointIfEdge(row, col);
    }

    protected boolean testPointIfEdge(int row, int col) {
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
}
