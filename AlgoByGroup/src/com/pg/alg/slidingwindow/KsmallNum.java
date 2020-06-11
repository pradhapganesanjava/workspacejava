package com.pg.alg.slidingwindow;

import java.util.Arrays;

/**
 * 
 * Smallest K: Design an algorithm to find the smallest K numbers in an array.
 *
 */
public class KsmallNum {

	public static void main(String[] args) {

		int[] iarr = { 3, 1, 5, 7, 3, 9, 2, 7, 8 };

		int[] iarrK = kSmallNumbers(Arrays.copyOf(iarr, iarr.length), 4);
		
	}

	private static int[]  kSmallNumbers(int[] iarr, int k) {
		//quickSrtRecur_Comb(iarr, 0, iarr.length-1, k);
		int[] iarrcopy1= Arrays.copyOf(iarr, iarr.length);
		quickSrtRecur_High(iarrcopy1, 0, iarr.length-1, 3);
		System.out.println("iarrcopy1's k smallest : " + Arrays.toString(Arrays.copyOf(iarrcopy1, 4)));
		System.err.println("--------------------------------");
		
		int[] iarrcopy2= Arrays.copyOf(iarr, iarr.length);
		GFG.kthSmallest(iarrcopy2, 0,  iarr.length-1, 4);
		System.out.println("iarrcopy2's k smallest : " + Arrays.toString(Arrays.copyOf(iarrcopy2, 4)));
		
		return Arrays.copyOf(iarr, k);
	}

	private static void quickSrtRecur_Comb(int[] iarr, int st, int ed, int k) {
		
		int low = st;
		int high = ed;
		int pt = (st + ed) / 2;
		int pval = iarr[pt];
		while(st <= ed) {
			
			while(iarr[st] <= pval) {
				st++;
			}
			
			while(iarr[ed] > pval) {
				ed--;
			}
			
			if(st <= ed) {
				swap(iarr, st, ed);
				st++;
				ed--;
			}
		}
		
		if(st < high) {
			
		}
		
		
	}

	private static void quickSrtRecur_High(int[] iarr, int st, int ed, int k) {
		if(st > ed) return;
		int pv = findPivot(iarr, st, ed);
		if(pv-1 == k) {
			return;
		}
		if(pv-1 > k) {
			//System.out.format("Meantime sort: %s \n", Arrays.toString(iarr));
			//quickSrtRecur_High(iarr, pv+1, ed, k);
			 quickSrtRecur_High(iarr, st, pv-1, k);
			 return;
			
		}
		quickSrtRecur_High(iarr, pv+1, ed, k);
		return;
	}

	private static int findPivot(int[] iarr, int st, int ed) {
		int low = st;
		int high = iarr[ed];
		
		
		System.out.format("st: %d, ed: %d, pVAL: %d IN-ARR: %s \n", st, ed, high, Arrays.toString(iarr));
		
		for(int run = st; run < ed-1; run++) {
			
			if(iarr[run] <= high) {
				swap(iarr, low, run);
				low++;
			}
			
		}
		swap(iarr, low, ed);
		System.out.format("st: %d, ed: %d, pt: %d arr: %s \n", st, ed, low, Arrays.toString(iarr));
		return low;
	}

	private static void swap(int[] iarr, int low, int run) {
		int tmp = iarr[low];
		iarr[low] = iarr[run];
		iarr[run] = tmp;
	}

}

class GFG 
{ 
	// Standard partition process of QuickSort. 
	// It considers the last element as pivot 
	// and moves all smaller element to left of 
	// it and greater elements to right 
	public static int partition(int [] arr, int l, 
											int r) 
	{ 
		int x = arr[r], i = l; 
		
		System.out.format("st: %d, ed: %d, pVAL: %d IN-ARR: %s \n", l, r, x, Arrays.toString(arr));
		for (int j = l; j <= r - 1; j++) 
		{ 
			if (arr[j] <= x) 
			{ 
				//Swapping arr[i] and arr[j] 
				int temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 

				i++; 
			} 
		} 
		
		//Swapping arr[i] and arr[r] 
		int temp = arr[i]; 
		arr[i] = arr[r]; 
		arr[r] = temp; 
		System.out.format("st: %d, ed: %d, pt: %d OUT-ARR: %s \n", l, r, i, Arrays.toString(arr));
		return i; 
	} 
	
	// This function returns k'th smallest element 
	// in arr[l..r] using QuickSort based method. 
	// ASSUMPTION: ALL ELEMENTS IN ARR[] ARE DISTINCT 
	public static int kthSmallest(int[] arr, int l, 
										int r, int k) 
	{ 
		// If k is smaller than number of elements 
		// in array 
		if (k > 0 && k <= r - l + 1) 
		{ 
			// Partition the array around last 
			// element and get position of pivot 
			// element in sorted array 
			int pos = partition(arr, l, r); 

			// If position is same as k 
			if (pos-l == k-1) 
				return arr[pos]; 
			
			// If position is more, recur for 
			// left subarray 
			if (pos-l > k-1) 
				return kthSmallest(arr, l, pos-1, k); 

			// Else recur for right subarray 
			return kthSmallest(arr, pos+1, r, k-pos+l-1); 
		} 

		// If k is more than number of elements 
		// in array 
		return Integer.MAX_VALUE; 
	} 

	// Driver program to test above methods 
	public void main(String[] args) 
	{ 
		int arr[] = new int[]{12, 3, 5, 7, 4, 19, 26}; 
		int k = 3; 
		System.out.print( "K'th smallest element is " + 
					kthSmallest(arr, 0, arr.length - 1, k) ); 
	} 
} 

