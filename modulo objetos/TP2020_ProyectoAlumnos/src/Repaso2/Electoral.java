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
public class Electoral extends Urna{
    private int cantListas; //DF del vector 
    private int [] vecContador;

    public Electoral(int U, int L){ // U es el nro de urna y L es la cant de listas = dimF
        super(U);
        setUnaCantDeListas(L);
        vecContador = new int [this.getCantDeListas()];
        for (int i=0; i<this.getCantDeListas(); i++) 
            vecContador[i] = 0;
    }

    private void setUnaCantDeListas(int unaCant){
        cantListas = unaCant;
    }
    
    public int getCantDeListas(){ //retorna la df del vector, la cant de listas que hay  
        return cantListas; 
    }
    
    public boolean validarNumeroDeLista(int N){
        boolean ok = false;
        if ((N>=0)&&(N<this.getCantDeListas()))
             ok = true; 
     return ok;
    }
    
    public void votarPorLista(int I){ //I es un nuero de lista válido 
        vecContador[I]++;
    }
    
    public int devolverVotosPorLista(int I){
        return vecContador[I];
    }

    @Override
    public int calcularGanador() {
       int votos = -1, i,ganadora = -1;
       for (i=0; i<this.getCantDeListas(); i++) 
           if(vecContador[i] > votos){
                 votos = vecContador[i];
                 ganadora = i;
            }
     return ganadora;
    }

    @Override
    public int calcularTotalVotos() {
       int sum = 0, i;
       for (i=0; i<this.getCantDeListas(); i++) 
           sum = sum + vecContador[i];
     return sum + super.getVotosEnBlanco();
    }
                 
}
    
  
