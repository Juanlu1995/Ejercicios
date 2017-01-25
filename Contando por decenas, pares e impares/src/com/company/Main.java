package com.company;

public class Main {

    public static void main(String[] args) {

        final int SIZE = 100;

        int min = 0;
        int max = 100;
        int nums [] = new int[SIZE];

        System.out.println("NUMEROS");
        System.out.println("=======");
        fillArray(nums, min, max);
        printArray(nums);
        printArray( printCountTens(nums) );
        //printCountTens(nums);
        //countEvensOdds();
    }

    /**
     * Rellena el array con valores aleatorios entre min y max.
     * @param nums  Array de enteros.
     * @param min Valor minimo del rango de valores generados.
     * @param max Valor maximo del rango de valores generados.
     */
    static void fillArray(int nums[], int min, int max){

        for (int i = 0; i < nums.length; i++){
            nums[i] = (int) (Math.random()*max+min);
        }

    }

    /**
     * Imprime el Array en 10 lineas que contine 10 numeros cada linea.
     * @param nums
     */
    static void printArray(int nums[]){
        for (int i = 0; i < nums.length; i++){
            System.out.printf(" %3d", nums[i]);
            if ((i + 1) % 10 == 0){
                System.out.println();
            }

        }
        System.out.println();
    }
    static  int [] printCountTens(int nums[]){

        int decenas[] = new int[10];

        for (int i = 0; i < nums.length; i++){
            decenas [nums[i]/10]++;
        }

        return decenas;
    }
}
