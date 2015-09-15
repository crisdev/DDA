/*
 * Implementar bubble sort e insertion sort y verificar la implementación con ejemplos.
 */
package trabajoPracticoN2;

/**
 *
 * @author Cristian
 * @version 4/09/2015
 */
public class Ejercicio12 {
    
    public static void main(String[] args) {
        int[] a = {12, 4, 8, 9, 0, 22, 31, 1};
        int[] b = {55, 102, 13, 87, 90, 21, 9};
        
        bubbleSort(a);
        insertionSort(b);
        
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        
        System.out.println();
        
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
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
