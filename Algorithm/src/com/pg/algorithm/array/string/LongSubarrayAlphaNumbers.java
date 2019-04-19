package com.pg.algorithm.array.string;

public class LongSubarrayAlphaNumbers {

	public static void main(String[] args) {

		String[] strArr = new String[] {"a","b","1","c","2","d","e","f","1","2"};
		
		int i = 0;
		int n = strArr.length;
		while(i<n) {
			int fstLen = findMatch(i,strArr);
			int sndLen = findMatch(i+fstLen-1,strArr);
		}
		
	}

	private static int findMatch(int i, String[] strArr) {
		int alen = 0;
		int ilen = 0;
		boolean alpha = "abcdefghijklmnopqrstuvwxyz".contains(strArr[i]);
		for(int j = i; j < strArr.length; j++) {
			if(alpha && "abcdefghijklmnopqrstuvwxyz".contains(strArr[j])){
				if(ilen != 0) {
					return alen;
				}
				alen++;
			}else {
				if(alen != 0) {
					return ilen;
				}
				ilen++;
			}
		}
		return 0;
	}

}
