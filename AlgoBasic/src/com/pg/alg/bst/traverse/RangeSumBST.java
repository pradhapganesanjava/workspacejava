package com.pg.alg.bst.traverse;

import java.util.List;

public class RangeSumBST {

	public static void main(String[] args) {
		TreeNode root = TreeNode.build(10,5,15,3,7,null,18);
	}

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class RangeSumBST_Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        return recur(root, L, R);
    }
    
    private int recur(TreeNode nd, int l, int r){
        if(nd == null) return 0;

        return recur(nd, l, r, 0);
        /*
        List<Integer> sumLst = new ArrayList<>(1);
        sumLst.add(0);
        recur(nd, l, r, sumLst);
        return sumLst.get(0);
        */
    }
    
    private int recur(TreeNode nd, int l, int r, int sum){
        if(nd == null) return 0;
        int lsum = recur(nd.left, l, r, sum);
        if(lsum > 0) return lsum;
        if(nd.val >= l && nd.val <= r){
            sum += nd.val;
        }
        if(nd.val == r) return sum;
        int rsum = recur(nd.right, l, r, sum);
        if(rsum > 0) return rsum;
        return 0;
    }    
    
    private Integer recur(TreeNode nd, Integer l, Integer r, Integer sum, Integer x){
        if(nd == null) return null;
        Integer lval = recur(nd.left, l, r, sum);
        if(lval != null) return lval;
            if(nd.val >= l && nd.val < r){
                sum += nd.val;
            }else if(nd.val == r){
                sum += nd.val;
                return sum;
            }
        Integer rval = recur(nd.right, l, r, sum);
        if(rval != null) return rval;
        return null;
    }
    
        
    private void recur(TreeNode nd, int l, int r, List<Integer> sumLst){
        if(nd == null) return;
        recur(nd.left, l, r, sumLst);
        System.out.println(nd.val);
        if(nd.val >= l && nd.val <= r){
            sumLst.set(0, sumLst.get(0) + nd.val);
        }
        if(nd.val == r) return;
        recur(nd.right, l, r, sumLst);
    }
}

class TreeNode {
     int val;     
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
     
     public static TreeNode build(Integer...in) {
    	 	TreeNode root = null;
    	 	for(Integer i : in) {
    	 		if(root == null) {
    	 			root = new TreeNode(i);
    	 			continue;
    	 		}
    	 		addNode(root, i);
    	 	}
    	 	return root;
     }

	private static void addNode(TreeNode root, Integer i) {
		TreeNode cn = root;
		TreeNode parent = null;
		while(true) {
			if(i < cn.val) {
				if(cn.left == null) {
					cn.left = new TreeNode(i);
					return;
				}else {
					cn = cn.left;
				}
			}else {
				if(cn.right == null) {
					cn.right = new TreeNode(i);
					return;
				}else {
					cn = cn.right;
				}
			}
		}
	}
 }