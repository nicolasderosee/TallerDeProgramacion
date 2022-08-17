program ListaConRecursion;
Type
lista=^nodo;
nodo=record
 datos: integer;
 sig: lista;
end;

procedure CrearListaAgregarAdelante(var L:lista);
    Procedure AgregarAdelante(var L:lista; elem:integer);
    var nue:lista;
    begin
      New(nue);
      nue^.datos:=elem;
      nue^.sig:=L;
      L:=nue;
    end;
var
 elem:integer;
begin
 L:=NIL;
 elem:= Random(16);
 while(elem<>15)do begin
   AgregarAdelante(L,elem);
   elem:= Random(16);
 end;
end;



procedure MaximoRec(L:lista;var max:integer);
var n:integer;
begin
 if(L<>NIL) then begin
    n:= L^.datos;
    if(n>max) then
      max:= n;
    MaximoRec(L^.sig,max);
 end;
end;


procedure MinimoRec(L:lista;var min:integer);
var n:integer;
begin
 if(L<>NIL) then begin
    n:= L^.datos;
    if(n<min) then
      min:= n;
    MinimoRec(L^.sig,min);
 end;
end;



function Buscar(L:lista; dato:integer):boolean;
begin
 if(L=nil) then
   Buscar:= false
 else begin
   if(L^.datos = dato)then
     Buscar:= true
   else
     Buscar:= Buscar(L^.sig,dato);
 end;
end;

Procedure RecorrerLista(L:lista);
var max:integer; min:integer; dato:integer; encontre:boolean;
Begin
 max:=-1; min:=999;
 if (L<>nil) then begin
  MaximoRec(L, max);
  MinimoRec(L, min);
  write('ingrese un valor a buscar:');
  readln(dato);
  encontre:=Buscar(L, dato);
 end;
 writeln();
 if (encontre=true) then
  writeln('el numero ', dato,  ' se encontro en la lista')
 else
  writeln('el numero ', dato,  ' no se encontro en la lista');
 writeln();
 writeln('el numero maximo de la lista es: ', max);
 writeln();
 writeln('el numero minimo de la lista es: ', min);
end;


procedure ImprimirLista(L:lista);
begin
 while(L<>NIL) do begin
  writeln(L^.datos);
  L:=L^.sig;
 end;
end;

procedure ImprimirEnOrden(L:lista);
begin
   if (L<>NIL) then begin
     writeln(L^.datos);
     L:=L^.sig;
     ImprimirEnOrden(L);
   end;
end;

procedure ImprimirOrdenInverso(L:lista);
begin
   if (L<>NIL) then begin
     ImprimirOrdenInverso(L^.sig);
     writeln(L^.datos);
   end;
end;


var L:lista;
Begin
 Randomize;
 CrearlistaAgregarAdelante(L);
 ImprimirLista(L);
 writeln('se imprimio la lista');
 writeln();
 ImprimirEnOrden(L);
 writeln('se imprimio la lista en orden de ingreso');
 writeln();
 ImprimirOrdenInverso(L);
 writeln('se imprimio la lista en orden inverso');
 writeln();
 RecorrerLista(L);
 Readln;
End.
