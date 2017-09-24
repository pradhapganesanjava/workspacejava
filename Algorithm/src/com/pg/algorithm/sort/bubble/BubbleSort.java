package com.pg.algorithm.sort.bubble;

import java.util.Arrays;

public class BubbleSort {

	private static int[][] arrIntInputs = {
			{ 10, 5,11, 2, 1, 9 },
			{},
			{ 0},
			{ 0,1},
			{ 9,8},
			{ 0,1,2,3,4,5,6,7,8,9},
			{ 9,8,7,6,5,4,3,2,1,0},
			{ 0,1,2,3,0,2,2,1,4,5,6,7,8,9}
	};

	public static void main(String[] args) {

		for(int[] arrInt : arrIntInputs){
//			bubbleWith_i_j(arrInt);
			bubbleWithonly_j(arrInt);
		}
		
	}

	private static void bubbleWith_i_j(int[] arrInt) {
		printLineStars();
		int[] copyOfArrInt = Arrays.copyOf(arrInt, arrInt.length);
		int count = 0;
		for(int i = 0 ; i< arrInt.length;i++){
			for(int j = 0; j < arrInt.length; j++){
				count++;
				if(arrInt[i]<arrInt[j]){
					swapUsingBits(arrInt, i, j);
				}
				//System.out.println("("+i+","+j+") "+Arrays.toString(arrInt));
			}
			System.out.println(i+": "+Arrays.toString(arrInt));
		}
		System.out.println("Input: "+Arrays.toString(copyOfArrInt));
		System.out.println("Output: "+Arrays.toString(arrInt));
		System.out.println("timeComplex n= "+arrInt.length + " \n O(n^2) = O( "+count+" )");
		printLineStars();
	}

	private static void printLineStars() {
		Character[] arrChar = new Character[80];
		Arrays.asList(arrChar).forEach(i->{System.out.print("*");if(i>=79)System.out.print("\n");});
	}

	private static void swapUsingBits(int[] arrInt, int i, int j) {
		arrInt[i] = arrInt[i] ^ arrInt[j];
		arrInt[j] = arrInt[i] ^ arrInt[j];
		arrInt[i] = arrInt[i] ^ arrInt[j];
	}

	private static void bubbleWithonly_j(int[] arrInt) {
		printLineStars();		
		int[] copyOfArrInt = Arrays.copyOf(arrInt, arrInt.length);
		int count = 0;

		for(int i = 0; i < arrInt.length; i++){
			for(int j = 0; j < arrInt.length-1; j++){
				count++;
				int tmp = arrInt[j];
				if(tmp > arrInt[j+1]){
					arrInt[j] = arrInt[j+1];
					arrInt[j+1] = tmp;
				} 
			}
			System.out.println(i+": "+Arrays.toString(arrInt));	
		}

		System.out.println("Input: "+Arrays.toString(copyOfArrInt));
		System.out.println("Output: "+Arrays.toString(arrInt));
		System.out.println("timeComplex n= "+arrInt.length + " \n O(n^2 - n ) = O( "+count+" )");
		printLineStars();
	}

}
