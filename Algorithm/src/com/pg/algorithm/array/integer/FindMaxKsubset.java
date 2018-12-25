package com.pg.algorithm.array.integer;

import java.util.Arrays;

public class FindMaxKsubset {

	private static int[] arr1 = {12,0,11,5,9,0,10,13};
	
	public static void main(String[] args) {

		System.out.println( Arrays.toString(findMaxInSubset(2, arr1)) );
		
	}

	private static int[] findMaxInSubset(int k, int[] arr) {

		int mxRangeInx = findMaxIndex(arr,0,k);
		int res[] = new int[arr.length-k+1];
		int resInx = 0;
		res[resInx]=arr[mxRangeInx];
		
		for(int i = k; i< arr.length; i++){
			resInx++;
			if( i < mxRangeInx + k ){
				if( arr[i] > arr[mxRangeInx]){
					mxRangeInx = i;
				}
			}else{
				 mxRangeInx = findMaxIndex(arr,mxRangeInx+1,i+1);
			}
			res[resInx]=arr[mxRangeInx];					
		}
		
		
		
		return res;
	}

	private static int findMaxIndex(int[] arr, int from, int to) {
		int mxRangeInx = -1;
		int[] arrTmp = Arrays.copyOfRange(arr, from, to);
		Arrays.sort(arrTmp);
		int mx = arrTmp[arrTmp.length-1];
		
		for(int i=from; i<to; i++){
			if(mx == arr[i]){
				mxRangeInx = i;				
			}
		}
		
		return mxRangeInx;
	}

}
