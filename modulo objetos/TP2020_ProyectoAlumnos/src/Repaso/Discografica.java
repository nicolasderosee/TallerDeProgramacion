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
public class Discografica {
    private String nombre;
    private String ciudad;
    private String nomDueño;
    private int DF = 50;
    private int DLSolista;
    private Solista [] vectorSolista;
    private int DLBanda;
    private Banda [] vectorBanda;
    
    public Discografica(String unNombre, String unaCiudad, String unNomDueño){
        setNombre(unNombre);
        setCiudad(unaCiudad);
        setNombreDueño(unNomDueño);
        DLSolista = 0;
        vectorSolista = new Solista [DF];
        DLBanda = 0;
        vectorBanda = new Banda [DF];
    }
    
    public String getNombre(){
        return nombre;       
    }
  
    public void setNombre(String unNombre){
        nombre = unNombre;
    }
    
    public String getCiudad(){
        return ciudad;       
    }
  
    public void setCiudad(String unaCiudad){
        ciudad = unaCiudad;
    }
    
    public String getNombreDueño(){
        return nomDueño;       
    }
  
    public void setNombreDueño(String unNomDueño){
        nomDueño = unNomDueño;
    }
    
    public int getDLSolista(){ //cantidad de solistas representados por una discográfica 
        return DLSolista;
    }
    
    public int getDLBanda(){ //cantidad de bandas representadas por una discográfica
        return DLBanda;
    }
    
    public void agregarSolista(Solista unSolista){
        vectorSolista[this.getDLSolista()] = unSolista;
        DLSolista++;
    }
    
    public void agregarBanda(Banda unaBanda){
        vectorBanda[this.getDLBanda()] = unaBanda;
        DLBanda++;
    }
    
    public int CantArtistasInstrumento(String unInstrumento){
        int cant = 0;
        for(int i=0; i<this.getDLSolista(); i++)
            if(vectorSolista[i].getInstrumento().equals(unInstrumento))
                cant++;
     return cant;    
    }
    
    public String BandaMayor(){
        int i, mayorCantI = -1; String bandaMayor = "";
        for( i=0; i<this.getDLBanda(); i++)
           if(vectorBanda[i].getCantIntegrantes() > mayorCantI){
               mayorCantI = vectorBanda[i].getCantIntegrantes();
               bandaMayor = vectorBanda[i].getNombreBanda();
           }
     return bandaMayor;                         
    }
    
    public int MismaCiudad(){
        int cant=0, i;
        for(i=0;i<this.getDLBanda();i++)
            if(vectorBanda[i].getCiudad().equals(this.getCiudad()))
                cant++;
        return cant;
    }
    
}
