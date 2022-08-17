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
public class Catalogo {
    private Artista [] vec; //instancio el vector de artistas
    private int dl;

    public Catalogo() {
        this.dl = 0;
        vec = new Artista[15]; //creo el vector de artistas de dimf 15 
    }
    
    public void agregarArtista(Artista A){ //agrega un artista al catalogo de artistas
        if(this.dl<15){
            vec[this.dl] = A;
            this.dl++;
        }
    }
    
    public Artista obtenerArtista(String O){
        Artista a = null;
        int i = 0;
        while(i<this.dl && !vec[i].obtenerObra(O)){ //si i es menor a dimL y todavia no encontré la obra ingresada sigo recorriendo !vec[i].obtenerObra(O) = si el metodo obtenerObra es distinto de true
            i++;
        }
        if(i<this.dl) //si i es menor a la dimL, quiere decir que encontre dicha obra 
            a = vec[i]; //al objeto a le asigno el objeto pos vec[i]
     return a; //retorno el objeto que tiene dicha obra sino retorna null 
    }
    
    public int obtenerCantArtistas(String arte){
        int cant = 0;
        int i;
       for(i=0; i<this.dl; i++){ //recorro hasta la dimL 
           if (vec[i].getArte().equals(arte)) //si el arte del artista ubicado en i es igual al arte ingresado, aumento la cant
             cant++;
       }
     return cant;   
    }
    
}
