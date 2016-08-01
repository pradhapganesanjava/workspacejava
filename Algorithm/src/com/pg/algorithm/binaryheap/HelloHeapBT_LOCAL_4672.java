package com.pg.algorithm.binaryheap;

import java.util.Arrays;

public class HelloHeapBT {

	public static void main(String[] args) {

		int[] intArr = { 25, 12, 16, 13, 10, 8, 14 };

		System.out.println(Arrays.toString(intArr) + " IS HEAP? :" + isHeapBT(intArr) + " ArraySIZE: " + intArr.length
				+ " HeapSize? " + getHeapSize(intArr));

		
		intArr = new int[] { 25, 14, 16, 13, 10, 8, 12 };

		System.out.println(Arrays.toString(intArr) + " IS HEAP? :" + isHeapBT(intArr) + " ArraySIZE: " + intArr.length
				+ " HeapSize? " + getHeapSize(intArr));
		
		
		intArr = new int[] { 25, 14, 13, 16, 10, 8, 12 };

		System.out.println(Arrays.toString(intArr) + " IS HEAP? :" + isHeapBT(intArr) + " ArraySIZE: " + intArr.length
				+ " HeapSize? " + getHeapSize(intArr));
		
		
		
		intArr = new int[] { 25, 14, 12, 13, 10, 8, 16 };

		System.out.println(Arrays.toString(intArr) + " IS HEAP? :" + isHeapBT(intArr) + " ArraySIZE: " + intArr.length
				+ " HeapSize? " + getHeapSize(intArr));
		
		
		intArr = new int[] { 14, 13, 12, 10, 8};

		System.out.println(Arrays.toString(intArr) + " IS HEAP? :" + isHeapBT(intArr) + " ArraySIZE: " + intArr.length
				+ " HeapSize? " + getHeapSize(intArr));
		
		intArr = new int[] { 14, 12, 13, 8, 10};

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
