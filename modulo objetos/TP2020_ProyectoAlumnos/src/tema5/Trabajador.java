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
public class Trabajador extends Persona {
    private String tarea;

    public Trabajador(String unNombre, int unDNI, int unaEdad, String unaTarea) {
        super(unNombre, unDNI, unaEdad);
        setTarea(unaTarea);
    }
    
    public String getTarea(){
        return tarea;
    }
    
    private void setTarea(String unaTarea){
        tarea = unaTarea;
    }
    
    @Override
    public String toString(){
       String aux = super.toString() + " Soy " + getTarea();
     return aux;
    }
    
}
