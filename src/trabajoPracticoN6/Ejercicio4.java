/*
 * Realizar el pseudocódigo y la implementación en java de un método que reciba
 * como datos de entrada dos arreglos de enteros ordenados en forma creciente,
 * de dimensiones n y m respectivamente, y obtenga un tercer arreglo,
 * también ordenado en forma creciente, de dimensión n+m.
 *
 * Ejemplo, si A = [3,7,10,15] y B = [5,6,7] entonces C = [3,5,6,7,7,10,15].
 * Calcular su tiempo de ejecución.
 */
package trabajoPracticoN6;

/**
 *
 * @author Cristian
 * @version 26/10/2015
 */
public class Ejercicio4 {

    public static int[] ordenaArreglo(int[] A, int[] B) {
        int longA, longB, longC, i, j, k;
        int[] C;

        longA = A.length;
        longB = B.length;
        longC = longA + longB;

        C = new int[longC];

        i = 0;
        j = 0;
        k = 0;
        while (i < longA && j < longB) {
            if (A[i] < B[j]) {
                C[k] = A[i];
                i++;
            } else {
                C[k] = B[j];
                j++;
            }

            k++;
        }

        while (i < longA) {
            C[k] = A[i];
            k++;
            i++;
        }

        while (j < longB) {
            C[k] = B[j];
            k++;
            j++;
        }

        return C;
    }

    public static void main(String[] args) {
        int[] A = {3, 7, 10, 15};
        int[] B = {5, 6, 7};
        int[] C;

        C = ordenaArreglo(A, B);

        for (int i = 0; i < C.length; i++) {
            System.out.print(C[i] + " ");
        }
    }

}
