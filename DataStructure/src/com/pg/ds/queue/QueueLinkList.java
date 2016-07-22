package com.pg.ds.queue;

public class QueueLinkList<E> {

	Node<E> head = null;
	Node<E> last = null;
	int size = 0;

	public QueueLinkList() {
		last = head = new Node<E>(null);
	}

	/*
	 * public void enQueue(E data) { Node<E> newNode = new Node<E>(data, null);
	 * size++; if (head.next == null) { head.next = newNode; last.next =
	 * head.next; return; } last.next.next = newNode; last.next = newNode;
	 * return; }
	 * 
	 * public E deQueue() { size--; E data = null; if (head.next == null) {
	 * return null; } if (size > 0) { data = head.next.data; head.next =
	 * head.next.next; } if (size == 0) { data = head.next.data; head = null;
	 * last = null; } return data; }
	 */

	private E deQueue() {
		// assert takeLock.isHeldByCurrentThread();
		Node<E> h = head;
		Node<E> first = h.next;
		h.next = h; // help GC
		head = first;
		E x = first.item;
		first.item = null;
		return x;
	}

	public static void main(String[] args) {

		int[] intArr = new int[] { 1, 2, 3, 4, 5 };

		QueueLinkList<Integer> queueLL = new QueueLinkList<Integer>();

		for (int i : intArr) {
			queueLL.enQueue(i);
		}

		for (int i=0;i<3;i++) {
			System.out.println(i + ": " + queueLL.deQueue());
		}
		System.out.println("--------------");
		for (int i=0;i<3;i++) {
			queueLL.enQueue(i*3);
		}
		for (int i=0;i<5;i++) {
			System.out.println(i + ": " + queueLL.deQueue());
		}
	}

	public void enQueue(E x) {
		// assert putLock.isHeldByCurrentThread();
		last = last.next = new Node<E>(x);
	}
}

class Node<E> {
	E item;
	Node<E> next;

	public Node(E item) {
		this.item = item;
	}
}