package com.pgexample.algorithm;

public class FibonacciSeq_Recur {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int size = 10;
		System.out.println("fib " + fibonacciRecur(size));
		int[] fibIntArr = new int[100];
	}

	private static int fibonacciWithStorage(int[] fibIntArr, int fibInt) {
		if (fibInt < 2) {
			fibIntArr[0]=fibIntArr[1]=1;
			return 1;
		}
		if (fibIntArr[fibInt] > 0) {
			return fibIntArr[fibInt];
		} else {
			int newVal = fibonacciWithStorage(fibIntArr, fibInt - 1) + fibonacciWithStorage(fibIntArr, fibInt - 2);
			fibIntArr[fibInt] = newVal;
			return newVal;
		}
	}

	// fib(i) repetitive many times... this is NOT recommended solution
	// nth takes O (2^n)
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
