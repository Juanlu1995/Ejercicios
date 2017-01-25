package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int fib, numero;

        fib = fibonachi(numero);

        System.out.println(fibonachi("fibonachi(" + numero + ") = " + fib);

    }

    static int fibonachi (int numero){

        if (numero == 1 || numero == 2 ){

            return 1;
        }else{
            return fibonachi(numero - 1) + fibonachi (numero - 2);
        }

    }
}
