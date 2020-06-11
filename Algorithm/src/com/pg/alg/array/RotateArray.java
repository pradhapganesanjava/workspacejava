package com.pg.alg.array;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {
		RotateArray_Solution sol = new RotateArray_Solution();
		int[] iarr = new int[] {1,2,3,4};
		sol.rotate(iarr, 2);
		System.out.println(Arrays.toString(iarr));
	}

}

class RotateArray_Solution {
    public void rotate(int[] nums, int k) {
        if(nums==null || nums.length < 2 || k == 0) return;
        
        failCountSwap(nums, k);
        
    }
    private void failCountSwap(int[] nums, int k){

        int p = 0;
        
        for(int i=0;i<nums.length/2; i++){
            
            int q = (p+k)%nums.length;
            int tp = nums[p];
            int tq = nums[q];
            nums[p] = tq;
            nums[q] = tp;
            p = q;
        }       
    }
}