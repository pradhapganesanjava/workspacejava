package com.pg.algorithm.array.string.permcomb;

public class PermutationCombinationMain {

	public static void main(String[] args) {

		PermutationCombinationAbstract pcRecurs = new PermutaionCombinationRecursive("abc");
		
		pcRecurs.orderedCombination().forEach(each -> System.out.println(each));
		pcRecurs.unOrderedCombination().forEach(each -> System.out.println(each));
		pcRecurs.permutation().forEach(each -> System.out.println(each));
		
	}

}
