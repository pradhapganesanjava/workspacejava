package com.pg.alg.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MagicIndexArrFindMissing {

	public static void main(String[] args) {

		MagicIndexArrFindMissing.Solution sol = new MagicIndexArrFindMissing().new Solution();
		int[] iarr = null; 
		iarr = new int[] {3,3,1,4,2};
		List<Integer> resLst = sol.findDisappearedNumbers(iarr);
		System.out.format("\nInArr: %s  Missing: %s \n", Arrays.toString(iarr), Arrays.toString(resLst.toArray(new Integer[0])));
	}

	private class Solution {
	    public List<Integer> findDisappearedNumbers(int[] nums) {
	        List<Integer> resLst = new ArrayList<Integer>();
	        if(null == nums || nums.length ==0) return resLst;
	        for(int i=0; i<nums.length; i++){
	        		if(nums[i] < 0) continue;
	            int v = nums[i]-1;
	            while(nums[v] > 0){
	                int tv = nums[v];
	                nums[v] = -1; 
	                v = tv-1;
	            }
	        }
	        
	        for(int i=0; i< nums.length; i++){
	            if(nums[i] > 0){
	                resLst.add(i+1);
	            }
	        }
	        return resLst;
	    }
	}
}

