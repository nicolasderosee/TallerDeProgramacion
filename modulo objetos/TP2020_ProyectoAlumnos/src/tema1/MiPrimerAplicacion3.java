/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;
import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Robledo
 */
public class MiPrimerAplicacion3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneradorAleatorio.iniciar();
      
        int contador = 0, cuantos;
        int suma = 0, valor;
       
        cuantos = Lector.leerInt();
        for(int i = 1 ; i <= cuantos ; i++) {
           System.out.println(i);
           valor = GeneradorAleatorio.generarInt(100);//valores de 0 a 100
           suma = suma + valor;
           contador = contador + 1;
        }
        
        System.out.println("La cantidad de numeros elegidos es " + contador);
        System.out.println("El promedio de los numero al azar es " + (double)(suma/contador));
    }
}
  