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
public class Entrenador extends Empleado {
    private int cantCampGanados;
    
    public Entrenador(int unaCant, String unNom, double unSueldoB){
        super(unNom,unSueldoB);
        setCantCampeonatosGanados(unaCant);   
    }
    
    public int getCantCampeonatosGandados(){
        return cantCampGanados;
    }
    
    private void setCantCampeonatosGanados(int UnaCant){
        cantCampGanados = UnaCant;    
    }
    
    public double calcularSueldoACobrar() {
        double sueldoC;
        if((getCantCampeonatosGandados()>= 1)&& (getCantCampeonatosGandados()<= 4))
            sueldoC = super.getSueldoBasico() + 5000;
        else 
            if((getCantCampeonatosGandados()>= 5) && (getCantCampeonatosGandados()<= 10))
                sueldoC = super.getSueldoBasico() + 30000;
            else 
                if(getCantCampeonatosGandados() > 10)
                    sueldoC = super.getSueldoBasico() + 50000; 
                else
                    sueldoC = super.getSueldoBasico();
     return sueldoC;   
    }
    
}
        
    
    

