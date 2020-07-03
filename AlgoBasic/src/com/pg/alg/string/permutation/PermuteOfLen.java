package com.pg.alg.string.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteOfLen {
	

	
	public static void main(String[] args) { 
		PermuteOfLen this_ = new PermuteOfLen();
		this_.permuteN(5);
		this_.permute(5,2);

	}

	private void permuteN(int n) {

		List<Integer> ilst = new ArrayList<>(Arrays.asList(1,2,3,4));
		permuteN(n, 0, ilst);
		
	}

	private void permuteN(int n, int idx, List<Integer> ilst) { 
		ilst.forEach(ech -> System.out.print(ech+","));
		for(int i=idx; i< n; i++) {
			permuteN(n, 0, ilst);
		}
	}

	private void permute(int n, int k) {
		
	}

}
