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
public abstract class MedidorBase {
    private final int DF = 7;
    private double vecDias [];

    public MedidorBase() {
        this.vecDias = new double[this.DF];
        for (int i=0; i<this.DF; i++)
            vecDias[i] = 9999;
    }
    
    public double obtenerValor(int D){
        return this.vecDias[D];
    }
    
    public void registrarValor(int D, double valor){
        this.vecDias[D] = valor;
    }
   
}
