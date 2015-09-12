/*
 * Implementación TDA especie.
 */
package TrabajoPracticoN4;

/**
 *
 * @author Cristian
 * @version 12/09/2015
 */
public class Especie {
// Atributos
    private String nombre;
    private int poblacion;
    private double tasaDeCrecimiento;

// Constructores
    public Especie(String nombre) {
        this.nombre = nombre;
    }

    public Especie(String nombre, int poblacion, double tasaCrec) {
        this(nombre);  // invoca al constructor con un parámetro
        this.poblacion = poblacion;
        this.tasaDeCrecimiento = tasaCrec;
    }

// Observadores
    public String getNombre() {
        return this.nombre;
    }

    public int getPoblacion() {
        return this.poblacion;
    }

    public double getTasaCrec() {
        return tasaDeCrecimiento;
    }

    public String aCadena() {
        return "Nombre: " + this.nombre + "\nPoblacion: " + this.poblacion + "\nTasa de Crecimiento: " + this.tasaDeCrecimiento + "%\n---";
    }

    public boolean igual(Especie otroObjeto) {
        return nombre.equals(otroObjeto.nombre) && poblacion == otroObjeto.poblacion && tasaDeCrecimiento == otroObjeto.tasaDeCrecimiento;
    }

// Modificadores
    public void setPoblacion(int n) {
        this.poblacion = n;
    }

    public void setTasaCrec(double t) {
        this.tasaDeCrecimiento = t;
    }

// Propias del tipo
    public int poblacionProyectada(int anios) {
        int poblacionAnual;
        int i;

        i = 1;
        poblacionAnual = (int) Math.round(this.poblacion + (this.poblacion * this.tasaDeCrecimiento / 100.0));

        while (i < anios) {
            poblacionAnual = poblacionAnual + (int) Math.round(poblacionAnual * this.tasaDeCrecimiento / 100.0);
            i++;
        }

        return poblacionAnual;
    }
}
