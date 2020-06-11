package com.pg.alg.bitwise;

import java.util.Arrays;

public class TwoNumberIn2Times {

	public static void main(String[] args) {
		TwoNumberIn2Times.Solution sol = new TwoNumberIn2Times().new Solution();
		int[] iarr = new int[] {1,2,1,3,2,5};
		int[] resArr = sol.twoSingleNumsInDups(iarr);
		System.out.format("InArr: %s , TwoSingles: %s \n",Arrays.toString(iarr), Arrays.toString(resArr));
	}

	class Solution{
		
		public int[] twoSingleNumsInDups(int[] iarr) {
			
			if(iarr == null || iarr.length == 0) return new int[] {};
			
			int xor = iarr[0];
			int len = iarr.length;
			
			for(int i=1; i<len; i++) {
				xor ^= iarr[i];
			}
			
			int diff = (xor & -xor); // & gives first 1 bit when +ve and -ve of same num
			int n1 = 0;
			int n2 = 0;
			for(int i=0; i<len; i++) {
				if( (iarr[i] & diff) == 0) {
					n1 ^= iarr[i]; // Group#1 : dups nums are removed and keep one of singles 
				}else {
					n2 ^= iarr[i];
				}
			}
			return new int[] {n1,n2};
			
		}
		
	}

}

