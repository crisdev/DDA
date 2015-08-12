/*
 * Implementar en Java el algoritmo.
 */
package TrabajoPracticoN0;

import Utiles.TecladoIn;

/**
 *
 * @author Cristian
 * @version 12/08/2015
 */
public class Ejercicio1 {
    
    public static void main(String[] args) {
        int x, y;
        
        x = TecladoIn.readLineInt();
        y = TecladoIn.readLineInt();
        
        x = x - y;
        y = x + y;
        x = y - x;
        
        System.out.println("Los valores de x e y son");
        System.out.println(x);
        System.out.println(y);
    }
    
}
