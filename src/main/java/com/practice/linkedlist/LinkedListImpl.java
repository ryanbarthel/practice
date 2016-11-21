// Copyright (C) 2016 Interactions Corporation
// All rights reserved
package com.practice.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LinkedListImpl<T> {
	private int size;
	private LLNode<T> head;
	private LLNode<T> tail;



    public LinkedListImpl(){
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	
	public void insertHead(LLNode<T> newHead) {
		if (size == 0) {
			this.head = newHead;
			this.tail = newHead;
		} else {
			LLNode<T> oldHead = this.head;
			this.head = newHead;
			newHead.setNext(oldHead);
		}
		size++;
	}
	
	public void insert(LLNode<T> newNode) {
		if (size == 0) {
			insertHead(newNode);
		} else {
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
		size++;
	}

	public LLNode<T> reverse() {
		LLNode<T> current = this.head;
		LLNode<T> next = null;
		LLNode<T> prev = null;

		while (current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
			System.out.println("PREV: " + prev + " CURRENT: " + current);
		}
		return prev;
	}

	public void insertAtIndex(int position, LLNode<T> node) {
		size++;
		if (position > this.size - 1) {
			insert(node);
			return;
		}
		if (position == 0) {
			insertHead(node);
			return;
		} 
		int count = 0;
		LLNode<T> current = this.head;
		while (current.getNext() != null) {
			count++;
			if (count == position) {
				node.setNext(current.getNext());
				current.setNext(node);
				break;
			} else {
				current = current.getNext();
			}
			
		}
	}

	public LLNode<T> reverse2() {
		LLNode<T> next;
		LLNode<T> current = this.head;
		LLNode<T> previous = null;
		while (current != null) {
			next = current.getNext();
			current.setNext(previous);
			previous = current;
			current = next;
		}
		return previous;
	}


	
	public void deleteAtIndex(int index) {
		size--;
		if (index == 0) {
			this.head = this.head.getNext();
			return;
		}
		int count = 0;
		LLNode<T> current = this.head;
		while (current.getNext() != null) {
			count++;
			if (index == count) {
				current.setNext(current.getNext().getNext());
				break;
			} else {
				current = current.getNext();
			}
		}
	}

	public LLNode<T> get(int index) {
	    if (index > size - 1) {
	        return null;
        }
	    if (index ==0) {
            return head;
        }
        int count = 1;
        LLNode<T> current = head.getNext();
        LLNode<T> retval = null;
        while(current.getNext() != null) {
            if (count == index) {
                retval = current;
                break;
            } else {
                count++;
            }

        }
        return retval;
    }
	
	public LinkedListImpl<T> deepCopy(LLNode<T> head) {
		LinkedListImpl<T> newList = new LinkedListImpl<T>();		
		LLNode<T> current = head;
		while (current.getNext() != null) {
			newList.insert(new LLNode<T>(current));
			current = current.getNext();
		}
		return newList;
		
	}

	public void deleteDuplicates() {
	    Map<T, LLNode<T>> dataMap = new HashMap<>();
        LLNode<T> current = head;
        int count = 0;
        while (current != null) {
            System.out.println(current.getNext().getData());
            if (dataMap.get(current.getNext().getData()) != null) {
                System.out.println("Removing: " + current.getNext().getData()+ " count: " + count);
                current.setNext(current.getNext().getNext());

            } else {
                dataMap.put(current.getData(), current);

            }
            count++;
            current = current.getNext();
        }
    }

    public void deleteDuplicatesSansBuffer() {
        LLNode<T> current = this.head;
        while (current != null) {
            LLNode<T> inner = current.getNext();

            while (inner != null) {
                if (inner.getNext() != null && inner.getNext().getData() == current.getData()) {
                    inner.setNext(inner.getNext().getNext());
                }
                inner = inner.getNext();
            }
            current = current.getNext();
        }
    }





    public int getSize() {
        return size;
    }

    public LLNode<T> getHead() {
        return head;
    }

    public LLNode<T> getTail() {
        return tail;
    }



}
