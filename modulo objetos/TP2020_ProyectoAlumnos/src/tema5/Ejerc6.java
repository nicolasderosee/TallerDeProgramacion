/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema5;

/**
 *
 * @author Robledo
 */
public class Ejerc6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VisorFigurasModificado v = new VisorFigurasModificado();
        Cuadrado c1 = new Cuadrado(10,"Violeta","Rosa");
        v.guardar(c1);
        Rectangulo r= new Rectangulo(20,10,"Azul","Celeste");
        v.guardar(r);
        Cuadrado c2= new Cuadrado(30,"Rojo","Naranja");
        v.guardar(c2);
        System.out.println("Figuras del visor:"); 
        v.mostrar();  
    }   
}
