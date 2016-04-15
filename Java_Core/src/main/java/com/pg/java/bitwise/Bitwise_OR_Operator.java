package com.pg.java.bitwise;

public class Bitwise_OR_Operator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ceilANumberTo2powerN();
		
	System.out.println("1|2 "+(1|2));
	System.out.println("2|2 "+(2|2));
	System.out.println("3|2 "+(3|2));
	System.out.println("4|2 "+(4|2));
	System.out.println("5|2 "+(5|2));
	System.out.println("6|2 "+(6|2));
	System.out.println("7|2 "+(7|2));
	System.out.println("8|2 "+(8|2));
	System.out.println("9|2 "+(9|2));
	System.out.println("10|2 "+(10|2));
	System.out.println("11|2 "+(11|2));
	System.out.println("13|2 "+(13|2));
	System.out.println("15|2 "+(15|2));
	System.out.println("16|2 "+(16|2));
	System.out.println("20|2 "+(20|2));
	System.out.println("10 & 5 "+(10 & 7));

	}

	private static void ceilANumberTo2powerN() {
		int initialCapacity = 200;
		initialCapacity = initialCapacity | (initialCapacity >>> 1);
		initialCapacity = initialCapacity | (initialCapacity >>> 2);
		initialCapacity = initialCapacity | (initialCapacity >>> 3);
		initialCapacity = initialCapacity | (initialCapacity >>> 4);
		initialCapacity = initialCapacity | (initialCapacity >>> 5);
		initialCapacity = initialCapacity | (initialCapacity >>> 6);
		initialCapacity = initialCapacity | (initialCapacity >>> 7);
		initialCapacity = initialCapacity | (initialCapacity >>> 8);
		initialCapacity = initialCapacity | (initialCapacity >>> 16);
		initialCapacity++;
	}
}
