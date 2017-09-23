package com.pg.algorithm.recursion;

public class Factorial {

	public static void main(String[] args) {
		for(int n=-1; n<8;n++){
			System.out.println(" factorial of : "+n+" is "+factorial(n));
		}
	}

	private static int factorial(int n){
		if(n<0) return 0;
		return factorialRecur(n);
	}
	
	private static int factorialRecur(int n){
		if(n==0) return 1;
		return n * factorialRecur(n-1);
	}
}
