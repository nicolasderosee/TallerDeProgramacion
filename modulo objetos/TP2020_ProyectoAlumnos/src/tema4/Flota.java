/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Robledo
 */
public class Flota {
    private int cantidadMicros = 0; //  DL
    private int cantTotalMicros = 15;// DF
    private Micro [] vecMicros = new Micro [cantTotalMicros];
    
    public Flota(){
     
    }
   
    private int getCantidadMicros(){ //dimL 
        return cantidadMicros;
    }
   
    public boolean estaCompleta(){
        boolean ok = false;
        if(this.getCantidadMicros() == cantTotalMicros)
            ok = true; //devuelve true si la flota esta completa 
     return ok;
    }
    
    public void agregarMicro(Micro unMicro){
        vecMicros[this.getCantidadMicros()] = unMicro;
        this.cantidadMicros++;
    }
    
    public boolean eliminarMicro(String unaPat){
        boolean ok = false;
        int i = 0;
        int j;
        while((i<this.getCantidadMicros())&&(!vecMicros[i].getPatente().equals(unaPat))){
            i++;
        }
        if(i<this.getCantidadMicros()){
            for (j=i; j<this.getCantidadMicros(); j++){ 
                vecMicros[j] = vecMicros[j+1]; //hago el corrimiento y elimino el elemento 
                ok = true;
            }
             cantidadMicros--; //disminuyo la dimL porque elimine un elemento del vector 
        }
     return ok;     
    }
    
    public Micro buscarMicroPorPatente(String unaPat){
        Micro m = null;
        int i = 0;
        while((i<this.getCantidadMicros())&&(!vecMicros[i].getPatente().equals(unaPat))){
            i++;
        }
        if(i<this.getCantidadMicros())
            m = vecMicros[i];
     return m;   
    }
    
    public Micro buscarMicroPorDestino (String unDest){
        Micro m = null;
        int i = 0;
        while((i<this.getCantidadMicros())&&(!vecMicros[i].getDestino().equals(unDest))){
            i++;
        }
        if(i<this.getCantidadMicros())
            m = vecMicros[i];
     return m; 
    }
    
}
