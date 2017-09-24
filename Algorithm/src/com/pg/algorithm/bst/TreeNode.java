package com.pg.algorithm.bst;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    
    public String toString(){
    	return "V:"+this.val+" "+val+"L:"+this.left+" "+val+"R:"+this.right;
    }
}