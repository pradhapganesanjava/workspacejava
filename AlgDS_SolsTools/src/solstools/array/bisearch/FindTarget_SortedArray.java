package solstools.array.bisearch;

import java.util.Arrays;

/**
 * 
35. Search Insert Position

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.

Input: [1,3,5,6], 5	Output: 2

Input: [1,3,5,6], 2 	Output: 1

Input: [1,3,5,6], 7	Output: 4

Input: [1,3,5,6], 0	Output: 0
 *
 */

public class FindTarget_SortedArray {
	static FindTarget_SortedArray_Solution sol;

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 3, 3, 3, 3 };
		int tgt = 4;
		int idx = sol.searchInsert(nums, tgt);
		System.out.format("arr: %s, tgt: %d, idx: %d \n", Arrays.toString(nums), tgt, idx);
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
			if (tgt == nums[m]) {
				return m;
			} else if (tgt < nums[m]) {
				r = m;
			} else {
				l = m + 1;
			}
		}
		return l;
	}
}