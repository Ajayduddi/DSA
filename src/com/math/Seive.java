package com.math;

public class Seive {
    
    public static void main(String[] args) {
        int n = 40;
        boolean[] arr = new boolean[n + 1];
        prime(n, arr);
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == false) {
                System.out.print(i+ " ");
            }
        }
    }
    
    // false in array means number is prime
    static void prime(int n, boolean[] arr) {
        for (int i = 2; i*i <=n ; i++) {
            if (!arr[i]) {
                for (int j = i*2 ; j < arr.length; j+=i ) {
                    arr[j] = true;
                }
            }
        }
    }
}
