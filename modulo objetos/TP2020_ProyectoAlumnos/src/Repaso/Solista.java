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
public class Solista {
    private String nom;
    private String instrumento;
    private int cantTemas;
    
    public Solista(String unNom, String unInst, int unaCant){
        setNombre(unNom);
        setInstrumento(unInst);
        setCantTemas(unaCant);
    }
    
    public String getNombre(){
        return nom;       
    }
  
    public void setNombre(String unNombre){
        nom = unNombre;
    }
   
    public String getInstrumento(){
        return instrumento;       
    }
  
    public void setInstrumento(String unInstrumento){
        instrumento = unInstrumento;
    }
    
    public int getCantTemas(){
        return cantTemas;      
    }
  
    public void setCantTemas(int unaCantTemas){
        cantTemas= unaCantTemas;
    }
   
    
}
