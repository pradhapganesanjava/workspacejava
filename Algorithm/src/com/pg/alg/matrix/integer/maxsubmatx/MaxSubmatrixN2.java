package com.pg.alg.matrix.integer.maxsubmatx;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.pg.alg.matrix.PrintMatrix;

public class MaxSubmatrixN2 {

	Map<String, Integer> mpCnt = new HashMap<>();
	
	private static AtomicInteger counter = new AtomicInteger(0);
	
	public static void main(String[] args) {

		int[][] matrix = new int[][] {
			{0, 1, 0, 1, 1, 0},
			{1, 1, 0, 1, 1, 1},
			{1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 0},
			{0, 1, 1, 1, 1, 1}
		};
		
		
		/*matrix = new int[][] {
			{1, 1, 0},
			{1, 1, 1},
			{1, 1, 1},
			{1, 1, 1}
		};*/
		
		int rx = matrix.length;
		int cx = matrix[0].length;
		
		int[][] mem = new int[rx][cx];
		int mx = 0;
		int cnt = 0;
		
		
		for(int r = 0 ; r < rx; r++) {
			for(int c = 0; c < cx; c++) {
				if(matrix[r][c] == 1 && mem[r][c] == 0) {
					counter.incrementAndGet();
					spreadSearch(matrix, r, c, mem, counter);
					
				}
			}
		}
		PrintMatrix.printMatrix(matrix);
		System.out.println("=====>");
		PrintMatrix.printMatrix(mem);
		System.out.println("runtime : " + counter.get());
		
	}

	private static int spreadSearch(int[][] matrix, int r, int c, int[][] mem, AtomicInteger inc) {
		inc.incrementAndGet();
		if(r >= matrix.length || c >= matrix[0].length || matrix[r][c] == 0) return 0;
		if(mem[r][c] != 0) return mem[r][c];

		int cnt = 1;
		// mem[r][c] = 1;
		int nxt = spreadSearch(matrix, r, c+1, mem, inc);
		int lf = spreadSearch(matrix, r+1, c, mem, inc);
		int dg = spreadSearch(matrix, r+1, c+1, mem, inc);
		
		int sz =  Math.min(dg, Math.min(nxt, lf)) + cnt;
		mem[r][c] = sz;
		
		return sz;
		
	}

}
