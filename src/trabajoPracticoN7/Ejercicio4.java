/*
 * Escribir las siguientes rutinas recursivas en java, realizando las respectivas
 * trazas sobre el siguiente arreglo unidimensional:
 * v = {12, 7, 0, -1, 8, 10}
 *
 * a) Dado un número entero n, devolver verdadero si n se encuentra en v y falso
 * en caso contrario. Traza para n = 8 y n = 6.
 * b) Devolver el valor de verdad en una función que determine si los elementos
 * del arreglo respetan un orden creciente o no.
 */
package trabajoPracticoN7;

/**
 *
 * @author Cristian
 * @version 28/10/2015
 */
public class Ejercicio4 {

    /**
     * Busca recursivamente un elemento dentro de un arreglo desordenado.
     * 
     * @param a arreglo de entrada
     * @param indice posición desde la cual se comienza a buscar
     * @param elemento entero a buscar
     * @return verdadero si el elemento está en el arreglo
     */
    public static boolean tieneElemento(int[] a, int indice, int elemento) {
        boolean encontrado;

        encontrado = false;

        if (a[indice] == elemento) {
            encontrado = true;
        } else {
            if (indice < a.length - 1) {
                encontrado = tieneElemento(a, indice + 1, elemento);
            } else {
                encontrado = false;
            }
        }

        return encontrado;
    }

    public static void main(String[] args) {
        int[] v = {12, 7, 0, -1, 8, 10};

        System.out.println(tieneElemento(v, 0, 12));
    }
}
