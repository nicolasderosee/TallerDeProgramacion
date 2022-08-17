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
public class Ejerc2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        System.out.print("Ingrese el nombre del entrenador: ");
        String nombre = Lector.leerString();
        System.out.print("Ingrese el sueldo basico del entrenador: ");
        double sueldoBasic = Lector.leerDouble();
        System.out.print("Ingrese la cantidad de camponatos ganados:");
        int cant = Lector.leerInt();
        Entrenador E = new Entrenador (cant,nombre,sueldoBasic);
        System.out.println(E.toString());
        
        System.out.print("Ingrese el nombre del jugador: ");
        String nom = Lector.leerString();
        System.out.print("Ingrese el sueldo basico del jugador: ");
        double sueldoB = Lector.leerDouble();
        System.out.print("Ingrese la cantidad de partidos jugados:");
        int cantPjugados = Lector.leerInt();
        System.out.print("Ingrese la cantidad de goles anotados:");
        int cantGAnotados = Lector.leerInt();
        Jugador J = new Jugador(cantPjugados,cantGAnotados,nom,sueldoB);
        System.out.println(J.toString());
    }
    
}
