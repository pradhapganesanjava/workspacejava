package com.pg.java.bitman.util;

import java.util.Arrays;

public class ConvertInt2Bits {

	public static void main(String[] args) {
		int2Bit(1);
		
	}
	
	private static int[] int2Bit(int in){
		int[] bitArr = new int[32];
		for(int i = 31; i > -1; i--){
			int it = 1 << i;
			int tin = in & it;
			System.out.println(it + " " + Integer.toBinaryString(it) + " len: "+Integer.toBinaryString(it).length());
			bitArr[31-i] = tin;
		}
		System.out.println("in Bitw " + Integer.toBinaryString(in));
		System.out.println("in Bitw Arr " + Arrays.toString(bitArr));
		return bitArr;
	}

}
