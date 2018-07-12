package com.pg.java.bitman.xor;

public class XorDuplicateSeqOnInts {

	public static void main(String[] args) {

		//int[] input = { -1,0,-2,4,3,0,0,-1,-2,3,0 };
		
		//int[] input = { 3,3,3,4,1,1,1};
		int[] input = { 3,27,4,64};
		
		int result = input[0];
		for (int i = 1; i < input.length; i++) {
			System.out.println(result +" ^ " + input[i] +" = "+ (result ^ input[i]));
			result = result ^ input[i];
		}
		System.out.println(" result " + result);
	}

}
