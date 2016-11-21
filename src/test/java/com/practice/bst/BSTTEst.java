package com.practice.bst;

import com.practice.binary.BinarySearchTree;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by rbarthel on 9/23/16.
 */
public class BSTTEst {

    @Test
    public void testInorder() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(7);
        bst.insert(0);
        bst.insert(1);
        bst.insert(10);
        bst.insert(2);
        bst.insert(11);
        bst.insert(2);

        List<Integer> list = bst.traverseInOrder();
        System.out.println(list);
        int prev = bst.getMinimum();
        for (Integer i: list) {
            assert prev <= i;
            prev = i;
        }

    }

    @Test
    public void testPreorder() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(7);
        bst.insert(0);
        bst.insert(1);
        bst.insert(10);
        bst.insert(2);
        bst.insert(11);
        bst.insert(2);
        bst.print();
        List<Integer> list = bst.traversePreOrder();
        System.out.println(list);
        int prev = bst.getMinimum();
        for (Integer i: list) {
            assert prev <= i;
            prev = i;
        }


    }

    @Test
    public void testMinDepth() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(7);
        bst.insert(0);
        bst.insert(1);
        bst.insert(10);
        bst.insert(2);
        bst.insert(11);
        bst.insert(2);
        //bst.print();
        System.out.println(bst.getMinimumDepth());

    }
}
