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
package TrabajoPracticoN1;

import Utiles.TecladoIn;

/**
 *
 * @author Cristian
 * @version 20/08/2015
 */
public class Ejercicio5 {
    
    public static void main(String[] args) {
        String conjuntoA, conjuntoB;
        
        do {
            System.out.println("Ingrese conjunto A: ");
            conjuntoA = TecladoIn.readLine();
            System.out.println("Ingrese conjunto B: ");
            conjuntoB = TecladoIn.readLine();
        } while (verificaRepetidos(conjuntoA) || verificaRepetidos(conjuntoB));
        
        System.out.println("Union: " + union(conjuntoA, conjuntoB));
    }
    
    /**
     * Verifica si una cadena de texto contiene caracteres repetidos.
     * 
     * @param texto cadena de texto a verificar
     * @return true si hay caracteres repetidos
     */
    public static boolean verificaRepetidos(String texto) {
        int longitud;
        char letraInicial;
        boolean estaRepetido;
        
        longitud = texto.length();
        estaRepetido = false;
        
        for (int i = 0; i < longitud; i++) {
            letraInicial = texto.charAt(i);
            
            for (int j = i+1; j < longitud; j++) {
                if (letraInicial == texto.charAt(j)) {
                    estaRepetido = true;
                }
            }
        }
        
        return estaRepetido;
    }
    
    /**
     * Determina la unión de dos conjuntos.
     * 
     * @param primerConjunto primer conjunto a analizar
     * @param segundoConjunto segundo conjunto a analizar
     * @return conjunto con elementos sin repetir del primer y segundo conjunto
     */
    public static String union(String primerConjunto, String segundoConjunto) {
        String union;
        int longitud;
        char pivote;
        boolean estaRepetido;
        
        longitud = primerConjunto.length();
        estaRepetido = false;
        union = "";
        
        for (int i = 0; i < longitud; i++) {
            pivote = primerConjunto.charAt(i);
            
            for (int j = 0; j < longitud; j++) {
                if (pivote == segundoConjunto.charAt(j)) {
                    estaRepetido = true;
                }
            }
            
            if(!estaRepetido) {
                union += pivote;
            }
            
        }
        
        return union;
    }
    
}
