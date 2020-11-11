package com.shpp.p2p.cs.sserheiev.assignment15;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Yes, I didn't comment this class. I think class and method naming is sufficient.
 * Everything I wanna tell, this class do some logic before encoding.
 */
public class Preprocessor {
    public static Map<Integer, Integer> countSymbolsInFile(String fileName) {
        HashMap<Integer, Integer> symbolFrequencyMap = new HashMap<>();
        try (FileInputStream parentFis = new FileInputStream(fileName);
             BufferedInputStream fis = new BufferedInputStream(parentFis, 128)) {

            int readValue;
            while ((readValue = fis.read()) != -1) {
                if (symbolFrequencyMap.containsKey(readValue)) {
                    symbolFrequencyMap.put(readValue, symbolFrequencyMap.get(readValue) + 1);
                } else {
                    symbolFrequencyMap.put(readValue, 1);
                }
            }

        } catch (IOException e) {
        }
        return symbolFrequencyMap;
    }

    public static PriorityQueue<TreeNode> makeSortedQueue(Map<Integer, Integer> symbolsCounterMap) {
        PriorityQueue<TreeNode> sortedQueue = new PriorityQueue<>();
        for (Integer key : symbolsCounterMap.keySet()) {
            int symbol = key;
            int value = symbolsCounterMap.get(key);
            TreeNode node = new TreeNode(symbol, value);
            sortedQueue.add(node);
        }
        return sortedQueue;
    }
}
