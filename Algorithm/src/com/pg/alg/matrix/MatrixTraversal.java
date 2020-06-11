package com.pg.alg.matrix;

public class MatrixTraversal {

	public static void main(String[] args) {
		int[][] imatx = new int[][]{{11,12,13,14,15},
									{21,22,23,24,25},
									{31,32,33,34,35},
									{41,42,43,44,45},
									{51,52,53,54,55}
								 };
									  
		System.out.println("--------------------------");
		PrintHelper.print(arr -> {
			System.out.println("INPUT ");
			return imatx;
		});
		
		PrintHelper.print(arr -> {
			System.out.println("BY DIAG c=r, r:c ==>");
			int rx = imatx.length;
			int cx = imatx[0].length;
			int[][] dparr = new int[rx][cx];
			for(int r=0 ; r<rx; r++) {
				for(int c=r; c<cx; c++) {
					dparr[r][c] = imatx[r][c];
					//System.out.format("(r:%d, c:%d)= %d (c:%d, r:%d)= %d \n",r,c,imatx[r][c],c,r,imatx[c][r]);
				}
			}
			int[][] dparr2 = new int[rx][cx];
			int t2r = 0;
			int t2c = 0;
			for(int r=0 ; r<rx; r++) {
				t2c = 0;
				for(int c=r; c<cx; c++) {
					dparr2[t2r][t2c] = imatx[r][c];
					t2c++;
				}
				t2r++;
			}
			return dparr2;
		});
		System.out.println("--------------------------");

		System.out.println("--------------------------");
		PrintHelper.print(arr -> {
			System.out.println("INPUT ");
			return imatx;
		});
		
		PrintHelper.print(arr -> {
			System.out.println("BY DIAG c=r, c:r ==>");
			int rx = imatx.length;
			int cx = imatx[0].length;
			int[][] dparr = new int[rx][cx];
			for(int r=0 ; r<rx; r++) {
				for(int c=r; c<cx; c++) {
					dparr[c][r] = imatx[c][r];
				}
			}
			return dparr;
		});
		System.out.println("--------------------------");
		
		PrintHelper.print(arr -> {
			System.out.println("INPUT ");
			return imatx;
		});
		PrintHelper.print(arr -> {
			System.out.println("BY COL c=0, c:r ==>");
			int rx = imatx.length;
			int cx = imatx[0].length;
			int[][] dparr = new int[rx][cx];
			int rt = 0;
			int ct = 0;
			for(int r=0 ; r<rx; r++) {
				ct = 0;
				for(int c=0; c<cx; c++) {
					dparr[rt][ct] = imatx[c][r];
					ct++;
				}
				rt++;
			}
			return dparr;
		});
		System.out.println("--------------------------");

	}


}
interface PrintArray{
	int[][] print(int[][] iarr);
}
class PrintHelper{
	public static void print(PrintArray printArr) {
		int[][] iarr = printArr.print(null);
		int rx = iarr.length;
		int cx = iarr[0].length;
		for(int r=0 ; r<rx; r++) {
			for(int c=0; c<cx; c++) {
				System.out.format("%d,\t",iarr[r][c]);
			}
			System.out.println();
		}
		
	}
}
