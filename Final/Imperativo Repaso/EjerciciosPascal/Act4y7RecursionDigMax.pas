program CalculoDigitoMaximoRec;
type
 digito=-1..9;

var num:integer; max:digito;

procedure digitoMaximoRec(n: integer; var max: digito);
var
  dig:integer;
begin
  if (n <> 0) then begin
                dig:= n mod 10;
                if (dig > max) then
                                max:= dig;
                n:= n div 10;
                digitoMaximoRec(n, max);
  end;
end;

procedure ImprimirDigitos1(n:integer);
var dig:integer;
begin
  if (n <> 0) then begin
      dig:= n mod 10;
      writeln(dig);
      n:= n div 10;
      ImprimirDigitos1(n);
  end;
end;


procedure ImprimirDigitos2(n:integer);
var dig:integer;
begin
  if (n <> 0) then begin
      dig:= n mod 10;
      n:= n div 10;
      ImprimirDigitos2(n);
      writeln(dig);
  end;
end;



begin
  write('ingrese un numero entero:');
  read (num);
  max := -1;
  digitoMaximoRec(num, max);
  write ('El digito maximo de ', num, ' es: ', max);
  writeln();
  writeln('escritura del numero empezando con la unidad:');
  ImprimirDigitos1(num);
  writeln();
  writeln('escritura del numero finalizando con la unidad:');
  ImprimirDigitos2(num);
  readln;
  readln;
end.

