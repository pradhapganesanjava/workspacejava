package com.pg.algorithm.binaryheap;

import java.util.Arrays;

public class HelloHeapBT {

	public static void main(String[] args) {

		// testIsHeap();

		int[] intArr = { 25, 12, 16, 13, 10, 8, 14 };
		intArr = new int[] { 1, 5, 6, 8, 12, 14, 16 };
		//heapifyTop2Bottom(intArr);
		
		heapifyBottom2Top(intArr);

	}
	
	private static void heapifyBottom2Top(int[] intArr){
		//leap nodes n/2 + 1 ... n
		//non-leap nodes 1... n/2
		
		for(int i=intArr.length/2-1;i>-1;i--){
			heapify(intArr, i);
		}
		
		System.out.println("Bottom to Top Heapify "+ Arrays.toString(intArr));
	}

	private static void heapify(int[] intArr, int index) {
		int alen = intArr.length;
		int i = index;
		int l = 2 * (i + 1) - 1;
		int r = 2 * (i + 1);
		int largeIndex = i;
		int aI = -1;
		int lI = -1;
		int rI = -1;
		if (i < alen) {
			aI = intArr[i];
			if (l < alen && intArr[i] < intArr[l]) {
				lI = intArr[l];
				if ((r < alen && intArr[l] < intArr[r])) {
					rI = intArr[r];
					largeIndex = r;
				} else {
					largeIndex = l;
				}
			}
			if (largeIndex == i && r < alen && intArr[i] < intArr[r]) {
				rI = intArr[r];
				largeIndex = r;
			}
			if (largeIndex != i) {
				int tmp = intArr[i];
				intArr[i] = intArr[largeIndex];
				intArr[largeIndex] = tmp;
				
				heapify(intArr, largeIndex);
			} 

			//heapify(intArr, largeIndex);
		}
	}


	private static void heapifyTop2Bottom(int[] intArr) {
		heapifyT2B(intArr, 0);
		System.out.println("Heapified " + Arrays.toString(intArr));
	}
	
	

	private static void heapifyT2B(int[] intArr, int index) {
		int alen = intArr.length;
		int i = index;
		int l = 2 * (i + 1) - 1;
		int r = 2 * (i + 1);
		int largeIndex = i;
		int aI = -1;
		int lI = -1;
		int rI = -1;
		if (i < alen) {
			aI = intArr[i];
			if (l < alen && intArr[i] < intArr[l]) {
				lI = intArr[l];
				if ((r < alen && intArr[l] < intArr[r])) {
					rI = intArr[r];
					largeIndex = r;
				} else {
					largeIndex = l;
				}
			}
			if (largeIndex == i && r < alen && intArr[i] < intArr[r]) {
				rI = intArr[r];
				largeIndex = r;
			}
			if (largeIndex != i) {
				int tmp = intArr[i];
				intArr[i] = intArr[largeIndex];
				intArr[largeIndex] = tmp;

				int parentIndex = (int) Math.ceil(i / 2);
				largeIndex = parentIndex > 0 ? parentIndex - 1 : 0;

			} else {
				largeIndex = i + 1;
			}

			heapifyT2B(intArr, largeIndex);
		}
	}

	private static void testIsHeap() {
		int[] intArr = { 25, 12, 16, 13, 10, 8, 14 };

		System.out.println(Arrays.toString(intArr) + " IS HEAP? :" + isHeapBT(intArr) + " ArraySIZE: " + intArr.length
				+ " HeapSize? " + getHeapSize(intArr));

		intArr = new int[] { 25, 14, 16, 13, 10, 8, 12 };

		System.out.println(Arrays.toString(intArr) + " IS HEAP? :" + isHeapBT(intArr) + " ArraySIZE: " + intArr.length
				+ " HeapSize? " + getHeapSize(intArr));

		intArr = new int[] { 25, 14, 13, 16, 10, 8, 12 };

		System.out.println(Arrays.toString(intArr) + " IS HEAP? :" + isHeapBT(intArr) + " ArraySIZE: " + intArr.length
				+ " HeapSize? " + getHeapSize(intArr));
<<<<<<< HEAD
		
		
		
=======

>>>>>>> 162459ac67b75c5b78fcab2302031ba86090cc50
		intArr = new int[] { 25, 14, 12, 13, 10, 8, 16 };

		System.out.println(Arrays.toString(intArr) + " IS HEAP? :" + isHeapBT(intArr) + " ArraySIZE: " + intArr.length
				+ " HeapSize? " + getHeapSize(intArr));
<<<<<<< HEAD
		
		
		intArr = new int[] { 14, 13, 12, 10, 8};

		System.out.println(Arrays.toString(intArr) + " IS HEAP? :" + isHeapBT(intArr) + " ArraySIZE: " + intArr.length
				+ " HeapSize? " + getHeapSize(intArr));
		
		intArr = new int[] { 14, 12, 13, 8, 10};
=======

		intArr = new int[] { 89, 19, 40, 17, 12, 10, 2, 5, 7, 11, 6, 9, 70 };
>>>>>>> 162459ac67b75c5b78fcab2302031ba86090cc50

		System.out.println(Arrays.toString(intArr) + " IS HEAP? :" + isHeapBT(intArr) + " ArraySIZE: " + intArr.length
				+ " HeapSize? " + getHeapSize(intArr));
	}

	private static boolean isHeapBT(int[] intArr) {
		if (null == intArr || intArr.length < 1) {
			return false;
		}
		int heapSize = getHeapSize(intArr);
		return intArr.length == heapSize;
	}

	private static int getHeapSize(int[] intArr) {
		Integer arrLen = intArr.length;
		for (int i = 1; i <= intArr.length; i++) {

			Integer pIndex = i - 1 < arrLen ? i - 1 : null;
			Integer lcIndex = i * 2 - 1 < arrLen ? i * 2 - 1 : null;
			Integer rcIndex = i * 2 < arrLen ? i * 2 : null;

			Integer pVal = pIndex != null ? intArr[pIndex] : null;
			Integer lcVal = lcIndex != null ? intArr[lcIndex] : null;
			Integer rcVal = rcIndex != null ? intArr[rcIndex] : null;

			// rule 1.1
			if (pVal != null && lcVal != null && rcVal != null) {
				if (pVal > lcVal && pVal > rcVal) {
					continue;
				}
			}
			// rule 1.2
			if (pVal != null && lcVal != null && rcVal == null && pVal > lcVal) {
				continue;
			}

			if (pVal != null && lcVal == null && rcVal == null) {
				continue;
			}

			if (pVal == null) {
				continue;
			}

			return i;
		}
		return arrLen;
	}

}
