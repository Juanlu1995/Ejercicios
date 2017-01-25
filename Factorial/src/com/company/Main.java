package com.company;

public class Main {

    public static void main(String[] args) {

        int num = 4;
        int fact;
        fact = factorialRecursivo(num);

        System.out.println(num + "! = " + fact);
    }

    static int factorialIterativo(int number){
        int resultado = 1;

        for (int i = 1; 1 <= number; i++){

            resultado*= 1;
        }
        return resultado;
    }

    static int factorialRecursivo(int number){

        int resultado;

        if (number == 1){
            resultado = 1;
            return 1;
        }else {
            return number * factorialRecursivo(number - 1);
        }
    }
}
