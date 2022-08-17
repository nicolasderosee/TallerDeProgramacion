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
public abstract class Premiacion {
    private Postulado [] postulados;
    private final int DF;
    private int DL;

    public Premiacion(int N) {
        this.DF = N;
        this.DL = 0;
        this.postulados = new Postulado[this.DF];
    }
    
    public void agregarPostulante(Postulado P){
       if(this.DL < this.DF){
           this.postulados[this.DL] = P;
           DL++;
       }
    }
    
    public int cantidadPostulados(){
        return this.DL;
    }
    
    public Postulado obtenerPostulado(int i){
        return this.postulados[i];
    }
    
    public abstract Postulado otorgarPremio();
    
}
