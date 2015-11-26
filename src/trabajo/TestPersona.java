/*
 * Implementar un TDA TestPersona, que permita cargar un conjunto de personas
 * (física y jurídicas).
 * Implementar los siguientes métodos:
 * - Método para recuperar aquellas personas físicas cuyo nombre contenga la cadena "SUAREZ"
 * - Método de OrdenamientoIsertionSort() para ordenar el arreglo de personas según su CUIT-CUIL
 * - Método de OrdenamientoSelectionSort() para ordenar el arreglo de personas según su CUIT-CUIL
 * - Método de OrdenamientoBurbujaSort() para ordenar el arreglo de personas según el CUIT-CUIL
 * - Método de BúsquedaSecuencial() para buscar un elemento en un arreglo ordenado de CUIT-CUIL
 * - Método de BúsquedaBinaria() para buscar un elemento en un arreglo ordenado de CUIT-CUIL
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
        //Ordenamiento.bubbleSort(arreglo);
        //Ordenamiento.mergeSort(arreglo);
        //Ordenamiento.quickSort(arreglo);
        Ordenamiento.heapSort(arreglo);
        for (int i = 0; i < longitudArreglo; i++) {
            System.out.println("===========");
            System.out.println(arreglo[i]);
        }

        //System.out.println(cantidadPersonas(arreglo, "pepe", longitudArreglo - 1));
        //System.out.println("Apellido: " + arreglo[1].getApellido());
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
                if (nombre.equalsIgnoreCase(x[i].getApellido())) {
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

        System.out.println("Ingrese apellido y nombre o razón social: ");
        nombre = TecladoIn.readLine();
        System.out.println("Ingrese domicilio: ");
        domicilio = TecladoIn.readLine();
        System.out.println("Ingrese número de domicilio: ");
        nroDomicilio = TecladoIn.readLineInt();
        System.out.println("Ingrese código postal: ");
        codigoPostal = TecladoIn.readLine();
        System.out.println("Ingrese provincia: ");
        provincia = TecladoIn.readLine();

        alguien = new Persona(cuitcuil, nombre, domicilio, nroDomicilio, codigoPostal, provincia);

        return alguien;
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

    /**
     * Búsqueda binaria de un cuit/cuil ingresado por el usuario.
     *
     * Precondición: arreglo de personas ordenado según sus números de cuit/cuil
     *
     * @param p arreglo de personas ordenado
     * @return null si la persona no es encontrada, persona si es encontrada
     */
    public static Persona BúsquedaBinaria(Persona[] p) {
        int inicio, medio, fin;
        Persona nueva;
        CuitCuil cuitcuil;

        inicio = 0;
        fin = p.length;
        nueva = null;

        cuitcuil = ingresarCuitCuil();

        while (inicio <= fin) {
            medio = (inicio + fin) / 2;
            if (cuitcuil == p[medio].getCuitCuil()) {
                nueva = p[medio];
            } else {
                if (cuitcuil.menorQue(p[medio].getCuitCuil())) {
                    fin = medio - 1;
                } else {
                    inicio = medio + 1;
                }
            }
        }

        return nueva;
    }

    /**
     * Determina si una persona es física o jurídica
     *
     * @param a arreglo de personas
     * @param i posición en el arreglo
     * @return verdadero si la persona es física
     */
    private static boolean esPersonaFisica(Persona[] a, int i) {
        boolean res;

        res = true;

        // 30 o 33 para personas jurídicas
        if (a[i].getCuitCuil().getTipo() == 30 || a[i].getCuitCuil().getTipo() == 33) {
            res = false;
        }

        return res;
    }

    /**
     * Imprime por pantalla las personas físicas que tienen un código postal
     * introducido por el usuario.
     *
     * @param a arreglo de personas
     */
    public static void recuperaPersonaFisica(Persona[] a) {
        int i;
        String codigoPostal;
        boolean esPersonaFisica;

        System.out.print("Ingrese código postal: ");
        codigoPostal = TecladoIn.readLine();

        i = 0;

        do {
            esPersonaFisica = esPersonaFisica(a, i);
            if (codigoPostal.equalsIgnoreCase(a[i].getCodigoPostal()) && esPersonaFisica) {
                System.out.println(a[i].toString());
            }

            i = i + 1;
        } while (i < a.length);
    }

    /**
     * Imprime por pantalla las personas jurídicas que tienen un código postal y
     * una calle introducidas por el usuario.
     *
     * @param a arreglo de personas
     */
    public static void recuperarPersonaJuridica(Persona[] a) {
        String codigoPostal;
        int nroDomicilio, i;
        boolean esPersonaJuridica;

        System.out.print("Ingrese código postal: ");
        codigoPostal = TecladoIn.readLine();
        System.out.print("Ingrese número de domicilio: ");
        nroDomicilio = TecladoIn.readLineInt();

        i = 0;

        do {
            esPersonaJuridica = !esPersonaFisica(a, i);
            if (codigoPostal.equalsIgnoreCase(a[i].getCodigoPostal())
                    && nroDomicilio == a[i].getNroDomicilio()
                    && esPersonaJuridica) {
                System.out.print(a[i].toString());
            }

            i = i + 1;
        } while (i < a.length);
    }

    /**
     * Cuenta recursivamente la cantidad de personas que tienen el apellido especificado.
     * 
     * @param a arreglo de personas
     * @param apellido apellido a buscar
     * @param pos posición de búsqueda inicial
     * @return cantidad de personas que tienen el apellido pasado por parámetro
     */
    public static int cantidadPersonas(Persona[] a, String apellido, int pos) {
        int cantidad;

        if (pos == 0) {
            if (apellido.equalsIgnoreCase(a[pos].getApellido())) {
                cantidad = 1;
            } else {
                cantidad = 0;
            }
        } else {
            if (apellido.equalsIgnoreCase(a[pos].getApellido())) {
                cantidad = 1 + cantidadPersonas(a, apellido, pos - 1);
            } else {
                cantidad = cantidadPersonas(a, apellido, pos - 1);
            }
        }

        return cantidad;
    }

    /**
     * Cuenta recursivamente la cantidad de empresas localizadas en una provincia especificada.
     * 
     * @param a arreglo de personas
     * @param provincia provincia de residencia
     * @param pos posición inicial de búsqueda
     * @return cantidad de empresas que habitan en la provincia especificada
     */
    public static int cantidadEmpresas(Persona[] a, String provincia, int pos) {
        int cantidad;

        if (pos == 0) {
            if (provincia.equalsIgnoreCase(a[pos].getProvincia())) {
                cantidad = 1;
            } else {
                cantidad = 0;
            }
        } else {
            if (provincia.equalsIgnoreCase(a[pos].getProvincia())) {
                cantidad = 1 + cantidadEmpresas(a, provincia, pos - 1);
            } else {
                cantidad = cantidadPersonas(a, provincia, pos - 1);
            }
        }

        return cantidad;
    }

    public static void menu() {
        System.out.println("1.- Ingresar persona física o jurídica.");
        System.out.println("2.- Generar datos aleatorios.");
        System.out.println("3.- Visualizar elementos del arreglo.");
        System.out.println("4.- Mostrar personas cuyo nombre contenga la cadena Suarez.");
        System.out.println("5.- Ordenar arreglo según CUIT-CUIL utilizando INSERTION-SORT.");
        System.out.println("6.- Ordenar arreglo según CUIT-CUIL utilizando SELECTION-SORT.");
        System.out.println("7.- Ordenar arreglo según CUIT-CUIL utilizando BURBUJA-SORT.");
        System.out.println("8.- Buscar secuencialmente un CUIT-CUIL sobre el arreglo ordenado.");
        System.out.println("9.- Buscar utilizando búsqueda binaria sobre el arreglo ordenado.");
        System.out.println("10.- Mostrar personas físicas dado su código postal.");
        System.out.println("11.- Mostrar personas jurídicas dado su código postal.");
        
        System.out.println("12.- Cantidad de personas físicas con determinado apellido.");
        System.out.println("13.- Cantidad de personas jurídicas en una determinada provincia.");
        System.out.println("14.- Ordenador arreglo según CUIT-CUIL utilizando MERGE-SORT.");
        System.out.println("15.- Ordenador arreglo según CUIT-CUIL utilizando QUICK-SORT.");
        System.out.println("16.- Ordenador arreglo según CUIT-CUIL utilizando HEAP-SORT.");
        System.out.println("17.- Salir.");
    }
}
