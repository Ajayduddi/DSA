package com.math;
import java.util.*;

public class Main{
    public static void main(String...args){
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int freq = in.nextInt();
        int slot = in.nextInt();
        char ch = in.next().trim().charAt(0);
        in.nextLine();
        String name = in.nextLine();
        int count = 0;

        for(int i = 0; i < slot; i++){
            if(name.charAt(i) == ch){
                count++;
            }
        }

        if(count >= freq){
            System.out.println(0);
        }else{
            count = 0;
            int i = 0, j = name.length() -1 ,x = 0;
            while(i < j){
                if(name.charAt(i) == ch){
                    x++;
                    count++;
                    break;
                }
                x++;
                if(x >= slot && count != freq){
                    System.out.println("-1");
                    break;
                }
                i++;
            }

            while( i < j && x < slot){
                if(name.charAt(j) == ch){
                    count++;
                }

                if(x >= slot && count != freq){
                    System.out.println("-1");
                }

                if(x <= slot && count == freq){
                    System.out.println(Math.abs(name.length() - j));
                    break;
                }
                j--;
            }
        }

    }
}