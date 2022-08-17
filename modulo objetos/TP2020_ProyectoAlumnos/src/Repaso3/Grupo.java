/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso3;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Robledo
 */
public abstract class Grupo {
    private int DL;
    private int DF = 10;
    private Planta [] vecPlantas; //vector de a lo sumo 10 plantas

    public Grupo(){
        this.DL = 0;
        vecPlantas = new Planta[this.DF];
        for(int i=0; i<this.getDL(); i++){
            vecPlantas[i] = null;
        }         
    } 

    public int getDL() { //retorna la cantidad de plantas del grupo 
        return DL;
    }

    public Planta[] getVecPlantas() {
        return vecPlantas;
    }
    
    public void agregarPlanta(Planta P){
        if(this.getDL()<this.DF){
            vecPlantas[this.getDL()] = P;
            this.DL++;
        }
    }
    
    public Planta obtenerPlanta(int unID){ //devuelve la planta que tiene el mismo ID ingresado 
        Planta P = null;
        int i = 0;
        while((i<this.getDL()) && (vecPlantas[i].getID()!= unID))
            i++;
        if(i<this.getDL())
            P = vecPlantas[i];
        return P;   
    }
     
    public void aplicarDosis(double D){
        vecPlantas[this.getDL()].setDosisFarmaco(D);
        int num = GeneradorAleatorio.generarInt(2);
        double a = vecPlantas[this.getDL()].getAlcoloides();
        double suma = a + num;
        vecPlantas[this.getDL()].setAlcoloides(suma);  
    }
    
    public abstract void aplicarMismaDosis(double D);
    
    @Override
    public String toString(){
        String aux = "";
        for (int i = 0; i<this.getDL(); i++)
            aux = "ID: " + vecPlantas[i].getID() + " especie: " + vecPlantas[i].getNombre() +
                    " último nivel de alcoloides: " + vecPlantas[i].getAlcoloides() +
                    " última dosis de farmaco: " + vecPlantas[i].getDosisFarmaco();
     return aux;
    }
    
}