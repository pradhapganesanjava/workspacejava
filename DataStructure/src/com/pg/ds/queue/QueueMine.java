package com.pg.ds.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class QueueMine<E> {

	private int INITIAL_CAPACITY=5;
	private E[] elements;
	
	int head = 0;
	int tail =0;
	
	public QueueMine(int capasity) {
		elements = (E[]) new Object[capasity];
	}
	
	public QueueMine() {
		elements = (E[]) new Object[INITIAL_CAPACITY];
	}
	public void add(E element){
		if((tail+1)>elements.length){
			elements = increaseCapasity();
		}
		elements[tail]=element;
		tail++;
	}

	public E poll(){
		E returnElem = null;
		if(head>=tail){
			System.out.println("No element in the queue");
			return null;
		}else{
			returnElem = elements[head];
			elements[head]=null;
			head++;
		}
		return returnElem;
	}

	private E[] increaseCapasity() {
		int elemLen = elements.length;
		E[] newElements = (E[])(new Object[elemLen+INITIAL_CAPACITY]);
		for(int i=0;i<elements.length;i++){
			newElements[i]=elements[i];
		}
		System.out.println("capasity increased Old"+Arrays.toString(elements)+" NEW: "+Arrays.toString(newElements));
		return newElements;
	}
	
	public static void main(String[] args) {

		QueueMine<String> simpqueue = new QueueMine<String>(5);
		ArrayQueueDup<String> queue = new ArrayQueueDup<String>(3);

		String[] strArr = new String[] { "0","1", "2", "3", "4","5","51","7"};

		int index=0;
		for(String str : strArr){
			queue.add(str);
			System.out.println(index+":"+str);
			index++;
		}
		
		/*index=0;
		for(String str : strArr){
			System.out.println(index+":"+queue.poll());
		index++;	
		}*/

		System.out.println(":"+queue.poll());	
		System.out.println(":"+queue.poll());	
		
		queue.add("11");
		queue.add("12");
		queue.add("13");
		queue.add("14");
		
		System.out.println(":"+queue.poll());		
		System.out.println(":"+queue.poll());
		/*queue.add("7");

		System.out.println(":"+queue.poll());		
		queue.add("8");
		queue.add("9");
		queue.add("10");
		queue.add("11");
		queue.add("12");
		
		
		System.out.println(":"+queue.poll());
		System.out.println(":"+queue.poll());
		System.out.println(":"+queue.poll());*/
		
	}

}
