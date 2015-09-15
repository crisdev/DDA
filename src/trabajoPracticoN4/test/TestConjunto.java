/*
 * Escribir en Java una clase TestConjunto para probar todos los métodos
 * implementados.
 */
package trabajoPracticoN4.test;

import trabajoPracticoN4.clases.Conjunto;

/**
 *
 * @author Cristian
 * @version 15/09/2015
 */
public class TestConjunto {

    public static void main(String[] args) {
        Conjunto a = new Conjunto();
        Conjunto b = new Conjunto();
        Conjunto c = new Conjunto();
        Conjunto d = new Conjunto();
        Conjunto e = new Conjunto();
        Conjunto f = new Conjunto();
        Conjunto g = new Conjunto();
        Conjunto h = new Conjunto();
        
        // Crear el conjunto vacío
        System.out.println("Conjunto vacío: " + a.aCadena());
        
        // Insertar elementos
        a.insertarElemento(27);
        a.insertarElemento(84);
        a.insertarElemento(3);
        System.out.println("A: " + a.aCadena());
        b.insertarElemento(9);
        b.insertarElemento(60);
        b.insertarElemento(27);
        System.out.println("B: " + b.aCadena());
        c.insertarElemento(5);
        c.insertarElemento(2);
        
        // Borrar un elemento
        System.out.println("C: " + c.aCadena());
        c.eliminarElemento(2);
        System.out.println("C: " + c.aCadena());
        
        // Igualdad entre conjuntos
        c.eliminarElemento(5);
        c.insertarElemento(84);
        c.insertarElemento(3);
        c.insertarElemento(27);
        System.out.println("A y C son iguales? " + a.igual(c));
        System.out.println("A y B son iguales? " + a.igual(b));
        
        // Comprobar si el conjunto está vacío
        System.out.println("A está vacío? " + a.estaVacio());
        System.out.println("D está vacío? " + d.estaVacio());
        
        // Unión de conjunto con otro
        d = a.union(b);
        System.out.println("A UNION B: " + d.aCadena());
        
        // Intersección de un conjunto con otro
        e = a.interseccion(b);
        System.out.println("A INTERSECCION B: " + e.aCadena());
        
        // Resta de un conjunto con otro
        f = a.resta(b);
        System.out.println("A - B: " + f.aCadena());
        
        // Complemento de un conjunto
        g = a.complemento();
        System.out.println("Complemento de A: " + g.aCadena());
        
        // Clonación de un conjunto
        h = b.clonar();
        System.out.println("B: " + b.aCadena());
        System.out.println("H: " + h.aCadena());
    }

}
