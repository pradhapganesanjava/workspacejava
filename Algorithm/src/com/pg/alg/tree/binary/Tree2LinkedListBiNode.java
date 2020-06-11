package com.pg.alg.tree.binary;

public class Tree2LinkedListBiNode {

	public static void main(String[] args) {
		BiNode root = createTree();
		printAsTree(root, "");
		BiNode r = convert(root);
		printLinkedListTree(r);
	}
	
	private static BiNode convert(BiNode nd) {
		if(nd == null) return null;
		
		BiNode prevNd = convert(nd.node1);
		nd.node1 = prevNd;
		if(prevNd != null) {
			prevNd.node2 = nd;
		}
		
		BiNode nxtNd = convert(nd.node2);
		nd.node2 = nxtNd;
		if(nxtNd != null) {
			nxtNd.node1 = nd;
		}
		
		return nd;
	}

	public static void printAsTree(BiNode root, String spaces) {
		if (root == null) {
			System.out.println(spaces + "- null");
			return;
		}
		System.out.println(spaces + "- " + root.data);
		printAsTree(root.node1, spaces + "   ");
		printAsTree(root.node2, spaces + "   ");
	}
	
	public static BiNode createTree() {
		BiNode[] nodes = new BiNode[7];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new BiNode(i);
		}
		nodes[4].node1 = nodes[2];
		nodes[4].node2 = nodes[5];
		nodes[2].node1 = nodes[1];
		nodes[2].node2 = nodes[3];
		nodes[5].node2 = nodes[6];
		nodes[1].node1 = nodes[0];
		return nodes[4];
	}
	
	public static void printLinkedListTree(BiNode root) {
		for (BiNode node = root; node != null; node = node.node2) {
			if (node.node2 != null && node.node2.node1 != node) {
				System.out.print("inconsistent node: " + node);
			}
			System.out.print(node.data + "->");
		}
		System.out.println();
	}
}

class BiNode {
	public BiNode node1;
	public BiNode node2;
	public int data; 
	public BiNode(int d) {
		data = d;
	}
}