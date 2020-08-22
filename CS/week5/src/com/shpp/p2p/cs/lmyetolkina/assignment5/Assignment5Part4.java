package com.shpp.p2p.cs.lmyetolkina.assignment5;

import com.shpp.cs.a.console.TextProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Displays data from a column in a CSV-file. The column index is set by the user.
 */
public class Assignment5Part4 extends TextProgram {
    /* The name of the CSV-file. */
    private static final String CSV_FILE = "food-origins.csv";

    @Override
    public void run() {
        int columnIndex = Integer.parseInt(readLine("Please, enter a column index:"));
        /*Extract data from the chosen column*/
        ArrayList<String> result = extractColumn(columnIndex);
        /*Print the result array*/
        for (String x : result) println(x);
    }

    /**
     * Read lines from the file and separate by columns
     * @param columnIndex
     * @return result array
     */
    private ArrayList<String> extractColumn(int columnIndex) {
        ArrayList<String> result = new ArrayList<>();
        String resultString;
        try {
            BufferedReader br = new BufferedReader(new FileReader(CSV_FILE));
            while (true) {
                String string = br.readLine();
                if (string == null) break;
                ArrayList<String> lines = fieldsIn(string);
                int comma = lines.get(0).indexOf(",");
                int count = 0;

                /*Check the place of the comma. If the comma is placed between pair quotes, then we use the next comma. */
                for (int j = 0; j < lines.get(0).length(); j++) {
                    if (lines.get(0).charAt(j) == '\"') {
                        count++;
                        if (j < comma && count % 2 != 0) comma = lines.get(0).indexOf(",", comma + 1);
                    }
                }

                /*If the index column is 0, we take part of the string before the comma, otherwise we take
                * part of string after comma.*/
                resultString = (columnIndex == 0)? lines.get(0).substring(0, comma) :  lines.get(0).substring(comma + 1);
                /*Delete all quotes from result string.*/
                resultString = resultString.replaceAll("\"", "");
                result.add(resultString);
            }
            br.close();

        } catch (IOException e) {
            println(null);
        }
        return result;
    }

    /**
     * Take line from file and put to array
     * @param line - one string from file
     * @return string array
     */
    private ArrayList<String> fieldsIn(String line) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add(line);
        return arr;
    }
}
