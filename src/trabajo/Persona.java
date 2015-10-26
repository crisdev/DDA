/*
 * Implementar un TDA Persona que modelará tanto a personas física o jurídicas
 * con los siguientes atributos:
 * 1. CUIT-CUIL de la cuitcuil (haga uso del TDA definido anteriormente)
 * 2. Nombre o razón social, contendrá el apellido y nombre de la cuitcuil o
 *    la razón social de la empresa.
 * 3. Calle del domicilio fiscal.
 * 4. Número del domicilio fiscal.
 * 5. Código postal del domicilio fiscal.
 * 6. Provincia del domicilio fiscal.
 */
package trabajo;

/**
 *
 * @author Cristian
 * @version 29/09/2015
 */
public class Persona {

    private CuitCuil cuitcuil;
    private String nombre;  // o razón social
    private String domicilio;
    private int nroDomicilio;
    private String codigoPostal;
    private String provincia;

    public Persona() {

    }

    public Persona(CuitCuil cc, String nom, String dom, int nro, String cod, String prov) {
        cuitcuil = cc;
        nombre = nom;
        domicilio = dom;
        nroDomicilio = nro;
        codigoPostal = cod;
        provincia = prov;
    }

    public String toString() {
        return "Nombre: " + nombre + "\nCUIT: " + cuitcuil.getTipo() + "-" + cuitcuil.getDNI() + "-"
                + cuitcuil.getVerificador() + "\nDomicilio: " + domicilio + "\nNúmero: " + nroDomicilio
                + "\nCódigo Postal: " + codigoPostal + "\nProvincia: " + provincia;
    }

    public CuitCuil getCuitCuil() {
        return cuitcuil;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public int getNroDomicilio() {
        return nroDomicilio;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getProvincia() {
        return provincia;
    }

}
