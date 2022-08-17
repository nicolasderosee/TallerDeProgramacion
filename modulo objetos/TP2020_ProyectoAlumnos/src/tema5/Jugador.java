/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema5;

/**
 *
 * @author Robledo
 */
public class Jugador extends Empleado {
    private int cantPartidosJugados;
    private int cantGolesAnotados;
    
    public Jugador (int unaCantP, int unaCantG, String unNom, double unSueldoB){
        super(unNom,unSueldoB);
        setCantPartidosJugados(unaCantP);
        setCantGolesAnotados(unaCantG);
    }
    
    public int getCantPartidosJugados(){
        return cantPartidosJugados;
    }
    
    private void setCantPartidosJugados(int UnaCantP){
        cantPartidosJugados = UnaCantP;    
    }
    
    public int getCantGolesAnotados(){
        return cantGolesAnotados;
    }
    
    private void setCantGolesAnotados(int UnaCantG){
        cantGolesAnotados = UnaCantG;    
    }
    
    public double getPromedio(){
      return getCantGolesAnotados() / getCantPartidosJugados(); 
    }
    
    public double calcularSueldoACobrar() {
        double sueldo = super.getSueldoBasico();
        if(this.getPromedio() > 0.5)
            sueldo = sueldo + super.getSueldoBasico();
     return sueldo;
    }
    
}
