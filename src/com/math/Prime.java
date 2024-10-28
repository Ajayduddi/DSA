package com.math;

public class Prime {
    public static void main(String[] args) {
        int num = 20;
        for (int i = 0; i <= num; i++) {
            System.out.println(i + " " + isPrime(i));
        }
    }

    static boolean isPrime(int num){
        /*
         * The prime number is divided by 1 and itSelf only
         * check the number from 0 to sqrt(N);
         */
        if(num <= 1) {
            return false;
        }

        int number = 2;
        while( number * number <= num){
            if(num % number == 0) {
                return false;
            }
            number++;
        }

        return true;
    }
}
