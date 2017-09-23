package com.pg.java.clone.chess;

import com.pg.java.clone.Bishap;
import com.pg.java.clone.ChessKeysAbstract;
import com.pg.java.clone.ChessKeysBase;
import com.pg.java.clone.Elephant;
import com.pg.java.clone.Horse;
import com.pg.java.clone.King;
import com.pg.java.clone.Pawn;
import com.pg.java.clone.Queen;

public class ChessCloneClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class ChessBoardFactory{
	
}

class ChessKeyFactory implements Cloneable{

	
}

abstract class ChessKey{
	abstract ChessKeysPos pos();
	abstract ChessColor color();
	abstract ChessKeyConst keyName();
}

class ChessKeys extends ChessKeysBase {

	
}
class ChessKeysPos{
	private int[][] position = new int[64][64];
	public int[][] position(int row, int col){
		position[row][col]=
	}
	
}

enum ChessKeyConst{
	P(Pawn),Q(Queen);
}

enum ChessColor{
	BLACK, WHITE
}

class ChessKey{
	
}

class ChessKeysBase{
	private Pawn pawns;
	private Bishop bishop;
	private Queen queen;
	private King king;
	private Knight knight;
	private Rook rook;
	
}
abstract class ChessKeysCloneFactory implements Cloneable{
	
	public ChessKeysBase basicChessKeys(){
		 try {
			return (ChessKeysAbstract)clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		 return null;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException{
			return super.clone();
	}
}