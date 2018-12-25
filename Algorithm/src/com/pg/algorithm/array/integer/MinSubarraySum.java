package com.pg.algorithm.array.integer;

import java.util.HashMap;

public class MinSubarraySum {

	public static void main(String[] args) {

		int[] _1a = {2,1,1,1,5,3,3,2};
		int _1s = 7;
		System.out.println(minSubArrayLen(_1s,_1a));
		System.out.println(minSubArrayLen_Mp(_1s,_1a));
		System.out.println(maxSubArrayLen(_1s,_1a));
		
		int[] _2a = {6,7,8,5,4,8};
		int _2s = 3;
		System.out.println(minSubArrayLen(_2s,_2a));
		System.out.println(minSubArrayLen_Mp(_2s,_2a));
		System.out.println(maxSubArrayLen(_2s,_2a));
		
		int[] _3a = {18,2,7,5,1,10,2};
		int _3s = 8;
		System.out.println(minSubArrayLen(_3s,_3a));
		System.out.println(minSubArrayLen_Mp(_3s,_3a));
		System.out.println(maxSubArrayLen(_3s,_3a));		
	}

	public static int minSubArrayLen(int s, int[] nums) {
	    if(nums==null||nums.length==0)
	        return 0;
	 
	    int i=0; 
	    int j=0;
	    int sum=0;
	 
	    int minLen = Integer.MAX_VALUE;
	 
	    while(j<nums.length){
	        if(sum<s){
	            sum += nums[j];
	            j++;        
	        }else{
	            minLen = Math.min(minLen, j-i);
	            if(i==j-1)
	                return 1;
	 
	            sum -=nums[i];
	            i++;
	        }
	    }
	 
	    while(sum>=s){
	        minLen = Math.min(minLen, j-i);
	 
	        sum -=nums[i++];
	    }
	 
	    return minLen==Integer.MAX_VALUE? 0: minLen;
	}
	
	public static int minSubArrayLen_Mp(int k, int[] nums) {
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	 
	    int min = 0;
	 
	    int sum=0;
	    for(int i=0; i<nums.length; i++){
	        sum += nums[i];
	 
	        if(sum==k){
	        	min = Math.min(min, i+1);
	        }  
	 
	        int diff = sum-k;
	 
	        if(map.containsKey(diff)){
	        	min = Math.min(min, i-map.get(diff));
	        }
	 
	        if(!map.containsKey(sum)){
	            map.put(sum, i);
	        }
	    }
	 
	 
	    return min;
	}
	
	public static int maxSubArrayLen(int k, int[] nums) {
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	 
	    int max = 0;
	 
	    int sum=0;
	    for(int i=0; i<nums.length; i++){
	        sum += nums[i];
	 
	        if(sum==k){
	            max = Math.max(max, i+1);
	        }  
	 
	        int diff = sum-k;
	 
	        if(map.containsKey(diff)){
	            max = Math.max(max, i-map.get(diff));
	        }
	 
	        if(!map.containsKey(sum)){
	            map.put(sum, i);
	        }
	    }
	 
	 
	    return max;
	}
}
