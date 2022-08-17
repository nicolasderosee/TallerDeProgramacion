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
public class Referendum extends Urna{
    private int contVotosAFavor;
    private int contVotosEnContra;

    public Referendum(int U) {
        super(U);
        setContadorAFavor(0);
        setContadorEnContra(0);
    }
    
    private void setContadorAFavor(int unaCant){
        contVotosAFavor = unaCant;
    }
    
    private void setContadorEnContra(int unaCant) {
        contVotosEnContra = unaCant;
    }
    
    public int getContadorAFavor(){
        return contVotosAFavor;
    }
    
    public int getContadorEnContra(){
        return contVotosEnContra;
    }
    
    public void votarAFavor(){
        this.contVotosAFavor++;
    }
    
    public void votarEnContra(){
        this.contVotosEnContra++;
    }

    @Override
    public int calcularGanador(){
       if(this.getContadorAFavor()== this.getContadorEnContra())
          return -1;
       else
           if(this.getContadorEnContra()>this.getContadorAFavor())
               return 0;
           else 
               return 1;
    }

    @Override
    public int calcularTotalVotos() {
        return this.getContadorAFavor() + this.getContadorEnContra() + super.getVotosEnBlanco();
    }

}
    
 
