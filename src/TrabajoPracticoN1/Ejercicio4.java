/*
 * Resolver el siguiente problema aplicando modularización
 * y conceptos de Strings:
 * Solicitar al usuario un número binario y almacenar en
 * un String de longitud n. Definir operaciones para:
 *
 * a) Obtener el valor del binario ingresado en decimal.
 * b) Obtener el complemento a uno del número binario.
 * c) Obtener el complemento a dos del número binario.
 */
package TrabajoPracticoN1;

import Utiles.TecladoIn;

/**
 *
 * @author Cristian
 * @version 19/08/2015
 */
public class Ejercicio4 {
    
    public static void main(String[] args) {
        String binario;
        
        do {
            System.out.print("Ingrese número binario: ");
            binario = TecladoIn.readLine();
        } while (!esBinario(binario));
        
        System.out.println("El valor decimal es " + binarioADecimal(binario));
        System.out.println("El complemento a uno es " + binarioAC1(binario));
        System.out.println("El complemento a dos es " + binarioAC2(binario));
    }
    
    /**
     * Determina si una cadena de caracteres es un número binario.
     * 
     * @param texto cadena a probar
     * @return verdadero si la cadena es binaria
     */
    public static boolean esBinario(String texto) {
        int longitud;
        boolean nroBinario;
        
        longitud = texto.length();
        nroBinario = true;
        
        for (int i = 0; i < longitud; i++) {
            if (texto.charAt(i) != '0' && texto.charAt(i) != '1') {
                nroBinario = false;
            }
        }
        
        return nroBinario;
    }
    
    /**
     * Convierte un número binario a decimal.
     * 
     * @param textoBinario cadena binaria
     * @return valor decimal
     */
    public static int binarioADecimal(String textoBinario) {
        int exponente, longitud, suma;
        
        suma = 0;
        
        // determino la longitud de la cadena
        longitud = textoBinario.length();
        
        // declaro el exponente de la potencia
        exponente = longitud - 1;
        
        for (int i = 0; i < longitud; i++) {
            
            if(textoBinario.charAt(i) == '1') {
                suma += Math.pow(2, exponente);
            }
            
            exponente = exponente - 1;
            
        }
        
        return suma;
    }
    
    /**
     * Transforma un número binario a complemento a uno.
     * 
     * @param textoBinario cadena binaria
     * @return cadena binaria complementada a uno
     */
    public static String binarioAC1(String textoBinario) {
        String C1;
        int longitud;
        
        C1 = "";
        longitud = textoBinario.length();
        
        for (int i = 0; i < longitud; i++) {
            if (textoBinario.charAt(i) == '0') {
                C1 += '1';
            } else {
                C1 += '0';
            }
        }
        
        return C1;
    }
    
    /**
     * Transforma un número binario a complemento a dos.
     * 
     * @param textoBinario cadena binaria
     * @return cadena binaria complementada a dos
     */
    public static String binarioAC2(String textoBinario) {
        String C2;
        int longitud;
        boolean salioUno;
        char bit;
        
        salioUno = false;
        C2 = "";
        longitud = textoBinario.length();
        
        for (int i = longitud - 1; i >= 0; i--) {
            bit = textoBinario.charAt(i);
            
            if (bit == '1' && !salioUno)
            {
                salioUno = true;
                C2 = "1" + C2;
            }
            else
            {
                if (salioUno)
                {
                    if (bit == '1')
                    {
                        C2 = "0" + C2;
                    }
                    else
                    {
                        C2 = "1" + C2;
                    }
                }   
                else
                {
                    if (bit == '1')
                    {
                        C2 = "1" + C2;
                    }
                    else
                    {
                        C2 = "0" + C2;
                    }
                }
            }
            
        }
        
        return C2;
    }
    
}
