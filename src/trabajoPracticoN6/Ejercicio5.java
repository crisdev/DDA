/*
 * Realizar el pseudocódigo y la implementación en java del método de la burbuja
 * mejorado, que consiste en finalizar las iteraciones del método burbuja,
 * cuando en el último recorrido no se han realizado cambios.
 */
package trabajoPracticoN6;

/**
 *
 * @author Cristian
 * @version 26/10/2015
 */
public class Ejercicio5 {

    /**
     * Implementación de burbuja mejorado: finaliza si no hay cambios.
     *
     * @param a arreglo de enteros desordenado
     */
    public static void burbujaMejorado(int[] a) {
        int i, j, anteUltimo, aux;
        boolean ordenado;

        anteUltimo = a.length - 1;
        ordenado = false;

        i = 0;
        while (!ordenado) {
            ordenado = true;
            for (j = 0; j < anteUltimo - i; j++) {
                if (a[j + 1] < a[j]) {
                    aux = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = aux;
                    ordenado = false;
                }
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int[] arreglo = {34, 2, 45, 0, 23, 4, 235, 5, 16, 5, 35, 2};

        burbujaMejorado(arreglo);

        for (int i : arreglo) {
            System.out.print(i + " ");
        }
    }

}
