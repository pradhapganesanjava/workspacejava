package com.pg.alg.math;

public class PrintDigitsOfNum {

	public static void main(String[] args) {

		int n = 4123;
		
		int tn = n;
		int d = 1;
		while(tn > 10) {
			d *=10;
			tn = n/d;
		}
		System.out.format("1st digit %d, last digit %d ", n/d, n%10);
		
	}

}
