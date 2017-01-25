package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int numero;
        int fibo [];

        System.out.println("Introducir numero Fibonachi");
        numero = input.nextInt();

        System.out.println("===========================");
        System.out.println(" La sucecion de Fibonachi es: ");

        fibo = new int[numero];

        fibo [0] = 1;
        fibo [1] = 1;

        System.out.printf(" %d",fibo[0]);
        System.out.printf(" %d",fibo[1]);


        for (int i = 2; i < numero; i ++)
        {
            fibo [i] = fibo [i - 1] + fibo [i - 2];

            System.out.printf(" %d" ,fibo[i]);
        }

    }
}
