package tema5;


public class Cuadrado extends Figura{
    
    private double lado;
    
    public Cuadrado(double unLado, String unColorR, String unColorL){
        super(unColorR,unColorL);
        setLado(unLado); // en vez de utilizar directamente las v.i. lado, puedo hacer que el objeto se envie un msj a si mismo para modificar/obtener dicho valor.
    } 
    
    public double getLado(){
        return lado;       
    }
  
    public void setLado(double unLado){
        lado=unLado;
    }

    public double calcularArea(){
       return (getLado()* getLado());
    }
    
    public double calcularPerimetro(){
       return (getLado()*4);
    }
    
    public String toString(){
       String aux = super.toString() +  //super es la referencia al objeto que se esta ejecutando. La busqueda del metodo inicia en la clase superior a la actual
                    " Lado: " + getLado();
       return aux;
    }
}
