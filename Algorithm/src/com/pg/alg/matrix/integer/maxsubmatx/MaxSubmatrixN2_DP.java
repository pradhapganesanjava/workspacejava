package com.pg.alg.matrix.integer.maxsubmatx;

import com.pg.alg.matrix.PrintMatrix;

public class MaxSubmatrixN2_DP {

	public static void main(String[] args) {
		int[][] mtx = new int[][] {
			{0, 1, 0, 1, 1, 0},
			{1, 1, 0, 1, 1, 1},
			{1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 0},
			{0, 1, 1, 1, 1, 1}
		};
		
		int rx = mtx.length;
		int cx = mtx[0].length;
				
		int[][] mem = new int[rx+1][cx+1];
		
		for(int r = 0; r < rx; r++) {
			for(int c = 0 ; c < cx; c++) {
				
				int rm = r+1;
				int cm = c+1;
				
				if(mtx[r][c] == 0) {
					mem[rm][cm] = 0;
				}else {
					int min = getMin(mem, rm, cm);
					mem[rm][cm] = 1 + min;
				}
				
			}
		}
		
		PrintMatrix.printMatrix(mtx);
		System.out.println("====>");
		PrintMatrix.printMatrix(mem);
		
	}

	private static int getMin(int[][] mem, int rm, int cm) {
		int dg = mem[rm-1][cm-1];
		int lf = mem[rm][cm-1];
		int up = mem[rm-1][cm];
		return Math.min(dg, Math.min(lf, up));
	}

}
