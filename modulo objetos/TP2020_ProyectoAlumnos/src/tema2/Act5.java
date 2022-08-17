/*
 5- Realice un programa que cargue un vector con 10 strings leídos desde teclado. El vector
generado tiene un mensaje escondido que se forma a partir de la primera letra de cada
string. Muestre el mensaje escondido en consola.
NOTA: La primer letra de un string se obtiene enviándole el mensaje charAt(0) al objeto
string. Probar con: humo oso lejos ala menos usado nene de ocho ! Debería imprimir:
holamundo!
 */
package tema2;
import PaqueteLectura.Lector;
/**
 *
 * @author Robledo
 */
public class Act5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final int DF = 10; 
        String [] vec = new String [DF];
        int i;
        
        for(i = 0 ; i < DF ; i++){ 
            System.out.print("Ingrese una palabra: ");
            String palabra = Lector.leerString();
            vec[i] = palabra;
        }
        
        System.out.print("Mensaje oculto: ");
        for(i = 0 ; i < DF ; i++)
            System.out.print(vec[i].charAt(0));   
    }    
}
