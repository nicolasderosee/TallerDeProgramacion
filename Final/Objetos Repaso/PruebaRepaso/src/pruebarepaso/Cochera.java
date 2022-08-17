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
public class Cochera {
    private Sector sectorInferior;
    private Sector sectorSuperior;

    public Cochera(int costoInf, int costoSup) {
       this.sectorInferior = new Sector(costoInf);
       this.sectorSuperior = new Sector(costoSup);
    }
    
    public int ingresarCoche(Coche C){
        int num = 0;
        if(C.getCantHoras()< 24)
            num = this.sectorInferior.ingresarCoche(C);
        else
            num = this.sectorSuperior.ingresarCoche(C);     
    return num;
    }
    
    public String sectorConMasCoches(){
        if(this.sectorInferior.cantidadCoches() > this.sectorSuperior.cantidadCoches())
            return "inferior";
        else return "superior";
    }
    
}
