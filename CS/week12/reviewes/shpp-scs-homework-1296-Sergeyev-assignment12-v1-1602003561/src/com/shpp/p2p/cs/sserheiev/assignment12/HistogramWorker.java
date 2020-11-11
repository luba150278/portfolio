package com.shpp.p2p.cs.sserheiev.assignment12;

/**
 * This class creates histogram of image.
 */
public class HistogramWorker {
    private static final int MAX_LUMINANCE = 255;

    public static int[] createHistogram(int[][] luminance) {
        int width = luminance[0].length;
        int height = luminance.length;
        int[] histogram = new int[MAX_LUMINANCE + 1];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int currentPixel = luminance[i][j];
                histogram[currentPixel]++;
            }
        }

        return histogram;
    }

    public static int getMedianFromHistogram(int[] histogram) {
        int median = 0;
        int totalPixels = 0;
        for (int i = 0; i < histogram.length; i++) {
            totalPixels += histogram[i];
        }
        for (int i = 0; i < histogram.length; i++) {
            median += histogram[i] * (i + 1);
        }

        return median/totalPixels;
    }
}
