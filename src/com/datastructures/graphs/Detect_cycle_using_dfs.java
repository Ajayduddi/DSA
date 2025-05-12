package com.datastructures.graphs;

public class Detect_cycle_using_dfs {
	
	/*
	 * Time Complexity : O ( V^2 )
	 * Space Complexity : O ( V )
	 */
	public static boolean detect_cycle(int[][] graph, int curr, int prev, boolean[] visited) {


		for (int i = 0; i < graph[curr].length; i++) {
			if (graph[curr][i] == 1 && visited[i] == true && i != prev) {
				return true;
			}

			if (graph[curr][i] == 1 && !visited[i]) {
				visited[i] = true;
				boolean result = detect_cycle(graph, i, curr, visited);
				if (result) {
					return result;
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int[][] graph = new int[][]{
			{0,1,1,0,0},
			{1,0,0,0,1},
			{1,0,0,1,0},
			{0,0,1,0,0},
			{0,1,0,0,0}
		};
		boolean[] visited = new boolean[graph.length];
		visited[0] = true;
		System.out.println("Cycle detected  : "+ detect_cycle(graph, 0, -1, visited));
	}
}
