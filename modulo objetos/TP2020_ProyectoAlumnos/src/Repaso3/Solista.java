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
public class Solista {
    private String nomArtista;
    private String instrumento;
    private int cantTemas;
    
    public Solista(String unNomArtista, String unInstrumento, int unaCantTemas){
        setNomArtista(unNomArtista);
        setInstrumento(unInstrumento);
        setCantTemas(unaCantTemas);    
    }
    
    public String getNomArtista() {
        return nomArtista;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public int getCantTemas() {
        return cantTemas;
    }

    public void setNomArtista(String nomArtista) {
        this.nomArtista = nomArtista;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    public void setCantTemas(int cantTemas) {
        this.cantTemas = cantTemas;
    }
    
}
