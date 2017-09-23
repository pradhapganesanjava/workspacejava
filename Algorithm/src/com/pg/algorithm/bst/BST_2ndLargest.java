package com.pg.algorithm.bst;

import java.util.Arrays;


public class BST_2ndLargest {

	public static void main(String[] args) {

		System.out.println(" "+find2ndMax(node));
		
	}
	
	private static int find2ndMax(com.pg.algorithm.bst.TreeNode root) {
		if(root == null) return Integer.MIN_VALUE;
		/*if(root.right==null) return fMRec(root.left,Integer.MIN_VALUE,Integer.MIN_VALUE);
		else return fMRec(root.right,Integer.MIN_VALUE,Integer.MIN_VALUE);*/
		return fMRec(root,Integer.MIN_VALUE,Integer.MIN_VALUE);
		
	}

	private static int fMRec(com.pg.algorithm.bst.TreeNode cN,int m1, int m2) {
		if(cN==null)return m2;
		
		if(m1<cN.val){
			int tm1= m1;
			m1 = cN.val;
			if(m2<tm1){
				m2=tm1;
			}
		}else if(cN.val>m2){
			m2=cN.val;
		}
		m2 = fMRec(cN.right,m1,m2);
		if(cN.right==null){
			m2 = fMRec(cN.left,m1,m2);
		}
		return m2;
	}

	/***
	 * BST Load
	 */
	static TreeNode node = null;
	static{
		//int[] intArr = new int[]{5,10,15,20,25,30,35};
		int[] intArr = new int[]{20,10,15,5};
		//binaryConstBST(intArr);
		linearConstBST(intArr);
	}
	private static void linearConstBST(int[] intArr) {
		for(int i : intArr){
			node = linearConstBSTRec(node,i);
		}
		System.out.println(node.toString());
	}
	private static void binaryConstBST(int[] intArr) {
		Arrays.sort(intArr);
		node = constructBST(intArr,0,intArr.length-1);
		System.out.println(node.toString());
	}	
	private static TreeNode linearConstBSTRec(TreeNode cN, int i) {
		if(cN==null){ 
			return node = new TreeNode(i);
		}
		if(i<=cN.val){
			cN.left = linearConstBSTRec(cN.left,i);
		}else{
			cN.right = linearConstBSTRec(cN.right, i);
		}
		return cN;
	}

	private static TreeNode constructBST(int[] intArr,int low, int high){
		if(low>high) return null;
		int mid = (low + high)/2;
		
		TreeNode node = new TreeNode(intArr[mid]);
		node.left = constructBST(intArr, low, mid-1);
		node.right = constructBST(intArr, mid+1, high);
		return node;
	}

}

