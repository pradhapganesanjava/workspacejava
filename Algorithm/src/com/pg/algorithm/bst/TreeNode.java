package com.pg.algorithm.bst;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) { val = x; }
    
    public String toString(){
    	return "V:"+this.val+" "+val+"L:"+this.left+" "+val+"R:"+this.right;
    }
}