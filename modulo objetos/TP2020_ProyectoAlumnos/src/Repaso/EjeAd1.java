/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso;
import PaqueteLectura.Lector;
/**
 *
 * @author Robledo
 */
public class EjeAd1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.print("Ingrese el nombre de la discográfica: ");
       String nom = Lector.leerString();
       System.out.print("Ingrese la ciudad de residencia: ");
       String ciu = Lector.leerString();
       System.out.print("Ingrese el nombre del dueño: ");
       String nomDueño = Lector.leerString();
       Discografica D = new Discografica(nom,ciu,nomDueño);
       
       System.out.print("Ingrese la cantidad de temas producidos por el solista: ");
       int cantTemas = Lector.leerInt();
       while(cantTemas!=0){
           System.out.print("Ingrese el nombre del solista: ");
           String nomSolista = Lector.leerString();
           System.out.print("Ingrese el instrumento que toca el solista: ");
           String inst = Lector.leerString();
           Solista S = new Solista(nomSolista,inst,cantTemas);
           D.agregarSolista(S);
           System.out.print("Ingrese la cantidad de temas producidos por el solista: ");
           cantTemas = Lector.leerInt();
       }
       System.out.print("Ingrese la cantidad de integrantes de la banda: ");
       int cantIntegrantes = Lector.leerInt();
       while(cantIntegrantes!=0){
            System.out.print("Ingrese el nombre de la banda: ");
            String nomBanda = Lector.leerString();
            System.out.print("Ingrese la ciudad de formación de la banda: ");
            String ciudadForm = Lector.leerString();
            Banda B = new Banda(nomBanda,ciudadForm,cantIntegrantes);
            D.agregarBanda(B);
            System.out.print("Ingrese la cantidad de integrantes de la banda: ");
            cantIntegrantes = Lector.leerInt();
        }
        System.out.println("Cantidad de bandas representadas por una discográfica: " + D.getDLBanda());
        System.out.print("Ingrese un instrumento:");
        String unInst = Lector.leerString();
        System.out.println("Cantidad de Artistas que tocan " + unInst + ": " + D.CantArtistasInstrumento(unInst));  
        System.out.println("Nombre de la banda con más integrantes: " + D.BandaMayor());
        System.out.println("Cantidad de bandas formadas en la misma ciudad que la discografica: " + D.MismaCiudad());
    }
    
}
