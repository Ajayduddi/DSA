package com.datastructures.graphs;

public class Main {
    public static void main(String[] args) {
        Adjacency_Matrix_Graph matrix_graph = new Adjacency_Matrix_Graph(5); // by default, it takes undirected graph

        matrix_graph.addEdge(1, 2);
        matrix_graph.addEdge(1, 3);
        matrix_graph.addEdge(1, 5);
        matrix_graph.addEdge(2, 4);
        matrix_graph.addEdge(2, 5);
        matrix_graph.addEdge(3, 4);

        System.out.println("\nUndirected matrix graph");
        matrix_graph.display();
        System.out.println("Is there any edge between 2,4 : " + matrix_graph.checkEdge(2, 4));
        System.out.println("Is there any edge between 2,3 : " + matrix_graph.checkEdge(2, 3));
        System.out.println("Degree of vertice 5 : " + matrix_graph.degree(5));
        matrix_graph.bfs(3);
        matrix_graph.dfs(3);
        matrix_graph.traverse_Complete_graph();

        System.out.println();
        matrix_graph.removeEdge(1, 5);
        matrix_graph.display();
        System.out.println("Is there any edge between 2,4 : " + matrix_graph.checkEdge(2, 4));
        System.out.println("Is there any edge between 2,3 : " + matrix_graph.checkEdge(2, 3));
        System.out.println("Degree of vertice 5 : " + matrix_graph.degree(5));

        System.out.println("\n-------------------------------------------------------------------------------------------");
        // directed graph
        Adjacency_Matrix_Graph matrix_directed_graph = new Adjacency_Matrix_Graph(5, true);
        matrix_directed_graph.addEdge(1, 2);
        matrix_directed_graph.addEdge(1, 3);
        matrix_directed_graph.addEdge(1, 5);
        matrix_directed_graph.addEdge(2, 4);
        matrix_directed_graph.addEdge(2, 5);
        matrix_directed_graph.addEdge(3, 4);
        matrix_directed_graph.addEdge(5, 4);

        System.out.println("\nDirected matrix graph");
        matrix_directed_graph.display();
        System.out.println("Is there any edge between 2,4 : " + matrix_directed_graph.checkEdge(2, 4));
        System.out.println("Is there any edge between 2,3 : " + matrix_directed_graph.checkEdge(2, 3));
        System.out.println("Out Degree of vertice 5 : " + matrix_directed_graph.outDegree(5));
        System.out.println("In Degree of vertice 5 : " + matrix_directed_graph.inDegree(5));
        matrix_directed_graph.bfs(1);
        matrix_directed_graph.dfs(1);
        matrix_directed_graph.traverse_Complete_graph();

        System.out.println();
        matrix_directed_graph.removeEdge(1, 5);
        matrix_directed_graph.display();
        System.out.println("Is there any edge between 2,4 : " + matrix_directed_graph.checkEdge(2, 4));
        System.out.println("Is there any edge between 2,3 : " + matrix_directed_graph.checkEdge(2, 3));
        System.out.println("Out Degree of vertice 5 : " + matrix_directed_graph.outDegree(5));
        System.out.println("In Degree of vertice 5 : " + matrix_directed_graph.inDegree(5));

        System.out.println("\n-------------------------------------------------------------------------------------------");
        // undirected list graph
        Adjacency_List_Graph list_graph = new Adjacency_List_Graph();  // by default, it takes undirected graph
        list_graph.addVertice();
        list_graph.addVertice();
        list_graph.addVertice();
        list_graph.addVertice();
        list_graph.addVertice();

        list_graph.addEdge(1, 2);
        list_graph.addEdge(1, 3);
        list_graph.addEdge(2, 4);
        // list_graph.addEdge(2, 3);
        // list_graph.addEdge(4, 3);
        list_graph.addEdge(4, 5);

        System.out.println("\nUndirected list graph");
        list_graph.display();
        System.out.println("Is there any edge between 2,4 : " + list_graph.checkEdge(2, 4));
        System.out.println("Is there any edge between 2,3 : " + list_graph.checkEdge(2, 3));
        System.out.println("Degree of vertice 4 : " + list_graph.degree(4));
        list_graph.bfs(2);
        list_graph.dfs(2);
        list_graph.traverse_Complete_graph();

        System.out.println();
        list_graph.removeEdge(4,3);
        list_graph.display();
        System.out.println("Is there any edge between 2,4 : " + list_graph.checkEdge(2, 4));
        System.out.println("Is there any edge between 2,3 : " + list_graph.checkEdge(2, 3));
        System.out.println("Degree of vertice 4 : " + list_graph.degree(4));

        System.out.println();
        list_graph.removeVertice(4);
        list_graph.display();
        System.out.println("Is there any edge between 2,4 : " + list_graph.checkEdge(2, 4));
        System.out.println("Is there any edge between 2,3 : " + list_graph.checkEdge(2, 3));

        System.out.println("\n-------------------------------------------------------------------------------------------");
        // Directed list graph
        Adjacency_List_Graph list_directed_graph = new Adjacency_List_Graph(true);
        list_directed_graph.addVertice();
        list_directed_graph.addVertice();
        list_directed_graph.addVertice();
        list_directed_graph.addVertice();

        list_directed_graph.addEdge(1, 2);
        list_directed_graph.addEdge(1, 3);
        list_directed_graph.addEdge(2, 4);
        list_directed_graph.addEdge(2, 3);
        list_directed_graph.addEdge(4, 3);

        System.out.println("\nDirected list graph");
        list_directed_graph.display();
        System.out.println("Is there any edge between 2,4 : " + list_directed_graph.checkEdge(2, 4));
        System.out.println("Is there any edge between 2,3 : " + list_directed_graph.checkEdge(2, 3));
        System.out.println("Out Degree of vertice 2 : " + list_directed_graph.outDegree(2));
        System.out.println("In Degree of vertice 2 : " + list_directed_graph.inDegree(2));
        list_directed_graph.bfs(1);
        list_directed_graph.dfs(1);
        list_directed_graph.traverse_Complete_graph();

        System.out.println();
        list_directed_graph.removeEdge(2,3);
        list_directed_graph.display();
        System.out.println("Is there any edge between 2,4 : " + list_directed_graph.checkEdge(2, 4));
        System.out.println("Is there any edge between 2,3 : " + list_directed_graph.checkEdge(2, 3));
        System.out.println("Out Degree of vertice 2 : " + list_directed_graph.outDegree(2));
        System.out.println("In Degree of vertice 2 : " + list_directed_graph.inDegree(2));

        System.out.println();
        list_directed_graph.removeVertice(4);
        list_directed_graph.display();
        System.out.println("Is there any edge between 2,4 : " + list_directed_graph.checkEdge(2, 4));
        System.out.println("Is there any edge between 2,3 : " + list_directed_graph.checkEdge(2, 3));
        System.out.println("Out Degree of vertice 2 : " + list_directed_graph.outDegree(2));
        System.out.println("In Degree of vertice 2 : " + list_directed_graph.inDegree(2));
    }
}
