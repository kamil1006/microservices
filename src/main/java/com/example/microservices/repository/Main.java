package com.example.microservices.repository;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        System.out.println (10 / (2 + 2) + 4 * 8);
        System.out.println((3 + 4) * (5 / 2));
        System.out.println((-5) * (-10) * (-20));
        System.out.println(12%13);
        System.out.println(24%2);
        System.out.println(25/2);

        int number = 12241;
        int digit = ((number % 100) / 10) % 10;
        System.out.println(digit);

        boolean b1=true,b2=false;
        System.out.println(b1 ^ b2);
        System.out.println(!b1 && b2);
        System.out.println(b1 && b2);

        System.out.println(b1 || b2);

        int n = 0;
        System.out.print(++n);
        System.out.print(n++);
        System.out.print(n++);



    }
}