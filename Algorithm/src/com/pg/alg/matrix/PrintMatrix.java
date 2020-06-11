package com.pg.alg.matrix;

public class PrintMatrix {

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if(j==0) {
					System.out.print("{"+ matrix[i][j]);
				}else if(j==matrix[i].length-1){
					System.out.print("," + matrix[i][j]+"},");
				}else {
				 System.out.print("," + matrix[i][j]);
				}
			}
			System.out.println();
		}
	}

	public static void printMatrix(String[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if(j==0) {
					System.out.print("{"+ matrix[i][j]);
				}else if(j==matrix[i].length-1){
					System.out.print("," + matrix[i][j]+"},");
				}else {
				 System.out.print("," + matrix[i][j]);
				}
			}
			System.out.println();
		}
	}
	
}
