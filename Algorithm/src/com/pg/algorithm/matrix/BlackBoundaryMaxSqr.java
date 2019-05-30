package com.pg.algorithm.matrix;

public class BlackBoundaryMaxSqr {

	public static void main(String[] args) {

		String[][] pixMx = new String[][] {
			{ "B", "B", "B", "W"},
			{ "B", "W", "B", "W"},
			{ "B", "B", "B", "B"},
			{ "B", "B", "B", "W"}
		};
		
		pixMx = new String[][] {
			{ "B", "W", "B", "B"},
			{ "B", "W", "B", "W"},
			{ "B", "B", "B", "B"},
			{ "B", "B", "B", "W"}
		};
		
		int N = pixMx.length;
		
		int mx = 0;
				
		for(int r = N-1 ; r >=0; r++) {
			for(int c = N-1; c >=0; c++) {
				
				int diagLmt = Math.min(r,c);
				int rx = r-diagLmt;
				int cx = c-diagLmt;
				
				boolean flg = checkBlkMxRecur(r, c, rx,cx, pixMx);
				/*int resCnt2 = checkBlkMxRecur(r, c, N, pixMx);
				int resCnt3 = checkBlkMxRecur(r, c, N, pixMx);
				int resCnt4 = checkBlkMxRecur(r, c, N, pixMx);
				mx = Math.max(Math.max(resCnt1, resCnt2),Math.max(resCnt3, resCnt4));*/
				if(flg) {
					break;
				}
				
			}
		}
		System.out.println("Max blk sqr " + mx);
	}

	private static boolean checkBlkMxRecur(int r, int c, int rx, int cx, String[][] pixMx) {
		if(pixMx[r][c] == "B" && (r<=rx || c<=cx)) return true;
		if(pixMx[r][c] == "W") return false;

		return checkBlkMxRecur(r-1, c, rx, cx, pixMx) 
				&& checkBlkMxRecur(r, c-1, rx, cx, pixMx) 
				&& checkBlkMxRecur(0, c-1, rx, cx, pixMx) 
				&& checkBlkMxRecur(r-1, 0, rx, cx, pixMx);
	}



}
