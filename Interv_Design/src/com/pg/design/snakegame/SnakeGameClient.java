package com.pg.design.snakegame;

import java.util.LinkedList;
import java.util.List;

public class SnakeGameClient {

}

class SnakeGame {

	LinkedList<SPos> sposLL = new LinkedList<SPos>();
    int wLimit = 0;
    int hLimit = 0;
    int[][] foodPos = null;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.wLimit = width;
        this.hLimit = height;
        this.foodPos = food;
        sposLL.addFirst(new SPos(0,0));
        
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
            SPos currP = sposLL.getFirst();
            int curR = currP.getRow();
            int curC = currP.getCol();

            int newR = curR;
            int newC = curC;

        if("U".equalsIgnoreCase(direction)){
            newR = curR+1;
            newC = curC;
        }else if("D".equalsIgnoreCase(direction)){
            newR = curR-1;
            newC = curC;
        }else if("L".equalsIgnoreCase(direction)){
            newR = curR;
            newC = curC-1;
        }else if("R".equalsIgnoreCase(direction)){
            newR = curR;
            newC = curC+1;
        }
        
        if(isValidPos(newR,newC)){
        	if(isFoodPos(newR, newC)){
        		
        	}else{
        		
        	}
        	return 1;
        }else{
        	return -1;
        }
    }

	private boolean isFoodPos(int newR, int newC) {
		if(newR<foodPos.length && newC<foodPos[0].length){
			return foodPos[newR][newC] != 0;
		}
		return false;
	}
    private boolean isValidPos(int newR, int newC){
        return !(newR<0 || newC<0 || newR>hLimit || newC>wLimit);
    }
    
}

class SPos{
    int row;
    int col;
    public SPos(int row, int col){
        this.row = row;
        this.col = col;
    }
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
    public void setRow(int row){
        this.row = row;
    }
    public void setCol(){
        this.col = col;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */