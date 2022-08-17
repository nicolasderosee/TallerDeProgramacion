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
public class Movilidad {
    private int DFF , DFC;
    private Estadistica [][] vecEstadisticas; //declaro el vector

    public Movilidad() {
        this.DFF = 8; //controles 
        this.DFC = 5; //motivos
        vecEstadisticas = new Estadistica[this.DFF][this.DFC]; //creo la matriz de 8x5 de estadisticas
        for(int f=0; f<DFF; f++){
            for(int c=0; c<DFC; c++)
                vecEstadisticas[f][c] = new Estadistica(); //a cada pos de la matriz le cargo una estadistica 
        }
    }
    
    public void registrarAuto(int m, int c, int mins, boolean viajaSolo){ //registra los datos de un vehiculo 
        vecEstadisticas[m-1][c-1].registrarAuto(mins, viajaSolo);
    }
    
    public double promedioMinutos(){
        double sum = 0;
        for(int f=0; f<DFF; f++){
            for(int c=0; c<DFC; c++){
                sum = sum + vecEstadisticas[f][c].getCantMinutos();
            }
        }
     return sum/1444.5;
    }
    
    
    public int controlMasConcurrido(){ //devuelve el nro de control por el que pasaron mas vehiculos. recorro por fila
        int maxControl = 0, maxVehiculos = -1, v;
        for(int f=0; f<DFF; f++){
            v = 0;
            for(int c=0; c<DFC; c++){
                v = v + vecEstadisticas[f][c].getCantVehiculos();
            }
            if(v > maxVehiculos){
                maxVehiculos = v;
                maxControl = f;
            }
        }
     return maxControl + 1;  
    }
    
    public int conductoresAcompañados(){ //devuelve la cant de conductores que viajan acompañados e/ todos los controles y motivos 
        int cant = 0;
        for(int f = 0; f<DFF; f++){ //recorre toda la matriz sumando la cant total de conductores acompañados
            for(int c = 0; c<DFC; c++){
                cant = cant + vecEstadisticas[f][c].getVehiculosAcompañados();
            }
        }
     return cant;
    }
    
    public String motivoYControlConMenosVehiculosSolos(){ //devuelve un string informando el motivo y el control donde pasaron menos vehiculos solos
        int motivo = 0, control = 0;
        for(int f=0; f<DFF; f++){
            for(int c=0; c<DFC; c++){
                if(vecEstadisticas[f][c].getVehiculosSoloConductor() < 
                        vecEstadisticas[control][motivo].getVehiculosSoloConductor()){
                    control = f;
                    motivo = c;
                }
            }
        }
     return "motivo " + motivo + " y control " + control;  
    }
    
       public int motivoMasConcurrido(){ //devuelve el nro de motivo por el que pasaron mas vehiculos. recorro por columna
        int maxMotivo = 0, maxVehiculos = -1, v;
        for(int c=0; c<DFC; c++){
            v = 0;
            for(int f=0; f<DFF; f++){
                v = v + vecEstadisticas[f][c].getCantVehiculos();
            }
            if(v > maxVehiculos){
                maxVehiculos = v;
                maxMotivo = c;
            }
        }
     return maxMotivo + 1;  
    }
    
    
}
