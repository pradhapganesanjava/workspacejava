package com.pg.alg.string.permcomb;

/***
 * permutation is a rearrangement of letters 
 * 
 * @author pradhapganesan
 *
 */
public class Permutation_CheckS2IsPermofS1 {

	public static void main(String[] args) {
		System.out.println("1 " + checkS2isPermutationofS1("abcde", "abbb"));
		System.out.println("2 " + checkS2isPermutationofS1("abcde", "edcab"));
		System.out.println("3 " + checkS2isPermutationofS1("abcde", "aabbccdd"));
		System.out.println("4 " + checkS2isPermutationofS1("abcde", "abcf"));
	}

	private static boolean checkS2isPermutationofS1(String s1, String s2) {
		int[] intS1 = new int[26];
		if(s2.length()>s1.length()) return false;
		for(int i=0; i < s1.length(); i++) {
			int dx = s1.charAt(i)-'a';
			intS1[dx] = intS1[dx] + 1;
		}
		for(int i=0; i< s2.length(); i++) {
			int dx = s2.charAt(i) - 'a';
			if(intS1[dx] == 0) {
				return false;
			}
		}
		return true;
	}
}
