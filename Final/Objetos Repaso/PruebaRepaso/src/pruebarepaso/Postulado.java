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
public class Postulado {
    
    private String nombre;
    private double promedio;
    private int ingreso;
    private int egreso;

    public Postulado(String nombre, double promedio, int ingreso, int egreso) {
        this.nombre = nombre;
        this.promedio = promedio;
        this.ingreso = ingreso;
        this.egreso = egreso;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getPromedio() {
        return this.promedio;
    }

    public int getIngreso() {
        return this.ingreso;
    }

    public int getEgreso() {
        return this.egreso;
    }
    
    
    
}
