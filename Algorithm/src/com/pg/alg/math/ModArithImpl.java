package com.pg.alg.math;

public class ModArithImpl {

	public static void main(String[] args) {

		System.out.println(mod(21,8));
		
	}

	private static int mod(int num, int mod) {
		int div = num / mod;
		int resMod = num - (div * mod);
		return resMod;
	}

}
