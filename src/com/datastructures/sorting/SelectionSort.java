package com.datastructures.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 2, 1, 3, -1, -31 };
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            
            // find the max index in the remaining array and swap it with the correct index
            int maxIndex = getMaxIndex(arr, 0, i);

            // swap the max index with the last index
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i]; 
            arr[i] = temp;
        }
    }

    private static int getMaxIndex(int[] arr, int start, int end) {
        int max =  start;
        for (int i = start; i <= end; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }

        return max;
    }
}

// Time complexity: For all cases :  O(n^2)
// Space complexity: O(1)

// https://www.gatevidyalay.com/selection-sort-selection-sort-algorithm/

// it does not support stable sorting