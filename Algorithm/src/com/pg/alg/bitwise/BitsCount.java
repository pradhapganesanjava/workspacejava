package com.pg.alg.bitwise;

import java.util.Arrays;
import java.util.List;

public class BitsCount {

	public static void main(String[] args) {
		
		rightShiftNsBit(11);
		
		leftShift1sBit(12);
		
		unsignedNsBit(Integer.MAX_VALUE+1);
		
		//int[] intArr = new int[]{197,235,162,1,2,10,16};
		//countLSB(intArr);
	}

	private static void unsignedNsBit(int n) {
		
		int tn = n;
		int cnt = 0;
		
		while(tn != 0) {
			if( (tn & 1) == 1) {
				cnt++;
			}
			tn = tn >>> 1;
		}
		System.out.format("(UNSIGNED) N: %d Bits: %s, Cnt: %d \n", n, Integer.toBinaryString(n), cnt);
	}

	private static void leftShift1sBit(int n) {
		int cnt = 0;
		
		for(int i=0; i<32; i++) {
			if( (n & 1 << i ) > 0) {
				cnt++;
			}
		}
		System.out.format("N: %d Bits: %s, Cnt: %d \n", n, Integer.toBinaryString(n), cnt);
	}

	private static void rightShiftNsBit(int tn) {int cnt = 0;
	int itn = tn;
	while(tn > 0) {
		
		if( (tn & 1) > 0) {
			cnt++;
		}
		tn = tn >> 1;
		
	}
	System.out.format("N: %d Bits: %s, Cnt: %d \n", itn, Integer.toBinaryString(itn), cnt);
	}

	private static void countLSB(int[] intArr) {
		for(int i=0; i< intArr.length; i++){
			int intInp = intArr[i];
			int lsbInt = countLSB(intInp);
			System.out.println(intInp+" : "+Integer.toBinaryString(intInp)+" : "+lsbInt);
		}
	}

	private static int countLSB(int intIn) {
		int countLSB = 0;
		System.out.println("1) intIn "+Integer.toBinaryString(intIn));
		System.out.println(" 1<<31 "+Integer.toBinaryString(1<<31));
		System.out.println("intIn & (1<<31) "+Integer.toBinaryString(intIn & (1<<31)));
		
		for(int i=0 ;i < 32;i++){
		if(((intIn<<i) & (1<<31))>0){
			countLSB++;
//			intIn = intIn<<1;
			System.out.println("intIn "+Integer.toBinaryString(intIn));
		}
		}
		return countLSB;
	}

	
	private static void printBinary(Integer[] intArrP) {
		Integer[] intArr = new Integer[]{197,235,162,1,2,10,16};

		List<Integer> intList = Arrays.asList(intArr);
		intList.forEach(intv -> System.out.println(intv+"\t:\t"+Integer.toBinaryString(intv)));
	}

	private static void printBinary(Byte[] byteArrP) {
		Byte[] byteArr = new Byte[]{-128,127,126,1,2,10,16};

		List<Byte> byteList = Arrays.asList(byteArr);
		byteList.forEach(intv -> System.out.println(intv+"\t:\t"+Integer.toBinaryString(intv)));
	}
}
