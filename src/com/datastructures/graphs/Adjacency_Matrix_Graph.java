package com.datastructures.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Adjacency_Matrix_Graph implements Graph, Graph_Traversal {
	private int[][] graph;
	private int vertices_size;
	private boolean isDirected;

	/**
	 * Constructor to initialize an undirected graph with a given number of vertices.
	 * 
	 * @param total_vertices The total number of vertices in the graph.
	 * Time Complexity: O(V^2)
	 * Space Complexity: O(V^2)
	 * 
	 * Steps:
	 * 1. Set the size of vertices to total_vertices + 1.
	 * 2. Initialize the adjacency matrix with the size of vertices_size x vertices_size.
	 */
	public Adjacency_Matrix_Graph(int total_vertices) {
		this.vertices_size = total_vertices + 1;
		this.graph = new int[vertices_size][vertices_size];
	}

	/**
	 * Constructor to initialize a graph with a given number of vertices and direction.
	 * 
	 * @param total_vertices The total number of vertices in the graph.
	 * @param isDirected     Boolean indicating if the graph is directed.
	 * Time Complexity: O(V^2)
	 * Space Complexity: O(V^2)
	 * 
	 * Steps:
	 * 1. Set the size of vertices to total_vertices + 1.
	 * 2. Set the isDirected flag.
	 * 3. Initialize the adjacency matrix with the size of vertices_size x vertices_size.
	 */
	public Adjacency_Matrix_Graph(int total_vertices, boolean isDirected) {
		this.vertices_size = total_vertices + 1;
		this.isDirected = isDirected;
		this.graph = new int[vertices_size][vertices_size];
	}

	/**
	 * Adds an edge between two vertices.
	 * 
	 * @param vertice1 The first vertex.
	 * @param vertice2 The second vertex.
	 * Time Complexity: O(1)
	 * Space Complexity: O(1)
	 * 
	 * Steps:
	 * 1. Check if the graph is directed.
	 * 2. If directed, call add_directed_edge.
	 * 3. If undirected, call add_undirected_edge.
	 */
	@Override
	public final void addEdge(int vertice1, int vertice2) {
		if (isDirected) {
			add_directed_edge(vertice1, vertice2);
		} else {
			add_undirected_edge(vertice1, vertice2);
		}
	}

	/**
	 * Removes an edge between two vertices.
	 * 
	 * @param vertice1 The first vertex.
	 * @param vertice2 The second vertex.
	 * Time Complexity: O(1)
	 * Space Complexity: O(1)
	 * 
	 * Steps:
	 * 1. Check if the graph is directed.
	 * 2. If directed, call remove_directed_edge.
	 * 3. If undirected, call remove_undirected_edge.
	 */
	@Override
	public final void removeEdge(int vertice1, int vertice2) {
		if (isDirected) {
			remove_directed_edge(vertice1, vertice2);
		} else {
			remove_undirected_edge(vertice1, vertice2);
		}
	}

	/**
	 * Displays the adjacency matrix of the graph.
	 * Time Complexity: O(V^2)
	 * Space Complexity: O(1)
	 * 
	 * Steps:
	 * 1. Loop through each row of the adjacency matrix.
	 * 2. Loop through each column of the adjacency matrix.
	 * 3. Print the value at graph[i][j].
	 * 4. Move to the next line after each row.
	 */
	@Override
	public final void display() {
		for (int i = 1; i < vertices_size; i++) {
			for (int j = 1; j < vertices_size; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Checks if there is an edge between two vertices.
	 * 
	 * @param vertice1 The first vertex.
	 * @param vertice2 The second vertex.
	 * @return True if there is an edge, false otherwise.
	 * Time Complexity: O(1)
	 * Space Complexity: O(1)
	 * 
	 * Steps:
	 * 1. Return true if graph[vertice1][vertice2] is not 0.
	 * 2. Return false otherwise.
	 */
	@Override
	public final boolean checkEdge(int vertice1, int vertice2) {
		return graph[vertice1][vertice2] != 0;
	}

	/**
	 * Calculates the degree of a vertex.
	 * 
	 * @param vertice The vertex.
	 * @return The degree of the vertex.
	 * Time Complexity: O(V)
	 * Space Complexity: O(1)
	 * 
	 * Steps:
	 * 1. Initialize count to 0.
	 * 2. Loop through each column of the adjacency matrix for the given vertex.
	 * 3. Increment count if there is an edge.
	 * 4. Return the count.
	 */
	@Override
	public final int degree(int vertice) {
		int count = 0;
		for (int i = 1; i < vertices_size; i++) {
			count += graph[vertice][i] != 0 ? 1 : 0;
		}
		return count;
	}

	/**
	 * Calculates the in-degree of a vertex.
	 * 
	 * @param vertice The vertex.
	 * @return The in-degree of the vertex.
	 * Time Complexity: O(V)
	 * Space Complexity: O(1)
	 * 
	 * Steps:
	 * 1. Initialize count to 0.
	 * 2. Loop through each row of the adjacency matrix for the given vertex.
	 * 3. Increment count if there is an edge.
	 * 4. Return the count.
	 */
	@Override
	public final int inDegree(int vertice) {
		int count = 0;
		for (int i = 1; i < vertices_size; i++) {
			count += graph[i][vertice] != 0 ? 1 : 0;
		}
		return count;
	}

	/**
	 * Calculates the out-degree of a vertex.
	 * 
	 * @param vertice The vertex.
	 * @return The out-degree of the vertex.
	 * Time Complexity: O(V)
	 * Space Complexity: O(1)
	 * 
	 * Steps:
	 * 1. Call the degree method for the given vertex.
	 * 2. Return the result.
	 */
	@Override
	public final int outDegree(int vertice) {
		return degree(vertice);
	}

	/**
	 * Returns the size of the graph.
	 * 
	 * @return The number of vertices in the graph.
	 * Time Complexity: O(1)
	 * Space Complexity: O(1)
	 * 
	 * Steps:
	 * 1. Return vertices_size - 1.
	 */
	@Override
	public final int size() {
		return vertices_size - 1;
	}

	/**
	 * Performs Breadth-First Search (BFS) starting from a given vertex.
	 * 
	 * @param vertice The starting vertex.
	 * Time Complexity: O(V^2)
	 * Space Complexity: O(V)
	 * 
	 * Steps:
	 * 1. Check if the graph is empty or the vertex is not found.
	 * 2. Initialize a queue and a visited array.
	 * 3. Mark the starting vertex as visited and add it to the queue.
	 * 4. Call the traversal method with the queue and visited array.
	 * 5. Print a new line.
	 */
	@Override
	public void bfs(int vertice) {
		if (graph.length == 0 || vertice >= graph.length) {
			System.out.println("Graph is empty or vertice is not found!!");
			return;
		}

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[graph.length];
		visited[vertice] = true;
		queue.add(vertice);
		traversal(queue, visited);
		System.out.println();
	}

	/**
	 * Traverses the entire graph using BFS.
	 * Time Complexity: O(V^2)
	 * Space Complexity: O(V)
	 * 
	 * Steps:
	 * 1. Check if the graph is empty.
	 * 2. Initialize a queue and a visited array.
	 * 3. Loop through each vertex.
	 * 4. If the vertex is not visited, mark it as visited and add it to the queue.
	 * 5. Call the traversal method with the queue and visited array.
	 * 6. Print a new line.
	 */
	@Override
	public void traverse_Complete_graph() {
		if (graph.length == 0) {
			System.out.println("Graph is empty !!");
			return;
		}

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[graph.length];

		for (int i = 1; i < visited.length; i++) {
			if (!visited[i]) {
				queue.add(i);
				visited[i] = true;
				traversal(queue, visited);
			}
		}
		System.out.println();
	}

	/**
	 * Performs Depth-First Search (DFS) starting from a given vertex.
	 * 
	 * @param vertice The starting vertex.
	 * Time Complexity: O(V^2)
	 * Space Complexity: O(V)
	 * 
	 * Steps:
	 * 1. Check if the graph is empty or the vertex is not found.
	 * 2. Initialize a visited array.
	 * 3. Mark the starting vertex as visited.
	 * 4. Call the helper method with the starting vertex and visited array.
	 * 5. Print a new line.
	 */
	@Override
	public void dfs(int vertice) {
		if (graph.length == 0 || vertice >= graph.length) {
			System.out.println("Graph is empty or vertice is not found!!");
			return;
		}

		boolean[] visited = new boolean[graph.length];
		visited[vertice] = true;
		helper(vertice, visited);
		System.out.println();
	}

	/**
	 * Helper method for BFS traversal.
	 * 
	 * @param queue   The queue used for BFS.
	 * @param visited The array to keep track of visited vertices.
	 * Time Complexity: O(V^2)
	 * Space Complexity: O(V)
	 * 
	 * Steps:
	 * 1. While the queue is not empty, do the following:
	 *    a. Poll the current vertex from the queue.
	 *    b. Print the current vertex.
	 *    c. Loop through each vertex.
	 *    d. If there is an edge and the vertex is not visited, mark it as visited and add it to the queue.
	 */
	private final void traversal(Queue<Integer> queue, boolean[] visited) {
		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + ", ");

			for (int i = 0; i < graph[current].length; i++) {
				if (graph[current][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}

	/**
	 * Helper method for DFS traversal.
	 * 
	 * @param vertice The current vertex.
	 * @param visited The array to keep track of visited vertices.
	 * Time Complexity: O(V^2)
	 * Space Complexity: O(V)
	 * 
	 * Steps:
	 * 1. Print the current vertex.
	 * 2. Loop through each vertex.
	 * 3. If there is an edge and the vertex is not visited, mark it as visited and call the helper method recursively.
	 */
	private final void helper(int vertice, boolean[] visited) {
		System.out.print(vertice + ", ");

		for (int i = 1; i < graph[vertice].length; i++) {
			if (graph[vertice][i] == 1 && !visited[i]) {
				visited[i] = true;
				helper(i, visited);
			}
		}
	}

	/**
	 * Adds a directed edge between two vertices.
	 * 
	 * @param vertice1 The first vertex.
	 * @param vertice2 The second vertex.
	 * Time Complexity: O(1)
	 * Space Complexity: O(1)
	 * 
	 * Steps:
	 * 1. Set graph[vertice1][vertice2] to 1.
	 */
	private final void add_directed_edge(int vertice1, int vertice2) {
		graph[vertice1][vertice2] = 1;
	}

	/**
	 * Adds an undirected edge between two vertices.
	 * 
	 * @param vertice1 The first vertex.
	 * @param vertice2 The second vertex.
	 * Time Complexity: O(1)
	 * Space Complexity: O(1)
	 * 
	 * Steps:
	 * 1. Set graph[vertice1][vertice2] to 1.
	 * 2. Set graph[vertice2][vertice1] to 1.
	 */
	private final void add_undirected_edge(int vertice1, int vertice2) {
		graph[vertice1][vertice2] = 1;
		graph[vertice2][vertice1] = 1;
	}

	/**
	 * Removes a directed edge between two vertices.
	 * 
	 * @param vertice1 The first vertex.
	 * @param vertice2 The second vertex.
	 * Time Complexity: O(1)
	 * Space Complexity: O(1)
	 * 
	 * Steps:
	 * 1. Set graph[vertice1][vertice2] to 0.
	 */
	private final void remove_directed_edge(int vertice1, int vertice2) {
		graph[vertice1][vertice2] = 0;
	}

	/**
	 * Removes an undirected edge between two vertices.
	 * 
	 * @param vertice1 The first vertex.
	 * @param vertice2 The second vertex.
	 * Time Complexity: O(1)
	 * Space Complexity: O(1)
	 * 
	 * Steps:
	 * 1. Set graph[vertice1][vertice2] to 0.
	 * 2. Set graph[vertice2][vertice1] to 0.
	 */
	private final void remove_undirected_edge(int vertice1, int vertice2) {
		graph[vertice1][vertice2] = 0;
		graph[vertice2][vertice1] = 0;
	}
}