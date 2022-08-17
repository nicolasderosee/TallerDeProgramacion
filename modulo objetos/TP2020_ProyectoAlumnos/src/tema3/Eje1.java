/*
 1- A- Definir una clase para representar triángulos. Un triángulo se caracteriza por el tamaño de sus
3 lados (double), el color de relleno (String) y el color de línea (String).
El triángulo debe saber:
 Devolver/modificar el valor de cada uno de sus atributos (métodos get# y set#)
 Calcular el área y devolverla (método calcularArea)
 Calcular el perímetro y devolverlo (método calcularPerimetro)
NOTA: Calcular el área con la fórmula √ , donde a,b y c son los lados
y La función raíz cuadrada es Math.sqrt(#)
B- Realizar un programa principal que instancie un triángulo, le cargue información leída desde
teclado e informe en consola el perímetro y el área.
 */
package tema3;
import PaqueteLectura.Lector;
/**
 *
 * @author Robledo
 */
public class Eje1 {

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
        Triangulo T = new Triangulo();
        T.setLado1(a);
        T.setLado2(b);
        T.setLado3(c);
        T.setColorRelleno(colorRelleno);
        T.setColorLinea(colorLinea);
        System.out.println("area del triangulo:" + T.CalcularArea());
        System.out.println("perimetro del triangulo:" + T.CalcularPerimetro());
    }  
}
