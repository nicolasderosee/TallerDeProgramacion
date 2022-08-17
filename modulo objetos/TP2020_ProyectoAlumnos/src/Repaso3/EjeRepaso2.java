/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso3;
import PaqueteLectura.Lector;

/**
 *
 * @author Robledo
 */
public class EjeRepaso2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Electoral E = new Electoral(203,5);
        Referendum R = new Referendum(203);
        System.out.print("Ingrese su numero de dni: ");
        int dni = Lector.leerInt();
        while(dni!= 0){
            System.out.print("Ingrese el numero de lista que quiera votar:");
            int N = Lector.leerInt();
            if(E.validarNumeroDeLista(N))
                E.validarPorLista(N);
            else 
                E.votarEnBlanco();
            System.out.println("su voto ha sido registrado con exito");
            System.out.println("Ingrese un numero para votar la aprobacion de la ley: ");
            int M = Lector.leerInt();
            if(M>0)
                R.votarAFavor();
            else
                if(M<0)
                    R.votarEnContra();
                else
                    R.votarEnBlanco();
            System.out.println("su voto ha sido registrado con exito");
            
            System.out.print("Ingrese su numero de dni: ");
            dni = Lector.leerInt();    
        }
        
        System.out.println("Numero de lista ganadora: " + E.calcularGanador());
        double porcentajeUrnaE = E.devolverVotosPorLista(E.calcularGanador())*100 / E.calcularTotalVotos();
        System.out.println("Porcentaje de votos de la lista ganadora: " + porcentajeUrnaE);
        
        double porcentajeUrnaR = 0;
        System.out.println("Resultado de los votos para la aprobación de la ley = ");
        if(R.calcularGanador() == -1){
           System.out.print("empate");
           porcentajeUrnaR = R.getContVAFavor()*100/R.calcularTotalVotos();
        }
        else 
            if(R.calcularGanador() == 0){
               System.out.print("en contra");
               porcentajeUrnaR = R.getContVEnContra()*100/R.calcularTotalVotos();
           }
            else
                if(R.calcularGanador() == 1){
                   System.out.println("a favor");
                   porcentajeUrnaR = R.getContVAFavor()*100/R.calcularTotalVotos();
               }  
        System.out.println("Porcentaje de votos del resultado de votos para la aprobación de la ley: " + porcentajeUrnaR);    
    }   
}
