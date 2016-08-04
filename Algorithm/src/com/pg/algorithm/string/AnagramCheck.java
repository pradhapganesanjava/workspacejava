package com.pg.algorithm.string;

import java.util.Comparator;

public class AnagramCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("isAnagram ? " + isAnagram("tea", "atc"));

	}

	private static boolean isAnagram(String str1, String str2) {
		Comparator comp = new AnagramComparable();
		int intVal = comp.compare(str1, str2);
		if (intVal != 0) {
			return false;
		} else {
			return true;
		}
	}

}

class AnagramComparable implements Comparator {

	int[] charIntArr = new int[256];

	@Override
	public int compare(Object o1, Object o2) {
		String str1 = o1.toString();
		String str2 = o1.toString();
		
		char[] charArr1 = str1.toCharArray();
		for(int i=0;i<charArr1.length;i++){
			if(charIntArr[charArr1[i]] == '\u0000'){
				charIntArr[charArr1[i]]++;
			}
		}
		
		return 0;
	}
}