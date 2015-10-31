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
     * @param a arreglo desordenado
     * @param e elemento a buscar
     * @param p tamaño del arreglo menos uno
     * @return verdadero si el elemento se encuentra en el arreglo
     */
    public static boolean tieneElemento(int[] a, int e, int p) {
        boolean encontrado;

        if (p == 0) {
            encontrado = (a[0] == e);
        } else {
            encontrado = (e == a[p]) || (tieneElemento(a, e, p - 1));
        }

        return encontrado;
    }

    public static boolean esCreciente(int[] a, int p) {
        boolean esCreciente;
        
        if (p > 0) {
            if (a[p] < a[p - 1]) {
                esCreciente = false;
            } else {
                esCreciente = (p == 1) || esCreciente(a, p - 1);
            }
        } else {
            esCreciente = true;
        }

        return esCreciente;
    }

    public static void main(String[] args) {
        int[] v = {12, 7, 0, -1, 8, 10};

        System.out.println(tieneElemento(v, 10, v.length - 1));

        if (esCreciente(v, v.length - 1)) {
            System.out.println("El arreglo es creciente.");
        } else {
            System.out.println("El arreglo no respeta un orden creciente.");
        }
    }
}
