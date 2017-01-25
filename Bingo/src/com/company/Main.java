package com.company;

import java.util.*;


public class Main {


    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        int cartones[][] ,copiaCartones[][],  numCarton, bolas[] = new int [90], numeroLineas[];



        //Pedimos al usuario cuantos cartones se van a jugar y
        // se guarda en la primera dimension del array cartones

        System.out.print("Introduce el numero de cartones a jugar: ");
        numCarton = input.nextInt();
        cartones = new int[numCarton][15];
        copiaCartones = new int[numCarton][15];
        numeroLineas = new int[numCarton];

        fillArray(cartones);



        copyArray(cartones, copiaCartones);

        for (int i = 0; i < cartones.length; i++) {
            System.out.println("Carton " + i);
            printArray(i, cartones);
        }

        throwBall(bolas,copiaCartones,cartones,numeroLineas);
    }

    /**
     * Generamos de forma aleatoria los numeros entre 1 y 90 en una funcion llamada "random"
     * @param num
     * @return
     */
    static int random (int num){
        num = ((int) (1+Math.random() * 90));
        return num;
    }

    /**
     * Con esta funcion rellenamos los cartones
     * @param cartones
     */
    static void fillArray(int cartones[][]) {
        int num = 0;

        //Tenemos un booleano que nos marcará, a través de la funcion checkNumber, si está o no repetido el numero.
        boolean check = false;

        /**
         *
         * Recorremos el array dandole a la variable num un valor aleatorio a traves de la funcion random y
         * probamos con checkNumber si está o no repetido el numero en el array
         */
        for (int i = 0; i < cartones.length ; i++) {
            for (int j = 0; j < cartones[i].length ; j++) {
                do {
                    num = random(num);
                    check = checkNumber(cartones,num,i);
                }while (check == true);
                cartones[i][j] = num;
            }
            Arrays.sort(cartones[i]);
        }
    }


    /**
     * Copiamos los cartones en otro array llamado copiaCartones para que
     * posteriormente, cada bola que salga, si esta en el carton, se reste y se ponga a 0.
     * @param cartones
     * @param copiaCartones
     */
    static void copyArray (int cartones[][], int copiaCartones[][]){
        for (int i = 0; i < cartones.length ; i++) {
            for (int j = 0; j < cartones[0].length ; j++) {
                copiaCartones[i][j] = cartones[i][j];
            }
        }
    }

    /**
     * Imprime los cartones dandole a cada 5 numeros un salto de linea
     * @param arrayImprimir
     */
    static void printArray(int i, int arrayImprimir[][]) {

        for (int j = 0; j < arrayImprimir[0].length; j++) {
            System.out.print(arrayImprimir[i][j] + " ");
            if ((j + 1) % 10 == 0 || (j + 1) % 10 == 5) {
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * Comprueba que el numero generado de forma aleatoria no se repita en el carton.
     * @param carton
     * @param num
     * @param nCarton
     * @return
     */
    static boolean checkNumber (int carton[][],int num,int nCarton){

        //Tenemos un booleano que será el que marcará si está o no repetido el numero
        boolean repetido = false;

        // En el bucle vamos probando que el numero que nos han mandado a la funcion
        // esté repetido en el array, y si lo está marca como verdadero el booleano.
        for (int i = 0; i < carton[nCarton].length ; i++) {
            if (num == carton[nCarton][i]) {
                repetido = true;
            }
        }
        return repetido;
    }

    /**
     * La bola se tira a través de la funcion, que llama a otra funcion llamada
     * checkBall para ver si el numero aleatorio generado ha salido antes.
     * Si ha salido, la bola se descarta, si no, se guarda en un array.
     * Una variable nos guarda el numero de bolas que han salido.
     * Imprimimos las bolas y la cantidad
     * @param arraybolas
     * @param arrayCopiaCarton
     * @param cartones
     */
    static void throwBall (int arraybolas [],int arrayCopiaCarton[][], int cartones[][],int numeroLineas[]){
        boolean checkBola = false, bingo = false, linea = false;
        int num = 0,contador = 0, contadorLinea = 0;

        do {
            for (int i = 0 ; i < arraybolas.length ; i++) {

                do {
                    num = random(num);
                    checkBola = checkBall(arraybolas, num);
                } while (checkBola == true);
                arraybolas[i] = num;
                contador++;
                System.out.println();
                System.out.println("Bola " + num);
                System.out.println();
                restaNumeroCopiaArray(num, arrayCopiaCarton);
                for (int j = 0; j < cartones.length; j++) {
                    linea = checkLinea(j, arrayCopiaCarton, cartones, numeroLineas);
                    if (linea == true) {
                        numeroLineas[j] += 1;
                    }
                    if (numeroLineas[j] > 2){
                        bingo = checkBingo(j,arrayCopiaCarton,cartones);
                        if (bingo == true){
                            i = arraybolas.length - 1;
                            j = cartones.length - 1;
                        }
                    }
                }
            }
        }while (bingo == false);
        System.out.println();
        System.out.println();
        System.out.println("Han salido " + contador + " bolas:");
        System.out.println();
        for (int i = 0; i < arraybolas.length ; i++) {
            if (arraybolas[i] != 0) {
                System.out.printf("%3d", arraybolas[i]);
                if ((i + 1) % 10 == 0) {
                    System.out.println();
                }
            }
        }
    }

    /**
     * Con esta funcion probamos si la bola es repetida o no. Para ello recorremos el array probando si el numero
     * dado por la funcion random es igual al que haya en el array. Si lo es ponemos un booleano a true y hacemos en
     * throwBall que nos de otra bola.
     * @param cheakArray
     * @param num
     * @return
     */
    static boolean checkBall (int cheakArray [], int num){
        boolean repetido = false;

        for (int i = 0; i <cheakArray.length ; i++) {
            if (num == cheakArray[i]) {
                repetido = true;
            }
        }
        return repetido;
    }

    /**
     * Pone a 0 las bolas que hayan salido en una copia de los cartones para su posterior comprobacion
     * Primero prueba si es bingo en una una funcion llamada chackBingo, y si no hay bingo probamos en la funcion
     * checkLinea si hay linea, y si hay linea, poneamos el booleano de linea a
     * true para que no vuelva a comprobar si hay linea.
     * @param numeroBola
     * @param copiaCarton
     * @return
     */
    static void restaNumeroCopiaArray (int numeroBola, int copiaCarton[][]) {
        boolean linea = false;

        for (int i = 0; i < copiaCarton.length; i++) {
            for (int j = 0; j < copiaCarton[i].length; j++) {
                if (numeroBola == copiaCarton[i][j]) {
                    copiaCarton[i][j] = 0;
                }
            }
        }
    }

    /**
     * Esta funcion nos prueba si hay bingo.
     * Para ello, comprobamos si la suma de los numeros del carton = 1500 y si lo es, es que hay bingo.
     * Lo especificamos en una variable booleana y nos mostrará por pantalla un mensaje
     * cantando el bingo y el cartón ganador.
     * @param i
     * @param copiaCarton
     * @param cartones
     * @return
     */
    static boolean checkBingo(int i, int copiaCarton[][], int cartones[][]) {
        boolean bingo = false;
        int controlador = 0;

        for (int j = 0; j < copiaCarton[i].length; j++) {
            controlador = controlador + copiaCarton[i][j];
        }

        if (controlador == 1500) {
            bingo = true;
            System.out.println();
            System.out.printf("Bingo para el carton " + i + " con los numeros ");
            System.out.println();
            System.out.println();
            printArray(i,cartones);
        }
        return bingo;
    }

    /**
     * Esta funcion nos prueba si las bolas que hayan salido hacen linea en algun carton.
     * Para ello, comprobamos cada 5 numeros si la suma de ellos es = 0 y si el resultado es 0 es que hay linea.
     * Lo especificamos en una variable booleana y mostramos un mensaje por pantalla que canta la linea y
     * nos dice qué carton ha tenido linea.
     * Ponemos los numeros de la linea a 100 para que la linea no se vuelva a comprobar. Aumentamos en el array
     * numeroLineas +1 en la posicion que nos marque la variable i para que cuando sea mayor o igual que 2 no cante
     * la linea y cante directamente el bingo.
     * @param i
     * @param copiaCartones
     * @param cartones
     * @param numeroLineas
     * @return
     */
    static boolean checkLinea (int i,int copiaCartones[][], int cartones[][],int numeroLineas[]) {
        boolean checkLinea = false;
        int linea = 0;


        linea = copiaCartones[i][0] + copiaCartones[i][1] + copiaCartones[i][2] + copiaCartones[i][3] + copiaCartones[i][4];
        if (linea == 0) {
            checkLinea = true;
            copiaCartones[i][0] = 100;
            copiaCartones[i][1] = 100;
            copiaCartones[i][2] = 100;
            copiaCartones[i][3] = 100;
            copiaCartones[i][4] = 100;

        } else {
            linea = copiaCartones[i][5] + copiaCartones[i][6] + copiaCartones[i][7] + copiaCartones[i][8] + copiaCartones[i][9];
            if (linea == 0) {
                checkLinea = true;
                copiaCartones[i][5] = 100;
                copiaCartones[i][6] = 100;
                copiaCartones[i][7] = 100;
                copiaCartones[i][8] = 100;
                copiaCartones[i][9] = 100;

            } else {
                linea = copiaCartones[i][10] + copiaCartones[i][11] + copiaCartones[i][12] + copiaCartones[i][13] + copiaCartones[i][14];
                if (linea == 0) {
                    checkLinea = true;
                    copiaCartones[i][10] = 100;
                    copiaCartones[i][11] = 100;
                    copiaCartones[i][12] = 100;
                    copiaCartones[i][13] = 100;
                    copiaCartones[i][14] = 100;

                }
            }
        }
        if (numeroLineas[i] < 2) {
            if (checkLinea == true) {
                System.out.println();
                System.out.println("Hay linea en el carton " + i);

                printArray(i,cartones);

                System.out.println();
            }
        }
        return checkLinea;
    }
}