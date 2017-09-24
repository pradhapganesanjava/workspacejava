package com.pg.algorithm;

public class Palindrome {

	public static void main(String[] args) {
		String givenStr = "pp";
		System.out.println("Given Str: " + givenStr + " isPalindrome? " + isPalindrome(givenStr));

	}

	private static boolean isPalindrome(String givenStr) {
		boolean isPalindrome = true;
		int len = givenStr.length();
		int mid = len % 2 == 0 ? len / 2 : len / 2 + 1;
		for (int i = len - 1, j = 0; i >= mid && j < mid; i--, j++) {
			if (givenStr.charAt(i) != givenStr.charAt(j)) {
				isPalindrome = false;
				break;
			}
		}
		return isPalindrome;
	}

}
