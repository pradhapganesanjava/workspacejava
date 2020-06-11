package com.pg.alg.matrix.str.maxsqrborder;

public class MaxSquareBorder {

	public static void main(String[] args) {
		char[][] charr = new char[][] {
			{'B', 'B', 'B','B'},
			{'W', 'B', 'W','B'},
			{'B', 'B', 'B','B'},
			{'B', 'B', 'B','B'}
		};
		int rx = charr.length;
		int cx = charr[0].length;
		int sqrCnt = 0;
		for(int r = rx-1; r >=0 ; r--) {
			for(int c = cx-1; c>=0; c--) {
				if(sqrCnt == 0 && charr[r][c] == 'B') {
					sqrCnt = 1;
				}
				int tsqrCnt = findSqr(charr, r, c, r-1, c-1);
				sqrCnt = Math.max(sqrCnt, tsqrCnt);
			}
		}
		System.out.println(sqrCnt);
	}

	private static int findSqr(char[][] charr, int r, int c, int r2, int c2) {
		System.out.format("(r, c): (%d, %d) , (rx, cx): (%d, %d) \n",r,c,r2,c2);
		if(r2 < 0 || c2 < 0 || r < r2 || c < c2) return 0;
		
		int mx = 0;
		
		int tr = r;
		int tc = c;
		int trx = r2;
		int tcx = c2;
		
		//topbot check r, cx
		boolean topbot = true;
		while(tcx <= tc) {
			if(charr[tr][tc] != 'B' || charr[trx][tc] != 'B') {
				topbot = false;
				break;
			}
			tc--;
		}
		
		tr = r;
		tc = c;
		trx = r2;
		tcx = c2;
		boolean lfrt = true;
		while(trx <= tr) {
			if(charr[tr][tc] != 'B' || charr[tr][tcx] != 'B') {
				lfrt = false;
				break;
			}
			tr--;
		}
		if(topbot && lfrt) {
			mx = r-r2;
		}
		

		int tmx = findSqr(charr, r, c, r2-1, c2-1);
		
		
		mx = Math.max(mx, tmx);
		System.err.format("(r, c): (%d, %d) , (rx, cx): (%d, %d) MX: %d \n",r,c,r2,c2, mx);
		
		return Math.max(mx, tmx);
	}

}
