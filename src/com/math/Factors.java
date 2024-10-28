package com.math;

import java.util.ArrayList;

public class Factors {
    
    public static void main(String[] args) {
        factor3(1000000);
    }
    
    // o(n)
    static void factor1(long n) {
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }
    
    // o(sqrt(n))
    static void factor2(long n) {
        for (int i = 1; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                System.out.print(i + " " + n / i + " ");
            }
        }
    }
    
    // Both time an space complexity are o(sqrt(n))
    static void factor3(long n) {
        ArrayList<Long> arr = new ArrayList<>();

        for (int i = 1; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + " ");
                    arr.add(n / i);
                }
            }
        }

        for (int i = arr.size() - 1; i >= 0; i--) {
            System.out.print(arr.get(i)+" ");
        }
    }
}
