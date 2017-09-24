package com.pg.algorithm.integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountPerfectSqrs {

	public static void main(String[] args) {
		System.out.println(""+new Solution().numSquares(12));
		
	}

}

class Solution {
    public int numSquares(int n) {
        return findNum(n,n, new ArrayList<Integer>(), Integer.MAX_VALUE);
    }
    
    private int findNum(int on, int tn, List<Integer> aL, int le){
        if(tn==0){
            if(aL.size()>0 && sumup(aL)==on){
            	if(le>aL.size()){
                	System.out.println(" "+Arrays.toString(aL.toArray()));
                }
                le = Math.min(aL.size(),le);
                aL.clear();
                //aL.remove(aL.size()-1);
                return le;
            }
        }
//        int cN = (int)Math.ceil((n+0.0)/2);
        int cN = (int)Math.ceil(Math.sqrt(tn));
        for(int i = cN; i>=1; i--){
            int mul = i * i;
            int ln = tn-mul;
            if(mul <= tn && ln >=0){
                aL.add(mul);
                le = findNum(on,ln,aL,le);
            }
        }
        return le;
    }
    private int sumup(List<Integer> inList){
    	int sum =0;
    	for(int i : inList){
    		sum += i;
    	}
    	return sum;
    }
}
