package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Fraccion fraccion1 = new Fraccion(2,0);
        Fraccion fraccion2 = new Fraccion(2,2);

        System.out.print(fraccion1 + " + " + fraccion2 + " = " );

        fraccion1.sumar(fraccion2);

        System.out.println(fraccion1);

    }
}

