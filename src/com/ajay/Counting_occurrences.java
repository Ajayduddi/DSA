package com.ajay;

public class Counting_occurrences {
    public static void main(String[] args) {

        int n = 23249824; // number
        int k = 2; // key to find

        int count = 0;

        while(n>0){

            int rem = n%10; // get last digit from the number

            if (rem == k){
                count++;
            }

            n = n/10; // removing last digit from the number

        }

        System.out.println("No of occurrences of " + k + " is : " + count);
    }
}


