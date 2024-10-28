package com.datastructures.recursion;

public class Counting {
    public static void main(String[] args) {
        // counting no of 0's
        System.out.println(count(1000000));
    }
    
    static int count(int n) {
        return helper(n,0);
    }

    static int helper(int n, int steps) {
        if (n == 0) {
            return steps;
        }

        if (n % 10 == 0) {
            return helper(n / 10, ++steps);
        }

        return helper(n / 10, steps);
    }
}
