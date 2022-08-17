Program programaPELICULAS;
Const
 DimF = 8;
Type
 cadena=string[20];
 rango=1..Dimf;
 pelicula=record
   codpeli:integer;
   titulo:cadena;
   codgen:rango;
   puntajeprom:real;
 end;
 peli=record
   codpeli:integer;
   titulo:cadena;
   puntajeprom:real;
 end;
 lista=^nodo;
 nodo=record
  datos:peli;
  sig:lista;
 end;

vector = Array [rango] of lista;

Procedure CrearVectorDeListas(var v:vector);

 Procedure inivec(var v:vector);
 var i:integer;
 begin
  for i:=1 to Dimf do
    v[i]:= NIL;
 end;

 Procedure LeerPelicula(var p:pelicula);
 begin
  write('ingrese el codigo de pelicula:');
  readln(p.codpeli);
  if(p.codpeli<>-1)then begin
   write('ingrese el titulo de la pelicula:');
   readln(p.titulo);
   write('ingrese el codigo de genero de la pelicula:');
   readln(p.codgen);
   write('ingrese el puntaje promedio de la pelicula:');
   readln(p.puntajeprom);
  end;
 end;

 Procedure CargarPeli(p:pelicula; var p1:peli);
 begin
  p1.codpeli:=p.codpeli;
  p1.titulo:=p.titulo;
  p1.puntajeprom:=p.puntajeprom;
 end;

 Procedure InsertarEnLista(var pri:lista; elem:peli);  //ordenada por codigo de pelicula
 var ant, nue, act: lista;
 begin
  new (nue);
  nue^.datos:=elem;
  act:=pri;
  while (act<>NIL) and (act^.datos.codpeli < elem.codpeli) do begin
    ant:= act;
    act:= act^.sig ;
  end;
  if (act = pri)  then
    pri:= nue
  else
    ant^.sig:= nue;
  nue^.sig:= act ;
 end;

var p:pelicula; p1:peli;
begin
 iniVec(v);
 LeerPelicula(p);
 while(p.codpeli<>-1) do begin
  CargarPeli(p,p1);
  InsertarEnLista(v[p.codgen],p1); {de esta forma enviandole p1 se carga en la lista los datos de la pelicula sin el codigo del género}
  writeln();
  LeerPelicula(p);
 end;
end;


Procedure informarPuntajeMax(v:vector);

 Procedure CalcularPuntajeMax(t:real; var max:real; i:integer; var codgenmax:integer);
 begin
  if(t>max)then begin
    max:=t;
    codgenmax:= i;
  end;
 end;


 Procedure recorrerlista(L:lista; var total:real);
 begin
  total:=0;
  while(L<>NIL) do begin
    total:= total + L^.datos.puntajeprom;
    writeln('codigo de la pelicula: ' , L^.datos.codpeli);
    L:=L^.sig;
  end;
  writeln('total de puntaje obtenido:', total:3:2,' ');
 end;


var i:integer; total, max: real; codgenmax:integer;
begin
 max:=-1;
 for i:= 1 to Dimf do begin
  writeln();
  writeln('codigo del genero ' , i);
  recorrerlista(v[i],total);
  CalcularPuntajeMax(total,max,i,codgenmax);
 end;
 writeln();
 writeln('codigo de genero que mas puntaje obtuvo entre todas las criticas:', codgenmax);
end;


Procedure EliminarElementoConOrden (var L:lista);
  Procedure BorrarElementoEnOrden (var pri:lista; valor:integer; var exito:boolean);
  var ant, act: lista;
  begin
      exito:= false;
      act:= pri;
      while (act <> NIL) and (act^.datos.codpeli < valor) do begin
         ant:= act;
         act:= act^.sig
      end;
      if (act <> NIL) and (act^.datos.codpeli=valor) then begin
         exito := true;
         if (act = pri) then
           pri := act^.sig
         else
           ant^.sig:= act^.sig;
         dispose (act);
      end;
  end;

var valor:integer; exito:boolean;
begin
 write('ingrese el codigo de la pelicula que quiera eliminar: ');
 readln(valor);
 BorrarElementoEnOrden(L,valor,exito);
 writeln();
 if(exito=true) then
  writeln('se elimino el codigo de pelicula ingresado')
 else
  writeln('el codigo de pelicula ingresado no se pudo eliminar');
end;


procedure ImprimirLista(L:lista);
begin
 while(L<>NIL) do begin
  writeln(L^.datos.codpeli);
  L:=L^.sig;
 end;
end;

var
 v:vector; codgen:integer;
begin
 CrearVectorDeListas(v);
 writeln();
 informarPuntajeMax(v);
 writeln();
 write('ingrese el codigo de genero de la pelicula que desea eliminar:');
 readln(codgen);
 EliminarElementoConOrden(v[codgen]);
 writeln();
 ImprimirLista(v[codgen]);
 writeln('se imprimio la lista modificada');
 readln;
end.
