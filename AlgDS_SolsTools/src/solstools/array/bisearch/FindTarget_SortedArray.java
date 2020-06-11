package solstools.array.bisearch;

import java.util.Arrays;

/**
 * 
35. Search Insert Position (https://leetcode.com/problems/search-insert-position/)

Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.

Input: [1,1,1,1], -5	 Output: -1

Input: [1,1,1,1], 1	 Output: 0

Input: [ 1, 1, 2, 2, 2 ], 2	Output: 2

Input: [1,3,5,6], 5	Output: 2

Input: [1,3,5,6], 2 	Output: -1

Input: [1,3,5,6], 6	Output: 3
 *
 */

public class FindTarget_SortedArray {
	static FindTarget_SortedArray_Solution sol;

	public static void main(String[] args) {
		int[][] nums2 = new int[][] {
			{ 2, 4, 6, 8 },
			{ 2, 4, 6, 8 },
			{ 1, 1, 1, 1 },
			{ 1, 1, 2, 2, 2 }
		};
		int[] tgts = new int[] {1,8,1,2};
		
		for(int i=0; i<nums2.length; i++) {
			int[] nums = nums2[i];
			int tgt = tgts[i];
			int idx = sol.searchInsert(nums, tgt);
			System.out.format("arr: %s, tgt: %d, idx: %d \n", Arrays.toString(nums), tgt, idx);
		}
	}

}

class FindTarget_SortedArray_Solution {
	public static int searchInsert(int[] nums, int target) {
		return bisrch(nums, target);
	}

	private static int bisrch(int[] nums, int tgt) {
		int l = 0;
		int r = nums.length;
		while (l < r) {
			int m = l + (r - l) / 2;
			if (tgt <= nums[m]) {
				r = m; //Not doing r = m-1; helps to keep L to tgt
			} else {
				l = m + 1;
			}
		}
		return l<nums.length && nums[l]==tgt ? l : -1;
	}
}