package com.algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {
    
    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];
        System.out.println("No of solutions : " + nqueen(0, board, new ArrayList<>()));
    }
    
    /*
     * Then 8-Queens Problem is to place eight queens on an 8 x 8 chessboard 
     * so that no two “attack”, that is, no two of them are on the same row, column, or diagonal. 
     * All solutions to the 8-queens problem can be represented as 8-tuples (x1, . . . . , x8),  
     * where xi  is the column of the ith row where the ith queen is placed. 
     * no two xi‟s can be the same (i.e., all queens must be on different columns) and no two queens can be on the same diagonal.
     * 
     * Column Conflicts: Two queens conflict if their xi  values are identical. 
     * Diagonal Conflicts: Two queens conflict if their xi  values are on the same diagonal.
     * 
     * Tip : to check diagonal conflicts, case (i, j) = (3, 1) and (k, l) = (8, 6). Therefore: 
     * abs(i - k) == abs(j - l)  :  | 1 - 6 | == | 3 - 8 | : 5 = 5 
     * if above condition is true, then the two queens are in same diagonal.
     * 
     */
    static int nqueen(int row, boolean[][] board, List<List<Integer>> ans) {
        // base condition ( find ans )
        if (row == board.length) {
            display(board);
            System.out.println(ans);
            System.out.println();
            return 1;
        }

        // to count the number of solutions
        int count = 0;

        for (int col = 0; col < board.length; col++) {
            if (isSafe(row, col, ans)) {
                // place queen
                board[row][col] = true;
                ans.add(Arrays.asList(row, col));

                count += nqueen(row + 1, board, ans);

                // backtracking
                board[row][col] = false;
                ans.remove(ans.size() - 1);
            }
        }

        return count;
    }
    
    static boolean isSafe(int row, int col, List<List<Integer>> ans) {
        // check column confilict
        for (List<Integer> list : ans) {
            if (list.get(1) == col) {
                return false;
            }
        }

        // check diagonal confilict
        for (List<Integer> list : ans) {
            if (Math.abs(list.get(0) - row) == Math.abs(list.get(1) - col)) {
                return false;
            }
        }

        return true;
    }
    
    static void display(boolean[][] board) {
        for (boolean[] list : board) {
            for (boolean b : list) {
                if (b) {
                    System.out.print("Q ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }
}


/*
 *  Algorithm : 
 * 
 * Step 1: Add to the sequence the next number in the sequence 1, 2, . . . , 8 not yet used. 
 * 
 * Step 2: If this new sequence is feasible and has length 8 then STOP with a solution. 
 * If the new sequence is feasible and has length less then 8, repeat Step 1. 
 * 
 * Step 3: If the sequence is not feasible, then backtrack through the sequence until 
 * we find the most recent place at which we can exchange a value. Go back to Step 1
 * 
 */