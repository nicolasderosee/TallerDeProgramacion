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
public class EjeRepaso4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneradorAleatorio.iniciar();
        Sistema S = new Sistema();
        int numC, numM, mins;
        boolean solo;
        for(int i =0; i < 10; i++){
             numC = GeneradorAleatorio.generarInt(8) + 1; //genera un nro de 0 a 7 numeros y luego le suma 1 
             numM = GeneradorAleatorio.generarInt(5) + 1;
             mins = GeneradorAleatorio.generarInt(120);
             solo = GeneradorAleatorio.generarBoolean();
             S.recibirVehiculo(numC, numM, solo, mins);
        }
        
        System.out.println("Promedio de minutos acumulados: " + S.devolverPromedio());
        System.out.println("Numero de control por el cual pasaron más vehiculos: " + S.masVehiculos());
        System.out.println("Cantidad total de conductores acompaádos: " + S.conductoresAcompañados());
        System.out.println("Motivo y control con menos cantidad de vehiculos: " + S.devolverMotivoYControl());
     
    }
    
}
