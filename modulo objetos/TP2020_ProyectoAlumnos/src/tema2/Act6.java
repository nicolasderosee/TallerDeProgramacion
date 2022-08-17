/*
6- Se dispone de la clase Partido (ya implementada en la carpeta tema2). Un objeto
partido representa un encuentro entre dos equipos (local y visitante). Un objeto partido
puede crearse sin valores iniciales o enviando en el mensaje de creación el nombre del
equipo local, el nombre del visitante, la cantidad de goles del local y del visitante (en ese
orden). Un objeto partido sabe responder a los siguientes mensajes:
getLocal() retorna el nombre (String) del equipo local
getVisitante() retorna el nombre (String) del equipo visitante
getGolesLocal() retorna la cantidad de goles (int) del equipo local
getGolesVisitante() retorna la cantidad de goles (int) del equipo visitante
setLocal(X) modifica el nombre del equipo local al “String” pasado por parámetro (X)
setVisitante(X) modifica el nombre del equipo visitante al “String” pasado por parámetro (X)
setGolesLocal(X) modifica la cantidad de goles del equipo local “int” pasado por parámetro (X)
setGolesVisitante(X) modifica la cantidad de goles del equipo visitante “int” pasado por parámetro (X)
hayGanador() retorna un boolean que indica si hubo (true) o no hubo (false) ganador
getGanador() retorna el nombre (String) del ganador del partido (si no hubo retorna un String vacío).
hayEmpate() retorna un boolean que indica si hubo (true) o no hubo (false) empate
Implemente un programa que cargue un vector con a lo sumo 20 partidos disputados en el
campeonato. La información de cada partido se lee desde teclado hasta ingresar uno con
nombre de visitante “ZZZ” o alcanzar los 20 partidos. Luego de la carga informar:
- La cantidad de partidos que ganó River.
- El total de goles que realizó Boca jugando de local.
- El porcentaje de partidos finalizados con empate.
 */
package tema2;
import PaqueteLectura.Lector;
/**
 *
 * @author Robledo
 */
public class Act6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int DF = 20;
        int DL = 0; 
        int i;
        String nomLocal;
        String nomVisitante;
        int cantGolesL;
        int cantGolesV;
        Partido [] vec = new Partido [DF];
   
        System.out.print("Ingrese el nombre del equipo local:");
        nomLocal = Lector.leerString();
        while((!nomLocal.equals("zzz")) && (DL<DF)){
             System.out.print("ingrese la cantidad de goles del equipo local:");
             cantGolesL = Lector.leerInt();
             System.out.print("ingrese el nombre del equipo visitante:");
             nomVisitante = Lector.leerString();
             System.out.print("ingrese la cantidad de goles del equipo visitante:");
             cantGolesV = Lector.leerInt();
             vec[DL] = new Partido (nomLocal,nomVisitante,cantGolesL,cantGolesV);
             DL++;
             System.out.print("Ingrese el nombre del equipo local:");
             nomLocal = Lector.leerString();
        }
        
        int PartidosganadosR = 0; double cantempate = 0; int TotalGolesBoca=0; 
        for(i=0; i<DL; i++){
            if(vec[i].hayGanador() == true)
                if (vec[i].getGanador().equals("river")) 
                     PartidosganadosR++;
            else
                 cantempate++;
            if(vec[i].getLocal().equals("boca"))
                 TotalGolesBoca = TotalGolesBoca + vec[i].getGolesLocal();
        }
        
        double Porcentaje = (cantempate*100)/DF;
        System.out.println("Cantidad de partidos que gano river:" + PartidosganadosR);
        System.out.println("Total de goles que realizo boca:" + TotalGolesBoca);
        System.out.println("Porcentaje de los partidos finalizados con empate" + Porcentaje);           
    }
}   

