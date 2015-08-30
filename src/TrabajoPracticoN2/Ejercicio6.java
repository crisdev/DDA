/*
 * Implementar en java el algoritmo selection sort.
 */
package TrabajoPracticoN2;

/**
 *
 * @author Cristian
 * @version 30/08/2015
 */
public class Ejercicio6 {
    
    public static void main(String[] args) {
        int[] arreglo = {5, 8, 9, 12, 34};
        
        selectionSort(arreglo);
        
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
    }
    
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
    
}
