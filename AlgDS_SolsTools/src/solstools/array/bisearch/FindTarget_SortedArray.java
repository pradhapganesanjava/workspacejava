package solstools.array.bisearch;

import java.util.Arrays;

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