package com.ajay;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        // 0,1,1,2,3,5,8,13,21....
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int n = in.nextInt();
        int a = 0;
        int b = 1;
        int count = 2;

        System.out.print(a+","+b);

        while(count <= n){
            int temp = b;
            b = a + b ;
            a = temp;
            System.out.print("," + b);
            count++;
        }

        System.out.println("\nThe fibonacci series of " + n +" : " + b);
    }
}
