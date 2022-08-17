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
public class Alfa extends Grupo {

    @Override
    public void aplicarMismaDosis(double D) {
       for (int i = 0; i<this.getDL(); i++){
           this.getVecPlantas()[i].setDosisFarmaco(D);
       }
    }
}

 

   