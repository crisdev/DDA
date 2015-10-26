/*
 * Realizar el pseudocódigo y la implementación en Java de un método que
 * reciba un arreglo de números enteros y verifique si los elementos del
 * arreglo respetan un orden creciente o no.
 * Calcular su tiempo de ejecución.
 */
package trabajoPracticoN6;

/**
 *
 * @author Cristian
 * @version 25/10/2015
 */
public class Ejercicio1 {

    /**
     * Recibe un arreglo de enteros y determina si se encuentra ordenado en
     * forma creciente.
     *
     * @param a arreglo de enteros
     * @return verdadero si el arreglo está ordenado de menor a mayor
     */
    public static boolean esOrdenCreciente(int[] a) {
        int i, j, elemento, longArreglo;
        long inicio, fin;
        boolean ordenCreciente;

        inicio = System.currentTimeMillis();
        i = 0;
        longArreglo = a.length;
        ordenCreciente = true;
        while (i < longArreglo && ordenCreciente) {
            elemento = a[i];
            j = i + 1;
            while (j < longArreglo && ordenCreciente) {
                if (elemento > a[j]) {
                    ordenCreciente = false;
                } else {
                    j = j + 1;
                }
            }
            i = i + 1;
        }
        fin = System.currentTimeMillis();

        System.out.println("Tiempo de ejecución: " + (fin - inicio) + " milisegundos");
        return ordenCreciente;
    }

    public static void main(String[] args) {
        int[] testA = {5, 10, 9, 12};
        int[] testB = {5, 9, 10, 12};
        int[] testC = new int[100000];

        for (int i = 0; i < 100000; i++) {
            testC[i] = i + 1;
        }

        System.out.println("Orden creciente: " + esOrdenCreciente(testA));
        System.out.println("Orden creciente: " + esOrdenCreciente(testB));
        System.out.println("Orden creciente: " + esOrdenCreciente(testC));
    }

}
