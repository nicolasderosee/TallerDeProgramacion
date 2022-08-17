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
public class EjeRepaso3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Alfa a = new Alfa();
        Beta b = new Beta();
        for (int i = 0; i<3; i++){
            int ID = GeneradorAleatorio.generarInt(11);
            Planta P = new Planta(ID,"girasol",2.1);
            a.agregarPlanta(P);
        }
        
        for (int i = 0; i<4; i++){
            int ID = GeneradorAleatorio.generarInt(11);
            Planta P = new Planta(ID,"cactus",0.1);
            a.agregarPlanta(P);
        }
        
        System.out.print("Ingrese la dosis de farmaco que quiera aplicar: ");
        double D = Lector.leerDouble();
        a.aplicarMismaDosis(D);
        b.aplicarMismaDosis(D);
        System.out.println("Grupo Alfa: " + a.toString());
        System.out.println("Grupo Beta: " + b.toString());    
    }   
}
