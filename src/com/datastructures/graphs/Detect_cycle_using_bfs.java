package com.datastructures.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Detect_cycle_using_bfs {
	
	/*
	 * Time Complexity : O ( V^2 )
	 * Space Complexity : O ( V )
	 */
	public static boolean detect_cycle(int[][] graph) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[graph.length];
		visited[0] = true;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		queue.add(0);
		
		while (!queue.isEmpty()) {	
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int row = queue.poll();
				for (int j = 0; j < graph[0].length; j++) {
					if (graph[row][j] == 1 && visited[j] == true && j != map.get(row)) {
						return true;
					}

					if (graph[row][j] == 1 && !visited[j]) {
						queue.add(j);
						map.put(j, row);
						visited[j] = true;
					}
				}
			}
		}

		return false;

	}

	public static void main(String[] args) {
		int[][] graph = new int[][]{
			{0,1,1,0,0},
			{1,0,0,0,1},
			{1,0,0,1,1},
			{0,0,1,0,0},
			{0,1,1,0,0}
		};

		System.out.println("Cycle detected  : "+ detect_cycle(graph));
	}
}
