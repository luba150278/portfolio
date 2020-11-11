package com.shpp.p2p.cs.lmyetolkina.assignment15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

/**
 * Haffman algorithm to code unique text symbols
 */
public class Haffman {

    private final TreeMap<Byte, Integer> frequencies;

    public Haffman(TreeMap<Byte, Integer> frequencies){
        this.frequencies = frequencies;
    }

    /**
     * Add all unique symbols and their frequencies (weights) to array list of free nodes
     * @return
     */
    public ArrayList<BinaryTree> findTreeNodes() {
        ArrayList<BinaryTree> treeNodes = new ArrayList<>();
        for (Byte node : frequencies.keySet()) {
            treeNodes.add(new BinaryTree(node, frequencies.get(node)));
        }
        return treeNodes;
    }

    /**
     * Form binary tree by Haffman algorithm:
     * 1. Two free tree nodes with the least weights are selected.
     * 2. Their parent is created with a weight equal to their total weight.
     * 3. The parent is added to the free list, and its two children are removed from the free list.
     * 4. Bit 1 (right) is assigned to one arc outgoing from the parent, bit 0 (left) to the other.
     * The bit values of branches outgoing from the root do not depend on the weights of the children.
     * 5.The steps are repeated until only one free node remains in the free list. He will be considered
     * the root of the tree.
     * @param treeNodes - array list with all unique symbols and their frequencies
     * @return
     */
    public  BinaryTree huffman(ArrayList<BinaryTree> treeNodes) {
        while (treeNodes.size() > 1) {
            Collections.sort(treeNodes);

            BinaryTree left = treeNodes.remove(treeNodes.size() - 1);
            BinaryTree right = treeNodes.remove(treeNodes.size() - 1);

            BinaryTree parent = new BinaryTree(null, right.weight + left.weight, left, right);

            treeNodes.add(parent);
        }
        return  treeNodes.get(0);
    }

    /**
     * Find binary code for each symbol. Use "getCodeForSymbol" method (class "BinaryTree) for it.
     * @param tree - Haffman binary tree
     * @return - code table: each of unique symbol has binary code. None of the received codes are a prefix of the other!
     */
    public TreeMap<Byte, String> findAllCodes(BinaryTree tree) {
        TreeMap<Byte, String> codes = new TreeMap<>();
        for (Byte symbol : frequencies.keySet()) {
            codes.put(symbol, tree.getCodeForSymbol(symbol, ""));
        }
        return codes;
    }
}
