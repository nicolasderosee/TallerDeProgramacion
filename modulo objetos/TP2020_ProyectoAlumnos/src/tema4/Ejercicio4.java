/*
4-A- Definir una clase para representar micros. Un micro conoce su patente, destino, hora
salida, el estado de sus 20 asientos (es decir si está o no ocupado) y la cantidad de asientos
ocupados al momento. Lea detenidamente a) y b) y luego implemente.
a) Implemente un constructor que permita iniciar el micro con una patente, un destino y
una hora de salida (recibidas por parámetro) y sin pasajeros.
b) Implemente métodos para:
i. devolver/modificar patente, destino y hora de salida
ii. devolver la cantidad de asientos ocupados
iii. devolver si el micro está lleno
iv. validar un número de asiento recibido como parámetro (es decir, devolver si está
en rango o no)
v. devolver el estado de un nro. de asiento válido recibido como parámetro
vi. ocupar un nro. de asiento válido recibido como parámetro
vii. liberar un nro. de asiento válido recibido como parámetro
viii. devolver el nro. del primer asiento libre.
B- Realice un programa que cree un micro con patente “ABC123”, destino “Mar del Plata” y
hora de salida 5:00. Cargue pasajeros al micro de la siguiente manera. Leer nros. de
asientos desde teclado que corresponden a pedidos de personas. La lectura finaliza cuando
se ingresa el nro. de asiento -1 o cuando se llenó el micro. Para cada nro. de asiento leído
debe: validar el nro; en caso que esté libre, ocuparlo e informar a la persona el éxito de la
operación; en caso que esté ocupado informar a la persona la situación y mostrar el nro.
del primer asiento libre. Al finalizar, informe la cantidad de asientos ocupados del micro. 

 */
package tema4;
import PaqueteLectura.Lector;
/**
 *
 * @author Robledo
 */
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Micro M = new Micro("ABC","Mar del Plata","5:00");
        System.out.print("Ingrese un numero de asiento:");
        int nroA = Lector.leerInt();
        while((nroA!=-1)&&(!M.Estalleno())){ // si el micro no esta lleno y el nro de asiento ingresado no es -1, entro al while.
            if(M.ValidarAsiento(nroA)) //valida si existe el asiento ingresado, si el asiento valido == true entra al if
                if(M.EstadoAsientoValido(nroA) == false){ //si el asiento ingresado no esta ocupado, ocuparlo
                    M.OcuparAsientoValido(nroA);
                    System.out.println("Se ocupó el numero de asiento ingresado:");
                }  
                else { //si el asiento ingresado esta ocupado 
                    System.out.println("El numero de asiento ingresado ya está ocupado");
                    System.out.println("Numero del primer asiento libre: " + M.PrimerAsientoLibre());  
                }
            else
                System.out.println("El numero de asiento ingresado no es valido");
            System.out.print("Ingrese un numero de asiento:");
            nroA = Lector.leerInt();
        }
        System.out.println("Cantidad de Asientos Ocupados: " + M.cantAsientosOcupados());
    }   
}
