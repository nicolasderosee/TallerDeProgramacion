/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;
import PaqueteLectura.Lector;
/**
 *
 * @author Robledo
 */
public class Actividad7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        final int DFF = 8, DFC = 4; 
        int [][] tabla = new int [DFF][DFC];
        
        int f,c;
       
        for(f = 0 ; f < DFF; f++)
           for(c = 0 ; c < DFC ; c++)
             tabla[f][c] = 0; // matriz contadora 
        
        
        System.out.print("Ingrese el numero de piso:");
        int nroPiso = Lector.leerInt();
        
        while(nroPiso!=9){    
           System.out.print("Ingrese el numero de oficina:");
           int nroOf = Lector.leerInt();
           tabla[nroPiso][nroOf]++;
           System.out.print("Ingrese otro numero de piso:");
           nroPiso = Lector.leerInt();
        }
        
        for(f = 0 ; f < DFF; f++)
            for(c= 0 ; c < DFC ; c++)
               System.out.println("Cantidad de personas en el piso " + f + " oficina " + c + ": " + tabla[f][c]);          
    }
}
