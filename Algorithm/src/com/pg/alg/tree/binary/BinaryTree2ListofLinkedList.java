package com.pg.alg.tree.binary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTree2ListofLinkedList {

	public static void main(String[] args) {
		int[] inArr = {30,35,40,45,50,55,60,65,70};
		BTNode<Integer> btNode = buildBTNode(inArr);
		/*System.out.println("InOrderTraversal Start.... ");
		traverseInOrder(btNode);*/
		
		createLLfromBT(btNode);
		
	}
	private static Stack<Integer> buffStack = new Stack<Integer>();
	private static List<LinkedList<Integer>> gListOfLL = new ArrayList<>();
	private static void createLLfromBT(BTNode<java.lang.Integer> btNode) {

		if(btNode==null) return;
		createLLfromBTRec(btNode);
//		gListOfLL.forEach(index -> i);
		
	}
	private static void createLLfromBTRec(BTNode<java.lang.Integer> btNode) {
		if(btNode == null){
			if(null!=buffStack && buffStack.size()>0){
				LinkedList<Integer> llTmp = new LinkedList<>();
				Collections.copy(buffStack, llTmp);
				gListOfLL.add(llTmp);
			}
			return;
		}
		buffStack.push(btNode.data);
		createLLfromBTRec(btNode.left);
		createLLfromBTRec(btNode.right);
		System.out.println("end of leaf : "+buffStack.pop());
		
		return;
	}
	private static void traverseInOrder(BTNode<java.lang.Integer> btNode) {
		if(btNode == null) return;
		traverseInOrder(btNode.left);
		System.out.println(btNode.data);
		traverseInOrder(btNode.right);
	}
	private static BTNode<Integer> buildBTNode(int[] inArr){
		if(null == inArr || inArr.length==0){
			return null;
		}
		return buildBTNodeRec(inArr, 0, inArr.length-1);
	}
	

	private static BTNode<Integer> buildBTNodeRec(int[] inArr, int start, int end) {
		if(end<start) return null;
		int mid = (start+end)/2;
		BTNode<Integer> btNode = new BTNode<Integer>(inArr[mid], null, null);
		btNode.left = buildBTNodeRec(inArr, start, mid-1);
		btNode.right = buildBTNodeRec(inArr, mid+1, end);
		return btNode;
	}


	private static class BTNode<Integer>{
		public Integer data;
		public BTNode<Integer> left;
		public BTNode<Integer> right;
		public BTNode(Integer data, BTNode<Integer> left,BTNode<Integer> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
}
