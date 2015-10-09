/*
 * Implementar un TDA TestPersona, que permita cargar un conjunto de personas
 * (física y jurídicas).
 * Implementar los siguientes métodos:
 * - Método para recuperar aquellas personas físicas cuyo nombre contenga la cadena "SUAREZ"
 * - Método de OrdenamientoIsertionSort() para ordenar el arreglo de personas según su CUIT-CUIL
 * - Método de OrdenamientoSelectionSort() para ordenar el arreglo de personas según su CUIT-CUIL
 * - Método de OrdenamientoBurbujaSort() para ordenar el arreglo de personas según el CUIT-CUIL
 * - Método de BúquedaSecuencial() para buscar un elemento en un arreglo ordenado de CUIT-CUIL
 * - Método de BúqeudaBinaria() para buscar un elemento en un arreglo ordenado de CUIT-CUIL
 * - Método para recuperar las personas físicas de una localidad determinada (dado su código postal)
 * - Método para recuperar las personas jurídicas de una localidad determinada (dado su código postal)
 *   y calle determinada
 */
package trabajo;

import utiles.Aleatorio;
import utiles.TecladoIn;

/**
 *
 * @author Cristian
 * @version 6/10/2015
 */
public class TestPersona {

    public static void main(String[] args) {
        Persona[] arreglo = new Persona[5];
        int longitudArreglo;

        longitudArreglo = arreglo.length;
        for (int i = 0; i < longitudArreglo; i++) {
            CuitCuil nuevo = new CuitCuil(23, (long) Aleatorio.intAleatorio(100, 200));
            arreglo[i] = new Persona(nuevo, Aleatorio.stringAleatorio(10), Aleatorio.stringAleatorio(4), i, "8300", "Neuquén");
            System.out.println("==========");
            System.out.println(arreglo[i]);
        }

        System.out.println("\n\n\nORDENADO");
        //OrdenamientoInsertionSort(arreglo);
        //OrdenamientoSelectionSort(arreglo);
        OrdenamientoBurbujaSort(arreglo);
        for (int i = 0; i < longitudArreglo; i++) {
            System.out.println("===========");
            System.out.println(arreglo[i]);

        }
    }

    /**
     * Imprime por pantalla la información almacenada sobre cualquier persona
     * cuyo nombre sea "SUAREZ".
     *
     * @param x arreglo de personas almacenadas
     */
    public static void Suarez(Persona[] x) {
        int tipo, longitudArreglo;
        String nombre;

        nombre = "Suarez";
        longitudArreglo = x.length;
        for (int i = 0; i < longitudArreglo; i++) {
            tipo = x[i].getCuitCuil().getTipo();

            if (tipo == 20 || tipo == 23 || tipo == 27) {
                if (nombre.equalsIgnoreCase(x[i].getNombre())) {
                    System.out.println(x[i]);
                }
            }
        }
    }

    /**
     * Crea un nuevo objeto CUIT/CUIL.
     *
     * @return objeto CUIT/CUIL
     */
    public static CuitCuil ingresarCuitCuil() {
        CuitCuil nuevo;
        byte tipo;
        int DNI;
        boolean esValido;

        do {
            System.out.println("Ingrese tipo de identificación: ");
            tipo = TecladoIn.readLineByte();
            esValido = tipo == 20 || tipo == 23 || tipo == 27 || tipo == 30 || tipo == 33;

            if (!esValido) {
                System.out.println("Número de identificación incorrecto.");
            }
        } while (!esValido);

        System.out.println("Ingrese DNI o número de sociedad: ");
        DNI = TecladoIn.readLineInt();

        nuevo = new CuitCuil(tipo, DNI);

        return nuevo;
    }

    /**
     * Crea un nuevo objeto persona.
     *
     * @return una persona
     */
    public static Persona ingresarPersona() {
        Persona alguien;
        CuitCuil cuitcuil;
        String nombre, domicilio, codigoPostal, provincia;
        int nroDomicilio;

        cuitcuil = ingresarCuitCuil();

        System.out.println("Ingrese nombre o razón social: ");
        nombre = TecladoIn.readLine();
        System.out.println("Ingrese domicilio: ");
        domicilio = TecladoIn.readLine();
        System.out.println("Ingrese número de domicilio: ");
        nroDomicilio = TecladoIn.readLineInt();
        System.out.println("Ingrese código postal: ");
        codigoPostal = TecladoIn.readLine();
        System.out.println("Ingrese provincia: ");
        provincia = TecladoIn.readLine();

        alguien = new Persona(cuitcuil, nombre, nombre, nroDomicilio, nombre, provincia);

        return alguien;
    }

    /**
     * Implementa el algoritmo de ordenamiento por inserción.
     *
     * @param a arreglo de personas desordenadas
     */
    public static void OrdenamientoInsertionSort(Persona[] a) {
        long temp;
        Persona nueva;
        int j, longitudArreglo;

        longitudArreglo = a.length;
        for (int p = 1; p < longitudArreglo; p++) {
            temp = a[p].getCuitCuil().getDNI();
            nueva = a[p];  // Necesito almacenar la referencia de la persona !!
            j = p;

            while (j > 0 && temp < a[j - 1].getCuitCuil().getDNI()) {
                a[j] = a[j - 1];
                j = j - 1;
            }

            a[j] = nueva;
        }
    }

    /**
     * Implementa el algoritmo de ordenamiento por selección.
     *
     * @param a arreglo de personas desordenadas
     */
    public static void OrdenamientoSelectionSort(Persona[] a) {
        int i, j, min, longitudArreglo;
        Persona nueva;

        longitudArreglo = a.length;
        for (i = 0; i < longitudArreglo - 1; i++) {
            min = i;

            for (j = i + 1; j < longitudArreglo; j++) {
                if (a[j].getCuitCuil().getDNI() < a[min].getCuitCuil().getDNI()) {
                    min = j;
                }
            }

            nueva = a[i];
            a[i] = a[min];
            a[min] = nueva;
        }
    }

    /**
     * Implementa el algoritmo de ordenamiento burbuja.
     *
     * @param a arreglo de personas desordenadas
     */
    public static void OrdenamientoBurbujaSort(Persona[] a) {
        int i, j, longitudArreglo;
        Persona nueva;

        longitudArreglo = a.length;
        for (i = 0; i < longitudArreglo - 1; i++) {
            for (j = 0; j < longitudArreglo - 1 - i; j++) {
                if (a[j + 1].getCuitCuil().getDNI() < a[j].getCuitCuil().getDNI()) {
                    nueva = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = nueva;
                }
            }
        }
    }

    /**
     * Busca secuencialmente el Cuit/Cuil especificado. Devuelve null en caso de
     * no encontrarlo.
     *
     * @param p arreglo de personas
     * @return persona cuyo CUIT/CUIL coincide con el buscado
     */
    public static Persona BúsquedaSecuencial(Persona[] p) {
        int i;
        boolean encontrado;
        Persona nueva = null;
        CuitCuil cuitcuil;

        cuitcuil = ingresarCuitCuil();

        i = 0;
        encontrado = false;
        while (i < p.length && !encontrado) {
            if (cuitcuil == p[i].getCuitCuil()) {
                nueva = p[i];
                encontrado = true;
            } else {
                i = i + 1;
            }
        }

        return nueva;
    }
}
