package com.pg.algorithm.array.integer;

import java.util.HashSet;
import java.util.Set;

public class PairOfSumAll {

	public static void main(String[] args) {

		int[] iarr = new int[] {10,5,15,3,2};
		
		printPairsOfSum(iarr, 20);
	}

	private static void printPairsOfSum(int[] iarr, int sum) {
		Set<Integer> iset = new HashSet<>();
		for(int i=0; i<iarr.length; i++) {
			iset.add(iarr[i]);
		}
		
		for(int i=0; i<iarr.length; i++) {
			int rem = sum - iarr[i];
			
			if(iset.contains(rem)) {
				System.out.format("%d, %d  \n", iarr[i], rem);
			}
		}
	}

}
