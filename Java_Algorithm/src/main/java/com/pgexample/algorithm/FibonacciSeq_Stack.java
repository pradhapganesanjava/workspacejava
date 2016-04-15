package com.pgexample.algorithm;

import java.util.Iterator;
import java.util.Stack;

public class FibonacciSeq_Stack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int size = 10;
		Stack fibStack = fibonacci_StackImpl(size);
		Iterator fibIter = fibStack.iterator();
		while (fibIter.hasNext()) {
			System.out.print(fibIter.next() + (fibIter.hasNext() ? ", " : ""));
		}
	}

	private static Stack fibonacci_StackImpl(int size) {
		int index = 0;
		Stack<Integer> stack = new Stack<Integer>();
		while (index < size) {
			if (index == 0) {
				stack.push(0);
			} else if (index == 1) {
				stack.push(1);
				index++;
				continue;
			} else {
				int top = stack.pop();
				int topSecond = stack.peek();
				int topNew = top + topSecond;
				stack.push(top);
				stack.push(topNew);
			}
			index++;
		}
		return stack;
	}
}
