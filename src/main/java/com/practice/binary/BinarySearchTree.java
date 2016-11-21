package com.practice.binary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbarthel on 9/17/16.
 */
public class BinarySearchTree {

    private Node root;

    public void insert(int value) {
        if (this.root == null) {
            this.root = new Node(value);
            return;
        }
        insertNode(root, value);

    }

    private void insertNode(Node lastNode, int value) {
        if (lastNode.getValue() > value) {
            if (lastNode.getLeft() == null) {
                lastNode.setLeft(new Node(value));
                return;
            } else {
                insertNode(lastNode.getLeft(), value);
            }
        } else if (value == lastNode.getValue()) {
            lastNode.incrementDuplicateCount();
            return;
        }   else {
            if (lastNode.getRight() == null) {
                lastNode.setRight(new Node(value));
                return;
            } else {
                insertNode(lastNode.getRight(), value);
            }
        }
    }

    public List<Integer> traverseInOrder() {
        List<Integer> retval = new ArrayList<Integer>();
        inOrder(retval, this.root);
        return retval;
    }

    private void inOrder(List<Integer> list, Node root) {
        if (root == null) {
            return;
        }
        inOrder(list, root.getLeft());
        list.add(root.getValue());
        if (root.getDuplicateCount() > 0) {
            for (int i = 0; i< root.getDuplicateCount(); i++) {
                list.add(root.getValue());
            }
        }

        inOrder(list, root.getRight());
    }

    public List<Integer> traversePreOrder() {
        List<Integer> retval = new ArrayList<>();
        preOrder(retval, this.root);
        return retval;
    }

    private void preOrder(List<Integer> list, Node root) {
        if (root == null) {
            return;
        }
        list.add(root.getValue());

        if (root.getDuplicateCount() > 0) {
            for (int i = 0; i< root.getDuplicateCount(); i++) {
                list.add(root.getValue());
            }
        }
        preOrder(list, root.getLeft());
        preOrder(list, root.getRight());
    }

    public void print() {
        System.out.println(root.getLeft().getValue());
        System.out.println(root.getLeft().getLeft());
        System.out.println(root.getLeft().getRight().getValue());
        System.out.println(root.getLeft().getRight().getRight().getValue());
        System.out.println(root.getRight().getValue());
        System.out.println(root.getRight().getRight().getValue());
    }



    public int getMinimum() {
        return min(this.root);
    }

    private int min(Node node) {
        if (node.getLeft() == null) {
            return node.getValue();
        } else {
            return min(node.getLeft());
        }
    }

    public int getMinimumDepth() {
        return minDepth(this.root);
    }

    private int minDepth(Node node) {
        if (node.getLeft() == null && node.getRight() == null) {
            return 1;
        }
        if (node.getLeft() == null) {
            return minDepth(node.getRight()) + 1;
        } else if (node.getRight() == null) {
            return minDepth(node.getLeft()) +1;
        } else {
            return Math.min(minDepth(node.getLeft()), minDepth(node.getRight())) +1;
        }
    }
}
