Program ejeRepaso2ProgramaPeliculas;
const
  DimF = 8;
type
  rango = 1..DimF;
  cadena20 = String[20];
  pelicula = record
     codp:integer;
     titulo:cadena20;
     codgen:rango;
     puntajeprom:real;
   end;
  peli = record
      codp:integer;
      titulo:cadena20;
      puntajeprom:real;
   end;
  lista=^nodo;
  nodo=record
    datos:peli;
    sig:lista;
   end;
  vector = Array [rango] of lista;  //vector de 8 listas, cada lista es el codigo de genero de las peliculas

procedure CrearVectorDeListas (var v:vector);

   procedure inivec(var v:vector);
   var i:integer;
   begin
       for i:=1 to Dimf do
          v[i]:= NIL;
   end;

   procedure LeerPelicula (var p:pelicula);
   begin
      write('Ingrese el codigo de la pelicula:');
      readln(p.codp);
      if(p.codp<>-1) then begin
         write('Ingrese el titulo de la pelicula:');
         readln(p.titulo);
         write('Ingrese el codigo de genero de la pelicula:');
         readln(p.codgen);
         write('Ingrese el puntaje promedio otorgado por las criticas:');
         readln(p.puntajeprom);
         writeln();
     end
   end;

  Procedure CargarPeli(p:pelicula; var p1:peli);
  begin
     p1.codp:= p.codp;
     p1.titulo:= p.titulo;
     p1.puntajeprom:= p.puntajeprom;
  end;

  Procedure InsertarEnLista(var pri:lista; elem:peli);
  var ant, nue, act: lista;
  begin
    new (nue);
    nue^.datos:=elem;
    act :=pri;
    while (act<>NIL) and (act^.datos.codp < elem.codp) do begin
        ant := act;
        act := act^.sig ;
    end;
    if (act = pri)  then pri:= nue
    else ant^.sig:= nue;
    nue^.sig:= act;
  end;


var p:pelicula; p1:peli;
begin
   inivec(v);
   LeerPelicula(p);
   while(p.codp<>-1) do begin
      CargarPeli(p,p1);
      InsertarEnLista(v[p.codgen],p1); {de esta forma enviandole p1 se carga en la lista los datos de la pelicula sin el codigo de genero}
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
    writeln('codigo de la pelicula:', L^.datos.codp);
    total:= total + L^.datos.puntajeprom;
    L:=L^.sig;
  end;
  writeln('total de puntaje promedio obtenido:', total:3:2,' ');
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
      while (act <> NIL) and (act^.datos.codp < valor) do begin
         ant:= act;
         act:= act^.sig
      end;
      if (act <> NIL) and (act^.datos.codp=valor) then begin
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
  writeln(L^.datos.codp);
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
