package com.pg.algorithm.array.integer;

import java.util.Arrays;
import java.util.Random;

public class Find_Kth_LargestLement {

	public static void main(String[] args) {

		int[] intArr = new int[20];
		Random rand = new Random();
		
		/*for(int intV : intArr){
			intV = rand.nextInt(10);
		}*/
		
		intArr = rand.ints(1,10).toArray();
		
		//Arrays.stream(intArr).map(n -> rand.nextInt(10)).close();
		
		System.out.println("Input intArr : "+Arrays.toString(intArr));
		int count = 0;
		//Arrays.stream(intArr).forEach((intArr, n) -> System.out.println(findKthLargest(intArr, n++)));
	}

	
	public  static int findKthLargest(int[] nums, int k) {
		if (k < 1 || nums == null) {
			return 0;
		}
	 
		return getKth(nums.length - k +1, nums, 0, nums.length - 1);
	}
	 
	public static int getKth(int k, int[] nums, int start, int end) {
	 
		int pivotRandIndex = start + new Random().nextInt(end) % (end-start+1);
		
		int pivot = nums[pivotRandIndex];
		// move pivot element to the end
		swap(nums,pivotRandIndex,end);
		
		pivotRandIndex = end;
		
		
	 
		int left = start;
		int right = end;
	 
		while (true) {
	 
			while (nums[left] < pivot && left < right) {
				left++;
			}
	 
			while (nums[right] >= pivot && right > left) {
				right--;
			}
	 
			if (left == right) {
				break;
			}
	 
			swap(nums, left, right);
		}
	 
		swap(nums, left, end);
	 
		if (k == left + 1) {
			return pivot;
		} else if (k < left + 1) {
			return getKth(k, nums, start, left - 1);
		} else {
			return getKth(k, nums, left + 1, end);
		}
	}
	 
	public static void swap(int[] nums, int n1, int n2) {
		int tmp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = tmp;
	}
}
