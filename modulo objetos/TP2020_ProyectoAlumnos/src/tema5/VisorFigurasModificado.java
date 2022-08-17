/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema5;

/**
 *
 * @author Robledo
 */
public class VisorFigurasModificado {
    private int guardadas; //DL
    private Figura [] vector; //vector de figuras

    public VisorFigurasModificado(){
       guardadas = 0;
       vector = new Figura [5];
    }

    public void guardar(Figura f){
        if(this.quedaEspacio()){
            vector[guardadas] = f;
            guardadas++;
        }
    }
    
    public boolean quedaEspacio(){
       boolean ok = false;
       if(guardadas<5)
           ok = true;
     return ok;
    }

    public void mostrar(){
      for(int i=0; i<guardadas; i++)
        System.out.println(vector[i].toString());
    }
 
    public int getGuardadas() {
     return guardadas;
    }
}


