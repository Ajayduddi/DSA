package com.algorithms.backtracking.maze;

public class Count_paths {

    public static void main(String[] args) {
        int[][]maze = new int[3][3];
        System.out.println("Total No of paths available from start to destination : " + count_paths(maze));
        System.out.println("Total No of paths available from start to destination includes diagonals : " + count_paths_includes_diagonal(maze));
    }

    /*
     * we have the large maze and we need to find all possible paths count to reach the destination from start
     * use recursion and combinations we can find all possible paths
     * start - (3,3) end - (1,1) maze - 3x3 matrix
     * we can move only in either rigth or down direction
     * 
     * For a 3×3 grid:
     * Moves down: 𝑚 − 1 = 2      # here m : row
     * Moves right: 𝑛 − 1 = 2      # here n : column
     * Total moves: 𝑚 + 𝑛 − 2 = 4
     * 
     *          3   2   1
     *     3    *
     *     2
     *     1            - 
     * 
     *      *  : start,  - : end
     */
    public static int count_paths(int[][] maze) {
        int row = maze.length;
        int column = maze[0].length;
        return helper(row, column);
    }

    // if we cam moves diagonally
    public static int count_paths_includes_diagonal(int[][] maze) {
        int row = maze.length;
        int column = maze[0].length;
        return helper_diagonal(row, column);
    }

    
    public static int helper(int row, int column) {
        // if we reach the last row or last column then we have single path to reach the end 
        // so we return 1
        if (row == 1 || column == 1) {
            return 1;
        }

        return helper(row - 1, column) + helper(row, column - 1);
    }
    
    public static int helper_diagonal(int row, int column) {
        // if we reach the last row or last column then we have single path to reach the end 
        // so we return 1
        if (row == 1 || column == 1) {
            return 1;
        }

        return helper_diagonal(row - 1, column) + helper_diagonal(row - 1, column - 1)
                + helper_diagonal(row, column - 1);
    }
}
