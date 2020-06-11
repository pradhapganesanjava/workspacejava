package com.pg.alg.string.permcomb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SubsetPermutCombinationAllin1 {

	public static void main(String[] args) {
		
		int[] nums = new int[] {1,2,3};
		String numStr = "123";
		
//		SubSet_dup(nums);
//		SubSet_NoDup(nums);
//		Permutation_dup(numStr);
		Permutation_Ordered("1234567");
//		Permutation_NoDup(nums);
//		Combination_Dup(nums);
		
	}

	private static void Combination_Dup(int[] nums) {
		// TODO Auto-generated method stub
		
	}

	private static void Permutation_NoDup(int[] nums) {
		// TODO Auto-generated method stub
		
	}

	private static void Permutation_dup(String numStr) {
		permutDups(numStr);
	}
	private static void Permutation_Ordered(String str) {
		StringBuilder strb = new StringBuilder();
		permutOrderedRecur(str,0, 3, strb);
	}	

	private static void SubSet_NoDup(int[] nums) {
		// TODO Auto-generated method stub
		
	}

	private static void SubSet_dup(int[] nums) {
		List<List<Integer>> lolst = new ArrayList<>();
		List<Integer> lst = new ArrayList<>();
		
		SubSet_dup_Impl(nums, 0, lst, lolst);
		print(nums, lolst, "Example: Sub Set Allow Duplicate");
	}

	/*
	 * > No Length Check
	 * > No 0 indexed; 
	 * > Index pass in param
	 * > 
	 */
	private static void SubSet_dup_Impl(int[] nums, int idx, List<Integer> lst, List<List<Integer>> lolst) {
		lolst.add(new ArrayList<>(lst));
		
		for(int i = idx; i<nums.length; i++) {
			lst.add(nums[i]);
			SubSet_dup_Impl(nums, i+1, lst, lolst);
			lst.remove(lst.size()-1);
		}
		
	}
	private static void permutDups(String str) {
		StringBuilder strb = new StringBuilder();
		int[] visit = new int[str.length()];
		permutDupsRecur(str, strb, visit);
	}

	private static void permutDupsRecur(String str, StringBuilder strb, int[] visit) {
		
		if(strb.length() == str.length()) {
			System.out.println(strb.toString());
			return;
		}
		
		for(int i=0; i<str.length(); i++) {
			if(visit[i]==1) continue;
			strb.append(str.charAt(i));
			visit[i] = 1;
			
			permutDupsRecur(str, strb, visit);
			
			visit[i] = 0;
			strb.setLength(strb.length()-1);
		}
	}
	
	private static void permutOrderedRecur(String str, int idx, int mxlen, StringBuilder strb) {
		
		if(strb.length() == mxlen) {
			System.out.println(strb.toString());
			return;
		}
		
		for(int i=idx; i<str.length(); i++) {
			strb.append(str.charAt(i));
			permutOrderedRecur(str, i+1, mxlen, strb);
			strb.setLength(strb.length()-1);
		}
	}
	
	private static void print(int[] nums, List<List<Integer>> lolst, String title) {
		final int st = 0;
		final int ed = 40;
		printLine(st, ed);
		System.out.format("---- %s ----\n", title);
		printLine(st, ed);
		System.out.format("INPUT:\n %s \n", Arrays.toString(nums));
		System.out.println("OUTPUT:");
		for(List<Integer> lst : lolst) {
			lst.forEach(ech -> System.out.print(ech+","));
			System.out.println();
		}	
		IntStream.range(st, ed).forEach( ech -> System.out.print("--"));
	}

	private static void printLine(final int st, final int ed) {
		IntStream.range(st, ed).forEach(ech -> {
			if (ech == ed-1) {
				System.out.println();
			} else {
				System.out.print("--");
			}
		});
	}

}


/*

This structure might apply to many other backtracking questions, but here I am just going to demonstrate Subsets, Permutations, and Combination Sum.

Subsets : https://leetcode.com/problems/subsets/

public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
}
Subsets II (contains duplicates) : https://leetcode.com/problems/subsets-ii/

public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
} 
Permutations : https://leetcode.com/problems/permutations/

public List<List<Integer>> permute(int[] nums) {
   List<List<Integer>> list = new ArrayList<>();
   // Arrays.sort(nums); // not necessary
   backtrack(list, new ArrayList<>(), nums);
   return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
   if(tempList.size() == nums.length){
      list.add(new ArrayList<>(tempList));
   } else{
      for(int i = 0; i < nums.length; i++){ 
         if(tempList.contains(nums[i])) continue; // element already exists, skip
         tempList.add(nums[i]);
         backtrack(list, tempList, nums);
         tempList.remove(tempList.size() - 1);
      }
   }
} 
Permutations II (contains duplicates) : https://leetcode.com/problems/permutations-ii/

public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
    if(tempList.size() == nums.length){
        list.add(new ArrayList<>(tempList));
    } else{
        for(int i = 0; i < nums.length; i++){
            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
            used[i] = true; 
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, used);
            used[i] = false; 
            tempList.remove(tempList.size() - 1);
        }
    }
}
Combination Sum : https://leetcode.com/problems/combination-sum/

public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, target, 0);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
    if(remain < 0) return;
    else if(remain == 0) list.add(new ArrayList<>(tempList));
    else{ 
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
            tempList.remove(tempList.size() - 1);
        }
    }
}
Combination Sum II (can't reuse same element) : https://leetcode.com/problems/combination-sum-ii/

public List<List<Integer>> combinationSum2(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, target, 0);
    return list;
    
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
    if(remain < 0) return;
    else if(remain == 0) list.add(new ArrayList<>(tempList));
    else{
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, remain - nums[i], i + 1);
            tempList.remove(tempList.size() - 1); 
        }
    }
} 
Palindrome Partitioning : https://leetcode.com/problems/palindrome-partitioning/

public List<List<String>> partition(String s) {
   List<List<String>> list = new ArrayList<>();
   backtrack(list, new ArrayList<>(), s, 0);
   return list;
}

public void backtrack(List<List<String>> list, List<String> tempList, String s, int start){
   if(start == s.length())
      list.add(new ArrayList<>(tempList));
   else{
      for(int i = start; i < s.length(); i++){
         if(isPalindrome(s, start, i)){
            tempList.add(s.substring(start, i + 1));
            backtrack(list, tempList, s, i + 1);
            tempList.remove(tempList.size() - 1);
         }
      }
   }
}

public boolean isPalindrome(String s, int low, int high){
   while(low < high)
      if(s.charAt(low++) != s.charAt(high--)) return false;
   return true;
} 

//Swap way
public void backtrack(int n,
                        ArrayList<Integer> nums,
                        List<List<Integer>> output,
                        int first) {
    // if all integers are used up
    if (first == n)
      output.add(new ArrayList<Integer>(nums));
    for (int i = first; i < n; i++) {
      // place i-th integer first 
      // in the current permutation
      Collections.swap(nums, first, i);
      // use next integers to complete the permutations
      backtrack(n, nums, output, first + 1);
      // backtrack
      Collections.swap(nums, first, i);
    }

*/