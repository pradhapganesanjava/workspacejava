package com.pg.java.temp;

import java.util.ArrayList;
import java.util.Arrays;

public class AdjacencyMatrix {

	static int[][] adjMatrix = { { 0, 1, 1, 0 }, { 0, 0, 0, 1 }, { 0, 1, 0, 1 }, { 0, 0, 0, 0 } };

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<Integer> getNeighbors = getNeighbors(3);

		System.out.println("neighbors of adjMatrix[1] " + Arrays.asList(getNeighbors));
		System.out.println("getTwoHopNeighbors " + Arrays.asList(getTwoHopNeighbors(2)));
	}

	private static ArrayList<Integer> getNeighbors(int vertices) {
		ArrayList<Integer> getNeighbors = new ArrayList<Integer>(0);

		for(int i = 0; i < 4; i++){
			System.out.println(" adjMatrix [" + vertices + "][" + i + "]" + adjMatrix[vertices][i]);
			if(adjMatrix[vertices][i] > 0){
				getNeighbors.add(i);
			}
		}
		return getNeighbors;
	}

	private static ArrayList<Integer> getTwoHopNeighbors(int vertices) {
		ArrayList<Integer> getNeighbors = new ArrayList<Integer>(0);

		for(int i = 0; i < 4; i++){
			for(int j = 0; j < adjMatrix[vertices][i]; j++){
				System.out.println(" getTwoHopNeighbors [" + vertices + "][" + i + "]"
						+ adjMatrix[vertices][i]);
				//getNeighbors.add(i);
				getNeighbors.addAll(getNeighbors(i));
			}
		}
		return getNeighbors;
	}

}
