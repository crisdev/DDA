/*
 * En un club de patín artístico se ha organizado una exhibición que incluye a
 * las siguientes categorías: A, B, C, I (intermedia) y P (principiante).
 * Los datos de los patinadores están almacenados en un arreglo de Patinador.
 * Se debe implementar la clase Patinador especificada en el UML y un programa
 * que permita implementar el TDA Patinador con la definición de los atributos y
 * la implementación de los siguientes métodos: constructores, una operación
 * observadora a elección, el método toString, una operación modificadora a
 * elección y las operaciones propias del tipo.
 */
package simulacros.primerParcial;

/**
 *
 * @author Cristian
 * @versioin 17/09/2015
 */
public class Patinador {

    private String apellido;
    private String nombre;
    private String DNI;
    private int edad;
    private char categoria;

// Métodos constructores
    public Patinador() {

    }

    public Patinador(String ape, String nom, String doc, int de, char cat) {
        apellido = ape;
        nombre = nom;
        DNI = doc;
        edad = de;
        categoria = cat;
    }

// Métodos observadores
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDoc() {
        return DNI;
    }

    public int getEdad() {
        return edad;
    }

    public char getCategoria() {
        return categoria;
    }
    
    public boolean equals(Patinador nuevo) {
        return apellido.equalsIgnoreCase(nuevo.apellido) && nombre.equalsIgnoreCase(nuevo.nombre) && DNI.equalsIgnoreCase(nuevo.DNI) &&
               edad == nuevo.edad && categoria == nuevo.categoria;
    }

    public String toString() {
        return "Nombre: " + nombre + "\nApellido: " + apellido + "\nDNI: " +
                DNI + "\nEdad: " + edad + "\nCategoría: " + categoria;
    }

// Modificadores
    public void setNombre(String nom) {
        nombre = nom;
    }

    public void setApellido(String ape) {
        apellido = ape;
    }

    public void setDoc(String doc) {
        DNI = doc;
    }

    public void setEdad(int de) {
        edad = de;
    }

    public void setCategoria(char cat) {
        // Almacena el caracter en mayúscula
        if (cat >= 'a') {
            categoria = (char) ('A' + (cat - 'a'));
        } else {
            categoria = cat;
        }
    }

// Propias del tipo
    public void asciendeCategoria() {
        switch (categoria) {
            case 'P': case 'p':
                categoria = 'I';
                break;
            case 'I': case 'i':
                categoria = 'C';
                break;
            case 'C': case 'c':
                categoria = 'B';
                break;
            case 'B': case 'b':
                categoria = 'A';
                break;
            case 'A': case 'a':
                break;
            default:
                System.out.println("Categoría incorrecta.");
                break;
        }
    }
}
