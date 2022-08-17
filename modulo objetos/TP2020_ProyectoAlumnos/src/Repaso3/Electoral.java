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
public class Electoral extends Urna{
    private int cantListas; 
    private int [] vecContadorVotos; //vector contador de votos de listas

    public Electoral(int U, int L) { //U es el nro de urna y L es la cantidad de listas existentes = DF
        super(U);
        setCantListas(L);
        vecContadorVotos = new int [this.getCantListas()]; 
        for (int i=0; i<this.getCantListas(); i++){
            vecContadorVotos[i] = 0;
        }
    }

    public int getCantListas() { //DF del vector contador 
        return cantListas;
    }

    private void setCantListas(int cantListas) {
        this.cantListas = cantListas;
    }  
    
    public boolean validarNumeroDeLista(int N){ //valida si N es un numero de lista valido 
        boolean ok = false;
        if((N>=0)&&(N<this.getCantListas()))
            ok = true;
     return ok;     
    }
    
    public void validarPorLista(int I){ //recibe un numero de lista valido y despues incrementa sus votos
        vecContadorVotos[I]++;
    }
    
    public int devolverVotosPorLista(int I){ //devuelve la cant de votos de un numero de lista ingresado valido
        return vecContadorVotos[I];
    }

    @Override
    public int calcularGanador() {
       int maxVotos = -1, listaGanadora = -1; 
       for(int i = 0; i<this.getCantListas(); i++){
           if(vecContadorVotos[i]>maxVotos){
               maxVotos = vecContadorVotos[i];
               listaGanadora = i;
           }
       }
     return listaGanadora;
    }

    @Override
    public int calcularTotalVotos() {
        int sum = 0, i;
        for (i=0; i<this.getCantListas(); i++) 
           sum = sum + vecContadorVotos[i];
       return sum + super.getContVotosBlanco();
    }    
    
}
