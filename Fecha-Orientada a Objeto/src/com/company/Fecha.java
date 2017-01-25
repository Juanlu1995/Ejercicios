package com.company;

/**
 * Created by Manu on 25/01/2017.
 */
public class Fecha {

    private int day;                        //Atributos son siempre privados
    private int month;
    private int year;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;                     //this se va a referir siempre a la instancia
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
