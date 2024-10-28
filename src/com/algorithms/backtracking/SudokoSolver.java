// https://leetcode.com/problems/sudoku-solver/
package com.algorithms.backtracking;

import java.util.Arrays;

public class SudokoSolver {
    
    public static void main(String[] args) {
        // int[][] board = {
        //     {5,3,0,0,7,0,0,0,0},
        //     {6,0,0,1,9,5,0,0,0},
        //     {0,9,8,0,0,0,0,6,0},
        //     {8,0,0,0,6,0,0,0,3},
        //     {4,0,0,8,0,3,0,0,1},
        //     {7,0,0,0,2,0,0,0,6},
        //     {0,6,0,0,0,0,2,8,0},
        //     {0,0,0,4,1,9,0,0,5},
        //     {0,0,0,0,8,0,0,7,9}
        // };

        int[][] board = {
            { 0, 0, 9, 7, 4, 8, 0, 0, 0 },
            { 7, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 2, 0, 1, 0, 9, 0, 0, 0 },
            { 0, 0, 7, 0, 0, 0, 2, 4, 0 },
            { 0, 6, 4, 0, 1, 0, 5, 9, 0 },
            { 0, 9, 8, 0, 0, 0, 3, 0, 0 },
            { 0, 0, 0, 8, 0, 3, 0, 2, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 6 },
            { 0, 0, 0, 2, 7, 5, 9, 0, 0 }
        };
        solveSudoku(board, 0, 0);
    }
    
    /*
     * Each of the digits 1-9 must occur exactly once in each row.
     * Each of the digits 1-9 must occur exactly once in each column.
     * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
     */
    static public void solveSudoku(int[][] board, int row, int col) {
        // After find solution
        if (row == board.length) {
            display(board);
            return;
        }

        // last col of the row
        if (col == board.length) {
            solveSudoku(board, row + 1, 0);
            return;
        }

        //solve sudoko
        if (board[row][col] == 0) {
            for (int i = 1; i <= board.length; i++) {
                if (isSafe(board, row, col, i)) {
                    board[row][col] = i;
                    solveSudoku(board, row, col + 1);
                    board[row][col] = 0; // backtracking
                }
            }
        } else {
            solveSudoku(board, row, col + 1);
        }
    }
    
    static boolean isSafe(int[][] board, int row, int col, int num) {
        // check column and row  conflicts
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        
        // check sub-box conflicts
        int matrixStartRow = row - row % 3;
        int matrixStartCol = col - col % 3;
        for (int i = matrixStartRow; i < matrixStartRow + 3; i++) {
            for (int j = matrixStartCol; j < matrixStartCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
    
    static void display(int[][] board) {
        for (int[] list : board) {
            System.out.println(Arrays.toString(list));
        }
    }
}
