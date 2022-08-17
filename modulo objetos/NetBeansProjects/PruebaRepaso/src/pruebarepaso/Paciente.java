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
public class Paciente extends Persona {
    private String obraSocial;
    
    public Paciente(String unNombre, int unDNI, int unaEdad, String unaOS) {
        super(unNombre, unDNI, unaEdad);
        this.setObraSocial(unaOS);
    }

    public String getObraSocial() {
        return obraSocial;
    }

    private void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }
    
    
}
