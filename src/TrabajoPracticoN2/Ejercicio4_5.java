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
package TrabajoPracticoN2;

import Utiles.TecladoIn;

/**
 *
 * @author Cristian
 * @version 30/08/2015
 */
public class Ejercicio4_5 {
    
    public static void main(String[] args) {
        int n;
        char[] conjuntoA, conjuntoB;
        
        System.out.println("Ingrese el número de elementos de los conjuntos: ");
        n = TecladoIn.readLineInt();
        
        conjuntoA = new char[n];
        conjuntoB = new char[n];
        
        repetir:
        do {
            for (int i = 0; i < conjuntoA.length; i++) {
                System.out.println("Ingrese elemento " + (i+1) + " del conjunto A: ");
                conjuntoA[i] = TecladoIn.readLineNonwhiteChar();
            }
        } while (hayRepetidos(conjuntoA));
        
        do {
            for (int i = 0; i < conjuntoA.length; i++) {
                System.out.println("Ingrese elemento " + (i+1) + " del conjunto B: ");
                conjuntoB[i] = TecladoIn.readLineNonwhiteChar();
            }
        } while (hayRepetidos(conjuntoB));
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
        
        while (i<arregloCaracteres.length && !repetido) {
            primerElemento = arregloCaracteres[i];
            while (j<arregloCaracteres.length && !repetido) {
                if (primerElemento == arregloCaracteres[j]) {
                    repetido = true;
                }
                j++;
            }
            i++;
        }
        
        return repetido;
    }
    
}
