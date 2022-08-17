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
public class Discografica {
    private String nombreD;
    private String ciudadR;
    private String nomDueño;
    private int DF = 50;
    private int DLBanda;
    private int DLSolista;
    private Banda [] vecBandas; //vector de bandas 
    private Solista [] vecSolistas; //vector de Solistas 
    
     public Discografica (String unNombreD, String unaCiudadR, String unNomDueño){
        setNombreD(unNombreD);
        setCiudadR(unaCiudadR);
        setNomDueño(unNomDueño);
        this.DLSolista = 0;
        this.DLBanda = 0;
        vecSolistas = new Solista [this.DF];
        vecBandas = new Banda [this.DF];
    }
    
    public String getNombreD() {
        return nombreD;
    }

    public String getCiudadR() {
        return ciudadR;
    }

    public String getNomDueño() {
        return nomDueño;
    }

    public int getDLBanda() { //devuelve la cantidad de bandas representadas por una discografica 
        return DLBanda;
    }

    public int getDLSolista() {
        return DLSolista;
    }
   
    public void setNombreD(String nombreD) {
        this.nombreD = nombreD;
    }

    public void setCiudadR(String ciudadR) {
        this.ciudadR = ciudadR;
    }

    public void setNomDueño(String nomDueño) {
        this.nomDueño = nomDueño;
    }
    
    public void agregarSolista(Solista unSolista){
        if(this.getDLSolista()<this.DF){
            vecSolistas[this.getDLSolista()] = unSolista;
            this.DLSolista++;      
        }
    }
    
    public void agregarBanda(Banda unaBanda){
        if(this.getDLBanda()<this.DF){
            vecBandas[this.getDLBanda()] = unaBanda;
            this.DLBanda++;      
        }
    }
     
    public int calcularCantArtistasInstrumento(String unInst){ //calcula la cantidad de artistas que tocan el mismo inst
        int cant = 0;
        for(int i=0; i<this.getDLSolista(); i++)
            if(vecSolistas[i].getInstrumento().equals(unInst))
                cant++;
     return cant;                                                                             
    }
    
    public String calcularBandaMayor(){ // calcula el nombre de la banda con mas integrantes 
        int maxIntegrantes = -1; String nomBandaMax = "";
        for(int i=0; i<this.getDLBanda(); i++){
            if(vecBandas[i].getCantIntegrantes()>maxIntegrantes){
                maxIntegrantes = vecBandas[i].getCantIntegrantes();
                nomBandaMax = vecBandas[i].getNomBanda();
            }                                                                        
        }
     return nomBandaMax;
    }
    
     public int mismaCiudad(){ //calcula la cantidad de bandas que se formaron en la misma ciudad que la discografica
        int cantBandas = 0;
        for(int i=0; i<this.getDLBanda(); i++)
            if(vecBandas[i].getCiudadF().equals(this.getCiudadR()))
                cantBandas++;
     return cantBandas;                                                                             
    }
       
}
