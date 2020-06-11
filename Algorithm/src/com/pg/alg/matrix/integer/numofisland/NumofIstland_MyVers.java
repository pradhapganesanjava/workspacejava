package com.pg.alg.matrix.integer.numofisland;

public class NumofIstland_MyVers {
	static int numOfIsland = 0;
//	static int[][] island = {{1,1},{1,1}, {0,0}};
//	static int[][] island = {{0,1},{1,1}, {0,0}};
//	static int[][] island = {{0,1},{1,1}, {0,1}};
	/*static int[][] island = {{0,1,0},
							 {0,1,1},
							 {1,0,0}};*/
	//static int[][] island = {{1,1}};
	static int[][] island = {
								{1,0,1,0,0},
								{0,1,0,1,1},
								{1,1,1,0,1},
								{1,0,0,0,1}
							};
	static int ix = island.length;
	static int jx = island[0].length;
	
	static boolean[][] visitLog = new boolean[ix][jx];
	
	public static void main(String[] args) {
		
		for(int i=0; i<ix; i++){
			for(int j=0; j < jx; j++){
				/*if(countIsland(i,j,0)>0){
					numOfIsland++;
				}*/
				if(countIsland(i,j)>0){
					numOfIsland++;
				}
			}
		}
		System.out.println("#OfIsland "+numOfIsland);
		
	}

	private static int countIsland(int i, int j, int ones){
		if(i>=ix || i<0 || j<0 || j>=jx || island[i][j] ==0 || visitLog[i][j]) return 0;
		ones++;
		visitLog[i][j]=true;
		//up
		countIsland(i,j-1,ones);
		//down
		countIsland(i,j+1,ones);
		//left
		countIsland(i-1,j,ones);
		//righ
		countIsland(i+1,j,ones);
		
		return ones;
		//if(ones>0) return 1; else return 0;
	}
	
	private static int countIsland(int i, int j){
		if(i>=ix || i<0 || j<0 || j>=jx || island[i][j] ==0 || visitLog[i][j]) return 0;
		int ones = 1;
		visitLog[i][j]=true;
		//up
		ones += countIsland(i,j-1);
		//down
		ones += countIsland(i,j+1);
		//left
		ones += countIsland(i-1,j);
		//righ
		ones += countIsland(i+1,j);
		
		return ones;
		//if(ones>0) return 1; else return 0;
	}
}
