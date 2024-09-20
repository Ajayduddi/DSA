package com.datastructures.arrays;

import java.util.Scanner;

public class Arrays {

    // Arrays are used to store multiple values in a single variable of same datatypes, instead of declaring separate variables for each value.

    // Arrays are mutable
    // All arrays are assigned by reference to the variable
    // only primitive datatypes are assigned by value and immutable
    // all Non-primitive datatypes are assigned by reference and default value is null

    /* Syntax
     * datatype[] variable_name = new datatype[size];
     * datatype[] variable_name = { value1, value2, .... };

      // only declaration
     * datatype variable_name[];
     * datatype[] variable_name;

      // Initialization to declaring variable
     * variable_name = new datatype[size];

     */

    public static void main(String[] args) {

        // here the reference variable 'roll_no' points to the array of 5 elements
        int[] roll_no = new int[5];

        int[] roll; //  declaration of the array. 'roll' is getting defined in the Stack.
        roll = new int[5]; // initialization : actually here the object being created in the memory(Heap).

        // in c/c++ array is stored in continuous memory
        // but in java array is not continuous , memory allocation is purely depends on the JVM
        // heap objects are not continuous


        // Access the array values using index
        System.out.println(roll[4]); // here access the 5th element at index 4

//        System.out.println(roll[5]); // here we get ArrayIndexOutOfBounds Error because we're accessing the 6th element but the array size is 5

        // Access and pass the value into the array
        roll_no[0] = 10;
        roll_no[1] = 20;
        roll_no[2] = 30;
        roll_no[3] = 40;
        roll_no[4] = 50;

        System.out.println();
        // print the array values using forEach
        for(int i:roll_no){
            System.out.print(i+",");
        }

        String[] names = new String[4];
        Scanner in = new Scanner(System.in);

        System.out.println("\nEnter some names: ");
        // read input from the user
        for (int i = 0; i<names.length; i++){
            names[i] = in.nextLine();
        }

        // print names
        System.out.println(java.util.Arrays.toString(names));

    }
}
