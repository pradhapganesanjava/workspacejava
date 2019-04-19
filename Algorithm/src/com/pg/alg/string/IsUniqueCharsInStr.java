package com.pg.alg.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsUniqueCharsInStr {

	/**
	 * Implement an algorithm to determine if a string has all unique
	 * characters. What if you can not use additional data structures?
	 */
	public static void main(String[] args) {

		// String s = "abcdxyz ABCDXYZ!@#$%^&*()_+?><:;";
		String s = "aabbcddxxyzz";
		s = "abcdefghijklmnopABCDEE ";
		// OofNsquare(s);
		//OofN_ASCII(s);
		//isUniqueChars(s);
		
		String s1 = "tea";
		String s2 = "ate";
		
		
		System.out.println(strAnagramCode(s1));
		System.out.println(strAnagramCode(s2));
		
			

		// mergeSortWay(s);
	}
	private static boolean isAnagram(String str1, String str2){
		return false;
	}

	private static int strAnagramCode(String str){
		int count = 0;
		int anagramCode = 0;
		while(count < str.length()){
		  	anagramCode+=str.charAt(count);
		  	count++;
		}
		return anagramCode;
	}
	
	private static void mergeSortWay(String s) {
		char[] rootArr = s.toCharArray();
		List<Character> repeatCharList = new ArrayList<Character>(rootArr.length);
		sort(rootArr, repeatCharList);
		System.out.println("repeaded chars " + Arrays.toString(repeatCharList.toArray()));
	}

	private static void sort(char[] rootArr, List repeatCharList) {

		if (rootArr.length < 2) {
			return;
		}

		int midArrCount = rootArr.length / 2;

		char[] leftArr = new char[midArrCount];
		char[] rightArr = new char[rootArr.length - midArrCount];

		for (int i = 0; i < midArrCount; i++) {
			leftArr[i] = rootArr[i];
		}
		for (int i = midArrCount; i < rootArr.length; i++) {
			rightArr[i - midArrCount] = rootArr[i];
		}
		sort(leftArr, repeatCharList);
		sort(rightArr, repeatCharList);
		mergeSort(leftArr, rightArr, rootArr, repeatCharList);
	}

	private static void mergeSort(char[] leftArr, char[] rightArr, char[] rootArr, List repeatCharList) {

		int leftArrCount = 0;// leftArr.length;
		int rightArrCount = 0;// rootArr.length;
		int rootArrCount = 0;// rootArr.length;

		while (leftArrCount < leftArr.length && rightArrCount < rightArr.length) {
			if (leftArr[leftArrCount] == rightArr[rightArrCount]) {
				// repeatCharArr[rootArrCount] = leftArr[leftArrCount];
				repeatCharList.add(leftArr[leftArrCount]);
				leftArrCount++;
			} else {
				// rootArr[rootArrCount]='\u0000';
				rightArrCount++;
			}

			rootArrCount++;
		}
		while (leftArrCount < leftArr.length) {
			// rootArr[rootArrCount]='\u0000';
			rootArrCount++;
			leftArrCount++;
		}

		while (rightArrCount < rightArr.length) {
			// rootArr[rootArrCount]='\u0000';
			rootArrCount++;
			rightArrCount++;
		}
	}

	private static void isUniqueChars(String str) {
		for (int i = 0; i < str.length(); i++) {
			if(str.indexOf(str.charAt(i), i + 1)>-1){
				System.out.println("first dup char "+str.charAt(i)+"");
				return;
			}
		}
		System.out.println("NO dup char ");
	}
	// kind of QuickFind way
	private static boolean OofN_ASCII(String s) {

		System.out.println("N is" + s.length());
		int count = 0;

		boolean[] boolArr = new boolean[126];
		for (int i = 0; i < s.length(); i++) {
			count++;
			int charInt = s.charAt(i);
			System.out.println(s.charAt(i) + "=>" + charInt);
			if (boolArr[charInt] == true) {
				System.out.println("?char true?" + (char) charInt);
				System.out.println("boolArr array" + Arrays.toString(boolArr));
				System.out.println("Is String unique? NO");
				return true;
			} else {
				boolArr[charInt] = true;
			}
		}
		System.out.println("boolArr array" + Arrays.toString(boolArr));
		System.out.println("O(n) is:" + count);
		System.out.println("Is String unique? YES");
		return false;
	}

	/**
	 * 
	 * kind of bubble sort
	 */
	private static void OofNsquare(String s) {
		System.out.println("N is" + s.length());
		int count = 0;
		boolean isUnique = false;
		for (int i = 0; i < s.length(); i++) {
			count++;
			for (int j = i; j < s.length() - 1; j++) {
				count++;
				if (s.charAt(i) == s.charAt(j + 1)) {
					System.out.println("Following char is NOT unique: " + s.charAt(i));
					isUnique = true;
				}
			}
		}

		System.out.println("O(n^2-n^2/2) is:" + count);
	}

}
