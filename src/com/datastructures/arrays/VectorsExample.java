package com.datastructures.arrays;

import java.util.Collections;
import java.util.Vector;

public class VectorsExample {

    // Similar to Arrays, Vector are another kind of data structure that is used for storing information
    // Using Vector, we can implement a dynamic array.
    // Vector are dynamically allocated, and therefore, they provide efficient memory allocation
    // It is a Collection framework store only the objects (reference types). so we pass the Wrapper classes as Type
    // Wrapper Class will be used to convert primitive data types into objects and vice Versa

    // syntax
    /*
     *  Vector<Type> = new Vector<>(size) ;
     *  Vector<Type> = new Vector<>() ;
     *
     */

    public static void main(String[] args) {
        Vector<Integer> list = new Vector<>(10);

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

        // print the capacity of the ArrayList
        System.out.println("capacity:"+ list.capacity());

        // print the current size of the ArrayList
        System.out.println("Size:"+ list.size());

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
