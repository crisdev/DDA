/*
 *
 */
package trabajoPracticoN4.tests;

import trabajoPracticoN4.clases.Matriz;

/**
 *
 * @author Cristian
 * @version 15/09/2015
 */
public class TestMatriz {

    public static void main(String[] args) {
        Matriz a = new Matriz(3,2);
        Matriz b = new Matriz(2,4);
        Matriz c = new Matriz(3,2);

        // Generar automáticamente matrices aleatorias
        a.generarNrosAleatorios();
        System.out.println("A:");
        a.mostrarMatriz();
        b.generarNrosAleatorios();
        System.out.println("B:");
        b.mostrarMatriz();

        // Producto de dos matrices
        a.producto(b).mostrarMatriz();

        // Modificar elementos de una matriz
        a.modificaValor(1, 1, 15);
        a.mostrarMatriz();

        // Suma de matrices
        System.out.println("Suma de matrices:");
        a.suma(c).mostrarMatriz();

        // Copia de matrices
        c = a.clonar();
        c.mostrarMatriz();
    }
}
