package com.pg.ds.stack;

public class StackLinkList<E> {

	
	public static void main(String[] str){
		
	StackLinkList<String> myStack = new StackLinkList<String>();
		myStack.push("A");
		myStack.push("B");
		myStack.push("C");
		myStack.push("D");
		
		System.out.println(" pop "+myStack.pop());
	}
	
	
	private Node<E> head = null;
	private Node<E> tail = null;
	
	public StackLinkList() {
		head = new Node<E>(null, null, null);
		tail = head;
	}
	
	public boolean push(E data){
		Node<E> newNode = new Node<E>(data, head.next, head.previous);
		newNode.next=head.next;
		newNode.previous=head.previous;

		head.next=newNode;
		head.previous=newNode.previous;
		head=newNode;
		return true;
	}

	public E pop(){

		E popData = head.data;
		head.next.previous=head.previous;
		head.previous.next=head.next;
		
		return popData;
	}
	
	private class Node<E> {
		E data;
		Node<E> next;
		Node<E> previous;
		
		public Node(E data, Node<E> next, Node<E> previous){
			this.data = data;
			this.next = next;
			this.previous = previous;
		}
	}
}
