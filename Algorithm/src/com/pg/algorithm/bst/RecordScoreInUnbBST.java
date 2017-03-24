package com.pg.algorithm.bst;

import java.util.LinkedList;
import java.util.Queue;

public class RecordScoreInUnbBST {

	private Node<Integer> root = null;
	static RecordScoreInUnbBST thisIns = new RecordScoreInUnbBST();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] intArrInp = {4,2,5,5,6,1,4};
		
		thisIns.createScoreUBST(intArrInp);
		
	
	
	}
	
	public void BFS(Node<Integer> currNode){
		if(currNode == null) return;
		
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		
		System.out.println(currNode);
		System.out.println(currNode.left);
		System.out.println(currNode.right);
		
	}
	
	public Node<Integer> createScoreUBST(Integer[] intArrInp){
		if(null == intArrInp || intArrInp.length ==0) return null;
		
		root = new Node<Integer>(intArrInp[0]);
		createScoreUBSTImpl(root,intArrInp,1);
		return root;
	}
	
	private Node<Integer> createScoreUBSTImpl(Node<Integer> node, Integer[] intArrInp,int index){
		
		Node<Integer> currNode = node;
		while (currNode != null){
			int compInt = intArrInp[index].compareTo(node.key);
			if(compInt == 0){
				currNode.increaseCount();
			}else if ( compInt > 0){
				currNode = currNode.right;
			}else{
				currNode = currNode.left;
			}
		}
		if ( currNode == null){
			currNode = new Node<Integer>(intArrInp[index]);
		}
		
		index++;
		if(index > intArrInp.length-1){
			return root;
		}else{
			createScoreUBSTImpl(root,intArrInp,index);
		}
		return root;
	}
	

	private class Node<T>{
		T key;
		int count;
		Node<T> left;
		Node<T> right;
		public Node(T key) {
			this.key = key;
			this.count = 1;
		}
		public int increaseCount(){
			return this.count++;
		}
		public String toString(){
			return key+":"+count;
		}
	}
}
