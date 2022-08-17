/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebarepaso;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author Robledo
 */
public class Examen2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Movilidad m = new Movilidad();
        for(int i=0; i<10; i++){
            int nroC = GeneradorAleatorio.generarInt(8) + 1;
            int nroM = GeneradorAleatorio.generarInt(5) + 1;
            int mins = GeneradorAleatorio.generarInt(120) + 1;
            boolean solo = GeneradorAleatorio.generarBoolean();
            m.registrarAuto(nroC, nroM, mins, solo);
        }
        System.out.println("promdio de minutos acumulados entre todos los controles y motivos: " + m.promedioMinutos());
        System.out.println("Control mas concurrido:" + m.controlMasConcurrido());
    }
    
    
}
