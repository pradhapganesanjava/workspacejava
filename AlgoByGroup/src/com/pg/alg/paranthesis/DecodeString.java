package com.pg.alg.paranthesis;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {

		List<Integer> lst = getLLtoL(10);
		lst.forEach(ech -> System.out.println(ech));

	}

	private static List<Integer> getLLtoL(int addf) {
		LinkedList<Integer> ill = new LinkedList<>();
		for (int i = addf; i > 0; i--) {
			ill.addFirst(i);
		}
		return ill;
	}

	class Solution {
		public String decodeString(String s) {

			if (s == null)
				return s;
			Stack<String> sstk = new Stack<String>();
			Stack<Integer> istk = new Stack<Integer>();
			int i = 0;
			int len = s.length();
			while (i < len) {
				// for(int i=0; i<len; i++) {

				switch (s.charAt(i)) {
				case '[':
					i++;
					break;
				case ']': {
					while (!sstk.isEmpty() && !istk.isEmpty()) {
						String topStr = sstk.pop();
						Integer topIn = istk.pop();
						StringBuilder strb = new StringBuilder();
						for (int mi = 0; mi < topIn; mi++) {
							strb.append(topStr);
						}
						sstk.push(strb.toString());
					}
					i++;
				}
					break;
				default: {
					if (Character.isDigit(s.charAt(i))) {
						int num = 0;
						while (Character.isDigit(s.charAt(i))) {
							num = 10 * num + (s.charAt(i) - '0');
							i++;
						}
						istk.push(num);
					} else if (Character.isAlphabetic(s.charAt(i))) {
						StringBuilder strb = new StringBuilder();
						while (Character.isAlphabetic(s.charAt(i))) {
							strb.append(s.charAt(i));
							i++;
						}
						sstk.push(strb.toString());
					}
				}

				}

			}
			return "";
		}
	}
}
