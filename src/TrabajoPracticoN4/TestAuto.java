/*
 * Proveer al usuario un menú con las siguientes opciones:
 * 1. Ingresar un auto: Permitir al usuario realizar la carga de uno o más autos.
 * El usuario puede ingresar a esta opción de menú reiteradas veces.
 */
package TrabajoPracticoN4;

import Utiles.TecladoIn;

/**
 *
 * @author Cristian
 * @version 14/09/2015
 */
public class TestAuto {
    
    public static void main(String[] args) {
        int opcion, i;
        Auto[] nuevo = new Auto[20];

        i = 0;
        do {
            menu();
            System.out.print("Seleccione una opción, 0 para terminar: ");
            opcion = TecladoIn.readLineInt();
            
            switch (opcion) {
                case 1:
                    ingresarAuto(nuevo, i);
                    i++;
                    break;
                case 2:
                    consultarAuto(nuevo, i);
                    break;
                case 3:
                    alquilarAuto(nuevo, i);
                    break;
                case 4:
                    devolverAuto(nuevo, i);
                    break;
                case 5:
                    break;
                case 6:
                    mostrarAutos(nuevo, i);
                    break;
                case 0:
                    break;
            }
            
        } while (opcion != 0);
    }
    
    public static void mostrarAutos(Auto[] auto, int longitud) {
        int j;
        
        j = 0;
        System.out.println("=== Autos Disponibles ===");
        while (j < longitud) {
            if (auto[j].getDisponible()) {
                System.out.println(auto[j].aCadena());
                System.out.println("------------------------");
            }
            j++;
        }
    }
    
    public static void devolverAuto(Auto[] auto, int longitud) {
        int j, km;
        boolean encontrado;
        String patente;
        
        System.out.print("Ingrese patente de búsqueda: ");
        patente = TecladoIn.readLine();
        System.out.print("Ingrese cantidad de kilómetros recorridos: ");
        km = TecladoIn.readLineInt();
        
        j = 0;
        encontrado = false;
        while (j < longitud && !encontrado) {
            if (patente.equalsIgnoreCase(auto[j].getPatente())) {
                encontrado = true;
                if (auto[j].getDisponible()) {
                    System.out.println("El modelo no se encontraba alquilado.");  
                } else {
                    auto[j].setDisponible(true);
                    auto[j].setCuentaKm(km);
                }
            }
            j++;
        }
        
        if (!encontrado) {
            System.out.println("La patente ingresada no existe.");
        }
    }
    
    public static void consultarAuto(Auto[] auto, int longitud) {
        int j;
        boolean encontrado;
        String patente;
        
        System.out.print("Ingrese patente de búsqueda: ");
        patente = TecladoIn.readLine();
        
        j = 0;
        encontrado = false;
        while (j < longitud && !encontrado) {
            if (auto[j].getPatente().equalsIgnoreCase(patente)) {
                System.out.println(auto[j].aCadena());
                encontrado = true;
            }
            j++;
        }
        
        if (!encontrado) {
            System.out.println("Automóvil no encontrado.");
        }
    }
    
    public static void alquilarAuto(Auto[] auto, int longitud) {
        int j;
        boolean encontrado;
        String modelo;
        
        System.out.print("Ingrese modelo a alquilar: ");
        modelo = TecladoIn.readLine();
        
        j = 0;
        encontrado = false;
        while (j < longitud && !encontrado) {
            if (modelo.equalsIgnoreCase(auto[j].getModelo())) {
                encontrado = true;
                if (auto[j].getDisponible()) {
                    auto[j].setDisponible(false);
                } else {
                    System.out.println("El modelo ya se encuentra en alquiler.");
                }
            }
            j++;
        }
        
        if (!encontrado) {
            System.out.println("El modelo no existe.");
        }
    }
    
    public static void ingresarAuto(Auto[] auto, int i) {
        int km;
        char respuesta;
        boolean disponible;
        String patente, modelo;
        
        System.out.print("Ingrese patente: ");
        patente = TecladoIn.readLine();
        System.out.print("Ingrese modelo: ");
        modelo = TecladoIn.readLine();
        System.out.print("Ingrese kilómetros recorridos: ");
        km = TecladoIn.readLineInt();
        System.out.print("Está disponible (s/n)? ");
        respuesta = TecladoIn.readLineNonwhiteChar();
        
        disponible = respuesta == 's';
        
        auto[i] = new Auto(patente, km, modelo, disponible);
    }
    
    public static void menu() {
        System.out.println("1. Ingresar un auto.");
        System.out.println("2. Consultar por un auto.");
        System.out.println("3. Alquiler por modelo.");
        System.out.println("4. Devolución de un automóvil.");
        System.out.println("5. Mostrar datos de la agencia.");
        System.out.println("6. Mostrar autos disponibles.");
        System.out.println("0. Salir");
        System.out.println();
    }
    
}
