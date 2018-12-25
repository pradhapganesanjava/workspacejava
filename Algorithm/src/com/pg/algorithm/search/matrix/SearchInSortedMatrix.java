package com.pg.algorithm.search.matrix;

import java.util.Arrays;

public class SearchInSortedMatrix {

	public static void main(String[] args) {
		int[][] iarr1 = {
						 {1,2,3,4}
						};
		int[][] iarr11 = {
				 {1},
				 {2},
				 {3},
				 {4}
				};

		int[][] iarr2 = {
				 {1,2,3,4},
				 {5,7,8,9}
				};
		
		int[][] iarr3 = {
				 {1,2,3,4},
				 {5,7,8,9},
				 {10,17,18,19},
				 {25,27,28,29},
				};
		
		int[][] iarrB = { 
				{ 1, 2, 3, 4, 5 }, 
				{ 6, 7, 8, 9, 10 }, 
				{ 11, 12, 13, 14, 15 },
				{ 16, 17, 18, 20, 21 },
				{ 216, 217, 218, 220, 221 },
				{ 316, 317, 318, 320, 321 },
				{ 416, 417, 418, 420, 421 },
				{ 516, 517, 518, 520, 521 },
				{ 616, 617, 618, 620, 621 },
				{ 716, 717, 718, 720, 721 },
				{ 816, 817, 818, 820, 821 },
				{ 916, 917, 918, 920, 921 },
				{ 1116, 1117, 1118, 1120, 1121 },
				{ 2216, 2217, 2218, 2220, 2221 },
				{ 3316, 3317, 3318, 3320, 3321 },
				{ 4416, 4417, 4418, 4420, 4421 },
				{ 5516, 5517, 5518, 5520, 5521 },
				{ 6616, 6617, 6618, 6620, 6621 },
				{ 7716, 7717, 7718, 7720, 7721 },
				{ 8816, 8817, 8818, 8820, 8821 },
				{ 9916, 9917, 9918, 9920, 9921 }
				};
		
		greedyWayFind(iarr1,3);
		greedyWayFind(iarr11,3);
		greedyWayFind(iarr2,9);
		greedyWayFind(iarr3,29);
		greedyWayFind(iarrB, 9921);
	}

	public static String greedyWayFind(int[][] iarr, int x){
		String inParamLog = String.format(" find( %s , %d )", Arrays.deepToString(iarr),x);
		System.out.println(inParamLog);
		if(iarr == null || iarr.length==0) return null;
		int i = 0;
		int j = 0; 
		int imx = iarr.length - 1;
		int jmx = iarr[0].length -1;
		int n=0;
		int m=0;
		
		if( x < iarr[0][0] || x > iarr[imx][jmx] ) return null;
		
		for(;  i >=0 && i <= imx && x > iarr[i][j] && (i+1 <= imx && x >= iarr[i+1][j]); i++){
			n+=1;
		}
		for(;  j >=0 && j <= jmx && x > iarr[i][j] && (j+1 <= jmx && x >= iarr[i][j+1]); j++){
			m+=1;
		}
		if(x > iarr[i][j]){ j += 1;}
		System.err.println(inParamLog + ": time consumption "+ (n+m));
		String ijStr = String.format("[%d,%d]", i, j);
		System.out.println(inParamLog + ":  co-ordinate : " + ijStr);
		return x == iarr[i][j] ? ijStr: null;
		
	}
}
