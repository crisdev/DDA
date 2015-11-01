/*
 * Dada una secuencia de caracteres (finalizada en ".") ingresada por teclado,
 * escribir planteos recursivos, desarrollar sus correspondientes métodos y
 * realizar la traza de cada inciso.
 *
 * a) Mostrar en orden inverso todos los caracteres de la secuencia distintos
 *    a un caracter dado.
 * b) Determinar la cantidad de veces que aparece un carácter dado en la secuencia.
 */
package trabajoPracticoN7;

import utiles.TecladoIn;

/**
 *
 * @author Cristian
 * @version 31/10/2015
 */
public class Ejercicio6 {
    
    public static char imprimir(char c) {
        char e;
        
        System.out.print("Ingrese un caracter (. para terminar): ");
        e = TecladoIn.readLineNonwhiteChar();
        
        if (e != '.') {
            if (c != e) {
                System.out.print(imprimir(e));
            } else {
                System.out.println("hola");
            }
        } else {
            e  = '\0';
        }
        
        return e;
    }
    
    public static void main(String[] args) {
        char caracter;
        
        System.out.print("Ingrese un caracter a excluir: ");
        caracter = TecladoIn.readLineNonwhiteChar();
        
        imprimir(caracter);
    }
}