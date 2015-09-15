/*
 * Implementar el TDA Racional respetando la definición dada en la guía.
 */
package trabajoPracticoN4.clases;

/**
 *
 * @author Cristian
 * @version 12/09/2015
 */
public class Racional {
    private int numerador;
    private int denominador;

// Constructores
    public Racional(int n, int d) {
        numerador = n;
        denominador = d;

        if (denominador == 0) {
            denominador = 1;
        }
    }

// Observadores
    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public double pasarADouble() {
        return (double) numerador / denominador;
    }

    public String aCadena() {
        return numerador + "/" + denominador;
    }

    public boolean igual(Racional r) {
        return numerador == r.numerador && denominador == r.denominador;
    }

// Modificadores
    public void setNumerador(int n) {
        numerador = n;
    }

    public void setDenominador(int d) {
        if (d > 0) {
            denominador = d;
        }
    }

// Propias del tipo
    public Racional sumar(Racional r) {
        Racional c;

        c = new Racional(numerador + r.numerador, denominador + r.denominador);

        return c;
    }

    public Racional restar(Racional r) {
        int resto;
        Racional c;

        resto = denominador - r.denominador;

        if (resto == 0) {
            c = null;
        } else {
            c = new Racional(numerador - r.numerador, resto);
        }

        return c;
    }

    public Racional multiplicar(Racional r) {
        Racional c;

        c = new Racional(numerador * r.numerador, denominador * r.denominador);

        return c;
    }

    public Racional dividir(Racional r) {
        Racional c = r;

        if (r.denominador > 0) {
            c = new Racional (numerador / r.numerador, denominador / r.denominador);
        }

        return c;
    }

    public void simplificar() {
        int mcd, den;

        mcd = mcd(numerador, denominador);
        den = denominador / mcd;

        if (den == 1) {
            System.out.println(numerador / mcd);
        } else {
            System.out.println(numerador / mcd + "/" + den);
        }
    }

    /**
     * Calcula el máximo común divisor entre dos números utilizando
     * el algoritmo de Euclides.
     *
     * @param a numerador
     * @param b denominador
     * @return máximo común divisor entre a y b
     */
    private int mcd(int a, int b) {
        int tmp;

        while (b != 0) {
            tmp = b;
            b = a % b;

            a = tmp;
        }

        return a;
    }
}
