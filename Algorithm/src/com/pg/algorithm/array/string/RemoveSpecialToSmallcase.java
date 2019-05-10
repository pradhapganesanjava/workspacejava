package com.pg.algorithm.array.string;

public class RemoveSpecialToSmallcase {

	public static void main(String[] args) {

		String s1 = "Taco Bell Is isn't my favorite";
		
		System.out.format("From: %s \n To: %s \n",s1, toOnlySmallcase(s1));
		
	}

	public static String toOnlySmallcase(String s1) {
		int h = 0;
		int t = 0;
		int alpCnt = 0;
		char[] chrArr = s1.toCharArray();
		while(t<chrArr.length) {
			if(isAlphaToSmall(chrArr,t)) {
				if(h<t) {
					swap(chrArr, h, t);
				}
				h++;
				t++;
				alpCnt++;
			}else {
				t++;
			}
		}
		
		return String.valueOf(chrArr, 0, alpCnt);
	}

	private static void swap(char[] chrArr, int h, int t) {
		char c1 = chrArr[h];
		chrArr[h] = chrArr[t];
		chrArr[t] = c1;
		
	}

	private static boolean isAlphaToSmall(char[] chrArr, int t) {
		int ichr = chrArr[t];
		if( ((ichr-'a') >=0 && (ichr-'a')<26) ) {
			return true;
		}else if((ichr-'A') >=0 && (ichr-'A')<26) {
			chrArr[t] = (char)((ichr-'A')+'a');
			return true;
		}
		return false;
	}

}
