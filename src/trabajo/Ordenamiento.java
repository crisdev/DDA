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

    public static void mergeSort(int[] a) {
        int longitud = a.length;
        int[] b = new int[longitud];

        mergeSort(a, b, 0, longitud - 1);
    }

    private static void mergeSort(int[] a, int[] temp, int inicio, int fin) {
        int medio;

        if (fin - inicio > 0) {
            medio = (inicio + fin) / 2;
            mergeSort(a, temp, inicio, medio);
            mergeSort(a, temp, medio + 1, fin);

            mezclar(a, temp, inicio, medio, fin);
            copiar(temp, inicio, fin, a);
        }
    }

    private static void mezclar(int[] a, int[] temp, int posIzq, int posDer, int posFin) {
        int finIzq, posAux, numElementos, i;
        
        finIzq = posDer - 1;
        posAux = posIzq;
        numElementos = posFin - posDer + 1;
    }
    
    private static void copiar(int[] b, int inicio, int fin, int[] a) {
        int k;

        for (k = inicio; k < fin; k++) {
            a[k] = b[k];
        }
    }
}
