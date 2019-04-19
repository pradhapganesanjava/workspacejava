package com.pg.alg.string;

import java.util.Arrays;

public class ReverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String str = "ABCDE";
		//O(n/2 - 1) 
		inlineReverset(str);

	}

	private static void inlineReverset(String str) {
		char[] chars = str.toCharArray();
		
		int n = chars.length;
		 
		 for (int j = 0; j < (n>>1); j++) {
			 char tmp = chars[n-1-j];
			 chars[n-1-j]=chars[j];
			 chars[j]=tmp; 
		 }
		
		 System.out.println("inline str: " +new String(chars));
	}

}
