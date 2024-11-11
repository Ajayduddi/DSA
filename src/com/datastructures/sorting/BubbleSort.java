package com.datastructures.sorting;

import java.util.Arrays;

public class BubbleSort {
    
    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 2, 1, 3,-1,-31 };
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    static void bubbleSort(int[] arr) {
        boolean swapped;
        // run steps n-1 times
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            // for each step, max item will be in the last respective index
            for (int j = 1; j < arr.length - i; j++) {
                // swap if the item is smaller than the previous item
                if (arr[j] < arr[j - 1]) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }

            // if no swap is occured for the particular value of i, It means the array is sorted hence stop the program
            if (!swapped) {
                break;
            }
        }
    }
}


// Time complexity:
/*
 * Best case : o(n)
 * Average case : o(n^2)
 * Worst case : o(n^2)
 */

 // Space complexity: O(1)

 // https://www.geeksforgeeks.org/bubble-sort-algorithm/

 //it supports stable sorting