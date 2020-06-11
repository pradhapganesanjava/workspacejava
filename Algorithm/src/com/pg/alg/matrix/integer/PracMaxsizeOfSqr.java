package com.pg.alg.matrix.integer;

public class PracMaxsizeOfSqr {

	public static void main(String[] args) {

		int[][] iarr0 = new int[][]{};
		int[][] iarr1 = new int[][]{ {1} };
		int[][] iarr2 = new int[][]{ {1,1} };
		int[][] iarr3 = new int[][]{ {1}
									,{1} };
		int[][] iarr4 = new int[][]{ {1,0}
									,{1,1} };
		int[][] iarr5 = new int[][]{ {1,0,1,1}
									,{1,1,1,1} };

        int[][] iarr6 = { { 1, 1, 0, 0, 1, 1 },
		                  { 0, 0, 1, 0, 1, 1 },
		                  { 1, 1, 1, 1, 1, 0 },
		                  { 1, 1, 1, 1, 1, 1 },
		                  { 1, 1, 1, 1, 1, 1 },
		                  { 0, 1, 1, 1, 1, 1 },
		                  { 1, 0, 0, 0, 1, 1 } };
							        
		/*System.out.println(getMaxSqr(iarr0));
		System.out.println(getMaxSqr(iarr1));
		System.out.println(getMaxSqr(iarr2));
		System.out.println(getMaxSqr(iarr3));
		System.out.println(getMaxSqr(iarr4));		
		System.out.println(getMaxSqr(iarr5));*/
		System.out.println(getMaxSqr(iarr6));		
		
	}
	
	private static int getMaxSqr(int[][] iarr){
		if(iarr == null || iarr.length ==0) return 0;
		int rMax = iarr.length;
		int cMax = iarr[0].length;
		
		int[][] memArr = new int[rMax][cMax];
		int mxSqr = 0;
		
		
		for(int r = 0; r < rMax; r++){
			memArr[r][0] = iarr[r][0];
		}
		for(int c = 0; c < cMax; c++){
			memArr[0][c] = iarr[0][c];
		}
		
		for(int r=1; r < rMax; r++){
			for (int c=1; c<cMax; c++){
//				if(inBoundry(r, c, rMax, cMax)){ continue;}
				
				int tMxSqr = calcSqr(r, c, rMax, cMax, memArr) + iarr[r][c];
				memArr[r][c] = tMxSqr;
				mxSqr = Math.max(tMxSqr, mxSqr);
			}
		}
		return mxSqr -1;
	}

	private static int calcSqr(int r, int c, int rMax, int cMax, int[][] memArr) {

		int minTmp = Math.min(minSqr(r-1, c, rMax, cMax, memArr), minSqr(r-1, c-1, rMax, cMax, memArr));
		int minFinal = Math.min(minSqr(r, c-1, rMax, cMax, memArr), minTmp);
		
		return minFinal;
	}
	
	private static int minSqr(int r, int c, int rMax, int cMax, int[][] memArr) {

		if(inBoundry(r, c, rMax, cMax)){
			return memArr[r][c];
		}
		
		return 0;
	}

	private static boolean inBoundry(int r, int c, int rMax, int cMax) {
			return !(r<0 || r >rMax-1 || c<0 || c>cMax-1);
	}

}
