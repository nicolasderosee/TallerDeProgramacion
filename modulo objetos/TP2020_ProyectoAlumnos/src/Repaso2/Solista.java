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
public class Solista {
    private String nombreA;
    private String instrumento;
    private int cantTemas;
    
    public Solista (String unNomA, String unInstrumento, int unaCantTemas){
        setNombreArtista(unNomA);
        setInstrumento(unInstrumento);
        setCantidadTemas(unaCantTemas);
    }
    
    public String getNombreArtista(){
        return nombreA;
    }
    
    public void setNombreArtista(String unNomA){
        nombreA= unNomA;    
    }
    
    public String getInstrumento(){
        return instrumento;
    }
    
    public void setInstrumento(String unInstrumento){
        instrumento = unInstrumento;    
    }
    
    public int getCantidadTemas(){
        return cantTemas;
    }
    
    public void setCantidadTemas(int unaCantT){
        cantTemas = unaCantT;    
    }

}
