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
public class Fecha {
    private String ciudad;
    private String dia;

    public Fecha(String unaCiudad, String unDia){
        setCiudad(unaCiudad);
        setDia(unDia);    
    }
    
    public String getCiudad(){
        return ciudad;       
    }
  
    public void setCiudad(String unaCiudad){
        ciudad = unaCiudad;
    }
    
    public String getDia(){
        return dia;       
    }
  
    public void setDia(String unDia){
        dia = unDia;
    }
    
}
