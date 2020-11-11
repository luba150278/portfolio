package com.shpp.p2p.cs.lmyetolkina.assignment7.Assignment7Part1;

/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

import java.util.*;

public class NameSurferEntry implements NameSurferConstants {

    /* Constructor: NameSurferEntry(line) */
    public final HashMap<String, ArrayList<Integer>> nameSurferEntry = new HashMap<>();

    /**
     * Creates a new NameSurferEntry from a data line as it appears
     * in the data file.  Each line begins with the name, which is
     * followed by integers giving the rank of that name for each
     * decade.
     */
    public NameSurferEntry(String line) {
        // You fill this in
        String[] arr = line.split(" ", 0);
        String[] newArray = Arrays.copyOfRange(arr, 1, arr.length );
        ArrayList<Integer> newInt = new ArrayList<>();
        for (String s : newArray) {
            newInt.add(Integer.parseInt(s));
        }
        nameSurferEntry.put(arr[0], newInt);
    }

    /**
     * Returns the name associated with this entry.
     */
    public String getName() {
        String name = "";
        for (Map.Entry<String, ArrayList<Integer>> entry : nameSurferEntry.entrySet()) {
            name = entry.getKey();
        }
        return name;
    }

    /**
     * Returns the rank associated with an entry for a particular
     * decade.  The decade value is an integer indicating how many
     * decades have passed since the first year in the database,
     * which is given by the constant START_DECADE.  If a name does
     * not appear in a decade, the rank value is 0.
     */
    public int getRank(int decade) {
        ArrayList<Integer> ranksArray = new ArrayList<>();
        for (Map.Entry<String, ArrayList<Integer>> entry : nameSurferEntry.entrySet()) {
            ranksArray = entry.getValue();
        }
        return ranksArray.get(decade);
    }

    /**
     * Returns a string that makes it easy to see the value of a
     * NameSurferEntry.
     */
    public String toString() {
        return nameSurferEntry.entrySet().toString();
    }
}

