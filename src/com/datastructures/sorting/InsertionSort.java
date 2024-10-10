package com.datastructures.sorting;

import java.util.Arrays;

public class InsertionSort {
    
    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 2, 1, 3,-1,-31, 8 };
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    static void insertionSort(int[] arr) {
        // run steps n-1 times
        for (int i = 0; i < arr.length - 1; i++) {
            // for each step , sort the LHS side of the array ( partially sorted sub array )
            for (int j = i+1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
                // this case will execute when the arr[j] < arr[j - 1] is false. it means the array is sorted hence stop the program
                else {
                    break;
                }
            }
        }
    } 
}


// time complexity:
/*
 * Best case : O(n)
 * Average case : O(n^2)
 * Worst case : O(n^2)
 */

// space complexity: O(1)
// https://www.gatevidyalay.com/insertion-sort-insertion-sort-algorithm/

// it supports stable sorting

// A stable sorting algorithm maintains the relative order of records with equal keys in a sorted list. This means that if two records have the same key and one appears before the other in the original list, they will also appear in the same order in the sorted list