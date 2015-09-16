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

    private int[][] matriz;

    /**
     * Método Constructor: genera una matriz cuadrada aleatoria.
     *
     * @param n tamaño de la matriz
     */
    public Matriz(int n) {
        matriz = new int[n][n];
    }

    /**
     * Método Constructor: genera una matriz de nxm.
     *
     * @param n cantidad de filas de la matriz
     * @param m cantidad de columnas de la matriz
     */
    public Matriz(int n, int m) {
        matriz = new int[n][m];
    }

    /**
     * Muestra por pantalla la matriz creada.
     */
    public void mostrarMatriz() {
        int nroFilas = matriz.length;
        int nroColumnas = matriz[0].length;
        int i, j;

        for (i = 0; i < nroFilas; i++) {
            for (j = 0; j < nroColumnas; j++) {
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

        int filas = matriz.length;
        int columnas = matriz[0].length;

        Matriz suma = new Matriz(filas, columnas);

        if (verificarOperacion(nueva)) {
            for (i = 0; i < filas; i++) {
                for (j = 0; j < columnas; j++) {
                    suma.asignaValor(i, j, matriz[i][j] + nueva.muestraValor(i, j));
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

        int filas = matriz.length;
        int columnas = matriz[0].length;

        Matriz resta = new Matriz(filas, columnas);

        if (verificarOperacion(nueva)) {
            for (i = 0; i < filas; i++) {
                for (j = 0; j < columnas; j++) {
                    resta.asignaValor(i, j, matriz[i][j] - nueva.muestraValor(i, j));
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

        int filas = matriz.length;
        int columnas = matriz[0].length;

        Matriz producto = new Matriz(filas, columnas);
        
        for (i = 0; i < filas; i++) {
            for (j = 0; j < columnas; j++) {
                producto.asignaValor(i, j, matriz[i][j] * entero);
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
        int nroFilas    = matriz.length;
        int nroColumnas = nueva.obtenerColumnas();
        Matriz producto = new Matriz(nroFilas, nroColumnas);

        if (verificarProducto(nueva)) {
            for (i = 0; i < nroFilas; i++) {
                for (j = 0; j < nroColumnas; j++) {
                    sumaTemporal = 0;
                
                    for (k = 0; k < matriz[0].length; k++) {
                        sumaTemporal += muestraValor(i, k) * nueva.muestraValor(k, j);
                    }
                
                    producto.asignaValor(i, j, sumaTemporal);
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
        if (i >= 0 && i < matriz.length && j >= 0 && j < matriz[0].length) {
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
        int nroFilas = matriz.length;
        int nroCol   = matriz[0].length;
        Matriz matrizClonada = new Matriz(nroFilas, nroCol);
        
        for (i = 0; i < nroFilas; i++) {
            for (j = 0; j < nroCol; j++) {
                matrizClonada.asignaValor(i, j, matriz[i][j]);
            }
        }
        
        return matrizClonada;
    }

    /**
     * Modifica un objeto matriz para inicializarla con valores aleatorios de 0
     * a 10.
     */
    public void generarNrosAleatorios() {
        Random r = new Random();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
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
        int filasMatriz = matriz.length;
        int columnasMatriz = matriz[0].length;

        Matriz transpuesta = new Matriz(columnasMatriz, filasMatriz);

        for (i = 0; i < filasMatriz; i++) {
            for (j = 0; j < columnasMatriz; j++) {
                transpuesta.asignaValor(j, i, matriz[i][j]);
            }
        }

        return transpuesta;
    }

// Métodos auxiliares

    private boolean verificarOperacion(Matriz nueva) {
        boolean esPosible;
        
        esPosible = false;
        if (matriz.length == nueva.obtenerFilas() &&
            matriz[0].length == nueva.obtenerColumnas()) {
            esPosible = true;
        }
        
        return esPosible;
    }
    
    private boolean verificarProducto(Matriz nueva) {
        boolean esPosible;
        
        esPosible = false;
        if (matriz[0].length == nueva.obtenerFilas()) {
            esPosible = true;
        }
        
        return esPosible;
    }
    
    private int muestraValor(int i, int j) {
        return matriz[i][j];
    }

    private void asignaValor(int i, int j, int valor) {
        matriz[i][j] = valor;
    }
    
    private int obtenerFilas() {
        return matriz.length;
    }
    
    private int obtenerColumnas() {
        return matriz[0].length;
    }
}
