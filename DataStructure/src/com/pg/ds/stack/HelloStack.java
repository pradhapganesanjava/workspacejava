package com.pg.ds.stack;

import java.util.Iterator;
import java.util.Stack;

public class HelloStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Stack<String> stack = new Stack<String>();
		
		String[] strArr = new String[]{"A", "B", "C", "D","E"};
		int index = 0;
		for(String str:strArr){
			System.out.println(index+":"+str);
			stack.push(str);
			index++;
		}
		
		System.out.println("stack capacity : "+stack.capacity());
		System.out.println("stack size : "+stack.size());

		System.out.println("stack peek : "+stack.peek());
		System.out.println("stack pop : "+stack.pop());
		System.out.println("stack after pop - peek : "+stack.peek());
		
		System.out.println("stack firstElement : "+stack.firstElement());
		System.out.println("stack elementAt : "+stack.elementAt(1));
		System.out.println("stack indexOf : "+stack.indexOf("D"));
		System.out.println("stack push : "+stack.push("PUSH"));//Pushes the element front of the list
		System.out.println("stack peek : "+stack.peek());
		System.out.println("stack search : "+stack.search("D"));
		
		int count=0;
		for(Iterator<String> strItr=stack.iterator();strItr.hasNext();){
			System.out.println(count+":"+strItr.next());
			count++;
		}
		
	}

}
