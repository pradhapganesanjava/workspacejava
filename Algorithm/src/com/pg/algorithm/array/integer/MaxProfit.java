package com.pg.algorithm.array.integer;

public class MaxProfit {

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 2, 1, 4, 5, 2, 9, 7 }));
	}

	public static int maxProfit(int[] prices) {

		int mxi = 0;
		int mx = 0;

		int i = 0;

		for (int r = 1; r < prices.length; i++, r++) {

			if (prices[r] > prices[i]) {
				int d = prices[r] - prices[i];

				if (d > mx) {
					mx = d;
				}
				if (prices[r] > prices[mxi]) {
					d = prices[r] - prices[mxi];
					if (d > mx) {
						mx = d;
						continue;
					}
				}
				mxi = i;
				

			}
		}
		return mx;
	}
}
