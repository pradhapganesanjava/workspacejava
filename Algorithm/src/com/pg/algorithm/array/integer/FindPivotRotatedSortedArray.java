package com.pg.algorithm.array.integer;

public class FindPivotRotatedSortedArray {

	public static int findPivotLinear(int[] array) {
		int pivot = -1;

		if (array != null && array.length > 0) {

			pivot = 0;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					pivot = i + 1;
					break;
				}
			}
		}
		return pivot;
	}

	public static int findPivotBinarySearch(int[] array) {

		if (array == null || array.length == 0) {	return -1;	}

		if (array.length == 1 || array[0] < array[array.length - 1]) {
			return 0;	}

		int start = 0, end = array.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (mid < array.length - 1 && array[mid] > array[mid + 1]) {
				return (mid + 1);
			} else if (array[start] <= array[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {

		int array[] = { 5, 4 };
		findPivotBinarySearchTest(array);
	}

	public static void findPivotLinearTest(int array[]) {
		int index = findPivotLinear(array);
		System.out.println("Pivot " + (index >= 0 ? (" found at index " + index) : " not found!"));
	}

	public static void findPivotBinarySearchTest(int array[]) {
		int index = findPivotBinarySearch(array);
		System.out.println("Pivot " + (index >= 0 ? (" found at index " + index) : " not found!"));
	}
}