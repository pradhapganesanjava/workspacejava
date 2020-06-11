package com.pg.alg.math;

public class ReverseInteger {

	public static void main(String[] args) {
		int in = Integer.MAX_VALUE;
		System.err.println("mx INT " + in);
		in = 1534236469;
		/*String istr = String.valueOf(in);
		StringBuilder strb = new StringBuilder(istr);
		String ristr = strb.reverse().toString();
		Integer rin = Integer.parseInt(ristr);
		System.out.format("FROM: %s  TO %s , IN: %d \n", istr, ristr, rin);*/
		
		ReverseInteger.Solution sol = new ReverseInteger().new Solution();
		// System.out.format("REV-IMPL IN: %s  EXPECT: %s , OUT: %d \n", istr, ristr, sol.reverse(in));
		System.out.format("REV-IMPL IN: %s  EXPECT: %s , OUT: %d \n", String.valueOf(in), "", sol.reverse(in));
		
		
		
	}

	class Solution {
	    public int reverse(int x) {
	        
	        int len = findLen(x);
	        if(len == 1) return x;
	        
	        int mxlen = findLen(Integer.MAX_VALUE);
	        if(len == mxlen){
	            return overflowPos(x, len);
	        }
            int negCare = 1;
            if(x < 0){
                negCare = -1;
                x = x * negCare;
            }        
	        int cnt = len-1;
	        int revi = 0;
	        int divMx = divMx(cnt);
	        int mulTen = 1;
	        while(x > 0){
	            
	        		int lf = x / divMx;
	            revi += (lf*mulTen);
	            
	            x -= lf*divMx;
	            divMx /=10;
	            mulTen *=10;
	            
	        }
	        return revi * negCare;
	    }
	    
	    private int findLen(int x){
	        int cnt = 0;
	        while(x>0){
	            x/=10;
	            cnt++;
	        }
	        return cnt;
	    }
	    
	    private int divMx(int cnt){
	        int d = 1;
	        while(cnt>0){
	            d *=10;
	            cnt--;
	        }
	        return d;
	    }
	    
	    private int overflowPos(int x, int len){
	        long inMx = (long)Integer.MAX_VALUE;
	        int cnt = len-1;
	        long revi = 0l;
	        int divMx = divMx(cnt);
	        int mulTen = 1;
	        while(x > 0){
	        	
        			int lf = x / divMx;
	            revi = revi + (long) lf*mulTen;
	            
	            if(revi > inMx){
	                return 0;
	            }
	            
	            x -= lf*divMx;
	            divMx /=10;
	            mulTen *=10;


	        }
	        return (int)revi;
	    }
	}
}
