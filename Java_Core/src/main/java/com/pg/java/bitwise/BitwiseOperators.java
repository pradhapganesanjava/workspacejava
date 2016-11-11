package com.pg.java.bitwise;

public class BitwiseOperators {

	public static void main(String str[]){
		 
		int a = 2; //0010
		int b = 4; //0100

		AND_operator(a,b);
		
		OR_operator(a, b);
		
		XOR_operator(a, b);
		
		unary_operator(a);
	}

	private static void unary_operator(int a) {
		System.out.println(" a:"+a+" (~a):"+(~a));
	}

	private static void XOR_operator(int a, int b) {
		System.out.println(" a:"+a+" b:"+b+" (a^b):"+(a^b));
	}

	private static void OR_operator(int a, int b) {
		System.out.println(" a:"+a+" b:"+b+" (a|b):"+(a|b));
	}
	
	static void AND_operator(int a, int b){
		System.out.println(" a:"+a+" b:"+b+" (a&b):"+(a&b));
	}
}
