package com.pg.alg.wordprocess.matrix.recurs;

import java.util.Arrays;

public class WordSearch_Matrix_Recurs {

	public static void main(String[] args) {
		WordSearch_Matrix_Recurs_Solution sol = new WordSearch_Matrix_Recurs_Solution();
		sol.exist(new char[][] {{'a','a'}}, "aaa");
	}

}
class WordSearch_Matrix_Recurs_Solution {
    public boolean exist(char[][] board, String word) {
        
        int[] chBuf = new int[128];
        boolean[][] mem = new boolean[board.length][board[0].length];
        
        for(char ch : word.toCharArray()){
            //chBuf[ch-'A']++;
            chBuf[ch]++;
        }
        
        return  checkExistRecur(board, word, chBuf, mem, 0,0,0);
    }
    
    private boolean checkExistRecur(char[][] board, String word, int[] chBuf, boolean[][] mem, int r, int c, int chCnt){
        if(chCnt==word.length()) return true;
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || mem[r][c]) return false;

       int icurCh = (int) board[r][c];
       if(chBuf[icurCh] <= 0){
           return false;
       }
       mem[r][c]=true;
       chBuf[icurCh]--;
       chCnt++;
        if(chCnt > word.length()) return false;
       
       return checkExistRecur(board, word, copyArr(chBuf), mem, r-1,c,chCnt)  //up
           || checkExistRecur(board, word, copyArr(chBuf), mem, r-1,c-1,chCnt) //up-lf-di
           || checkExistRecur(board, word, copyArr(chBuf), mem, r-1,c+1,chCnt) //up-rt-di
           || checkExistRecur(board, word, copyArr(chBuf), mem, r,c-1,chCnt) //lf
           || checkExistRecur(board, word, copyArr(chBuf), mem, r,c+1,chCnt) //rt
           || checkExistRecur(board, word, copyArr(chBuf), mem, r+1,c,chCnt) //dw
           || checkExistRecur(board, word, copyArr(chBuf), mem, r+1,c-1,chCnt) //dw-lf-di
           || checkExistRecur(board, word, copyArr(chBuf), mem, r+1,c+1,chCnt); //dw-rt-di
       
    }
    
    private int[] copyArr(int[] chBuf){
        return Arrays.copyOf(chBuf, chBuf.length);
    }
    
    
}