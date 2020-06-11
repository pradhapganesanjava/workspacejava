package com.pg.alg.matrix.traverse;

import java.util.ArrayList;
import java.util.List;

public class Matrix_Traverse_Spiral_ON2 {

	public static void main(String[] args) {
		Matrix_Traverse_Spiral_ON2_Solution sol = new Matrix_Traverse_Spiral_ON2_Solution();
		int[][] imat = new int[][] {
			{11,12,13,14,15},
			{21,22,23,24,25},
			{31,32,33,34,35},
			{41,42,43,44,45},
			{51,52,53,54,55},
			{61,62,63,64,65},
			{71,72,73,74,75},
			{81,82,83,84,85},
		};
		List<Integer> ilst = sol.spiralOrder(imat);
		ilst.forEach(ech -> System.out.print(ech + ", "));
	}

}

class Matrix_Traverse_Spiral_ON2_Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        
        if(null == matrix || matrix.length == 0) return new ArrayList<Integer>(0);
        return optForLoopWay(matrix);
       // return myWhileLoopWay(matrix);
    }
    
    private List<Integer> optForLoopWay(int[][] matrix){
        int rx = matrix.length-1;
        int cx = matrix[0].length-1;
        int r = 0;
        int c = 0;
        
        List<Integer> iLst = new ArrayList<>();

        while(r<rx && c<cx){
                //top
                for(int i=c; i<=cx; i++){
                    iLst.add(matrix[r][i]);
                }
                //rt
                for(int i=r+1; i<rx; i++){
                    iLst.add(matrix[i][cx]);
                }
                //btm
                for(int i=c; i<=cx; i++){
                    iLst.add(matrix[rx][cx-i]);
                }  
                //lft
                for(int i=r+1; i<rx; i++){
                    iLst.add(matrix[rx-i][c]);
                }            
            r++;
            c++;
            rx--;
            cx--;
        }
        return iLst;          
    }
}