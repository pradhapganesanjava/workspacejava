package com.pg.algorithm.binarytree;

public class BinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] inArr = new int[] { 2, 1, 4, 3, 5 };
		BST<Integer, Object> bst = new BST<Integer, Object>();
		for (int i : inArr) {
			//bst.add(i);
			bst.root = bst.addRecur(bst.root, i,i);
		}
		
		
		//System.out.println(bst.getNode(bst.root,1).toString());
		bst.preOrderTraverse(bst.root);
		System.out.println("--------");
		
		bst.root = bst.delete(bst.root, 2);

		bst.preOrderTraverse(bst.root);
	}
}

class BST<E extends Comparable<E>, V> {

	public BTNode<E,V> root = null;

	public void add(E data) {
		if (root == null) {
			root = new BTNode<E, V>(data, null, null);
		} else {
			BTNode<E, V> curNode = root;
			BTNode<E, V> parent = root;
			while (curNode != null) {
				parent = curNode;
				if (data.compareTo(curNode.data) < 0) {
					curNode = curNode.left;
					if (null == curNode) {
						parent.left = new BTNode<E, V>(data, null, null);
						return;
					}
				} else if (data.compareTo(curNode.data) > 0) {
					curNode = curNode.right;
					if (null == curNode) {
						parent.right = new BTNode<E, V>(data, null, null);
						return;
					}
				}
			}
		}
	}

	public BTNode<E,V> addRecur(E data, V value) {
		root = addRecur(root, data,value);
		return root;
	}
	public BTNode<E,V> addRecur(BTNode<E,V> node, E data, V value) {
		if(node == null){
			return new BTNode<E, V>(data, value);
		}
		int compare = data.compareTo(node.data);
		if(compare<0){
			node.left = addRecur(node.left,data, value);
		}else if(compare>0){
			node.right = addRecur(node.right,data, value);
		}else{
			node.value=value;
		}
		return node;
	}
	
	public BTNode<E, V> getNode(BTNode<E, V> node, E key) {
		if (node == null)
			return null;
		
		//pre - traversal
		if(node.data.equals(key)){
			return node;
		}
		int compare = key.compareTo(node.data);
		if (compare < 0) {
			 return node.left = getNode(node.left, key);
		} else if (compare > 0) {
			return node.right = getNode(node.right, key);
		}/*else {
			//post-traversal
			return node;
		}*/
		return null;
	}

	public BTNode<E, V> delete(BTNode<E,V> node, E data){
		
		if(node == null) return null;
		
		int comp = data.compareTo(node.data);
		if(comp<0){
			node.left = delete(node.left,data);
		}else if (comp>0){
			node.right=delete(node.right, data);
		}else{
			if(node.right==null) return node.left;
			if(node.left==null) return node.right;
			
			BTNode<E, V> tmpNode = node;
			node = min(tmpNode.right);
			node.right= deleteMin(tmpNode.right);
			node.left=tmpNode.left;
		}
		return node;
	}
	
	public BTNode<E, V> min(BTNode<E, V> node) {
		if(node.left==null){return node;}
		else return node = min(node.left);
	}
	
	public BTNode<E, V> deleteMin(BTNode<E, V> node){
		if(node.left == null){return node.right;}
		node.left = deleteMin(node.left);
		return node;
	}
	
	
	public void preOrderTraverse(BTNode node) {
		if (node == null) {
			return;
		}
		System.out.println(node.data);
		preOrderTraverse(node.left);
		preOrderTraverse(node.right);
	}

	public BST() {
	}
}

class BTNode<E, V> {
	E data;
	V value;
	BTNode<E,V> left, right;

	BTNode(E data, V value) {
		this.data = data;
		this.value = value;
	}

	BTNode(E data, BTNode left, BTNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "data: "+this.data+" value: "+this.value;
	}
	
	public E getData() {
		return data;
	}

	public BTNode getLeft() {
		return left;
	}

	public BTNode getRight() {
		return right;
	}

	public void setData(E data) {
		this.data = data;
	}

	public void setLeft(BTNode left) {
		this.left = left;
	}

	public void setRight(BTNode right) {
		this.right = right;
	}
}