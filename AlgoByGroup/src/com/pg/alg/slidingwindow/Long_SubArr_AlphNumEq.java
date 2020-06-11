package com.pg.alg.slidingwindow;

import java.util.Arrays;

public class Long_SubArr_AlphNumEq {

	public static void main(String[] args) {
		char[][] chArrs = new char[][]{ 
			{ 'a' },
			{ 'a', '1'},
			{ 'a', '1', '1' },
			{ 'a', '1', 'b', '1' ,'c'},
			{ 'a', 'a', 'b', '1', 'c', '1', '1', 'd','1','1'},
			{ 'a', 'a', 'b', '1', 'c', '1', '1', 'd','1','d','e','1'}
		};
		
		for(char[] chArr : chArrs) {
			longSubarrAlphNumEq(chArr);
			
		}

	}

	private static void longSubarrAlphNumEq(char[] chArr) {
		
		if(null == chArr || chArr.length < 2) return ;
		
		int len = chArr.length;
		
		int mxSubArrLen = 0;
		int mxSubArrI = -1;
		int mxSubArrJ = -1;
		for(int i=0; i<len; i++) {
			int aCnt = 0;
			int iCnt = 0;
			for(int j=i; j<len; j++) {
				if("0123456789".indexOf(chArr[j]) > -1) {
					iCnt++;
				}else {
					aCnt++;
				}
				
				if(iCnt == aCnt && aCnt > mxSubArrLen ) {
					mxSubArrLen = aCnt;
					mxSubArrI = i;
					mxSubArrJ = j;
				}
			}
		}
		if(mxSubArrI < 0 || mxSubArrJ < 0) return;
		System.out.format("InArr: %s, Longest subArr: %s \n", Arrays.toString(chArr), Arrays.toString(Arrays.copyOfRange(chArr, mxSubArrI, mxSubArrJ+1)));
	}

}
