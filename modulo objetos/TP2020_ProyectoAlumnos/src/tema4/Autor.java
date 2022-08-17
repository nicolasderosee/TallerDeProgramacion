/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Robledo
 */
public class Autor {
    private String nombre;
    private String biografia;
    
    public Autor (String unNombre, String unaBio){
        nombre = unNombre;
        biografia = unaBio;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String unNombre){
        nombre = unNombre;
    }
    
    public String getBiografia(){
        return biografia;
    }
    
    public void setBiografia(String unaBio){
        biografia = unaBio;
    }
    
    
    @Override
    public String toString(){
       return nombre + " " + biografia;
    }

}
