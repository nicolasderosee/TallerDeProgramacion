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
public class Act5Repaso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final int DF = 5;
        double [] vector = new double [DF]; //desde 0 a 14
        
        double sumAltura = 0, prom;
        for(int i = 0 ; i < DF ; i++){
            System.out.print("Ingrese la altura del jugador:");
            double altura = Lector.leerDouble();
            vector [i] = altura; 
            sumAltura = sumAltura + altura;
        }
        prom = sumAltura/DF;
        System.out.println("Altura promedio:" + prom);
        
        int cantJugadores = 0;
        for(int i = 0 ; i < DF ; i++){
            if(vector [i] > prom)
                cantJugadores++;
        } 
        System.out.println("cantidad de jugadores con altura por encima del prom:" + cantJugadores);
    }   
}
