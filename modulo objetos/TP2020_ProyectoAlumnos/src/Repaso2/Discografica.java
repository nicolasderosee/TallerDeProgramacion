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
public class Discografica {
    private String nombreDisc;
    private String ciudadR;
    private String nombreDueño;
    private Solista [] vecSolistas;
    private Banda [] vecBandas;
    private int DF;
    private int DLSolista;
    private int DLBanda;
     
    public Discografica(String unNomDisc, String unaCiudadR, String unNomDueño){
        DF = 50;
        DLSolista = 0;
        DLBanda = 0;
        setNombreDiscografica(unNomDisc);
        setCiudadResidencia(unaCiudadR);  
        setNombreDueño(unNomDueño);
        vecSolistas = new Solista [DF];
        vecBandas = new Banda [DF];   
    }
    
    public String getNombreDiscografica(){
        return nombreDisc;
    }
    
    public void setNombreDiscografica(String unNomDisc){
        nombreDisc = unNomDisc;    
    }
    
    public String getCiudadResidencia(){
        return ciudadR;
    }
    
    public void setCiudadResidencia(String unaCiudadR){
        ciudadR = unaCiudadR;    
    }
    
    public String getNombreDueño(){
        return nombreDueño;
    }
    
    public void setNombreDueño(String unNomDueño){
        nombreDueño = unNomDueño;    
    }
    
    public int getDLSolista(){
        return DLSolista;
    }
    
    public int getDLBanda(){ //devuelve la cantidad de bandas representadas por una discografica
        return DLBanda;
    }
    
    public int getDF(){
        return DF;
    }
    
    public void agregarSolista(Solista unSolista){
        if(this.getDLSolista()<this.getDF()){
            vecSolistas[this.getDLSolista()] = unSolista;
            DLSolista++;
        }
    }
    
    public void agregarBanda(Banda unaBanda){
        if(this.getDLBanda()<this.getDF()){
            vecBandas[this.getDLBanda()] = unaBanda;
            DLBanda++;
        }
    }
    
    public int cantArtistasInstrumento(String unInst){
        int cant = 0;
        for(int i=0; i<this.getDLSolista(); i++)
            if(vecSolistas[i].getInstrumento().equals(unInst))
                cant++;
     return cant;
    }
    
    public String bandaConMasIntegrantes(){
        int cantMax = -1; String bandaMax = "";
        for(int i=0; i<this.getDLBanda(); i++){
            if(vecBandas[i].getCantidadIntegrantes() > cantMax){
                cantMax = vecBandas[i].getCantidadIntegrantes();
                bandaMax = vecBandas[i].getNombreBanda();
            }
        }
    return bandaMax;  
    }
    
    public int mismaCiudad(){
        int cant = 0;
        for(int i=0; i<this.getDLBanda(); i++)
            if(vecBandas[i].getCiudadFormacion().equals(this.getCiudadResidencia()))
                cant++;
     return cant;
    }
                
     
}
