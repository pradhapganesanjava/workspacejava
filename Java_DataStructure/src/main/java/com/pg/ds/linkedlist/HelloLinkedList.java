package com.pg.ds.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class HelloLinkedList {

	/**
	 * LinkedList can we say Last IN Last OUT?
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {

		LinkedList<String> strLinkLst = null;

		String[] strArr = new String[] { "A", "B", "C", "D", "E" };

		strLinkLst = loadLinkedList(strArr);
		printLinkedList(strLinkLst);
		
		for(int i=0;i<5;i++){
			System.out.println("POLL"+i+":"+strLinkLst.poll());
		}
		
		strLinkLst = loadLinkedList(strArr);
		
		for(int i=0;i<5;i++){
			System.out.println("POP"+i+":"+strLinkLst.poll());
		}
		
		strLinkLst = loadLinkedList(strArr);
		printLinkedList(strLinkLst);
		
		System.out.println("strLinkLst size : "+strLinkLst.size());	
		System.out.println("LinkLst.element  :"+strLinkLst.element());
		
		System.out.println("LinkLst.get(index)  :"+strLinkLst.get(0));
		System.out.println("LinkLst.getFirst  :"+strLinkLst.getFirst());
		
		System.out.println("LinkLst.peek  :"+strLinkLst.peek());
		System.out.println("LinkLst.peekFirst  :"+strLinkLst.peekFirst());
		
		System.out.println("LinkLst.add ADD :"+strLinkLst.add("ADD"));
		System.out.println("LinkLst.peek after add :"+strLinkLst.peek());
		System.out.println("LinkLst.peekLast after add :"+strLinkLst.peekLast());

		System.out.println("LinkLst.offer OFFER  :"+strLinkLst.offer("OFFER"));
		System.out.println("LinkLst.peek after offer(=add) :"+strLinkLst.peek());
		System.out.println("LinkLst.peekLast after offer(=add) :"+strLinkLst.peekLast());

		System.out.println("LinkLst.getLast  :"+strLinkLst.getLast());
		System.out.println("LinkLst.peekLast  :"+strLinkLst.peekLast());
		
		System.out.println("LinkLst.poll  :"+strLinkLst.poll());
		System.out.println("LinkLst.peek after poll :"+strLinkLst.peek());
		System.out.println("LinkLst.peekLast after poll :"+strLinkLst.peekLast());
		
		System.out.println("LinkLst.pop  :"+strLinkLst.pop());
		System.out.println("LinkLst.peek after pop :"+strLinkLst.peek());
		System.out.println("LinkLst.peekLast after pop :"+strLinkLst.peekLast());

		int count=0;
		for(Iterator<String> strItr=strLinkLst.iterator();strItr.hasNext();){
			System.out.println(count+":"+strItr.next());
			count++;
		}
		
	}

	private static LinkedList<String> loadLinkedList(String[] strArr) {
		LinkedList<String> strLinkLst = new LinkedList<String>();
		
		int index=0;
		for(String str : strArr){
			//strLinkLst.push(str);//insert the element front of the list
			strLinkLst.add(str);//insert the element front of the list
			//System.out.println(index+":"+str);
			index++;
		}
		return strLinkLst;
	}

	private static void printLinkedList(LinkedList<String> linkList) {
		for(int i = 0; i < linkList.size(); i++){
			System.out.println(i+":"+linkList.get(i));
		}
	}
}
