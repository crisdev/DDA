package utiles;

/**
 *
 * @author Cristian
 * @version 12/08/2015
 */
public class Geometria {

    /**
     * Calcula el perímetro (suma de lados) de un cuadrado a partir de su lado.
     *
     * @param lado lado del cuadrado
     * @return perímetro del cuadrado
     */
    public static double calcularPerimetroCuadrado(double lado) {
        return (4 * lado);
    }

    /**
     * Calcula el área (superficie) de un cuadrado a partir de uno de sus lados.
     * 
     * @param lado lado del cuadrado
     * @return área del cuadrado
     */
    public static double calcularAreaCuadrado(double lado) {
        return (lado * lado);
    }

    /**
     * Calcula el perímetro de una circunferencia.
     * 
     * @param radio radio de la circunferencia
     * @return perímetro de la circunferencia
     */
    public static double calcularPerimetroCirculo(double radio) {
        return (2 * Math.PI * radio * radio);
    }

    /**
     * Calcula el área de un círculo a partir de su radio.
     *
     * @param radio radio del círculo
     * @return área del círculo
     */
    public static double calcularAreaCirculo(double radio) {
        return (Math.PI * radio * radio);
    }

    /**
     * Calcula el perímetro de un rectángulo.
     * 
     * @param base base del rectángulo
     * @param altura altura del rectángulo
     * @return perímetro del rectángulo
     */
    public static double calcularPerimetroRectangulo(double base, double altura) {
        return (2 * base + 2 * altura);
    }

    /**
     * Calcula el área (superficie) de un rectángulo.
     * 
     * @param base base del rectángulo
     * @param altura altura del rectángulo
     * @return área del rectángulo
     */
    public static double calcularAreaRectangulo(double base, double altura) {
        return (base * altura);
    }

    /**
     * Calcula el perímetro de un triángulo.
     * 
     * @param lado lado del triángulo
     * @return perímetro del triángulo
     */
    public static double calcularPerimetroTriangulo(double lado) {
        return (3 * lado);
    }

    /**
     * Calcula el área (superficie) de un triángulo.
     * 
     * @param lado lado del triángulo
     * @return area del triángulo
     */
    public static double calcularAreaTriangulo(double lado) {
        return (lado * lado * Math.sqrt(3) / 4);
    }

    /**
     * A partir de los lados de un triángulo determina si éste es equilátero.
     * 
     * @param lado1 primer lado del triángulo
     * @param lado2 segundo lado del triángulo
     * @param lado3 tercer lado del triángulo
     * @return verdadero si el triángulo es equilátero
     */
    public static boolean esTrianguloEquilatero(double lado1, double lado2, double lado3) {
        final double delta = 1e-6;
        
        boolean resultado;
        
        resultado = Math.abs((lado1-lado2)) < delta && Math.abs((lado1-lado3)) < delta && Math.abs((lado2-lado3)) < delta;
        
        return resultado;
    }
}
