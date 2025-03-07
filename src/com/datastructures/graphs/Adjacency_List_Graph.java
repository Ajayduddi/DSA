package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This class represents a graph using an adjacency list.
 */
public class Adjacency_List_Graph implements Graph, Graph_Traversal {
    private List<List<Integer>> graph;
    private boolean isDirected;

    /**
     * Default constructor for an undirected graph.
     */
    public Adjacency_List_Graph() {
        this.graph = new ArrayList<>();
    }

    /**
     * Constructor for a graph with specified direction.
     * 
     * @param isDirected true if the graph is directed, false otherwise.
     */
    public Adjacency_List_Graph(boolean isDirected) {
        this.isDirected = isDirected;
        this.graph = new ArrayList<>();
    }

    /**
     * Adds a new vertex to the graph.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * Step-by-step:
     * 1. Create a new empty list to represent the edges of the new vertex.
     * 2. Add this list to the graph.
     */
    public final void addVertice() {
        graph.add(new ArrayList<>());
    }

    /**
     * Removes a vertex from the graph.
     * 
     * @param vertice the vertex to be removed.
     * 
     * Time Complexity: O(V + E)
     * Space Complexity: O(1)
     * 
     * Step-by-step:
     * 1. Remove the list of edges associated with the vertex.
     * 2. Iterate through each list in the graph.
     * 3. Remove any occurrence of the vertex in these lists.
     */
    public final void removeVertice(int vertice) {
        graph.remove(vertice - 1);
        for (List<Integer> integers : graph) {
            integers.remove(Integer.valueOf(vertice - 1));
        }
    }

    /**
     * Adds an edge between two vertices.
     * 
     * @param vertice1 the first vertex.
     * @param vertice2 the second vertex.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * Step-by-step:
     * 1. Check if the graph is directed.
     * 2. If directed, add a directed edge.
     * 3. If undirected, add an undirected edge.
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
     * @param vertice1 the first vertex.
     * @param vertice2 the second vertex.
     * 
     * Time Complexity: O(V)
     * Space Complexity: O(1)
     * 
     * Step-by-step:
     * 1. Check if the graph is directed.
     * 2. If directed, remove the directed edge.
     * 3. If undirected, remove the undirected edge.
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
     * Displays the graph.
     * 
     * Time Complexity: O(V + E)
     * Space Complexity: O(1)
     * 
     * Step-by-step:
     * 1. Iterate through each vertex in the graph.
     * 2. Print the vertex number.
     * 3. Iterate through the edges of the vertex.
     * 4. Print each connected vertex.
     */
    @Override
    public final void display() {
        for (int i = 0; i < graph.size(); i++) {
            System.out.print((i + 1) + " : ");
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(graph.get(i).get(j) + 1 + ", ");
            }
            System.out.println();
        }
    }

    /**
     * Checks if there is an edge between two vertices.
     * 
     * @param vertice1 the first vertex.
     * @param vertice2 the second vertex.
     * @return true if there is an edge, false otherwise.
     * 
     * Time Complexity: O(V)
     * Space Complexity: O(1)
     * 
     * Step-by-step:
     * 1. Get the list of edges for the first vertex.
     * 2. Check if the second vertex is in this list.
     * 3. Return true if found, false otherwise.
     */
    @Override
    public final boolean checkEdge(int vertice1, int vertice2) {
        return graph.get(vertice1 - 1).contains(vertice2 - 1);
    }

    /**
     * Returns the degree of a vertex.
     * 
     * @param vertice the vertex.
     * @return the degree of the vertex.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * Step-by-step:
     * 1. Get the list of edges for the vertex.
     * 2. Return the size of this list.
     */
    @Override
    public final int degree(int vertice) {
        return graph.get(vertice - 1).size();
    }

    /**
     * Returns the in-degree of a vertex.
     * 
     * @param vertice the vertex.
     * @return the in-degree of the vertex.
     * 
     * Time Complexity: O(V)
     * Space Complexity: O(1)
     * 
     * Step-by-step:
     * 1. Initialize a counter to zero.
     * 2. Iterate through each list in the graph.
     * 3. Increment the counter if the vertex is found in the list.
     * 4. Return the counter.
     */
    @Override
    public final int inDegree(int vertice) {
        int count = 0;
        for (List<Integer> e : graph) {
            count += e.contains(vertice - 1) ? 1 : 0;
        }
        return count;
    }

    /**
     * Returns the out-degree of a vertex.
     * 
     * @param vertice the vertex.
     * @return the out-degree of the vertex.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * Step-by-step:
     * 1. Call the degree method for the vertex.
     * 2. Return the result.
     */
    @Override
    public final int outDegree(int vertice) {
        return degree(vertice);
    }

    /**
     * Returns the size of the graph.
     * 
     * @return the number of vertices in the graph.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * Step-by-step:
     * 1. Return the size of the graph list.
     */
    @Override
    public final int size() {
        return graph.size();
    }

    /**
     * Performs Breadth-First Search (BFS) starting from a vertex.
     * 
     * @param vertice the starting vertex.
     * 
     * Time Complexity: O(V + E)
     * Space Complexity: O(V)
     * 
     * Step-by-step:
     * 1. Check if the graph is empty or the vertex is out of bounds.
     * 2. Initialize a queue and a visited array.
     * 3. Add the starting vertex to the queue and mark it as visited.
     * 4. Call the traversal method with the queue and visited array.
     */
    @Override
    public final void bfs(int vertice) {
        if (graph.isEmpty() || vertice > size()) {
            System.out.println("Graph is empty or vertex not found!!");
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[size()];
        queue.add(vertice - 1);
        visited[vertice - 1] = true;
        traversal(queue, visited);
        System.out.println();
    }

    /**
     * Traverses the entire graph using BFS.
     * 
     * Time Complexity: O(V + E)
     * Space Complexity: O(V)
     * 
     * Step-by-step:
     * 1. Check if the graph is empty.
     * 2. Initialize a queue and a visited array.
     * 3. Iterate through each vertex.
     * 4. If the vertex is not visited, add it to the queue and mark it as visited.
     * 5. Call the traversal method with the queue and visited array.
     */
    @Override
    public final void traverse_Complete_graph() {
        if (graph.isEmpty()) {
            System.out.println("Graph is empty !!");
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[size()];

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                queue.add(i);
                visited[i] = true;
                traversal(queue, visited);
            }
        }
        System.out.println();
    }

    /**
     * Performs Depth-First Search (DFS) starting from a vertex.
     * 
     * @param vertice the starting vertex.
     * 
     * Time Complexity: O(V + E)
     * Space Complexity: O(V)
     * 
     * Step-by-step:
     * 1. Check if the graph is empty or the vertex is out of bounds.
     * 2. Initialize a visited array.
     * 3. Mark the starting vertex as visited.
     * 4. Call the helper method with the starting vertex and visited array.
     */
    @Override
    public final void dfs(int vertice) {
        if (vertice > size() || graph.isEmpty()) {
            System.out.println("Graph is Empty or vertice is not found!!");
            return;
        }

        boolean[] visited = new boolean[size()];
        visited[vertice - 1] = true;
        helper(vertice - 1, visited);
        System.out.println();
    }

    /**
     * Helper method for BFS traversal.
     * 
     * @param queue the queue used for BFS.
     * @param visited the visited array.
     * 
     * Time Complexity: O(V + E)
     * Space Complexity: O(V)
     * 
     * Step-by-step:
     * 1. While the queue is not empty, repeat steps 2-5.
     * 2. Remove the front element from the queue.
     * 3. Print the current vertex.
     * 4. Iterate through the neighbors of the current vertex.
     * 5. If a neighbor is not visited, add it to the queue and mark it as visited.
     */
    private final void traversal(Queue<Integer> queue, boolean[] visited) {
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print((current + 1) + ", ");

            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    /**
     * Helper method for DFS traversal.
     * 
     * @param vertice the current vertex.
     * @param visited the visited array.
     * 
     * Time Complexity: O(V + E)
     * Space Complexity: O(V)
     * 
     * Step-by-step:
     * 1. Get the list of edges for the current vertex.
     * 2. Print the current vertex.
     * 3. Iterate through the neighbors of the current vertex.
     * 4. If a neighbor is not visited, mark it as visited and call the helper method recursively.
     */
    private final void helper(int vertice, boolean[] visited) {
        List<Integer> current = graph.get(vertice);
        System.out.print((vertice + 1) + ", ");

        for (Integer neighbor : current) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                helper(neighbor, visited);
            }
        }
    }

    /**
     * Adds a directed edge between two vertices.
     * 
     * @param vertice1 the first vertex.
     * @param vertice2 the second vertex.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * Step-by-step:
     * 1. Get the list of edges for the first vertex.
     * 2. Add the second vertex to this list.
     */
    private final void add_directed_edge(int vertice1, int vertice2) {
        graph.get(vertice1 - 1).add(vertice2 - 1);
    }

    /**
     * Adds an undirected edge between two vertices.
     * 
     * @param vertice1 the first vertex.
     * @param vertice2 the second vertex.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * Step-by-step:
     * 1. Get the list of edges for the first vertex.
     * 2. Add the second vertex to this list.
     * 3. Get the list of edges for the second vertex.
     * 4. Add the first vertex to this list.
     */
    private final void add_undirected_edge(int vertice1, int vertice2) {
        graph.get(vertice1 - 1).add(vertice2 - 1);
        graph.get(vertice2 - 1).add(vertice1 - 1);
    }

    /**
     * Removes a directed edge between two vertices.
     * 
     * @param vertice1 the first vertex.
     * @param vertice2 the second vertex.
     * 
     * Time Complexity: O(V)
     * Space Complexity: O(1)
     * 
     * Step-by-step:
     * 1. Get the list of edges for the first vertex.
     * 2. Remove the second vertex from this list.
     */
    private final void remove_directed_edge(int vertice1, int vertice2) {
        graph.get(vertice1 - 1).remove(Integer.valueOf(vertice2 - 1));
    }

    /**
     * Removes an undirected edge between two vertices.
     * 
     * @param vertice1 the first vertex.
     * @param vertice2 the second vertex.
     * 
     * Time Complexity: O(V)
     * Space Complexity: O(1)
     * 
     * Step-by-step:
     * 1. Get the list of edges for the first vertex.
     * 2. Remove the second vertex from this list.
     * 3. Get the list of edges for the second vertex.
     * 4. Remove the first vertex from this list.
     */
    private final void remove_undirected_edge(int vertice1, int vertice2) {
        graph.get(vertice1 - 1).remove(Integer.valueOf(vertice2 - 1));
        graph.get(vertice2 - 1).remove(Integer.valueOf(vertice1 - 1));
    }
}
