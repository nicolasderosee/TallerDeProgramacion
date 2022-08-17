/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebarepaso;

/**
 *
 * @author Robledo
 */
public class Persona {
    private String nombre;
    private int DNI;
    private int edad;
    
    public Persona(String unNombre, int unDNI, int unaEdad){
        setNombre(unNombre);
        setDNI(unDNI);
        setEdad(unaEdad);
    }
    
    public String getNombre(){
        return nombre;
    }
    
    private void setNombre(String unNombre){
        nombre = unNombre;
    }
    
    public int getDNI(){
        return DNI;
    }
    
    private void setDNI(int unDNI){
        DNI = unDNI;
    }
    
    public int getEdad(){
        return edad;
    }
    
    private void setEdad(int unaEdad){
        edad = unaEdad;
    }
    
    @Override
    public String toString(){
       String aux = "Mi nombre es " + getNombre() + "," + " mi dni es " + getDNI() + " y tengo " + getEdad();
     return aux;
    }
    
}

