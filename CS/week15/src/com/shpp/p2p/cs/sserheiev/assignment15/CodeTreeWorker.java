package com.shpp.p2p.cs.sserheiev.assignment15;


import java.util.Queue;

public class CodeTreeWorker {
    /**
     * Symbol code storage.
     */
    private static String symbolCode = null;

    /**
     * Build code tree based on priority queue.
     * @param sortedQueue priority queue of tree leafs.
     * @return one node which is a binary tree.
     */
    public static TreeNode buildCodeTree(Queue<TreeNode> sortedQueue) {
        while (sortedQueue.size() != 1) {
            TreeNode left = sortedQueue.poll();
            TreeNode right = sortedQueue.poll();
            int count = left.getCount() + right.getCount();
            TreeNode node = new TreeNode(null, count, left, right);
            sortedQueue.add(node);
        }
        return sortedQueue.poll();
    }

    /**
     * Find code for symbol, based on binary tree search.
     * @param symbol look for symbol.
     * @param node current node. In first step it's always the root.
     * @return code for symbol, which is a road from the root to leaf, where value of the leaf is the look for symbol.
     */
    public static String getCodeForeSymbol(Integer symbol, TreeNode node) {
        String bitSequence = "";
        String codeForSymbol = findSymbolAndItsCode(node, symbol, bitSequence);
        resetSymbolCode();
        return codeForSymbol;
    }

    /**
     * Main logic of code search.
     * @param node current node.
     * @param symbol look for symbol.
     * @param bitSequence current "road" to the look for symbol.
     * @return code of symbol.
     */
    private static String findSymbolAndItsCode(TreeNode node, Integer symbol, String bitSequence) {
        if (node.getValue() != null && node.getValue().equals(symbol)) {
            symbolCode = bitSequence;
            return symbolCode;
        } else {
            if (node.getLeftNode() != null && symbolCode == null) {
                symbolCode = findSymbolAndItsCode(node.getLeftNode(), symbol, (bitSequence += "0"));
                bitSequence = bitSequence.substring(0, bitSequence.length() - 1);
            }
            if (node.getRightNode() != null && symbolCode == null) {
                symbolCode = findSymbolAndItsCode(node.getRightNode(), symbol, (bitSequence += "1"));
                bitSequence = bitSequence.substring(0, bitSequence.length() - 1);
            }
        }
        return symbolCode;
    }

    private static void resetSymbolCode() {
        symbolCode = null;
    }

}
