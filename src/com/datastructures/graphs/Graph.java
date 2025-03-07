package com.datastructures.graphs;

/**
 * Interface representing a graph data structure.
 */
public interface Graph {

    /**
     * Adds an edge between two vertices in the graph.
     *
     * @param vertice1 the first vertex
     * @param vertice2 the second vertex
     */
    void addEdge(int vertice1, int vertice2);

    /**
     * Removes an edge between two vertices in the graph.
     *
     * @param vertice1 the first vertex
     * @param vertice2 the second vertex
     */
    void removeEdge(int vertice1, int vertice2);

    /**
     * Displays the graph.
     */
    void display();

    /**
     * Checks if there is an edge between two vertices in the graph.
     *
     * @param vertice1 the first vertex
     * @param vertice2 the second vertex
     * @return true if there is an edge between the vertices, false otherwise
     */
    boolean checkEdge(int vertice1, int vertice2);

    /**
     * Returns the degree of a vertex in the graph.
     *
     * @param vertice the vertex
     * @return the degree of the vertex
     */
    int degree(int vertice);

    /**
     * Returns the in-degree of a vertex in the graph.
     *
     * @param vertice the vertex
     * @return the in-degree of the vertex
     */
    int inDegree(int vertice);

    /**
     * Returns the out-degree of a vertex in the graph.
     *
     * @param vertice the vertex
     * @return the out-degree of the vertex
     */
    int outDegree(int vertice);

    /**
     * Returns the number of vertices in the graph.
     *
     * @return the size of the graph
     */
    int size();
}
