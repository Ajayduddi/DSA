package com.algorithms.backtracking;

public class KNights {

    public static void main(String[] args) {
        boolean[][] board = new boolean[3][3];
        knights(board, 0, 0, 4);
    }
    
    /*
     * Then k-Nights Problem is to place eight queens on an 8 x 8 chessboard, so that no two “attack”
     */
    static void knights(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            display(board);
            System.out.println();
            return;
        }

        // last row and last column
        if (row == board.length - 1 && col == board.length) {
            return;
        }

        // if i am in last column in the row
        if (col == board.length) {
            knights(board, row + 1, 0, knights);
            return;
        }

        // place knight
        if (isSafe(board, row, col)) {
            board[row][col] = true;
            knights(board, row, col + 1, knights - 1);
            board[row][col] = false; // backtracking
        }

        // move to right
        knights(board, row, col + 1, knights);
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        // check confilicts
        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }
        
        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }
        
        if (isValid(board, row + 1, col + 2)) {
            if (board[row + 1][col + 2]) {
                return false;
            }
        }
        
        if (isValid(board, row + 1, col - 2)) {
            if (board[row + 1][col - 2]) {
                return false;
            }
        }
        
        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }
        
        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }
        
        if (isValid(board, row + 2, col + 1)) {
            if (board[row + 2][col + 1]) {
                return false;
            }
        }
        
        if (isValid(board, row + 2, col - 1)) {
            if (board[row + 2][col - 1]) {
                return false;
            }
        }
        
        
        return true;
    }

    // check i am in board or not
    static boolean isValid(boolean[][] board, int row, int col) {
        if (row >=0 && row < board.length && col >=0 && col < board[row].length) {
            return true;
        }
        return false;
    }
    
    static void display(boolean[][] board) {
        for (boolean[] list : board) {
            for (boolean b : list) {
                if (b) {
                    System.out.print("K ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }
}