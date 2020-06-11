package com.pg.alg.string.permcomb;

import com.pg.algorithm.array.string.RemoveSpecialToSmallcase;

public class IsPermutationofPalindrom {

	public static void main(String[] args) {
		
		System.out.println(isPermutOfPalin("Tact Coa"));
		
		System.out.println(isPermutOfPalin("TactzCoa"));
		
	}

	private static boolean isPermutOfPalin(String s) {
		String str = RemoveSpecialToSmallcase.toOnlySmallcase(s);
		
		int[] intArr = new int[26];
		int len = str.length();
		
		for(int i=0; i<len; i++) {
			
			int dx = str.charAt(i)-'a';
			
			intArr[dx] = intArr[dx]+1;
			
		}
		
		if(len%2==0) {
			return evenCheck(intArr);
		}else {
			return oddCheck(intArr);
		}
		
	}

	private static boolean oddCheck(int[] intArr) {
		int oddCnt = 0;
		for(int i=0; i < 26; i++) {
			if(intArr[i] % 2 !=0) {
				oddCnt++;
				if(oddCnt>1) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean evenCheck(int[] intArr) {
		for(int i=0; i < 26; i++) {
			if(intArr[i] % 2 !=0) {
				return false;
			}
		}
		return true;
	}

}
