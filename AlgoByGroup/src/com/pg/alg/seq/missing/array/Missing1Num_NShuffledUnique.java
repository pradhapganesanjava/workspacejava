package com.pg.alg.seq.missing.array;

import java.util.Arrays;

/**
 * 
 * You are given a list of n-1 integers 1 to n. 
 * There are no duplicates in the list. One of the integers is missing in
 * the list. Write an efficient code to find the missing integer.
 * 
 * Example :
 * 
 * Input: arr[] = {7, 2, 4, 8, 3, 1, 6} N= 8; Output: 5
 * 
 * Input: arr[] = {2, 5, 3, 1} N = 5; Output: 4
 *
 */
public class Missing1Num_NShuffledUnique {

	public static void main(String[] args) {
		
		int iarr[] = {7, 2, 4, 8, 3, 1, 6};
		
		System.out.format("InArr : %s, Missing #: %d \n", Arrays.toString(iarr), missing1Num(iarr));
		

	}

	/**
	 * O ( N ) solution
	 * @param iarr
	 * @return
	 */
	private static int missing1Num(int[] iarr) {
		int ntot = 0;
		for(int ival : iarr) {
			ntot += ival;
		}
		int N = iarr.length+1;
		
		int actTot = (N*(N+1))/2;
		
		return actTot - ntot;
	}

}
