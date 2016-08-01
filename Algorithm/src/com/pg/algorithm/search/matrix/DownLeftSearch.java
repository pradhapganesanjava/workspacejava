package com.pg.algorithm.search.matrix;

//O(n) time complexity best approach to search in Matrix
public class DownLeftSearch {

	public static void main(String[] args) {

		int[][] intArrTD = new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
				{ 16, 17, 18, 20, 21 } };
		int rowLen = intArrTD.length;
		int colLen = intArrTD[0].length;

		System.out.println("row " + rowLen + " column " + colLen);

		int findInt = 21;

		int i = 0;
		int j = colLen - 1;
		boolean search_done = false;

		while (!search_done) {
			if (findInt <= intArrTD[i][j]) {
				if (j - 1 > -1) {
					j--;
				} else {
					search_done = true;
				}
			} else {
				if (i + 1 < rowLen) {
					i++;
				} else {
					search_done = true;
				}
			}
		}
		System.out.println(" Searching int " + findInt + " at index [" + i + "][" + j + "].");

	}

}
