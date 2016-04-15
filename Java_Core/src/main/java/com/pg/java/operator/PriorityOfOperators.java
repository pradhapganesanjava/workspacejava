package com.pg.java.operator;

public class PriorityOfOperators {

	public static void main(String... str) {

		//divide take over multiply
		System.out.println(" "+(30/10*10));
		
		//multiply take priority over + or -
		System.out.println(" "+(10+30/10*10-10));
		
		System.out.println(" "+(2-11+11));
		
		int b = 0x08;
		int mask7 = 0x80;
		System.out.println(" b "+(b));
		System.out.println("mask "+(b&mask7));
		
	}
}
