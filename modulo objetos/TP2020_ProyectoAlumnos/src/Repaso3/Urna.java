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
public abstract class Urna {
    private int nroUrna;
    private int contVotosBlanco;

    public Urna(int unNroUrna) {
        setNroUrna(unNroUrna);
        setContVotosBlanco(0);
    }
    
    
    public int getNroUrna() {
        return nroUrna;
    }

    public int getContVotosBlanco() {
        return contVotosBlanco;
    }

    public void setNroUrna(int nroUrna) {
        this.nroUrna = nroUrna;
    }

    private void setContVotosBlanco(int contVotosBlanco) {
        this.contVotosBlanco = contVotosBlanco;
    }
    
    public void votarEnBlanco(){
        this.contVotosBlanco++;
    }
    
    public abstract int calcularGanador();
    public abstract int calcularTotalVotos();
}
