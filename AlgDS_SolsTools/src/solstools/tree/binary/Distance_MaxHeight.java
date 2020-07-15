package solstools.tree.binary;

/*
 * 
	<a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">104. Maximum Depth of Binary Tree</a>
	Given a binary tree, find its maximum depth.
	
	The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
	
	Note: A leaf is a node with no children.
	
	Example:
	
	Given binary tree [3,9,20,null,null,15,7],
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its depth = 3.



 * 
 */
public class Distance_MaxHeight {

	public static void main(String[] args) {
		Distance_MaxHeight_Solution sol = new Distance_MaxHeight_Solution();
		sol.maxDepth(null);

	}

}

/**
 * Definition for a binary tree node.
 */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Distance_MaxHeight_Solution {
    public int maxDepth(TreeNode root) {
        // return topDown(root);
        return bottomUp(root);
    }
    
    private int bottomUp(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(bottomUp(root.left), bottomUp(root.right))+1;
    }
    
    private int topDown(TreeNode root){
        int[] mx = new int[]{0};
        topDown(root, 0, mx);
        return mx[0];
    }
    private void topDown(TreeNode cnd, int cnt, int[] mx){
        if(cnd == null){
            mx[0] = Math.max(mx[0],cnt);
            return;
        }
        cnt += 1;
        topDown(cnd.left, cnt, mx);
        topDown(cnd.right, cnt, mx);
    }
}