package com.pg.alg.math;

public class RandRange {

	public static void main(String[] args) {
		
		int[] range1 = new int[14];
		int test_sz = 10000;
		for(int i=0; i<test_sz;i++) {
			int r1 = randRange(5,10);
			System.out.println();
			range1[r1] +=1;
		}
		
		for(int i=0; i< range1.length; i++) {
			System.out.format("%d percent of appearance %d \n",i, range1[i]*100/test_sz);
		}
	}

	private static int randRange(int lower, int higher) {
		return  lower + (int)(Math.random()* (higher - lower + 1));
	}

}
