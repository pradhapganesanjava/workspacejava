package com.pg.algorithm.array.string;

public class LongComSubsequence_Dynprog_ {

	public static void main(String[] args) {

		String s1 = "";
		String s2 = "";
		
		/*
		 s1 = "axbyc";
		 s2 = "mabnc";
		
		System.out.format("s1: %s, s2: %s  LCS: %d \n", s1, s2, longCommSubseq(s1, s2));
		
		s1 = "axbycmnop";
		s2 = "mabncxoypzz";
		
		System.out.format("s1: %s, s2: %s  LCS: %d \n", s1, s2, longCommSubseq(s1, s2));
		
		*/
		s1 = "ACBEA";
		s2 = "ADCA";
		
		System.out.format("s1: %s, s2: %s  LCS: %d \n", s1, s2, longCommSubseq(s1, s2));
	}
	
	private static int longCommSubseq(String s1, String s2) {
		
		if(s1 == null || s2 == null || "" == s1 || "" == s2) return 0;
		
		int n1 = s1.length();
		int n2 = s2.length();
		
		int[][] lcs = new int[n1+1][n2+1];
		int r = 1;
		int c = 1;
		int mx = Integer.MIN_VALUE;
		for(int i=0; i<n1; i++) {
			r = i+1;
			for(int j=0; j<n2; j++) {
				c = j+1;

				lcs[r][c] = Math.max(Math.max(lcs[r-1][c-1],lcs[r][c-1]),lcs[r-1][c]);
				
				if(s1.charAt(i) == s2.charAt(j)) {
					lcs[r][c] = lcs[r][c]+1;
					if(mx<lcs[r][c]) {
						mx = lcs[r][c];
					}
				}
				
				
			}
		}
		
		for(int i=0; i<lcs.length; i++) {
			for(int j=0; j<lcs[i].length; j++) {
				System.out.format("%d ", lcs[i][j]);
			}
			System.out.println();;
		}
		StringBuilder strb = new StringBuilder();
		
		int m = s1.length()-1;
		int n = s2.length()-1;
		
		int li = m+1;
		int lj = n+1;
		while(li>=0 && lj>=0) {
			
			int left = lj-1>=0 ? lcs[li][lj-1] : -1;
			int up = li-1<0? -1 :lcs[li-1][lj];
			int dig = (li-1<0 && lj-1<0)? 0 :lcs[li-1][lj-1];
			
			if( dig >= up && dig >= left)  {
				System.out.println(lj + " : " +s2.charAt(lj-1));
				strb.append(s2.charAt(lj-1));
				li = li-1;
				lj = lj-1;

			}else if( (up > left) || (up > dig)){
				li = li-1 ;
				
			}else if( (left > dig) || (left > up)){
				lj = n-1;
			}
			
		}
		System.out.println(strb.toString());
		return mx;
		
	}

}
