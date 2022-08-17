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
public class Examen3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Alfa a = new Alfa();
        Beta b = new Beta();
        
        a.agregarPaciente(new Paciente2("AA",2.0, 3.0));
        a.agregarPaciente(new Paciente2("BB",2.1, 3.1));
        a.agregarPaciente(new Paciente2("CC",2.2, 3.2));
        
        b.agregarPaciente(new Paciente2("DD",2.3, 3.3));
        b.agregarPaciente(new Paciente2("EE",2.4, 3.4));
        b.agregarPaciente(new Paciente2("FF",2.5, 3.5));
        b.agregarPaciente(new Paciente2("GG",2.6, 3.6));
        
        double D = Lector.leerDouble();
        a.aplicarDosis(D);
        b.aplicarDosis(D);
        
        System.out.println(a.toString());
        System.out.println(b.toString());
    }
    
}
