/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso;
import PaqueteLectura.Lector;

/**
 *
 * @author Robledo
 */
public class EjeAd2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Electoral E = new Electoral(203,5);
       Referendum R = new Referendum(203);
       System.out.print("Ingrese su dni:");
       int dni = Lector.leerInt();
       while (dni != 0){
            System.out.print("Ingrese un numero de lista que quiera votar: ");
            int N = Lector.leerInt();
            if (E.validarNroDeLista(N))
                 E.votarPorLista(N);
            else
                 E.votarEnBlanco();
            System.out.print("Ingrese un numero: ");
            int  M = Lector.leerInt();
            if(M>0)
                R.votarAFavor();
            else
                if(M<0)
                    R.votarEnContra();
                else
                    R.votarEnBlanco();
            System.out.print("Ingrese su dni:");
            dni = Lector.leerInt(); 
        }
       System.out.println("Numero de lista ganadora: " + E.calcularGanador());
       double porcentajeUrnaE = E.devolverVotosPorLista(E.calcularGanador()) / E.calcularTotalVotos();
       System.out.println("Porcentaje de votos de la lista ganadora: " + porcentajeUrnaE);
       
       double porcentajeUrnaR = 0;
       if(R.calcularGanador() == -1){
           System.out.println("Resultado de los votos para la aprobación de la ley = empate");
           porcentajeUrnaR = R.getContadorAFavor()/R.calcularTotalVotos();
       }
       else 
           if(R.calcularGanador() == 0){
               System.out.println("Resultado de los votos para la aprobación de la ley = En contra");
                porcentajeUrnaR = R.getContadorEnContra()/R.calcularTotalVotos();
           }
           else
               if(R.calcularGanador() == 1){
                   System.out.println("Resultado de los votos para la aprobación de la ley = A Favor");
                   porcentajeUrnaR = R.getContadorAFavor()/R.calcularTotalVotos();
               }  
       
       System.out.println("Porcentaje de votos del resultado de votos para la aprobación de la ley: " + porcentajeUrnaR);
    }         
}
