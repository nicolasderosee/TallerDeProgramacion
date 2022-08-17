/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebarepaso;

/**
 *
 * @author Robledo
 */
public class Cama {
    private Paciente p;
    private int dias; //cant dias que la cama es ocupada

    public Cama() {
        this.p = null;
        this.dias = 0;
    }

    public Paciente getP() {
        return p;
    }

    public int getDiasOcupada() {
        return dias;
    }

    public void setP(Paciente p) {
        this.p = p;
    }

    public void setDiasOcupada(int dias) {
        this.dias = dias;
    }
    
    public boolean getOcupada(){
        return this.getP()!= null; //si paciente no es null entonces significa que la cama esta ocupada y devuelve true 
    }
    
    public void incrementarDias(int d){
        this.dias = this.dias + d;
    }
    
}
