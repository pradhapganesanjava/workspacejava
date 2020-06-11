package com.pg.alg.slidingwindow;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KSmallNumbers {

	public static void main(String[] args) {

		int[] iarr = new int[] { 3, 1, 0, -1, 2, 4, 5, -5, 10 };
		int k = 5;

		int[] karr = bruteForce(iarr, k);
		System.out.format("%s => %s \n", Arrays.toString(iarr), Arrays.toString(karr));
		
		
		//karr = maxHeap(iarr, k);
		Integer[] iarrW = new Integer[] { 3, 1, 0, -1, 2, 4, 5, -5, 10 };
		Arrays.sort(iarrW, KSmallNumbers::maxHeapCompare);
		System.out.format("MaxHeap: %s => %s \n", Arrays.toString(iarrW), Arrays.toString(iarrW));
	}

	private static int[] maxHeap(int[] iarr, int k) {

        if(null == iarr || iarr.length ==0 )return iarr;
        if(iarr.length < k) return null;

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, KSmallNumbers::maxHeapCompare);

        for(int i = 0; i<iarr.length; i++){

            if(maxHeap.size()>k){
            	 	maxHeap.poll();
                 maxHeap.offer(iarr[i]);
            }else{
                maxHeap.offer(iarr[i]);
            }

        }
		
        int[] karr = new int[k];

        for(int i=0; i<k; i++){
            karr[i] = maxHeap.poll();
        }

		return karr;
	}
	
	static int maxHeapCompare(int i1, int i2) {
		return i1 > i2 ? -1 : 1;
		//return i2-i1;
	}

	/**
	 * Brute Force 
	 * > sort the array O (n log n) 
	 * > then return new array copy first k numbers 
	 * > In this arrays gets modified during sorting
	 */
	private static int[] bruteForce(int[] iarr, int k) {
		if (null == iarr || iarr.length == 0)
			return iarr;
		if (iarr.length < k)
			return null;

		Arrays.sort(iarr);
		int[] retArr = new int[k];
		for (int i = 0; i < k; i++) {
			retArr[i] = iarr[i];
		}
		return retArr;
	}

}
