Program VectorConRecursion;
Const 
 DimF = 10;
Type
 indice = 0..Dimf;
 vec = Array [ 1..DimF] of integer;


Procedure CrearVector(var v:vec; var dimL:indice);

 Procedure Agregar(var v:vec; var dimL:indice; elem:integer; var exito:boolean);
 begin
  If (dimL < dimF) then begin
    dimL:= dimL+1;
    v [dimL]:= elem;
    exito:=true
  end
  else
    exito:=false;
 end;

var elem:integer; exito:boolean;
begin
 dimL:=0;
 exito:=true;
 while(exito=true)do begin
  elem:=random(10);
  writeln('el numero aleatorio generado es:',elem);
  Agregar(v,dimL,elem,exito);
 end;
end;


procedure Maximo(v:vec; dimL,i:indice; var max:integer);
var n:integer;
begin
 if(i<=dimL) then begin
    n:= v[i];
    if(n>max) then
      max:= n;
    Maximo(v,dimL,i+1,max);
 end;
end;

procedure Suma(v:vec; dimL,i:indice; var sum:integer);
var n:integer;
begin
 if(i<=dimL) then begin
    n:= v[i];
    sum:= sum + n;
    Suma(v,dimL,i+1,sum);
 end;
end;


procedure ImprimirVector(vec:vec; dimL:indice);
var i:indice;
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


var v:vec; dimL:indice; i:indice; sum, max:integer;
begin
 Randomize;
 i:=1;
 sum:=0;
 max:=-1;
 CrearVector(v,dimL);
 writeln();
 ImprimirVector(v,dimL);
 writeln();
 Maximo(v,dimL,i,max);
 writeln('valor maximo del vector:', max);
 writeln();
 Suma(v,dimL,i,sum);
 writeln('suma de todos los valores contenidos en el vector:', sum);
 Readln;
End.

