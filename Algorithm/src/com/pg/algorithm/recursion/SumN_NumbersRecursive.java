package com.pg.algorithm.recursion;

public class SumN_NumbersRecursive {

	public static void main(String[] args) {
		System.out.println(sumRecur(10));
	}
	private static int sumRecur(int n) {
		if(n == 0) return 0;
		//if(n == 1) return 1;
		//int sum = 1;
		return sumRecur(n-1)+n;
		//return sum;
	}
}
