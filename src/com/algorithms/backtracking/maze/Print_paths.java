package com.algorithms.backtracking.maze;

public class Print_paths {
    
    public static void main(String[] args) {
        int[][] maze = new int[3][3];
        print_paths(maze);
        print_paths_includes_diagonal(maze);
    }
    
    /*
     * we have the large maze and we need to find all possible paths to reach the destination from start
     * use recursion, permutations & combinations we can find all possible paths
     * start - (3,3) end - (1,1) maze - 3x3 matrix
     * we can move only in either rigth ( R ) or down ( D ) direction
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
    public static void print_paths(int[][] maze) {
        int row = maze.length;
        int column = maze[0].length;

        System.out.println(
                "Total No of paths available from start to destination : " + helper(row, column, new String()));
    }
    
    // if we cam moves diagonally
    public static void print_paths_includes_diagonal(int[][] maze) {
        int row = maze.length;
        int column = maze[0].length;

        System.out.println();
        System.out.println( "Total No of paths available from start to destination : " + helper_diagonal(row, column, new String()));
    }
    
    
    public static int helper(int row, int column, String ans) {
        // if we reach the last row or last column then we have single path to reach the end 
        if (row == 1 || column == 1) {
            // if we reach the last row
            if (column > 1) {
                return helper(row, column - 1, ans + 'R');
            }
            // if we reach the last column
            else if (row > 1) {
                return helper(row - 1, column, ans + 'D');
            }
            // if we reach destination 
            else {
                System.out.println(ans);
                return 1;
            }
        }

        return helper(row - 1, column, ans + 'D') + helper(row, column - 1, ans + 'R');
    }
    
    public static int helper_diagonal(int row, int column, String ans) {
        // if we reach the last row or last column then we have single path to reach the end 
        if (row == 1 || column == 1) {
            // if we reach the last row
            if (column > 1) {
                return helper_diagonal(row, column - 1, ans + 'H');
            }
            // if we reach the last column
            else if (row > 1) {
                return helper_diagonal(row - 1, column, ans + 'V');
            }
            // if we reach destination 
            else {
                System.out.println(ans);
                return 1;
            }
        }


        
        return helper_diagonal(row - 1, column, ans + 'V') + helper_diagonal(row - 1, column - 1, ans + 'D')
                + helper_diagonal(row, column - 1, ans + 'H');
    }
}
