package com.pg.alg.tree.binary.travers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.epi.BinaryTreePrototypeTemplate.BinaryTreeNode;
import com.epi.BinaryTreeUtils;
import com.pg.alg.tree.binary.TreeNode;

public class BinarytreeInorderIterator {

	public static void main(String[] args) {

		Integer[] iarr = new Integer[] {10, 8, 15, 6, 9, null, 18, 5, 7, null, null, 17, 20, 2, null, null, null, null, null, null, null, null, 1,4,null, null, 3, null};
		Integer[] iarr2 = new Integer[] {10, 6, 15, 4, 8, 12, 18, 3, 5, 7, 9, 11, 13, 17, 19};
		//                                0  1   2  3  4  5    6  7  8  9 10  11   12 13  14
		
		TreeNode bst = TreeNode.buildTree(iarr2);
		inorderTraversals(bst);	
		
		kthSmallestElem(bst);
	}

	private static void kthSmallestElem(TreeNode bst) {
		int kthsm = kthSmallestIter(bst, 4);
		System.out.println(kthsm);
		
		System.out.println("RECUR Kth");
		kthsm = kthSmallestRecur(bst, 0, 4);
		System.out.println(kthsm);
	}

	private static int kthSmallestRecur(TreeNode bst, int cnt, int k) {
		if(bst == null) return -1;
		
		int lfv = kthSmallestRecur(bst.left, cnt, k);
		cnt++;
		if(cnt == k) return bst.val;
		int rtv = kthSmallestRecur(bst.right, cnt, k);
		if(lfv != -1 || rtv != -1) return lfv == -1 ? rtv : lfv;
		return -1;
	}

	private static int kthSmallestIter(TreeNode bst, int k) {
		Stack<TreeNode> stk = new Stack<>();
		int cnt = 1;
		while(true) {
			while(bst != null) {
				stk.push(bst);
				bst = bst.left;
			}
			if(stk.empty()) break;
			bst = stk.pop();
			if(cnt == k) return bst.val;
			cnt++;
			bst = bst.right;
		}
		return 0;
	}

	private static void inorderTraversals(TreeNode bst) {
		List<Integer> inordLst = new ArrayList<>();
		
		inorderIter(bst, inordLst);
		inordLst.forEach( ech -> System.out.print(ech+", "));
		System.out.println("-------------");
		
		inordLst = new ArrayList<>();
		inorderRecur(bst, inordLst);
		inordLst.forEach( ech -> System.out.print(ech+", "));
		System.out.println("-------------");
	}

	private static void inorderRecur(TreeNode bstNd, List<Integer> inordLst) {
		if(bstNd == null) return;
		inorderRecur(bstNd.left, inordLst);
		inordLst.add(bstNd.val);
		inorderRecur(bstNd.right, inordLst);
	}

	private static void inorderIter(TreeNode btree, List<Integer> inordLst) {
		TreeNode curNd = btree;
		Stack<TreeNode> stk = new Stack<>();
		while(true) {
			while(curNd != null) {
				stk.add(curNd);
				curNd = curNd.left;
			}
			if(stk.isEmpty()) break;
			curNd = stk.pop();
			inordLst.add(curNd.val);
			curNd = curNd.right;
			//stk.push(item)
		}
	}

}
