/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebarepaso;

/**
 *
 * @author Robledo
 */
public abstract class Grupo {
    private int DF;
    private int DL;
    private Paciente2 [] vecPacientes; //DECLARO EL VECTOR DE PACIENTES 

    public Grupo() {
        this.DF = 10;
        this.DL = 0;
        vecPacientes = new Paciente2 [this.DF]; //CREO EL VECTOR DE 10 ELEMENTOS
    }

    public int getCandidadDePacientes() { //DEVUELVE LA CANT DE PACIENTES 
        return DL;
    }
    
    public void agregarPaciente(Paciente2 p){
        if(this.DL<this.DF){
            vecPacientes[this.DL] = p;
            this.DL++;
        }
    }
    
    public Paciente2 obtenerPaciente(int unID){ //obtiene un paciente dado un ID 
        return vecPacientes[unID - 1];
    }
    
    /**
    public Paciente2 obtenerPaciente(int unID){ //obtiene un paciente dado un ID 
        int i = 0;
        while(vecPacientes[i].getID() != unID)
            i++;
     return vecPacientes[i];
    }
     * @param D
    */
    
    public abstract void aplicarDosis(double D);
    
    @Override
    public String toString(){
        String aux = " ";
        for(int i = 0; i<this.DL; i++){
            aux = aux + "ID " + (i+1) + ": " + vecPacientes[i].getNombre() + vecPacientes[i].getGlucosa()
                    + vecPacientes[i].getDosis();
        }
     return aux;
    }
    
    
    
    
    

}






