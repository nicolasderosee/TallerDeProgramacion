program CalculoDePotenciaRecursion;

procedure Leer(var x,n:integer);
begin
 write('ingrese la base:');
 readln(x);
 write('ingrese el exponente:');
 readln(n);
end;

Function potencia (x,n: integer): real;
begin
  if (n = 0) then
    potencia:= 1
  else
    potencia:= x*potencia(x,n-1);
end;


var x,n:integer;
Begin
 Leer(x,n);
 writeln();
 write('resultado de la potencia:' , potencia(x,n):6:2);
 readln;
End.
