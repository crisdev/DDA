/*
 * Implementar un TDA TestPersona, que permita cargar un conjunto de personas
 * (física y jurídicas).
 * Implementar los siguientes métodos:
 * - Método para recuperar aquellas personas físicas cuyo nombre contenga la cadena "SUAREZ"
 * - Método de OrdenamientoIsertionSort() para ordenar el arreglo de personas según su CUIT-CUIL
 * - Método de OrdenamientoSelectionSort() para ordenar el arreglo de personas según su CUIT-CUIL
 * - Método de OrdenamientoBurbujaSort() para ordenar el arreglo de personas según el CUIT-CUIL
 * - Método de busquedaSecuencial() para buscar un elemento en un arreglo ordenado de CUIT-CUIL
 * - Método de busquedaBinaria() para buscar un elemento en un arreglo ordenado de CUIT-CUIL
 * - Método para recuperar las personas físicas de una localidad determinada (dado su código postal)
 * - Método para recuperar las personas jurídicas de una localidad determinada (dado su código postal)
 *   y calle determinada
 */
package trabajo;

import utiles.TecladoIn;

/**
 *
 * @author Cristian
 * @version 6/10/2015
 */
public class TestPersona {

    public static void main(String[] args) {
        final int almacenamientoMaximo = 50;
        Persona[] persona = new Persona[almacenamientoMaximo];
        int opcion, cantPersonas, cant;
        String apellido, provincia;

        cantPersonas = 0;
        do {
            menu();
            opcion = TecladoIn.readLineInt();
            switch (opcion) {
                case 1:
                    persona[cantPersonas] = ingresarPersona(persona, cantPersonas);
                    cantPersonas++;
                    break;
                case 2:
                    System.out.print("Ingrese cantidad de datos a generar: ");
                    cant = TecladoIn.readLineInt();
                    if ((cant > 0) && (cant + cantPersonas < almacenamientoMaximo)) {
                        generarDatosAleatorios(persona, cantPersonas, cant);
                        cantPersonas += cant;
                    } else {
                        System.out.println("Número incorrecto, reingrese");
                    }
                    break;
                case 3:
                    mostrarPersonas(persona, cantPersonas);
                    break;
                case 4:
                    buscarPersona(persona, cantPersonas);
                    break;
                case 5:
                    Ordenamiento.insertionSort(persona, cantPersonas);
                    System.out.println("===== PERSONAS ORDENADAS =====");
                    mostrarPersonas(persona, cantPersonas);
                    break;
                case 6:
                    Ordenamiento.selectionSort(persona, cantPersonas);
                    System.out.println("===== PERSONAS ORDENADAS =====");
                    mostrarPersonas(persona, cantPersonas);
                    break;
                case 7:
                    Ordenamiento.bubbleSort(persona, cantPersonas);
                    System.out.println("===== PERSONAS ORDENADAS =====");
                    mostrarPersonas(persona, cantPersonas);
                    break;
                case 8:
                    busquedaSecuencial(persona, cantPersonas);
                    break;
                case 9:
                    busquedaBinaria(persona, cantPersonas);
                    break;
                case 10:
                    recuperaPersonaFisica(persona, cantPersonas);
                    break;
                case 11:
                    recuperarPersonaJuridica(persona, cantPersonas);
                    break;
                case 12:
                    System.out.print("Ingrese apellido: ");
                    apellido = TecladoIn.readLine();
                    cant = cantidadPersonas(persona, apellido, cantPersonas - 1);
                    System.out.println("Cantidad de personas encontradas: " + cant);
                    break;
                case 13:
                    System.out.print("Ingrese provincia: ");
                    provincia = TecladoIn.readLine();
                    cant = cantidadEmpresas(persona, provincia, cantPersonas - 1);
                    System.out.println("Cantidad de empresas encontradas: " + cant);
                    break;
                case 14:
                    Ordenamiento.mergeSort(persona, cantPersonas);
                    System.out.println("===== PERSONAS ORDENADAS =====");
                    mostrarPersonas(persona, cantPersonas);
                    break;
                case 15:
                    Ordenamiento.quickSort(persona, cantPersonas);
                    System.out.println("===== PERSONAS ORDENADAS =====");
                    mostrarPersonas(persona, cantPersonas);
                    break;
                case 16:
                    Ordenamiento.heapSort(persona, cantPersonas);
                    System.out.println("===== PERSONAS ORDENADAS =====");
                    mostrarPersonas(persona, cantPersonas);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción incorrecta verifique y reingrese");
                    break;
            }
        } while (opcion != 0);
    }

    /**
     * Imprime por pantalla la información almacenada sobre una persona cuyo
     * apellido sea ingresado por el usuario.
     *
     * @param x arreglo de personas
     * @param cantPersonas cantidad de personas válidamente ingresadas en el
     * arreglo
     */
    public static void buscarPersona(Persona[] x, int cantPersonas) {
        String nombre;
        int i;
        boolean encontrado;

        encontrado = false;
        System.out.print("Ingrese apellido a buscar: ");
        nombre = TecladoIn.readLine();
        for (i = 0; i < cantPersonas; i++) {
            if (esPersonaFisica(x, i)) {
                if (nombre.equalsIgnoreCase(x[i].getApellido())) {
                    encontrado = true;
                    System.out.println(x[i]);
                }
            }
        }

        if (!encontrado) {
            System.out.println("Ninguna persona hallada");
        }
    }

    /**
     * Crea un nuevo objeto CUIT/CUIL.
     *
     * @param p arreglo de personas
     * @param cantPersonas cantidad de personas válidamente ingresadas en el
     * arreglo
     * @return objeto válido CUIT/CUIL
     */
    public static CuitCuil ingresarCuitCuil(Persona[] p, int cantPersonas) {
        CuitCuil nuevo;
        byte tipo;
        int DNI;
        boolean idValido, repetido;

        do {
            do {
                System.out.print("Ingrese tipo de identificación (20, 23, 27, 30 o 33): ");
                tipo = TecladoIn.readLineByte();
                idValido = tipo == 20 || tipo == 23 || tipo == 27 || tipo == 30 || tipo == 33;
                if (!idValido) {
                    System.out.println("Número de identificación incorrecto, reingrese datos");
                }
            } while (!idValido);

            System.out.print("Ingrese DNI o número de sociedad: ");
            DNI = TecladoIn.readLineInt();
            repetido = cuitcuilRepetido(p, new CuitCuil(tipo, DNI), cantPersonas);

            if (repetido) {
                System.out.println("Cuit/Cuil repetido, reingrese datos");
            }
        } while (repetido);

        nuevo = new CuitCuil(tipo, DNI);

        return nuevo;
    }

    /**
     * Crea un nuevo objeto persona.
     *
     * @param p arreglo de personas
     * @param cantPersonas cantidad de personas válidamente ingresadas en el
     * arreglo
     * @return una persona
     */
    public static Persona ingresarPersona(Persona[] p, int cantPersonas) {
        Persona alguien;
        CuitCuil cuitcuil;
        String nombre, domicilio, codigoPostal, provincia;
        int nroDomicilio;

        System.out.print("Ingrese apellido y nombre o razón social: ");
        nombre = TecladoIn.readLine();
        cuitcuil = ingresarCuitCuil(p, cantPersonas);
        System.out.print("Ingrese domicilio: ");
        domicilio = TecladoIn.readLine();
        System.out.print("Ingrese número de domicilio: ");
        nroDomicilio = TecladoIn.readLineInt();
        System.out.print("Ingrese código postal: ");
        codigoPostal = TecladoIn.readLine();
        System.out.print("Ingrese provincia: ");
        provincia = TecladoIn.readLine();

        alguien = new Persona(cuitcuil, nombre, domicilio, nroDomicilio, codigoPostal, provincia);

        return alguien;
    }

    /**
     * Busca secuencialmente el Cuit/Cuil especificado y lo muestra por
     * pantalla.
     *
     * @param p arreglo de personas
     * @param cantPersonas cantidad de personas válidamente ingresadas en el
     * arreglo
     */
    public static void busquedaSecuencial(Persona[] p, int cantPersonas) {
        int i;
        boolean encontrado;
        CuitCuil cuitcuil;
        Persona[] n = p;

        i = 0;
        encontrado = false;
        Ordenamiento.insertionSort(n, cantPersonas); // la búsqueda se realiza sobre el arreglo ordenado
        cuitcuil = ingresarCuitCuil(p, cantPersonas);
        while (i < cantPersonas && !encontrado) {
            if (cuitcuil.esIgualA(n[i].getCuitCuil())) {
                encontrado = true;
                System.out.println("===== PERSONA ENCONTRADA =====");
                System.out.println(n[i]);
            } else {
                i = i + 1;
            }
        }

        if (!encontrado) {
            System.out.println("La persona que busca no existe");
        }
    }

    /**
     * Busca binariamente el Cuit/Cuil especificado y lo muestra por pantalla.
     *
     * @param p arreglo de personas
     * @param cantPersonas cantidad de personas válidamente ingresadas en el
     * arreglo
     */
    public static void busquedaBinaria(Persona[] p, int cantPersonas) {
        int inicio, medio, fin;
        boolean encontrado;
        CuitCuil cuitcuil;
        Persona[] n = p;

        inicio = 0;
        fin = cantPersonas;
        encontrado = false;
        cuitcuil = ingresarCuitCuil(n, cantPersonas);
        Ordenamiento.insertionSort(n, cantPersonas);
        while (inicio <= fin && !encontrado) {
            medio = (inicio + fin) / 2;
            if (cuitcuil.esIgualA(n[medio].getCuitCuil())) {
                encontrado = true;
                System.out.println("===== PERSONA ENCONTRADA =====");
                System.out.println(n[medio]);
            } else {
                if (cuitcuil.menorQue(n[medio].getCuitCuil())) {
                    fin = medio - 1;
                } else {
                    inicio = medio + 1;
                }
            }
        }

        if (!encontrado) {
            System.out.println("La persona que busca no existe");
        }
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
     * @param cantPersonas cantidad de personas válidamente ingresadas en el
     * arreglo
     */
    public static void recuperaPersonaFisica(Persona[] a, int cantPersonas) {
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
        } while (i < cantPersonas);
    }

    /**
     * Imprime por pantalla las personas jurídicas que tienen un código postal y
     * un número de domicilio introducidos por el usuario.
     *
     * @param a arreglo de personas
     * @param cantPersonas cantidad de personas válidamente ingresadas en el
     * arreglo
     */
    public static void recuperarPersonaJuridica(Persona[] a, int cantPersonas) {
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
        } while (i < cantPersonas);
    }

    /**
     * Cuenta recursivamente la cantidad de personas que tienen el apellido
     * especificado.
     *
     * @param a arreglo de personas
     * @param apellido apellido a buscar
     * @param cantPersonas posición de búsqueda inicial
     * @return cantidad de personas que tienen el apellido pasado por parámetro
     */
    public static int cantidadPersonas(Persona[] a, String apellido, int cantPersonas) {
        int cantidad;

        if (cantPersonas == 0) {
            if (apellido.equalsIgnoreCase(a[cantPersonas].getApellido())) {
                cantidad = 1;
            } else {
                cantidad = 0;
            }
        } else {
            if (apellido.equalsIgnoreCase(a[cantPersonas].getApellido())) {
                cantidad = 1 + cantidadPersonas(a, apellido, cantPersonas - 1);
            } else {
                cantidad = cantidadPersonas(a, apellido, cantPersonas - 1);
            }
        }

        return cantidad;
    }

    /**
     * Cuenta recursivamente la cantidad de empresas localizadas en una
     * provincia especificada.
     *
     * @param a arreglo de personas
     * @param provincia provincia de residencia
     * @param cantPersonas cantidad de personas válidamente ingresadas en el
     * arreglo
     * @return cantidad de empresas que habitan en la provincia especificada
     */
    public static int cantidadEmpresas(Persona[] a, String provincia, int cantPersonas) {
        int cantidad;

        if (cantPersonas == 0) {
            if (provincia.equalsIgnoreCase(a[cantPersonas].getProvincia())) {
                cantidad = 1;
            } else {
                cantidad = 0;
            }
        } else {
            if (provincia.equalsIgnoreCase(a[cantPersonas].getProvincia())) {
                cantidad = 1 + cantidadEmpresas(a, provincia, cantPersonas - 1);
            } else {
                cantidad = cantidadPersonas(a, provincia, cantPersonas - 1);
            }
        }

        return cantidad;
    }

    /**
     * Verifica si un Cuit/Cuil fue introducido previamente en el arreglo de
     * personas
     *
     * @param p arreglo de personas
     * @param n cuit/cuil a agregar
     * @param cantPersonas cantidad de personas válidamente ingresadas en el
     * arreglo
     * @return verdadero si está repetido
     */
    private static boolean cuitcuilRepetido(Persona[] p, CuitCuil n, int cantPersonas) {
        boolean estaRepetido;
        int i;

        i = 0;
        estaRepetido = false;
        while (i < cantPersonas && !estaRepetido) {
            if (p[i].getCuitCuil() == n) {
                estaRepetido = true;
            } else {
                i = i + 1;
            }
        }

        return estaRepetido;
    }

    /**
     * Genera personas físicas y jurídicas de forma automática.
     *
     * @param p arreglo de personas
     * @param cantPersonas cantidad de personas válidamente ingresadas en el
     * arreglo
     * @param cantidad cantidad de elementos a generar
     */
    private static void generarDatosAleatorios(Persona[] p, int cantPersonas, int cantidad) {
        int i;

        int[] tipo = {20, 23, 27, 30, 33};

        String[] nombre = {"Juan", "Matias", "Pedro", "Ignacio", "German", "Nicolas", "Lucia", "Patricia", "Maria", "Soledad"};
        String[] apellido = {"Suarez", "Castillo", "Lopez", "Villegas", "Bauch", "Fernandez", "Bobeda", "Puerta", "Aguada", "Pereira"};
        String[] empresa = {"Coca Cola", "Apple", "Microsoft", "Jugos del Sur", "Sancor", "Perez Compaq", "Transportes del Valle", "LAN", "Aceros Inc", "Ferreteria Miguelito"};
        String[] domicilio = {"Almafuerte", "Los Jazmines", "Avenida Siempreviva", "Cura Brochero", "Torre Mirador", "Saveedra", "Liniers", "Almafuerte", "Las Lomas", "Rivadavia"};
        int[] nroDomicilio = {50, 202, 23, 56, 11, 650, 88, 100, 3, 800};
        String[] codPostal = {"8100", "8300", "2000", "6030", "1100", "8080", "112", "9000", "2200", "7000"};
        String[] provincia = {"Neuquen", "Rio Negro", "Buenos Aires", "Capital Federal", "Santa Fe", "Cordoba", "Mendoza"};

        i = 0;
        while (i < cantidad) {
            int t = tipo[Aleatorio.intAleatorio(0, tipo.length - 1)];
            String nom, ape;
            String dom = domicilio[Aleatorio.intAleatorio(0, domicilio.length - 1)];
            int nro = nroDomicilio[Aleatorio.intAleatorio(0, nroDomicilio.length - 1)];
            String cod = codPostal[Aleatorio.intAleatorio(0, codPostal.length - 1)];
            String prov = provincia[Aleatorio.intAleatorio(0, provincia.length - 1)];

            CuitCuil nuevo = new CuitCuil(t, Aleatorio.intAleatorio(20000000, 30000000));

            if (t == 20 || t == 23 || t == 27) {
                nom = nombre[Aleatorio.intAleatorio(0, nombre.length - 1)];
                ape = apellido[Aleatorio.intAleatorio(0, apellido.length - 1)];
                p[cantPersonas++] = new Persona(nuevo, ape + " " + nom, dom, nro, cod, prov);
            } else {
                nom = empresa[Aleatorio.intAleatorio(0, empresa.length - 1)];
                p[cantPersonas++] = new Persona(nuevo, nom, dom, nro, cod, prov);
            }

            i = i + 1;
        }
    }

    /**
     * Imprime por pantalla las personas almacenadas en el arreglo.
     *
     * @param p arreglo de personas
     * @param cantPersonas cantidad de personas válidamente ingresadas en el
     * arreglo
     */
    public static void mostrarPersonas(Persona[] p, int cantPersonas) {
        int i;

        for (i = 0; i < cantPersonas; i++) {
            System.out.println(p[i].toString());
        }
    }

    /**
     * Imprime un menú por pantalla.
     */
    public static void menu() {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Ingrese el número correspondiente a la opción deseada ");
        System.out.println();
        System.out.println("1. Ingresar persona física o jurídica.");
        System.out.println("2. Generar datos aleatorios.");
        System.out.println("3. Visualizar elementos del arreglo.");
        System.out.println("4. Buscar persona por apellido.");
        System.out.println("5. Ordenar arreglo según CUIT-CUIL utilizando INSERTION-SORT.");
        System.out.println("6. Ordenar arreglo según CUIT-CUIL utilizando SELECTION-SORT.");
        System.out.println("7. Ordenar arreglo según CUIT-CUIL utilizando BURBUJA-SORT.");
        System.out.println("8. Buscar secuencialmente un CUIT-CUIL sobre el arreglo ordenado.");
        System.out.println("9. Buscar utilizando búsqueda binaria sobre el arreglo ordenado.");
        System.out.println("10. Mostrar personas físicas dado su código postal.");
        System.out.println("11. Mostrar personas jurídicas dado su código postal y calle.");
        System.out.println("12. Cantidad de personas físicas con determinado apellido.");
        System.out.println("13. Cantidad de personas jurídicas en una determinada provincia.");
        System.out.println("14. Ordenador arreglo según CUIT-CUIL utilizando MERGE-SORT.");
        System.out.println("15. Ordenador arreglo según CUIT-CUIL utilizando QUICK-SORT.");
        System.out.println("16. Ordenador arreglo según CUIT-CUIL utilizando HEAP-SORT.");
        System.out.println();
        System.out.println("0. Salir.");
        System.out.println("-------------------------------------------------------------------------");
        System.out.print("> ");
    }
}
