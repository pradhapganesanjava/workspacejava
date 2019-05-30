package com.pg.alg.allpossible;

/**
 * 
 * <B>Diving Board</B>: You are building a diving board by placing a bunch of planks of
 * wood end-to-end. There are two types of planks, one of length shorter and one
 * of length longer. You must use exactly K planks of wood.
 * Write a method to generate all possible lengths for the diving board.
 * 
 */

public class DivingBoard {

	public static void main(String[] args) {

//		printAllPossibleSmallLongCombination(15, 5, 10);
		printAllPossibleSmallLongCombination(12, 1, 3);
		
	}

	private static void printAllPossibleSmallLongCombination(int k, int s, int l) {
		int is = k;
		int ls = 0;
		int counter = 0;
		
		while(is >=0) {
			counter ++;
			int len = 0;
			len = is * s;
			len += ls * l;

			System.out.format("s: %d , l: %d len: %d ", is, ls, len);
			System.out.println();
			
			ls ++;
			is --;
		}
		
		System.out.println("counter "+ counter);
	}

}
