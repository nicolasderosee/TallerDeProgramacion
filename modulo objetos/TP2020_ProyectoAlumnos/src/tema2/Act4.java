/*
4- Se realizará un casting para un programa de TV. El casting durará a lo sumo 5 días y en
cada día se entrevistarán a 8 personas en distinto turno.
a) Simular el proceso de inscripción de personas al casting. A cada persona se le pide
nombre, DNI y edad y se la debe asignar en un día y turno de la siguiente manera: las
personas primero completan el primer día en turnos sucesivos, luego el segundo día y así
siguiendo. La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los
40 cupos de casting.
Una vez finalizada la inscripción:
b) Informar para cada día y turno el nombre de la persona a entrevistar.
NOTA: utilizar la clase Persona y pensar en la estructura de datos a utilizar. 
 */
package tema2;
import PaqueteLectura.Lector;
/**
 *
 * @author Robledo
 */
public class Act4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final int DFF = 5, DFC=8; 
        
        Persona [][] tabla = new Persona [DFF][DFC]; //matriz de tipo persona
        int f = 0, c = 0; // f(dias) c(turnos)
        int dia = 0,turno = 0;
        
        System.out.print("Ingrese el nombre de la persona: ");
        String nom = Lector.leerString();
        
        while((!nom.equals("zzz")) && (f<DFF)){
            while((c<DFC) && (!nom.equals("zzz"))){ 
                 System.out.print("Ingrese el dni: ");
                 int dni = Lector.leerInt();
                 System.out.print("Ingrese la edad: ");
                 int edad = Lector.leerInt();  
                 tabla [f][c] = new Persona(nom,dni,edad); // tabla es de tipo persona 
                 System.out.print("Ingrese el nombre de la persona: ");
                 nom = Lector.leerString();
                 turno = c; //dimL de turnos 
                 c++;    
            }
            dia = f; // dimL de dias 
            c=0;
            f++;   
        }
   
        for(f = 0 ; f <= dia; f++){ //recorro la matriz e imprimo
            System.out.println("Dia: " + (f+1));
            if(f==dia)
                for(c = 0; c <= turno; c++){
                 System.out.println("Turno: " + (c+1));
                 System.out.println("nombre de la persona a entrevistar: " + tabla[f][c].getNombre());
                }
            else 
                for(c = 0; c < DFC; c++){
                 System.out.println("Turno: " + (c+1));
                 System.out.println("nombre de la persona a entrevistar: " + tabla[f][c].getNombre());
                }
        }
    }
}
