package com.datastructures.recursion;

import java.util.Arrays;

public class InsertionSort {
    
    public static void main(String[] args) {
        int[] arr = {2,3,4,2,3,6,4,5,3};
        insertionSort(arr, 0);
        System.out.println(Arrays.toString(arr));
    }
    
    static void insertionSort(int[] arr, int n) {
        if (n == arr.length - 1) {
            return;
        }

        for (int i = n + 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }
        }
        
        insertionSort(arr, n + 1);
    }
}
