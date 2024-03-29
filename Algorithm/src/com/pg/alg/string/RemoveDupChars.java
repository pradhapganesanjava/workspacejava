package com.pg.alg.string;

import java.util.Arrays;

public class RemoveDupChars {

	/**
	 * remove the duplicate characters in a string without using any additional
	 * buffer. NOTE: One or two additional variables are fine. An extra copy of
	 * the array is not.
	 */
	public static void main(String[] args) {

		// String str = "BAABCDEFAB";
		String str = "aaaa";
		linearONpower2(str);

		char[] charArr2 = str.toCharArray();
		removeDuplicates(charArr2);

		System.out.println("removeDuplicates: " + new String(charArr2));

	}

	private static void linearONpower2(String str) {
		char[] charArr = str.toCharArray();

		int count = 0;
		for (int i = 0; i < charArr.length; i++) {
			count++;
			for (int j = i; j < charArr.length - 1; j++) {
				count++;
				if (charArr[i] == charArr[j + 1]) {
					charArr[j + 1] = 0;
				}
			}
		}
		System.out.println("N : " + str.length() + " O(N) " + count);

		System.out.println("duplicate chars are removed: " + new String(charArr));
	}

	public static void removeDuplicates(char[] str) {
		if (str == null)
			return;
		int len = str.length;
		if (len < 2)
			return;

		int tail = 1;

		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j])
					break;
			}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
	}
}
