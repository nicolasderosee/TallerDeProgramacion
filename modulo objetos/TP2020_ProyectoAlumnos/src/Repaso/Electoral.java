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
public class Electoral extends Urna {
    private int cantListas;
    private int [] vecContador;
    
    public Electoral (int U, int L){
        super(U);
        setCantidadListas(L); 
        vecContador = new int [this.getCantidadListas()];
        for (int i=0; i<this.getCantidadListas(); i++)
            vecContador[i]=0;
    } 
    
    private int getCantidadListas(){
        return cantListas;      
    }
  
    private void setCantidadListas(int unaCantL){
        cantListas = unaCantL;
    }
  
    public boolean validarNroDeLista(int N){
        boolean ok = false;
        if((N>=0)&&(N<this.getCantidadListas()))
           ok = true;
     return ok;
    }
    
    public void votarPorLista(int I){
        vecContador[I]++;
    }
    
    public int devolverVotosPorLista(int I){
     return vecContador[I];
    }

    public int calcularGanador() {
       int votos = -1, ganadora = -1;
       for (int i=0; i<this.getCantidadListas(); i++)
            if(vecContador[i] >= votos){
                votos = vecContador[i];
                ganadora = i;
            }
     return ganadora;
    }
    
    public double calcularTotalVotos(){
        int sumVotos = 0;
        for(int i=0; i<this.getCantidadListas(); i++)
            sumVotos = sumVotos + vecContador[i];
      return sumVotos + super.getVotosEnBlanco();
    }
    
}
