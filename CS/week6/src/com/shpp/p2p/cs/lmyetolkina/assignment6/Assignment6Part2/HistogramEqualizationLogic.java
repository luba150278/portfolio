package com.shpp.p2p.cs.lmyetolkina.assignment6.Assignment6Part2;

import java.util.Arrays;

public class HistogramEqualizationLogic {
    private static final int MAX_LUMINANCE = 255;

    /**
     * Given the luminances of the pixels in an image, returns a histogram of the frequencies of
     * those luminances.
     * <p/>
     * You can assume that pixel luminances range from 0 to MAX_LUMINANCE, inclusive.
     *
     * @param luminances The luminances in the picture.
     * @return A histogram of those luminances.
     */
    public static int[] histogramFor(int[][] luminances) {
        int numCols = luminances[0].length;
        int[] histogram = new int[MAX_LUMINANCE + 1];

        for (int[] luminance : luminances) {
            for (int col = 0; col < numCols; col++) {
                histogram[luminance[col]]++;
            }
        }
        return histogram;
    }

    /**
     * Given a histogram of the luminances in an image, returns an array of the cumulative
     * frequencies of that image.  Each entry of this array should be equal to the sum of all
     * the array entries up to and including its index in the input histogram array.
     * <p/>
     * For example, given the array [1, 2, 3, 4, 5], the result should be [1, 3, 6, 10, 15].
     *
     * @param histogram The input histogram.
     * @return The cumulative frequency array.
     */
    public static int[] cumulativeSumFor(int[] histogram) {
        int[] cumulativeSumFor = new int[MAX_LUMINANCE + 1];

        for (int i = 0; i < histogram.length; i++) {
            for (int j = 0; j <= i; j++) {
                cumulativeSumFor[i] += histogram[j];
            }
        }
        return cumulativeSumFor;
    }

    /**
     * Returns the total number of pixels in the given image.
     *
     * @param luminances A matrix of the luminances within an image.
     * @return The total number of pixels in that image.
     */
    public static int totalPixelsIn(int[][] luminances) {
        return luminances.length * luminances[0].length;
    }

    /**
     * Applies the histogram equalization algorithm to the given image, represented by a matrix
     * of its luminances.
     * <p/>
     * You are strongly encouraged to use the three methods you have implemented above in order to
     * implement this method.
     *
     * @param luminances The luminances of the input image.
     * @return The luminances of the image formed by applying histogram equalization.
     */
    public static int[][] equalize(int[][] luminances) {
        int totalPixels = totalPixelsIn(luminances);
        int numRows = luminances.length;
        int numCols = luminances[0].length;
        int[][] equalize = new int[numRows][numCols];
        int[] histogram = histogramFor(luminances);
        int[] cumulativeHistogram = cumulativeSumFor(histogram);
        double newLuminance;
        /*Change luminance every pixel. If start luminance == 0 (max value of luminance) don't change value of luminance,
        * otherwise use formula to change luminance value.*/
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int L = luminances[row][col];
                if(L==0)System.out.println(L);
                if (cumulativeHistogram[L] == 0) {
                    newLuminance = 0;
                } else {
                    double fractionSmaller = (double) cumulativeHistogram[L] / (double) totalPixels;
                    newLuminance = (double) MAX_LUMINANCE * fractionSmaller;
                }
                equalize[row][col] = (int) newLuminance;
            }
        }

        return equalize;
    }
}
