package com.shpp.p2p.cs.lmyetolkina.assignment5;

import com.shpp.cs.a.console.TextProgram;

/**
 * Find the count of syllables in a word
 */
public class Assignment5Part1 extends TextProgram {
    private final char[] vowelSounds = {'a', 'e', 'i', 'u', 'y', 'o'}; //vowel array

    public void run() {
        /*If user wants to stop program, he enter <q>*/
        println("Enter <q> to finish program.");
        /*Find count of syllables in a word while don't get <q> */
        while (true) {
            String word = readLine("Please, enter a single word: ");
            if(word.equals("q") || word.equals("Q")) break;
            println("  Syllable count: " + syllablesIn(word.toLowerCase()));
        }
    }

    /**
     * Check chars from 0 to penultimate char index using checkChar method
     * Check last char index using checkLastChar method
     * @param word - the word which to count of the syllables
     * @return a count of the syllables
     */
    private int syllablesIn(String word) {

        int lengthWord = word.length();
        /*Check the null-length word*/
        if (lengthWord == 0) return 0;

        int counterOfSyllables = 0;
        int previousChar = 0;
        int currentChar;

        /*Compare previous and current char. If current char is a vowel and previous char is consonant we add 1
         to counter of syllables.*/
        for (int i = 0; i < lengthWord-1; i++) {
            currentChar = checkChar(word.charAt(i));
            if(currentChar == 1 && previousChar == 0) counterOfSyllables++;
            previousChar = currentChar;
        }
        /*Check last char. It should be a vowel but shouldn't be 'e' char .*/
        counterOfSyllables += checkLastChar(word.charAt(lengthWord-1));

        /*If the word hasn't the syllables but has the letters we add 1 to counter*/
        if (counterOfSyllables == 0) counterOfSyllables++;

        return counterOfSyllables;
    }

    /**
     * Check char to a vowel
     * @param checkedChar - char from the word
     * @return If char is a vowel return 1, otherwise return 0
     */
    private int checkChar(char checkedChar) {
        for (char x : vowelSounds) if (x == checkedChar) return 1;
        return 0;
    }

    /**
     * Check char to a vowel
     * @param checkedChar - char from the word
     * @return If char is a vowel and not 'e' char return 1, otherwise return 0
     */
    private int checkLastChar(char checkedChar) {
        for (char x : vowelSounds) if (x == checkedChar && checkedChar != 'e') return 1;
        return 0;
    }
}
