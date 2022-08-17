/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebarepaso;

/**
 *
 * @author Nicolas
 */
public class Examen4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProntaGraduacion PG = new ProntaGraduacion(5);
        MejorGraduado MG = new MejorGraduado(5);
        
        Postulado a1 = new Postulado("AA",7.5,2001,2006);
        Postulado a2 = new Postulado("BB",7.8,2001,2008);
        Postulado a3 = new Postulado("CC",8.0,2004,2008);
        Postulado a4 = new Postulado("DD",5.0,2006,2010);
        
        PG.agregarPostulante(a1);
        PG.agregarPostulante(a2);
        PG.agregarPostulante(a3);
        PG.agregarPostulante(a4);
        
        MG.agregarPostulante(a1);
        MG.agregarPostulante(a2);
        MG.agregarPostulante(a3);
        MG.agregarPostulante(a4);
        
        Postulado ganador1 = PG.otorgarPremio();
        Postulado ganador2 = MG.otorgarPremio();
        
        System.out.println(ganador1.getNombre());
        System.out.println(ganador2.getNombre());
    }
    
}
