package com.pg.alg.coinchange;

public class MinCoinChange {

	public static void main(String[] args) {
		MinCoinChangeSolution sol = new MinCoinChangeSolution();
		int cnt = sol.coinChange(new int[] {2,5}, 11);
	}

}


class MinCoinChangeSolution {
    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, 0);
    }
    
    private int coinChange(int[] coins, int amt, int ic){
        if(ic >= coins.length) return -1;
        if(amt < 0) return -1;
        if (amt ==0) return 0;
        
        int mxCnt = amt / coins[ic] ;
        int minCnt = Integer.MIN_VALUE;
        for(int i=0; i<= mxCnt; i++){
            if(amt >= amt - (i*coins[ic])){
                int res = coinChange(coins, amt - (i*coins[ic]), ic+1);
                if(res != -1){
                    Math.min(minCnt, res+i);
                }
            }
            
        }
        return minCnt == Integer.MIN_VALUE ? -1: minCnt;
    }
}