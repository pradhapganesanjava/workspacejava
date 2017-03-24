package com.pg.algorithm.array.integer;

import java.util.Stack;

public class FindNearestGreater {

	public static void main(String[] args) {

		int[] arrInp1 = { 11, 5, 3, 6, 12, 10, 11 };
		printNGE(arrInp1);
	}

	public static void getNGE(int[] a) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(a[0]);

		for (int i = 1; i < a.length; i++) {
			if (s.peek() != null) {
				while (true) {
					if (s.peek() == null || s.peek() > a[i]) {
						break;
					}
					System.out.println(s.pop() + ":" + a[i]);
				}
			}
			s.push(a[i]);
		}
		while (s.peek() != null) {
			System.out.println(s.pop() + ":" + -1);
		}
	}

	public static void printNGE(int[] arr) {
		Stack<Integer> s = new Stack<Integer>();
		int element = 0;
		int next = 0;

		int arrInpLen = arr.length;

		// # push the first element to stack
		s.push(arr[0]);

		// # iterate for rest of the elements
		for (int i = 1; i < arrInpLen; i++) {
			next = arr[i];

			if (!s.isEmpty()) {

				// # if stack is not empty, then pop an element from stack
				element = s.pop();

				/*
				 * If the popped element is smaller than next, then a) print the
				 * pair b) keep popping while elements are smaller and stack is
				 * not empty '''
				 */
				while (element < next) {
					System.out.println(element + " -- " + next);
					if (s.isEmpty()) {
						break;
					}
					element = s.pop();
				}
				/*
				 * '''If element is greater than next, then push the element
				 * back '''
				 */
				if (element > next) {
					s.push(element);
				}
			}

			/*
			 * '''push next to stack so that we can find next greater for it '''
			 */
			s.push(next);
		}
		/*
		 * '''After iterating over the loop, the remaining elements in stack do
		 * not have the next greater element, so print -1 for them '''
		 */

		while (!s.isEmpty()) {
			element = s.pop();
			next = -1;
			System.out.println(element + " -- " + next);
		}
	}
	
public static void printNGE_Formatted(int[] arr) {
	Stack<Integer> s = new Stack<Integer>();
	int element = 0;
	int next = 0;
	int arrInpLen = arr.length;

	s.push(arr[0]);
	
	for (int i = 1; i < arrInpLen; i++) {
		next = arr[i];
		if (!s.isEmpty()) {
			element = s.pop();
			while (element < next) {
				System.out.println(element + " -- " + next);
				if (s.isEmpty()) {
					break;	}
				element = s.pop();
			}
			if (element > next) {
				s.push(element);	}
		}
		s.push(next);
	}
	while (!s.isEmpty()) {
		element = s.pop();
		next = -1;
		System.out.println(element + " -- " + next);}
}
}
