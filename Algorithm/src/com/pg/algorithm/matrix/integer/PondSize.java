package com.pg.algorithm.matrix.integer;

import java.util.ArrayList;
import java.util.List;

public class PondSize {
	static int count = 0;

	public static void main(String[] args) {
		List<List<Integer>> matrix = new ArrayList<>();

		int[][] iarr = new int[][] { { 0, 2, 1, 0 }, 
									{ 0, 1, 0, 1 }, 
									{ 1, 1, 0, 1 }, 
									{ 0, 1, 0, 1 } };
									
		/*iarr = new int[][] { { 1, 2, 1, 1 }, 
							 { 1, 1, 1, 1 }, 
							 { 1, 1, 1, 1 }, 
							 { 1, 1, 1, 1 } };
									
		iarr = new int[][] { { 0, 2, 1, 0 }, 
							 { 0, 1, 0, 1 }, 
							 { 1, 0, 1, 0 }, 
							 { 0, 1, 0, 1 } };*/

		// iterativeModifyInput(iarr);
									
		iterative(iarr);
							 
		//recursionModifyInput(iarr);
	}

	private static void iterative(int[][] iarr) {
		
		int[][] visit = new int[iarr.length][iarr[0].length];
		
		for(int r = 0 ; r < iarr.length; r++) {
			for(int c = 0; c < iarr[0].length; c++) {
				int cnt = 0;
				cnt = checkWater(r, c, iarr, visit);
				if(cnt > 0) {
					System.out.println(cnt);
				}
			}
		}
		
		for(int r = 0 ; r < visit.length; r++) {
			for(int c = 0; c < visit[0].length; c++) {
				System.out.print(visit[r][c] + " ");
			}
			System.out.println();
		}
		
	}

	private static void recursionModifyInput(int[][] iarr) {
		int rx = iarr.length;
		int cx = iarr[0].length;
		
		checkWaterRecur(0, 0, rx, cx, iarr);
				
		
		
	}

	private static void checkWaterRecur(int r, int c, int rx, int cx, int[][] iarr) {
		if(r == rx) return;
		
		for(int j = 0; j<cx; j++) {
			int cnt = checkWater( r,  j, iarr);
			if (cnt >0){
				System.out.println(cnt);
			}
		}
		checkWaterRecur(r+1, c, rx, cx,iarr) ;
		
	}

	private static void iterativeModifyInput(int[][] iarr) {
		int rx = iarr.length;
		int cx = iarr[0].length;

		for (int r = 0; r < rx; r++) {
			for (int c = 0; c < cx; c++) {
				count++;
				if(isNotCountable(r, c, iarr, rx, cx)) continue;
				int cnt = checkWater(r, c, iarr);
				if(cnt > 0) {
					System.out.println(cnt);
				}
			}
		}
		System.out.println(count);
	}

	private static int checkWater(int r, int c, int[][] iarr, int[][] visit) {
		
		int rx = iarr.length;
		int cx = iarr[0].length;
		
		if (isNotCountable(r, c, iarr, rx, cx, visit)) {
			return 0;
		} 
		
		int cnt = 1;
		visit[r][c] = -1;
		
		cnt += checkWater(r - 1, c, iarr, visit);
		cnt += checkWater(r + 1, c, iarr, visit);
		cnt += checkWater(r - 1, c - 1, iarr, visit);
		cnt += checkWater(r + 1, c + 1, iarr, visit);
		cnt += checkWater(r - 1, c + 1, iarr, visit);
		cnt += checkWater(r + 1, c - 1, iarr, visit);
		cnt += checkWater(r, c + 1, iarr, visit);
		cnt += checkWater(r, c - 1, iarr, visit);
		
		return cnt;

	}
	


	private static int checkWater(int r, int c, int[][] iarr) {
		count++;
		int rx = iarr.length;
		int cx = iarr[0].length;
		
		if (isNotCountable(r, c, iarr, rx, cx)) {
			return 0;
		} 
		
		int cnt = 1;
		iarr[r][c] = -1;
		
		cnt += checkWater(r - 1, c, iarr);
		cnt += checkWater(r + 1, c, iarr);
		cnt += checkWater(r - 1, c - 1, iarr);
		cnt += checkWater(r + 1, c + 1, iarr);
		cnt += checkWater(r - 1, c + 1, iarr);
		cnt += checkWater(r + 1, c - 1, iarr);
		cnt += checkWater(r, c + 1, iarr);
		cnt += checkWater(r, c - 1, iarr);
		
		return cnt;

	}

	private static boolean isNotCountable(int r, int c, int[][] iarr, int rx, int cx) {
		return r < 0 || c < 0 || r >= rx || c >= cx || iarr[r][c] != 0;
	}

	private static boolean isNotCountable(int r, int c, int[][] iarr, int rx, int cx, int[][] visit) {
		return r < 0 || c < 0 || r >= rx || c >= cx || visit[r][c] ==-1 || iarr[r][c] != 0 ;
	}

}
