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
public class Ejerc3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Ingrese el nombre: ");
        String nom = Lector.leerString();
        System.out.print("Ingrese el dni: ");
        int dni = Lector.leerInt();
        System.out.print("Ingrese la edad: ");
        int edad = Lector.leerInt();
        Persona P = new Persona(nom,dni,edad);
        System.out.println(P.toString());
        System.out.print("Ingrese el nombre del trabajador: ");
        String nombre = Lector.leerString();
        System.out.print("Ingrese el dni: ");
        int Dni = Lector.leerInt();
        System.out.print("Ingrese la edad: ");
        int ed = Lector.leerInt();
        System.out.print("Ingrese la tarea que realiza: ");
        String tarea = Lector.leerString();
        Trabajador T = new Trabajador(nombre,Dni,ed,tarea);
        System.out.println(T.toString());
    }
    
}
