package com.pg.alg.string.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermutationDups {

	public static void main(String[] args) {
		PermutationDups_Solution sol = new PermutationDups_Solution();
		List<List<Integer>> lolst = sol.permuteUnique(new int[] {1,1,2,2});
		lolst.forEach(lst -> { 
				lst.forEach(ech -> System.out.print(ech));
				System.out.println();
		});
	}

}
class PermutationDups_Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        return permuteVisit(nums);
        //return permuteSrtSwap(nums);
        //return recurPermuteUniq(nums);
        
    }
    
    private List<List<Integer>> permuteVisit(int[] nums){
        List<Integer> permuteLst = new ArrayList<>(nums.length);
        List<List<Integer>> resLst = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visit = new boolean[nums.length];
        permuteVisit( nums, visit, permuteLst, resLst);
        return resLst;
    }
    private void permuteVisit(int[] nums, boolean[] visit, List<Integer> permuteLst,List<List<Integer>> resLst){
        if(permuteLst.size() == nums.length){
            resLst.add( new ArrayList<Integer>(permuteLst)); 
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(visit[i] || (i>0 && nums[i]==nums[i-1] && !visit[i-1] )) continue;
            visit[i] = true;
            permuteLst.add(nums[i]);
            permuteVisit( nums, visit, permuteLst, resLst);
            permuteLst.remove(permuteLst.size()-1);
            visit[i] = false;
        }
    }
    
    private List<List<Integer>> permuteSrtSwap(int[] nums){
        Arrays.sort(nums);
        List<Integer> ilst = new ArrayList<>();
        for(int num : nums){
            ilst.add(num);
        }
        List<List<Integer>> lolst = new ArrayList<>();
        
        permuteSrtSwap(nums, 0, ilst, lolst);
            
        return lolst;
    }
    private void permuteSrtSwap(int[] nums, int idx, List<Integer> lst, List<List<Integer>> lolst){
        if(idx >= nums.length){
            lolst.add(new ArrayList<Integer>(lst)); return;}
        
        for(int i=idx; i<nums.length; i++){
            if( i>idx && lst.get(i) == lst.get(idx)) continue;
            Collections.swap(lst,idx, i);
                permuteSrtSwap(nums, idx+1, lst, lolst);
            Collections.swap(lst,idx, i); }
    }
    
    
    private List<List<Integer>> recurPermuteUniq(int[] nums) {
        if(nums == null){
            List<Integer> ilst = new ArrayList<>(0);
            List<List<Integer>> lolst = new ArrayList<>();    
            lolst.add(ilst);
            return lolst;
        }
        
        List<List<Integer>> lolst = new ArrayList<>();
        
        recurPermuteUniq(nums, lolst, 0);
        
        return lolst;
    }
    
    private void recurPermuteUniq(int[] nums, List<List<Integer>> lolst, int idx){
        if(idx >= nums.length){
            List<Integer> ilst = new ArrayList<>(nums.length);
            Arrays.stream(nums).forEach(ech -> ilst.add(ech));
            lolst.add(ilst);
            return;
        }
        
        for(int i=idx; i<nums.length; i++){
            
            //check sub set has dups
            if(! isDupsB4(nums, idx, i)){
                swap(nums, idx, i);
 
                recurPermuteUniq(nums, lolst, i+1);
                
                swap(nums, idx, i);
            }
        }
    }
    
    private boolean isDupsB4(int[] nums, int l, int r){
        for(int i=l; i<r; i++){
            if(nums[i]==nums[r]){return true;}
        }
        return false;
    }
    private void swap(int[] nums, int l, int r){
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
}