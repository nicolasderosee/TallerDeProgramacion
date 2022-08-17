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
public class Sector {
    private double costoACobrar;
    private Coche [] lugares;
    private int DF = 20;
    private int DL;

    public Sector(double costoACobrar) {
        this.costoACobrar = costoACobrar;
        this.lugares = new Coche[this.DF];
        this.DL = 0;
        for (int i=0; i<this.DF; i++) {
            this.lugares [i]= null;
        }
    }

    public double getCostoACobrar() {
        return this.costoACobrar;
    }
    
    public int ingresarCoche(Coche C){
        int i = 0;
        while (this.lugares[i] != null)
            i++;
        this.lugares[i] = C;
        this.DL++;
     return i;
    }
    
    public int cantidadCoches(){
        return this.DL;
    }
    
    
}
