package com.pg.algorithm.sort.quick;

import java.util.Arrays;

public class QuickSortRevisit {

	public static void main(String[] args) {

		int[] ar1 = { 1,2,3,4,5};
		int[] ar2 = {4,2,2,2,1};
		int[] ar3 = {10,1,5,6};
		int[] ar4 = { 9, 6, 5, 0, 8, 4, 2, 7 };
		int[] ar5 = { 13, 19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11 };
		quickSort(ar1,0,ar1.length-1);
		quickSort(ar2,0,ar2.length-1);
		quickSort(ar3,0,ar3.length-1);
		quickSort(ar4,0,ar4.length-1);
		quickSort(ar5,0,ar5.length-1);
		
		System.out.println(Arrays.toString(ar1));
		System.out.println(Arrays.toString(ar2));
		System.out.println(Arrays.toString(ar3));
		System.out.println(Arrays.toString(ar4));
		System.out.println(Arrays.toString(ar5));
	}
	
	
	private static void quickSort(int[] arr, int i, int j){
		if(i >= j )return;
		
		int pi = findPivot(arr, i, j);
		
		quickSort(arr, i, pi-1);
		quickSort(arr, pi, j);
	}


	private static int findPivot(int[] arr, int i, int j) {

		int pi = (i + j) / 2;
		
		swap(arr,pi,i);
		
		while(i<=j){
			
			while(arr[i] < arr[pi]){
				i++;
			}
			while(arr[j] > arr[pi]){
				j--;
			}
			if(i<=j){
				int ti = arr[i];
				arr[i] = arr[j];
				arr[j] = ti;
				i++;
				j--;
			}
			
		}
		/*if(i <= pi){
		}else if(j <= pi ){
		}
		if(i == j){
			swap(arr,pi,j);
		}*/
		
		return i;
	}

	public static void swap(int[] nums, int n1, int n2) {
		int tmp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = tmp;
	}
}


