package com.pg.algorithm.array;

public class LongCommonSubseq {

	public static void main(String[] args) {

		String lcsStr1 = "cat";
		String lcsStr2 = "cut";
		char[] lcsStr2Chars = lcsStr2.toCharArray();

		int lcsIndex = -1;
		int globalCount = 0;
		int low = 0;
		int lcsStr2Len = lcsStr2.length();
		int lcsStr1Len = lcsStr1.length();

		while (low + lcsStr2Len <= lcsStr1Len) {
			int localCount = 0;
			try{
			char[] str1Chars = lcsStr1.substring(low, low + lcsStr2Len).toCharArray();

			for (int i = 0; i < lcsStr2Len; i++) {
				if (str1Chars[i] == lcsStr2Chars[i]) {
					localCount++;
				}
			}
			}catch(Exception e){
				System.out.println(" exception "+low+ " "+lcsStr2Len);
			}

			if (localCount > globalCount) {
				globalCount = localCount;
				lcsIndex = low;
			}
			low++;
		}
		System.out.println("lcsIndex "+lcsIndex);
		System.out.println("LCS result : "+lcsStr1.substring(lcsIndex));
	}
}
