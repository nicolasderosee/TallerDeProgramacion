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
public abstract class Recital {
    private String nomBanda;
    private String [] listaTemas; 
    private int DF;
    private int DL;
    
    public Recital(String unNomBanda, int cantTemas){
        setNombre(unNomBanda);
        setDF(cantTemas);
        DL = 0;
        listaTemas = new String [cantTemas];
    }
   
    public String getNombreBanda(){
        return nomBanda;       
    }
  
    private void setNombre(String unNombreBanda){
        nomBanda= unNombreBanda;
    }
    
    public int getDF(){
        return DF;
    }
    
    private void setDF(int unaCant){
        DF = unaCant;
    }
    
    public int getDL(){
        return DL;
    }
    
    public void agregarTema(String unTema){
        if(this.getDL()<this.getDF()){
            listaTemas[this.getDL()] = unTema;
            DL++;
        }
    }
    
    public String actuar(){
        String aux = "";
        for(int i=0; i<this.getDL(); i++)
            aux = "Y ahora tocaremos " + listaTemas[i];
       return (aux);
    }
    
    
}
