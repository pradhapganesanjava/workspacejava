package com.pg.algorithm.matrix.string.numoflonely;

public class NumOfLonely {
	
	static String[][] iPicArr = {{"W","W","B"},
								 {"W","B","W"},
								 {"B","W","B"}};
	
	static int iX = iPicArr.length;
	static int jX = iPicArr[0].length;
	
	static int[] rowCnt = new int[iX];
	static int[] colCnt = new int[jX];

	static int lonelyCnt = 0;
	public static void main(String[] args) {

		for(int i=0; i<iX; i++){
			for(int j=0; j<jX; j++){
				if("B".equals(iPicArr[i][j])){
					rowCnt[i]=rowCnt[i]+1;
					colCnt[j]=colCnt[j]+1;
				}
			}
		}
		
		for(int i=0; i<iX; i++){
			for(int j=0; j<jX; j++){
				if("B".equals(iPicArr[i][j]) && rowCnt[i]==1 && colCnt[j] == 1){
					lonelyCnt++;
				}
			}
		}
		
		System.out.println(" lonelyCnt " + lonelyCnt);
	}

}
