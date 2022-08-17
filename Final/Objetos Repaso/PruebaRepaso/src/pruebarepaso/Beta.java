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
public class Beta extends Grupo {

    @Override
    public void aplicarDosis(double D) {  //aplica una dosis de farmaco a los pacientes con glucosa mayor a 2.5
        for(int i=1; i<this.getCandidadDePacientes(); i++){
            Paciente2 P = this.obtenerPaciente(i);
            if (P.getGlucosa()>2.5)
                this.aplicarDosis(D);
        }
    }
    
    
}
