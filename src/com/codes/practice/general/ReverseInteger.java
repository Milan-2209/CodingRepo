package com.java.myWay;

import java.util.Scanner;

public class ReverseInteger {

    public int reverse(int x) {
        int i=10;
        int revInt = 0;
        if(x>0){
            while(x > 0){
                revInt = revInt * i + x%10;
                x/=10;
            }
        }
        else{
            int newNum = (x - x) - x;
            while(newNum > 0){
                int rem = newNum % 10;
                revInt = revInt * i + rem ;
                newNum/=10;
            }
            revInt = (revInt - revInt) - revInt;
        }
        if(Integer.MIN_VALUE<revInt && revInt<Integer.MAX_VALUE-1)
            return revInt;
        else
            return 0;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ReverseInteger rev = new ReverseInteger();
        System.out.println(rev.reverse(num));

    }
}
