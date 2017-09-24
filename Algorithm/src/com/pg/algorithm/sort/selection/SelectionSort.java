package com.pg.algorithm.sort.selection;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {

		int[] intArr = {5,4,0,1,-5,0,3,3,8};
//		int[] intArr = {};
//		int[] intArr = {5};
//		int[] intArr = {1,2};
//		int[] intArr = {2,1};
		
		System.out.println("Input: "+Arrays.toString(intArr));
		int minIndex = 0;
		for(int i = 0; i < intArr.length;i++){
			minIndex = i;
			for(int j = i+1; j< intArr.length;j++){
				if(intArr[minIndex] > intArr[j]){
					minIndex = j;
				}
			}
			if(i != minIndex){
				swapUsingBits(intArr, minIndex, i);
			}
			System.out.println(i+": "+Arrays.toString(intArr));
		}

	}

	private static void swapUsingBits(int[] intArr, int minIndex, int i) {
		intArr[minIndex] = intArr[minIndex] ^ intArr[i];
		intArr[i] = intArr[minIndex] ^ intArr[i];
		intArr[minIndex] = intArr[minIndex] ^ intArr[i];
	}

}
