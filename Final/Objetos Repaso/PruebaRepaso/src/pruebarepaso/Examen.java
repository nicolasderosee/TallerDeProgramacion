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
public class Examen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Catalogo c = new Catalogo ();  
        String o1 = "", o2 = "Mamarracho",o3 = "",o4 = "",o5 = "",o6 = "";
        
        Artista a1 = new Artista("AA","A");
        c.agregarArtista(a1);
        a1.agregarObra(o1);
        a1.agregarObra(o2);
        
        Artista a2 = new Artista("BB","escultura");
        c.agregarArtista(a2);
        a2.agregarObra(o3);
        a2.agregarObra(o4);
        
        Artista a3 = new Artista("CC","escultura");
        c.agregarArtista(a3);
        a3.agregarObra(o5);
        a3.agregarObra(o6);
        
        System.out.println("nombre del artista: " + c.obtenerArtista("Mamarracho").getNombre());
        System.out.println("cantidad de artistas que se destacan en escultura: " + c.obtenerCantArtistas("escultura"));
        
    }
    
}
