/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso2;

/**
 *
 * @author Robledo
 */
public abstract class Urna {
    private int nroUrna;
    private int contVotosBlanco;
    
    public Urna(int unNroUrna){
       setNumeroDeUrna(unNroUrna);
       setVotosEnBlanco(0);
    }
    
     public int getNumeroDeUrna(){
        return nroUrna;      
    }
  
    public void setNumeroDeUrna(int unNumUrna){
        nroUrna = unNumUrna;
    }
    
    public int getVotosEnBlanco(){
        return contVotosBlanco;      
    }
  
    public void setVotosEnBlanco(int unContador){
        contVotosBlanco = unContador;
    }
    
    public void votarEnBlanco(){
        this.contVotosBlanco++;
    }
    
    public abstract int calcularGanador();
    public abstract int calcularTotalVotos();
}
