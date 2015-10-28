/*
 * Escribir un planteo recursivo, desarrollar su implementación en java y realizar
 * la traza indicada para:
 *
 * a) Contar la cantidad de dígitos de un número entero positivo n. Realizar la traza para n = 32154.
 * b) Dado un número entero positivo n y un dígito t, contar la cantidad de veces que aparece el
 * dígito t en el número n. Por ejemplo si n = 13234 y t = 3, el resultado debe ser 2.
 * Realizar la traza para los valores del ejemplo.
 */
package trabajoPracticoN7;

/**
 *
 * @author Cristian
 * @version 28/10/2015
 */
public class Ejercicio3 {

    /**
     * Determina recursivamente la cantidad de apariciones de un dígito
     * sobre un número.
     * 
     * @param n número de ingreso
     * @param t dígito que aparece en n
     * @return cantidad de apariciones de t en n
     */
    public static int cantidadApariciones(int n, int t) {
        int contador, p;

        contador = 0;
        p = 0;

        if (n % 10 == t) {
            p = p + 1;
        }

        if (n / 10 == 0) {
            contador = p;
        } else {
            contador = cantidadApariciones(n / 10, t) + p;
        }

        return contador;
    }

    /**
     * Calcula recursivamente la cantidad de dígitos que posee un número.
     * 
     * @param n un número entero
     * @return cantidad de dígitos de n
     */
    public static int cantidadDigitos(int n) {
        int cantidad;

        if (n > 0) {
            cantidad = cantidadDigitos(n / 10) + 1;
        } else {
            cantidad = 0;
        }

        return cantidad;
    }

    public static void main(String[] args) {
        int numero = 32154;
        int numero2 = 282321504;

        System.out.println(cantidadDigitos(numero));
        System.out.println(cantidadApariciones(numero2, 2));
    }

}
