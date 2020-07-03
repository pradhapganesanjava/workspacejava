package algds.array.sorted.search;

/***
 * 
 * 
275. H-Index II 
<a href="
Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, 
write a function to compute the researcher's h-index.

Example:

Input: citations = [0,1,3,5,6]
Output: 3 
Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had 
             received 0, 1, 3, 5, 6 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each and the remaining 
             two with no more than 3 citations each, her h-index is 3.

 *
 */
public class FindIndex_HindexCondition_SortedArray {

	public static void main(String[] args) {


	}

}

class FindIndex_HindexCondition_SortedArray_Sols {
    public int hIndex(int[] citations) {
        return splitBiSrch(citations);
    }
    
    private int splitBiSrch(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        int l = 0;
        int r = nums.length;
        while(l<r){
            int m = l + (r-l)/2;
            int rcnt = nums.length-m;
            /*if(nums[m] == rcnt){
                return nums[m];
            }else */
            if(nums[m] >= rcnt){
                r = m;
            }else{
                l = m + 1;
            }
        }
        return l>=0 && l<nums.length && nums[l] == nums.length-l ? nums[l] : l>=0 && l<nums.length && nums[l]> nums.length-l ? nums.length-l : 0;
    }
}

