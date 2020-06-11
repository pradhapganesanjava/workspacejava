package com.pg.alg.matrix.integer.maxrectangle;

public class MaxRectangle {

	public static void main(String[] args) {
		int[][] irec = new int[][] {
			{0, 1, 1, 0, 0, 1},
			{1, 0, 1, 1, 1, 0},
			{1, 1, 1, 1, 0, 1}
		};
		
		int rx = irec.length;
		int cx = irec[0].length;
		int mxSz = 0;
		for(int r = rx-1; r >=0 ; r--) {
			for(int c = cx-1; c >=0 ; c--) {
				
				if(irec[r][c] == 1) {
					int reSz = findRec(irec, r, c);
				}
				
			}
		}
	}

	private static int findRec(int[][] irec, int r, int c) {
		if(r < 0 || c < 0) return 0;
		int rx = r;
		int cx = c;
		while(rx>=0 && irec[rx][c] == 1) {
			rx--;
		}
		while(cx>=0 && irec[r][cx] == 1) {
			cx--;
		}
		
		return findMxRec(irec, r, c, rx, cx);
	}

	private static int findMxRec(int[][] irec, int rs, int cs, int rx, int cx) {

		if(rx < rs || cx < cs) return 0;
		if(irec[rx][cx] == 1) return 1;
		
		int lf = findMxRec(irec, rs, cs, rx, cx-1);
		int dw =	 findMxRec(irec, rs, cs, rx-1, cx);
		int dg =	 findMxRec(irec, rs, cs, rx-1, cx-1);
		
		int tmin = Math.min(lf, dw);
		int t2min = Math.min(tmin, dg);
		
		return 0;
	}

}
