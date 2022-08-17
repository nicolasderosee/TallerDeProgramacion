/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso2;
import PaqueteLectura.Lector;

/**
 *
 * @author Robledo
 */
public class Eje1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("Ingrese el nombre de la discografica:");
        String nomDisc = Lector.leerString();
        System.out.print("Ingrese la ciudad de residencia:");
        String ciudad = Lector.leerString();
        System.out.print("Ingrese el nombre del dueño:");
        String nombreD = Lector.leerString();
        Discografica D = new Discografica(nomDisc,ciudad,nombreD);
        
        System.out.print("Ingrese la cantidad de temas producidos por el solista:");
        int cantTemas = Lector.leerInt();
        while(cantTemas != 0){
            System.out.print("Ingrese el nombre del artista:");
            String nombreA = Lector.leerString();
            System.out.print("Ingrese el instrumento que toca el artista:");
            String inst = Lector.leerString();
            Solista S = new Solista(nombreA, inst, cantTemas);
            D.agregarSolista(S);
            System.out.print("Ingrese la cantidad de temas producidos por el solista:");
            cantTemas = Lector.leerInt();
        }
        System.out.print("Ingrese la cantidad de integrantes de la banda:");
        int cantI = Lector.leerInt();
        while(cantI!=0){ 
            System.out.print("Ingrese el nombre de la banda:");
            String nomB = Lector.leerString();
            System.out.print("Ingrese la ciudad de formacion de la banda:");
            String ciuF = Lector.leerString();
            Banda B = new Banda(nomB,ciuF,cantI);
            D.agregarBanda(B);
            System.out.print("Ingrese la cantidad de integrantes de la banda:");
            cantI = Lector.leerInt();
        }
        System.out.println("Cantidad de bandas representadas por la discografica:" + D.getDLBanda());
        System.out.print("Ingrese un instrumento:");
        String nuevoInst = Lector.leerString();
        System.out.println("Cantidad de artistas que tocan: " + nuevoInst + ":" + D.cantArtistasInstrumento(nuevoInst));
        System.out.println("Nombre de la banda con más integrantes:" + D.bandaConMasIntegrantes());
        System.out.println("Cant de bandas que formadas en la misma ciudad que la discografica:" + D.mismaCiudad());
    }
}
    

