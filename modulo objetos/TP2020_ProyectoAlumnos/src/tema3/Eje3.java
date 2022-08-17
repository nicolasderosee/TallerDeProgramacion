/*
 3- A- Definir una clase para representar entrenadores de un club de fútbol. Un entrenador se
caracteriza por su nombre, sueldo básico y la cantidad de campeonatos ganados.
 Defina métodos para obtener/modificar el valor de cada atributo.
 Defina el método calcularSueldoACobrar que calcula y devuelve el sueldo a cobrar por el
entrenador. El sueldo se compone del sueldo básico, al cual se le adiciona un plus por
campeonatos ganados (5000$ si ha ganado entre 1 y 4 campeonatos; $30.000 si ha ganado
entre 5 y 10 campeonatos; 50.000$ si ha ganado más de 10 campeonatos).
B- Realizar un programa principal que instancie un entrenador, cargándole datos leídos desde
teclado. Pruebe el correcto funcionamiento de cada método implementado.
 */
package tema3;
import PaqueteLectura.Lector;

/**
 *
 * @author Robledo
 */
public class Eje3 {

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
        
        Entrenador E = new Entrenador ();
        E.setNombre(nombre);
        E.setSueldoBasico(sueldoBasic);
        E.setCantCampeonatosGanados(cant);
        System.out.println("Informacion del entrenador ingresado:");
        System.out.println("Nombre:" + E.getNombre());
        System.out.println("Sueldo basico: " + E.getSueldoBasico());
        System.out.println("Cantidad de campeonatos ganados: " + E.getCantCampeonatosGandados());
        System.out.println("Sueldo a cobrar:" + E.CalcularSueldoACobrar());
    }
    
}
