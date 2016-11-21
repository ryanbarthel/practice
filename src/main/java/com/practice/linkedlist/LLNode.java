// Copyright (C) 2016 Interactions Corporation
// All rights reserved
package com.practice.linkedlist;

public class LLNode<T> {
	private T data;
	private LLNode<T> next;
	
	public LLNode() {}

	public LLNode(T data) {
		this.data = data;
	}
	
	public LLNode(LLNode<T> other) {
		this.data= other.getData();
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public LLNode<T> getNext() {
		return next;
	}

	public void setNext(LLNode<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "LLNode{" +
				"data=" + data +
				", next=" + next +
				'}';
	}
}
