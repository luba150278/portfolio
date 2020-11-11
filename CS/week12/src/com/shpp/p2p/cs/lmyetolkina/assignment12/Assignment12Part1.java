package com.shpp.p2p.cs.lmyetolkina.assignment12;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The task is to determine the number of people in the picture using the depth-first search algorithm.
 * The picture must contain a uniform background, but small objects are allowed.
 */
public class Assignment12Part1 {
    public static BufferedImage image;

    public static void main(String[] args) {
        File file;
        try {
            try {
                file = new File(args[0]);  //Read file name from input array.
            } catch (ArrayIndexOutOfBoundsException e) {
                file = new File("test.jpg"); //If the input array is empty use "test.jpg" file.
            }
            image = ImageIO.read(file);
            image.setData(image.getRaster());

        } catch (IOException e) {
            System.out.println("File not found."); //If the file from the input array didn't found or
                                                   // didn't found "test.jpg".
            return;
        }

        Colormap.main(); //The class in which we define the frequency with which each color appears in the image.
                         //For pictures with a transparent background, replace the background with white.
        FindColors.main(); //The class that finds the foreground and background colors.
        DeepFirstSearch.main(); //The class in which we create the graph, adjust it.
                               //Next, we use the depth-first search algorithm to determine
                               //the number of people (objects) in the image.
    }
}

