package com.shpp.p2p.cs.lmyetolkina.assignment13;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The task is to determine the number of people in the picture using the breadth-first search algorithm.
 * The picture must contain a uniform background, but small objects are allowed.
 */
public class Assignment13Part1 {
    private static final long startTimer = System.currentTimeMillis();
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        int objects = searchObjects(readFile(args[0]));
        text.append("The file <").append(args[0]).append("> has ").append(objects).append(" silhouettes.");

        //text = test(); //Use this method to test some images (to comment first method string).
        System.out.println(text);
                double time = System.currentTimeMillis() - startTimer;
        System.out.println(time);
    }

    /**
     * Read the image (check the format and existing of the file), find main and back colors,
     * find the count objects on the image.
     *
     * @param args - the name image file
     */
    private static BufferedImage readFile(String args) {
        BufferedImage image;
        File file;
        try {
            try {
                file = new File(args);  //Read file name from input array.
            } catch (ArrayIndexOutOfBoundsException e) {
                file = new File("test.jpg"); //If the input array is empty use "test.jpg" file.
            }

            image = ImageIO.read(file);
            image.setData(image.getRaster());

        } catch (IOException e) {
            System.out.println("File not found."); //If the file from the input array didn't found or
            // didn't found "test.jpg".
            return null;
        } catch (NullPointerException e) {
            System.out.println("Invalid file format."); //If the file has not image format.
            return null;
        }
        return image;
    }

    private static int searchObjects(BufferedImage image) {
        BackMainColors bmc = new BackMainColors();
        return bmc.start(image);
    }

    /**
     * Use this method to test some images (to comment the first row and to uncomment it in the main method).
     * Add your images to the below array.
     */
    private static StringBuilder test() {
        StringBuilder text = new StringBuilder();
        int failed = 0;
        int objects;
        for (String[] test : tests) {
            objects = searchObjects(readFile(test[0]));
            text.append("The file <").append(test[0]).append("> has ").append(objects).append(" silhouettes.");
            if (objects != Integer.parseInt(test[1])) {
                failed++;
                text.append(" FAIL!");
            }
            text.append(" Expected: ").append(test[1]).append("\n");
        }
        text.append("Checked: ").append(tests.length).append(" images. Filed: ").append(failed);
        return text;
    }

    /**
     * The array of test images. The second column of the array is the correct count of image objects.
     */
    private static final String[][] tests = {
            {"test.jpg", "8"},
            {"ten.jpg", "10"},
            {"skater.jpg", "1"},
            {"01.jpg", "1"},
            {"20.jpg", "20"},
            {"29.jpg", "29"},
            {"balet.jpg", "1"},
            {"cats.png", "9"},
            {"child.png", "5"},
            {"dance.jpg", "6"},
            {"fashion.png", "10"},
            {"fashion2.png", "10"},
            {"handball.png", "6"},
            {"mat.png", "4"},
            {"rect3.png", "2"},
            {"1.1.jpg", "8"},
            {"1.jpg", "16"},
            {"children.jpg", "7"},
            {"test22i.jpg", "6"},
            {"test22.jpg", "6"},
            {"testColors.png", "6"},
            {"testdrive.jpg", "1"},
            {"test_2.jpg", "9"},
            {"test3.png", "4"},
            {"test2.png", "4"},
            {"test.png", "1"},
            {"test1.png", "5"},
            {"test1.jpg", "1"},
            {"example1.jpg", "6"},
            {"example2.jpg", "4"},
            {"rect3.png", "2"},
            {"new.jpg", "6"},
            {"mat.jpg", "4"},
    };
}

