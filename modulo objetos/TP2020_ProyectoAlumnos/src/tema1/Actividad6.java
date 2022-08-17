/*
 Escriba un programa que defina una matriz de enteros de tamaño 10x10.
Inicialice la matriz con números aleatorios entre 0 y 200.
Luego realice las siguientes operaciones:
- Mostrar el contenido de la matriz en consola.
- Calcular e informar la suma de todos los elementos almacenados entre las
filas 2 y 9 y las columnas 0 y 3
- Generar un vector de 10 posiciones donde cada posición i contiene la suma
de los elementos de la columna i de la matriz.
- Lea un valor entero e indique si se encuentra o no en la matriz. En caso de
encontrarse indique su ubicación (fila y columna) en caso contrario
imprima “No se encontró el elemento”.

 */
package tema1;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Robledo
 */
public class Actividad6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneradorAleatorio.iniciar();
        final int DF =10, DFF = 10, DFC = 10; 
        
        int [][] tabla = new int [DFF][DFC];
        int [] vector = new int [DF];
        int c,f,i;
        
        for(f= 0 ; f < DFF; f++) // cargo la matriz -  i = filas - j = columnas
           for(c = 0 ; c < DFC ; c++){
             int num = GeneradorAleatorio.generarInt(200);
             tabla[f][c] = num; 
            }   
        
        for(f = 0 ; f < DFF; f++) //recorro la matriz e imprimo
            for(c = 0; c < DFC; c++)
               System.out.println("El valor contnido en la pos " + f + "," + c + " es: " + tabla[f][c]);
        
        int sum = 0;
        for(f =2; f < DFF; f++) //recorro una parte de la matriz e imprimo 
            for(c = 0; c < 4; c++)
               sum = sum + tabla[f][c];
        System.out.println("La suma de todos los elementos almacenados e/ las filas 2 y 9 y las columnas 0 y 3 es: " +sum); 
        
        
        for(i = 0 ; i < DF ; i++) // vector de 0 a 9 
            vector[i] = 0;
        
        int sumcol = 0;
        for(c= 0 ; c < DFC; c++){
            for(f = 0; f < DFF; f++) 
                sumcol = sumcol + tabla [f][c];
            vector[c] = sumcol;
        }   
                
        for(i = 0 ; i < DF; i++)        
            System.out.println("la pos " + i + " del vector tiene: " + vector[i]);

        
   
       System.out.print("ingrese el valor que quiera buscar en la matriz:");
       int valor = Lector.leerInt();
       
       int posf,posc = 0; 
       boolean ok = false;

       posf=0;
       while ((posf<DFF)&&(ok == false)){
            posc=0;
            while((posc<DFC)&&(ok ==false)){
                if ((valor == tabla[posf][posc]))
                    ok = true;
                if(valor != tabla[posf][posc])
                   posc++;        
            }
            if(ok == false)
                posf++;
        }
        if(ok == true)
            System.out.println("El valor ingresado se encuentra contenido en la pos " + posf + "," + posc + ": " + tabla[posf][posc]);   
        else 
            System.out.println("No se encontro el valor ingresado");                                
    }
}
