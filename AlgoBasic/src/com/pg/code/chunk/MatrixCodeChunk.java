package com.pg.code.chunk;

import java.util.Arrays;

public class MatrixCodeChunk {

	public static void main(String[] args) {
		sort_2D();
		
		
		int N = 4;
		int[][] mat = new int[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				mat[r][c] = r * N + c;
			}
		}
		for(int[] arr : mat) {
			System.out.println(Arrays.toString(arr));
		}
		
		mat  = new int[N][N];
		for(int i=0; i<N; i++) {
			int c = i * N + i;
			mat[i][c] = i * N + c;
			mat[c][i] = 0;
		}
	}

	private static void sort_2D() {
		//Simple 2D sort either row or col
		sort_2D_simple();
	}

	private static void sort_2D_simple() {
		int[][] iarr = new int[][] {
			{ 3, 2},
			{ 8, 6},
			{12,13},
			{16,17}
		};
		//Arrays.sort(iarr, MatrixCodeChunk::srtBy0idx);
	}
	private int srtBy0idx(int[] arr1, int[] arr2) {
		return 0;
	}
}
