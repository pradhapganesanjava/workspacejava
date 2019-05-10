package com.pg.alg.math;

public class SumDigitsNum {

	public static void main(String[] args) {

		int num = 199;
		
		System.out.format("sumRecur %d\n", sumRecur(0,num));
		
		System.out.format("sumIter %d\n", sumIter(num));
	}

	private static int sumRecur(int sum, int num) {
		if(num < 10) {
			sum = sum + num;
			return sum;
		}
		
		sum = sum + num%10;
		return sumRecur(sum, num/10);
	}
	
	private static int sumIter(int num) {
		
		int sum = 0;
		int rem = num;
		
		while(rem>0) {
			sum += rem % 10;
			rem = rem / 10;
		}
		
		return sum;
	}

}
