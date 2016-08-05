package com.pg.algorithm.linkedlist.reverse;

public class ReverseLinkedList {
	private Node head;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public void reverseList() {

		Node prev = null;
		Node curr = null;
		Node nxt = head;

		while (nxt != null) {
			curr = nxt;
			nxt = nxt.getNext();
			curr.setNext(prev);
			prev = curr;
		}
		head = curr;
	}

	public static void main(String[] args) {

		ReverseLinkedList list = new ReverseLinkedList();
		list.createTestList(10);
		list.printlist();
		list.reverseList();
		list.printlist();
	}

	public void createTestList(int n) {

		if (n < 1)
			return;

		int i = 1;
		Node temp = null;
		while (i <= n) {
			Node node = new Node(i);
			if (head == null) {
				head = node;
				temp = head;
			} else {
				temp.setNext(node);
				temp = node;
			}
			i++;
		}
	}

	public void printlist() {

		Node temp = head;
		while (temp != null) {
			System.out.print(temp.getData() + " -> ");
			temp = temp.getNext();
		}
		System.out.println("X");
	}

	class Node {

		private int data;
		private Node next;

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node(int data) {
			super();
			this.data = data;
		}

	}

	private void reverseLinkedListRecursive(Node curr) {

		if (curr == null) {
			return;
		}

		if (curr.getNext() == null) {
			this.head = curr;
			return;
		}

		reverseLinkedListRecursive(curr.getNext());
		curr.getNext().setNext(curr);
		curr.setNext(null);
	}
}
