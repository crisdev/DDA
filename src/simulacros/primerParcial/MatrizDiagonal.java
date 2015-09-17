/*
 * Implementar un módulo en Java que dada una matriz de NxN de caracteres
 * verifique si todos los caracteres en las celdas ubicadas en la diagonal
 * secundaria son iguales.
 */
package simulacros.primerParcial;

/**
 *
 * @author Cristian
 * @version 17/09/2015
 */
public class MatrizDiagonal {

    public static void main(String[] args) {
        char[][] ejemplo = {{'A','F','Y','D','E'},
                            {'A','U','R','E','L'},
                            {'J','H','E','M','S'},
                            {'X','E','N','O','R'},
                            {'E','W','X','B','H'}};

        if (verifica(ejemplo)) {
            System.out.println("La diagonal secundaria tiene los mismos caracteres.");
        } else {
            System.out.println("La diagonal secundaria tiene distintos caracteres.");
        }
    }

    public static boolean verifica(char[][] matriz) {
        boolean caracteresIguales = true;
        int cantFilas = matriz.length;
        int cantColus = matriz[0].length;
        char referencia = matriz[0][cantColus-1];

        for (int i = 0; i < cantFilas; i++) {
            for (int j = 0; j < cantColus; j++) {
                if (j+i == cantFilas-1 && referencia != matriz[i][j]) {
                    caracteresIguales = false;
                }
            }
        }

        return caracteresIguales;
    }

}
