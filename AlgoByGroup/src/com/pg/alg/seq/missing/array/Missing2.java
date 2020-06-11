package com.pg.alg.seq.missing.array;

/**
 * 
 * Given an array of n unique integers where each element in the array is in
 * range [1, n]. The array has all distinct elements and size of array is (n-2).
 * Hence Two numbers from the range are missing from this array. Find the two
 * missing numbers.
 * 
 * Examples:
 * 
 * Input : arr[] = {1, 3, 5, 6}, n = 6 Output : 2 4
 * 
 * Input : arr[] = {1, 2, 4}, n = 5 Output : 3 5
 * 
 * Input : arr[] = {1, 2}, n = 4 Output : 3 4
 *
 */

/*
 * Key point are :
 * > Same Number Xor ^ result 0
 * > 1st Iteration Given Array (N-2) xor each number
 * > 2nd Iteration Xor with N number;
 * > Now Xor value has combination of 2 missing number
 * > Get set bit (Right Most 1 bit) of Xor, ie bit both number differ 
 * > Repeat two iterations (N-2 and then N), buy & with Xor; this will group two set of integers
 * > missing numbers will be separated, and easily mapped
 */
public class Missing2 {

	public static void main(String[] args) {
		int X = 0;
		System.out.format("X: %d, XBits: %s, X-1 Bit: %s, SetBit: %s \n ", X, Integer.toBinaryString(X), Integer.toBinaryString(X-1), (X & ~(X-1)));
		
		int iarr[] = {1, 7, 2, 4, 5, 6};
		
		int N = 8;
		
		int miss2Xor = 0;
		
		for(int i=0; i<iarr.length;i++) {
			miss2Xor ^= iarr[i];
		}
		
		for(int i=1; i<=N;i++) {
			miss2Xor ^= i;
		}
		
		miss2Xor = miss2Xor & ~ (miss2Xor-1);
		int miss1 = 0;
		int miss2 = 0;
		
		for(int i=0; i<iarr.length;i++) {
			if( (iarr[i] & miss2Xor) == 0) {
				miss1 ^= iarr[i];
			}else {
				miss2 ^= iarr[i];
			}
		}
		for(int i=1; i<=N;i++) {
			if( (i & miss2Xor) == 0) {
				miss1 ^= i;
			}else {
				miss2 ^= i;
			}
		}
		
		System.out.format("Missing numbers %d, %d \n", miss1, miss2);
				
	}

}
