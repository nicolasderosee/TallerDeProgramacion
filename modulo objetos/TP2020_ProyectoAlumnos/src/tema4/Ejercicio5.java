/*
5-A- Definir una clase para representar flotas de micros. Una flota se caracteriza por
conocer a los micros que la componen (a lo sumo 15). Defina un constructor para crear
una flota vacía (sin micros).
Implemente métodos para:
i. devolver si la flota está completa (es decir, si tiene 15 micros o no).
ii. agregar a la flota un micro recibido como parámetro.
iii. eliminar de la flota el micro con patente igual a una recibida como parámetro, y
retornar si la operación fue exitosa.
iv. buscar en la flota un micro con patente igual a una recibida como parámetro y
retornarlo (en caso de no existir dicho micro, retornar null).
v. buscar en la flota un micro con destino igual a uno recibido como parámetro y
retornarlo (en caso de no existir dicho micro, retornar null). 
B- Genere un programa que cree una flota vacía. Cargue micros (sin pasajeros) a la flota
con información leída desde teclado (hasta que se ingresa la patente “ZZZ000” o hasta
completar la flota). Luego lea una patente y elimine de la flota el micro con esa patente;
busque el micro con dicha patente para comprobar que ya no está en la flota. Para
finalizar, lea un destino e informe la patente del micro que va a dicho destino
 */
package tema4;
import PaqueteLectura.Lector;
/**
 *
 * @author Robledo
 */
public class Ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Flota f = new Flota();
        System.out.print("Ingrese la patente del auto: ");
        String pat = Lector.leerString();
        while(!pat.equals("0ZZZ000") && !f.estaCompleta()){ //mientras pat sea distinto de 0ZZZ000 y la flota no este completa entro
             System.out.print("Ingrese el destino: ");
             String dest = Lector.leerString();
             System.out.print("Ingrese la hora de salida: ");
             String hSalida = Lector.leerString();
             Micro m = new Micro(pat,dest,hSalida);
             f.agregarMicro(m);
             System.out.print("Ingrese la patente del auto: ");
             pat = Lector.leerString();
        }
        System.out.print("Ingrese la patente del micro que quiere eliminar: ");
        String unaPat = Lector.leerString();
        if (f.eliminarMicro(unaPat))
            if (f.buscarMicroPorPatente(unaPat) == null)
                System.out.println("Se eliminó el micro correctamente");
        else
            System.out.println("No se encontró un micro con dicha patente");
        
        
        System.out.print("Ingrese un destino: ");
        String unDest = Lector.leerString();
        Micro Mic = f.buscarMicroPorDestino(unDest);
        System.out.println("patente del micro que va a dicho destino: " + Mic.getPatente());
    }      
}
