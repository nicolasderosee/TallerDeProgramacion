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
public class Artista {
    private String nombre;
    private String arte;
    private String [] vecO;
    private int diml;

    public Artista(String nombre, String arte) {
        this.nombre = nombre;
        this.arte = arte;
        this.diml = 0;
        vecO = new String[5]; //creo el vector de obras    
    }

    public String getNombre() {
        return nombre;
    }

    public String getArte() {
        return arte;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setArte(String arte) {
        this.arte = arte;
    }
    
    public void agregarObra(String O){ //agrega una obra al vector de Obras que es un vec de strings 
        if(this.diml<5){
            vecO[this.diml] = O;
            this.diml++; //aumento la dimL del vector de obras 
        }
    }
    
    public boolean obtenerObra(String O){
    int num = 0; boolean ok = false;
        while((num<this.diml) && (!vecO[num].equals(O))) //si num es menor a diml y la obra pos en num es distinta de una obra ingresada sigo recorriendo 
                num++;
        if(num<this.diml) //si num es menor a diml quiere decir que encontre la obra ingresada 
            ok = true;
     return ok; 
    }
}
