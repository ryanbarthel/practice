package com.practice.linkedlist;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.testng.Assert.assertNull;

/**
 * Created by rbarthel on 9/17/16.
 */
public class LLTest {

    @Test
    public void testOrderedInsert() {
        OrderedLinkedList ll = new OrderedLinkedList();
        ll.orderedInsert(10);
        ll.orderedInsert(7);
        ll.orderedInsert(9);
        ll.orderedInsert(2);
        ll.orderedInsert(0);
        ll.orderedInsert(5);

        OrderedLinkedList.Node node = ll.getHead();
        int last = node.getValue();
        node = node.getNext();
        while (node != null) {
            assert last < node.getValue();
            last = node.getValue();
            node = node.getNext();
        }

    }

    @Test
    public void testDuplicates() {
        LinkedListImpl<Integer> ll = new LinkedListImpl<>();
        for (int i = 0; i < 100; i++) {
            LLNode<Integer> node = new LLNode<>();
            if (i != 0) {
                if (i % 3 == 0) {
                    node.setData(ll.get(i-1).getData());
                } else {
                    node.setData(i*2);
                }
            } else {
                node.setData(0);
            }
            ll.insert(node);
        }

        ll.deleteDuplicates();
        Map<Integer, LLNode<Integer>> values = new HashMap<>();
        LLNode<Integer> current = ll.getHead();
        while (current != null) {
            System.out.println("value: " + current.getData());
            assertNull(values.get(current.getData()));
            values.put(current.getData(), current);
            current = current.getNext();
        }

    }

    @Test
    public void testDuplicatesNoBuffer() {
        LinkedListImpl<Integer> ll = new LinkedListImpl<>();
        for (int i = 0; i < 100; i++) {
            LLNode<Integer> node = new LLNode<>();
            if (i != 0) {
                if (i % 3 == 0) {
                    node.setData(ll.get(i-1).getData());
                } else {
                    node.setData(i*2);
                }
            } else {
                node.setData(0);
            }
            ll.insert(node);
        }

        ll.deleteDuplicatesSansBuffer();
        Map<Integer, LLNode<Integer>> values = new HashMap<>();
        LLNode<Integer> current = ll.getHead();
        while (current != null) {
            System.out.println("value: " + current.getData());
            assertNull(values.get(current.getData()));
            values.put(current.getData(), current);
            current = current.getNext();
        }

    }

    public static void main(String[] args) {
        System.out.println(9%10);
    }

    @Test
    public void testReverse() {
        LinkedListImpl<Integer> ll = new LinkedListImpl<>();
        ll.insert(new LLNode<Integer>(7));
        ll.insert(new LLNode<Integer>(8));
        ll.insert(new LLNode<Integer>(9));
        ll.insert(new LLNode<Integer>(1));
        ll.insert(new LLNode<Integer>(3));
        ll.insert(new LLNode<Integer>(5));

        LLNode<Integer> node = ll.reverse2();
        while(node != null) {
            System.out.println(node.getData());
            node = node.getNext();
        }
    }

    public int compare(LinkedListImpl<Character> list1, LinkedListImpl<Character> list2) {
        if (list1.getSize() > list2.getSize()) {
            return 1;
        } else if (list1.getSize() < list2.getSize()) {
            return -1;
        } else {
            LLNode<Character> node1 = list1.getHead();
            LLNode<Character> node2 = list2.getHead();
            while (node1 != null && node2 != null) {
                if (node1.getData() > node2.getData()) {
                    return 1;
                } else if (node1.getData() < node2.getData()) {
                    return -1;
                }
                node1 = node1.getNext();
                node2 = node2.getNext();
            }
        }
        return 0;

    }

    public static LLNode<Integer> intersection(LLNode<Integer> head1, LLNode<Integer> head2) {
        LinkedListImpl<Integer> retval = new LinkedListImpl<>();
        LLNode<Integer> curr1 = head1;
        while (curr1 != null) {
            LLNode<Integer> curr2 = head2;
            while (curr2 != null) {
                if (curr1.getData() == curr2.getData()) {
                    retval.insert(new LLNode<>(curr1.getData()) );
                }
                curr2 = curr2.getNext();
            }
            curr1 = curr1.getNext();

        }
        return retval.getHead();
    }


    @Test
    public void testMergeSort() {
        LLNode<Integer> head = new LLNode<>(0);
        LLNode<Integer> current = new LLNode<>(0);
        head.setNext(current);
        for (int i = 0 ; i < 1000 ; i++) {
            Random rand = new Random();
            int r = rand.nextInt(200);
            LLNode<Integer> next = new LLNode<>(r);
            current.setNext(next);
            current = next;
        }

        LLNode<Integer> sorted = mergeSort(head);
        int curr = sorted.getData();
        while (sorted != null) {
            assert curr <= sorted.getData();
            sorted = sorted.getNext();
        }

    }


    private LLNode<Integer> mergeSort(LLNode<Integer> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        LLNode<Integer> node = head;
        LLNode<Integer> mid = getMid(head);
        LLNode<Integer> node2 = mid.getNext();
        mid.setNext(null);

        mergeSort(node);
        mergeSort(node2);
        head = merge (node, node2);
        return head;

    }

    private LLNode<Integer> merge(LLNode<Integer> a, LLNode<Integer> b) {
        LLNode<Integer> result = null;
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        if (a.getData() <= b.getData()) {
            result = a;
            result.setNext(merge(a.getNext(), b));
        } else {
            result = b;
            result.setNext(merge(a, b.getNext()));
        }
        System.out.println("MERGE RESULT: " + result);
        return result;
    }

    private LLNode<Integer> getMid(LLNode<Integer> head) {
        LLNode<Integer> fast = head.getNext();
        LLNode<Integer> slow = head;
        while( fast != null &&fast.getNext() !=null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }


}
