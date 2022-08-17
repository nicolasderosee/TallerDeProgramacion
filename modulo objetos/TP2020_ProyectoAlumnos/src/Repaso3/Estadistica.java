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
public class Estadistica {
    private int cantVehiculos; //cant de  vehiculos que pasan por cada control y motivo 
    private int cantMinutos; 
    private int cantUnConductor; 

    public Estadistica() {
        this.cantVehiculos = 0; 
        this.cantMinutos = 0;
        this.cantUnConductor = 0;
    }
    
    public int getCantVehiculos() { //devuelve la cant de vehiculos que pasan por el control y el motivo
        return cantVehiculos;
    }

    public int getCantMinutos() {
        return cantMinutos;
    }

    public int getCantUnConductor() { //devuelve la cantidad de vehiculos en cada control y motivo donde solo viajan los conductores 
        return cantUnConductor;
    }

    
    public void registrarVehiculo(boolean viajaSolo, int min){ //m = motivo y c = control 
        this.cantVehiculos++;
        if(viajaSolo)
            this.cantUnConductor++;
        this.cantMinutos = this.getCantMinutos() + min;
    }
    
    public int getVehiculosAcompañados(){ //devuelve la cant total de conductores que viajan acompañados de cada control y motivo
        return (this.getCantVehiculos() - this.getCantUnConductor()); // total de vehiculos menos la cantidad de vehiculos en donde viaja solo el conductor 
    }
   
    
} 
   
    

