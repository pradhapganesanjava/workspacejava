package com.pg.ds.tree.binary;

/*
 * 
 * Tree:
 *  > Root
 *  > Node
 *  	* Parent Node
 *  	* Child Node
 *  > Leaf (No Children)
 *  > SubTree
 * 
 * Binary Tree:
 *  > Root Node - a Middle value of whole tree.
 *  > Parent Node - can have max two children Nodes. 
 *  > LeftNode - Lesser than Parent Node
 *	> RightNode - Higher than Parent Node  
 *  
 *  
 * 
 */

public class BinaryTreeHello {

	Node rootNode = null;

	public boolean addNode(String nodeName, Integer value) {

		Node newNode = new Node(nodeName, value);

		if (rootNode == null) {
			rootNode = newNode;
			return true;
		} else {
			Node focusNode = rootNode;
			Node parentNode = null;
			while (true) {
				parentNode = focusNode;
				if (value < focusNode.value) {
					focusNode = focusNode.leftNode;
					if (null == focusNode) {
						parentNode.leftNode = newNode;
						return true;
					}
				} else {
					focusNode = focusNode.rightNode;
					if (null == focusNode) {
						parentNode.rightNode = newNode;
						return true;
					}
				}
			}
		}
	}
	
	public void deleteNode(Node nodeToDelete){
		
		
		
		
		
	}

	public String searchNode(Integer nodeValue){
		
		Node focusNode = rootNode;
		
		while(focusNode.value != nodeValue){
			
			if(nodeValue < focusNode.value){
				focusNode = focusNode.leftNode;
			}else{
				focusNode = focusNode.rightNode;
			}
			if(focusNode == null){
				return null;
			}
		}
		
		return focusNode.nodeName;
	}
	
	public void inorderTraversal(Node focusNode) {
		if (null != focusNode) {
			System.out.println("Node visited: " + focusNode.nodeName);

			inorderTraversal(focusNode.leftNode);
			inorderTraversal(focusNode.rightNode);
		}
	}

	static class Node {
		Integer value;
		String nodeName;
		Node leftNode;
		Node rightNode;

		public Node(String nodeName, Integer value) {
			this.value = value;
			this.nodeName = nodeName;
		}

		@Override
		public String toString() {
			return "NodeName: " + this.nodeName + " NodeValue: " + this.value;
		}
	}

	public static void main(String... str) {

		BinaryTreeHello biTree = new BinaryTreeHello();
		biTree.addNode("root", 5);
		biTree.addNode("ONE", 1);
		biTree.addNode("TWO", 2);
		biTree.addNode("THREE", 3);
		biTree.addNode("FOUR", 4);
		//biTree.addNode("SIX", 6);
		//biTree.addNode("SEVEN", 7);
		biTree.addNode("EIGHT", 8);
		biTree.addNode("SIX", 6);
		biTree.addNode("EIGHT", 8);
		biTree.inorderTraversal(biTree.rootNode);
		String search = biTree.searchNode(7);
		System.out.println("Found? "+( (null == search)?"NOT FOUND":"YES, NodeName: "+search) );

	}

}
