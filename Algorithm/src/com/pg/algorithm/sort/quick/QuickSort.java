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

	private static int PARTITION(int[] intArr, int low, int high) {
		int pivot = intArr[high];

		/*
			int randI = Math.random();   // a random number between 0 and 1
		    pivot = low + Math.floor( (high - low + 1) * randI);  
		    swap(intArr[low], intArr[pivot]);
		 */
		
		for (int count = low; count <= high - 1; count++) {
			if (intArr[count] <= pivot) {
				swap(intArr, low, count);
				low++;
			}
		}
		swap(intArr, low, high);
		System.out.println(" " + Arrays.toString(intArr));
		return low;
	}

	private static void swap(int[] intArr, int left, int right) {
		int tmp = intArr[left];
		intArr[left] = intArr[right];
		intArr[right] = tmp;
	}
}
