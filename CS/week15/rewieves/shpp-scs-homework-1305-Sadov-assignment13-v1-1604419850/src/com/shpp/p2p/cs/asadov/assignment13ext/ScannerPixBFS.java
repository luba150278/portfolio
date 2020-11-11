package com.shpp.p2p.cs.asadov.assignment13ext;

import java.awt.image.BufferedImage;

public class ScannerPixBFS extends ScannerBlocksBFS {
    public ScannerPixBFS(String fileName, String filePath, BufferedImage image) {
        super(fileName,filePath, image);
        delta = 1;
    }
}
