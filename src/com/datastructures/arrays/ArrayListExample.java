package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExample {

    // Similar to Arrays, ArrayList are another kind of data structure that is used for storing information
    // Using ArrayList, we can implement a dynamic array.
    // ArrayList are dynamically allocated, and therefore, they provide efficient memory allocation
    // The difference between a built-in array and an ArrayList in Java, is that the size of an array cannot be modified but size of the ArrayList was Dynamically.
    // It is a Collection framework store only the objects (reference types). so we pass the Wrapper classes as Type
    // Wrapper Class will be used to convert primitive data types into objects and vice Versa

    // syntax
    /*
    *  ArrayList<Type> = new ArrayList<>(size) ;
    *  ArrayList<Type> = new ArrayList<>() ;
    *
    */

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(3);

        // Adding element to ArrayList
        list.add(10);
        list.add(30);
        list.add(33535);
        list.add(46363);
        list.add(63463636);

        // print the list
        System.out.println("ArrayList Elements: "+list); // Internally calls the toString method to the object

        // get the particular index element from the array List using get() method
        System.out.println("1st Element: "+list.get(0));
        System.out.println("2nd Element: "+list.get(1));

        // modify the particular element from the ArrayList using set() method
        list.set(0,100);
        System.out.println("1st Element after modification: "+ list.get(0));

        // Remove element from the ArrayList
        list.remove(4);
        System.out.println("After Removing: "+ list);

        // print the current Size of the ArrayList
        System.out.println("Size: "+ list.size());

        // sorting the ArrayList
        Collections.sort(list);
        // implement for loop
        for(int a:list){
            System.out.print(a+" ");
        }

        // Remove all the elements from the ArrayList
        list.clear();
        System.out.println("\nAfter clearing the list: "+ list);
    }
}
