package com.algorithms.backtracking.maze;

import java.util.Arrays;

public class Maze_with_backtracking {

    public static void main(String[] args) {
        Boolean[][] maze = {
                { true, true, true },
                { true, true, true },
                { true, true, true },
        };

        // print paths
        findAllPaths(maze, count, count, new String());
        System.out.println("Total No of paths available from start to destination : " + count);
        System.out.println();
        
        // print paths with matrix
        count = 0;
        findAllPaths(maze, count, count, new String(), new int[3][3], 1);
        System.out.println("Total No of paths available from start to destination : " + count);
    }


    /*
     * we have the large maze and we need to find all possible paths to reach the destination from start
     * we have obstacles in the maze
     * we can move in all 4 directions ( up, down, right, left )
     * use backtracking to find all possible paths
     * start - (0,0) end - (2,2) maze - 3x3 matrix
     * 
     */
    static int count;
    static void findAllPaths(Boolean[][] maze, int row, int column, String ans) {
        // if reach the destination
        if (row == maze.length - 1 && column == maze[0].length - 1) {
            System.out.println(ans);
            count++;
            return;
        }

        // if reach the obstacle
        // flase : obstacle
        if (!maze[row][column]) {
            return;
        }

        // I consider this block in my path
        maze[row][column] = false;

        if (row < maze.length - 1) {
            findAllPaths(maze, row + 1, column, ans + 'D'); // go down
        }

        if (column < maze[0].length - 1) {
            findAllPaths(maze, row, column + 1, ans + 'R'); // go right
        }

        if (row > 0) {
            findAllPaths(maze, row - 1, column, ans + 'U'); // go up
        }

        if (column > 0) {
            findAllPaths(maze, row, column - 1, ans + 'L'); // go left
        }

        // this line is where the function will be over
        // so, before function is getting removed from the stack, also remove the changes that are made in the function
        maze[row][column] = true;

    }
    
    // find all paths and also print matrix
    static void findAllPaths(Boolean[][] maze, int row, int column, String ans, int[][] matrix,int steps) {
        // if reach the destination
        if (row == maze.length - 1 && column == maze[0].length - 1) {
            matrix[row][column] = steps;
            for (int i = 0; i < matrix.length; i++) {
                System.out.println(Arrays.toString(matrix[i]));
            }
            System.out.println(ans);
            System.out.println();
            count++;
            return;
        }

        // if reach the obstacle
        // flase : obstacle
        if (!maze[row][column]) {
            return;
        }

        // I consider this block in my path
        maze[row][column] = false;
        matrix[row][column] = steps;

        if (row < maze.length - 1) {
            findAllPaths(maze, row + 1, column, ans + 'D', matrix, steps + 1); // go down
        }
        
        if (column < maze[0].length - 1) {
            findAllPaths(maze, row, column + 1, ans + 'R', matrix, steps + 1); // go right
        }
    
        if (row > 0) {
            findAllPaths(maze, row - 1, column, ans + 'U', matrix, steps + 1); // go up
        }

        if (column > 0) {
            findAllPaths(maze, row, column - 1, ans + 'L', matrix, steps + 1); // go left
        }

        // this line is where the function will be over
        // so, before function is getting removed from the stack, also remove the changes that are made in the function
        maze[row][column] = true;
        matrix[row][column] = 0;

    }
}
