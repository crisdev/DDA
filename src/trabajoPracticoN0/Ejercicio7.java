/*
 * En una exposición de vehículos se administra la información de los autos
 * que están exhibidos. Para cada auto se desea conocer: patente, marca,
 * de fabricación, color y capacidad (cantidad de personas sentadas y cinturón
 * de seguridad disponible). En base a la información relevada se desea mostrar:
 * a) La cantidad de vehículos rojos.
 * b) La capacidad promedio de los autos exhibidos.
 * c) La marca de vehículos que más autos exhibe en la exposición.
 */
package trabajoPracticoN0;

import utiles.TecladoIn;

/**
 *
 * @author Cristian
 * @version 13/08/2013
 */
public class Ejercicio7 {
    
    public static void main(String[] args) {
        String patente, color;
        int año, N, cantidadRojos, cantidadPersonasSentadas, suma, marca;
        int renault, fiat, peugeot, audi, ford;
        
        cantidadRojos = 0;
        suma = 0;
        renault = 0;
        fiat = 0;
        peugeot = 0;
        audi = 0;
        ford = 0;
        
        System.out.print("Ingrese cantidad de vehículos: ");
        N = TecladoIn.readLineInt();
        
        for (int i = 0; i < N; i++) {
            System.out.print("Patente del vehículo: ");
            patente = TecladoIn.readLine();
            System.out.print("Año de fabricación: ");
            año = TecladoIn.readLineInt();
            System.out.print("Color: ");
            color = TecladoIn.readLine();
            
            if (color.equalsIgnoreCase("rojo")) {
                cantidadRojos++;
            }
            
            System.out.print("Capacidad de personas sentadas: ");
            cantidadPersonasSentadas = TecladoIn.readLineInt();
            suma += cantidadPersonasSentadas;
            
            opciones();
            System.out.print("Marca del vehículo: ");
            marca = TecladoIn.readLineInt();

            switch (marca) {
                case 1:
                    renault++;
                    break;
                case 2:
                    fiat++;
                    break;
                case 3:
                    peugeot++;
                    break;
                case 4:
                    audi++;
                    break;
                case 5:
                    ford++;
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        }
        
        System.out.println("Capacidad promedio de autos exhibidos: " + promedio(suma, N));
        System.out.println("Marca más popular " + marcaPopular(renault, fiat, peugeot, audi, ford));
        
    }
    
    
    /**
     * Determina el promedio de la suma de cierta cantidad de números.
     * 
     * @param sumaTotal suma de las edades de los encuestados
     * @param cantidad cantidad total de encuestados
     * @return promedio de encuestados, 0 si no se definió una cantidad
     */
    public static double promedio(int sumaTotal, int cantidad) {
        double promedio;
        
        if (cantidad > 0) {
            promedio = sumaTotal / cantidad;
        } else {
            promedio = 0;
        }
        
        return promedio;
    }
    
    public static void opciones() {
        System.out.println("1.- Renault");
        System.out.println("2.- Fiat");
        System.out.println("3.- Peugeot");
        System.out.println("4.- Audi");
        System.out.println("5.- Ford");
    }
    
    public static String marcaPopular(int auto1, int auto2, int auto3, int auto4, int auto5) {
        int mayorValor;
        String marca;
        
        mayorValor = auto1;
        marca = "Renault";
        
        if (mayorValor <= auto2) {
            mayorValor = auto2;
            marca = "Fiat";
            if (mayorValor <= auto3) {
                mayorValor = auto3;
                marca = "Peugeot";
                if (mayorValor <= auto4) {
                    mayorValor = auto4;
                    marca = "Audi";
                    if (mayorValor <= auto5) {
                        mayorValor = auto5;
                        marca = "Ford";
                    }
                }
            }
        }

        return marca;
    }
}
