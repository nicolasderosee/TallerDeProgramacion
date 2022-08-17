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
public class Turno {
    
    private int num;
    private String nomDocente;
    private Alumno [] alumnos;
    private int DF = 50;
    private int DL;

    public Turno(int num, String nomDocente) {
        this.num = num;
        this.nomDocente = nomDocente;
        this.alumnos = new Alumno [DF];
        this.DL = 0;
    }
    
    
    
}
