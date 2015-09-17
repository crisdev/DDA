/*
 * Implementar la clase TestPatinador que a través de un menú de opciones permita:
 * a) Carga los datos de los patinadores. El arreglo será dimensionado con un
 *    valor ingresado por el usuario, ya que la cantidad de participantes del
 *    evento es conocida.
 * b) Mostrar por pantalla los datos de todos los patinadores que pertenecen a
 *    una categoría dada.
 * c) Dado el documento de un patinador, cambiar su categoría de la siguiente manera:
 *    iniciando en categoría P: P -> I -> C -> B -> A. Un patinador de categoría A
 *    no puede aumentar su categoría, por lo tanto mantiene la categoría A. Este
 *    método debe usar asciendeCategoria() de Patinador.
 */
package simulacros.primerParcial;

import utiles.TecladoIn;

/**
 *
 * @author Cristian
 * @version 17/09/2015
 */
public class TestPatinador {

    public static void main(String[] args) {
        int cantPart, i, opcion;
        Patinador[] patinador;
        char categoria;
        String DNI;

        System.out.print("Ingrese cantidad de participantes: ");
        cantPart = TecladoIn.readLineInt();
        patinador = new Patinador[cantPart];

        do {
            menu();
            System.out.print("Ingrese opción: ");
            opcion = TecladoIn.readLineInt();
            switch (opcion) {
                case 1:
                    for (i = 0; i < cantPart; i++) {
                        patinador[i] = new Patinador();
                        System.out.print("Ingrese nombre del patinador: ");
                        patinador[i].setNombre(TecladoIn.readLine());
                        System.out.print("Ingrese apellido del patinador: ");
                        patinador[i].setApellido(TecladoIn.readLine());
                        System.out.print("Ingrese DNI del patinador: ");
                        patinador[i].setDoc(TecladoIn.readLine());
                        System.out.print("Ingrese edad del patinador: ");
                        patinador[i].setEdad(TecladoIn.readLineInt());
                        System.out.print("Ingrese categoría del patinador: ");
                        patinador[i].setCategoria(TecladoIn.readLineNonwhiteChar());
                    }
                    break;
                case 2:
                    System.out.print("Ingrese categoría del patinador: ");
                    categoria = TecladoIn.readLineNonwhiteChar();
                    if (categoria >= 'a') {
                        categoria = (char) ('A' + (categoria - 'a'));
                    }
                    System.out.println("Patinadores presentes:");
                    for (i = 0; i < cantPart; i++) {
                        if (categoria == patinador[i].getCategoria()) {
                            System.out.println(patinador[i].toString());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Ingrese DNI del patinador: ");
                    DNI = TecladoIn.readLine();
                    for (i = 0; i < cantPart; i++) {
                        if (DNI.equals(patinador[i].getDoc())) {
                            patinador[i].asciendeCategoria();
                        }
                    }
                    System.out.println(patinador[i - 1].toString());
                    break;
                case 4:
                    break;
            }
        } while (opcion != 4);

    }

    public static void menu() {
        System.out.println("1. Ingresar patinadores.");
        System.out.println("2. Mostrar patinadores por categoría.");
        System.out.println("3. Subir categoría, por DNI.");
        System.out.println("4. Terminar.");
    }

}
