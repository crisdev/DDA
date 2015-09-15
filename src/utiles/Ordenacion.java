/*
 * Librería para los algoritmos de ordenación vistos.
 */
package utiles;

/**
 *
 * @author Cristian
 * @version 5/09/2015
 */
public class Ordenacion {
    
    /**
     * Implementa el algoritmo de búsqueda de la selección.
     * 
     * @param a arreglo de enteros desordenado
     */
    public static void selectionSort(int[] a) {
        int i, j, min, tmp;
        
        for (i = 0; i < a.length-1; i++) {
            min = i;
            
            for (j = i+1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            
            tmp = a[min];
            a[min] = a[i];
            a[i] = tmp;
        }
    }
    
    /**
     * Implemente el algoritmo de búsqueda de la burbuja.
     * 
     * @param a arreglo de números desordenados
     */
    public static void bubbleSort(int[] a) {
        int i, j, tmp;
        
        for (i = 0; i < a.length-1; i++) {
            for (j = 0; j < a.length-1-i; j++) {
                if (a[j+1] < a[j]) {
                    tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
    }
    
    /**
     * Implementa el algoritmo de ordenamiento por inserción.
     * 
     * @param a arreglo de números desordenados
     */
    public static void insertionSort(int[] a) {
        int p, j, temp;
        
        for (p = 1; p < a.length; p++) {
            temp = a[p];
            j = p;
            
            while (j > 0 && temp < a[j-1]) {
                a[j] = a[j-1];
                j = j-1;
            }
            
            a[j] = temp;
        }
    }
}
