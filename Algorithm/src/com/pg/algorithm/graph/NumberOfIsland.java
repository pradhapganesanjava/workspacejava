package com.pg.algorithm.graph;

public class NumberOfIsland {
	public static void main(String[] args) {

		int[][] m = { { 1, 0, 1, 0, 1 }, { 1, 1, 0, 0, 0 }, { 0, 1, 0, 1, 1 } };

		boolean[][] visited = new boolean[3][5];
		int clusterCount = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (m[i][j] == 0) {
					visited[i][j] = true;
					continue;
				}
				if (!visited[i][j]) {
					System.out.println("Starting new cluster at:" + i + ":" + j);
					DFS(m, i, j, visited);
					System.out.println("cluster completed");
					++clusterCount;
				}
			}
		}
	}

	public static void DFS(int[][] m, int i, int j, boolean[][] visited) {

		if (i >= m.length || i < 0 || j >= m[0].length || j < 0) {
			return;
		}
		if (visited[i][j])
			return;
		visited[i][j] = true;
		if (m[i][j] == 0) {
			return;
		}
		System.out.println("adding to cluster :" + i + ":" + j);
		DFS(m, i + 1, j, visited);
		DFS(m, i - 1, j, visited);
		DFS(m, i, j - 1, visited);
		DFS(m, i, j + 1, visited);
		DFS(m, i + 1, j + 1, visited);
		DFS(m, i - 1, j - 1, visited);
		DFS(m, i - 1, j + 1, visited);
		DFS(m, i + 1, j - 1, visited);
	}
}