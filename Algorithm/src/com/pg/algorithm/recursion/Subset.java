package com.pg.algorithm.recursion;

public class Subset {

	public static void main(String[] args) {
		int[] iset = new int[] {1,2,3};
		
		printSubsetRecur(iset,0, new StringBuilder());
	}

	private static void printSubsetRecur(int[] iset, int idx, StringBuilder strb) {
		for(int i=idx; i<iset.length; i++) {
			strb.append(iset[i]);
			System.out.println(strb.toString());
			printSubsetRecur(iset, i+1, strb);
			strb.setLength(strb.length()-1);
			
				
		}
	}

}
