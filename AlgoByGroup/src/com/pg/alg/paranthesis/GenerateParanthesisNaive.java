package com.pg.alg.paranthesis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GenerateParanthesisNaive {

	public static void main(String[] args) {
		StringBuilder strb;
		String s = "asdf";
		char[] sarr = s.toCharArray();
		Arrays.sort(sarr);
		System.out.println("sorted " + String.valueOf(sarr));
		 
		//genParanthRecur("", 0, 3);
		genParanthRecurMem("", 0, 3);
	}

	private static void genParanthRecurMem(String str, int i, int n) {
		Map<String, Boolean> memMp = new HashMap<>();
		genParanthRecurMemImp(str, i, n, memMp);
		
	}

	private static void genParanthRecurMemImp(String str, int i, int n, Map<String, Boolean> memMp) {
		if(i > 2*n) return;
		if(i == 2*n) {
			if(memMp.containsKey(str) && memMp.get(str)) {
				System.out.println(str);
			}else if(validParant(str)){
				System.out.println(str);
				memMp.put(str, true);
			}else {
				memMp.put(str, false);
			}
			return;
		}
		genParanthRecurMemImp(str+"(", i+1, n, memMp);
		genParanthRecurMemImp(str+")", i+1, n, memMp);
	}

	private static void genParanthRecur(String str, int i, int n) {
		if(i> 2 * n) return;
		if(i == 2*n) {
			if(validParant(str)) {
				System.out.println(str);
			}
			return;
		}
		genParanthRecur(str+"(", i+1, n);
		genParanthRecur(str+")", i+1, n);
		
	}

	private static boolean validParant(String str) {
		int cnt = 0;
		for(char ch : str.toCharArray()) {
			if(')' == ch) {
				cnt--;
			}else if('(' == ch) {
				cnt++;
			}
			if(cnt<0) return false;
		}
		
		return cnt==0;
	}


}
