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
public class MiPrimerAplicacion2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneradorAleatorio.iniciar();
        int contador = 0;
        int suma = 0, valor;
       
        valor = GeneradorAleatorio.generarInt(100);//valores de 0 a 100
        while (valor != 0){
           if(valor % 2 == 0){
             suma = suma + valor;
             contador = contador + 1;
           }
           else{
               System.out.println("IMPAR");
           }
           valor = GeneradorAleatorio.generarInt(100);
        }
        
        System.out.println("La cantidad de numeros elegidos es " + contador);
        System.out.println("El promedio de los numero al azar es " + (double)(suma/contador));
    }
    
}
