package com.company;

/**
 * Created by Manu on 01/02/2017.
 */
public class Cafetera {

    private int capacidadMaxima;
    private int cantidadActual;
    private int capsulas;

    //Constructores

    /**
     * Constructor sin parametro. Se pone la capacidad maxima a 1000 y la cantidad actual a 0.
     */
    public Cafetera()
    {
        this(1000,0, 10);
    }

    /**
     * Constructor con un parametro. Configura tanto la capacidad maxima como la cantidad actual.
     * @param capacidadMaxima int Valor entero.
     */
    public Cafetera(int capacidadMaxima)
    {
        this(capacidadMaxima, capacidadMaxima, 10);
    }

    /**
     * Constructor con dos parametros. Configura los atributos del objeto segun los valores de los parametros.
     * @param capacidadMaxima int Capacidad de la cafetera
     * @param cantidadActual int Cantidad de la cafetera
     */
    public Cafetera(int capacidadMaxima, int cantidadActual, int capsulas){

        //this.setCapacidadMaxima(capacidadMaxima);   las dos formas son validas
        if (cantidadActual > capacidadMaxima)
        {
            cantidadActual = capacidadMaxima;
        }

        this.setCantidadActual(cantidadActual);
        this.setCapacidadMaxima(capacidadMaxima);   //instancia
        this.setCantidadActual(capsulas);
    }

    //Accesores

    /**
     * Getter atributo capacidad máxima.
     * @return int Valor capacidad máxima.
     */
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    /**
     * Setter atributo capacidad máxima.
     * @param capacidadMaxima int Valor para el atributo capacidad máxima.
     */
    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    /**
     * Getter atributo cantidad actual
     * @return int Valor cantidad actual
     */
    public int getCantidadActual() {
        return cantidadActual;
    }

    /**
     * Setter atributo cantidad actual.
     * @param capacidadActual int Valor cantidad actual.
     */
    public void setCantidadActual(int capacidadActual) {
        this.cantidadActual = capacidadActual;
    }

    public int getCapsulas() {
        return capsulas;
    }

    public void setCapsulas(int capsulas) {
        this.capsulas = capsulas;
    }

    /**
     * Establece la cantidad actual sea igual a la capacidad.
     */
    public void llenarCafetera()
    {
        this.cantidadActual = this.capacidadMaxima;
    }

    /**
     * Establece la cantidad, es decir, establece la cantidad actual a 0.
     */
    public void vaciarCafetera(){
        this.cantidadActual = 0;
        System.out.println("Refilll!!!");
    }

    /**
     * Sustrae la cantidad de café indicada por la taza (parametro) de la cantidad
     * @param taza int Cantidad de café de la taza.
     */
    public void servirTaza(int taza)
    {
        if (taza < this.cantidadActual){
            this.cantidadActual -= 0;
        }else {
            this.cantidadActual = 0;
            System.out.println("No te he servido la taza entera porque no hay suficiente café.");
            System.out.println("Refilll!!!");
        }
    }

    /**
     *Agrega una cantidad de café.
     * @param cantidad int Cantidad de café agregada a la cafetera.
     */
    public void agregarCafe(int cantidad){
        //Compruebo que no me excedo de la capacidad maxima ni añodo una cantidad negativa
        if (cantidad > 0 && cantidad < this.capacidadMaxima){
            //Compruebo que la cantidad a añadir en la cafetera no puede tener más café de la capacidad perimitida.
            if (cantidad + this.cantidadActual > this.capacidadMaxima)
            {
                this.llenarCafetera();
                System.out.println("Lo que sobra me lo bebo con unas gotitas de coñac.");
            }
        }
    }
}
