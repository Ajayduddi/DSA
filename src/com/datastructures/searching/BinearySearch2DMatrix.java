package com.datastructures.searching;
// bineary search is only applyed on sorted 2D matrix

import java.util.Arrays;

public class BinearySearch2DMatrix {
    
    public static void main(String[] args) {
        int[][] partiallyMatrix = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 28, 29, 37, 49 },
                { 33, 34, 38, 50 }
        };

        int[][] fullyMatrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        System.out.println("Ans Of Partially Sorted Matrix: " + Arrays.toString(partiallySortedMatrix(partiallyMatrix, 37)));
        System.out.println("Ans Of Fully Sorted Matrix: " + Arrays.toString(fullySortedMatrix(fullyMatrix, 15)));
    }
    
    // find the row and column index of the target element
    // matrix is sorted in row and col wise manner
    /*
     * First select the first element from the first row & last element from the first row
     * then compare the last element with the target element. if it is equal to target return index
     * if it is greater than the target element then col--;
     * if it is less than the target element then row++;
     * repeat till row <= last row & col >= 0;
     * 
     * O(m+n)
     */
    static int[] partiallySortedMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {

            if (matrix[row][col] == target) {
                return new int[] { row, col };
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }

        }

        return new int[] { -1, -1 };
    }

    // Method 1 : Fully sorted matrix
    /*
     * First find the 'row' where the target element is present in the range. if we cann't find return [-1,-1]. 
     * For that, first select the first row and last row. then find mid row.
     * then the mid row first element <= target & last element >= target. we apply bineary search to that row.
     * if last element < target then rowStart = mid+1;
     * if first element > target then rowEnd = mid-1;
     * repete until rowStart <= rowEnd;
     * 
     * O(log(n) + log(m))
     */
    static int[] fullySortedMatrix(int[][] matrix, int target) {
        int rowStart = 0, rowEnd = matrix.length - 1;

        while (rowStart <= rowEnd) {
            int midrow = rowStart + (rowEnd - rowStart) / 2;
            int colSize = matrix[midrow].length - 1;

            if (matrix[midrow][0] <= target && matrix[midrow][colSize] >= target) {
                // apply bineary search to select row

                int start = 0;
                int end = colSize;

                while (start <= end) {
                    int mid = start + (end - start) / 2;

                    if (matrix[midrow][mid] == target)
                        return new int[] { midrow, mid };
                    else if (matrix[midrow][mid] > target)
                        end = mid - 1;
                    else
                        start = mid + 1;
                }

                return new int[] { -1, -1 };
            } else if (matrix[midrow][colSize] < target) {
                rowStart = midrow + 1;
            } else {
                rowEnd = midrow - 1;
            }
        }

        return new int[] { -1, -1 };
    }
    
    
}
