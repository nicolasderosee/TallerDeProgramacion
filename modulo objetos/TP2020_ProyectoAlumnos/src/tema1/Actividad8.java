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
public class Actividad8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final int DF = 5;
        int [] vec = new int [DF];
        int i;
        
        for(i = 0 ; i < DF ; i++) // de 0 a 4 - vector de 5 elementos 
            vec[i] = 0;
        
        System.out.print("Ingrese el numero de la operacion que desea realizar:");
        int num = Lector.leerInt();
        
        while(num != 5){    
           vec[num]++;
           System.out.print("Ingrese el numero de la operacion que desea realizar:");
           num = Lector.leerInt();
        }
        
        int max = -1, opmax = 0; 
        for(i = 0 ; i < DF ; i++){ 
            System.out.println("Cantidad de personas atendidas en la operacion " + i + ": " + vec[i]);
            if(vec[i]>max){
                max = vec[i];
                opmax = i;
            }     
        } 
        System.out.println("la operacion mas solicitada es " + opmax);       
    }  
}
