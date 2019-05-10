package com.pg.algorithm.array.string;

public class PermutationWithDups {
	static int run = 0;
	static int resCnt = 0;
	public static void main(String[] args) {
		String str = "aaa"; //"aabbccc";
		permutDups(str);
		System.out.format("N=%d is number of chars in given string, # times loop executed %d , resCnt=%d \n",str.length(), run,  resCnt);
	}

	private static void permutDups(String str) {
		StringBuilder strb = new StringBuilder();
		int[] visit = new int[str.length()];
		permutDupsRecur(str, strb, visit);
	}

	private static void permutDupsRecur(String str, StringBuilder strb, int[] visit) {
		
		if(strb.length() == str.length()) {
			System.out.println(strb.toString());
			 resCnt++;
			return;
		}
		
		for(int i=0; i<str.length(); i++) {
			run++;
			if(visit[i]==1) continue;
			strb.append(str.charAt(i));
			visit[i] = 1;
			
			permutDupsRecur(str, strb, visit);
			
			visit[i] = 0;
			strb.setLength(strb.length()-1);
		}
	}

}
