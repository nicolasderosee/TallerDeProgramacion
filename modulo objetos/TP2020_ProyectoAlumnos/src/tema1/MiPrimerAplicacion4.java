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
public class MiPrimerAplicacion4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         GeneradorAleatorio.iniciar();
        
        final int DF = 10; // se usa final para declarar constantes
        
        int [] veccontador = new int [DF]; //desde el 0 al 9
        int cuantos,valor;
      
        cuantos = Lector.leerInt();
        for(int i = 0 ; i < DF ; i++) // de 0 a 9 
            veccontador[i] = 0;
    
        for(int i = 1 ; i <= cuantos ; i++) {
           valor = GeneradorAleatorio.generarInt(10);//valores entre 0 y 9
           veccontador[valor]++; //suma 1 al valor que se encuentra en esa posicion
        }
        
        for(int i = 0 ; i < DF ; i++) // de 0 a 9 
          System.out.println("El valor " + i + " salio " + veccontador[i] + " veces");
    }
}
    

