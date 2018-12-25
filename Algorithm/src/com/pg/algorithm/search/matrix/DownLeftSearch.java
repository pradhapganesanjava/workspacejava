package com.pg.algorithm.search.matrix;

//O(n) time complexity best approach to search in Matrix
public class DownLeftSearch {

	public static void main(String[] args) {

		int[][] intArrTD = { 
							{ 1, 2, 3, 4, 5 }, 
							{ 6, 7, 8, 9, 10 }, 
							{ 11, 12, 13, 14, 15 },
							{ 16, 17, 18, 20, 21 } };
		
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
		stairSearch(intArrTD, 21);
		stairSearch(iarrB, 9921);

	}

	public static String stairSearch(int[][] intArrTD, int findInt) {
		int rowLen = intArrTD.length;
		int colLen = intArrTD[0].length;

		int i = 0;
		int j = colLen - 1;
		boolean search_done = false;

		int n = 0;
		
		while (!search_done) {
			if (findInt <= intArrTD[i][j]) {
				if (j - 1 > -1) {
					j--;
				} else {
					search_done = true;
				}
			} else {
				if (i + 1 < rowLen) {
					i++;
				} else {
					search_done = true;
				}
			}
			n+=1;
		}
		System.out.println(" Searching int " + findInt + " at index [" + i + "][" + j + "].");
		System.err.println("time consumption " + n);
		return String.format("[%d,%d]", i, j);
	}

}
