/*
 * Para cada arreglo de tipos de datos enteros o reales del ejercicio anterior
 * calcule el valor promedio.
 */
package TrabajoPracticoN2;

import java.util.Random;

/**
 *
 * @author Cristian
 * @version 29/02/2015
 */
public class Ejercicio2 {

    public static void main(String[] args) {
    // inciso B
        int[] enteroConsecutivo;
        enteroConsecutivo = new int[1000];
        for (int i = 0; i < enteroConsecutivo.length; i++) {
            enteroConsecutivo[i] = i + 1;
        }

        System.out.println("El promedio de enteros consecutivos del 1 a 1000 es: " + promedio(enteroConsecutivo));
    // inciso C
        int[] enteroImparConsecutivo;
        enteroImparConsecutivo = new int[20000];

        for (int i = 0; i < enteroImparConsecutivo.length; i++) {
            enteroImparConsecutivo[i] = 10000 + (2*i + 1);
        }

        System.out.println("El promedio de enteros impares consecutivos de 10000 a 50000 es: " + promedio(enteroImparConsecutivo));

    // inciso E
        int[] enteroAleatorio;
        enteroAleatorio = new int[50];
        Random r = new Random();

        for (int i = 0; i < enteroAleatorio.length; i++) {
            enteroAleatorio[i] = r.nextInt(101);
        }

        System.out.println("El promedio de 50 enteros aleatorios entre 0 y 100 es: " + promedio(enteroAleatorio));

    // inciso G
        double[] temperatura = {23.3, 22.0, 18.2, 13.3, 9.2, 6.1, 5.6,
                                8.1, 11.2, 15.3, 19.3, 22.2, 32.1, 14.0, 3.1};

        System.out.println("El promedio de 15 temperatuas es: " + promedio(temperatura));

    // inciso H
        double[] altura = {1.82, 1.77, 1.60, 1.83, 1.65, 1.90, 2.10, 1.78,
                           2.01, 1.66, 1.87, 1.79, 1.67, 2.20};

        System.out.println("El promedio de 14 alturas es: " + promedio(altura));
    }

    /**
     * Calcula el promedio de elementos en un arreglo.
     *
     * @param arreglo array de entero a calcular
     * @return promedio de los elementos del arreglo
     */
    public static double promedio(int[] arreglo) {
        double suma, promedio;
        int cantidadElementos;

        suma = 0.0;
        cantidadElementos = arreglo.length;

        for (int i = 0; i < cantidadElementos; i++) {
            suma += arreglo[i];
        }

        promedio = suma / cantidadElementos;

        return suma;
    }

    /**
     * Calcula el promedio de elementos en un arreglo.
     *
     * @param arreglo array de entero a calcular
     * @return promedio de los elementos del arreglo
     */
    public static double promedio(double[] arreglo) {
        double suma, promedio;
        int cantidadElementos;

        suma = 0.0;
        cantidadElementos = arreglo.length;

        for (int i = 0; i < cantidadElementos; i++) {
            suma += arreglo[i];
        }

        promedio = suma / cantidadElementos;

        return promedio;
    }
}
