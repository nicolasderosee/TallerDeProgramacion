/*
1-A– Defina constructores para la clase Triángulo (definida en la Act. 3): el primer
constructor debe recibir un valor para cada lado y para los colores de línea y relleno; el
segundo constructor no debe poseer parámetros ni código (constructor nulo).
 B- Realice un programa que instancie un triángulo mediante los distintos constructores.
 */
package tema4;
import PaqueteLectura.Lector;
/**
 *
 * @author Robledo
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Ingrese el lado a: ");
        double a = Lector.leerDouble();
        System.out.print("Ingrese el lado b: ");
        double b = Lector.leerDouble();
        System.out.print("Ingrese el lado c: ");
        double c = Lector.leerDouble();
        System.out.print("Ingrese el color de relleno: ");
        String colorRelleno = Lector.leerString();
        System.out.print("Ingrese el color de linea: ");
        String colorLinea = Lector.leerString();
        Triangulo T= new Triangulo();
        Triangulo Tri = new Triangulo(a,b,c,colorRelleno,colorLinea);
        System.out.println("Area del triangulo:" + Tri.CalcularArea());
        System.out.println("Perimetro del triangulo:" + Tri.CalcularPerimetro());
    }
    
}
