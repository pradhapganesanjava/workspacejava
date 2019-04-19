package com.pg.alg.string;

import java.util.Comparator;

public class AnagramCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("isAnagram ? " + isAnagram("treat", "tater"));

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
		String str2 = o2.toString();
		
		int compare = 0;
		
		char[] charArr1 = str1.toCharArray();
		for(int i=0;i<charArr1.length;i++){
			charIntArr[charArr1[i]]++;}
		
		char[] charArr2 = str2.toCharArray();
		for(int i=0;i<charArr2.length;i++){
			int tmpVal = --charIntArr[charArr2[i]];
			if(tmpVal < 0){
				compare = -1;	break;}}
		
		for(int i=0;i<charIntArr.length;i++){
			if(charIntArr[i]!=0){
				compare = -1;	break;}}
		
		return compare;
	}
}