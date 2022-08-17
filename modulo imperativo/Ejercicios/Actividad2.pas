Program Actividad2;
var num, n, cant: integer;
begin
 Randomize;
 write('ingrese un numero del 0 al 10:');
 readln(num);
 n:= random(11); {valores del 0 al 10}
 writeln('el numero aleatorio generado es:',n);
 while(n<>num)do begin
  cant:= cant + 1;
  n:=random(11);
 end;
 writeln('Cantidad de veces necesarias para que se de la coincidencia:',cant);
 readln;
end.
