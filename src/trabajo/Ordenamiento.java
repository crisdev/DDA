/*
 * Esta clase incluye los métodos de ordenamiento implementados
 * sobre la clase TestPersona: INSERTION, SELECTION, BUBBLE, MERGE, QUICK y HEAP.
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
     * @param a arreglo de personas desordenado
     * @param cantPersonas cantidad de personas válidamente ingresadas en el
     * arreglo
     */
    public static void selectionSort(Persona[] a, int cantPersonas) {
        int i, j, min;
        Persona nueva;

        for (i = 0; i < cantPersonas - 1; i++) {
            min = i;

            for (j = i + 1; j < cantPersonas; j++) {
                if (a[j].getCuitCuil().menorQue(a[min].getCuitCuil())) {
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
     * @param a arreglo de personas desordenado
     * @param cantPersonas cantidad de personas válidamente ingresadas en el
     * arreglo
     */
    public static void insertionSort(Persona[] a, int cantPersonas) {
        Persona nueva;
        int j;

        for (int p = 1; p < cantPersonas; p++) {
            nueva = a[p];
            j = p;

            while (j > 0 && a[p].getCuitCuil().menorQue(a[j - 1].getCuitCuil())) {
                a[j] = a[j - 1];
                j = j - 1;
            }

            a[j] = nueva;
        }
    }

    /**
     * Implementa el algoritmo de ordenamiento burbuja.
     *
     * @param a arreglo de personas desordenado
     * @param cantPersonas cantidad de personas válidamente ingresadas en el
     * arreglo
     */
    public static void bubbleSort(Persona[] a, int cantPersonas) {
        int i, j;
        Persona nueva;

        for (i = 0; i < cantPersonas - 1; i++) {
            for (j = 0; j < cantPersonas - 1 - i; j++) {
                if (a[j + 1].getCuitCuil().menorQue(a[j].getCuitCuil())) {
                    nueva = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = nueva;
                }
            }
        }
    }

    /**
     * Implementa el algorito de ordenamiento merge sort.
     *
     * @param arreglo arreglo de personas desordenado
     * @param cantPersonas cantidad de personas válidamente ingresadas en el
     * arreglo
     */
    public static void mergeSort(Persona[] arreglo, int cantPersonas) {
        mergeSort(arreglo, 0, cantPersonas - 1);
    }

    private static void mergeSort(Persona a[], int izquierda, int derecha) {
        int medio;

        if (izquierda < derecha) {
            medio = (izquierda + derecha) / 2;

            mergeSort(a, izquierda, medio);
            mergeSort(a, medio + 1, derecha);

            mezclar(a, izquierda, medio, derecha);
        }
    }

    private static void mezclar(Persona a[], int izquierda, int medio, int derecha) {
        int i, j, k;
        Persona[] aux = new Persona[a.length];

        // Copia las mitades en el arreglo auxiliar
        for (i = izquierda; i <= derecha; i++) {
            aux[i] = a[i];
        }

        i = k = izquierda;
        j = medio + 1;

        // Copia el elemento más grande en el arreglo original
        while (i <= medio && j <= derecha) {
            if (aux[i].getCuitCuil().menorQue(aux[j].getCuitCuil())) {
                a[k++] = aux[i++];
            } else {
                a[k++] = aux[j++];
            }
        }

        // Copia elementos restantes de la primera mitad
        while (i <= medio) {
            a[k++] = aux[i++];
        }
    }

    /**
     * Implementa el algoritmo de ordenación quick sort.
     *
     * @param arreglo arreglo de personas desordenado
     * @param cantPersonas cantidad de personas válidamente ingresadas en el
     * arreglo
     */
    public static void quickSort(Persona[] arreglo, int cantPersonas) {
        quickSort(arreglo, 0, cantPersonas - 1);
    }

    private static void quickSort(Persona[] a, int izquierda, int derecha) {
        Persona pivote = a[izquierda];
        Persona nueva;
        int i = izquierda;
        int j = derecha;

        // Intercambia elementos mayores y menores al pivote
        while (i < j) {
            while (a[i].getCuitCuil().menorIgualQue(pivote.getCuitCuil()) && i < j) {
                i++;
            }
            while (pivote.getCuitCuil().menorQue(a[j].getCuitCuil())) {
                j--;
            }
            if (i < j) {
                nueva = a[i];
                a[i] = a[j];
                a[j] = nueva;
            }
        }

        a[izquierda] = a[j];
        a[j] = pivote;

        // Ordena arreglo izquierdo
        if (izquierda < j - 1) {
            quickSort(a, izquierda, j - 1);
        }

        // Ordena arreglo derecho
        if (j + 1 < derecha) {
            quickSort(a, j + 1, derecha);
        }
    }

    /**
     * Implementa el algoritmo de ordenación heap sort.
     *
     * @param a arreglo de personas desordenado
     * @param cantPersonas cantidad de personas válidamente ingresadas en el
     * arreglo
     */
    public static void heapSort(Persona[] a, int cantPersonas) {
        Persona tmp;
        int posFin;

        armarHeapMaximo(a, cantPersonas);

        posFin = cantPersonas - 1;
        while (posFin > 0) {
            tmp = a[posFin];
            a[posFin] = a[0];
            a[0] = tmp;
            siftDown(a, 0, posFin - 1);
            posFin--;
        }
    }

    private static void armarHeapMaximo(Persona[] a, int longitud) {
        int inicio;

        inicio = (longitud - 2) / 2;

        while (inicio >= 0) {
            siftDown(a, inicio, longitud - 1);
            inicio--;
        }
    }

    private static void siftDown(Persona[] a, int posIni, int posFin) {
        Persona tmp;
        int raiz, hijo;
        boolean intercambiar;

        raiz = posIni;
        intercambiar = true;

        while ((raiz * 2 + 1) <= posFin && intercambiar) {
            hijo = raiz * 2 + 1;

            if (hijo + 1 <= posFin && a[hijo].getCuitCuil().menorQue(a[hijo + 1].getCuitCuil())) {
                hijo = hijo + 1;
            }

            if (a[raiz].getCuitCuil().menorQue(a[hijo].getCuitCuil())) {
                tmp = a[raiz];
                a[raiz] = a[hijo];
                a[hijo] = tmp;
                raiz = hijo;
            } else {
                intercambiar = false;
            }
        }
    }
}
