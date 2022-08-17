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
public class Evento extends Recital{
    private String motivo;
    private String nomContratista;
    private String dia;

    public Evento(String unNomBanda, int cantTemas, String unMotivo, String unContratista, String unDia) {
        super(unNomBanda, cantTemas);
        setMotivo(unMotivo);
        setNombreContratista(unContratista);
        setDia(unDia);
    }
    
    public String getMotivo(){
        return motivo;       
    }
  
    private void setMotivo(String unMotivo){
        motivo = unMotivo;
    }
    
    public String getNombreContratista(){
        return nomContratista;       
    }
  
    private void setNombreContratista(String unNombreContratista){
        nomContratista = unNombreContratista;
    }
    
    public String getDia(){
        return dia;       
    }
  
    private void setDia(String unDia){
        dia = unDia;
    }
    
}
