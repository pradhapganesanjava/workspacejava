package com.pg.alg.bit.util;

import java.util.Arrays;

public class Num2Bit {

	public static void main(String[] args) {
		int n = -6;
		System.out.format("%d =BITS=> %s \n", n, Integer.toBinaryString(n));
		
		int[] iarr = new int[32];
		
		int cnt = 0;
		while(n != 0 && cnt < 32) {
			System.out.format("cnt: %d, n: %d (%s) , rem (n&1): %d \n",cnt, n, Integer.toBinaryString(n), (n&1));
			if( (n&1) != 0) {
				iarr[cnt] = 1;
			}
			cnt++;
			n = n>>1;
		}
		
		System.out.format("MY VERS %d =BITS=> %s \n", n, Arrays.toString(iarr));
	}

}
