/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso3;

/**
 *
 * @author Robledo
 */
public class Hospital {
   private String nombre;
   private String direccion;
   private int DF;
   private Cama [] vecCamas; //vector de camas, cada cama tiene info de la cama y un paciente
   private int cantPacientes;

    public Hospital(String nombre, String direccion) {
        this.DF = 100;
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.cantPacientes = 0; // cantidad de pacientes internados 
        vecCamas = new Cama [this.DF]; // creo el vector de camas 
        for(int i=0; i<this.DF; i++){
             vecCamas[i] = new Cama(); // a cada pos del vector le asigno una nueva cama 
        }      
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void ingresarPaciente(Paciente P, int nroCama){ //registra un paciente en el nro de cama recibido
        vecCamas[nroCama].registrarPaciente(P, nroCama);
        this.cantPacientes++;
    }
    
    public void liberarCama(int unDNI){ //dar de alta a un paciente liberando su cama
        int i = 0; 
        while((i<this.DF) && (vecCamas[i].getP().getDni()!= unDNI)){
            i++;
        }
        if(i<this.DF){
            vecCamas[i].setP(null);
            System.out.println("El paciente ha sido dado de alta");
        }
    }
    
    public void incrementar(){ // incrementa en 1 la cantidad de dias de ocupacion de todas las camas que esten ocupadas
        for(int i=0; i<this.DF; i++){
            vecCamas[i].incrementarCantDiasOcupada();         
        }
    }
    
    public int getCantPacientesInternados(){  //devuelve la cantidad de pacientes internados 
        return this.cantPacientes;
    }
}
