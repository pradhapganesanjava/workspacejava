package com.pg.alg.array.path;

import java.util.ArrayList;
import java.util.List;

public class IArray132Pattern {

	public static void main(String[] args) {
		IArray132Pattern_Solution sol = new IArray132Pattern_Solution();
		int[] iarr1 = new int[] { 3, 1, 4, 2 };
		sol.find132pattern(iarr1);
	}

}

class IArray132Pattern_Solution {
	public boolean find132pattern(int[] nums) {

		return recurPermutWay0(nums);
	}

	private boolean recurPermutWay(int[] nums) {
		if (nums == null || nums.length < 3)
			return false;

		List<Integer> ilst = new ArrayList<>(3);
		if (recurPermutWay(nums, ilst, 0)) {
			return true;
		}
		return false;
	}

	private boolean recurPermutWay0(int[] nums) {
		if (nums == null || nums.length < 3)
			return false;

		for (int i = 0; i < nums.length; i++) {
			List<Integer> ilst = new ArrayList<>(3);
			if (recurPermutWay(nums, ilst, i)) {
				return true;
			}
		}
		return false;
	}

	private boolean recurPermutWay(int[] nums, List<Integer> ilst, int idx) {
		if (idx > nums.length || ilst.size() > 3)
			return false;
		if (ilst.size() == 3) {
			ilst.forEach(e -> System.out.print(e));
			System.out.println();
			if (ilst.get(0) < ilst.get(2) && ilst.get(2) < ilst.get(1)) {
				return true;
			}
			return false;
		}

        for(int i=idx; i<nums.length; i++){
    		    ilst.add(nums[idx]);
			boolean bflg = recurPermutWay(nums, ilst, i+1);
			if (bflg)
				return true;
			ilst.remove(ilst.size() - 1);
        }

		return false;
	}
}
