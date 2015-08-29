/*
 * Rehacer los ejercicios 4, 5 y 6 del práctico 1 pero utilizando arreglos.
 */
package TrabajoPracticoN2;

import Utiles.TecladoIn;

/**
 *
 * @author Cristian
 * @version 29/08/2015
 */
public class Ejercicio4 {
    
    public static void main(String[] args) {
        String cadenaBinaria;
        int[] numeroBinario;
        int longitud;
        
        System.out.print("Ingrese un número binario: ");
        cadenaBinaria = TecladoIn.readLine();
        
        while (!esBinario(cadenaBinaria)) {
            System.out.println("El número introducido es incorrecto.");
            System.out.println("Ingrese un número binario: ");
            cadenaBinaria = TecladoIn.readLine();
        }
        
        longitud = cadenaBinaria.length();

        numeroBinario = new int[longitud];
        
        for (int i = 0; i < longitud; i++) {
            numeroBinario[i] = Integer.parseInt(cadenaBinaria.substring(i, i+1));
        }
        
        System.out.println("Binario a decimal: " + binarioADecimal(numeroBinario));
        binarioAC1(numeroBinario);
        
        System.out.print("Binario a C1: ");
        for (int i = 0; i < numeroBinario.length; i++) {
            System.out.print(numeroBinario[i]);
        }
        
        System.out.println();
    }
    
    /**
     * Determina si la cadena enviada como parámetro es un número binario.
     * 
     * @param cadenaBinaria cadena a comprobar
     * @return verdadero si todos los caracteres son binarios
     */
    public static boolean esBinario(String cadenaBinaria) {
        boolean esBinario;
        char elemento;
        int i, longitud;
        
        esBinario = true;
        longitud = cadenaBinaria.length();
        i = 0;
        
        if (longitud == 0) {
            esBinario = false;
        }
        
        while (i<longitud && esBinario) {
            elemento = cadenaBinaria.charAt(i);
            
            if (elemento != '0' && elemento != '1') {
                esBinario = false;
            }
            
            i++;
        }
        
        return esBinario;
    }
    
    /**
     * Convierte un número binario a decimal.
     * 
     * @param arregloBinario cadena binaria
     * @return valor decimal
     */
    public static int binarioADecimal(int[] arregloBinario) {
        int exponente, longitud, suma;
        
        suma = 0;
        
        // determino la longitud de la cadena
        longitud = arregloBinario.length;
        
        // declaro el exponente de la potencia
        exponente = longitud - 1;
        
        for (int i = 0; i < longitud; i++) {
            
            if(arregloBinario[i] == 1) {
                suma += Math.pow(2, exponente);
            }
            
            exponente = exponente - 1;
        }
        
        return suma;
    }
    
    /**
     * Transforma un arreglo binario a complemento a uno.
     * 
     * @param arregloBinario cadena binaria
     */
    public static void binarioAC1(int[] arregloBinario) {
        int longitud;
        
        longitud = arregloBinario.length;
        
        for (int i = 0; i < longitud; i++) {
            if (arregloBinario[i] == 0) {
                arregloBinario[i] = 1;
            } else {
                arregloBinario[i] = 0;
            }
        }
    }
    
}
