package com.pg.algorithm.graph.sort;

import java.util.ArrayList;
import java.util.List;

public class TopologicalSortGP1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Graph<T>{
	private List<T> vertices;
	private List<T> edges;

	public void addVertices(T vertices){
//		if(!vertices.contains(vertices)
	}
	
}
class GraphV<T>{
	private T data;
	private List<T> edges;
	
	public GraphV(T data){
		this.data = data;
	}
	public void addEdge(T data){
		if(null!=edges && !edges.contains(data)) edges.add(data); 
	}
	public List<T> getEdges(){
		return edges;
	}
	public T getData(){
		return data;
	}
}
