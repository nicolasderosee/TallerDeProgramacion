/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso3;
import PaqueteLectura.Lector;

/**
 *
 * @author Robledo
 */
public class EjeRepaso1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("Ingrese el nombre de la discografica: ");
        String nomDisco = Lector.leerString();
        System.out.print("Ingrese la ciudad de residencia: ");
        String ciudadR = Lector.leerString();
        System.out.print("Ingrese el nombre del dueño:");
        String nomDueño = Lector.leerString();
        Discografica D = new Discografica(nomDisco,ciudadR,nomDueño);
        
        System.out.print("Ingrese la cantidad de temas producidos por el artista solista:");
        int cantTemas = Lector.leerInt();
        while(cantTemas != 0){
            System.out.print("Ingrese el nombre del artista:");
            String nomA = Lector.leerString();
            System.out.print("Ingrese el instrumento que toca el artista:");
            String inst = Lector.leerString();
            Solista S = new Solista(nomA,inst,cantTemas);
            D.agregarSolista(S);
            System.out.print("Ingrese la cantidad de temas producidos por otro artista solista: ");
            cantTemas = Lector.leerInt();
        }
        
        System.out.print("Ingrese la cantidad de integrantes de la banda:");
        int cantI = Lector.leerInt();
        while(cantI != 0){
            System.out.print("Ingrese el nombre de la banda:");
            String nomB = Lector.leerString();
            System.out.print("Ingrese la ciudad de formacion de la banda:");
            String ciuF  = Lector.leerString();
            Banda B = new Banda (nomB,ciuF,cantI);
            D.agregarBanda(B);
            System.out.print("Ingrese la cantidad de integrandes de otra banda: ");
            cantI = Lector.leerInt();
        }
        
        System.out.println("Cantidad de bandas representadas por la discografica:" + D.getDLBanda());
        
        System.out.print("Ingrese un instrumento:");
        String instrumento = Lector.leerString();
        System.out.println("Cantidad de artistas solistas que tocan " + instrumento + ":" + D.calcularCantArtistasInstrumento(instrumento));
        
        System.out.println("Nombe de la banda con mas integrantes:" + D.calcularBandaMayor());
        System.out.println("Cantidad de bandas formadas en la misma ciudad que la discografica:" + D.mismaCiudad());           
    }   
}
