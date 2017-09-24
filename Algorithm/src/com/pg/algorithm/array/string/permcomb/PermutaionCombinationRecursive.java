package com.pg.algorithm.array.string.permcomb;

import java.util.List;

public class PermutaionCombinationRecursive extends PermutationCombinationAbstract{

	private String string;
	List<String> orderedComb;
	List<String> unOrderedComb;
	List<String> permut;
	
	public PermutaionCombinationRecursive(String string) {
		this.string = string;
	}
	
	@Override
	public List<String> orderedCombination() {
		
		
		return orderedComb;
	}

	@Override
	public List<String> unOrderedCombination() {
		return unOrderedComb;
	}

	@Override
	public List<String> permutation() {
		return permut;
	}

	private void orderedComb(int start){
		for(int i=start; i<string.length();i++){
			
		}
	}
}
