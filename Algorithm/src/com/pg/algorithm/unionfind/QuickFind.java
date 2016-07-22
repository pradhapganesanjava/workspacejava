package com.pg.algorithm.unionfind;

import java.util.Arrays;

/*
 * Quadratic way of doing QuickFind algorithm, is 10times slower. Big O is N^2.
 *   
 */
public class QuickFind {

	private static int COUNT = 10;
	private static int[] intArr;

	/**
	 * @param args
	 * 
	 * 
	 */
	public static void main(String[] args) {

		COUNT = getInputCount(args);

		intArr = initIntArray();
		
		connect(4,3);
		connect(3,8);
		connect(6,5);
		connect(9,4);
		connect(2,1);
		connect(8,9);
		connect(5,0);
		connect(7,2);
		connect(6,1);
		
		System.out.println("Arrays: "+Arrays.toString(intArr));

	}

	private static void connect(int p, int q) {
		if(!isConnected(p, q)){
			union(p,q);
		}
	}

	public static void union(int intP, int intQ) {

		int intPVal = intArr[intP];
		int intQVal = intArr[intQ];

		for(int i = 0; i < intArr.length; i++){
			if(intArr[i] == intPVal){
				intArr[i] = intQVal;
			}
		}
	}

	public static boolean isConnected(int intP, int intQ) {

		if(intArr[intP] == intArr[intQ]){
			System.out.println("Already Connected");
			return true;
		}
		return false;
	}

	private static int[] initIntArray() {
		int[] intArr = new int[COUNT];
		for(int i = 0; i < intArr.length; i++){
			intArr[i] = i;
		}
		return intArr;
	}

	private static int getInputCount(String[] args) {
		if(null != args && args.length > 0 && null != args[0]){
			try{
				COUNT = Integer.parseInt(args[0]);
			}catch(Exception e){
				System.out.println("exception " + e.getMessage());
			}
		}
		return COUNT;
	}

}
