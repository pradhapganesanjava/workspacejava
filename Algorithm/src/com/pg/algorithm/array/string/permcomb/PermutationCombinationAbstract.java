package com.pg.algorithm.array.string.permcomb;

import java.util.List;

public abstract class PermutationCombinationAbstract {

	/**
	 * Permutation of a string is . where n is number characters.
	 * Ex: word : "abc"
	 * List<String> : a,ab,abc,ac,b,bc,c
	 * n is 3;
	 * 
	 * 
	 * @param word
	 * @return
	 */
	public abstract List<String> orderedCombination();
	/**
	 * unOrderedCombination of a string is n! + n(n-1). where n is number characters.
	 * Ex: word : "abc"
	 * List<String> : a,ab,abc,ac,acb, b,ba,bac,bc,bca, c,ca,cab,cb,cba
	 * n is 3;
	 * n! + n (n+1) = 6 + 12;
	 * 
	 * @param word
	 * @return
	 */
	public abstract List<String> unOrderedCombination();
	
	/**
	 * Permutation of a string is n!. where n is number characters.
	 * Ex: word : "abc"
	 * List<String> : abc, acb, bac, bca, cab, cba
	 * n is 3;
	 * n! 3x2x1 = 6;
	 * 
	 * @param word
	 * @return
	 */
	public abstract List<String> permutation();
}
