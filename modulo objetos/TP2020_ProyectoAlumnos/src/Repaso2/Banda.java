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
public class Banda {
    private String nombreB;
    private String ciudad;
    private int cantIntegrantes;
    
    public Banda (String unNombreBanda, String unaCiudad, int unaCantIntegrantes){
       setNombreBanda(unNombreBanda);
       setCiudadFormacion(unaCiudad);
       setCantidadIntegrantes(unaCantIntegrantes);
    }
    
    public String getNombreBanda(){
        return nombreB;
    }
    
    public void setNombreBanda (String unNomB){
        nombreB = unNomB;    
    }
    
    public String getCiudadFormacion(){
        return ciudad;
    }
    
    public void setCiudadFormacion(String unaCiudad){
        ciudad = unaCiudad;    
    }
    
    public int getCantidadIntegrantes(){
        return cantIntegrantes;
    }
    
    public void setCantidadIntegrantes(int unaCant){
        cantIntegrantes = unaCant;    
    }
}
