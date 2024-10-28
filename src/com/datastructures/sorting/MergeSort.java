package com.datastructures.sorting;

import java.util.Arrays;

public class MergeSort {
    
    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 2, 1, 9, 4, 7, 6 };
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    
    static void mergeSort(int[] arr, int start, int end) {
        if (start == end) {
            return;
        }

        int mid = start + (end - start) / 2;
        // apply divide and conquer
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }
    
    static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] >= arr[j]) {
                temp[k] = arr[j];
                j++;
                k++;
            } else {
                temp[k] = arr[i];
                k++;
                i++;
            }
        }
        
        // if first part is not empty
        while (i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }
        
        // if second part is not empty
        while (j <= end) {
            temp[k] = arr[j];
            k++;
            j++;
        }

        // copy sorted array into main array
        for (int k2 = 0; k2 < temp.length; k2++) {
            arr[k2+start] = temp[k2];
        }
    }
}
