package com.datastructures.recursion;

import java.util.Arrays;

public class Bubblesort {

    public static void main(String[] args) {
        int[] arr = {2,3,4,2,3,6,4,5,3};
        bubbleSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    
    static void bubbleSort(int[] arr, int n) {
        if (n == 1) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        
        bubbleSort(arr, n-1);
    }
}