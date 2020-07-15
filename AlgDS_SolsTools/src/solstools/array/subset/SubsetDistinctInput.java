package solstools.array.subset;

import java.util.ArrayList;
import java.util.List;

public class SubsetDistinctInput {

	public static void main(String[] args) {
		SubsetDistinctInput_Solution sol = new SubsetDistinctInput_Solution();

		List<List<Integer>> lolst = sol.subsets(new int[] {1,2,3,4});
		lolst.forEach( lst -> {
			System.out.print("[");
			lst.forEach(ech -> System.out.print(ech+","));
			System.out.println("]");
		});
	}

}

class SubsetDistinctInput_Solution {

    public List<List<Integer>> subsets(int[] nums){
        return subsetBitmask(nums);
        //return subsetBacktrack(nums);
		//return subset2pN(nums);
		//return subsetRecurs(nums);
		//return subsetIters(nums);
	}
    private List<List<Integer>> subsetBitmask(int[] nums){
        List<List<Integer>> lolst = new ArrayList<>();
        
        int n = nums.length;
        int nbits = 1<<n;
        for(int b=0; b<nbits; b++){
            List<Integer> ilst = new ArrayList<>();
            int k = b;
            for(int i=0; i<n && k > 0; i++){
                if( ((k>>0) & 1) != 0){
                    ilst.add(nums[i]);
                }
                k = k>>1;
            }
            lolst.add(ilst);
        }
        return lolst;
    }
    
    private List<List<Integer>> subsetBacktrack(int[] nums){
        List<List<Integer>> lolst = new ArrayList<>();
        List<Integer> ilst = new ArrayList<>();
        for(int i=0; i<= nums.length; i++){
            subsetBacktrack(nums, i, 0, ilst, lolst);
        }
        return lolst;
    }
    private void subsetBacktrack(int[] nums, int len, int idx, List<Integer> ilst, List<List<Integer>> lolst){
        if(ilst.size() == len){
            lolst.add(ilst);
            return;
        }
        for(int i=idx; i<nums.length; i++){
            List<Integer> nlst = new ArrayList<>(ilst);
            nlst.add(nums[i]);
            subsetBacktrack(nums, len, i+1, nlst, lolst);
        }
    }
	
    private List<List<Integer>> subset2pN(int[] nums){
        List<List<Integer>> lolst = new ArrayList<>();
        List<Integer> ilst = new ArrayList<>();
        subset2pN(nums, 0, ilst, lolst);
        return lolst;
    }
    
    private void  subset2pN(int[] nums, int idx, List<Integer> ilst, List<List<Integer>> lolst){
        if(idx == nums.length){
            lolst.add(ilst); 
            return;
        }
        subset2pN(nums, idx+1, ilst, lolst);
        List<Integer> nlst = new ArrayList<>(ilst);
        nlst.add(nums[idx]);  
        subset2pN(nums, idx+1, nlst, lolst);
    }
    
    private List<List<Integer>> subsetRecurs(int[] nums){
		List<List<Integer>> lolst = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        subsetRecurs(nums, 0, lst, lolst);
		return lolst;
	}
    private void subsetRecurs(int[] nums, int idx, List<Integer> ilst, List<List<Integer>> lolst){
        lolst.add(ilst);
        for(int i=idx; i<nums.length; i++){
            List<Integer> nlst = new ArrayList<>(ilst);
            nlst.add(nums[i]);
            subsetRecurs(nums, i+1, nlst, lolst);
        }
    }
	
	private List<List<Integer>> subsetIters(int[] nums){
		List<List<Integer>> lolst = new ArrayList<>();
        
        List<Integer> ilst = new ArrayList<>();
        lolst.add(ilst);
        
        for(int i=0; i<nums.length; i++){
            int sz = lolst.size();
            for(int j=0; j<sz; j++){
                List<Integer> nlst = new ArrayList<>(lolst.get(j));
                nlst.add(nums[i]);
                lolst.add(nlst);
            }
        }
        
		return lolst;
	}
}