package algds.array.sort;

import java.util.Arrays;

public class Group2Sort {
	static Group2Sort_Solution sol;
	public static void main(String[] args) {
		
		int[][] nums2 = new int[][] {
			{0,0,0,0,0},
			{0,0,1,0,0},
			{0,0,1,0},
			{1,1,0,0},
			{1,1,1,0},
			{0,0,0,1},
			{1,1,1,1,0}
		};
		for(int i=0; i<nums2.length; i++) {
			System.out.print("B4 :"+ Arrays.toString(nums2[i]));
			sol.group2Sort(nums2[i]);
			System.out.println(" => A4 :"+ Arrays.toString(nums2[i]));
		}
	}

}


class Group2Sort_Solution{
	public static void group2Sort(int[] nums) {
		useForLoop(nums);
		//useWhileLoop(nums);
	}
	private static void useForLoop(int[] nums) {
		int l=0;
		for(int r=1; r<nums.length; r++) {
			if(nums[l]!=nums[r]) {
				swap(nums, l, r);
			}
		}
	}

	private static void useWhileLoop(int[] nums) {
		int l = 0;
		int r = nums.length -1;
		while(l<=r) {
			while(l<nums.length && nums[l] == 0) {
				l++;
			}
			while(r>-1 && nums[r]==1) {
				r--;
			}
			if(l<r) {
				swap(nums, l, r);
				l++;
				r--;
			}
		}
	}

	private static void swap(int[] nums, int l, int r) {
		int t = nums[l];
		nums[l] = nums[r];
		nums[r] = t;
	}
}