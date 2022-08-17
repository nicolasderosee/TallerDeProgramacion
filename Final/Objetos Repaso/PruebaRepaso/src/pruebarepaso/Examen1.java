/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebarepaso;

import PaqueteLectura.Lector;

/**
 *
 * @author Robledo
 */
public class Examen1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Hospital H = new Hospital("NOMBRE" , "DIRECCION");   
        Paciente p1 = new Paciente("AA", 11, 20, "OS1");
        Paciente p2 = new Paciente("BB", 22, 40, "OS2");
        Paciente p3 = new Paciente("CC", 23, 60, "OS3");
        
        H.ingresarUnPaciente(p1, 10);
        H.ingresarUnPaciente(p2, 67);
        H.ingresarUnPaciente(p3, 32);
        
        H.incrementarDias();
        
        System.out.println(H.cantidadPacientesInternados());
        
        H.altaPaciente(Lector.leerInt());
    }
    
}
