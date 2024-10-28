package com.math;

public class BinearySearchSqrt {
    public static void main(String[] args) {
        System.out.println(sqrt(222222222,5));
    }
    
    static double sqrt(long n, int p) {
        long start = 0;
        long end = n;

        while (start < end) {
            long mid = (long) (start + (end - start) / 2);

            if (mid * mid <= n)
                start = mid + 1;
            else
                end = mid - 1;
        }
        
        double root = end;
        double inc = 0.1;
        for (int i = 0; i < p; i++) {
            while (root * root <= n) {
                root += inc;
            }
            
            root -= inc;
            inc /= 10;
        }        

        return root;

    }
}
