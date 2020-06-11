package com.pg.alg.tree.binary;

public class TreeNode {

	public Integer val;
	public TreeNode left;
	public TreeNode right;

	TreeNode(Integer x) {
		val = x;
	}
	
	public String toString() {
		return String.format("%d <- ( %d ) -> %d" , (null!=this.left?this.left.val:null), this.val, (null!=this.right?this.right.val:null));
	}

	public static void main(String...str) {
		TreeNode root = null; 
		
		/*root = buildTree(new Integer[][] {          
			          { 4 },
			       { 2,               3},
			    {null,   1,         5,  null}, 
			      { null, null, null, 6}
		});*/
		
		 root = buildTree(new Integer[] {3,9,20,null,null,15,7});
	}

	public static TreeNode buildTree(Integer[] iarr) {
		TreeNode root = null;
		root = new TreeNode(iarr[0]);
		buildTreeRecur(root, iarr, 0);
		
		return root;
	}

	private static TreeNode buildTreeRecur(TreeNode cn, Integer[] iarr, int idx) {
		//int cidx = (int)Math.pow(2, lev) + idx;
		if(idx >= iarr.length || iarr[idx] == null) return null;
		if(cn == null) {
			cn = new TreeNode(iarr[idx]);
		}
		cn.left = buildTreeRecur(cn.left, iarr, (2*idx)+1);
		cn.right = buildTreeRecur(cn.right, iarr, (2*idx)+2);
		return cn;
	}
	
	private static TreeNode buildTreeFailed(TreeNode cn, Integer[] iarr, int lev, int idx) {
		//int cidx = (int)Math.pow(2, lev) + idx;
		int cidx =  lev + idx;
		if(cidx >= iarr.length || iarr[cidx] == null) return null;
		if(cn == null) {
			cn = new TreeNode(iarr[cidx]);
		}
		cn.left = buildTreeFailed(cn.left, iarr, lev+1, (int)Math.pow(2, lev)-1);
		cn.right = buildTreeFailed(cn.right, iarr, lev+1, (int)Math.pow(2, lev));
		return cn;
	}

	static TreeNode buildTree(Integer[][] iarr) {
		if(iarr == null || iarr.length == 0) return null;
		TreeNode root = new TreeNode(iarr[0][0]);
		 //buildTreeRecur(root, iarr, 1, 0);
		root = null;
		buildTreeRecur(root, iarr, 0, 0); 
		 return root;
	}

	private static TreeNode buildTreeRecur(TreeNode cn, Integer[][] iarr, int r, int c) {
		// if(cn == null) return null;
		if(r >= iarr.length) return null;
		if(c >= iarr[r].length) return null;
		if(cn == null && iarr[r][c] != null) {
			cn = new TreeNode(iarr[r][c]);
		}
		if(cn == null) return null;
		//r = r+1;
		cn.left = buildTreeRecur(cn.left, iarr, r+1, c);
		cn.right = buildTreeRecur(cn.right, iarr, r+1, c+1);
		return cn;
	}
	/*
	private static int buildTreeRecur2(TreeNode cn, Integer[][] iarr, int r, int c) {
		// if(cn == null) return null;
		if(r >= iarr.length) return null;
		if(c >= iarr[r].length) return null;
		
		if(iarr[r][c] != null) {
			cn = new TreeNode(iarr[r][c]);
		}
		if(cn == null) return null;
		r = r+1;
		c = 0;
		cn.left = buildTreeRecur2(iarr, r, c);
		c +=1;
		cn.right = buildTreeRecur2(iarr, r, c);
		return c;
	}*/

}
