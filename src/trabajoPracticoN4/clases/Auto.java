/*
 * Una empresa de alquiler de autos almacena la información de los autos que
 * tiene para alquilar de la siguiente manera: cada auto está identificado
 * por su patente (String de 6 caracteres), número registrado en el odómetro,
 * modelo y si está disponible o no. Aplicando los conceptos vistos en teoría,
 * implementar en Java la clase Auto de acuerdo a la especificación.
 */
package trabajoPracticoN4.clases;

/**
 *
 * @author Cristian
 * @version 12/09/2015
 */
public class Auto {
    private int cuentaKm;
    private boolean disponible;
    private String patente;
    private String modelo;
    
// Constructores
    public Auto(String pat) {
        patente = pat;
        disponible = true;
    }
    
    public Auto(String pat, int km, String mod, boolean dispo) {
        patente = pat;
        cuentaKm = km;
        modelo = mod;
        disponible = dispo;
    }
    
// Modificadores
    public void setCuentaKm(int km) {
        cuentaKm = km;
    }
    
    public void setModelo(String mod) {
        modelo = mod;
    }
    
    public void setDisponible(boolean disp) {
        disponible = disp;
    }
    
// Observadores
    public String getPatente() {
        return patente;
    }
    
    public int getCuentaKm() {
        return cuentaKm;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public boolean getDisponible() {
        return disponible;
    }
    
    public String aCadena() {
        String texto;
        
        if (disponible) {
            texto = "Sí";
        } else {
            texto = "No";
        }
        
        return "Modelo: " + modelo + "\nPatente: " + patente + "\nDisponible: " +
                texto + "\nKilómetros recorridos: " + cuentaKm;
    }
    
    public boolean igual(Auto a) {
        return cuentaKm == a.cuentaKm && disponible == a.disponible &&
                modelo.equalsIgnoreCase(a.modelo) && patente.equalsIgnoreCase(a.patente);
    }
}
