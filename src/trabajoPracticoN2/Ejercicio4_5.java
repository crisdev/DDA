/*
 * Solicitar al usuario los elementos de dos conjuntos A y B de cardinalidad
 * fija (digamos n). Cada conjunto estará compuesto por caracteres. Su solución
 * deberá verificar que los conjuntos son válidos (no tienen elementos repetidos)
 * y permitirá realizar operaciones entre conjuntos:
 * - mostrar los elementos que lo componen
 * - unión de conjuntos
 * - diferencia entre conjuntos
 * - intersección entre conjuntos
 */
package trabajoPracticoN2;

import utiles.TecladoIn;

/**
 *
 * @author Cristian
 * @version 30/08/2015
 */
public class Ejercicio4_5 {

    public static void main(String[] args) {
        int n;
        char[] conjuntoA, conjuntoB;

        System.out.print("Ingrese el número de elementos de los conjuntos: ");
        n = TecladoIn.readLineInt();

        conjuntoA = new char[n];
        conjuntoB = new char[n];

        do {
            for (int i = 0; i < conjuntoA.length; i++) {
                System.out.print("Ingrese elemento " + (i + 1) + " del conjunto A: ");
                conjuntoA[i] = TecladoIn.readLineNonwhiteChar();
            }
        } while (hayRepetidos(conjuntoA));

        do {
            for (int i = 0; i < conjuntoA.length; i++) {
                System.out.print("Ingrese elemento " + (i + 1) + " del conjunto B: ");
                conjuntoB[i] = TecladoIn.readLineNonwhiteChar();
            }
        } while (hayRepetidos(conjuntoB));

        System.out.println("Unión de conjuntos:");
        mostrarMatriz(unir(conjuntoA, conjuntoB));
    }

    /**
     * Verifica si hay repetidos en un arreglo de caracteres.
     *
     * @param arregloCaracteres arreglo de caracteres
     * @return verdadero si hay caracteres repetidos
     */
    public static boolean hayRepetidos(char[] arregloCaracteres) {
        boolean repetido = false;
        char primerElemento;
        int i, j;

        j = 1;
        i = 0;

        while (i < arregloCaracteres.length && !repetido) {
            primerElemento = arregloCaracteres[i];
            while (j < arregloCaracteres.length && !repetido) {
                if (primerElemento == arregloCaracteres[j]) {
                    repetido = true;
                }
                j++;
            }
            i++;
        }

        return repetido;
    }

    /**
     * Muestra por pantalla los elementos de una matriz.
     *
     * @param conjunto matriz que se desea visualizar
     */
    public static void mostrarMatriz(char[] conjunto) {
        System.out.print("Elementos: ");
        for (int i = 0; i < conjunto.length; i++) {
            if (conjunto[i] != '\0') {
                System.out.print(conjunto[i] + " ");
            }
        }
    }

    /**
     * Une dos conjuntos, removiendo los elementos repetidos.
     *
     * @param conjuntoA primer conjunto de entrada
     * @param conjuntoB segundo conjunto de entrada
     * @return conjunto unión entre el primer y segundo conjunto
     */
    public static char[] unir(char[] conjuntoA, char[] conjuntoB) {
        int i, j;
        char[] union;

        union = new char[conjuntoA.length + conjuntoB.length];

        // copio las dos matrices en una
        for (i = 0; i < conjuntoA.length; i++) {
            union[i] = conjuntoA[i];
        }
        for (j = 0; j < conjuntoB.length; j++) {
            union[i] = conjuntoB[j];
            i++;
        }

        // elimino los elementos repetidos
        for (i = 0; i < union.length; i++) {
            for (j = i + 1; j < union.length; j++) {
                if (union[i] == union[j]) {
                    union[j] = '\0';
                }
            }
        }

        return union;
    }

}
