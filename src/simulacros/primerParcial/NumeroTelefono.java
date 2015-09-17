/*
 * En una provincia se están cambiando los números de teléfonos celulares de
 * 8 dígitos de la siguiente manera: luego del 15 se agrega un 4, los 3 números
 * sucesivos se invierten y se colocan al final. Por ejemplo el número 15560432
 * queda 154432065. Implementar en pseudocódigo un algoritmo que dado un número
 * de teléfono almacenado como cadena de caracteres genere el nuevo número.
 * Resolver el ejercicio recorriendo en la cadena caracter por caracter.
 *
 * IMPORTANTE: La cadena de caracteres de entrada siempre tendrá una secuencia de
 * dígitos que representa un número de celular, es decir que no posee espacios en
 * blanco, ni caracteres especiales, y la longitud de la cadena de entrada es
 * siempre 8.
 */
package simulacros.primerParcial;

/**
 *
 * @author Cristian
 * @version 17/09/2015
 */
public class NumeroTelefono {

    public static void main(String[] args) {
        String numero = "15560432";

        System.out.println(cambia(numero));
    }

    public static String cambia(String numero) {
        int i;
        String inicio = "154";
        String medio = "";
        String fin = "";

        for (i = 2; i <= 4; i++) {
            fin = numero.charAt(i) + fin;
        }

        for (i = 5; i < numero.length(); i++) {
            medio = medio + numero.charAt(i);
        }

        return inicio + medio + fin;
    }
}
