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
			int g = PARTITION(intArr, sIndex, eIndex);
			QUICK_SORT(intArr, sIndex, g - 1);
			QUICK_SORT(intArr, g + 1, eIndex);
		}
	}

	private static int PARTITION(int[] intArr, int sIndex, int eIndex) {
		// int eIndex = intArr.length-1;
		// int sIndex = 0;
		int lastItem = intArr[eIndex];

		for (int j = sIndex; j <= eIndex - 1; j++) {
			if (intArr[j] <= lastItem) {
				swap(intArr, sIndex, j);
				sIndex++;
			}
		}
		swap(intArr, sIndex, eIndex);

		System.out.println(" " + Arrays.toString(intArr));
		return sIndex;
	}

	private static void swap(int[] intArr, int left, int right) {
		int tmp = intArr[left];
		intArr[left] = intArr[right];
		intArr[right] = tmp;
	}
}
