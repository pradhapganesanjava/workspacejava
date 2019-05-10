package com.pg.alg.tree.binary;

public class IsBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isValidBST(TreeNode root) {
        
        return isBSTRecur(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }
    
    private boolean isBSTRecur(TreeNode cn, int min, int max){
        if(null == cn) return true;
        
        if(! (cn.val>min || cn.val<=max)) return false;
        
        return isBSTRecur(cn.left, min, cn.val) && isBSTRecur(cn.right, cn.val, max);
    }

    /**
     * Definition for a binary tree node.
     */
     private class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
}


 
