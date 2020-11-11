package com.shpp.p2p.cs.dbobrovnitskiy.assignment13;

import java.io.IOException;

/**
 * This class counts the number of objects in the picture
 * At the same time delete excess garbage
 */
public class Assignment13Part1 {

    /**
     * Displays the number of objects in the selected image
     * or test image if the file is not found
     *
     * @param args - arguments:
     *             - expected first argument with image file name;
     *             - subsequent arguments are not important.
     * @throws IOException - possible error when working with the image file
     */
    public static void main(String[] args) throws IOException {
        int numberOfObjects;
        try {
            // output the selected file:
            System.out.println("You selected file:\n" + args[0]);
            numberOfObjects = new CountingObjects(Binary.getImage(args[0])).getObjectsCount();
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            numberOfObjects = new CountingObjects(Binary.getImage("assets/materials.png")).getObjectsCount();
            // if the file is not found:
            System.out.println("Check if the filename is correct");
            System.out.println("Test file \"assets/materials.png\": ");
        }
        // result output:
        System.out.println("There are " + numberOfObjects + " objects in this image");
    }
}
