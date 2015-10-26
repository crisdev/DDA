/*
 * Realizar el pseudocódigo y la implementación Java de un método que reciba
 * un arreglo ordenado (en forma creciente) de números enteros y un valor n,
 * y verifique si n está en el arreglo, utilizando los métodos de búsqueda:
 * - Secuencial
 * - Búsqueda binaria
 *
 * Indicar la técnica algorítmica utilizada. Calcular el tiempo de ejecución de
 * cada algoritmo.
 */
package trabajoPracticoN6;

/**
 *
 * @author Cristian
 * @version 25/10/2015
 */
public class Ejercicio2 {

    public static int busquedaSecuencial(int[] a, int n) {
        int i, longArreglo, pos;
        boolean encontrado;

        i = 0;
        longArreglo = a.length;
        encontrado = false;
        pos = -1;
        while (i < longArreglo && !encontrado) {
            if (a[i] == n) {
                pos = i;
                encontrado = true;
            } else {
                i = i + 1;
            }
        }

        return pos;
    }

    public static int busquedaBinaria(int[] a, int k) {
        int inicio, fin, medio, resultado;

        inicio = 0;
        fin = a.length - 1;
        resultado = -1;

        while (inicio <= fin) {
            medio = (inicio + fin) / 2;
            if (k == a[medio]) {
                resultado = medio;
                inicio = fin + 1;
            } else {
                if (k < a[medio]) {
                    fin = medio - 1;
                } else {
                    inicio = medio + 1;
                }
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] arregloA = {44, 1, 35, 2, 0, 16, 25, 77, 9, 3};
        int[] arregloB = {0, 1, 2, 3, 9, 16, 25, 35, 44, 77};

        System.out.println("Posición del elemento: " + busquedaSecuencial(arregloA, 3));
        System.out.println("Posición del elemento: " + busquedaBinaria(arregloB, 35));

    }
}
