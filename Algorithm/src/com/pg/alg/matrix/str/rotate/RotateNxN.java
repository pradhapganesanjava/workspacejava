package com.pg.alg.matrix.str.rotate;

public class RotateNxN {

	public static void main(String...str) {
		
		
		String[][] sarr = new String[][] {
			{"A1","A2","A3","A4"},
			{"B1","B2","B3","B4"},
			{"C1","C2","C3","C4"},
			{"D1","D2","D3","D4"}
		};
		System.out.println("B4: ");
		printMatrix(sarr);
		rotateArr(sarr, 0,0,sarr.length-1);
		System.out.println("A4: ");
		printMatrix(sarr);
		
		
	}

	private static void rotateArr(String[][] sarr, int r, int c, int n) {
		
		if(n<=0 || r > n || c > n) return;
		int tn = n;
		//n = n-1;
		int tr = r;
		int rx = r+n;
		int tc = c;
		
		int rtr = r;
		int rtc = c+n;
		int br = r+n;
		int bc = c+n;
		int ltr = r+n;
		int ltc = c;
		
		while(tn>0) {
			String t = sarr[tr][tc];
			String rt = sarr[rtr][rtc];
			String b = sarr[br][bc];
			String lf = sarr[ltr][ltc];
			
			sarr[tr][tc] = lf;
			sarr[rtr][rtc] = t;
			sarr[br][bc] = rt;
			sarr[ltr][ltc] = b;
			
			
			tc++;
			rtr++;
			bc--;
			ltr--;
			tn--;
			
			
		}
		
		rotateArr(sarr, r+1,c+1,n-2);
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
