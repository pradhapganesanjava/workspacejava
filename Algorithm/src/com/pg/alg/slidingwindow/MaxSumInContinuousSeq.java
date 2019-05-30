package com.pg.alg.slidingwindow;

import java.util.Arrays;

public class MaxSumInContinuousSeq {

	public static void main(String[] args) {

		int[] iarr = null;
		iarr = new int[] { -1,-10, -3, -11, -3, -1};
		System.out.format("ArrIn: %s , max: %d \n", Arrays.toString(iarr), maxContinuousSeq(iarr));
		
		iarr = new int[] { -1,-10, -3, -11, -3, -1, 0};
		System.out.format("ArrIn: %s , max: %d \n", Arrays.toString(iarr), maxContinuousSeq(iarr));
		
		iarr = new int[] {8, -3, 4, -5, 5, 6, -4, 3};
		System.out.format("ArrIn: %s , max: %d \n", Arrays.toString(iarr), maxContinuousSeq(iarr));
		
		iarr = new int[] { -4, 5, 1, 0, -2, 5};
		System.out.format("ArrIn: %s , max: %d \n", Arrays.toString(iarr), maxContinuousSeq(iarr));
		
	}

	private static int maxContinuousSeq(int[] iarr) {
		int max = Integer.MIN_VALUE;
		boolean isAllNeg = true;
		for(int i=0; i<iarr.length; i++ ) {
			if(iarr[i] >=0 ) {
				max = Integer.MIN_VALUE;
				isAllNeg = false;
				break;
			}
			max = Math.max(iarr[i], max);
		}
		if(isAllNeg) return max;
		
		int sum = 0;
		for(int i=0; i<iarr.length; i++) {
			sum += iarr[i];
			if(sum < 0) sum = 0;
			max = Math.max(max, sum);
		}
		
		return max;
	}

}
