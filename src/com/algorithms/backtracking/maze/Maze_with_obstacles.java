package com.algorithms.backtracking.maze;

public class Maze_with_obstacles {
    
    public static void main(String[] args) {

        // false : obstacle
        Boolean[][] maze = {
                { true, true, true },
                { true, false, true },
                { true, true, true },
        };

        pathRestrict(maze, 0, 0, new String());
    }
    
    
    /*
     * we have the large maze and we need to find all possible paths to reach the destination from start
     * we have obstacles in the maze
     * use recursion, permutations & combinations we can find all possible paths
     * we can move only in either rigth or down direction
     * 
     */
    static void pathRestrict(Boolean[][] maze, int row, int column, String ans) {
        // if reach the destination
        if (row == maze.length - 1 && column == maze[0].length - 1) {
            System.out.println(ans);
            return;
        }

        // if reach the obstacle
        // false : obstacle
        if (!maze[row][column]) {
            return;
        }

        if (row < maze.length - 1) {
            pathRestrict(maze, row + 1, column, ans+'D');
        }
        if (column < maze[0].length - 1) {
            pathRestrict(maze, row, column + 1, ans+'R');
        }

    }
}
