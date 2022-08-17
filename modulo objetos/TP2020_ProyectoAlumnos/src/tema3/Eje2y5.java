/*
2- A – Definir una clase para representar balanzas comerciales (para ser utilizadas en verdulerías,
carnicerías, etc). Una balanza comercial sólo mantiene el monto y la cantidad de items
correspondientes a la compra actual (es decir, no almacena los ítems de la compra). La balanza
debe responder a los siguientes mensajes:
 iniciarCompra(): inicializa el monto y cantidad de ítems de la compra actual.
 registrarProducto(pesoEnKg, precioPorKg): recibe el peso en kg del ítem comprado y su precio
por kg, debiendo realizar las actualizaciones en el estado de la balanza.
 devolverMontoAPagar(): retorna el monto de la compra actual.
 devolverResumenDeCompra(): retorna un String del siguiente estilo “Total a pagar X por la
compra de Y productos” , donde X es el monto e Y es la cantidad de ítems de la compra
B - Genere un programa principal que cree una balanza e inicie una compra. Lea información desde
teclado correspondiente a los ítems comprados (peso en kg y precio por kg) hasta que se ingresa
uno con peso 0. Registre cada producto en la balanza. Al finalizar, informe el resumen de la compra.
5-A- Modifique el ejercicio 2-A. Ahora la balanza debe poder generar un resumen de compra más
completo. Para eso agregue a la balanza la característica resumen (String). Modifique los métodos:
 iniciarCompra para que además inicie el resumen en el String vacío.
 registrarProducto para que reciba un objeto Producto (que se caracteriza por peso en kg y
descripción) y su precio por kg. La operación debe realizar las actualizaciones en monto
/cantidad de ítems y adicionar al resumen (string) la descripción y el monto pagado por este
producto.
 devolverResumenDeCompra() para que retorne un String del siguiente estilo: “Naranja 100
pesos – Banana 40 pesos – Lechuga 50 pesos – Total a pagar 190 pesos por la compra de 3
productos” . La sección subrayada es el contenido de resumen.
Realice las modificaciones necesarias en el programa principal solicitado en 2-B para corroborar el
funcionamiento de la balanza.
NOTA: dispone en la carpeta tema 3 de la clase Producto ya implementada. Para adicionar la
información del producto recibido al resumen use concatenación de Strings (operación +). 
 */
package tema3;
import PaqueteLectura.Lector;
/**
 *
 * @author Robledo
 */
public class Eje2y5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Balanza B = new Balanza();
       B.iniciarCompra();
       System.out.print("Ingrese el peso del producto: ");
       double peso = Lector.leerDouble();
       while (peso != 0){
            System.out.print("Ingrese la descripcion del producto: ");
            String desc = Lector.leerString();
            Producto P = new Producto(peso,desc);
            System.out.print("Ingrese el precio del producto: ");
            double precio = Lector.leerDouble();
            B.registrarProducto(precio,P);
            System.out.print("Ingrese el peso del producto: ");
            peso = Lector.leerDouble();
        } 
      
       System.out.println(B.devolverResumenDeCompra() + B.devolverMontoAPagar()); 
    }
}
       

