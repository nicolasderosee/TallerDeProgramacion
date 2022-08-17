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
public class Referendum extends Urna{
    private int contVAFavor;
    private int contVEnContra;

    public Referendum(int U) {
        super(U);
        setContVAFavor(0);
        setContVEnContra(0);
    }
    
    public int getContVAFavor() {
        return contVAFavor;
    }

    public int getContVEnContra() {
        return contVEnContra;
    }

    private void setContVAFavor(int contVAFavor) {
        this.contVAFavor = contVAFavor;
    }

    private void setContVEnContra(int contVEnContra) {
        this.contVEnContra = contVEnContra;
    }
    
    public void votarAFavor(){ //incrementa en 1 los votos a favor 
        this.contVAFavor++;
    }
    
    public void votarEnContra(){ //incrementa en 1 los votos en contra 
        this.contVEnContra++;
    }

    @Override
    public int calcularGanador() {
        if(this.getContVAFavor() == this.getContVEnContra())
            return -1;
        else 
            if(this.getContVEnContra()>this.getContVAFavor())
                return 0;
            else
                return 1;
    }

    @Override
    public int calcularTotalVotos() {
        return this.getContVAFavor() + this.getContVEnContra() + super.getContVotosBlanco();
    }
    
    
}
