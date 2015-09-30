/*
 * Generador de elementos aleatorios.
 */
package utiles;

/**
 *
 * @author Nacho
 */
public class Aleatorio {

    /**
     * Genera un real aleatorio en el rango especificado
     * 
     * @param min límite inferior del rango
     * @param max límite superior del rango
     * @return real aleatorio entre [min, max]
     */
    public static double doubleAleatorio(int min, int max) {
        return Math.random() * (max - min) + min;
    }

    /**
     * Genera un número entero aleatorio.
     * 
     * @param min ímite inferior del rango
     * @param max límite superior del rango
     * @return entero aleatorio entre [min, max]
     */
    public static int intAleatorio(int min, int max) {
        return (int) doubleAleatorio(min, max);
    }

    /**
     * Genera un caracter aleatorio.
     * 
     * @return caracter aleatorio en mayúscula o minúscula
     */
    public static char charAleatorio() {
        char a;
        if (Math.random() >= 0.5) {
            a = (char) intAleatorio(97, 123);
        } else {
            a = (char) intAleatorio(65, 91);
        }
        return a;
    }

    /**
     * Genera una cadena de texto aleatoria del tamaño indicado.
     * 
     * @param tam longitud de la cadena de texto
     * @return texto aleatorio del tamaño indicado
     */
    public static String stringAleatorio(int tam) {
        String res = "";
        for (int i = 0; i < tam; i++) {
            res = res + charAleatorio();
        }
        return res;
    }
}
