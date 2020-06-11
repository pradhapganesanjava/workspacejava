package com.pg.alg.linkedlist;

public class DoubleLinkedList {

	public static void main(String[] args) {
		int[] iarr = new int[] { 1,2,3,4,5,6 };
		DLL dll = new DLL();
		for(int i : iarr) {
			dll.addFirst(i);
		}
		dll.removeLast();
		dll.removeLast();
		dll.addFirst(1);
		dll.addFirst(2);
		DLL.Node cn = dll.head.next;
		while(cn != null) {
			System.out.println(cn.toString());
			cn = cn.next;
		}
	}
}

class DLL {
	public Node head = null;
	Node tail = null;

	public DLL() {
		head = new Node();
		tail = new Node();

		head.next = tail;
		tail.prev = head;
	}

	public Node addFirst(int val) {
		Node nnd = new Node();
		nnd.val = val;

		nnd.next = head.next;
		nnd.prev = head;

		head.next.prev = nnd;
		head.next = nnd;
		return nnd;
	}

	public Node removeLast() {
		return remove(tail.prev);
	}

	private Node remove(Node node) {
		node.next.prev = node.prev;
		node.prev.next = node.next;
		return node;
	}

	private Node getNode(int val) {
		Node cnd = head.next;
		while (cnd != null) {
			if (cnd.val == val)
				return cnd;
			cnd = cnd.next;
		}
		return null;
	}

	public class Node {
		Node next;
		Node prev;
		int val;

		@Override
		public String toString() {
			return (prev==null?"-":prev.val) + " <-- " + this.val + " --> " + (next==null?"-":next.val);
		}
	}
}
