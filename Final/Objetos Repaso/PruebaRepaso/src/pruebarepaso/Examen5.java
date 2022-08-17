/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebarepaso;

/**
 *
 * @author Nicolas
 */
public class Examen5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cochera C = new Cochera(250,220);
        
        Coche C1 = new Coche("AA",2);
        Coche C2 = new Coche("BB",3);
        Coche C3 = new Coche("CC",2);
        Coche C4 = new Coche("DD",48);
        
        C.ingresarCoche(C1);
        C.ingresarCoche(C2);
        C.ingresarCoche(C3);
        C.ingresarCoche(C4);
        
        System.out.println(C.sectorConMasCoches());
    }
    
}
