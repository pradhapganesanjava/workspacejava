package com.pg.alg.path.matrix;

public class MinFallingSum {

	public static void main(String[] args) {
		MinFallingSum_Solution sol = new MinFallingSum_Solution();
		sol.minFallingPathSum(null);}

class MinFallingSum_Solution {
    public int minFallingPathSum(int[][] A) {
        return matrixPath_Intuitive(A);
    }
    private int matrixPath_Intuitive(int[][] A){
        if(A == null || A.length == 0) return 0;
       int[][] mem = new int[A.length][A[0].length];
        int min = Integer.MAX_VALUE;
        for(int c=0; c<A[0].length; c++){
            int t = matrixPath_Intuitive(A, 0, c, mem);
            min = Math.min(min, t);
        }
        return min;
    }
    
    private int matrixPath_Intuitive(int[][] A, int r, int c, int[][] mem){
        if(r<0 || c<0||r>=A.length || c>=A[0].length) return Integer.MAX_VALUE;
        if(mem[r][c] != 0 ) return mem[r][c];
        int min = Integer.MAX_VALUE;
        int res1 = matrixPath_Intuitive(A, r+1, c-1, mem);
        int res2 = matrixPath_Intuitive(A, r+1, c, mem);
        int res3 = matrixPath_Intuitive(A, r+1, c+1, mem);
        
        int minRes = Math.min(Math.min(res1, res2), res3);
        if(minRes != Integer.MAX_VALUE){
            mem[r][c] = Math.min(A[r][c]+minRes, min);
            return  mem[r][c];
        }
        mem[r][c] = Integer.MAX_VALUE;
        return mem[r][c];
    }
}