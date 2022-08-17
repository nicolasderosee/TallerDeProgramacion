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
public class Coche {
    
    private String patente;
    private int cantHoras;

    public Coche(String pat, int cantHoras) {
        this.patente = pat;
        this.cantHoras = cantHoras;
    }


    public String getPatente() {
        return this.patente;
    }

    public int getCantHoras() {
        return this.cantHoras;
    }
    
    
    
}
