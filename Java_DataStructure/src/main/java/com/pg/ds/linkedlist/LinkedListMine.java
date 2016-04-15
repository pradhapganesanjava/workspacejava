package com.pg.ds.linkedlist;

public class LinkedListMine<E> {

	private static class Node<E> {
		E element;
		Node<E> next;
		Node<E> previous;

		public Node(E element, Node<E> next, Node<E> previous) {
			this.element = element;
			this.next = next;
			this.previous = previous;
		}
	}

	private Node<E> head = new Node<E>(null, null, null);
	private Node<E> tail = new Node<E>(null, null, null);

	public boolean add(E element) {
		Node<E> newEntry = new Node<E>(element, head, head.previous);

		newEntry.next.previous = newEntry;
		newEntry.previous.next = newEntry;

		return true;
	}

	public E poll() {
		Node<E> firstNode = head.next;
		firstNode.previous.next = firstNode.next;
		firstNode.next.previous = firstNode.previous;
		return firstNode.element;
	}

	public LinkedListMine() {
		head.next = head.previous = head;
	}

	/**
	 */
	public static void main(String[] args) {

		LinkedListMine<String> llMineStr = new LinkedListMine<String>();
		llMineStr.add("1");
		llMineStr.add("2");
		llMineStr.add("3");
		llMineStr.add("4");

		for (int i = 0; i < 4; i++) {
			System.out.println("polling element: " + llMineStr.poll());
		}
	}
}
