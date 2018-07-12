package com.pg.algorithm.array.integer;

public class OddNumberOfTimesOccurPositiveArr {

	public static void main(String[] args) {

		int[] iArr1 = {2,5,9,1,5,1,8,2,8};
		
		int[] iArr2 = {2,3,4,3,1,4,5,1,4,2,5 };
		
		int[] iArrBig1 = {253332233,33123,445666,33123,33123,445666,5,1,5,1,33123 };
		
		oddNumberOfTimesOccuringXOR(iArr1);
		
		oddNumberOfTimesOccuringXOR(iArr2);
		
		oddNumberOfTimesOccuringXOR(iArrBig1);
		
	}

	public static void oddNumberOfTimesOccuringXOR(int[] input) {
		if (input == null || input.length == 0) {
			System.out.println("Empty input array.");
			return;
		}
		int result = input[0];
		for (int i = 1; i < input.length; i++) {
			System.out.println(result +" ^ " + input[i] +" = "+ (result ^ input[i]));
			result = result ^ input[i];
		}
		System.out.println("Number occurring odd number of times is " + result);
	}

}
