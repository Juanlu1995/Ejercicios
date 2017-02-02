/*
Desarrollar una clase Cafetera con los siguientes atributos:

capacidadMaxima: la cantidad máxima de café que puede contener la cafetera
cantidadActual: la cantidad actual de café que hay en la cafetera.
Implementa los siguientes métodos:

Constructor predeterminado (designado): establece la capacidad máxima en 1000 (c.c.) y la actual en cero (cafetera vacía).
Constructor con la capacidad máxima de la cafetera; inicializa la cantidad actual de café igual a la capacidad máxima.
Constructor con la capacidad máxima y la cantidad actual. Si la cantidad actual es mayor que la capacidad máxima de la cafetera, la ajustará al máximo.
Métodos accesores.
llenarCafetera(): pues eso, hace que la cantidad actual sea igual a la capacidad.

servirTaza(int): simula la acción de servir una taza con la capacidad indicada. Si la cantidad actual de café “no alcanza” para llenar la taza, se sirve lo que quede y se avisará por consola de habernos quedado sin café.

 vaciarCafetera(): pone la cantidad de café actual en cero.

 agregarCafe(int): añade a la cafetera la cantidad de café indicada.

Escribir un pequeño programa que declare y utilice un objeto cafetera y pruebe el código de nuestra clase.
 */
package com.company;

public class Main {

    public static void main(String[] args) {
	Cafetera nespresso = new Cafetera(1000, 500, 10);

	    nespresso.agregarCafe(200);

        System.out.println(nespresso.getCapacidadMaxima());
        System.out.println(nespresso.getCantidadActual());

    }
}
