/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebarepaso;

/**
 *
 * @author Nicolas
 */
public class MejorGraduado extends Premiacion {
    
    public MejorGraduado(int N) {
        super(N);
    }

    @Override
    public Postulado otorgarPremio() {
       double maxProm = -1; Postulado P,postuladoPremiado = null;
       for (int i=0; i<this.cantidadPostulados(); i++){
           P = this.obtenerPostulado(i);
           if(P.getPromedio() > maxProm) {
                maxProm = P.getPromedio();
                postuladoPremiado = P; 
           }   
        }
    return postuladoPremiado;
    }
    
}
