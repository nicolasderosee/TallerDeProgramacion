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
public class Referendum extends Urna {
    private int contadorAFavor;
    private int contadorEnContra;

    public Referendum(int unNumUrna) {
        super(unNumUrna);
        setContadorAFavor(0);
        setContadorEnContra(0);
    }
    
    public int getContadorAFavor(){
        return contadorAFavor;      
    }
  
    private void setContadorAFavor(int unContAFavor){
        contadorAFavor = unContAFavor;
    }
    
    public int getContadorEnContra(){
        return contadorEnContra;      
    }
  
    private void setContadorEnContra(int unContEnContra){
        contadorEnContra = unContEnContra;
    }
    
    
    public void votarAFavor(){
        contadorAFavor++;
    }
    
    public void votarEnContra(){
        contadorEnContra++;
    }

    public int calcularGanador() {
       int nro;
       if(this.getContadorAFavor() == this.getContadorEnContra())
           nro = -1;
       else 
           if(this.getContadorEnContra()> this.getContadorAFavor())
               nro = 0;
           else 
               nro = 1;
     return nro;
    }
  
    public double calcularTotalVotos() {
      return this.getContadorAFavor() + this.getContadorEnContra() + super.getVotosEnBlanco();
    }
                       
}
