package com.pg.algorithm.sort.quick;

import java.util.Arrays;

/*
 * 
 * Partition. Take end of a number from array. 
 * 
 * 
 */
public class QuickSort {

	public static void main(String[] args) {

		int intArr[] = new int[] { 9, 6, 5, 0, 8, 4, 2, 7 };
		intArr = new int[] { 13, 19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11 };
		QUICK_SORT(intArr, 0, intArr.length - 1);

		System.out.println(" " + Arrays.toString(intArr));

	}

	private static void QUICK_SORT(int[] intArr, int sIndex, int eIndex) {
		if (sIndex < eIndex) {
			int pivotIndex = PARTITION(intArr, sIndex, eIndex);
			QUICK_SORT(intArr, sIndex, pivotIndex - 1);
			QUICK_SORT(intArr, pivotIndex + 1, eIndex);
		}
	}

	private static int PARTITION(int[] intArr, int l, int end) {
		int pivot = intArr[end];

		/*
			int randI = Math.random();   // a random number between 0 and 1
		    pivot = low + Math.floor( (high - low + 1) * randI);  
		    swap(intArr[low], intArr[pivot]);
		 */
		
		System.out.format("st: %d, ed: %d, pv: %d IN-ARR: %s \n", l, end, pivot, Arrays.toString(intArr));
		
		for (int r = l; r <= end - 1; r++) {
			if (intArr[r] <= pivot) {
				swap(intArr, l, r);
				l++; } }
		swap(intArr, l, end);
		System.out.format("st: %d, ed: %d, pv: %d OUT-ARR: %s \n", l, end, l, Arrays.toString(intArr));
		return l;
	}

	private static void swap(int[] intArr, int left, int right) {
		int tmp = intArr[left];
		intArr[left] = intArr[right];
		intArr[right] = tmp;
	}
}
