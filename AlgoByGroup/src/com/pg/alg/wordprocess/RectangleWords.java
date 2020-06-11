package com.pg.alg.wordprocess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RectangleWords {

	public static void main(String[] args) {

		String[] wrds = new String[] {
				
		};
		Arrays.sort(wrds, RectangleWords::sortByLen);
		
		List<List<List<String>>> wrdPrepros = new ArrayList<>();
		String[][][] wrdPrepArr = new String[26][110][];
		
		
		for(String wrd : wrds) {
			for(char ch : wrd.toCharArray()) {
				int ich = (int) ch;
				if(null == wrdPrepArr[ich][wrd.length()]) {
					int len = wrdPrepArr[ich][wrd.length()].length;
					wrdPrepArr[ich][wrd.length()][len] = wrd;
				}
			}
		}
		List<String> resRectWrd = new ArrayList<>();
		for(String wrd : wrds) {
			int n = wrd.length();
			for(char ch : wrd.toCharArray()) {
				int mch = findMaxLen(ch, wrdPrepArr, 100);
				String[] wrdByLenArr = listWordByLen(ch, wrdPrepArr, 100);
				if(null == wrdByLenArr) {
					break;
				}
				for(String wrdByLen : wrdByLenArr) {
					resRectWrd.add(wrdByLen);
				}
				
			}
		}
		
	}
	
	private static int findMaxLen(char ch, String[][][] wrdPrepArr, int maxLen) {
		String[][] wrdArr = wrdPrepArr[ch+0];
		for(int i = maxLen; i>=0; i--) {
			if(wrdArr[i] != null) {
				return i;
			}
		}
		return 0;
	}
	
	private static String[] listWordByLen(char ch, String[][][] wrdPrepArr, int maxLen) {
		String[][] wrdArr = wrdPrepArr[ch+0];
		for(int i = maxLen; i>=0; i--) {
			if(wrdArr[i] != null) {
				return wrdArr[i];
			}
		}
		return null;
	}

	private static int sortByLen(String w1, String w2) {
		return w1.length() - w2.length() > 0 ? -1 : w1.length() - w2.length() == 0 ? 0 : 1;
	}

}
