package com.pg.alg.tree.binary;

public class Ancesstor1stCom_Tree_Recur_TopDown_Return {
	
	Ancesstor1stCom_Tree_Recur_TopDown_Return this_ = new Ancesstor1stCom_Tree_Recur_TopDown_Return();
	Tree tree = this_.new Tree();

	public static void main(String[] args) {
		int[] iarr = new int[] {5,1,44,33,8,2,10};
		
		
	}

	private class Tree{
		Integer val;
		Tree left;
		Tree right;
		Tree(Integer val){
			this.val = val;
		}
		Tree(){
		}
	}
}
