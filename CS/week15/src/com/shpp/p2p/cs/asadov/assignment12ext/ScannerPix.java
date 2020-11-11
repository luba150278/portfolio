package com.shpp.p2p.cs.asadov.assignment12ext;

import java.awt.image.BufferedImage;

public class ScannerPix extends ScannerBlocks {
    public ScannerPix(String fileName, String filePath, BufferedImage image) {
        super(fileName,filePath, image);
        delta = 1;
    }
}
