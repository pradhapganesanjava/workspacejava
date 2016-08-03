package com.pg.algorithm.graph.sort;

import java.util.ArrayList;
import java.util.Hashtable;

import com.pg.algorithm.graph.Graph;
import com.pg.algorithm.graph.Graph.Graph_Node;

public class TopologicalSort {
	public void printSorted(Graph gr) {
		Hashtable inDegrees = new Hashtable<Integer, Integer>();
		ArrayList<Graph_Node> zeroDegreeList = new ArrayList<Graph_Node>();
		ArrayList<Graph_Node> nodes = gr.nodeList;

		// This for loop counts the in-degrees for all nodes.
		// Adds nodes having in-degree > 0 to in-Degrees hashtable
		for (int i = 0; i < nodes.size(); i++) {
			Graph_Node temp = nodes.get(i);

			temp = temp.next;
			while (temp != null) {
				int count = (inDegrees.get(temp.node_id) == null) ? 0 : (int) inDegrees.get(temp.node_id);
				inDegrees.put(temp.node_id, count + 1);
				temp = temp.next;
			}

		}

		// nodes which are not added to in-degree hashtable have in-degree = 0
		// create zeroDegree list of such nodes
		for (int i = 0; i < nodes.size(); i++) {
			Graph_Node temp = nodes.get(i);

			// nodes with zero indegree would not be in the hashtable
			// since they are not in anyone's neighbor list
			if (inDegrees.get(temp.node_id) == null) {
				zeroDegreeList.add(0, temp);
			}

		}
		// take out a node from zeroDegree list
		// print that node, remove all out-edges associated with it and update
		// zeroDegree list.
		while (!zeroDegreeList.isEmpty()) {
			Graph_Node curr = zeroDegreeList.remove(0);

			// print topo sort
			System.out.println(curr.node_id);

			Graph_Node temp = curr.next;

			// update the in-degree for all the neighbors of the current vertex
			while (temp != null) {
				int prevInDegree = (int) inDegrees.get(temp.node_id);

				inDegrees.put(temp.node_id, prevInDegree - 1);
				if (prevInDegree == 1) {
					zeroDegreeList.add(gr.getNode(temp.node_id));
				}
				temp = temp.next;
			}
		}

	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Graph gr = new Graph();

		gr.addEdge(1, 2);
		gr.addEdge(1, 6);

		gr.addEdge(3, 4);
		gr.addEdge(3, 1);

		gr.addEdge(4, 5);

		gr.addEdge(6, 2);
		gr.addEdge(6, 4);
		gr.addEdge(6, 5);

		gr.printGraph();

		TopologicalSort sort = new TopologicalSort();

		sort.printSorted(gr);
	}
}
