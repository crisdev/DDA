/*
 * Supongamos que almacenamos en una matriz la cantidad de expedientes que
 * un organismo del estado procesa por mes desde el año 2000.
 * La matriz representará en sus filas los 12 meses y en columnas
 * los años 2000, 2001, hasta el 2014 inclusive.
 * Modularizando correctamente y haciendo reuso de módulos, definir módulos para:
 * a. Calcular la cantidad de expetiendes procesados en un año determinado.
 * b. Calcular el promedioPorAño de expedientes procesador para un año determinado.
 * c. Obtener el mes en el cual se procesó la mayor cantidad de expedientes en el período 2000-2014.
 * d. Obtener el mes en el cual se procesó la menor cantidad de expedientes en el período 2000-2014.
 * e. Para un año determinado, digamos X, obtener un arreglo unidimensional ordenado
 *    de sus producciones mensuales.
 * f. Obtener la mediana estadística de los expedientes procesados para un año X.
 * g. Determinar la varianza de expedientes para un año determinado.
 * h. Determinar los años en los cuales el desvío es superior a un valor M.
 * i. Calcular el promedio de expedientes procesados para igual mes en el periodo 2000-2014.
 * j. Calcular el promedio de expedientes procesados en un período de dos años X e Y.
 * k. Contar la cantidad de meses en que se han procesado más de X cantidad de
 *    de expedientes para un determinado año Z.
 * l. Determinar la cantidad de meses (cualquiera sea el año) en el cual se hayan
 *    procesado más de Y cantidad de expedientes.
 * m. Determinar si para algún mes de un año X, se han procesado más de Y cantidad
 *    de expedientes.
 */
package TrabajoPracticoN3;

import Utiles.Ordenacion;
import java.util.Random;
import Utiles.TecladoIn;

/**
 *
 * @author Cristian
 * @version 5/09/2015
 */
public class Ejercicio4 {

    public static void main(String[] args) {
        Random r = new Random();
        int[][] expediente = new int[12][15];

        // genero el expediente
        for (int i = 0; i < expediente.length; i++) {
            for (int j = 0; j < expediente[0].length; j++) {
                expediente[i][j] = r.nextInt(51);
            }
        }

        menu(expediente);
    }

    /**
     * Convierte un índice al año determinado.
     *
     * @param pos índice de entrada
     * @return año en formato común
     */
    public static int indiceAAño(int pos) {
        int[] listado = {2000, 2001, 2002, 2003, 2004, 2005,
                         2006, 2007, 2008, 2009, 2010, 2011,
                         2012, 2013, 2014};

        return listado[pos];
    }

    /**
     * Convierte un año ingresado por el usuario a una posición en el índice
     * de expedientes.
     *
     * @param año año de ingreso
     * @return posición del índice
     */
    public static int añoAIndice(int año) {
        int[] listado = {2000, 2001, 2002, 2003, 2004, 2005,
                         2006, 2007, 2008, 2009, 2010, 2011,
                         2012, 2013, 2014};
        int i, pos;
        boolean encontrado;

        i = 0;
        pos = -1;
        encontrado = false;

        while (i < listado.length && !encontrado) {
            if (año == listado[i]) {
                pos = i;
                encontrado = true;
            } else {
                i++;
            }
        }

        return pos;
    }

    /**
     * Este módulo suma los expedientes correspondientes a un año determinado.
     *
     * @param expediente tabla de expedientes
     * @param año año de interés
     * @return cantidad total de expedientes
     */
    public static int sumaExpedientesPorAño(int[][] expediente, int año) {
        int suma, j;

        suma = 0;

        for (j = 0; j < expediente.length; j++) {
            suma += expediente[j][año];
        }

        return suma;
    }

    /**
     * Imprime el expediente por pantalla.
     *
     * @param expediente
     */
    public static void verExpediente(int[][] expediente) {
        System.out.println("2000\t2001\t2002\t2003\t2004\t2005\t2006\t2007\t2008\t2009\t2010\t2011\t2012\t2013\t2014");
        for (int i = 0; i < expediente.length; i++) {
            for (int j = 0; j < expediente[0].length; j++) {
                System.out.printf("%4d\t", expediente[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Determina el promedio por año de expedientes.
     *
     * @param expediente arreglo de entrada
     * @param suma suma de expedientes en 12 meses
     * @return promedio por año de expedientes
     */
    public static double promedioPorAño(int[][] expediente, double suma) {
        return suma / expediente.length;
    }

    /**
     * Determina el promedio por mes de expedientes.
     *
     * @param expediente arreglo de entrada
     * @param suma suma de expedientes en todos los años
     * @return promedio promedio de expedientes
     */
    public static double promedioPorMes(int[][] expediente, double suma) {
        return suma / expediente[0].length;
    }

    /**
     * Calcula la suma por mes de todos los años de expedientes presentes.
     *
     * @param expediente arreglo de entrada
     * @param mes mes a calcular
     * @return suma de expedientes
     */
    public static int sumaExpedientesPorMes(int[][] expediente, int mes) {
        int suma, j;

        suma = 0;

        for (j = 0; j < expediente[0].length; j++) {
            suma += expediente[mes][j];
        }

        return suma;
    }

    /**
     * Convierte un índice en su mes correspondiente.
     *
     * @param pos índice de 0 a 11
     * @return texto (mes) correspondiente al índice indicado
     */
    public static String posAMes(int pos) {
        String mes[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                        "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre"};

        return mes[pos];
    }

    /**
     * Este módulo determina el mes indicial en que hubo mayor cantidad de expedientes.
     *
     * @param expediente tabla de expedientes
     * @return posición indicial del mes con mayor cantidad de expedientes
     */
    public static int mesMasExpedientes(int[][] expediente) {
        int mayorMes, i, pos;

        mayorMes = sumaExpedientesPorMes(expediente, 0);
        pos = 0;

        for (i = 1; i < expediente.length; i++) {
            if (mayorMes < sumaExpedientesPorMes(expediente, i)) {
                mayorMes = sumaExpedientesPorMes(expediente, i);
                pos = i;
            }
        }

        return pos;
    }

    /**
     * Este módulo determina el mes indicial en que hubo menor cantidad de expedientes.
     *
     * @param expediente tabla de expedientes
     * @return posición indicial del mes con menor cantidad de expedientes
     */
    public static int mesMenosExpedientes(int[][] expediente) {
        int menorMes, i, pos;

        menorMes = sumaExpedientesPorMes(expediente, 0);
        pos = 0;

        for (i = 1; i < expediente.length; i++) {
            if (menorMes > sumaExpedientesPorMes(expediente, i)) {
                menorMes = sumaExpedientesPorMes(expediente, i);
                pos = i;
            }
        }

        return pos;
    }

    /**
     * Visualiza mes a mes el año seleccionado.
     *
     * @param expediente arreglo de entrada
     * @param año año a visualizar
     */
    public static void imprimeMes(int[][] expediente, int año) {
        int i;

        System.out.println("---------------------");
        for (i = 0; i < expediente.length; i++) {
            System.out.println("Mes de " + posAMes(i) + ", cantidad de expedientes " + expediente[i][año]);
        }
    }

    /**
     * Calcula la cantidad de expedientes cuyo valor supera cierta cantidad definida por el usuario.
     *
     * @param expediente arreglo de entrada
     * @param cantidad condición definida por el usuario
     * @return cantidad de expedientes en total
     */
    public static int cantidadExpedientesTotal(int[][] expediente, int cantidad) {
        int i, j, suma;

        suma = 0;

        for (i = 0; i < expediente.length; i++) {
            for (j = 0; j < expediente[0].length; j++) {
                if (expediente[i][j] >= cantidad) {
                    suma++;
                }
            }
        }

        return suma;
    }

    /**
     * Calcula la cantidad de expedientes por año que superan o iguales cierta cantidad definida por el usuario.
     *
     * @param expediente arreglo de entrada
     * @param año año a revisar
     * @param cantidad cantidad máxima de expedientes
     * @return cantidad total de expedientes que cumplen con los requisitos
     */
    public static int cantidadExpedientesPorAño(int[][] expediente, int año, int cantidad) {
        int i, suma, valor;

        suma = 0;

        for (i = 0; i < expediente.length; i++) {
            valor = expediente[año][i];
            if (valor >= cantidad) {
                suma++;
            }
        }

        return suma;
    }

    /**
     * Calcula la mediana de un año determinado.
     *
     * @param expediente matriz de ingreso
     * @param año fila a seleccionar
     * @return mediana del año elegido
     */
    public static double mediana(int[][] expediente, int año) {
        int[] arregloOrdenado = new int[expediente[0].length];
        int i;
        double mediana;

        for (i = 0; i < expediente[0].length; i++) {
            arregloOrdenado[i] = expediente[año][i];
        }

        Ordenacion.insertionSort(arregloOrdenado);

        mediana = (arregloOrdenado[arregloOrdenado.length/2] + arregloOrdenado[arregloOrdenado.length/2 + 1]) / 2.0;

        return mediana;
    }

    /**
     * Calcula la varianza de los expedientes para un año determinado.
     *
     * @param expediente arreglo de entrada
     * @param año año a calcular
     * @return varianza para el año fijado
     */
    public static double varianza(int expediente[][], int año) {
        int n, i;
        double varianza, promedio;

        varianza = 0.0;
        n = expediente.length;
        promedio = promedioPorAño(expediente, sumaExpedientesPorAño(expediente, año));

        for (i = 0; i < n; i++) {
            varianza += Math.pow(expediente[i][año] - promedio, 2.0);
        }

        return (1.0/n)*varianza;
    }

    /**
     * Calcula los desvíos que cumplen con cierta condición.
     *
     * @param expediente arreglo de entrada
     * @param M valor del desvío a superar
     */
    public static void desviosMayores(int[][] expediente, int M) {
        int i, cantidadAños;
        double desvio;

        cantidadAños = expediente[0].length;

        for (i = 0; i < cantidadAños; i++) {
            desvio = Math.sqrt(varianza(expediente, i));
            if (desvio > M) {
                System.out.println("Año: " + indiceAAño(i) + ", desvío " + desvio);
            }
        }
    }

    /**
     * Imprime un menú por pantalla.
     *
     * @param expediente tabla de entrada
     */
    public static void menu(int[][] expediente) {
        int opcion, año1, año2, mes, indice1, indice2, M, X;

        do {
            System.out.println();
            System.out.println("1: Visualizar tabla de expedientes.");
            System.out.println("2: Suma de expedientes en un año.");
            System.out.println("3: Promedio de expedientes en un año.");
            System.out.println("4: Calcular mes con mayor cantidad de expedientes.");
            System.out.println("5: Calcular mes con menor cantidad de expedientes.");
            System.out.println("6: Visualizar producción mensual.");
            System.out.println("7: Obtener la mediana.");
            System.out.println("8: Varianza de expedientes procesados.");
            System.out.println("9: Años para los cuales el desvío standar es superior a M.");
            System.out.println("10: Promedio de expedientes en un mes entre 2000-2014.");
            System.out.println("11: Promedio entre dos años.");
            System.out.println("12: Cantidad de meses para los cuales se procesaron más de X expedientes en un año.");
            System.out.println("13: Cantidad de meses para los cuales se procesaron más de X expedientes en todos los años.");
            System.out.println("14: Determina para un año X si se procesaron más de Y expedientes.");
            System.out.print("Ingrese opción, 0 para terminar: ");
            opcion = TecladoIn.readLineInt();

            switch(opcion) {
                case 0:
                    break;
                case 1:
                    verExpediente(expediente);
                    break;
                case 2:
                    System.out.print("Ingrese año para calcular la suma de expedientes: ");
                    año1 = TecladoIn.readLineInt();
                    indice1 = añoAIndice(año1);
                    if (indice1 != -1) {
                        System.out.println("La suma es " + sumaExpedientesPorAño(expediente, indice1));
                    } else {
                        System.out.println("Año inválido. Debe estar entre 2000 y 2014.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese año para calcular el promedio de expedientes: ");
                    año1 = TecladoIn.readLineInt();
                    indice1 = añoAIndice(año1);
                    if (indice1 != -1) {
                        System.out.printf("El promedio de expedientes es %.2f%n", promedioPorAño(expediente, sumaExpedientesPorAño(expediente, indice1)));
                    } else {
                        System.out.println("Año inválido. Debe estar entre 2000 y 2014.");
                    }
                case 4:
                    System.out.println("El mes con mayor cantidad de expedientes fue " + posAMes(mesMasExpedientes(expediente)));
                    break;
                case 5:
                    System.out.println("El mes con menor cantidad de expedientes fue " + posAMes(mesMenosExpedientes(expediente)));
                    break;
                case 6:
                    System.out.print("Ingrese año: ");
                    año1 = TecladoIn.readLineInt();
                    indice1 = añoAIndice(año1);
                    if (indice1 != -1) {
                        imprimeMes(expediente, indice1);
                    } else {
                        System.out.println("Año inválido. Debe estar entre 2000 y 2014.");
                    }
                case 7:
                    System.out.print("Ingrese año: ");
                    año1 = TecladoIn.readLineInt();
                    indice1 = añoAIndice(año1);
                    if (indice1 != -1) {
                        System.out.printf("La mediana es %.2f%n", mediana(expediente, indice1));
                    } else {
                        System.out.println("Año inválido. Debe estar entre 2000 y 2014.");
                    }
                case 8:
                    System.out.print("Ingrese año: ");
                    año1 = TecladoIn.readLineInt();
                    indice1 = añoAIndice(año1);
                    if (indice1 != -1) {
                        System.out.printf("La varianza es %.2f%n", varianza(expediente, indice1));
                    } else {
                        System.out.println("Año inválido. Debe estar entre 2000 y 2014.");
                    }
                    break;
                case 9:
                    System.out.print("Ingrese parámetro M: ");
                    M = TecladoIn.readLineInt();
                    desviosMayores(expediente, M);
                    break;
                case 10:
                    System.out.print("Ingrese mes para calcular el promedio de expedientes: ");
                    mes = TecladoIn.readLineInt();
                    if (mes >= 1 && mes <= 12) {
                        System.out.printf("El promedio de expedientes es %.2f%n", promedioPorMes(expediente, sumaExpedientesPorMes(expediente, mes-1)));
                    } else {
                        System.out.println("Mes inválido. Debe estar entre 1 y 12.");
                    }
                    break;
                case 11:
                    System.out.print("Ingrese primer año: ");
                    año1 = TecladoIn.readLineInt();
                    System.out.print("Ingrese segundo año: ");
                    año2 = TecladoIn.readLineInt();
                    indice1 = añoAIndice(año1);
                    indice2 = añoAIndice(año2);

                    if (indice1 != -1 && indice2 != -1) {
                        System.out.printf("El promedio entre ambos años es %.2f%n",
                                (promedioPorAño(expediente, sumaExpedientesPorAño(expediente, indice1)) + promedioPorAño(expediente, sumaExpedientesPorAño(expediente, indice2))) / 2.0);
                    } else {
                        System.out.println("Año inválido. Debe estar entre 2000 y 2014.");
                    }
                    break;
                case 12:
                    System.out.print("Ingrese año: ");
                    año1 = TecladoIn.readLineInt();
                    indice1 = añoAIndice(año1);
                    if (indice1 != -1) {
                        System.out.print("Ingrese cantidad de expedientes: ");
                        X = TecladoIn.readLineInt();
                        System.out.println("Cantidad de meses: " + cantidadExpedientesPorAño(expediente, indice1, X));
                    } else {
                        System.out.println("Año inválido. Debe estar entre 2000 y 2014.");
                    }
                    break;
                case 13:
                    System.out.print("Ingrese cantidad de expedientes: ");
                    X = TecladoIn.readLineInt();
                    System.out.println("Cantidad de meses: " + cantidadExpedientesTotal(expediente, X));
                    break;
                case 14:
                    System.out.print("Ingrese año: ");
                    año1 = TecladoIn.readLineInt();
                    indice1 = añoAIndice(año1);
                    if (indice1 != -1) {
                        System.out.print("Ingrese cantidad de expedientes: ");
                        X = TecladoIn.readLineInt();

                        if (cantidadExpedientesPorAño(expediente, indice1, X) > 0) {
                            System.out.println("Existen expedientes que cumplen con los requisitos especificados.");
                        } else {
                            System.out.println("No hay expedientes.");
                        }

                    } else {
                        System.out.println("Año inválido. Debe estar entre 2000 y 2014.");
                    }
                    break;
                default:
                    System.out.println("Opción incorrecta.");
                    break;
            }
        } while (opcion != 0);
    }
}