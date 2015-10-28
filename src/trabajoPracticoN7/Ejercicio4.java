/*
 * Escribir las siguientes rutinas recursivas en java, realizando las respectivas
 * trazas sobre el siguiente arreglo unidimensional:
 * v = {12, 7, 0, -1, 8, 10}
 *
 * a) Dado un número entero n, devolver verdadero si n se encuentra en v y falso
 * en caso contrario. Traza para n = 8 y n = 6.
 * b) Devolver el valor de verdad en una función que determine si los elementos
 * del arreglo respetan un orden creciente o no.
 */
package trabajoPracticoN7;

/**
 *
 * @author Cristian
 * @version 28/10/2015
 */
public class Ejercicio4 {
    
    public static boolean tieneElemento(int[] a, int elemento) {
        boolean encontrado;
        int[] c = new int[a.length-1];
        
        encontrado = false;
        
        if (a[0] == elemento) {
            encontrado = true;
        } else {
            for(int i = 1; i < a.length; i++) {
                c[i-1] = a[i];
            }
            
            //System.out.println(encontrado);
            
            encontrado = tieneElemento(c, elemento);
        }
        
        return encontrado;
    }
    
    public static void main(String[] args) {
        int[] v = {12, 7, 0, -1, 8, 10};
        
        System.out.println(tieneElemento(v, 2));
    }
    
}
