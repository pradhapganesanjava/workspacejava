package com.pg.algorithm.array.integer;

import java.util.Arrays;

public class FindMissingOneNumberFrom2ndArr {

	public static void main(String...str){
		findMissing(new int[]{9,7,8,5,4,6,2,3,1}, new int[]{2,4,3,9,1,8,5,6});
		findMissing(new int[]{1}, new int[]{});
		findMissing(new int[]{1,3,2}, new int[]{2,1});
		findMissing(new int[]{1,3,2,1}, new int[]{1,2,1});
	}
	
	private static int findMissing(int[] ar, int[] br){
		System.out.format("Arr1: %s\nArr2: %s\n", Arrays.toString(ar), Arrays.toString(br));
		int aSize = ar.length;
		int bSize = br.length;
		int mxSize = aSize > bSize ? aSize : bSize;
		int r = 0;
		for(int i = 0; i < mxSize ; i++){
			if(i < aSize){
				r = r ^ ar[i]; }
			if(i < bSize){
				r = r ^ br[i];
			}
		}
		Arrays.sort(ar);
		Arrays.sort(br);
		System.out.format("Sorted Arr1: %s\nSorted Arr2: %s\n", Arrays.toString(ar), Arrays.toString(br));
		System.out.println("missing is " + r);
		return r;
	}
}
