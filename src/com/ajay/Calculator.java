package com.ajay;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int num1 = 5,num2 = 20;
        boolean i = true;

        while(i){
            System.out.println("Type X or x for exit ");
            System.out.println("Enter an Operator: ");
            int op = in.next().trim().charAt(0);
            
//            if(op == '+' || op == '-' || op == '*' || op == '/' || op == '%' || op == 'x' || op == 'X'){
//                System.out.println("num 1 : ");
//                System.out.println("num 2 : ");
//                num1 = in.nextInt();
//                num2 = in.nextInt();
//            }

            switch(op){
                case '+' :
                    System.out.println(num1+num2);
                    break;

                case '-' :
                    System.out.println(num1-num2);
                    break;

                case '*' :
                    System.out.println(num1*num2);
                    break;

                case '/' :
                    System.out.println(num1/num2);
                    break;

                case '%' :
                    System.out.println(num1%num2);
                    break;

                case 'x' :
                    i = false;
                    break;

                case 'X' :
                    i = false;
                    break;

                default :
                    System.out.println("invalid operator");

            }
        }
        in.close();
    }
}
