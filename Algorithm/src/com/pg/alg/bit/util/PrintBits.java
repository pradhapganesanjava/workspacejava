package com.pg.alg.bit.util;

public class PrintBits {

	public static void main(String[] args) {
		for (int i = 1; i < 8; i++) {
			int n = i;
			System.out.format("(+ve): %d  , bits: %s \n(-ve): %d , bits: %s \n(n &=-n) => %s \n", n, toBits(n), -n,
					toBits(-n), toBits((n &= -n)));
		}
	}

	public static String toBits(Integer in) {
		return Integer.toBinaryString(in);
	}

}
