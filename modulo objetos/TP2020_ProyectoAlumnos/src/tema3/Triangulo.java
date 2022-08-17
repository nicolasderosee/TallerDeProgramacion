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
public class Triangulo {
    private double lado1;
    private double lado2;
    private double lado3;
    private String colorR;
    private String colorL;
   
       
    public double getLado1(){
        return lado1;
    }
    
    public void setLado1(double unLado1){
        lado1 = unLado1;
    }
    
    public double getLado2(){
        return lado2;
    }
    
    public void setLado2(double unLado2){
        lado2 = unLado2;
    }
    
    public double getLado3(){
        return lado3;
    }
    
    public void setLado3(double unLado3){
        lado3 = unLado3;
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
        double s = (lado1+lado2+lado3)/2;
        double aux = Math.sqrt(s*(s-lado1)*(s-lado2)*(s-lado3)); //para la raiz cuadrada se usa Math.sqrt()
        return aux;   
    }
    
    public double CalcularPerimetro(){
        return lado1+lado2+lado3;
    }
}