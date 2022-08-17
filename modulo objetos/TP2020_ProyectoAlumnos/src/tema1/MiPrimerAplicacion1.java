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
public class MiPrimerAplicacion1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneradorAleatorio.iniciar(); //con esta instruccion en cada ejecucion los valores random son distintos 
        int año = Lector.leerInt(), mes = GeneradorAleatorio.generarInt(12) + 1;
        double precio = GeneradorAleatorio.generarDouble(100); //si la variable me aparece subrrayada en gris significa que no le estoy dando uso
        boolean V = true, F = false;
        char letra = '!';
        String cartel = GeneradorAleatorio.generarString(15); //genera un string de long 15
       
        System.out.println(cartel);
        System.out.println("Estamos en el año " + año + " en el mes " + mes + letra);
        System.out.println("El precio del petroleo hoy es " + precio);
    }   
}
