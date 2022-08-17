/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package derosenicolas;

/**
 *
 * @author Nicolas
 */
public class Alumno {
    
    private String nombre;
    private int asistencias;
    private int DNI; 

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
    
    public int getDNI(){
        return this.DNI;
    }
    
    public String toString(){
        return "DNI: " + this.getDNI() + "Nombre " + this.getNombre() + "Asistencias " + this.getAsistencias();
    } 
}
