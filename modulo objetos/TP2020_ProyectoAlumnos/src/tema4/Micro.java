/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Robledo
 */
public class Micro {
    private String patente;
    private String destino;
    private String horaSalida;
    private int cantOcupados; //DL
    private int DF = 20;
    private boolean [] vecAsientos; //vector de asientos 
    
    public Micro(String unaPat, String unDest, String unaHoraSalida){
        patente = unaPat;
        destino = unDest;
        horaSalida = unaHoraSalida; 
        cantOcupados=0;
        vecAsientos = new boolean [DF];
        for(int i=0; i<DF; i++)
            vecAsientos[i]= false; //todos los asientos vacios     
    }
    
    public String getPatente(){
        return patente;
    }
    
    public void SetPatente(String unaPat){
        patente = unaPat;
    }
    
    public String getDestino(){
        return destino;
    }
    
    public void setDestino(String unDestino){
        destino = unDestino;  
    }
    
    public String getHoraSalida(){
        return horaSalida;
    }
    
    public void setHoraralida(String unaHoraSalida){
        horaSalida = unaHoraSalida;
    }
    
    public int cantAsientosOcupados(){
        return cantOcupados;         
    }
    
    public boolean Estalleno(){
        boolean ok = false;
        if(cantOcupados == DF)
           ok = true; 
     return ok; // si devuelve true, el micro esta lleno. si devuelve false, el micro no está lleno
    }
    
    public boolean ValidarAsiento(int numAsiento){
        boolean ok = false;
        if ((numAsiento>=0)&&(numAsiento<DF))
             ok = true; 
      return ok;
    }
    
    public boolean EstadoAsientoValido(int numAsiento){
        return vecAsientos[numAsiento]; //devuelve si el asiento ingresado esta vacio o ocupado 
    }
    
    public void OcuparAsientoValido(int numAsiento){ //ocupa un asiento valido ingresado 
         vecAsientos[numAsiento] = true; 
         cantOcupados++;
    }
    
    public void LiberarAsientoValido(int unAsiento){ //libera un asiento ingresado 
        vecAsientos[unAsiento] = false; 
        cantOcupados--;
    }
    
    public int PrimerAsientoLibre(){ //devuelve el primer asiento vacio
        int num = 0; 
        while((num<DF) && (vecAsientos[num] == true))
                num++;
        return num;   
    }
}
