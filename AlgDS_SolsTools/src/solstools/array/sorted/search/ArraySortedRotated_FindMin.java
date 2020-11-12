package solstools.array.sorted.search;

/*
	<a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/">154. Find Minimum in Rotated Sorted Array II</a>
 	Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
	Find the minimum element.
	The array may contain duplicates.

	//Case#1: min is in 2nd half; pv > end
	input: [2,2,2,1,1] output: 1
	
	//Case#2 min is in 1st half; pv < end
	input: [2,1,1,2,2,2] output: 1
	
	//Case#3 min is in mid; pv == end
	input: [10,1,10,10,10,10] 

 	//Flat
 	input: [ 4,4,4,4,4,4] output: 4
 	
 	//Asc
 	input: [ 1,2,3,4,5 ] output: 1
 	
 	//Dsc
 	input: [2,3,4,5,1] output: 1
 	
 */
public class ArraySortedRotated_FindMin {

	public static void main(String[] args) {
		ArraySortedRotated_FindMin_Solution sol = new ArraySortedRotated_FindMin_Solution();
		sol.findMin(new int[] {10,1,10,10,10,10});
	}

}

class ArraySortedRotated_FindMin_Solution {
    public int findMin(int[] nums) {
        return bisearch(nums);
    }
    
    private int bisearch(int[] nums){
        int pv = findPivot(nums);
        return nums[pv];
    }
    
    private int findPivot(int[] nums){
        if(nums[0]<nums[nums.length-1]) return 0;
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int p = l + (r-l)/2;

            if(nums[p]==nums[r]){
                r--;
            } else if(nums[p]>nums[r]){
                l=p+1;
            } else {
                r=p;
            }
        }
        return l;
    }
}