package com.pg.algorithm.graph;

import java.util.ArrayList;

public class Graph {
	public class Graph_Node {
		public int node_id;
		public Graph_Node next;

		public Graph_Node(int id) {
			this.node_id = id;
		}
	}

	public ArrayList<Graph_Node> nodeList;

	public Graph() {
		nodeList = new ArrayList<Graph_Node>();
	}

	public Graph_Node addNode(int id) {
		Graph_Node node = new Graph_Node(id);

		nodeList.add(0, node);

		return nodeList.get(0);
	}

	// adding edge from id1 to id2
	// if either of these does not exist then create and add
	public void addEdge(int id1, int id2) {

		// search for id1 and id2
		boolean node1_found = false, node2_found = false;

		Graph_Node node1 = null, node2 = null;
		for (int i = 0; i < nodeList.size(); i++) {
			if (nodeList.get(i).node_id == id1) {
				node1_found = true;
				node1 = nodeList.get(i);
			}
			if (nodeList.get(i).node_id == id2) {
				node2_found = true;
				node2 = nodeList.get(i);
			}

			if (node1_found && node2_found)
				break;
		}

		if (!node1_found) {
			node1 = this.addNode(id1);
		}

		if (!node2_found) {
			node2 = this.addNode(id2);
		}

		Graph_Node temp = new Graph_Node(id2);
		temp.next = node1.next;
		node1.next = temp;

		return;
	}

	public Graph_Node getNode(int id) {
		for (int i = 0; i < nodeList.size(); i++) {
			if (id == nodeList.get(i).node_id) {
				return nodeList.get(i);
			}

		}

		return null;
	}

	public void printGraph() {
		for (int i = 0; i < nodeList.size(); i++) {
			Graph_Node temp = nodeList.get(i);

			while (temp != null) {
				System.out.print(" ->" + temp.node_id);
				temp = temp.next;
			}
			System.out.println();
		}
	}

}
