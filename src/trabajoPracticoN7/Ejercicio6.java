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
 * @version 2/11/2015
 */
public class Ejercicio6 {

    /**
     * Imprime una secuencia de caracteres excluyendo el parámetro ingresado.
     * 
     * @param c caracter a excluir en la representación
     */
    public static void imprimir(char c) {
        char e;
        
        System.out.print("Ingrese un caracter o . para terminar: ");
        e = TecladoIn.readLineNonwhiteChar();
        
        if (e == '.') {
            e = '\0';
        } else {
            if (e == c) {
                e = '\0';
            }
            imprimir(c);
        }

        System.out.print(e);
    }
    
    public static int cuentaCaracter(char a) {
        int contador = 0;
        char e;
        
        System.out.print("Ingrese un caracter o . para terminar: ");
        e = TecladoIn.readLineNonwhiteChar();
        
        if (e != '.') {
            if (e == a) {
                contador++;
                cuentaCaracter(a);
            } else {
                cuentaCaracter(a);
            }
        }
        
        return contador;
    }

    public static void main(String[] args) {
        char caracter;

        //System.out.print("Ingrese un caracter a excluir: ");
        //caracter = TecladoIn.readLineNonwhiteChar();

        //imprimir(caracter);
        
        System.out.print("Ingrese un caracter a contar: ");
        caracter = TecladoIn.readLineNonwhiteChar();
        
        System.out.println("Repeticiones: " + cuentaCaracter(caracter));
    }
}
