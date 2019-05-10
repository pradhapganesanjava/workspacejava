package com.pg.algorithm.array.integer;

import java.util.HashMap;
import java.util.Map;

public class SumMatch {

	public static void main(String[] args) {

	}

	public int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> mp = new HashMap<>();
		int[] res = new int[2];
		int len = nums.length;
		if (null == nums || len == 0)
			return res;

		for (int i = 0; i < len; i++) {
			mp.put(nums[i], i);
		}

		for (int i = 0; i < len; i++) {
			int cur = nums[i];
			int rem = 0;
			if ((target >= 0 && cur >= 0) || (target < 0 && cur < 0)) {
				rem = Math.abs(target - cur);
				if (target < 0 && cur < 0) {
					rem *= -1;
				}
			} else {
				if (target > cur) {
					rem = target - cur;
				} else {
					rem = cur - target;
				}
			}

			if (mp.keySet().contains(rem) && i != mp.get(rem)) {
				return new int[] { i, mp.get(cur) };
			}
		}

		return res;
	}
}
