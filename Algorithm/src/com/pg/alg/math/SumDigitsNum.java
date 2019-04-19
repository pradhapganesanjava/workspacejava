package com.pg.alg.math;

public class SumDigitsNum {

	public static void main(String[] args) {

		int num = 99;
		
		int sumDigit = sumRecur(0,num);
		
		System.out.println(sumDigit);
	}

	private static int sumRecur(int sum, int num) {
		if(num < 10) {
			sum = sum + num;
			return sum;
		}
		
		sum = sum + num%10;
		return sumRecur(sum, num/10);
	}

}
