/*
 * Realizar el pseudocódigo y la implementación en java de un método de ordenación
 * para cada esquema algorítmico que se lista a continuación:
 *
 * 1) Fuerza bruta
 * 2) Disminuye y vencerás
 *
 * El algoritmo recibe un arreglo de números enteros y los ordena de menor a mayor
 * (orden creciente). Calcular el tiempo de ejecución de cada algoritmo.
 *
 * En cada método, ¿qué sentencias deben cambiar para ordenar el arreglo en orden decreciente?
 */
package trabajoPracticoN6;

/**
 *
 * @author Cristian
 * @version 26/10/2015
 */
public class Ejercicio3 {

    /**
     * Ordena un arreglo utilizando el algoritmo de selección (Fuerza bruta).
     *
     * @param arreglo arreglo desordenado
     */
    public static void selectionSort(int[] arreglo) {
        int i, j, min, tmp, longArreglo;

        longArreglo = arreglo.length;
        for (i = 0; i < longArreglo - 1; i++) {
            min = i;
            for (j = i + 1; j < longArreglo; j++) {
                if (arreglo[j] < arreglo[min]) { // usar ">" para orden decreciente
                    min = j;
                }
            }
            // intercambiar a[i] y a[min]
            tmp = arreglo[i];
            arreglo[i] = arreglo[min];
            arreglo[min] = tmp;
        }
    }

    /**
     * Visualiza por pantalla los elementos de un arreglo.
     *
     * @param a arreglo de ingreso
     */
    public static void mostrarArreglo(int[] a) {
        int i, longArreglo;

        longArreglo = a.length;
        for (i = 0; i < longArreglo; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
    }

    /**
     * Ordena un arreglo utilizando el algoritmo de inserción (Disminuye y
     * vencerás).
     *
     * @param arreglo arreglo desordenado
     */
    public static void insertionSort(int[] arreglo) {
        int i, j, temp, longArreglo;

        longArreglo = arreglo.length;
        for (i = 0; i < longArreglo; i++) {
            j = i;
            while (j > 0 && arreglo[j - 1] > arreglo[j]) { // usar "<" para orden decreciente
                temp = arreglo[j];
                arreglo[j] = arreglo[j - 1];
                arreglo[j - 1] = temp;

                j = j - 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {12, 3, 56, 1, 0, 34, 100, 83, 13, 65, 23, 53, 13};
        int[] b = {12, 3, 56, 1, 0, 34, 100, 83, 13, 65, 23, 53, 13};

        mostrarArreglo(a);
        selectionSort(a);
        mostrarArreglo(a);

        System.out.println("================");

        mostrarArreglo(b);
        insertionSort(b);
        mostrarArreglo(b);
    }
}
