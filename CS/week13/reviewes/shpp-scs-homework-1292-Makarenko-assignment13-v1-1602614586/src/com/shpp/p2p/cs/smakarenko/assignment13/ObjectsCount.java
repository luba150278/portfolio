package com.shpp.p2p.cs.smakarenko.assignment13;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Count objects on the picture
 *
 */
public class ObjectsCount {

    public static int elementCount;
    /**  garbage threshold */
    public static double GARBAGE_THRESHOLD = 0.05; // if object(s) less than 5% we will ignore him

    /**
     * Count objects on the picture
     * @param pixels - array of pixel equivalent
     * @return - count of all objects on the picture
     */
    public int getCount(int[][] pixels, int background) {
        boolean[][] visited = new boolean[pixels.length][pixels[0].length];
        int objNum = 0, max = 0;
        ArrayList<Integer> countsOfElement = new ArrayList<>();
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[row].length; col++) {
                if (!visited[row][col] && pixels[row][col] != background) {
                    elementCount = 1;
                    elementTraversal(pixels, visited, row, col);
                    countsOfElement.add(objNum, elementCount);
                    max = Math.max(max, elementCount);
                    objNum++;
                } else {
                    visited[row][col] = true;
                }
            }
        }
        return checkForGarbage(max, countsOfElement);
    }

    /**
     * Remove garbage
     * @param countsOfElement - all objects on the picture
     * @return count without garbage
     */
    private static int checkForGarbage(int max, ArrayList<Integer> countsOfElement) {
        int qty= 0;
        for (Integer count : countsOfElement) {
            if ((double) count / max > GARBAGE_THRESHOLD)
                qty++;
        }
        return qty;
    }


    /**
     * Object traversal using the depth-first traversal algorithm
     * @param pixels array of pixel equivalent
     * @param visited array of visited
     * @param row - number row
     * @param col - number column
     */
    private static void elementTraversal(int[][] pixels, boolean[][] visited, int row, int col) {
        Stack<Integer> rows = new Stack<>(); // if stack change to queue, program work in depth
        Stack<Integer> cols = new Stack<>();
        int pixelId = pixels[row][col];
        rows.push(row);
        cols.push(col);
        visited[row][col] = true;

        while (!rows.isEmpty() && !cols.isEmpty()) {
            row = rows.pop();
            col = cols.pop();
            elementCount++;


            int right = (col < pixels[0].length-1 && pixelId ==pixels[row][col+1] ? pixelId : -1);
            if (right == pixelId && !visited[row][col + 1]) {
                rows.push(row);
                cols.push((col+1));
                visited[row][col+1] = true;
            }


            int down = (row < pixels.length-1 && pixelId == pixels[row+1][col] ? pixelId : -1);
            if (down == pixelId && !visited[row + 1][col]) {
                rows.push((row+1));
                cols.push(col);
                visited[row+1][col] = true;
            }


            int left = (col > 0 && pixelId == pixels[row][col-1] ? pixelId : -1);
            if (left == pixelId && !visited[row][col - 1]) {
                rows.push(row);
                cols.push((col-1));
                visited[row][col-1] = true;
            }


            int up = (row > 0 && pixelId == pixels[row-1][col] ? pixelId : -1);
            if (up == pixelId && !visited[row - 1][col]) {
                rows.push((row-1));
                cols.push(col);
                visited[row-1][col] = true;
            }

        }
    }
}