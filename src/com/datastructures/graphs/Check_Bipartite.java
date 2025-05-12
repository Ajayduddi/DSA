// https://www.naukri.com/code360/problems/check-bipartite-graph-_920551?leftPanelTabValue=PROBLEM

package com.datastructures.graphs;

import java.util.*;

public class Check_Bipartite {

    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {

        // 0 - not visited, 1 - set1, 2 - set2
        int[] colored = new int[edges.size()];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < edges.size(); i++) {
            for (int j = 0; j < edges.size(); j++) {
                if (colored[i] == 0 && edges.get(i).get(j) == 1) {
                    queue.add(i);
                    colored[i] = 1;
                    boolean res = helper(edges, queue, colored, 2, i);
                    if (!res) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    // check using bfs
    public static boolean helper(ArrayList<ArrayList<Integer>> edges, Queue<Integer> queue, int[] colored, int color, int i){

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int j = 0; j < size; j++){
                int vertice = queue.poll();
                for(int k = 0; k < edges.size(); k++){
                    if(edges.get(vertice).get(k) == 1 && colored[k] == 0){
                        colored[k] = color;
                        queue.add(k);
                    }

                    if(edges.get(vertice).get(k) == 1 && colored[k] != color){
                        return false;
                    }
                }
            }

            color = color == 1 ? 2 : 1;
        }


        return true;
    }
}