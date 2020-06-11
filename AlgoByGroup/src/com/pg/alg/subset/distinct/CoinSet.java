package com.pg.alg.subset.distinct;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CoinSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution {
    public int change(int amount, int[] coins) {
        return subsetRecur(amount, coins);
        //return subsetRecur2(amount, coins);
    }
    private int subsetRecur2(int amt, int[] coins){
        List<Integer> coinLst = IntStream.of(coins)
                                         .boxed()
                                         .sorted( (i1, i2) -> {
                                            return i2-i1;
                                          })
                                         .collect( Collectors.toList());        
        return subsetRecur2(amt, coinLst, 0);
    }
    private int subsetRecur2(int amt, List<Integer> coinLst, int idx){
        if(amt == 0) return 1;
        if(idx >= coinLst.size() || amt < 0) return 0;
        int cnt = 0;
        for(int i=0; i< coinLst.size(); i++){
            if(amt < coinLst.get(i)){
                continue;
            }
            int namt = amt - coinLst.get(i);
            cnt += subsetRecur2(namt, coinLst, idx+1);
        }
        return cnt;
    }
    
    private int subsetRecur(int amt, int[] coins){
        List<Integer> coinLst = IntStream.of(coins)
                                         .boxed()
                                         .sorted( (i1, i2) -> {
                                            return i2-i1;
                                          })
                                         .collect( Collectors.toList());

        return subsetRecur(amt, coinLst, 0);
    }
    
    private int subsetRecur(int amt, List<Integer> coinLst, int idx){
        if(amt == 0){
            return 1;
        }
        if(amt < 0 || idx >= coinLst.size()){
            return 0;
        }

        int cnt = 0;
        for(int i=idx; i<coinLst.size(); i++){
        		if(amt < coinLst.get(i)){
                continue; }
	        for(int j=amt/coinLst.get(i); j>0; j--){
	            if(amt < coinLst.get(i)){
	                continue;
	            }
	            System.out.println("amt " + amt + " i: "+i+" i: "+idx+" coinLst.get(i): " + coinLst.get(i));
	            amt -= coinLst.get(idx)*j;
	
	            cnt +=subsetRecur(amt, coinLst, idx+1);
	            amt += coinLst.get(idx)*j;
	        }
        }
        return cnt;
    }
    
    private int subsetRecur0(int amt, int[] coins){
        List<Integer> coinLst = IntStream.of(coins)
                                         .boxed()
                                         .sorted( (i1, i2) -> {
                                            return i2-i1;
                                          })
                                         .collect( Collectors.toList());
        int cnt = 0;
        for(int i=0; i<coinLst.size(); i++){
            cnt += subsetRecur(amt, coinLst, i); 
        }
        return cnt;
        
        //return subsetRecur(amt, coinLst, 0); 
    }
    
    private int subsetRecur0(int amt, List<Integer> coinLst, int idx){
        if(amt == 0){
            return 1;
        }
        if(amt < 0 || idx >= coinLst.size()){
            return 0;
        }

        int cnt = 0;
        //for(int i=idx ; i<coinLst.size(); i++){
        for(int i=amt/coinLst.get(idx); i>0; i--){
            if(amt < coinLst.get(idx)){
                continue;
            }
            System.out.println("amt " + amt + " i: "+i+" idx: "+idx+" coinLst.get(idx): " + coinLst.get(idx));
            int mul = amt/coinLst.get(idx);
            amt -= coinLst.get(idx)*i;

            cnt +=subsetRecur(amt, coinLst, idx+1);
            amt += coinLst.get(idx)*i;
        }
        return cnt;
    }
}