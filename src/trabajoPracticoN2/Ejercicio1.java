/*
 * Declare, cree e inicialice arreglos para cada uno de los siguientes casos:
 * a. Un arreglo de vocales.
 * b. Un arreglo de enteros consecutivos del 1 al 1000.
 * c. Un arreglo de los enteros impares consecutivos entre 10000 y 50000
 * d. Un arreglo de letras del abecedario (ordenadas alfabéticamente).
 *    Considere que las letras del abecedario aparece en orden correlativo en la
 *    tabla unicode.
 * e. Un arreglo de 50 números enteros aleatorios entre 0 y 100.
 * f. Un arreglo de 15 palabras.
 * g. Un arreglo de 15 temperaturas.
 * h. Un arreglo de 14 alturas de personas.
 */
package trabajoPracticoN2;

import java.util.Random;

/**
 *
 * @author Cristian
 * @date 28/08/2015
 */
public class Ejercicio1 {

    public static void main(String[] args) {
    /* INCISO A */

        // declaración
        char[] vocal;

        // creación
        vocal = new char[5];

        // inicialización
        vocal[0] = 'a';
        vocal[1] = 'e';
        vocal[2] = 'i';
        vocal[3] = 'o';
        vocal[4] = 'u';

        // muestra por pantalla
        for (int i = 0; i < vocal.length; i++) {
            System.out.print(vocal[i] + " ");
        }

        System.out.println();

    /* INCISO B */

            // declaración
            int[] enteroConsecutivo;

            // creación
            enteroConsecutivo = new int[1000];

            // inicialización
            for (int i = 0; i < enteroConsecutivo.length; i++) {
                enteroConsecutivo[i] = i + 1;
            }

            // muestra por pantalla
            System.out.println(enteroConsecutivo[0] + "..." + enteroConsecutivo[999]);

    /* INCISO C */

        // declaración
        int[] enteroImparConsecutivo;

        // creación
        enteroImparConsecutivo = new int[20000];

        // inicialización
        for (int i = 0; i < enteroImparConsecutivo.length; i++) {
            enteroImparConsecutivo[i] = 10000 + (2*i + 1);
        }

        // muestra por pantalla
        System.out.println(enteroImparConsecutivo[0] + "..." + enteroImparConsecutivo[19999]);

    /* INCISO D */

        // declaración
        char[] abecedario;

        // creación (ASCII no tiene la Ñ)
        abecedario = new char[26];

        // inicialización
        for (int i = 0; i < abecedario.length; i++) {
            // 97 = 'a'
            abecedario[i] = (char) (97 + i);
        }

        // muestra por pantalla
        for (int i = 0; i < abecedario.length; i++) {
            System.out.print(abecedario[i] + " ");
        }

        System.out.println();

    /* INCISO E */

        // declaración
        int[] enteroAleatorio;

        // creación
        enteroAleatorio = new int[50];

        // inicialización
        Random r = new Random();
        for (int i = 0; i < enteroAleatorio.length; i++) {
            enteroAleatorio[i] = r.nextInt(101);
        }

        // muestra por pantalla
        for (int i = 0; i < enteroAleatorio.length; i++) {
            System.out.print(enteroAleatorio[i] + " ");
        }

        System.out.println();

    /* INCISO F */

        // declaración, creación e inicialización
        String[] palabra = {"manzana", "semilla", "cielo", "casa", "auto",
                            "ceniza", "pez", "granjero", "árbol", "piedra",
                            "ladrillo", "lápiz", "reloj", "goma", "huevo"};

        // muestra por pantalla
        for (int i = 0; i < palabra.length; i++) {
            System.out.print(palabra[i] + " ");
        }

        System.out.println();

    /* INCISO G */

        // declaración, creación e inicialización
        double[] temperatura = {23.3, 22.0, 18.2, 13.3, 9.2, 6.1, 5.6,
                                8.1, 11.2, 15.3, 19.3, 22.2, 32.1, 14.0, 3.1};

        // muestra por pantalla
        for (int i = 0; i < temperatura.length; i++) {
            System.out.print(temperatura[i] + " ");
        }

        System.out.println();

    /* INCISO H */

        // declaración, creación e inicialización
        double[] altura = {1.82, 1.77, 1.60, 1.83, 1.65, 1.90, 2.10, 1.78,
                           2.01, 1.66, 1.87, 1.79, 1.67, 2.20};

        // muestra por pantalla
        for (int i = 0; i < altura.length; i++) {
            System.out.print(altura[i] + " ");
        }

        System.out.println();
    }
}
