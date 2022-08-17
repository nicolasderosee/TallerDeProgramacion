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
public class Estadistica {
    private int cantVehiculos, cantMinutos, vehiculosSoloConductor;

    public Estadistica() {
        this.cantVehiculos = 0;
        this.cantMinutos = 0;
        this.vehiculosSoloConductor = 0;
    }

    public int getCantVehiculos() {
        return cantVehiculos;
    }

    public int getCantMinutos() {
        return cantMinutos;
    }

    public int getVehiculosSoloConductor() {
        return vehiculosSoloConductor;
    }
    
    public void registrarAuto(int mins, boolean viajasolo){
        this.cantVehiculos++;
        if(viajasolo)
            this.vehiculosSoloConductor++;
        this.cantMinutos = this.cantMinutos + mins;
    }
    
    public int getVehiculosAcompañados(){
        return this.getCantVehiculos() - this.getVehiculosSoloConductor(); //la dif entre la cant total de vehiculos y la cant de vehiculos donde solo viaja el conductor = cant de vehiculos con cunductores que viajan acompañados
    }
    
}
