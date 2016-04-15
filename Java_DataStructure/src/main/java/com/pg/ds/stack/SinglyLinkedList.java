package com.pg.ds.stack;

public class SinglyLinkedList<X> {

	/**
	 * 
	 */
	public static void main(String[] args) {

		SinglyLinkedList<String> sllStr = new SinglyLinkedList<String>();
		sllStr.add("A1");
		sllStr.add("A2");
		sllStr.add("A3");

		/*System.out.println("1. " + sllStr.pop());
		System.out.println("2. " + sllStr.pop());
		System.out.println("3. " + sllStr.pop());*/
		int i=0;
		String data=null;
		while( (data= sllStr.get(i)) != null){
			System.out.println(i+": "+data);
			i++;
		}

	}

	private Node<X> head = null;

	public SinglyLinkedList() {
		head = new Node<X>(null, null);
	}

	public X get(int index) {
		Node<X> tmp = head.next;
		
		for (int i = 1; i <= index; i++) {
			if(null != tmp){
				tmp = tmp.next;
			}
		}
		if (null != tmp) {
			return tmp.data;
		}
		return null;
	}

	public boolean add(X data) {

		Node<X> newNode = new Node<X>(data, head.next);
		// newNode.data=data;
		head.next = newNode;
		// head = newNode;

		return true;
	}

	public X pop() {
		X data = head.next.data;
		Node<X> nextNode = head.next.next;
		head.next = nextNode;
		return data;
	}

	private class Node<X> {
		private X data;
		private Node<X> next;

		public Node(X data, Node<X> next) {
			this.data = data;
			this.next = next;
		}
	}
}
