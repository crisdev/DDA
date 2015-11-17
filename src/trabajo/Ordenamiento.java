/*
 * Esta clase incluye los métodos de ordenamiento implementados
 * sobre la clase Persona.
 */
package trabajo;

/**
 *
 * @author Cristian
 * @version 16/11/2015
 */
public class Ordenamiento {

    /**
     * Implementa el algoritmo de ordenamiento por selección.
     *
     * @param a arreglo de personas desordenadas
     */
    public static void selectionSort(Persona[] a) {
        int i, j, min, longitudArreglo;
        Persona nueva;

        longitudArreglo = a.length;
        for (i = 0; i < longitudArreglo - 1; i++) {
            min = i;

            for (j = i + 1; j < longitudArreglo; j++) {
                if (a[j].getCuitCuil().getDNI() < a[min].getCuitCuil().getDNI()) {
                    min = j;
                }
            }

            nueva = a[i];
            a[i] = a[min];
            a[min] = nueva;
        }
    }

    /**
     * Implementa el algoritmo de ordenamiento por inserción.
     *
     * @param a arreglo de personas desordenadas
     */
    public static void insertionSort(Persona[] a) {
        long temp;
        Persona nueva;
        int j, longitudArreglo;

        longitudArreglo = a.length;
        for (int p = 1; p < longitudArreglo; p++) {
            temp = a[p].getCuitCuil().getDNI();
            nueva = a[p];  // Necesito almacenar la referencia de la persona !!
            j = p;

            while (j > 0 && temp < a[j - 1].getCuitCuil().getDNI()) {
                a[j] = a[j - 1];
                j = j - 1;
            }

            a[j] = nueva;
        }
    }

    /**
     * Implementa el algoritmo de ordenamiento burbuja.
     *
     * @param a arreglo de personas desordenadas
     */
    public static void bubbleSort(Persona[] a) {
        int i, j, longitudArreglo;
        Persona nueva;

        longitudArreglo = a.length;
        for (i = 0; i < longitudArreglo - 1; i++) {
            for (j = 0; j < longitudArreglo - 1 - i; j++) {
                if (a[j + 1].getCuitCuil().getDNI() < a[j].getCuitCuil().getDNI()) {
                    nueva = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = nueva;
                }
            }
        }
    }
}
