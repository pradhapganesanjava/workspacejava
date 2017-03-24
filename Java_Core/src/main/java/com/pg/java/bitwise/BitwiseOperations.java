package com.pg.java.bitwise;

public class BitwiseOperations {

	public static void main(String[] args) {
		swapIntegersWOArithOpr();
		addTwoInts(10,20);

	}

	private static void swapIntegersWOArithOpr(){
		int a = 8;
		int b = 3;
		System.out.format("Before Swap: a:%d, b:%d \n", a, b);
		System.out.format("a =(a ^ b) :%d \n", (a=a^b));
		System.out.format("b =(a ^ b) :%d \n", (b=a^b));
		System.out.format("a =(a ^ b) :%d \n", (a=a^b));
		System.out.format("After Swap: a:%d, b:%d \n", a, b);
	}
	
	private static int addTwoInts(int x, int y) {
		System.out.format("Add two ints : x:%d + y:%d \n",x,y);
		// Iterate till there is no carry
		while (y != 0) {
			// carry now contains common set bits of x and y
			int carry = x & y;

			// Sum of bits of x and y where at least one of the bits is not set
			x = x ^ y;

			// Carry is shifted by one so that adding it to x gives the required
			// sum
			y = carry << 1;
		}
		System.out.format("Add two ints output: x: %d y: %d  \n",x,y);
		return x;
	}

}
