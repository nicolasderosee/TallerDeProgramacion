/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso3;

/**
 *
 * @author Robledo
 */
public class Planta {
    private int ID;
    private String nombre;
    private double alcoloides; //ultima medicion de alcoloides 
    private double dosisFarmaco; //ultima dosis recibida del farmaco

    public Planta(int unID, String unNombre, double unaMedicionAlcoloides) {
        setID(unID);
        setNombre(unNombre);
        setAlcoloides(unaMedicionAlcoloides);
    }
    
    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public double getAlcoloides() {
        return alcoloides;
    }

    public double getDosisFarmaco() {
        return dosisFarmaco;
    }
   
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAlcoloides(double alcoloides) {
        this.alcoloides = alcoloides;
    }

    public void setDosisFarmaco(double dosisFarmaco) {
        this.dosisFarmaco = dosisFarmaco;
    }
    
}
