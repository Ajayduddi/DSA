package com.datastructures.recursion;

public class NumbersRecursion {

    public static void main(String[] args) {
        print(1);
    }

    // use recursion to print first 5 integers
    static void print(int n){

        // base condition to stop the recursion
        // if base condition is not used then the memory limit exceeds at some moment and give he stack overflow error
        if(n == 5){
            System.out.println(n);
            return;
        }

        System.out.println(n);
        // this is tail recursion
        // because this is the last function call after that we can ot perform any operation.
        print(n+1);
        // if function is calling itself again and again. it will be treated as each call as a separate call in the stack.
        // each function call has its own memory
    }
}
