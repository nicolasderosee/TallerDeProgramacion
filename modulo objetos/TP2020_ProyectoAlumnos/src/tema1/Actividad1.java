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
public class Actividad1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("ingrese el lado a:");
        double a = Lector.leerDouble();
        System.out.print("ingrese el lado b:");
        double b = Lector.leerDouble();
        System.out.print("ingrese el lado c:");
        double c = Lector.leerDouble();
        
        if((a < b + c) && (b < a + c) && (c < a + b)){
            double suma = (a + b + c);
            System.out.println("el triangulo formado es valido");
            System.out.println("perimetro del triangulo:" + suma);
        }
        else 
            System.out.println("el triangulo ingresado no es valido:");
    }
          
}
    

