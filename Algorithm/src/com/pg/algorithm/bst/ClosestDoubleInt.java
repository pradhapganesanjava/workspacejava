package com.pg.algorithm.bst;

public class ClosestDoubleInt {

	public static void main(String[] args) {

		int[] intArr = null;
		intArr = new int[] {1,2,3,4,5,6,7,8,9,10};
		intArr = new int[] {10,20,30};

		TreeNode_cdi root = loadTreeNode(intArr,0,intArr.length-1);
		System.out.println(root.toString());
		
		Solution sol = new Solution();
		
		sol.closestValue(root, 21.12);
	}

	private static TreeNode_cdi loadTreeNode(int[] intArr,int start,int end) {
		if(start>end) return null;
		int mid = (start+end)/2;
		TreeNode_cdi treeNode = new TreeNode_cdi(intArr[mid]);
			treeNode.left = loadTreeNode(intArr,start,mid-1);
			treeNode.right = loadTreeNode(intArr,mid+1,end);
		
		return treeNode;
	}

}

// Definition for a binary tree node.
  class TreeNode_cdi {
      int val;
      TreeNode_cdi left;
      TreeNode_cdi right;
      TreeNode_cdi(int x) { val = x; }
      
      public String toString(){
    	  //return val+" L: "+(null!=left?String.valueOf(left.val):"null")+" R: "+(null!=right?String.valueOf(right.val):"null");
    	  return val+" L: "+(null!=left?left.toString():"null")+" R: "+(null!=right?right.toString():"null");
      }
      
  }
class Solution {
    public int closestValue(TreeNode_cdi root, double target) {
        if(root==null) return -1;
        
        TreeNode_cdi currNode = root;
        int closestInt = root.val;
        while(currNode != null){
            
            /*if(currNode.val == (int)java.lang.Math.floor(target) || currNode.val == (int)java.lang.Math.ceil(target)){
                System.out.println("currNode.val  "+currNode.val);
                return currNode.val;
            }*/
            closestInt = currNode.val;
                    int leftInt = 0;
                    int rightInt = 0;
                    double leftDiff = 0;
                    double rightDiff = 0;
                    
            leftInt = null !=currNode.left?currNode.left.val:0;
            rightInt = null != currNode.right? currNode.right.val:0;
            
            leftDiff = Math.abs(target - leftInt);
            rightDiff = Math.abs(target - rightInt);

            
            if(leftDiff>rightDiff){
                currNode = currNode.right;
            }else{
                currNode = currNode.left;
            }
        }
        System.out.println("closestInt "+closestInt);
        return closestInt;
    }
}