/*
 * Especificar el esquema UML para una Matriz que posea una estructura capaz de
 * almacenar una matriz de enteros de una dimensión definida por el usuario y
 * permita realizar las operaciones matemáticas básicas de matrices (suma,
 * resta, etc.).
 * - Implementar el TDA Matriz
 * - Implementar la clase testMatriz que permita probar toda la funcionalidad
 *   del TDA
 */
package trabajoPracticoN4.clases;

import java.util.Random;

/**
 *
 * @author Cristian
 * @version 15/09/2015
 */
public class Matriz {

    private final int[][] matriz;
    private final int fil;  // Cantidad de filas de la matriz
    private final int col;  // Cantidad de columnas de la matriz

    /**
     * Método Constructor: genera una matriz cuadrada.
     *
     * @param n tamaño de la matriz
     */
    public Matriz(int n) {
        fil = n;
        col = n;
        matriz = new int[fil][col];
 
    }

    /**
     * Método Constructor: genera una matriz de nxm.
     *
     * @param n cantidad de filas de la matriz
     * @param m cantidad de columnas de la matriz
     */
    public Matriz(int n, int m) {
        fil = n;
        col = m;
        matriz = new int[fil][col];
    }

    /**
     * Muestra por pantalla la matriz creada.
     */
    public void mostrarMatriz() {
        int i, j;

        for (i = 0; i < fil; i++) {
            for (j = 0; j < col; j++) {
                System.out.printf("%4d ", matriz[i][j]);
            }
            System.out.println();
        }
        System.out.println("-----------------------");
    }

    /**
     * Suma dos matrices.
     *
     * @param nueva matriz que se desea sumar
     * @return matriz sumada
     */
    public Matriz suma(Matriz nueva) {
        int i, j;

        Matriz suma = new Matriz(fil, col);

        if (verificarOperacion(nueva)) {
            for (i = 0; i < fil; i++) {
                for (j = 0; j < col; j++) {
                    suma.matriz[i][j] = matriz[i][j] + nueva.matriz[i][j];
                }
            }
        } else {
            System.out.println("La operación no se puede realizar.");
        }

        return suma;
    }

    /**
     * Resta dos matrices.
     *
     * @param nueva matriz que se desea restar
     * @return matriz restada
     */
    public Matriz resta(Matriz nueva) {
        int i, j;

        Matriz resta = new Matriz(fil, col);

        if (verificarOperacion(nueva)) {
            for (i = 0; i < fil; i++) {
                for (j = 0; j < col; j++) {
                    resta.matriz[i][j] = matriz[i][j] - nueva.matriz[i][j];
                }
            }
        } else {
            System.out.println("La operación no se puede realizar.");
        }

        return resta;
    }

    /**
     * Multiplica una matriz por un escalar.
     *
     * @param entero valor entero que multiplicará a la matriz
     * @return matriz multiplcada por entero
     */
    public Matriz productoEscalar(int entero) {
        int i, j;

        Matriz producto = new Matriz(fil, col);

        for (i = 0; i < fil; i++) {
            for (j = 0; j < col; j++) {
                producto.matriz[i][j] = matriz[i][j] * entero;
            }
        }

        return producto;
    }

    /**
     * Multiplica dos matrices.
     *
     * @param nueva matriz a multiplicar
     * @return matriz multiplicada
     */
    public Matriz producto(Matriz nueva) {
        int i, j, k, sumaTemporal;

        Matriz producto = new Matriz(fil, nueva.col);

        if (verificarProducto(nueva)) {
            for (i = 0; i < fil; i++) {
                for (j = 0; j < nueva.col; j++) {
                    sumaTemporal = 0;

                    for (k = 0; k < col; k++) {
                        sumaTemporal += matriz[i][k] * nueva.matriz[k][j];
                    }

                    producto.matriz[i][j] = sumaTemporal;
                }
            }
        } else {
            System.out.println("La operación no se puede realizar.");
        }

        return producto;
    }

    /**
     * Modifica el valor de un elemento de la matriz.
     *
     * @param i fila elegida, comenzando en 1 terminando en n
     * @param j columna elegida, comenzando en 1 terminando en n
     * @param valor valor a fijar
     */
    public void modificaValor(int i, int j, int valor) {
        if (i >= 0 && i < fil && j >= 0 && j < col) {
            matriz[i-1][j-1] = valor;
        } else {
            System.out.println("Posición inexistente.");
        }
    }

    /**
     * Copia (clona) una matriz.
     *
     * @return matriz clonada
     */
    public Matriz clonar() {
        int i, j;
        Matriz matrizClonada = new Matriz(fil, col);

        for (i = 0; i < fil; i++) {
            for (j = 0; j < col; j++) {
                matrizClonada.matriz[i][j] = matriz[i][j];
            }
        }

        return matrizClonada;
    }

    /**
     * Modifica un objeto matriz para inicializarla con valores aleatorios
     * de 0 a 10.
     */
    public void generarNrosAleatorios() {
        Random r = new Random();

        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                matriz[i][j] = r.nextInt(11);
            }
        }
    }

    /**
     * Genera una nueva matriz transpuesta.
     *
     * @return matriz transpuesta
     */
    public Matriz transponer() {
        int i, j;

        Matriz transpuesta = new Matriz(col, fil);

        for (i = 0; i < fil; i++) {
            for (j = 0; j < col; j++) {
                transpuesta.matriz[i][j] = matriz[i][j];
            }
        }

        return transpuesta;
    }

// Métodos auxiliares

    /**
     * Verifica si es posible realizar una operación básica entre matrices
     * como suma o resta.
     *
     * @param nueva matriz que se desea verificar
     * @return verdadero si es posible realizar la operación
     */
    private boolean verificarOperacion(Matriz nueva) {
        boolean esPosible;

        esPosible = false;
        if (fil == nueva.fil && col == nueva.col) {
            esPosible = true;
        }

        return esPosible;
    }

    /**
     * Verifica si es posible realizar el producto entre dos matrices.
     *
     * @param nueva matriz a verificar
     * @return verdadero si las matrices se pueden multiplicar
     */
    private boolean verificarProducto(Matriz nueva) {
        boolean esPosible;

        esPosible = false;
        if (col == nueva.fil) {
            esPosible = true;
        }

        return esPosible;
    }
}