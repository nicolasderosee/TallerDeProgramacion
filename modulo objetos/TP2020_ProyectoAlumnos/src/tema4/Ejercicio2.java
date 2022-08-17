/*
2-A– Defina un constructor para la clase Entrenador (definida en la Act. 3) que reciba los
datos necesarios (nombre, sueldo básico, cantidad de campeonatos ganados). Además
defina un constructor nulo.
 B- Realice un programa que instancie un entrenador mediante el primer constructor.
 */
package tema4;
import PaqueteLectura.Lector;
/**
 *
 * @author Robledo
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Ingrese el nombre del entrenador: ");
        String nombre = Lector.leerString();
        System.out.print("Ingrese el sueldo basico del entrenador: ");
        double sueldoBasic = Lector.leerDouble();
        System.out.print("Ingrese la cantidad de camponatos ganados:");
        int cant = Lector.leerInt();
     
        Entrenador Ent = new Entrenador (nombre,sueldoBasic,cant);
        System.out.println("Informacion del entrenador ingresado:");
        System.out.println("Nombre:" + Ent.getNombre());
        System.out.println("Sueldo basico: " + Ent.getSueldoBasico());
        System.out.println("Cantidad de campeonatos ganados: " + Ent.getCantCampeonatosGandados());
        System.out.println("Sueldo a cobrar:" + Ent.CalcularSueldoACobrar());
    }
    
}
