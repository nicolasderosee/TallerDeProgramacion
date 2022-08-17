/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso3;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author Robledo
 */
public class EjeRepaso5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Hospital H = new Hospital("San luis","av 75 1269");
        for (int i=0; i<3; i++){
            System.out.print("Ingrese el dni del paciente: ");
            int dni = Lector.leerInt();
            System.out.print("Ingrese el nombre: ");
            String nom = Lector.leerString();
            System.out.print("Ingrese la obra social: ");
            String obra = Lector.leerString();
            Paciente P = new Paciente(dni,nom,obra);
            int nroCama = GeneradorAleatorio.generarInt(100);
            H.ingresarPaciente(P, nroCama);
        }
        H.incrementar();
        System.out.println("Cantidad de pacientes internados: " + H.getCantPacientesInternados());
        System.out.println("Ingrese el dni del paciente para darle el alta: ");
        int nuevoDni = Lector.leerInt();
        H.liberarCama(nuevoDni);
        
    }
    
}
