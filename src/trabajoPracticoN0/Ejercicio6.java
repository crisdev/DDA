/*
 * En un evento realizado por la empresa de turismo Argentar se hizo una encuesta
 * a algunas de las personas que asistieron.
 * Se les preguntó: nombre, apellido, edad, cantidad de países visitados y
 * estado civil.
 * Las personas solteras con edad entre 45 y 62 años podían participar del sorteo
 * de un viaje a Cataratas.
 * En base a la información relevada se desea mostrar:
 * a) El promedio de edad de los asistentes encuestado.
 * b) El nombre y apellido de las personas que más países visitó.
 * c) Por cada persona indicar si podía o no participar del sorteo.
 */
package trabajoPracticoN0;

import utiles.TecladoIn;

/**
 *
 * @author Cristian
 * @version 12/08/2015
 */
public class Ejercicio6 {
    
    public static void main(String[] args) {
        String nombre, apellido;
        String nombreMasViajo, apellidoMasViajo;
        int edad, paisesVisitados, encuestados, sumaEdad;
        int paisesMasVisitados;
        char estadoCivil;
        
        sumaEdad = 0;
        paisesMasVisitados = 0;
        nombreMasViajo = "";
        apellidoMasViajo = "";
        
        System.out.print("Ingrese el número de asistentes encuestados: ");
        encuestados = TecladoIn.readLineInt();
        
        for (int i=0; i < encuestados ; i++) {
            System.out.print("Ingrese nombre: ");
            nombre = TecladoIn.readLine();
            System.out.print("Ingrese apellido: ");
            apellido = TecladoIn.readLine();
            System.out.print("Ingrese edad: ");
            edad = TecladoIn.readLineInt();
            
            sumaEdad += edad;
            
            System.out.print("Ingrese cantidad de países visitados: ");
            paisesVisitados = TecladoIn.readLineInt();
            
            if (paisesVisitados > paisesMasVisitados) {
                nombreMasViajo = nombre;
                apellidoMasViajo = apellido;
                paisesMasVisitados = paisesVisitados;
            }
            
            System.out.print("Ingrese estado civil (S/C): ");
            estadoCivil = TecladoIn.readLineNonwhiteChar();
            
            if (participaSorteo(edad, estadoCivil)) {
                System.out.println("Esta persona participa del sorteo.");
            } else {
                System.out.println("Esta persona no participa del sorteo.");
            }
        }
        
        System.out.println();
        System.out.println("Promedio edad de encuestados: " + promedio(sumaEdad, encuestados));
        System.out.println("Persona que más países visitó: " + nombreMasViajo + " " + apellidoMasViajo);
    }
    
    /**
     * Verifica si la persona encuestada puede participar del sorteo.
     * 
     * @param edad edad del participante
     * @param estadoCivil estado civil del participante
     * @return verdadero si aplica para el sorteo
     */
    public static boolean participaSorteo(int edad, char estadoCivil) {
        return (edad >= 45) && (edad <= 62) && (estadoCivil == 'S' || estadoCivil == 's');
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
    
}
