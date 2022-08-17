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
public class Catedra {
    
    private Turno turno1;
    private Turno turno2; 

    public Catedra(Turno turno1, Turno turno2) {
        this.turno1 = turno1;
        this.turno2 = turno2;
    }
    
    public void agregarAlumno(Alumno a){
        if(this.getTurno1().cantidadAlumnos() < this.getTurno2().cantidadAlumnos())
            this.turno1.agregarAlumno(a);
        else this.turno2.agregarAlumno(a);
    }
    
    public String toString(){
        return "Representacion turno: " + turno1.getNum()  + " Docente" + this.turno1.getNomDocente() + this.turno1.toString();
    }
    
    public int mayorAsistencias(){
        if(this.getTurno1().contarAsistencias() > this.getTurno2().contarAsistencias())
            return this.turno1.getNum();
        else
            return this.turno2.getNum(); 
    }

    public Turno getTurno1() {
        return this.turno1;
    }

    public Turno getTurno2() {
        return this.turno2;
    }
    
    
    
}
