Program programaVector;
Const
 DimF = 10;
Type
 indice = 0..Dimf;
 vector = Array [ 1..DimF] of integer;

procedure CrearVector(var v:vector; var dimL:indice);

  Procedure Agregar (var v: vector; var dimL:indice;
  elem: integer; var exito : boolean);
  begin
    If (dimL < dimF) then begin
      dimL:= dimL+1;
      v[dimL]:= elem;
      exito:= true;
    end
    else exito:= false;
  end;

var
 elem:integer; ok:boolean;
begin
 dimL:=0;
 ok:= true;
 elem:= random(16);
 while(ok = true) and (elem<15) do begin
   elem:= random(16);
   writeln('el numero aleatorio generado es:',elem);
   Agregar(v,dimL,elem,ok);
 end;
end;


procedure EliminarElemento(var v:vector; var dimL:indice); //recibo por referencia ya que voy a modificar el vector y la dimL al borrar un elem

 Procedure BorrarElemento(var v:vector; var dimL:indice; valor:integer; var exito:boolean);

    Function BuscarPosElem(valor:integer; v:vector; dimL:indice):integer; //retorna la pos si es que existe el elem que se quiere borrar
    var pos:indice;
    begin
      pos:=1;
      while (pos<=dimL) and (valor<>v[pos]) do
        pos:=pos+1;
      if (pos>dimL) then
        pos:=0;
      BuscarPosElem :=pos;
    end;

    Procedure BorrarElemPosModif(var v:vector; var dimL:indice; pos:indice);
    var j:integer;
    begin
       for j:=pos+1 to dimL do
         v [j-1]:=v[j]; {se hace el corrimiento y se resta 1 a la dimL}
       dimL := dimL - 1;
    end;

 var pos:indice;
 begin
  pos:= BuscarPosElem (valor,v,dimL);
  if (pos <> 0) then begin
    BorrarElemPosModif (v,dimL,pos);
    exito:= true;
  end
  else exito:= False;
 end;

var valor:integer; ok:boolean;
begin
 writeln();
 write('ingrese un valor para que sea eliminado:');
 read(valor);
 BorrarElemento(v,dimL,valor,ok);
 if(ok=true)then begin
  writeln();
  writeln('se elimino el valor ingresado');
 end
 else begin
  writeln();
  writeln('no se pudo eliminar el valor ingresado');
 end;
 readln;
end;

Procedure OrdenacionPorInsercion(var v:vector; var dimL:indice);
var i,j,elem:integer;
begin
 for i:= 2 to dimL do begin
   elem:=v[i];
   j:=i-1;
   while(j>0) and (v[j]>elem) do begin
     v[j+1]:= v[j];
     j:=j-1;
   end;
 v[j+1]:=elem;
 end;
end;

Procedure busquedaDicotomica(v:vector; ini,fin:indice; dato:integer; var pos:indice);
var
 medio:indice;
begin
  if(ini=fin) and (dato<>v[ini]) then  //caso base 1
    pos:=0
  else  begin
       medio:= (ini+fin) div 2;
       if (dato=v[medio]) then  //caso base 2
         pos:=medio
       else begin
           if (dato < v[medio]) then fin:=medio-1
	                           else  ini:=medio+1;
           busquedaDicotomica (v, ini, fin, dato, pos); //caso recursivo
       end;
  end;
end;

procedure ImprimirVector(vec:vector; dimL:indice); //no los recibe por referencia ya que solo se tiene que recorrer e informar, no se modifica nada
var i:integer;
begin
 writeln();
 write('numeros almacenados:');
 for i:= 1 to dimL do begin
  write('|',vec[i]);
 end;
 writeln();
 writeln();
 writeln('dimension logica:' , dimL);
end;



Var
 v:vector; dimL:indice; ini:indice; dato:integer; pos:indice;
Begin
 ini:=1; pos:=0;
 Randomize;
 CrearVector(v,dimL);
 ImprimirVector(v,dimL);
 EliminarElemento(v,dimL);
 writeln();
 ImprimirVector(v,dimL);
 OrdenacionPorInsercion(v,dimL);
 writeln();
 ImprimirVector(v,dimL);
 writeln('se imprimio el vector ordenado');
 writeln();
 write('ingrese un valor a buscar:');
 readln(dato);
 busquedaDicotomica(v,ini,dimL,dato,pos);
 if(pos=0) then
   writeln('no se encontro el valor ingresado')
 else
   writeln('el numero ', dato ,' se encuentra en la posicion ', pos);
 readln;
End.

