package com.pg.alg.bitwise;

import java.util.Arrays;

public class SingleNumberIn3Times {

	public static void main(String[] args) {
		
		int[] iarr = null;
		iarr = new int[] {-2,-2,1,1,-3,1,-3,-3,-4,-2};
		//iarr = new int[] {2,2,1,1,3,1,3,3,4,2};
		bitSumWayCount(iarr);
		simpleSumWayCount(iarr);
		
		
		
	}

	private static void simpleSumWayCount(int[] iarr) {
		int sum = 0;
		for(int i=0; i<iarr.length; i++) {
			sum += iarr[i];
		}
		
		int uniXor = iarr[0];
		for(int i=1; i<iarr.length; i++) {
			uniXor ^= iarr[i];
		}
		
		int diff = sum - uniXor;
		
		System.out.format("sum: %d, unixor: %d, diff: %d ", sum, uniXor, diff);
		
		int res = diff / 2;
		
		System.out.format("\niarr: %s , single num# %d \n", Arrays.toString(iarr), res);
	}

	private static void bitSumWayCount(int[] iarr) {
		Solution sol = new Solution();
		int sint = sol.singleNumber(iarr);
		System.out.format("iarr: %s , single num# %d \n", Arrays.toString(iarr), sint);
	}

}

class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        
        int[] iarr = new int[32];
        
        for(int i=0; i<nums.length; i++){
            int cnt = 0;
            int n = nums[i];
            while(n != 0 && cnt < 32){
                if( (n&1) != 0){
                    iarr[cnt] = iarr[cnt]+1;
                }
                cnt++;
                n = n>>1;
            }
        }
        
        for(int i=0; i<32; i++){
            iarr[i] = iarr[i] % 3;
        }
        int res = 0;
        for(int i=0; i<32; i++){
            if(iarr[i] != 0){
                res ^= 1 << i;
            }
        }
        
        return res;
    }
}