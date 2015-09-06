/*
 * Implementar el algoritmo de búsqueda binaria.
 */
package TrabajoPracticoN2;

/**
 *
 * @author Cristian
 * @version 4/09/2015
 */
public class Ejercicio7 {
    public static void main(String[] args) {
        int[] arreglo = {5, 12, 9, 34, 8};
        
        System.out.println("Ubicación: " + binarySearch(arreglo, 34));
    }
    
    /**
     * Este módulo implementa el algoritmo de búsqueda binaria.
     * 
     * @param a arreglo de números ordenados
     * @param k número a buscar
     * @return posición del índice donde se encuentra el número, -1 en caso contrario
     */
    public static int binarySearch(int[] a, int k) {
        int l, m, r, resultado;
        
        l = 0;
        r = a.length-1;
        m = (l+r) / 2;
        resultado = -1;
        
        while (l <= r && k != a[m]) {
            m = (l+r) / 2;
            
            if (k == a[m]) {
                resultado = m;
            } else {
                if (k < a[m]) {
                    r = m-1;
                } else {
                    l = m+1;
                }
            }
        }
        
        return resultado;
    }
}
