package com.practice.linkedlist;

/**
 * Created by rbarthel on 9/28/16.
 */
public class OrderedLinkedList {
    private Node head;

    public void orderedInsert(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else if (head.getValue() > value) {
            node.setNext(head);
            this.head = node;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                if (current.getNext().getValue() > value) {
                    node.setNext(current.getNext());
                    current.setNext(node);
                    break;
                } else {
                    current = current.getNext();
                }
            }
            //incoming value is bigger than all existing values;
            if (current.getNext() == null) {
                current.setNext(node);
            }

        }
    }

    public void delete(Node start, Node toDelete) {
        if (this.head.equals(toDelete)) {
            this.head = this.head.getNext();
        } else {
            Node current = start;
            while (current.getNext() != null) {
                if (current.getNext().equals(toDelete)) {
                    current.setNext(current.getNext().getNext());

                }

            }
        }


    }
    public Node getHead() {
        return head;
    }

    public class Node {






        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(Node node) {
            this.value = node.getValue();
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (value != node.value) return false;
            return next.equals(node.next);

        }

        @Override
        public int hashCode() {
            int result = value;
            result = 31 * result + next.hashCode();
            return result;
        }
    }
}
