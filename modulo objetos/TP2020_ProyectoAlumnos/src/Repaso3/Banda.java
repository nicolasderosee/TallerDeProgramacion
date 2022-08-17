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
public class Banda {
    private String nomBanda;
    private String ciudadF;
    private int cantIntegrantes;
    
    public Banda(String unNomBanda, String unaCiudadF, int unaCantIntegrantes) {
        setNomBanda(unNomBanda);
        setCiudadF(unaCiudadF);
        setCantIntegrantes(unaCantIntegrantes);    
    }

    public String getNomBanda() {
        return nomBanda;
    }

    public String getCiudadF() {
        return ciudadF;
    }

    public int getCantIntegrantes() {
        return cantIntegrantes;
    }

    public void setNomBanda(String nomBanda) {
        this.nomBanda = nomBanda;
    }

    public void setCiudadF(String ciudadF) {
        this.ciudadF = ciudadF;
    }

    public void setCantIntegrantes(int cantIntegrantes) {
        this.cantIntegrantes = cantIntegrantes;
    }
}
