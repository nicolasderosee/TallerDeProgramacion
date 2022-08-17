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
public class Actividad4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        final int DF = 10;
        int num;
     
        for (int i=1; i<DF; i++){
          num = i;
          int factorial = 1;
          while(num>0){
            factorial=factorial*num;
            num--;
          }
          System.out.println("El factorial de "+ i + "! es: " + factorial);    
        }
        
        for (int i=1; i<DF; i++){
          num = i;
          int factorial = 1;
          if(num % 2 != 0){
            while(num>0){
              factorial=factorial*num;
              num--;
            }
            System.out.println("El factorial de "+ i + "! es: " + factorial);
          }
          else 
            System.out.println("No se puede calcular el factorial de " + i + "!");
            
        }
    }   
}
