package com.pg.alg.matrix.integer.zeromx;

import java.util.HashSet;
import java.util.Set;

import com.pg.alg.matrix.PrintMatrix;

public class ZeroMatrix {

	public static void main(String...str) {
		
		int[][] iarr = new int[][] {
			{1,2,3,4,0},
			{1,2,2,1,1},
			{0,1,1,0,1}
		};
		int rx = iarr.length;
		int cx = iarr[0].length;
		
		Set<Integer> rst= new HashSet<>();
		Set<Integer> cst= new HashSet<>();
		
		System.out.println("B4 ");
		PrintMatrix.printMatrix(iarr);
		
		for(int r=0; r<rx; r++) {
			for(int c=0; c<cx; c++) {
				if(iarr[r][c] == 0) {
					rst.add(r);
					cst.add(c);
				}
			}
		}
		
		for(int r : rst) {
			int tc = 0;
			while(tc<cx) {
				iarr[r][tc]=0;
				tc++;
			}
		}
		
		for(int c : cst) {
			int tr = 0;
			while(tr<rx) {
				iarr[tr][c]=0;
				tr++;
			}
		}
		
		//O_N_pow_4(iarr, rx, cx, rst, cst);
		
		System.out.println("AFTER ");
		PrintMatrix.printMatrix(iarr);
	}

	private static void O_N_pow_4(int[][] iarr, int rx, int cx, Set<Integer> rst, Set<Integer> cst) {
		for(int r=0; r<rx; r++) {
			for(int c=0; c<cx; c++) {
				if(rst.contains(r)) {
					int tc = 0;
					while(tc<cx) {
						iarr[r][tc]=0;
						tc++;
					}
				}
				if(cst.contains(c)) {
					int tr = 0;
					while(tr<rx) {
						iarr[tr][c]=0;
						tr++;
					}
				}
			}
		}
	}
	
}
