package com.datastructures.recursion;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1231));
    }
    
    public static boolean isPalindrome(int n) {
        return n == reverse(n);
    }

    public static int reverse(int n) {
        // total no of digits present in the number
        int digits = (int) (Math.log10(n)) + 1;
        int result = helper(n, digits);
        System.out.println("After reversing the number is : " + result);
        return result;
    }

    public static int helper(int n, int digits) {
        if (n % 10 == n) {
            return n;
        }
        /*
         * 1234
         * 4 * 10^3 + 123
         * 3 * 10^2 + 12
         * 2 * 10^1 + 1
         * 1 * 10*0 + 0
         * 
         * 4 * 10^3 + 3 * 10^2 + 2 * 10^1 + 1
         */
        return (n % 10) * (int) (Math.pow(10, digits - 1)) + helper(n / 10, digits - 1);
    }
}
