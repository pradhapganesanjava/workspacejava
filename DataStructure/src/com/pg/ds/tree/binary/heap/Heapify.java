package com.pg.ds.tree.binary.heap;

import java.util.Arrays;

public class Heapify {
	
	 public static void doHeapify(int arr[], int n){
	        // Build heap (rearrange array) 
	        for (int i = n / 2 - 1; i >= 0; i--) 
	        	downRecur(arr, n, i); 
	 }
	
	  public static void downRecur(int arr[], int n, int i) 
	    { 
	        int smallest = i; // Initialize smalles as root 
	        int l = 2 * i + 1; // left = 2*i + 1 
	        int r = 2 * i + 2; // right = 2*i + 2 
	  
	        // If left child is smaller than root 
	        if (l < n && arr[l] < arr[smallest]) 
	            smallest = l; 
	  
	        // If right child is smaller than smallest so far 
	        if (r < n && arr[r] < arr[smallest]) 
	            smallest = r; 
	  
	        // If smallest is not root 
	        if (smallest != i) { 
	            int temp = arr[i]; 
	            arr[i] = arr[smallest]; 
	            arr[smallest] = temp; 
	  
	            // Recursively heapify the affected sub-tree 
	            downRecur(arr, n, smallest); 
	        } 
	    } 
	
	public static int[] down(int[] arr){
		int n = arr.length;
		int[] intArr = arr.clone();
		
		for(int i = 0; i < n ; i++){
			
			int it = i;
			int its = getSmaller(intArr, it);
			
			while(it != its){
				swap(intArr, it, its);
				it = getParent(it);
				its = getSmaller(intArr, it);
			}
		}
		return intArr;
	}

	private static int getSmaller(int[] intArr, int it) {

		int n = intArr.length;
		int l = it * 2 + 1;
		int r = it * 2 + 2;
		int s = it;
		if(l < n && intArr[l] < intArr[s]){
			s = l;
		}
		if(r < n && intArr[r] < intArr[s]){
			s = r;
		}
		
		return s;
	}

	public static int[] array(int[] ain) {
		
		if (null == ain || ain.length == 0) {
			return null;
		}
		
		int[] arr = Arrays.copyOf(ain, ain.length);

		int len = arr.length;

		for (int i = 0; i < len; i++) {

			int icur = i;
			int ip = getParent(icur);
			
			if(icur <= 0) continue;
			
			while(isReqSwap(arr, icur, ip)){
				swap(arr, icur,ip);
				icur = ip;
				ip = getParent(icur);
			}
		}

		return arr;
	}

	private static void swap(int[] arr, int icur, int ip) {
		if(icur <0 || ip <0 || icur >= arr.length || ip >= arr.length){
			return;
		}
		
		int itmp = arr[ip];
		arr[ip] = arr[icur];
		arr[icur] = itmp;
	}

	private static boolean isReqSwap(int[] arr, int icur, int ip) {
		if(icur <0 || ip <0 || icur >= arr.length || ip >= arr.length){
			return false;
		}
		
		return arr[ip] > arr[icur];
		
	}

	private static int getParent(int icur) {
		return icur <=0 ? 0 : (icur-1)/2;
	}

}
