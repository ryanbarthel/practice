package com.practice.binary;

/**
 * Created by rbarthel on 9/11/16.
 */
public class Node {
    private int value;

    private int duplicateCount;

    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getDuplicateCount() {
        return this.duplicateCount;
    }

    public void incrementDuplicateCount() {
        this.duplicateCount++;
    }
}
