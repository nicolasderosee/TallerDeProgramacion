/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso3;

/**
 *
 * @author Robledo
 */
public class Cama {
    private int nro;
    private boolean ocupada; //guarda null si no esta ocupada o guarda el paciente si lo esta 
    private int cantDiasOcupada;
    private Paciente P;

    public Cama() {
        this.setNro(0);
        this.setCantDiasOcupada(0);
        this.setOcupada(false);
        this.setP(null);
    }
    
    public int getNro() {
        return nro;
    }

    public boolean getOcupada() {
        return ocupada;
    }

    public int getCantDiasOcupada() {
        return cantDiasOcupada;
    }

    public Paciente getP() {
        return P;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public void setCantDiasOcupada(int cantDiasOcupada) {
        this.cantDiasOcupada = cantDiasOcupada;
    }

    public void setP(Paciente P) {
        this.P = P;
    }
    
    public void registrarPaciente(Paciente P, int nroCama){
        this.setNro(nroCama);
        this.setP(P);
        this.setOcupada(true); // cambio el boolean a true para indicar que la cama fue ocupada
    }
    
    public void incrementarCantDiasOcupada(){
        if(this.ocupada!= false) // si la cama está ocupada, o sea el boolean es distinto de false entonces incremento la cant de dias ocupada
            this.cantDiasOcupada++;
    }
    
}
