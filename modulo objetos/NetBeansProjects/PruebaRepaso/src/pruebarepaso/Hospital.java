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
public class Hospital {
    private String nombre, direccion;
    private Cama [] vecCamas; //instancio el vector de camas

    public Hospital(String nom, String dir) {
        this.nombre = nom;
        this.direccion = dir;
        vecCamas = new Cama[100]; //creo el vector de 100 camas 
        for(int i=0; i<100; i++){
            vecCamas[i] = new Cama(); //a cada pos del vector le cargo una cama
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
     
    
    public void ingresarUnPaciente(Paciente P, int nroCama){ //ingresa un paciente en el nro de cama -1 recibido
        vecCamas[nroCama-1].setP(P);
    }
   
    public void altaPaciente(int dni){ // debe eliminar al paciente con un dni ingresado que seguro existe 
        int i = 0; boolean buscar = true;
        while(buscar){
            if(vecCamas[i].getOcupada()&& vecCamas[i].getP().getDNI() == dni)
                buscar = false;  //lo encontre 
            else 
                i++; //si no lo encontre sigo recorriendo
        }
        vecCamas[i].setP(null); //elimina el paciente, liberando asi la cama que ocupa
        vecCamas[i].setDiasOcupada(0); 
    }
    
    public void darAltaPaciente(int nro){ //extra = dar de alta a un paciente recibiendo el nro de cama q seguro existe
        vecCamas[nro-1].setP(null);
        vecCamas[nro-1].setDiasOcupada(0);
    }
    
    public void incrementarDias(){ //incrementa en 1 la cantidad de dias de ocupacion de todas las camas que esten ocupadas
        for(int i=0; i<100; i++){
            if(vecCamas[i].getOcupada())
                vecCamas[i].incrementarDias(1);
        }
    }
    
    public void moverPaciente(int camaX, int camaY){ // extra = mueve a un paciente de una cama x ocupada a otra y desocupada 
        vecCamas[camaY - 1].setP(vecCamas[camaX - 1].getP()); //al paciente de la cama Y (no tiene) le asigno el de la cama X 
        vecCamas[camaY - 1].setDiasOcupada(vecCamas[camaX - 1].getDiasOcupada());
        vecCamas[camaX - 1].setP(null); //pone al paciente de la cama x ocupada en null para desocuparla 
        vecCamas[camaX - 1].setDiasOcupada(0);
    }
    
    public int cantidadPacientesInternados(){ //recorre sumando la cantidad de pacintes que estan internados
        int c = 0;
        for(int i = 0; i< 100; i++){
            if(vecCamas[i].getOcupada())
                c++;
        }
      return c;
    }
    
    public int catidadCamasLibres(){ //recorre contando la cant de camas que no estan ocupadas por pacientes 
        int c = 0;
        for(int i = 0; i<100; i++){
            if(!vecCamas[i].getOcupada()) //si la cama es distinto de true o sea si no esta ocupada entonces cuento
                c++;
        }
     return c;
    }
    
    public int cantidadPacientesInternadosMasDias(int D){ //recorre contando la cant de P con mas de D dias de internacion 
        int c = 0;
        for(int i = 0; i<100; i++){
            if (vecCamas[i].getOcupada() && vecCamas[i].getDiasOcupada() > D) //si la cama esta ocupada y los dias de ocupacion son mayores a d entonces sumo 
                c++;
        }
     return c;
    }
    
}
