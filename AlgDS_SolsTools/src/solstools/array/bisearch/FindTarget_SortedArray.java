package solstools.array.bisearch;

import java.util.Arrays;

/**
 * 
704. Binary Search ( https://leetcode.com/problems/binary-search/ )

Given a sorted (in ascending order) integer array nums of n elements and a target value, 
write a function to search target in nums. If target exists, then return its index, otherwise return -1.


Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

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