package com.math;

public class GCD_LCM {
    public static void main(String[] args) {
        System.out.println(gcd(20, 14234400));
        System.out.println(lcm(14234400, 20));
    }
    
    // euclidean algorithm for finding GCD or HCF
    static int gcd(int a, int b) {
        // b is the place that holds the remainder of gcd
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // gcd ( 100, 20 ) = gcd ( 20, 0 )
    // lcm* hcf = product of two numbers

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
