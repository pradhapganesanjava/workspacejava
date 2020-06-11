package com.pg.alg.matrix.integer.maxsum;

public class MaxSumSubMatrix {

	public static void main(String[] args) {
		int[][] mxarr = new int[][] {
			{ 2,  3,  4, -5},
			{ 1,  2,  0,  8},
			{-2,  0,  1,  3},
			{ 4, -1, -2,  8}
		};
		
		mxarr = randomMatrix(10, 10, -5, 5);
		
		mxarr = new int[][] {
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
		
		printMatrix(mxarr) ;
		
		int mx = Integer.MIN_VALUE;
		
		for(int r = 0; r < mxarr.length; r++) {
			for(int c = 0; c < mxarr[0].length; c++) {
				if(mx == Integer.MIN_VALUE) {
					mx = Math.max(mx, mxarr[r][c]);
				}
				int tmx = findMx(mxarr, r , c, r+1, c+1);
				mx = Math.max(mx, tmx);
			}
		}
		System.out.println("Max : "+mx);
	}

	private static int findMx(int[][] mxarr, int r, int c, int r2, int c2) {
		
		if(r > r2 || c > c2 || r2 >= mxarr.length || c2 >= mxarr[0].length) return 0;
		
		int curMx = 0;
		for(int i = r; i<=r2; i++) {
			for(int j=c; j<=c2; j++) {
				curMx += mxarr[i][j];
			}
		}
		System.out.format("(r, c): (%d, %d) , (rx, cx): (%d, %d) MX: %d \n",r,c,r2,c2, curMx);
		
		int mx1 = findMx(mxarr, r, c, r2, c2+1);
		System.out.format("(r, c): (%d, %d) , (rx, cx): (%d, %d) MX: %d \n",r,c,r2,c2, mx1);
		int mx2 = findMx(mxarr, r, c, r2+1, c2);
		System.out.format("(r, c): (%d, %d) , (rx, cx): (%d, %d) MX: %d \n",r,c,r2,c2, mx1);
		int mx3 = findMx(mxarr, r, c, r2+1, c2+1);
		System.out.format("(r, c): (%d, %d) , (rx, cx): (%d, %d) MX: %d \n",r,c,r2,c2, mx1);
		
		int mxs1 = Math.max(mx1,  mx2);
		int mxs2 = Math.max(curMx, mx3);
		
		int mx = Math.max(mxs1, mxs2);
		
		System.out.format("(r, c): (%d, %d) , (rx, cx): (%d, %d) MX: %d \n",r,c,r2,c2, mx);
		return mx;
	}
	
	public static int[][] randomMatrix(int M, int N, int min, int max) {
		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = randomIntInRange(min, max);
			}
		}
		return matrix;
	}

	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] < 10 && matrix[i][j] > -10) {
					//System.out.print(" ");
				}
				if (matrix[i][j] < 100 && matrix[i][j] > -100) {
					//System.out.print(" ");
				}
				if (matrix[i][j] >= 0) {
					//System.out.print(" ");
				}
				if(j==0) {
					System.out.print("{"+ matrix[i][j]);
				}else if(j==matrix[i].length-1){
					System.out.print("," + matrix[i][j]+"},");
				}else {
				 System.out.print("," + matrix[i][j]);
				}
			}
			System.out.println();
		}
	}

}
