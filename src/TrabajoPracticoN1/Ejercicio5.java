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
        int longA, longB;
        
        do {
            System.out.print("Ingrese conjunto A: ");
            conjuntoA = TecladoIn.readLine();
            longA = conjuntoA.length();
            System.out.print("Ingrese conjunto B: ");
            conjuntoB = TecladoIn.readLine();
            longB = conjuntoB.length();
            
            // repetir mientras haya caracteres repetidos o longitudes distintas
        } while (longA != longB || verificaRepetidos(conjuntoA) || verificaRepetidos(conjuntoB));
        
        System.out.println("\nUnion: " + union(conjuntoA, conjuntoB));
        System.out.println("Intersección: " + interseccion(conjuntoA, conjuntoB));
        System.out.println("Diferencia A - B: " + diferencia(conjuntoA, conjuntoB));
        System.out.println("Diferencia B - A: " + diferencia(conjuntoB, conjuntoA));
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
     * @param conjuntoA primer conjunto a analizar
     * @param conjuntoB segundo conjunto a analizar
     * @return conjunto con elementos sin repetir del primer y segundo conjunto
     */
    public static String union(String conjuntoA, String conjuntoB) {
        String union;
        int longitud;
        
        union = conjuntoA;
        longitud = conjuntoA.length();
        
        for (int i = 0; i < longitud; i++) {
            // si el caracter no está lo añado al conjunto union
            if (conjuntoA.indexOf(conjuntoB.charAt(i)) == -1) {
                union += conjuntoB.charAt(i);
            }
        }
        
        return union;
    }
    
    /**
     * Determina la intersección entre dos conjuntos.
     * 
     * @param conjuntoA primer conjunto
     * @param conjuntoB segundo conjunto
     * @return conjunto interseccion de elementos repetidos
     */
    public static String interseccion(String conjuntoA, String conjuntoB) {
        String interseccion;
        
        int longitud;
        
        interseccion = "";
        longitud = conjuntoA.length();
        
        for (int i = 0; i < longitud; i++) {
            // añado caracter al conjunto interseccion solo si está repetido
            if (conjuntoA.indexOf(conjuntoB.charAt(i)) != -1) {
                interseccion += conjuntoB.charAt(i);
            }
        }
        
        return interseccion;
    }
    
    /**
     * Calcula la diferencia entre dos conjuntos.
     * 
     * @param conjuntoA primer conjunto de entrada
     * @param conjuntoB segundo conjunto de entrada
     * @return diferencia entre el primer y segundo conjunto
     */
    public static String diferencia(String conjuntoA, String conjuntoB) {
        String interseccion;
        String diferencia;
        char elementoInter, elementoConjA;
        boolean estaPresente;
        int i, j;
        
        interseccion = interseccion(conjuntoA, conjuntoB);
        diferencia = "";
        estaPresente = false;
        
        /*
        El código que sigue se puede remplazar por una sola línea de código:
        
        return conjuntoA.replaceAll(interseccion, "");
        */
        
        for (i = 0; i < conjuntoA.length(); i++) {
            elementoConjA = conjuntoA.charAt(i);  // indice del conjuto A
            
            j = 0;
            while (!estaPresente && j<interseccion.length()) {
                elementoInter = interseccion.charAt(j);
                if (elementoConjA == elementoInter) {
                    estaPresente = true;
                }
                    
                j++;
            }
                
            if (!estaPresente) {
                diferencia += elementoConjA;
            }
            
            estaPresente = false;
        }

        return diferencia;
    }
    
}
