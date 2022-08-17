/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema5;
import PaqueteLectura.Lector;

/**
 *
 * @author Robledo
 */
public class Ejerc1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Ingrese el lado a del triangulo: ");
        double a = Lector.leerDouble();
        System.out.print("Ingrese el lado b del triangulo: ");
        double b = Lector.leerDouble();
        System.out.print("Ingrese el lado c del triangulo: ");
        double c = Lector.leerDouble();
        System.out.print("Ingrese el color de relleno del triangulo: ");
        String colorRelleno = Lector.leerString();
        System.out.print("Ingrese el color de linea del triangulo: ");
        String colorLinea = Lector.leerString();
        Triangulo T = new Triangulo(a,b,c,colorRelleno,colorLinea);
        System.out.println(T.toString());
        System.out.print("Ingrese un lado del cuadrado: ");
        double lado = Lector.leerDouble();
        System.out.print("Ingrese el color de relleno del cuadrado: ");
        String colorR = Lector.leerString();
        System.out.print("Ingrese el color de linea del cuadrado: ");
        String colorL = Lector.leerString();
        Cuadrado C = new Cuadrado(lado,colorR,colorL);
        System.out.println(C.toString());
    }
}
    
