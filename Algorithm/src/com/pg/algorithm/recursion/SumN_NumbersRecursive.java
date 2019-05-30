package com.pg.algorithm.recursion;

public class SumN_NumbersRecursive {

	public static void main(String[] args) {
		System.out.println(sumRecur(10));
	}
	private static int sumRecur(int n) {
		if(n == 0) return 0;
		return n + sumRecur(n-1);
	}
}
