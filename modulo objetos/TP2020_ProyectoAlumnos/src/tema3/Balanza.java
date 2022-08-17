/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author Robledo
 */
public class Balanza {
    private double monto;
    private int cant;
    private String resumen;
 
   
    public Balanza(){     
    }
    
    public void iniciarCompra(){
        monto = 0;
        cant = 0;
        resumen = "";
    }
    
    public void registrarProducto(double unPrecioKg, Producto UnProducto){
        cant++;
        monto = monto + (unPrecioKg* UnProducto.getPesoEnKg());
        resumen = resumen + UnProducto.getDescripcion() + " " +(unPrecioKg *UnProducto.getPesoEnKg()) + " pesos " + " - ";
    }
    
    public double devolverMontoAPagar(){ 
        return monto;     
    }
    
    public String devolverResumenDeCompra(){  
        return resumen + " Total a pagar por la compra de " + cant + " productos: ";
    }     
}
 