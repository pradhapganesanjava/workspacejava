package com.pg.algorithm.sort.insertion;

import java.util.Comparator;

public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] partSort = new int[] { 1, 2, 3, 4, 0 };
		
		String str1 = new String("a b c d");
		char ch = str1.charAt(1);
		System.out.println(" "+ch);
		//str1.replace(str1.charAt(1), '%20');
		
	}

	private static void insertionSort(Object[] arr, Comparator comp) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j > 0 && isLesser(comp, arr[j], arr[j - 1]); j--) {
				swap(arr,j,j-1);
			}
		}
	}

	private static boolean isLesser(Comparator compare, Object curr, Object prev) {
		return compare.compare(curr, prev) < 0;
	}
	
	private static void swap(Object[] arr,int from, int to){
		Object tmp = arr[from];
		arr[from] = arr[to];
		arr[to]=tmp;
	}
}
