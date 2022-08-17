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
public class Banda {
    private String nomBanda;
    private String ciudad;
    private int cantIntegrantes;
    
    public Banda(String unNomBanda, String unaCiudadR, int unaCantI){
        setNombre(unNomBanda);
        setCiudad(unaCiudadR);
        setCantIntegrantes(unaCantI);
    }
     
    public String getNombreBanda(){
        return nomBanda;       
    }
  
    public void setNombre(String unNombreBanda){
        nomBanda= unNombreBanda;
    }
    
    public String getCiudad(){
        return ciudad;       
    }
  
    public void setCiudad(String unaCiudad){
        ciudad = unaCiudad;
    }
    
     public int getCantIntegrantes(){
        return cantIntegrantes;       
    }
  
    public void setCantIntegrantes(int unaCant){
        cantIntegrantes = unaCant;
    }
    
    
}
