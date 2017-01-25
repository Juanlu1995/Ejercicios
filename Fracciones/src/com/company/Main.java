package com.company;

public class Main {

    public static void main(String[] args) {

       //Definir la primera fraccion a/b = 1/2
       int numA = 1;
       int denA = 2;

        //Definir la segunda fraccion a/b = 1/3
       int numB = 1;
       int denB = 3;

    }
    static void sumar(int a, int b, int c, int d){

        int numResultado, denResultado;

        denResultado = minimoComunMultiplo(b,d);

        numResultado = denResultado/b*a + denResultado/d*c;

        System.out.println(a+"/"+b+" + "+c+"/"+d+" =" + denResultado+"/"+numResultado);
    }

    static int minimoComunMultiplo(int a, int b){

        return (a*b) / maximoComunDivisor(a,b);
    }

    static int maximoComunDivisor(int a, int b){
        int mcd = 1;

        return mcd;
    }
}
