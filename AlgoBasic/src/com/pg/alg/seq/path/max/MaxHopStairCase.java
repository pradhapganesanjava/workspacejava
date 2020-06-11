package com.pg.alg.seq.path.max;

public class MaxHopStairCase {

	public static void main(String[] args) {
		MaxHopStairCase_Solution sol = new MaxHopStairCase_Solution();
		int mxPos = sol.climbStairs(10);
		System.out.println(mxPos);
	}

}

class MaxHopStairCase_Solution {

    public int climbStairs(int n) {
        
        return tryAgain110219(n);
        
       // return climbStrirsRecur(0, n);
       // return climbStairIter(n);
    }
    
    private int tryAgain110219(int n){
        int mx = 0;
        int[] mem = new int[n+1];
        int[] step = new int[]{1,2,3};
        StringBuilder strb = new StringBuilder();
        tryAgain110219_Recur(n, step, step.length-1, mem,strb);
        return mem[n];
    }
    
    private int tryAgain110219_Recur(int n, int[] steps, int si, int[] mem, StringBuilder strb){
        if(n == 0) {
  		  System.err.println(strb.toString()+",");
        	  return 1;
        }
        if(n<0) return 0;
        if(mem[n] !=0) return mem[n];
        int cnt = 0;
        for(int i=si; i>=0; --i){
            /*int div = n/steps[i];
            int tcnt = 0;
            if( div > 0){
            	cnt += tryAgain110219_Recur(n-(div*steps[i]), steps, i-1, mem);
            }*/
            //cnt = Math.max(cnt, tcnt);
        		
        		if(n-steps[i]>=0) {
        		  strb.append(String.valueOf(steps[i]));
        		  cnt += tryAgain110219_Recur(n-steps[i], steps, steps.length-1, mem, strb);
       		  System.out.println(strb.toString()+",");
        		  strb.setLength(strb.length()-1);
        		}
        }
        mem[n] = cnt;
        return cnt;
    }
    
}