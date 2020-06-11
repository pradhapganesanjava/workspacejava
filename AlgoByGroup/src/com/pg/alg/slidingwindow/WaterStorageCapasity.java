package com.pg.alg.slidingwindow;

import java.util.Arrays;

public class WaterStorageCapasity {

	public static void main(String[] args) {
		int[] iarr = new int[] {1,0,1};
		System.out.format("in: %s , storage: %d \n", Arrays.toString(iarr), calcCapasity(iarr));
		
		iarr = new int[] {3,1,1};
		System.out.format("in: %s , storage: %d \n", Arrays.toString(iarr), calcCapasity(iarr));
		
		iarr = new int[] {1,2,3};
		System.out.format("in: %s , storage: %d \n", Arrays.toString(iarr), calcCapasity(iarr));
		
		iarr = new int[] {3,2,3};
		System.out.format("in: %s , storage: %d \n", Arrays.toString(iarr), calcCapasity(iarr));
		
		iarr = new int[] {3,0,10,0,3};
		System.out.format("in: %s , storage: %d \n", Arrays.toString(iarr), calcCapasity(iarr));
	}
	
	private static int calcCapasity(int[] arr){
	    if(arr == null || arr.length <=2) return 0;

	    int lx = Integer.MIN_VALUE;
	    int rx = Integer.MIN_VALUE;
	    int l = 0;
	    int r = rx-1;
	    
	    int cnt = 0;

	    while( l <= r){
	        while(lx <= rx){
	            if(arr[l] > lx){
	                lx = arr[l];
	                l++;
	                continue;
	            }else{
	                int dif = lx - arr[l];
	                cnt += dif;
	                l++;
	            }
	        }
	        while(lx > rx){
	             if(arr[r] > rx){
	                rx = arr[r];
	                r++;
	                continue;
	            }else{
	                int dif = rx - arr[r];
	                cnt += dif;
	                r++;
	            }           
	        }
	    }
	    return cnt;
	}

}
