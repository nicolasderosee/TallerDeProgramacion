/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebarepaso;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Robledo
 */
public class Paciente2 {
    private String nombre;
    private double glucosa;
    private double dosis;

    public Paciente2(String nombre, double glucosa, double dosis) {
        this.nombre = nombre;
        this.glucosa = glucosa;
        this.dosis = dosis;
    }


    public String getNombre() {
        return nombre;
    }

    public double getGlucosa() {
        return glucosa;
    }

    public double getDosis() {
        return dosis;
    }
    
     public void aplicarDosis(double D){
        this.dosis = D;
        this.glucosa = this.glucosa - GeneradorAleatorio.generarDouble(1);
    }
    
   
}
