package com.datastructures.graphs;

/**
 * Interface representing graph traversal algorithms.
 */
public interface Graph_Traversal {

    /**
     * Performs a breadth-first search (BFS) starting from the specified vertex.
     *
     * @param vertice the starting vertex for the BFS traversal
     */
    void bfs(int vertice);

    /**
     * Traverses the entire graph using an appropriate traversal algorithm.
     */
    void traverse_Complete_graph();

    /**
     * Performs a depth-first search (DFS) starting from the specified vertex.
     *
     * @param vertice the starting vertex for the DFS traversal
     */
    void dfs(int vertice);

}