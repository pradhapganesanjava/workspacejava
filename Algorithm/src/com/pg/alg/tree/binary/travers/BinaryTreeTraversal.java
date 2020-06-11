package com.pg.alg.tree.binary.travers;

import java.util.Stack;

import com.pg.alg.tree.binary.TreeNode;

public class BinaryTreeTraversal {

	public static void main(String...str) {
		
		TreeNode tn = TreeNode.buildTree(new Integer[] {				5,
															 9,             12,
														  8,     10,     7,       null,
												    null,null,11,null, null, 20, null,null});
		
		preOrderIter(tn);
		System.out.println("\n--recur-->");
		preOrderRecur(tn);
		
		
	}

	private static void preOrderRecur(TreeNode tn) {
		if(tn == null) return;
		System.out.print(tn.val+", ");
		preOrderRecur(tn.left);
		preOrderRecur(tn.right);
	}

	private static void preOrderIter(TreeNode tn) {
		if(tn == null) return;
		Stack<TreeNode> stk = new Stack<>();
		stk.push(tn);
		
		while(!stk.isEmpty()) {
			
			TreeNode cn = stk.pop();
			if(cn == null) continue;
			System.out.print(cn.val+", ");
			
			if(cn.left!=null && cn.right != null) {
				stk.push(cn.right);
				stk.push(cn.left);
			}else if(cn.left!=null) {
				stk.push(cn.left);
			}else if(cn.right!=null) {
				stk.push(cn.right);
			}
		}
	}
	
}
