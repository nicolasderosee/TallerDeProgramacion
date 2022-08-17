/*
 El dueño de un restaurante entrevista a cinco clientes y les pide que califiquen
(con puntaje de 1 a 10) los siguientes aspectos: (0) Atención al cliente (1) Calidad
de la comida (2) Precio (3) Ambiente.
Escriba un programa que lea desde teclado las calificaciones de los cinco clientes
para cada uno de los aspectos y almacene la información en una estructura. Luego
imprima la calificación promedio obtenida por cada aspecto. 
 */
package tema1;
import PaqueteLectura.Lector;
/**
 *
 * @author Robledo
 */
public class Actividad9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic
        final int DFF = 5, DFC = 4; 
        
        int [][] tabla = new int [DFF][DFC];
        
        int f,c; 
        
        for(f = 0; f < DFF; f++){
           System.out.println("Cliente numero " + f);
           for(c = 0 ; c < DFC ; c++){
               System.out.print("Califique del 1 al 10 el aspecto " + c + ":");
               int calificacion = Lector.leerInt();
               tabla [f][c]= calificacion;
           }
        } 
        
        
        for(c = 0 ; c < DFC ; c++){
            double sum = 0;
            for(f = 0 ; f < DFF; f++)
               sum = sum + tabla [f][c];
            double prom = sum/DFC;
            System.out.println("promedio de las calificaciones del aspecto: " + c + ": " + prom);
        } 
    }
}
