package com.shpp.p2p.cs.lmyetolkina.assignment13;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

/**
 * Find the background and objects(main) colors
 * Call the "find object" class
 */
public class BackMainColors {
    /**
     * 1. Change transparency background with white color
     * 2. Find back and main colors
     * 3. Find the count of silhouettes
     * @param image - the checked image
     * @return the count of silhouettes
     */
    public int start(BufferedImage image) {
        int rows = image.getHeight(); //The number of image rows
        int cols = image.getWidth();//The number of image columns
        BufferedImage image_w = deleteTransparency(image); //Change transparency background with white color
        /*The hashmap consists of all image colors and their pixel frequencies*/
        HashMap<Color, Integer> colorsMap = getColorsMap(image_w, rows, cols);

        if (colorsMap.size() == 1) { //If color count is 1 we can't find objects.
            System.out.println("The people count is zero :-) Your picture has just one color.");
            return 0;
        }

        //Find the main and background colors. Index 0 of array equals back color, 1 - main color
        Color[] colors=findBackAndMainColors(colorsMap);
        //Check the founded colors. Sometimes it needs the correction.
        colors=clarifyBackAndMainColors(colors, rows, cols,colorsMap);

        return findObjects(colors, image_w, colorsMap, rows, cols); //Find the count of silhouettes
    }

    /**
     * Find the count of silhouettes
     *
     * @param colors - the array back(0 index) and main (1 index) colors
     * @param image_w - the image with transparency back color
     * @param colorsMap - the hashmap consists of all image colors and their pixel frequencies
     * @param rows - the number image rows
     * @param cols - the number image columns
     * @return the count of silhouettes
     */
    private int findObjects(Color[] colors, BufferedImage image_w, HashMap<Color, Integer> colorsMap, int rows, int cols ){
        /*Create the "FindObjects" class member.*/
        FindObjects fo = new FindObjects();
        fo.createVerticesArray(getImageColors(image_w,rows, cols), colorsMap, rows, cols,
                colors[1], colors[0], sumRGB(colors[1]), sumRGB(colors[0]));

        /*Find the count of silhouettes*/
        return fo.findSilhouettes();
    }

    /**
     * Replace the transparent background with white. This method was found on the internet.
     *
     * @param inputImage the start image
     * @return the image with the transparent background
     */
    private BufferedImage deleteTransparency(BufferedImage inputImage) {
        // Make any transparent parts white
        if (inputImage.getTransparency() == Transparency.TRANSLUCENT) {
            // Fill background  with white
            Graphics2D graphics = inputImage.createGraphics();
            try {
                graphics.setComposite(AlphaComposite.DstOver); // Set composite rules to paint "behind"
                graphics.setPaint(Color.WHITE);
                graphics.fillRect(0, 0, inputImage.getWidth(), inputImage.getHeight());
            } finally {
                graphics.dispose();
            }
        }
        return inputImage;
    }

    /**
     * We calculate with what frequency each color occurs.
     * @param image the image with the transparent background
     * @param rows - the number image rows
     * @param cols - the number image columns
     * @return The hashmap consists of all image colors and their pixel frequencies
     */
    private HashMap<Color, Integer> getColorsMap(BufferedImage image, int rows, int cols) {
        HashMap<Color, Integer> colorsMap = new HashMap<>();
        Color clr; //the current color
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                clr = new Color(image.getRGB(j, i));
                if (colorsMap.get(clr) == null) {
                    colorsMap.put(clr, 1);
                } else {
                    colorsMap.put(clr, colorsMap.get(clr) + 1);
                }
            }
        }

        return colorsMap;
    }

    /**
     * An approximate definition of the main and back colors
     * @param colorsMap The hashmap consists of all image colors and their pixel frequencies
     * @return the array with back (0 - index) and main colors (1 - index)
     */
    private Color[] findBackAndMainColors(HashMap<Color, Integer> colorsMap) {
        /*The proximity of the background and object colors should not be less than 5%*/
        double PROXIMITY_COLORS = 0.05;
        double START_SUM_RGB = -100;   //Use any value less than 0
        Color back = null; //Background color
        Color main = null; //The main color
        Color[] colors = new Color[2];
        List<Integer> item = new ArrayList<>(colorsMap.values()); //Using this array we sort the frequency of each color
                                                                 // in the image in reverse order.
        double sumBack = START_SUM_RGB;
        double sumMain = START_SUM_RGB;
        double delta; //The delta between sum RGB main and back colors
        int indexMainColor = 1; //First color after background is the object color

        Collections.sort(item);  //Sort colormap by frequency
        Collections.reverse(item); //Reverse colormap

        /*Determine the color of the two most popular positions in the array.
        The top color is the background color. The second color is the color of objects (base color).
        Compare the colors. If these colors are close (the difference is less than 5% in the sum of the RGB),
        then the next most popular color is taken as the main one.*/
        for (Map.Entry<Color, Integer> entry : colorsMap.entrySet()) {

            if (entry.getValue().equals(item.get(0))) {
                back = entry.getKey();
                sumBack = sumRGB(back);
            }
            if (entry.getValue().equals(item.get(indexMainColor))) {
                main = entry.getKey();
                sumMain = sumRGB(main);
            }

            if (sumBack != START_SUM_RGB && sumMain != START_SUM_RGB && indexMainColor != 2) {
                delta = Math.abs(sumMain - sumBack) / sumBack;
                if (delta < PROXIMITY_COLORS) {
                    indexMainColor = 2;
                    main = null;
                }
            }

            if (back != null && main != null) break;
        }
        colors[0]=back;
        colors[1]=main;
        return colors;
    }

    /**
     * We distribute the colors according to their similarity to the foreground or background color.
     * We take into account not only the color, but also the frequency of its appearance.
     * Next, we summarize the corresponding groups with the frequencies of occurrence of the main and background colors.
     * If it turns out that the total frequency of occurrence of the main color exceeds the frequency of occurrence
     * of the background color, then change the main color and background color in places.
     *
     * @param colors the start array with the back and main colors
     * @param rows - the number image rows
     * @param cols - the number image columns
     * @param colorsMap The hashmap consists of all image colors and their pixel frequencies
     * @return the array with back (0 - index) and main colors (1 - index)
     */
    private Color[] clarifyBackAndMainColors(Color[] colors, int rows, int cols, HashMap<Color, Integer> colorsMap) {
        Color back = colors[0]; //Background color
        Color main = colors[1]; //The main color
        Color[] newColors = new Color[2];
        double size = rows * cols; //The size of image
        int sumCurr; //The sum of RGB components for current color in HashMap
        double similarity; //The ratio of the sum of the color to the sum of the background color,
        // or to the sum of the base color if it turns out that the background color is black
        double freqBack = 0.0, freqMain = 0.0; //The frequency of appearance of colors close to the background and main,
        // respectively
        int sumBack = sumRGB(colors[0]);
        int sumMain = sumRGB(colors[1]);

        if (sumBack == 0) sumBack = sumMain;

        for (Color clr : colorsMap.keySet()) {
            if (!clr.equals(main) && !clr.equals(back)) {
                sumCurr = sumRGB(clr);

                if (sumBack != 0) {//Compare with the background
                    similarity = (sumCurr < sumBack) ? (sumBack - sumCurr) / (double)sumBack :
                            (sumCurr - sumBack) / (double) sumCurr;
                    if (similarity < 0.5) {//Color closer to background color
                        freqBack += colorsMap.get(clr) / size;
                    } else {
                        freqMain += colorsMap.get(clr) / size;
                    }
                }

                if (sumBack == 0) {//Compare with the base color
                    similarity = (sumCurr < sumMain) ? (sumMain - sumCurr) / (double)sumMain :
                            (sumCurr - sumMain) / (double)sumCurr;
                    if (similarity < 0.5) {//Color closer to main color
                        freqMain += colorsMap.get(clr) / size;
                    } else {
                        freqBack += colorsMap.get(clr) / size;
                    }
                }
            }
        }

        /*If it turns out that the total frequency of occurrence of the main color exceeds the frequency of occurrence
         of the background color, then change the main color and background color in places.*/
        if ((freqBack + colorsMap.get(back) / size) < (freqMain + colorsMap.get(main) / size)) {
            Color prom = back;
            back = main;
            main = prom;
        }
        newColors[0] = back;
        newColors[1] = main;
        return newColors;
    }

    /**
     * Find sum of red, green, blue components
     *
     * @param clr - the color
     * @return the sum
     */
    public int sumRGB(Color clr) {
        return clr.getRed() + clr.getGreen() + clr.getBlue();
    }

    /**
     * Find the color of each image pixel
     * @param image - the image
     * @param rows - the number image rows
     * @param cols - the number image rows
     * @return the colors array of each pixel
     */
    private Color[][] getImageColors(BufferedImage image,int rows, int cols) {

        Color[][] imageColors = new Color[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                imageColors[i][j] = new Color(image.getRGB(j, i));
            }
        }
        return imageColors;
    }
}
