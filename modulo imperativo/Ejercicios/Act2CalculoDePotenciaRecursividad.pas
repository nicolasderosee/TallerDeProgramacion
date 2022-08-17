program CalculoDePotenciaRecursion;

procedure Leer(var x,n:integer);
begin
 write('ingrese la base:');
 readln(x);
 write('ingrese el exponente:');
 readln(n);
end;

Function potencia1 (x,n: integer): real;
begin
    potencia1:= x*potencia1(x,n-1);
end;

var x,n:integer;
Begin
 Leer(x,n);
 writeln();
 write('resultado de la potencia:' , potencia1(x,n):6:2);
 readln;
End.
