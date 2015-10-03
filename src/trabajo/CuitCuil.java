/*
 * Tanto el CUIT (Clave Única de Identificación Tributaria) como la CUIL
 * (Clave Única de Identificación Laboral) constan de tres partes:
 * El tipo, el número y el dígito verificador
 * separados por guión.
 * En el siguiente ejemplo se toma como CUIT el número ##-12345678-X donde
 * ## es el tipo, 12345678 es el número de DNI o número de sociedad y X es
 * el dígito verificador.
 * El tipo puede ser 20, 23 y 27 para personas físicas sin importar el género o
 * identidad; o 30, 33 para empresas o personas jurídicas.
 */
package trabajo;

/**
 *
 * @author Cristian
 * @version 29/09/2015
 */
public class CuitCuil {

    private int tipo;
    private long DNI;
    private int verificador;

    public CuitCuil(int tipo, long DNI) {
        this.tipo = tipo;
        this.DNI = DNI;
        verificador = modulo11();
    }

    /**
     * Calcula la cantidad de dígitos que tiene un número.
     *
     * @param numero valor de entrada
     * @return número de digitos
     */
    private int cantidadDigitos(long numero) {
        int contador;

        contador = 0;
        while (numero != 0) {
            numero = numero / 10;
            contador++;
        }

        return contador;
    }

    /**
     * Este módulo invierte el módulo del DNI y devuelve el valor de la posición
     * indicada en el parámetro.
     *
     * @param pos posicion deseada
     * @return valor de la posición
     */
    private int digito(int pos) {
        String valor = DNI + "";
        String valorInvertido = "";

        for (int i = 0; i < valor.length(); i++) {
            valorInvertido = valor.charAt(i) + valorInvertido;
        }

        return Integer.parseInt(valorInvertido.substring(pos, pos + 1));
    }

    /**
     * Genera el número verificador.
     *
     * @return verificador
     */
    private int modulo11() {
        int control, suma, longitudDNI, mod, cociente;

        suma = 0;
        longitudDNI = cantidadDigitos(DNI);
        for (int i = 0; i < longitudDNI; i++) {
            suma = digito(i) * (i % 6 + 1) + suma;
        }

        mod = suma % 11;
        cociente = suma / 11;

        switch (mod) {
            case 0:
                control = 0;
                break;
            case 1:
                control = cociente % 10 + cociente / 10;
                break;
            default:
                control = 11 - mod;
                break;
        }

        return control;
    }

    /**
     * Compara dos números de CUIT/CUIL.
     *
     * @param x CUIT/CUIL a comparar
     * @return verdadero si el primer CUIT/CUIL es menor al segundo
     */
    public boolean menorQue(CuitCuil x) {
        return (tipo + DNI + verificador) < (x.tipo + x.DNI + x.verificador);
    }

    public int getTipo() {
        return tipo;
    }

    public long getDNI() {
        return DNI;
    }

    public int getVerificador() {
        return verificador;
    }
}
