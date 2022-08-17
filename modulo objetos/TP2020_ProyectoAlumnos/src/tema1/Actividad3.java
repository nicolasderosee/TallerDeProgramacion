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
public class Actividad3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("ingrese un numero:");
        int numero = Lector.leerInt();
        int factorial = 1;
        int num = numero;
        
        while(num>0){
          factorial=factorial*num;
          num--;
        }
        
        System.out.println("El factorial de "+ numero + "! es: " + factorial);       
    }    
}
