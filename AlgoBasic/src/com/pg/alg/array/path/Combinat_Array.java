package com.pg.alg.array.path;

public class Combinat_Array {

	public static void main(String[] args) {
		int[] iarr = new int[] {1,2,3,4};
		recur_genCombinat(iarr);
	}

	private static void recur_genCombinat(int[] iarr) {
		StringBuilder strb = new StringBuilder();
		recur_genCombinat(iarr, strb, 0);		
	}

	private static void recur_genCombinat(int[] iarr, StringBuilder strb, int idx) {
		
		for(int i=idx; i<iarr.length; i++) {
			strb.append(String.valueOf(iarr[i]));
			System.out.println(strb.toString());
			recur_genCombinat(iarr, strb, i+1);
			strb.setLength(strb.length()-1);
		}
		
	}

}
