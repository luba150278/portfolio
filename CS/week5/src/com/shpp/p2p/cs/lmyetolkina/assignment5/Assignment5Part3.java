package com.shpp.p2p.cs.lmyetolkina.assignment5;

import com.shpp.cs.a.console.TextProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;

/**
 * Search for words that can be made from three letters of a license plate
 */
public class Assignment5Part3 extends TextProgram {
    /* The name of the words file. */
    private static final String DICTIONARY_FILE = "en-dictionary.txt";
    /*Array with the right words */
    private final ArrayList<String> suitableWords = new ArrayList<>();

    @Override
    public void run() {
        /*Read dictionary file with words*/
        ArrayList<String> words = readWords();
        if (words.size() == 0) return;

        println("Enter <q> to finish program.");
        
        /*Find word. Ask user to input word and search the right word in the dictionary*/
        while (true) {
            String userString = readLine("Please, enter a car number: ");
            if (userString.toLowerCase().equals("q")) break;
            boolean result = playGame(userString, words);
            printResult(result, userString);
        }
    }

    /**
     * Read dictionary text file and put words into array.
     *
     * @return array list with all dictionary words
     */
    private ArrayList<String> readWords() {
        ArrayList<String> result = new ArrayList<>();
        /* Open the words file for reading. */
        try (BufferedReader br = new BufferedReader(new FileReader(DICTIONARY_FILE))) {
            while (br.readLine() != null) {
                result.add(br.readLine().toLowerCase());
            }
        } catch (IOException e) {
            println("Can't read or find file");
        }
        return result;
    }

    /**
     * Find array with the all suitable words
     * @param userString - carNumber
     * @param words      - Array list with all words
     * @return true - find onr ore more word combinations, false - don't find
     */
    private boolean playGame(String userString, ArrayList<String> words) {
        String getNumbers = userString.toLowerCase();
        /*Delete non-letters chars*/
        getNumbers = getNumbers.replaceAll("(\\W)|(\\d)", "");
        /*Create char array from the letters in the car number*/
        char[] charArray = getNumbers.toCharArray();
        /*Check the count of the wrapped chars*/
        int counter;                                                       

        /*Iterate over all the words in the array and check the occurrence of characters,
        observing the sequence of their occurrence*/
        for (String word : words) {
            int startPosition = -1;
            counter = 0;

            /*Iterate each char from car number letters*/
            for (char ch : charArray) {
                int checkedIndex = (startPosition != -1) ? startPosition + 1 : 0;
                if (checkedIndex > word.length() - 1) break;

                if (word.indexOf(ch, checkedIndex) >= 0) {
                    if (word.indexOf(ch, checkedIndex) > startPosition) {
                        startPosition = word.indexOf(ch, checkedIndex);
                        if (startPosition == 0) break;
                        counter++;
                    }
                }
            }
            if (counter == charArray.length) suitableWords.add(word);
        }

        return suitableWords.size() > 0;
    }

    /**
     * Print result
     * @param result true - if we have suitable words array, return false if we haven't suitable words/
     * @param userString - car number
     */
    private void printResult(boolean result, String userString) {
        if (result) {
            StringBuilder str = new StringBuilder("You can have " + suitableWords.size() + " word combinations:\n");
            for (String s : suitableWords) {
                str.append(s).append("\n");
            }
            println(str.toString());
        } else {
            println("Can't construct real word using the car number " + userString);
        }
    }
}
