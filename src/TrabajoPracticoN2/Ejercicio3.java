/*
 * Para los arreglos de los incisos e y f,
 * definir métodos que permitan consultar si un número o una palabra
 * (según corresponda) es parte del arreglo.
 */
package TrabajoPracticoN2;

import java.util.Random;
import Utiles.TecladoIn;

/**
 *
 * @author Cristian
 * @version 29/08/2015
 */
public class Ejercicio3 {

    public static void main(String[] args) {
        int numero;

    // inciso E
        int[] enteroAleatorio;
        int estaPresente;
        enteroAleatorio = new int[50];

        Random r = new Random();
        for (int i = 0; i < enteroAleatorio.length; i++) {
            enteroAleatorio[i] = r.nextInt(101);
        }

        System.out.print("Ingrese un número a buscar: ");
        numero = TecladoIn.readLineInt();

        estaPresente = estaElNumero(enteroAleatorio, numero);

        if (estaPresente != -1) {
            System.out.println("El número se encuentra en el elemento " + estaPresente + ".");
        } else {
            System.out.println("El número no está presente.");
        }

    // inciso F
        int posicion;
        String buscar;
        String[] palabra = {"manzana", "semilla", "cielo", "casa", "auto",
                            "ceniza", "pez", "granjero", "árbol", "piedra",
                            "ladrillo", "lápiz", "reloj", "goma", "huevo"};

        System.out.print("Ingrese una palabra a buscar: ");
        buscar = TecladoIn.readLine();

        posicion = estaLaPalabra(palabra, buscar);

        if (posicion != -1) {
            System.out.println("La palabra se encuentra en el elemento " + posicion);
        } else {
            System.out.println("La palabra no se encuentra en el arreglo.");
        }
    }

    /**
     * Verifica si un valor está presente en un arreglo.
     *
     * @param arreglo arreglo que se desea analizar
     * @param valor número a buscar
     * @return posición del número en el arreglo, sino -1
     */
    public static int estaElNumero(int[] arreglo, int valor) {
        int posicion, i;
        boolean encontrado;

        posicion = -1;
        encontrado = false;
        i = 0;

        while (i<arreglo.length && !encontrado) {
            if (arreglo[i] == valor) {
                posicion = i;
                encontrado = true;
            }

            i++;
        }

        return posicion;
    }

    /**
     * Verifica si una palabra está presente en un arreglo de palabras.
     *
     * @param elemento colección de palabras
     * @param palabra palabra que deseamos saber si existe en la colección
     * @return ubicación de la palabra en la colección
     */
    public static int estaLaPalabra(String[] elemento, String palabra) {
        int posicion, i;
        boolean encontrado;

        posicion = -1;
        encontrado = false;
        i = 0;

        while (i<elemento.length && !encontrado) {
            if (elemento[i].equalsIgnoreCase(palabra)) {
                posicion = i;
                encontrado = true;
            }

            i++;
        }

        return posicion;
    }

}
