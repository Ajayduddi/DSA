package com.datastructures.recursion;

public class Fibonacci {

    // 0,1,1,2,5,8,13,21,34,55 .......
    // fib(n) = fib(n-1) + fib(n-2)
    public static void main(String[] args) {
        // find fibonacci series of 10th number
        System.out.println(findFibonacci(4));
    }

    // find fibonacci series from 1 to n positions
    static int findFibonacci(int n){
        // base condition
        if (n < 2) {
            return n;
        }

        // this is not tail recurssion because after last call we preform addition and return it.
        return findFibonacci(n-1) + findFibonacci(n-2);
    }
}
