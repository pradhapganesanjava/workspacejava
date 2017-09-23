package com.pg.algorithm.array.integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSmallerAfterSelf {

	public static void main(String[] args) {
//		new Solution().countSmaller(new int[]{1,2,3,4,5,6,7,8,9,10});
//		new Solution().countSmaller(new int[]{10,12,14,9,14,11,8,11});
//		new Solution().countSmaller(new int[]{1,2,3,4,5,6,7,8,9,10});
//		new Solution().countSmaller(new int[]{10,9,8,7,6,5,4,3,2,1});
		new Solution().countSmaller(new int[]{10,15,20,18});
	}

}

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int numsLen = nums.length;
        List<Integer> countSmaller = new ArrayList<>(numsLen);
        int[] countSmalArr = new int[numsLen];
        ArrayList<Integer>[] arrOfList = new ArrayList[0];
        int[][] valSmalArr = new int[numsLen][numsLen];
	        for(int i=numsLen-1 ; i>-1; --i){
	            
	            if(i==numsLen-1){
//	                countSmalArr[i]++;
	                continue;
	            }
	            int r = i+1;
	            if(nums[i]>nums[r]){
	                countSmalArr[i]++;
	                int[] listInts = valSmalArr[r];
	                if(listInts.length==0){
	                    listInts[0] = nums[r];
	                }else{
	                	listInts[listInts.length-1]=nums[r];
	                }
	            }
	            for(int j=countSmalArr[r]-1; j>-1; --j){
	            	int[] listInts = valSmalArr[j];
	            	if(listInts.length>0 && nums[i] > listInts[j]){
	                    countSmalArr[i]++;
	                    int[] newIntsArr = valSmalArr[r];
	                    if(newIntsArr.length==0){
	                    	newIntsArr[0] = listInts[j];
	                    }else{
	                    	newIntsArr[listInts.length-1]=listInts[j];
	                    }
	            }
	        }
	     }

	     for(int i=0;i<nums.length;i++){
	    	 countSmaller.add(countSmalArr[i]);
	     }
	     System.out.println("IN: "+Arrays.toString(nums)+"  OUT: "+Arrays.toString(countSmalArr));
	     return countSmaller;
    }
}