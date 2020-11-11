package com.shpp.p2p.cs.smakarenko.assignment13;

import java.awt.image.BufferedImage;

/**
 * WORK WITH "assets" FOLDER!!!
 * Calculate number of object(s) on the picture.
 *
 */
public class Assignment13Part1 {

    /**
     * Get picture, check format
     * @param args - array of picture name
     */
    public static void main(String[] args) {
       args = new String[] {"1.1.jpg", "1.jpg", "children.jpg", "example.jpg", "example1.jpg", "example2.jpg", "materials.png", "materials2.png", "new.jpg", "test.jpg", "test1.jpg", "test1.png", "test2.png", "test3.png", "test22.jpg", "test22i.jpg", "test_2.jpg"};
        int count;
        if (args.length == 0) {
            args = new String[]{"test.jpg"};
        }
        for (String fileName : args) {
            try {
                FileProcessing rf = new FileProcessing(fileName);
                BufferedImage image = rf.getImage();
                Graph.sumColors(Graph.CreateGraph(image), Graph.getBackground()); ///
                ObjectsCount co = new ObjectsCount();
                count = co.getCount(Graph.CreateGraph(image), Graph.getBackground());
                if (count != -1) System.out.println("For [" + fileName + "] found " + count + " object(s)");
            } catch (Exception e) {
                System.out.println("[" + fileName + "] loading file error!");
            }
        }
    }
}