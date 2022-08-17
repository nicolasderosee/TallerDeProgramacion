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
public class Paciente {
    private int dni;
    private String nom;
    private String obraSocial;

    public Paciente(int unDni, String unNom, String unaObraSocial) {
        this.setDni(unDni);
        this.setNom(unNom);
        this.setObraSocial(unaObraSocial);
    }
    
    public int getDni() {
        return dni;
    }

    public String getNom() {
        return nom;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    private void setDni(int dni) {
        this.dni = dni;
    }

    private void setNom(String nom) {
        this.nom = nom;
    }

    private void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }
    
    
}
