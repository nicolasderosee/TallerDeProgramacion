/*
4-A- Generar una clase para representar círculos. Los círculos se caracterizan por su radio (double),
el color de relleno (String) y el color de línea (String). El círculo debe saber:
 Devolver/modificar el valor de cada uno de sus atributos (get# y set#)
 Calcular el área y devolverla. (método calcularArea)
 Calcular el perímetro y devolverlo. (método calcularPerimetro)
NOTA: la constante PI es Math.PI
 B- Realizar un programa principal que instancie un círculo, le cargue información leída de teclado
e informe en consola el perímetro y el área. 
6-A– Defina constructores para la clase Círculo (definida en la Act. 3): el primer
constructor debe recibir un valor para el radio y para los colores de línea y relleno; el
segundo constructor no debe poseer parámetros ni código (constructor nulo).
 B- Realice un programa que instancie un círculo mediante los distintos constructores
 */
package tema3;
import PaqueteLectura.Lector;
/**
 *
 * @author Robledo
 */
public class Eje4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Ingrese el radio del circulo: ");
        int r = Lector.leerInt();
        System.out.print("Ingrese el color de relleno: " );
        String colorRelleno = Lector.leerString();
        System.out.print("Ingrese el color de linea: " );
        String colorLinea = Lector.leerString();
        Circulo C = new Circulo(r,colorRelleno,colorLinea);
        System.out.println("Area del circulo: " + C.CalcularArea());
        System.out.println("Perimetro del circulo: " + C.CalcularPerimetro());      
    }  
}
