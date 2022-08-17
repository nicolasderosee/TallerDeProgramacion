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
public class Actividad5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final int DF = 15;  
        double [] vector = new double [DF]; //desde el 0 al 15
        double sumaAlturas = 0;
        
        
        for(int i = 0 ; i < DF ; i++){ // de 0 a 15
            System.out.print("ingrese la altura del jugador:");
            double altura = Lector.leerDouble();
            vector[i] = altura;
            sumaAlturas = sumaAlturas + altura;
        }
        
        double prom = sumaAlturas/DF;
        System.out.println("promedio de alturas: " + prom );
        
        int cantj = 0;
        for(int i = 0 ; i < DF ; i++){ 
          if(vector[i]>prom) 
              cantj++;
        }
        System.out.println("Cantidad de jugadores con altura por encima del prom " + cantj);
    }   
}
