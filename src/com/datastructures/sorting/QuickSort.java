package com.datastructures.sorting;

import java.util.Arrays;

/**
 * QuickSort
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    
    static void quickSort(int[] arr,int start,int end) {
        if (start >= end) {
            return;
        }

        int pivot = arr[start];
        int i = start, j = end;

        while (i < j) {
            // check that the left part of the pivot is less than pivot value. if its not, we need to swap
            while (arr[i] < pivot) {
                i++;
            }

            // check that the right part of the pivot is greater than pivot value. if its not, we need to swap
            while (arr[j] > pivot) {
                j--;
            }

            // if i < j  means the the above two conditions are volited , so we need to swap
            if (i < j) {
                swap(arr, i, j);
            }
        }
        // After compliting the while loop above,the pivote value is placed at the correct position
        // so, we need to sort the left part and the right part of the pivot value
        quickSort(arr, start, i - 1);
        quickSort(arr, j + 1, end);
    }
    
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}