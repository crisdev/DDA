/*
 * Un multiconjunto permite que los elementos de un conjunto estén repetidos.
 * Por ejemplo, el multiconjunto {a, a, b, b, b, c} tiene dos ocurrencias de
 * "a", tres de "b", y una de "c". Defina adicionalmente una operación para
 * determinar la multiplicidad de un elemento. Cada elemento de un multiconjunto
 * tiene asociado una multiplicidad (un número natural), el cual indica cuántas
 * veces el elemento es miembro del conjunto.
 *
 * Su solución deberá verificar que un multiconjunto es válido (puede contener
 * elementos repetidos) y permitirá realizar operaciones entre multiconjuntos:
 * - unión de conjuntos.
 * - diferencia entre conjuntos (elimine múltiples ocurrencias).
 * - intersección entre conjuntos.
 */
package TrabajoPracticoN1;

import Utiles.TecladoIn;

/**
 *
 * @author Cristian
 * @version 21/08/2015
 */
public class Ejercicio6 {
    
    public static void main(String[] args) {
        String conjuntoA, conjuntoB;
        int longA, longB;
        char elemento;
        
        do {
            System.out.print("Ingrese conjunto A: ");
            conjuntoA = TecladoIn.readLine();
            longA = conjuntoA.length();
            System.out.print("Ingrese conjunto B: ");
            conjuntoB = TecladoIn.readLine();
            longB = conjuntoB.length();
            
            // repetir mientras haya caracteres repetidos o longitudes distintas
        } while (longA != longB);
        
        System.out.println("Ingrese elemento: ");
        elemento = TecladoIn.readLineNonwhiteChar();
        
        System.out.println("El elemento \"" + elemento + "\" aparece " + multiplicidad(conjuntoA, elemento)
                            + " veces.");
    }
    
    /**
     * Determina la cantidad de veces que un elemento forma parte de un conjunto.
     * 
     * @param conjunto conjunto de entrada
     * @param elemento elemento que se desea verificar
     * @return cantidad de apariciones del elemento en el conjunto
     */
    public static int multiplicidad(String conjunto, char elemento) {
        int nroMiembros, longitud;
        
        nroMiembros = 0;
        longitud = conjunto.length();
        
        for (int i = 0; i < longitud; i++) {
            if (conjunto.charAt(i) == elemento) {
                nroMiembros++;
            }
        }
        
        return nroMiembros;
    }
}
