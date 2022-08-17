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
public class Sistema {
    private int DFF, DFC; // 8 controles y 5 motivos 
    private Estadistica [][] tabla; //declaro la matriz que es de tipo estadistica 
   
    public Sistema() {
        this.DFF = 8;
        this.DFC = 5;
        tabla = new Estadistica [this.DFF][this.DFC]; //creo la matriz de estadisticas de 8(filas = controles) x 5 col = motivos
         for(int f = 0; f < this.DFF; f++){
            for(int c =0; c < this.DFC; c++) 
                tabla [f][c] = new Estadistica(); //cargo cada elemento de la matriz con una nueva estadistica.
        }
    }
    
    
    public void recibirVehiculo(int c, int m, boolean viajaSolo, int min){ //m = motivo y c = control 
        this.tabla[c-1][m-1].registrarVehiculo(viajaSolo, min); //si recibe el motivo 5 lo guarda en la pos 5 - 1 = 4 de la col de motivos
    }

    public double devolverPromedio(){ //recorre toda la matriz sumando todos los minutos de cada control y motivo
        double sum = 0;
        for(int f = 0; f < DFF; f++)
            for(int c =0; c < DFC; c++) 
                sum = sum + tabla[f][c].getCantMinutos();
     return sum/1440.0;    
    }
    
    public double masVehiculos(){ //recorre calculando el control por el que pasaron mas vehiculos 
       int maxVehiculos = -1, cmax = 0;
        for(int f = 0; f < DFF; f++){
            for(int c =0; c < DFC; c++) 
                if(tabla[f][c].getCantVehiculos() > maxVehiculos){
                    maxVehiculos = tabla[f][c].getCantVehiculos();
                    cmax = c;
                }
        }
     return cmax + 1; 
    }
    
    
    public int conductoresAcompañados(){ //recorre toda la matriz sumando todos los vehiculos con conductores acompañados de cada control y motivo
        int cant = 0;
        for(int f = 0; f < DFF; f++){
            for(int c =0; c < DFC; c++){
                cant = cant + tabla[f][c].getVehiculosAcompañados();
            }
        }
     return cant;    
    }
    
    public String devolverMotivoYControl(){ //devuelve un string (motivo y nro de control) donde pasaron menos conductores solos (sin acompañantes) 
        int motivo = 0, control = 0;
        for(int f = 0; f < DFF; f++){
            for(int c =0; c < DFC; c++){
                if(tabla[f][c].getCantUnConductor()< tabla[motivo][control].getCantUnConductor())
                    motivo = f; control = c;
            }
        }
     return "Motivo: " + motivo + "Y control: " + control;         
    }
}

