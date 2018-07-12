package com.pg.algorithm.sort.comb;

import java.util.Arrays;

public class CombSort {

	public static void main(String[] args) {

		int[] ar1 = { 1, 2, 3, 4, 5 };
		int[] ar2 = { 4, 2, 2, 2, 1 };
		int[] ar3 = { 10, 1, 5, 6 };
		int[] ar4 = { 9, 6, 5, 0, 8, 4, 2, 7 };
		int[] ar5 = { 13, 19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11 };

		combSort(ar1);
		System.out.println(Arrays.toString(ar1));
	}

	private static final float SHRINK_FACTOR = 1.3f;

	public static void combSort(int[] array) {

		if (array == null || array.length < 2) {
			return;
		}

		int n = array.length;
		int gap = n;
		boolean swapped = false;

		do {
			gap = (int) (gap / SHRINK_FACTOR);
			for (int i = 0; i < n - gap; i++) {
				if (array[i] > array[i + gap]) {
					swap(array, i, i + gap);
					swapped = true;
				} }
		} while (gap > 1 && swapped);
	}

	private static void swap(int[] intArr, int left, int right) {
		int tmp = intArr[left];
		intArr[left] = intArr[right];
		intArr[right] = tmp;
	}
}
