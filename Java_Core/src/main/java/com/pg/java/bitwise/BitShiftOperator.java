package com.pg.java.bitwise;

public class BitShiftOperator {

	public static void main(String... str) {

		byte x = 0x2b;
		System.out.println(x >> 2);

		int bitmask = 0x000F;
		int val = 0x2222;
		// prints "2"
		System.out.println(val & bitmask);

		int number = 8; // 0000 1000
		int result = 0;
		System.out.println("Original number : " + number);

		// left shifting bytes with 1 position
		result = number << 1; // should be 16 i.e. 0001 0000

		// equivalent of multiplication of 2
		System.out.println("LEFT SHIFT: "+number+" << 1  = " + result);

		number = -8;
		// right shifting bytes with sign 1 position
		result = number >> 1; // should be 16 i.e. 0001 0000

		// equivalent of division of 2
		System.out.println("RIGHT-SIGNED SHIFT: "+number+" >> 1 = "+ result);

		number = -8;
		// right shifting bytes with sign 1 position
		result = number >>> 1;

		// equivalent of division of 2
		System.out.println("RIGHT-UN-SIGNED SHIFT  (-Ve): "+number+" >>> 1 = "+ result);

		number = 8;
		// right shifting bytes with sign 1 position
		result = number >>> 1;

		// equivalent of division of 2
		System.out.println("RIGHT-UN-SIGNED SHIFT (+Ve): "+number+" >>> 1 = "+ result);
		
	}

}
