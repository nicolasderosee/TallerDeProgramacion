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
public class MedidorAvanzado extends MedidorBase {

    public MedidorAvanzado() {
    }
    
    public double calcularTemperaturaProm(){
        double tempTotal =0; 
        for(int i=0; i<7; i++)
            tempTotal = tempTotal + this.obtenerValor(i);
    return tempTotal/7;
    }
}
