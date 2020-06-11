package com.pg.algorithm.bst.twosum;

import com.pg.algorithm.bst.TreeNode;

public class TwoSumBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        
       return findTargetBtm2Up(root, root, k);
       
    }
    
     private boolean findTargetBtm2Up(TreeNode proot, TreeNode croot, int k) {
         if(croot == null) return false;
        
         
         findTargetBtm2Up(proot, croot.left, k);
         int rem = k - croot.val;
         TreeNode foundNd = findTargetRecur(proot, rem);
         Boolean lfoundFlg = null;
         if(foundNd != null){
             if(rem == croot.val){
               lfoundFlg =  ((null != foundNd.left && foundNd.left.val == rem) || 
                    (null != foundNd.right && foundNd.right.val == rem))?true: null;
             }else{
                lfoundFlg = true;
             }
         }
         Boolean rfoundFlg = null;
         if(lfoundFlg == null){
             findTargetBtm2Up(proot, croot.right, k);
             int rrem = k - croot.val;
             TreeNode rfoundNd = findTargetRecur(proot, rrem);
             if(rfoundNd != null){
                 if(rrem == croot.val){
                   rfoundFlg =  ((null != rfoundNd.left && rfoundNd.left.val == rrem) || 
                        (null != rfoundNd.right && rfoundNd.right.val == rem))?true: null;
                 }else{
                    rfoundFlg = true;
                 }
             }
         }
         return (null != lfoundFlg && lfoundFlg) || (null != rfoundFlg && rfoundFlg);
     }
    
    private TreeNode findTargetRecur(TreeNode root, int k) {
        if(root == null) return null;
        
        if(k == root.val) return root;
        
        TreeNode lf = findTargetRecur(root.left, k);
        if(lf != null) return lf;
        TreeNode rt = findTargetRecur(root.right, k);
        if(rt != null) return rt;
        
        return null;
    }
}