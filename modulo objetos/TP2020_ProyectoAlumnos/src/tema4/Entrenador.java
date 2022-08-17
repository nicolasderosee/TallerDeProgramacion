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
public class Entrenador {
    private String nom;
    private double sueldoB;
    private int cantCampGanados;
    
    public Entrenador(){
        
    }
    
    public Entrenador (String unNom, double unSueldoB, int unaCant){
        nom = unNom;
        sueldoB = unSueldoB;
        cantCampGanados = unaCant;
    }
    public String getNombre(){
        return nom;
    }
    
    public void setNombre(String unNom){
        nom = unNom;
    }
    
    public double getSueldoBasico(){
        return sueldoB;
    }
    
    public void setSueldoBasico(double unSueldoB){
        sueldoB = unSueldoB;
    }
    
    public int getCantCampeonatosGandados(){
        return cantCampGanados;
    }
    
    public void setCantCampeonatosGanados(int UnaCant){
        cantCampGanados = UnaCant;    
    }
    
    public double CalcularSueldoACobrar(){
        double sueldoC;
        if((cantCampGanados >= 1)&& (cantCampGanados<=4))
            sueldoC = sueldoB + 5000;
        else 
            if((cantCampGanados >= 5)&& (cantCampGanados<=10))
                sueldoC = sueldoB + 30000;
            else 
                if(cantCampGanados>10)
                    sueldoC = sueldoB + 50000; 
                else
                    sueldoC = sueldoB;
        return sueldoC;
    }   
}
