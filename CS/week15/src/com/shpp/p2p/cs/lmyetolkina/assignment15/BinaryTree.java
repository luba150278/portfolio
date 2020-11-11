package com.shpp.p2p.cs.lmyetolkina.assignment15;

/**
 * Form binary tree and find binary codes for unique text symbols
 */
public class BinaryTree implements Comparable<BinaryTree>{

    final Byte symbol;
    final int weight;
    BinaryTree left;
    BinaryTree right;

    /**
     * This constructor use to form ArrayList with all unique symbols and their frequencies
     * @param symbol - unique text symbol
     * @param weight - symbol frequency in text
     */
    public BinaryTree(Byte symbol, int weight) {
        this.symbol = symbol;
        this.weight = weight;
    }

    /**
     * This constructor use to form tree branches
     * @param symbol new node form from left and right "children" nodes
     * @param weight summary weight (frequencies) left and right free nodes
     * @param left - left child (free node)
     * @param right - right child (free node)
     */
    public BinaryTree(Byte symbol, int weight, BinaryTree left, BinaryTree right) {
        this.symbol = symbol;
        this.weight = weight;
        this.left = left;
        this.right = right;
    }

    @Override
    /**
     * Use this method for sort tree nodes by weight
     */
    public int compareTo(BinaryTree object) {
        return object.weight - weight;
    }

    /**
     * Algorithm:
     * To determine the code for each of the symbols included in the text, we must go from the leaf of the tree
     * corresponding to the current symbols to its root, accumulating bits as we move along the branches of the tree
     * (the first branch in the path corresponds to the least significant bit). The sequence of bits obtained
     * in this way is the code of this character, written in reverse order.
     *
     * @param foundNodes
     * @param parentPath - The code string contains "0" and "1". None of the received codes are a prefix of the other!
     * @return
     */
    public String getCodeForSymbol(Byte foundNodes, String parentPath) {
        if (symbol==foundNodes) {
            return  parentPath;
        } else {
            if (left != null) {
                String path = left.getCodeForSymbol(foundNodes, parentPath + 0);
                if (path != null) {
                    return path;
                }
            }
            if (right != null) {
                String path = right.getCodeForSymbol(foundNodes, parentPath + 1);
                return path;
            }
        }
        return null;
    }
}
