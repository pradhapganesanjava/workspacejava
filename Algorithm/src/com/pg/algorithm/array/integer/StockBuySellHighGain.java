package com.pg.algorithm.array.integer;

/**
	Input : arr = { 2, 3, 10, 6, 4, 8, 1 }
	Output : 8
	Explanation : The maximum difference is between 10 and 2.
	
	Input : arr = { 7, 9, 5, 6, 3, 2 }
	Output : 2
	Explanation : The maximum difference is between 9 and 7.
	O(N) best solution. where N is number of element in the array
*/

public class StockBuySellHighGain {

	static int[] lastStock = new int[]{10,5,6,7,16,8,15};
	
	
	public static void main(String...str){
		
		System.out.println();
		
		System.out.println("[10] : " + findBestDiffStock(new int[]{10}));		
		System.out.println("[10,11] : " + findBestDiffStock(new int[]{10,11}));
		System.out.println("[10,9] : " + findBestDiffStock(new int[]{10,9}));
		System.out.println("[10,5,6,7,16,8,15] : " + findBestDiffStock(new int[]{10,5,6,7,16,8,15}));
		System.out.println("[1, 2, 3, 4, 5, 6, 7] : " + findBestDiffStock(new int[]{1, 2, 3, 4, 5, 6, 7}));
		System.out.println("[91, 82, 73, 64, 55, 46, 37] : " + findBestDiffStock(new int[]{91, 82, 73, 64, 55, 46, 37}));
		System.out.println("[2, 3, 10, 6, 4, 8, 1] : " + findBestDiffStock(new int[]{ 2, 3, 10, 6, 4, 8, 1}));
		System.out.println("[7, 9, 5, 6, 3, 2] : " + findBestDiffStock(new int[]{7, 9, 5, 6, 3, 2}));
	}


	private static int findBestDiffStock(int[] stk) {
		if (stk == null || stk.length == 0)
			return 0;
		if (stk.length < 2)
			return stk[0];

		int l = 0;
		int r = 1;

		int mx = -1;
		int mp = 0;

		while (r < stk.length) {

			if (stk[l] < stk[r]) {
				if (mx == -1) {
					mx = l;
					mp = Math.abs(stk[l]-stk[r]);
				} else {

					int min = Math.min(stk[mx], stk[l]);
					if (min != stk[mx]) {
						mx = l;
					}
					mp = Math.max(mp, Math.abs(stk[mx]-stk[r]));
				}
			}
			l++;
			r++;
		}
		return mp;
	}
	
}
