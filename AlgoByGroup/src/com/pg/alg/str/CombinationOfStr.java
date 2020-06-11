package com.pg.alg.str;

public class CombinationOfStr {

	public static void main(String[] args) {
		String nStr = "abcd";
		int k = 3;
		StringBuilder strb = new StringBuilder();
		combinationRecur(nStr, strb, 0);
		System.err.println("-----------------");
		combinationRecur(nStr,  0);
	}

	private static void combinationRecur(String nStr, StringBuilder strb ,int idx) {
		if (idx >= nStr.length())
			return;
//		StringBuilder strb = new StringBuilder();

		while (idx < nStr.length()) {
			strb.append(nStr.charAt(idx));
			System.out.println(strb.toString());
			combinationRecur(nStr,strb, idx+1);
			idx++;
			strb.setLength(strb.length()-1);
		}

	}
	
	private static void combinationRecur(String nStr, int idx) {
		if (idx >= nStr.length())
			return;
		StringBuilder strb = new StringBuilder();

		while (idx < nStr.length()) {
			strb.append(nStr.charAt(idx));
			System.out.println(strb.toString());
			combinationRecur(nStr, idx+1);
			idx++;
			//strb.setLength(strb.length()-1);
		}

	}

}
