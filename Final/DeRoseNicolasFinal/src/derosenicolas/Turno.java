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
        for (int i=0; i<DF; i++){
            alumnos[i] = null;
        }
    }

    public int getNum() {
        return this.num;
    }

    public String getNomDocente() {
        return this.nomDocente;
    }
    
    
    
    public void agregarAlumno(Alumno a){
        this.alumnos[DL] = a;
        DL++;
    }
    
    public int cantidadAlumnos(){
        return this.DL;
    }
    
    public String toString(){
        String aux = "";
        for (int i=0; i<this.cantidadAlumnos(); i++){
            aux = aux + "Alumno " + i + alumnos[i].toString();
        }
     return aux;
    }
    
    public int contarAsistencias(){
        int cant = 0;
        for (int i=0; i<this.cantidadAlumnos(); i++)
            cant = cant + alumnos[i].getAsistencias();
    return cant;
    }
}
