package com.company;

public class Main {

    public static void main(String[] args) {

        Fecha hoy = new Fecha(26, 1, 2017);

        Fecha fiesta = new Fecha(2005);

        Fecha ayer = new Fecha();

        System.out.println(hoy);

        System.out.println(fiesta);

        System.out.println(ayer);
    }
}
