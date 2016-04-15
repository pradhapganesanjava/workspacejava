package com.pgexample.algorithm;

public class FibonacciSeq_Recur {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int size = 10;
		System.out.println("fib " + fibonacciRecur(size));
	}

	private static int fibonacciRecur(int size) {
		if (size == 1) {
			return 0;
		} else if (size == 2) {
			return 1;
		} else {
			return fibonacciRecur(size - 1) + fibonacciRecur(size - 2);
		}
	}
}
