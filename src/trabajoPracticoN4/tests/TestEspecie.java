/*
 * Implementar la clase TestEspecie que permita probar la funcionalidad
 * del TDA Especie. Es decir, cargar los datos de una o más especies, consultarlas,
 * modificarlas y aplicar las operaciones propias del tipo.
 *
 * La especie rinoceronte tiene una población de 100 y una tasa de crecimiento de 15%
 * y la especie elefante tiene una población de 10 y una tasa de crecimiento de 35%.
 * ¿Cuántos años le llevará a la población elefante superar a la especie rinoceronte?
 */
package trabajoPracticoN4.tests;

import trabajoPracticoN4.clases.Especie;
import utiles.TecladoIn;

/**
 *
 * @author Cristian
 * @version 12/09/2015
 */
public class TestEspecie {

    public static void main(String[] args) {
        int años, i;
        boolean laSupera;

        i = 1;
        laSupera = false;

        Especie caballo     = new Especie("Caballo", 30, 20);
        Especie rinoceronte = new Especie("Rinoceronte", 100, 15);
        Especie elefante    = new Especie("Elefante", 10, 35);

        System.out.println(caballo.aCadena());

        if (!rinoceronte.igual(caballo)) {
            System.out.println("Un " + caballo.getNombre() + " no es igual a un " + rinoceronte.getNombre());
        }

        System.out.print("Ingrese cantidad de años para estimar la población de caballos: ");
        años = TecladoIn.readLineInt();
        System.out.println("Población proyectada: " + caballo.poblacionProyectada(años) + "\n");

        while(!laSupera && i < 200) { // para evitar un posible ciclo infinito
            if (elefante.poblacionProyectada(i) > rinoceronte.poblacionProyectada(i)) {
                laSupera = true;
            } else {
                i++;
            }
        }

        System.out.println("La población de elefantes superará a la de los rinocerontes en " + i + " años.");
        System.out.println("Población de elefantes en " + i + " años: " + elefante.poblacionProyectada(i));
        System.out.println("Población de rinocerontes en " + i + " años: " + rinoceronte.poblacionProyectada(i));
    }
}
