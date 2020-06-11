package com.pg.algorithm.sort.quick;

import java.util.Arrays;
import java.util.Random;

/*
 * 
 * Partition. Take end of a number from array. 
 * 
 * 
 */
public class QuickSort_Prof {
	private int[] numbers;
	private int number;

	public static void main(String[] args) {

		int intArr[] = new int[] { 9, 6, 5, 0, 8, 4, 2, 7 };
		intArr = new int[] { 13, 19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11 };
		intArr = new int[] {1,2,1,0,4,3,4,-1};
		intArr = new int[] {0,1,2,3,6,4,3};
		new QuickSort_Prof().sort(intArr);

		System.out.println(" " + Arrays.toString(intArr));

	}
	
	public void sort(int[] values) {
		// check for empty or null array
		if (values == null || values.length == 0) {
			return;
		}
		this.numbers = values;
		number = values.length;
		quicksort(0, number - 1);
	}

	private void quicksort(int low, int high) {
		int i = low, j = high;
		// Get the pivot element from the middle of the list
		int pivot = numbers[low + (high - low) / 2];
		//int pivot = numbers[randomRange(low, high) ];

		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (numbers[i] < pivot) {
				i++;
			}
			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (numbers[j] > pivot) {
				j--;
			}

			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i <= j) {
				swap(i, j);
				i++;
				j--;
			}
		}
		System.out.println(""+Arrays.toString(numbers));
		// Recursion
		if (low < j)
			quicksort(low, j);
		if (i < high)
			quicksort(i, high);
	}
	
	private static int randomRange(int st, int ed) {
		//System.out.println("st: "+st+" ed: "+ ed);
		if(st>=ed) return st;
		int rand = new Random().nextInt(ed - st);
		return st+rand;
	}

	private void swap(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
