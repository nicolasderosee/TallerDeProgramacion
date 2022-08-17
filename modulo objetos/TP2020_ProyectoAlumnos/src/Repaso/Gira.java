/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso;

/**
 *
 * @author Robledo
 */
public class Gira extends Recital {
    private String nomGira;
    private Fecha [] vecFechas; 
    private int DL;

    public Gira(String unNomBanda, int cantTemas, String unNomGira, int unaCantFechas) {
        super(unNomBanda, cantTemas);
        setNombreGira(unNomGira);
        vecFechas = new Fecha [unaCantFechas];
        DL = 0;
    }
    
    public String NombreGira(){
        return nomGira;       
    }
  
    private void setNombreGira(String unNomGira){
        nomGira= unNomGira;
    }
    
    public void agregarFecha(Fecha unaFecha){
        vecFechas [DL] = unaFecha;
    }
    
}
