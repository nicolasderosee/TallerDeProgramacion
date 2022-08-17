/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author Robledo
 */
public class Circulo {
    private double radio;
    private String colorR;
    private String colorL;
    
    public Circulo(double unRadio, String unColorR, String unColorL){
        radio = unRadio;
        colorR = unColorR;
        colorL = unColorL;
    }
    
    public double getRadio(){
        return radio;
    }
    
    public void setRadio(double unRadio){
        radio = unRadio;
    }
    
    
    public String getColorRelleno(){
        return colorR;
    }
    
    public void setColorRelleno(String unColorR){
        colorR = unColorR;
    }
    
    public String getColorLinea(){
        return colorL;
    }
    
    public void setColorLinea(String unColorL){
        colorL = unColorL;
    }
    
    public double CalcularArea(){ 
       return (Math.PI * (radio*radio)); 
    }
    
    public double CalcularPerimetro(){
        double D = 2*radio;
        return (Math.PI*D);
    }             
}
