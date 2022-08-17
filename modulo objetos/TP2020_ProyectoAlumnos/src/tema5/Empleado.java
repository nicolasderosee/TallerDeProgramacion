/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema5;

/**
 *
 * @author Robledo
 */
public abstract class Empleado {
    private String nombre;
    private double sueldoB;
    
    public Empleado(String unNombre, double unSueldoB){
        setNombre(unNombre);
        setSueldoBasico(unSueldoB);
    }
    
    public String getNombre(){
        return nombre;       
    }
     
    public void setNombre(String unNombre){
        nombre = unNombre;       
    }
    
    public double getSueldoBasico(){
        return sueldoB;
    }
    
    public void setSueldoBasico(double unSueldoB){
        sueldoB = unSueldoB;
    }
    
    public abstract double calcularSueldoACobrar();
    
    public String toString(){
        String aux = "Nombre: " + getNombre() + " Sueldo a cobrar: " + this.calcularSueldoACobrar();
     return aux;
    }
    
}
