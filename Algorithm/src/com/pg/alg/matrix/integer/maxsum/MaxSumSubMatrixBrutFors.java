package com.pg.alg.matrix.integer.maxsum;

public class MaxSumSubMatrixBrutFors {

	public static void main(String[] args) {

		int[][] imatx = null;
		 imatx = new int[][] {
			{ 1,  2,  4,  2,  3},
			{ 0,  1, -2, -1, -1},
			{ 0, -1,  0, -1,  9},
			{-5,  1, -2, -1, -1},
			{ 4, -1,  0, -1,  9}
		};
		
		
		imatx = new int[][] {
			{2,3,4,-5},
			{1,2,0,8},
			{-2,0,1,3},
			{4,-1,-2,8}
		};		
		
		imatx = new int[][] {
			{5,1,2,5,2,-5,-1,5,-2,-4},
			{-2,0,-3,2,2,-5,-2,-1,-4,5},
			{4,3,0,2,-5,4,2,-5,2,-5},
			{5,-4,2,5,3,-1,-4,-4,-3,4},
			{-2,2,2,5,2,4,-1,3,-4,5},
			{2,-5,0,-4,2,3,4,-5,5,-4},
			{1,1,4,-1,-5,3,-3,-3,4,2},
			{-3,3,1,-1,-1,3,5,-4,-2,0},
			{-2,-4,-3,2,4,-3,1,3,1,-5},
			{-2,-4,4,5,5,-5,-5,1,5,-2}
		};

		
		int N = imatx.length;
		int mxSum = 0;
		for(int r = 0; r < N; r++) {
			for( int c = 0 ; c < N; c++) {
				int lastSum = imatx[r][c];
				int tN = r+1;
				
				while( tN < N) {
					int curSum = 0;
					curSum += lastSum;
					int tr = r;
					int tc = c;
					while( tc <= tN && tr <= tN ) {
						if(tc == tr && tc == tN) {
							curSum += imatx[tr][tc];
						}else {
							curSum += imatx[tN][tc];
							curSum += imatx[tr][tN];
						}
						tc++;
						tr++;
					}
					int tmxSum = Math.max(lastSum, curSum);
					mxSum = Math.max(mxSum, tmxSum);
					lastSum = curSum;
					tN++;
				}
				
			}
		}
		System.out.println("mxSum "+ mxSum);
	}

}
