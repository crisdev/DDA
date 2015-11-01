/*
 * Dada una secuencia S de números enteros positivos (finalizada en 0, que no se
 * considera parte de la secuencia) ingresados por teclado, escribir planteos
 * recursivos, sus correspondientes métodos, y realizar la traza para la secuencia
 * 2 5 3 6 12 3 0 en los siguientes incisos:
 *
 * a) Calcular cuántos enteros múltiplos de 4 hay en la secuencia.
 * b) Determinar el máximo entero perteneciente a la secuencia.
 */
package trabajoPracticoN7;

import utiles.TecladoIn;

/**
 *
 * @author Cristian
 * @version 31/10/2015
 */
public class Ejercicio5 {

    /**
     * Calcula recursivamente la cantidad de mútiplos de 4 de una entrada de
     * números.
     *
     * @return múltiplos de 4
     */
    public static int multiplosDeCuatro() {
        int cantidad, n;

        System.out.print("Ingrese un número: ");
        n = TecladoIn.readLineInt();

        if (n <= 0) {
            cantidad = 0;
        } else {
            if (n % 4 == 0) {
                cantidad = 1 + multiplosDeCuatro();
            } else {
                cantidad = multiplosDeCuatro();
            }
        }

        return cantidad;
    }

    public static int mayorValor() {
        // TODO
    }

    public static void main(String[] args) {
        System.out.println("Cantidad de múltiplos de 4: " + multiplosDeCuatro());
    }
}
