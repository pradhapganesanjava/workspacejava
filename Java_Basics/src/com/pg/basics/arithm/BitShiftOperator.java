package com.pg.basics.arithm;

public class BitShiftOperator {

	public static void main(String... str) {

		byte x = 0x2b;
		System.out.println(x >> 2);

		int bitmask = 0x000F;
		int val = 0x2222;
		// prints "2"
		System.out.println(val & bitmask);

		int number = 8; // 0000 1000
		System.out.println("Original number : " + number);

		// left shifting bytes with 1 position
		number = number << 1; // should be 16 i.e. 0001 0000

		// equivalent of multiplication of 2
		System.out.println("value of number after left shift: " + number);

		number = -8;
		// right shifting bytes with sign 1 position
		number = number >> 1; // should be 16 i.e. 0001 0000

		// equivalent of division of 2
		System.out.println("value of number after right shift with sign: " + number);

		number = -8;
		// right shifting bytes without sign 1 position
		number = number >>> 1; // should be 16 i.e. 0001 0000

		// equivalent of division of 2
		System.out.println("value of number after right shift with sign: " + number);

	}

}
