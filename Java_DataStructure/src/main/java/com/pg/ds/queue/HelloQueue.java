package com.pg.ds.queue;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class HelloQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//Queue<String> queue = new LinkedList<String>();
		Queue<String> queue = new ArrayDeque<String>(5);

		String[] strArr = new String[] { "A", "B", "C", "D","D"};

		/*int index=0;
		for(String str : strArr){
			queue.add(str);
			System.out.println(index+":"+str);
			index++;
		}*/

		queue = loadLinkedList(strArr);
		printLinkedList(queue);
		
		System.out.println("queue size :"+queue.size()); //similar to peek; except throws exception if no element found
		System.out.println("queue.element :"+queue.element()); //similar to peek; except throws exception if no element found
		System.out.println("queue.peek :"+queue.peek());
		System.out.println("queue.poll (read and remove) :"+queue.poll());
		System.out.println("queue.element :"+queue.element());
		System.out.println("queue.add :"+queue.add("A1")); //similar to offer; But add throws exception when limited size
		System.out.println("queue.peek after add:"+queue.peek());
		System.out.println("queue.remove :"+queue.remove("D"));//similar to poll; remove throws exception
		System.out.println("queue.peek after remove:"+queue.peek());
		System.out.println("queue.add :"+queue.offer("A"));
		System.out.println("queue.peek after offer(=add):"+queue.peek());
	
		int count =0;
		for(Iterator<String> strItr=queue.iterator();strItr.hasNext();){
			System.out.println(count+":"+strItr.next());count++;
		}
	
	}
	
	private static LinkedList<String> loadLinkedList(String[] strArr) {
		LinkedList<String> strLinkLst = new LinkedList<String>();
		
		int index=0;
		for(String str : strArr){
			strLinkLst.add(str);
			//System.out.println(index+":"+str);
			index++;
		}
		return strLinkLst;
	}

	private static void printLinkedList(Queue<String> queueList) {
		int i=0;
		for(Iterator it =queueList.iterator();it.hasNext();i++){
			System.out.println(i+":"+it.next());
		}
	}
}
