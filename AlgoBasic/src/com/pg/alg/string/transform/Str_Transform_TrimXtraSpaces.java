package com.pg.alg.string.transform;

import java.util.Arrays;

public class Str_Transform_TrimXtraSpaces {

	public static void main(String[] args) {

		Str_Transform_TrimXtraSpaces_Solution sol = new Str_Transform_TrimXtraSpaces_Solution();
		String s1 = "A    B    .xxxadsf ";
		System.out.println(sol.trimExtraSpaces("   A    B    "));
		System.out.println(sol.trimExtraSpaces("A    B    .xxx    "));
		System.out.println(sol.trimExtraSpaces(s1) + " size: "+sol.trimExtraSpaces(s1).length());
	}

}

class Str_Transform_TrimXtraSpaces_Solution {
	public String trimExtraSpaces(String s) {
		if (s == null || "".equals(s.trim()))
			return "";
		int i=0, j=0;
		int len = s.length();
		char[] carr = s.toCharArray();
		while(i<len) {
			while(i<len && s.charAt(i)==' ') {
				i++;
			}
			while(i<len && s.charAt(i)!=' '){
				carr[j] = s.charAt(i);
				i++;
				j++;
			}
			while(i<len && s.charAt(i)==' '){
				i++;
			}
			if(i<len) {
				carr[j] = ' ';
				j++;
			}
		}
		return String.valueOf(Arrays.copyOf(carr, j));
	}
}
