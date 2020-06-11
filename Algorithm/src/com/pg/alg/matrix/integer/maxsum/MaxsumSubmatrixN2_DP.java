package com.pg.alg.matrix.integer.maxsum;

public class MaxsumSubmatrixN2_DP {

	public static void main(String[] args) {

		int[][] mtx = new int[][] {
			{ 2,  3,  4, -5},
			{ 1,  2,  0,  8},
			{-2,  0,  1,  3},
			{ 4, -1, -2,  8}
		};
		
		int rx = mtx.length;
		int cx = mtx[0].length;
		
		int[][] mem = new int[rx][cx];
		
		for(int r = 0 ; r < rx; r++) {
			for(int c = 0 ; c < cx ; c++) {
				int rm = rx+1;
				int cm = cx+1;
				mem[rm][cm] = sumNeigb(mem, rm, cm) + mtx[r][c];
			}
		}
		
	}

	private static int sumNeigb(int[][] mem, int rm, int cm) {
		int dg = mem[rm-1][cm-1];
		int lf = mem[rm][cm-1];
		int up = mem[rm-1][cm];
		return 0;
	}

}
