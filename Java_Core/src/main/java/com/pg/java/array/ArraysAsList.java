package com.pg.java.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysAsList {

	public static void main(String[] args) {

		//#1 Compilation Fails - can not cast int[] to List<Integer>
		// inList = Arrays.asList(new int[]{1,2,3,4});

		//#2 Arrays.asList(new Integer[] { 1, 2, 3, 4 });
		arraysAsList_WrapArr();

		//#3 - below wrapper array obj, works and modifiable.
		//new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2, 3, 4 }));
		arraysAsList_wrapArr_newList();

	}

	private static void arraysAsList_wrapArr_newList() {
		List<Integer> inList;
		inList = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2, 3, 4 }));

		/*
		 * inList = Arrays.asList(1,2,3,4); for(int i : inList){
		 * System.out.println(i); }
		 */
		for (int i : inList) {
			System.out.println(i);
		}

		inList.add(5);
		inList.add(6);
		inList.add(7);

		System.out.println("Modified List--->");
		for (int i : inList) {
			System.out.println(i);
		}
	}

	/*
	 * works for object array; But can NOT modify (add or remove) on returned
	 * list, throws java.lang.UnsupportedOperationException
	 */
	private static void arraysAsList_WrapArr() {
		List<Integer> inList = null;

		inList = Arrays.asList(new Integer[] { 1, 2, 3, 4 });
		for (int i : inList) {
			System.out.println(i);
		}

		inList.add(5);
		inList.add(6);
		inList.add(7);

		System.out.println("Modified List--->");
		for (int i : inList) {
			System.out.println(i);
		}
	}

}
