program CalculoDePotenciaRecursion;

procedure Leer(var x,n:integer);
begin
 write('ingrese la base:');
 readln(x);
 write('ingrese el exponente:');
 readln(n);
end;

Function potencia2 (x,n: integer): real;
begin
    if (n = 0) then
       potencia2:= 1
    else
       potencia2 := x * potencia2(x,n);
end;

var x,n:integer;
Begin
 Leer(x,n);
 writeln();
 write('resultado de la potencia:' , potencia2(x,n):6:2);
 readln;
End.
