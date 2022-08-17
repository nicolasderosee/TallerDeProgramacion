/*
Demo que crea objetos Libro invocando a los constructores definidos. Tema 4.
3-A- Modifique la clase Libro (carpeta tema 4) para ahora considerar que el primer autor
es un objeto instancia de la clase Autor. Implemente la clase Autor, considerando que éstos
se caracterizan por nombre y biografía. El autor debe poder devolver/modificar el valor de
sus atributos. 
B- Modifique el programa ppal. (carpeta tema 4) para instanciar un libro con su autor,
considerando las modificaciones realizadas en A). Los datos se ingresan por teclado. 
 */
package tema4;

import PaqueteLectura.Lector;

/**
 *
 * @author vsanz
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Ingrese el nombre del autor:");
        String nom = Lector.leerString();
        System.out.print("Ingrese la biografia del autor:");
        String bio = Lector.leerString();
        Autor a = new Autor(nom,bio);
        System.out.print("Ingrese el titulo del libro:");
        String titulo = Lector.leerString();
        System.out.print("Ingrese la editorial del libro:");
        String edit = Lector.leerString();
        System.out.print("Ingrese el año de edición:");
        int añoEdicion = Lector.leerInt();
        System.out.print("Ingrese el codigo ISBN del libro:");
        String codISBN = Lector.leerString();
        System.out.print("Ingrese el precio del libro:");
        double precio = Lector.leerDouble();
        Libro libro1= new  Libro(titulo,edit,añoEdicion,a,codISBN,precio);
        Libro libro2= new Libro("Learning Java by Building Android Games",  "CreateSpace Independent Publishing", new Autor("John Horton","22 años"), "978-1512108347");
        System.out.println(libro1.toString());
        System.out.println(libro2.toString());
        System.out.println("Precio del libro2: " +libro2.getPrecio());
        System.out.println("Año edición del libro2: " +libro2.getAñoEdicion());
        Libro libro3= new Libro();   
    }   
}
