package com.datastructures.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MultiDimensionalArray {

    /* Syntax
     * datatype[][] variable_name = new datatype[size][size];
     * datatype[][] variable_name = { (value1, value2, .... },{value1, value2, ....} };

      // only declaration
     * datatype variable_name[][];
     * datatype[][] variable_name;

      // Initialization to declaring variable
     * variable_name = new datatype[size][size];

     */

    /*
        1,2,3
        4,5,6
        7,8,9
     */

    public static void main(String[] args) {

        // 2D Array
        int[][] arr2D = {
                {1,2,3,4},
                {5,6,7,8}
        };

        // print the array
        for (int row =0;row<arr2D.length;row++){
            for (int col=0;col<arr2D[row].length;col++){
                System.out.print(arr2D[row][col]+" ");
            }
            System.out.println();
        }

        int newarr[][] = new int[3][3];
        Scanner in = new Scanner(System.in);
        // insert input to the 2D array
        System.out.println("Enter 2D array 3*3:");
        for (int row=0;row<newarr.length;row++){
            for(int col=0;col<newarr[row].length;col++){
                newarr[row][col] = in.nextInt();
            }
        }

        // print the reading input
        for(int[] row:newarr){
            for (int element:row){
                System.out.print(element+" ");
            }
            System.out.println();
        }

        // print using toString()
        for(int[] a:newarr){
            System.out.println(Arrays.toString(a));
        }

//        System.out.println("\nmemory address of newarr"+ newarr);
    }
}
