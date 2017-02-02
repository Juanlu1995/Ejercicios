package com.company;

/**
 * Created by Manu on 25/01/2017.
 */
public class Fecha {

    private int day;                        //Atributos son siempre privados
    private int month;
    private int year;

    //Constructores         siempre van despues de los atributos

    /**
     * Constructor de conveniencia sin parametros.
     */
    public Fecha(){

        this(1, 1, 1970);       //Se pone lo que quiero que salga. Para que no me haga falta
                                                  //set ni get.
    }

    /**
     * Constructor de conveniencia con dos parametros.
     * @param day
     * @param month
     */
    public Fecha(int day, int month){

        this(day, month, 1970);
    }

    /**
     * Construcot de conveniencia con un parametro. Pone la  fecha a 1/1/año.
     * @param year
     */
    public Fecha(int year){

        this(1, 1, year);
    }

    /**
     * Constructor designado. Da valor a todos los parametros.
     * @param day
     * @param month
     * @param year
     */
    public  Fecha(int day, int month, int year){

        this.setDay(day);           //Tambien se puede escribir asi   this.day = day;
        this.setMonth(month);
        this.setYear(year);

    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {       //set es para ponerlos

        this.day = day;                     //this se va a referir siempre a la instancia.
    }

    public int getMonth() {             // get es para extraerlos.

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

    //Helpers   =   ayudantes

    public String toString(){

        String resultado = "";

        resultado = this.getDay() + "/" + this.getMonth() + "/" + this.getYear();

        return resultado;
    }
}
