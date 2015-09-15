/*
 * Construir el TDA para tratar la abstracción matemática Conjunto a partir
 * de las operaciones detalladas más abajo, haciendo la correcta clasificación
 * de las mismas: Constructoras, Observadoras, Modificadoras y Propias del tipo,
 * que manejen conjuntos de números naturales del 1 al 100. Armar la caja UML
 * de la clase Conjunto. (Ayuda: Usar un arreglo booleano).
 */
package trabajoPracticoN4.clases;

/**
 *
 * @author Cristian
 * @version 15/09/2015
 */
public class Conjunto {

    private static final int rango = 100;

    private boolean[] conjunto;

    public Conjunto() {
        conjunto = new boolean[rango];
    }

    public void insertarElemento(int elemento) {
        conjunto[elemento - 1] = true;
    }

    public void eliminarElemento(int elemento) {
        conjunto[elemento - 1] = false;
    }

    private boolean verElemento(int elemento) {
        return conjunto[elemento];
    }

    public boolean igual(Conjunto nuevo) {
        int i;
        boolean sonIguales;

        sonIguales = true;

        i = 0;
        while (i < rango && sonIguales) {
            if (conjunto[i] != nuevo.verElemento(i)) {
                sonIguales = false;
            } else {
                i++;
            }
        }

        return sonIguales;
    }

    public boolean estaVacio() {
        int i;
        boolean vacio;

        vacio = true;
        i = 0;
        while (i < rango && vacio) {
            if (conjunto[i]) {
                vacio = false;
            } else {
                i++;
            }
        }

        return vacio;
    }

    public boolean pertenece(int elemento) {
        int i;
        boolean encontrado;

        encontrado = false;

        i = 0;
        while (i < rango && !encontrado) {
            if (conjunto[elemento - 1]) {
                encontrado = true;
            } else {
                i++;
            }
        }

        return encontrado;
    }

    public Conjunto union(Conjunto nuevo) {
        int i;
        boolean valor;
        Conjunto copia = new Conjunto();

        copia = clonar();

        // efectúa la unión
        for (i = 0; i < rango; i++) {
            valor = nuevo.verElemento(i);

            if (valor) {
                copia.insertarElemento(i+1);
            }
        }

        return copia;
    }

    public Conjunto interseccion(Conjunto nuevo) {
        int i;
        Conjunto copia = new Conjunto();

        for (i = 0; i < rango; i++) {
            if (conjunto[i] && nuevo.verElemento(i)) {
                copia.insertarElemento(i+1);
            }
        }

        return copia;
    }

    public Conjunto resta(Conjunto nuevo) {
        int i;
        boolean valor;
        Conjunto copia        = new Conjunto();
        Conjunto interseccion = new Conjunto();

        copia = clonar();

        interseccion = copia.interseccion(nuevo);

        // remueve elementos de la intersección
        for (i = 0; i < rango; i++) {
            valor = interseccion.verElemento(i);

            if (valor == conjunto[i]) {
                copia.eliminarElemento(i+1);
            }
        }

        return copia;
    }

    public Conjunto complemento() {
        int i;
        boolean valor;
        Conjunto complemento = new Conjunto();

        for (i = 0; i < rango; i++) {
            valor = conjunto[i];

            if (!valor) {
                complemento.insertarElemento(i+1);
            }
        }

        return complemento;
    }

    public String aCadena() {
        int i, ultimaComa;
        String elementos;

        elementos = "";
        for (i = 0; i < rango; i++) {
            if (conjunto[i]) {
                elementos += (i + 1) + ",";
            }
        }

        // remueve la última coma
        ultimaComa = elementos.lastIndexOf(",");
        if (ultimaComa > 0) {
            elementos = elementos.substring(0, ultimaComa) + elementos.substring(ultimaComa + 1);
        }

        elementos = "{" + elementos + "}";

        return elementos;
    }

    public Conjunto clonar() {
        int i;
        boolean valor;
        Conjunto copia = new Conjunto();

        for (i = 0; i < rango; i++) {
            valor = conjunto[i];

            if (valor) {
                copia.insertarElemento(i+1);
            }
        }

        return copia;
    }
}