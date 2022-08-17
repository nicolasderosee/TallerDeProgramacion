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
public class Alfa extends Grupo{

    @Override
    public void aplicarDosis(double D) { //aplica dosis a todos los pacientes del grupo
        for(int i=1; i<this.getCandidadDePacientes(); i++){
            Paciente2 p = this.obtenerPaciente(i);
            p.aplicarDosis(D);
        }
    }
    
}
