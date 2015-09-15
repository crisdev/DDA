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
package trabajoPracticoN1;

import utiles.TecladoIn;

/**
 *
 * @author Cristian
 * @version 21/08/2015
 */
public class Ejercicio6 {
    
    public static void main(String[] args) {
        String conjuntoA, conjuntoB;
        
        System.out.print("Ingrese conjunto A: ");
        conjuntoA = TecladoIn.readLine();
        System.out.print("Ingrese conjunto B: ");
        conjuntoB = TecladoIn.readLine();
        
        System.out.println("\nUnión de A y B: " + union(conjuntoA, conjuntoB));
        System.out.println("Intersección entre A y B: " + interseccion(conjuntoA, conjuntoB));
        System.out.println("Diferencia entre A y B: " + diferencia(conjuntoA, conjuntoB));
        System.out.println("Diferencia entre B y A: " + diferencia(conjuntoB, conjuntoA));
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
    
    /**
     * Retorna la unión de dos multiconjuntos.
     * 
     * @param conjuntoA primer conjunto de entrada
     * @param conjuntoB segundo conjunto de entrada
     * @return unión de los conjuntos introducidos como parámetros
     */
    public static String union(String conjuntoA, String conjuntoB) {
        String union;
        int multiplicidadA, multiplicidadB;
        char elementoA, elementoB;
        
        union = "";
        
        for (int i = 0; i < conjuntoA.length(); i++) {
            elementoA = conjuntoA.charAt(i);
            multiplicidadA = multiplicidad(conjuntoA, elementoA);
            multiplicidadB = multiplicidad(conjuntoB, elementoA);
            
            if (multiplicidadA > multiplicidadB) {
                union += elementoA;
            }
        }
        
        for (int i = 0; i < conjuntoB.length(); i++) {
            elementoB = conjuntoB.charAt(i);
            multiplicidadA = multiplicidad(conjuntoA, elementoB);
            multiplicidadB = multiplicidad(conjuntoB, elementoB);
            
            if (multiplicidadB >= multiplicidadA) {
                union += elementoB;
            }
        }
        
        return union;
    }
    
    /**
     * Determina la intersección de dos multiconjuntos
     * 
     * @param conjuntoA primer multiconjunto de entrada
     * @param conjuntoB segundo multiconjunto de entrada
     * @return intersección entre los dos conjuntos de entrada
     */
    public static String interseccion(String conjuntoA, String conjuntoB) {
        String interseccion;
        String abecedario; 
        char letra;
        
        abecedario = "abcdefghijklmnñopqrstuvwxyz";
        interseccion = "";
        
        for (int i = 0; i < abecedario.length(); i++) {
            letra = abecedario.charAt(i);
            if (multiplicidad(conjuntoA, letra) >= multiplicidad(conjuntoB, letra)) {
                for (int j = 0; j < multiplicidad(conjuntoB, letra); j++) {
                    interseccion += letra;
                }
            } else {
                for (int j = 0; j < multiplicidad(conjuntoA, letra); j++) {
                    interseccion += letra;
                }
            }
            
        }
        
        return interseccion;
    }
    
    /**
     * Calcula la diferencia entre dos multiconjuntos.
     * 
     * @param conjuntoA primer conjunto de entrada
     * @param conjuntoB segundo conjunto de entrada
     * @return diferencia entre el primer y el segundo conjunto
     */
    public static String diferencia(String conjuntoA, String conjuntoB) {
        String interseccion, diferencia;
        int repeticiones, i;
        char elemento;
        
        diferencia = conjuntoA;
        interseccion = interseccion(conjuntoA, conjuntoB);
        repeticiones = interseccion.length();
        i = 0;
        
        if (!interseccion.equals("")) {
            while (repeticiones > 0) {
                elemento = interseccion.charAt(i);
                diferencia = diferencia.substring(0, diferencia.indexOf(elemento)) + diferencia.substring(diferencia.indexOf(elemento) + 1);
                i++;
                repeticiones--;
            }
        }
        
        return diferencia;
    }
}
