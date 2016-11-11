package com.pg.java.basics.arithm;

public class ArithmeticPriority {

	public static void main(String...str){
		
		subtractModular();
		
		incrementModular();
		
		int x = 10;
		double y = 20;
		double z = x + y / 100;
		
		System.out.println(z);
		
		square(10,3);
		
	}
	
	private static int square(int num, int toSqr){
		int square = 0;
		
		if(num == 0){
			return square;
		}
		
		square = (int)Math.pow(num,toSqr);
		
		System.out.println(num + " to the power of "+toSqr+ " = "+square);
		
		return square;
	}

	private static void incrementModular() {
		int i = 10;
		int n = i++%5;
		
		System.out.println(" i "+i);
		System.out.println(" n "+n);
	}

	private static void subtractModular() {
		int a = 12;
		int b = 30;
		int c = 20;
		int x = 0;
		
		c -= b%a;
	
		System.out.println(" c "+c);
	}
	
}
