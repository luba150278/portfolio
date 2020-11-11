package com.shpp.p2p.cs.sserheiev.assignment12;

/**
 * This class creates boolean matrix, where true - silhouette, false - background.
 */
public class BooleanWorker {
    public static boolean[][] getBooleanMatrix(int[][] luminance, int median) {
        int width = luminance[0].length;
        int height = luminance.length;
        boolean[][] booleanMatrix = new boolean[height][width];
        int backgroundLuminance = backgroundLuminanceDetection(luminance);
        boolean isBackgroundBrighter = backgroundLuminance > median;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (isBackgroundBrighter) {
                    if (luminance[i][j] > median) {
                        booleanMatrix[i][j] = false;
                    } else {
                        booleanMatrix[i][j] = true;
                    }
                } else {
                    if (luminance[i][j] < median) {
                        booleanMatrix[i][j] = false;
                    } else {
                        booleanMatrix[i][j] = true;
                    }
                }
            }
        }

        return booleanMatrix;
    }

    /**
     * Check top, bot, left, right lines and get average luminance of background.
     * @param luminance black-n-white matrix image.
     */
    private static int backgroundLuminanceDetection(int[][] luminance) {
        int width = luminance[0].length;
        int height = luminance.length;
        int averageLuminance = 0;
        for (int i = 0; i < width; i++) {
            averageLuminance += luminance[0][i];
            averageLuminance += luminance[height - 1][i];
        }
        for (int i = 0; i < height; i++) {
            averageLuminance += luminance[i][0];
            averageLuminance += luminance[i][width - 1];
        }

        averageLuminance /= ((width * 2) + (height * 2));

        return averageLuminance;
    }
}
