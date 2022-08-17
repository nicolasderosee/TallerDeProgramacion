/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;
import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Robledo
 */
public class Actividad2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneradorAleatorio.iniciar();
       
        int cantTAutos = 0;
        double cantAutosIngreso = 0; 
        int pat = GeneradorAleatorio.generarInt(15);
        while (pat !=0){
           if(pat % 2 == 0){
              System.out.println("El auto con patente " + pat + " tiene permitido el paso");
              cantAutosIngreso++;
           }
           else 
              System.out.println("El auto con patente " + pat + " no tiene permitido el paso");
           
           cantTAutos++;
           pat = GeneradorAleatorio.generarInt(15);
        }
        
        double prom = cantAutosIngreso/cantTAutos;
        System.out.println("porcentaje de autos que ingresaron con respecto al total de autos " + prom);
    }
}