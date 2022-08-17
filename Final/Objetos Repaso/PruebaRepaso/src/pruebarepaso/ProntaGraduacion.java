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
public class ProntaGraduacion extends Premiacion{
    
    public ProntaGraduacion(int N) {
        super(N);
    }

    @Override
    public Postulado otorgarPremio() {
       double minAños = 999; Postulado P,postuladoPremiado = null;
       for (int i=0; i<this.cantidadPostulados(); i++){
           P = this.obtenerPostulado(i);
           int cantAños = P.getEgreso() - P.getIngreso();
           if(cantAños < minAños) {
                minAños = cantAños;
                postuladoPremiado = P; 
           }   
        }
    return postuladoPremiado;
    }
    
}
