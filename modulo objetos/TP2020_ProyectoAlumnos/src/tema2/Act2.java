/*
Utilizando la clase Persona (ya implementada). Realice un programa que almacene en
un vector 15 personas. La información de cada persona debe leerse de teclado. Luego de
almacenar la información:
 - Informe la cantidad de personas mayores de 65 años.
 - Muestre la representación de la persona con menor DNI.
 */
package tema2;
import PaqueteLectura.Lector;
/**
 *
 * @author Robledo
 */
public class Act2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final int DF = 3; 
        
        Persona [] vec = new Persona [DF]; // vector del 0 al 14 = 15 elementos 
        
        int i;
        
        for(i = 0 ; i < DF ; i++) {
             System.out.print("Ingrese el nombre de la persona: ");
             String nom = Lector.leerString();
             System.out.print("Ingrese el dni de la persona: ");
             int dni = Lector.leerInt();
             System.out.print("Ingrese la edad de la persona: ");
             int edad = Lector.leerInt();
             Persona p = new Persona(nom,dni,edad);
             vec[i] = p;
        }
        
        int cantmayores = 0, menorDNI = 999999999, menorP = 0;
        for(i = 0 ; i < DF ; i++){
            if(vec[i].getEdad()>65)
                cantmayores++;
            if(vec[i].getDNI()< menorDNI){
                menorDNI = vec[i].getDNI();
                menorP = i;
            }   
        } 
        System.out.println("Cantidad de personas mayores a 65 años: " + cantmayores);
        System.out.println("informacion de la persona con menor dni: " + vec[menorP].toString());            
    }  
}
