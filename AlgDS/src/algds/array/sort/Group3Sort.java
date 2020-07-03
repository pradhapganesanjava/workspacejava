package algds.array.sort;

import java.util.Arrays;

public class Group3Sort {
	static Group3Sort_Solution sol;

	public static void main(String[] args) {

		int[][] nums2 = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 1, 2, 1, 0 },
				{ 1, 1, 0, 0, 1, 2, 2 }, { 1, 1, 1, 2, 2, 0 }, { 0, 0, 0, 1, 2 }, { 1, 1, 1, 1, 0 } };
		for (int i = 0; i < nums2.length; i++) {
			System.out.print("B4 :" + Arrays.toString(nums2[i]));
			sol.groupSort(nums2[i]);
			System.out.println(" => A4 :" + Arrays.toString(nums2[i]));
		}

	}

}

class Group3Sort_Solution {
	public static void groupSort(int[] nums) {
		group3Sort(nums);
	}

	private static void group3Sort(int[] nums) {
		useForLoop(nums);
		// useWhileLoop(nums);
	}

	private static void useForLoop(int[] nums) {
		for (int l = 0, r = nums.length - 1, m = 0; m <= r;) {
			if (nums[m] == 2) {
				swap(nums, m, r);
				r--;
				continue;
			} else if (nums[m] == 0) {
				swap(nums, l, m);
				l++;
			}
			m++;
		}
	}

	private static void useWhileLoop(int[] nums) {
		int cnt = 0;
		int l = 0;
		int r = nums.length - 1;
		int m = 0;
		while (cnt < nums.length) {
			while (l < nums.length && nums[l] == 0) {
				l++;
				cnt++;
			}
			while (r > -1 && nums[r] == 2) {
				r--;
				cnt++;
			}
			if (l <= r) {
				if (nums[l] != 1 && nums[r] != 1) {
					swap(nums, r, l);
					r--;
					l++;
				} else if (nums[r] != 2) {
					swap(nums, m, r);
					r--;
				} else {
					swap(nums, m, l);
					l++;
				}
				cnt++;
			}
		}
	}

	private static void group3Sort2(int[] nums) {
		int cnt = 0;
		for (int l = 0, r = nums.length - 1, m = 0; cnt < nums.length; cnt++) {
			if (nums[m] == 0) {
				swap(nums, l, m);
				l++;
				continue;
			}
			if (nums[m] == 2) {
				swap(nums, r, m);
				r--;
				continue;
			}
			m++;
		}
	}

	private static void swap(int[] nums, int l, int r) {
		int t = nums[l];
		nums[l] = nums[r];
		nums[r] = t;
	}
}
