/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Robledo
 */
public class MiPrimerAplicacion5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneradorAleatorio.iniciar();
        
        final int DFF = 4, DFC = 5; 
        
        int [][] contador = new int [DFF][DFC]; //matriz 4filasx5columnas
        int cuantos, fila, columna;
      
        cuantos = Lector.leerInt();
        for(int i = 0 ; i < DFF; i++)
           for(int j = 0 ; j < DFC ; j++)
             contador[i][j] = 0; //contador = matriz contadora 
    
        for(int i = 1 ; i <= cuantos ; i++) {
          fila = GeneradorAleatorio.generarInt(DFF);//valores entre 0 y 3 
          columna = GeneradorAleatorio.generarInt(DFC);//valores entre 0 y 4 
           
          contador[fila][columna]++;//sumo 1 al valor que se encuentra en esa pos
        }
        
        for(int i = 0 ; i < DFF; i++)
            for(int j = 0 ; j < DFC ; j++)
               System.out.println("El valor " + i + "," + j + " salió " + 
                                   contador[i][j] + " veces.");
        
       
        /* para recorrer los elementos por columna 
        for(int j = 0 ; j < DFC ; j++)
            for(int i = 0 ; i < DFF; i++)
               System.out.println("El valor " + i + "," + j + " salió " + 
                                   contador[i][j] + " veces.");
        */
        
        /* para imprimir solo de una determinada columa eje col 3
        for(int i = 0 ; i < DFF; i++)
            System.out.println("El valor " + i + "," + 3 + " salió " + 
                                contador[i][3] + " veces.");
        */
        
        /* para imprimir solo de una determinada fila eje fila 2
        for(int j = 0 ; j < DFC; j++)
            System.out.println("El valor " + 2 + "," + j + " salió " + 
                                contador[2][j] + " veces.");
        */
    }    
}
