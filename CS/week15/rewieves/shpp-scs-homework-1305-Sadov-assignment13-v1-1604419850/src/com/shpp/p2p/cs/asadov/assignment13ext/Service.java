package com.shpp.p2p.cs.asadov.assignment13ext;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Service {
    public static BufferedImage readFile(String filePath, String fileName) {
        try {
            BufferedImage image = ImageIO.read(new File(filePath, fileName));
            return image;
        } catch(IOException | NullPointerException e) {
            System.out.println(e);
            return null;
        }
    }
}
