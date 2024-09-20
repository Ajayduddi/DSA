package com.ajay;

public class Reverse_number {
    public static void main(String[] args) {
        int n = 7673427;
        int ans = 0;

        while(n>0){
            int rem = n%10; //getting last digit
            ans = ans * 10 + rem;
            n /= 10; // removing last digit from number
        }

        System.out.println(ans);
    }
}
