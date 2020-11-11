package com.shpp.p2p.cs.lmyetolkina.assignment6.Assignment6Part3;

public class ToneMatrixLogic {
    /**
     * Given the contents of the tone matrix, returns a string of notes that should be played
     * to represent that matrix.
     *
     * @param toneMatrix The contents of the tone matrix.
     * @param column     The column number that is currently being played.
     * @param samples    The sound samples associated with each row.
     * @return A sound sample corresponding to all notes currently being played.
     */
    public static double[] matrixToMusic(boolean[][] toneMatrix, int column, double[][] samples) {
        /*Array with sum sounds white cells in the same column (normalizing)*/
        double[] result = new double[ToneMatrixConstants.sampleSize()];

        /*Create array sounds waves for current column*/
        for (int i = 0; i < toneMatrix.length; i++) {
            if (toneMatrix[i][column]) {
                result = sumSamples(result, samples[i]);
            }
        }
        /*Normalize of array*/
        return normalize(result);
    }

    /**
     * Sum sounds waves of the all white cells in the column
     *
     * @param result sum sounds waves of the previous white cells in the column
     * @param sample the sound wave of the next white cell in the column
     * @return sum sounds waves of the all white cells in the column
     */
    private static double[] sumSamples(double[] result, double[] sample) {
        double[] sumSounds = new double[result.length];
        for (int i = 0; i < sample.length; i++)
            sumSounds[i] = result[i] + sample[i];
        return sumSounds;
    }

    /**
     * Normalize of sounds array
     *
     * @param result - non-normalize array
     * @return normalize array
     */
    private static double[] normalize(double[] result) {
        /*Find max value of sound wave*/
        double max = result[0];
        /*Find sum of sounds waves*/
        for (double soundWave : result) {
            if (Math.abs(soundWave) > Math.abs(max)) max = soundWave;
        }
        /*Create normalize array of sounds waves to current column*/
        if (max != 0) {
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] / max;
            }
        }
        return result;
    }
}
