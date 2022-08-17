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
public class Circulo extends Figura{
    
    private double radio;
    
    public Circulo(double unRadio, String unColorR, String unColorL) {
        super(unColorR, unColorL);
        setRadio(unRadio);
    }
    
    public double getRadio(){
        return radio;       
    }
  
    public void setRadio(double unRadio){
        radio=unRadio;
    }
 
    public double calcularArea() {
       return (Math.PI * (getRadio()*getRadio())); 
    }

    public double calcularPerimetro() {
        double D = 2*getRadio();
     return (Math.PI*D);
    }  
    
    public String toString(){
       String aux = super.toString() +
                    " Radio: " + getRadio();
       return aux;
    }

}
