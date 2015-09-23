/*
 * Escribir un programa testRacional que permita cargar y operar con racionales.
 * Debe contar con un menú de opciones para probar toda la funcionalidad del TDA.
 */
package trabajoPracticoN4.tests;

import trabajoPracticoN4.clases.Racional;
import utiles.TecladoIn;

/**
 *
 * @author Cristian
 * @version 12/09/2015
 */
public class TestRacional {

    public static void main(String[] args) {
        byte opcion;
        int numerador, denominador;

        Racional r1 = new Racional(1,1);
        Racional r2;

        do {
            menu();
            opcion = TecladoIn.readLineByte();
            switch(opcion) {
                case 1:
                    r1 = creaRacional();
                    break;
                case 2:
                    System.out.println("El numerador es: " + r1.getNumerador());
                    break;
                case 3:
                    System.out.println("El denominador es: " + r1.getDenominador());
                    break;
                case 4:
                    System.out.println("En forma real: " + r1.pasarADouble());
                    break;
                case 5:
                    System.out.println(r1.aCadena());
                    break;
                case 6:
                    r2 = creaRacional();

                    if(r1.igual(r2)) {
                        System.out.println("Los racionales son iguales.");
                    } else {
                        System.out.println("Los racionales son distintos.");
                    }

                    break;
                case 7:
                    System.out.print("Ingrese numerador: ");
                    numerador = TecladoIn.readLineInt();
                    r1.setNumerador(numerador);
                    break;
                case 8:
                    System.out.print("Ingrese denominador: ");
                    denominador = TecladoIn.readLineInt();
                    r1.setDenominador(denominador);
                    break;
                case 9:
                    r2 = creaRacional();
                    r1 = r1.sumar(r2);

                    System.out.println("Resultado: " + r1.aCadena());
                    break;
                case 10:
                    r2 = creaRacional();
                    r1 = r1.restar(r2);

                    System.out.println("Resultado: " + r1.aCadena());
                    break;
                case 11:
                    r2 = creaRacional();
                    r1 = r1.multiplicar(r2);

                    System.out.println("Resultado: " + r1.aCadena());
                    break;
                case 12:
                    r2 = creaRacional();
                    r1 = r1.dividir(r2);

                    System.out.println("Resultado: " + r1.aCadena());
                    break;
                case 13:
                    r1.simplificar();
                    break;
                case 14:
                    break;
                default:
                    System.out.println("Opción incorrecta.");
                    break;
            }
        } while (opcion != 14);
    }

    public static void menu() {
        System.out.println("-----------------------------");
        System.out.println();
        System.out.println("1. - Crear un número racional.");
        System.out.println("2. - Obtener numerador.");
        System.out.println("3. - Obtener denominador.");
        System.out.println("4. - Pasar a real.");
        System.out.println("5. - Visualizar racional.");
        System.out.println("6. - Comparar racionales.");
        System.out.println("7. - Cambiar numerador.");
        System.out.println("8. - Cambiar denominador.");
        System.out.println("9. - Sumar dos racionales.");
        System.out.println("10.- Restar dos racionales.");
        System.out.println("11.- Multiplicar dos racionales.");
        System.out.println("12.- Dividir dos racionales.");
        System.out.println("13.- Simplificar racional.");
        System.out.println("14.- Terminar.");
        System.out.print("Ingrese la opción deseada: ");
    }

    private static Racional creaRacional() {
        int numerador, denominador;
        Racional nuevo;

        System.out.print("Ingrese numerador: ");
        numerador = TecladoIn.readLineInt();
        System.out.print("Ingrese denominador: ");
        denominador = TecladoIn.readLineInt();

        while (denominador == 0) {
            System.out.println("Denominador nulo!");
            System.out.print("Ingrese nuevo denominador: ");
            denominador = TecladoIn.readLineInt();
        }

        nuevo = new Racional(numerador, denominador);

        return nuevo;
    }
}
