/*
 * Implementar las siguientes operaciones para matrices:
 *
 * a. Mostrar los elementos de una matriz.
 * b. Verificar si una matriz es cuadrada.
 * c. Verificar si una matriz es triangular superior.
 * d. Verificar si una matriz es matriz diagonal.
 * e. Suma de matrices.
 * f. Producto por un escalar.
 * g. Transponer una matriz.
 * h. Sumar los elementos de una fila determinada.
 * i. Sumar los elementos de una columna.
 * j. Multiplicación de matrices.
 */
package trabajoPracticoN3;

import utiles.TecladoIn;

/**
 *
 * @author Cristian
 * @version 5/09/2015
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        menu();
    }

    /**
     * Imprime por pantalla los elementos de una matriz.
     *
     * @param a matriz de entrada
     */
    public static void mostrarMatriz(int[][] a) {
        int nroFilas    = a.length;
        int nroColumnas = a[0].length;
        int i, j;

        for (i = 0; i < nroFilas; i++) {
            for (j = 0; j < nroColumnas; j++) {
                System.out.printf("%3d", a[i][j]);
            }
            System.out.println();
        }

    }

    /**
     * Verifica si una matriz es cuadrada.
     *
     * @param arreglo matriz de entrada
     * @return verdadero si la matriz de entrada es cuadrada
     */
    public static boolean esCuadrada(int[][] arreglo) {
        return arreglo.length == arreglo[0].length;
    }

    /**
     * Verifica si una matriz es triangular superior.
     * 
     * @param arreglo matriz de entrada
     * @return verdadero si la matriz de entrada es triangular superior
     */
    public static boolean esTriangularSuperior(int[][] arreglo) {
        int nroFilas    = arreglo.length;
        int nroColumnas = arreglo[0].length;
        int i, j;
        boolean esTS = true;

        if (!esCuadrada(arreglo)) {
            esTS = false;
        } else {
            i = 0;
            while (i < nroFilas && esTS) {
                j = 0;
                while (j < nroColumnas && esTS) {
                    if (i > j && arreglo[i][j] != 0) {
                        esTS = false;
                    } else {
                        j++;
                    }
                }
                i++;
            }
        }

        return esTS;
    }
    
    /**
     * Verifica si una matriz es triangular inferior.
     * 
     * @param arreglo matriz de entrada
     * @return verdadero si la matriz de entrada es triangular inferior
     */
    public static boolean esTriangularInferior(int[][] arreglo) {
        int nroFilas    = arreglo.length;
        int nroColumnas = arreglo[0].length;
        int i, j;
        boolean esTI = true;

        if (!esCuadrada(arreglo)) {
            esTI = false;
        } else {
            i = 0;
            while (i < nroFilas && esTI) {
                j = 0;
                while (j < nroColumnas && esTI) {
                    if (i < j && arreglo[i][j] != 0) {
                        esTI = false;
                    } else {
                        j++;
                    }
                }
                i++;
            }
        }

        return esTI;
    }
    
    /**
     * Verifica si una matriz es diagonal.
     * 
     * @param a
     * @return 
     */
    public static boolean esDiagonal(int[][] a) {
        return esTriangularInferior(a) && esTriangularSuperior(a);
    }
    
    /**
     * Calcula la suma de dos matrices.
     * 
     * @param a primer arreglo de entrada
     * @param b segundo arreglo de entrada
     * @return suma de los dos arreglos de entrada
     */
    public static int[][] suma(int[][] a, int[][] b) {
        int i, j;
        int[][] c = new int[a.length][a[0].length];
        
        for (i = 0; i < a.length; i++) {
            for (j = 0; j < b.length; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        
        return c;
    }
    
    /**
     * Calcula el producto de una matriz por un escalar.
     * 
     * @param a arreglo de entrada
     * @param k escalar
     * @return producto de la matriz por el escalar
     */
    public static int[][] productoEscalar(int a[][], int k) {
        int i, j;
        int[][] c = new int[a.length][a[0].length];
        
        for (i = 0; i < a.length; i++) {
            for (j = 0; j < a[0].length; j++) {
                c[i][j] = k * a[i][j];
            }
        }
    
        return c;
    }
    
    /**
     * Transpone una matriz.
     * 
     * @param matriz matriz de entrada
     * @return matriz transpuesta
     */
    public static int[][] transponer(int[][] matriz) {
        int i, j;
        int filasMatriz    = matriz.length;
        int columnasMatriz = matriz[0].length;
        
        int[][] transpuesta = new int[columnasMatriz][filasMatriz];
        
        for (i = 0; i < matriz.length; i++) {
            for (j = 0; j < matriz[0].length; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }
        
        return transpuesta;
    }
    
    /**
     * Suma los elementos de una fila determinada de un arreglo.
     * 
     * @param a arreglo de entrada
     * @param fila fila a sumar
     * @return valor total de la suma
     */
    public static int sumaFila(int[][] a, int fila) {
        int contador, j;
        
        contador = 0;
        
        for (j = 0; j < a[0].length; j++) {
            contador += a[fila-1][j];
        }
        
        return contador;
    }
    
    /**
     * Suma los elementos de una columna determinada de un arreglo.
     * 
     * @param a arreglo de entrada
     * @param columna fila a sumar
     * @return valor total de la suma
     */
    public static int sumaColumna(int[][] a, int columna) {
        int contador, i;
        
        contador = 0;
        
        for (i = 0; i < a.length; i++) {
            contador += a[i][columna-1];
        }
        
        return contador;
    }
    
    /**
     * Crea un arreglo de dimensiones definidas por el usuario.
     * 
     * @return arreglo nuevo creado
     */
    public static int[][] creaArray() {
        int i, j;
        int filas, columnas;
        int[][] a;
        
        System.out.print("Ingrese cantidad de filas: ");
        filas = TecladoIn.readLineInt();
        System.out.print("Ingrese cantidad de columnas: ");
        columnas = TecladoIn.readLineInt();
        
        a = new int[filas][columnas];
        
        for (i = 0; i < filas; i++) {
            for (j = 0; j < columnas; j++) {
                System.out.print("Ingrese fila " + (i+1) + " columna " + (j+1) + ": ");
                a[i][j] = TecladoIn.readLineInt();
            }
        }
        
        return a;
    }
    
    /**
     * Multiplica dos matrices.
     * 
     * @param a primer matriz de ingreso
     * @param b segunda matriz de ingreso
     * @return producto de las dos matrices de ingreso
     */
    public static int[][] multiplicaMatriz(int[][] a, int[][] b) {
        int[][] resultado;
        int i, j, m, k, suma;
        
        resultado = new int[a.length][b[0].length];
        m = b.length;
        
        for (i = 0; i < a.length; i++) {
            for (j = 0; j < b[0].length; j++) {
                suma = 0;
                
                for (k = 0; k < m; k++) {
                    suma += a[i][k] * b[k][j]; 
                }
                
                resultado[i][j] = suma;
            }
        }
        
        return resultado;
    }
    
    /**
     * Verifica que dos matrices se puedan multiplicar entre sí.
     * 
     * @param a primer matriz de ingreso
     * @param b segunda matriz de ingreso
     * @return verdadero si se pueden multiplicar
     */
    public static boolean sePuedenMultiplicar(int[][] a, int[][] b) {
        return a[0].length == b.length;
    }
    
    /**
     * Muestra un menú por pantalla.
     */
    public static void menu() {
        int opcion, escalar, fila, columna;
        int[][] auxiliar;
        int[][] matriz = {{5,0}, {0,9}, {0,4}};
        
        do {
            System.out.println();
            System.out.println("1. Crear una matriz.");
            System.out.println("2: Listar elementos de la matriz.");
            System.out.println("3: Verifica si una matriz es cuadrada.");
            System.out.println("4: Verifica si una matriz es triangular superior.");
            System.out.println("5: Verifica si una matriz es triangular inferior.");
            System.out.println("6: Verifica si una matriz es diagonal.");
            System.out.println("7: Suma dos matrices.");
            System.out.println("8: Producto por un escalar.");
            System.out.println("9. Transponer una matriz.");
            System.out.println("10. Sumar los elementos de una fila.");
            System.out.println("11. Sumar los elementos de una columna.");
            System.out.println("12. Multiplicar dos matrices.");
            System.out.print("Seleccione la opción indicada (0 para salir): ");
            opcion = TecladoIn.readLineInt();
            switch(opcion) {
                case 0:
                    break;
                case 1:
                    matriz = creaArray();
                case 2:
                    System.out.println("Matriz cargada:");
                    mostrarMatriz(matriz);
                    break;
                case 3:
                    if (esCuadrada(matriz)) {
                        System.out.println("La matriz es cuadrada.");
                    } else {
                        System.out.println("La matriz no es cuadrada.");
                    }
                    break;
                case 4:
                    if (esTriangularSuperior(matriz)) {
                        System.out.println("La matriz es triangular superior.");
                    } else {
                        System.out.println("La matriz no es triangular superior.");
                    }
                    break;
                case 5:
                    if (esTriangularInferior(matriz)) {
                        System.out.println("La matriz es triangular inferior.");
                    } else {
                        System.out.println("La matriz no es triangular inferior.");
                    }
                    break;
                case 6:
                    if (esDiagonal(matriz)) {
                        System.out.println("La matriz es diagonal.");
                    } else {
                        System.out.println("La matriz no es diagonal.");
                    }
                    break;
                case 7:
                    auxiliar = creaArray();
                    mostrarMatriz(suma(matriz, auxiliar));
                    break;
                case 8:
                    System.out.print("Ingrese un escalar: ");
                    escalar = TecladoIn.readLineInt();
                    mostrarMatriz(productoEscalar(matriz, escalar));
                    break;
                case 9:
                    mostrarMatriz(transponer(matriz));
                    break;
                case 10:
                    System.out.print("Ingrese una fila: ");
                    fila = TecladoIn.readLineInt();
                    if (fila <= matriz.length) {
                        System.out.println("La suma de la fila es " + sumaFila(matriz, fila));
                    } else {
                        System.out.println("Fuera de rango.");
                    }
                    break;
                case 11:
                    System.out.print("Ingrese una columna: ");
                    columna = TecladoIn.readLineInt();
                    if (columna <= matriz[0].length) {
                        System.out.println("La suma de la columna es " + sumaColumna(matriz, columna));
                    } else {
                        System.out.println("Fuera de rango.");
                    }
                    break;
                case 12:
                    auxiliar = creaArray();
                    if (sePuedenMultiplicar(matriz, auxiliar)) {
                        System.out.println("El producto es:");
                        mostrarMatriz(multiplicaMatriz(matriz, auxiliar));
                    } else {
                        System.out.println("La operación no se puede realizar.");
                    }
                    break;
                default:
                    System.out.println("Opción incorrecta. Repita código.");
                    break;
            }
        } while (opcion != 0);
    }
}
