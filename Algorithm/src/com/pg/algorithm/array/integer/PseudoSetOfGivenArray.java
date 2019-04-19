package com.pg.algorithm.array.integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PseudoSetOfGivenArray {

	public static void main(String[] args) {
		
		PseudoSet pseudoSet = new PseudoSetOfGivenArray().new PseudoSet(new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12});
		
		System.out.println(Arrays.toString(pseudoSet.generate(4)));
		System.out.println(Arrays.toString(pseudoSet.generate(4)));
		System.out.println(Arrays.toString(pseudoSet.generate(4)));
		
	}

	private class PseudoSet {
		int [] intArr;
		public PseudoSet(int[] intArr) {
			this.intArr = intArr;
		}
		
		public Integer[] generate(int m) {
			List<Integer> iLst = new ArrayList<>();
			for(int i=0; i<m; i++) {
				Random rand = new Random();
				int icur = rand.nextInt(intArr.length-1);
				iLst.add(intArr[icur]);
			}
			return iLst.toArray(new Integer[0]);
		}
		
	}
}


