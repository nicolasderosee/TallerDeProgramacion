/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso;

/**
 *
 * @author Robledo
 */
public abstract class Urna {
    private int numUrna;
    private int contador;
    
    public int getNumeroDeUrna(){
        return numUrna;      
    }
  
    public void setNumeroDeUrna(int unNumUrna){
        numUrna = unNumUrna;
    }
    
    public int getVotosEnBlanco(){
        return contador;      
    }
  
    public void setVotosEnBlanco(int unContador){
        contador = unContador;
    }
    public Urna(int unNumUrna){
        setNumeroDeUrna(unNumUrna);
        setVotosEnBlanco(0);
    }
    
   
    
    public void votarEnBlanco() {
       contador++;
    } 
    
    public abstract int calcularGanador();
    public abstract double calcularTotalVotos();
  
}
