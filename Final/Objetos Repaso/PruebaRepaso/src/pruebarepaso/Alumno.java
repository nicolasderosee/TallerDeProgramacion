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
public class Alumno {
    
    private String nombre;
    private int asistencias;

    public Alumno(String nombre, int asistencias) {
        this.nombre = nombre;
        this.asistencias = asistencias;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getAsistencias() {
        return this.asistencias;
    }
    
    
    
    
}
