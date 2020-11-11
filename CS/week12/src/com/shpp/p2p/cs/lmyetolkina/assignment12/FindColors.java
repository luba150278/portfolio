package com.shpp.p2p.cs.lmyetolkina.assignment12;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * The class that finds the foreground (main) and background colors.
 */
public class FindColors {
    public static Color back = null; //Background color
    public static Color main = null; //The main color
    /*Sum of the integer value red, green, blue channels*/
    public static int rgbBack;
    public static int rgbMain;
    /*The hashmap consists of all image colors and their pixel frequencies. It was found in the "Colormap" class.*/
    private static final HashMap<Color, Integer> colorsMap = Colormap.colorsMap;
    /*Sizes of the image in pixels. They were found in the "Colormap" class too.*/
    private static final int rowsImage = Colormap.rowsImage;
    private static final int columnsImage = Colormap.columnsImage;

    /**
     * The main method calls helper methods that sequentially solve the problem described for the class
     */
    public static void main() {
        findColors(); //Find the main and background colors.
        checkColors(); //Check the founded colors. Sometimes it needs the correction.
        getRGBValues(); //Get the sum of RGB values for main and back colors.
                        // Values will use in the "Deep First Search" class.
    }

    /**
     * Find the main and background colors
     */
    private static void findColors() {

        List<Integer> item = new ArrayList<>(colorsMap.values()); //Using this array we sort the frequency of each color
                                                                  // in the image in reverse order.
        Collections.sort(item); //Sort
        Collections.reverse(item); //Reverse

        double sumBack = -100.0;
        double sumMain = -100.0;
        double delta;
        int n = 1;

        /*Determine the color of the two most popular positions in the array.
        The top color is the background color. The second color is the color of objects (base color).
        Compare the colors. If these colors are close (the difference is less than 5% in the sum of the RПИ),
        then the next most popular color is taken as the main one.*/
        for (Map.Entry<Color, Integer> entry : colorsMap.entrySet()) {

            if (entry.getValue().equals(item.get(0))) {
                back = entry.getKey();
                sumBack = sumRGB(back);
            }
            if (entry.getValue().equals(item.get(n))) {
                main = entry.getKey();
                sumMain = sumRGB(main);
            }

            if (sumBack != -100.0 && sumMain != -100.0 && n!=2) {
                delta = (sumBack < sumMain) ? (sumMain - sumBack) / sumMain : (sumBack - sumMain) / sumBack;
                if (delta < 0.05) {
                    n = 2;
                    main = null;
                }
            }

            if (back != null && main != null) break;
        }
    }

    /**
     * We distribute the colors according to their similarity to the foreground or background color.
     * We take into account not only the color, but also the frequency of its appearance.
     * Next, we summarize the corresponding groups with the frequencies of occurrence of the main and background colors.
     * If it turns out that the total frequency of occurrence of the main color exceeds the frequency of occurrence
     * of the background color, then change the main color and background color in places.
     */
    private static void checkColors() {
        double sumCurr; //The sum of RGB components for current color in HashMap
        double similarity; //The ratio of the sum of the color to the sum of the background color,
                           // or to the sum of the base color if it turns out that the background color is black
        double freqBack = 0.0, freqMain = 0.0; //The frequency of appearance of colors close to the background and main,
                                              // respectively
        double sumBack = sumRGB(back);
        double sumMain = sumRGB(main);

        if (sumBack == 0.0) sumBack = sumMain;

        double size = rowsImage * columnsImage;

        for (Color clr : colorsMap.keySet()) {
            if (!clr.equals(main) && !clr.equals(back)) {
                sumCurr = sumRGB(clr);

                if (sumBack != 0) {//Compare with the background
                    similarity = (sumCurr < sumBack) ? (sumBack - sumCurr) / sumBack : (sumCurr - sumBack) / sumCurr;
                    if (similarity < 0.5) {//Color closer to background color
                        freqBack += colorsMap.get(clr) / size;
                    } else {
                        freqMain += colorsMap.get(clr) / size;
                    }

                }
                if (sumBack == 0) {//Compare with the base color
                    similarity = (sumCurr < sumMain) ? (sumMain - sumCurr) / sumMain : (sumCurr - sumMain) / sumCurr;
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
    }

    /**
     * We will use sum RGB components the main and back colors further (in the "DFS" class)
     */
    private static void getRGBValues() {
        rgbBack = sumRGB(back);
        rgbMain = sumRGB(main);
    }

    /**
     *
     * Find sum of red, green, blue components
     * @param clr - the color
     * @return the sum
     */
    public static int sumRGB(Color clr){
        return clr.getRed() + clr.getGreen() + clr.getBlue();
    }

}
