package com.shpp.p2p.cs.sserheiev.assignment15;

import java.util.Objects;

/**
 * Node of a binary code-tree.
 */
public class TreeNode implements Comparable {
    private Integer value;
    private Integer count;
    private TreeNode leftNode;
    private TreeNode rightNode;

    private static int recursiveToStringCounter = 0;

    public TreeNode() {
    }

    public TreeNode(Integer value, Integer count) {
        this.value = value;
        this.count = count;
        leftNode = null;
        rightNode = null;
    }

    public TreeNode(Integer value, Integer count, TreeNode leftNode, TreeNode rightNode) {
        this.value = value;
        this.count = count;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getCount() {
        return count;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return Objects.equals(value, treeNode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


    @Override
    public int compareTo(Object o) {
        TreeNode symbol = (TreeNode) o;
        if (count > symbol.count) return 1;
        if (count < symbol.count) return -1;
        return 0;
    }

    @Override
    public String toString() {
        int recursiveInnerCounter = recursiveToStringCounter;
        String stringRepresentation = "";
        for (int i = 0; i < recursiveInnerCounter; i++) {
            stringRepresentation += "\t";
        }
        char character;
        String charString = "[N]";
        if (value != null) {
            character = (char) value.intValue();
            charString = String.valueOf(character) + "| " + value;
        }
        stringRepresentation += charString + ": " + count;
        stringRepresentation += "\n";

        recursiveToStringCounter++;
        if (leftNode != null) stringRepresentation += leftNode.toString();
        recursiveToStringCounter = recursiveInnerCounter;
        recursiveToStringCounter++;
        if (rightNode != null) stringRepresentation += rightNode.toString();
        return stringRepresentation;
    }
}
