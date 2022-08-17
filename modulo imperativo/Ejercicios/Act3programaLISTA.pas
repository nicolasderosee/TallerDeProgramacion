Program programaLista;
Type
 elemento=record
  cod:integer;
end;
lista=^nodo;
nodo=record
 datos: elemento;
 sig: lista;
end;

procedure CrearListaAgregarAdelante(var L:lista);

Procedure AgregarAdelante(var L:lista; elem:elemento);
    var nue:lista;
    begin
      New(nue);
      nue^.datos:=elem;
      nue^.sig:=L;
      L:=nue;
    end;
var
 elem:elemento;
begin
 L:=NIL;
 elem.cod:= Random(16);
 while(elem.cod<>15)do begin
   AgregarAdelante(L,elem);
   elem.cod:= Random(16);
 end;
end;

procedure CrearListaAgregarAtras(var L2:lista);
   procedure AgregarAtras (var pri, ult: lista; elem: elemento);
   var nue : lista;
   begin
     new (nue);
     nue^.datos:= elem;
     nue^.sig := NIL;
     if pri <> Nil then
        ult^.sig := nue
     else
        pri := nue;
     ult := nue;
   end;
var
 elem:elemento; ult:lista;
begin
 L2:=NIL; ult:=NIL;
 elem.cod:= Random(16);
 while(elem.cod<>15)do begin
  AgregarAtras(L2,ult,elem);
  elem.cod:= Random(16);
 end;
end;


procedure EliminarElemento(var L2:lista);
    Procedure BorrarElemento (var pri:lista; valor:integer; var exito: boolean);
    var ant, act: lista;
    begin
      exito := false;
      act := pri;
      while (act <> NIL) and (act^.datos.cod <> valor) do begin
         ant := act;
         act := act^.sig
      end;
      if (act <> NIL) then begin
         exito := true;
         if (act = pri) then
           pri := act^.sig
         else
           ant^.sig:= act^.sig;
         dispose (act);
      end;
    end;
var
 valor:integer; ok:boolean;
begin
 write('ingrese un valor que quiera eliminar:');
 readln(valor);
 writeln();
 BorrarElemento(L2,valor,ok);
 if(ok=true)then
   writeln('el valor se elimino con exito')
 else
   writeln('el valor no se pudo eliminar');
end;


procedure CrearListaOrdenada(var L3:lista);
   Procedure InsertarEnLista (var pri: lista; elem: elemento);
   var ant, nue, act: lista;
   begin
     new (nue);
     nue^.datos := elem;
     act := pri;
     while (act<>NIL) and (act^.datos.cod < elem.cod) do begin
       ant := act;
       act := act^.sig ;
     end;
     if (act = pri) then
       pri := nue
     else
       ant^.sig := nue;
     nue^.sig := act ;
   end;
var elem:elemento;
begin
 L3:=NIL;
 elem.cod:= random(16);
 while(elem.cod<>15) do begin
   InsertarEnLista(L3,elem);
   elem.cod:=random(16);
 end;
end;


Procedure EliminarElementoConOrden (var L3:lista);
  Procedure BorrarElementoEnOrden (var pri:lista; valor:integer; var exito: boolean);
  var ant, act: lista;
  begin
      exito:= false;
      act:= pri;
      while (act <> NIL) and (act^.datos.cod < valor) do begin
         ant:= act;
         act:= act^.sig
      end;
      if (act <> NIL) and (act^.datos.cod=valor) then begin
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
 write('ingrese un valor que quiera eliminar: ');
 readln(valor);
 BorrarElementoEnOrden(L3,valor,exito);
 writeln();
 if(exito=true) then
  writeln('el valor se elimino con exito')
 else
  writeln('el valor no se pudo eliminar');
end;


procedure ImprimirLista(L:lista);
begin
 while(L<>NIL) do begin
  writeln(L^.datos.cod);
  L:=L^.sig;
 end;
end;

var L,L2,L3:lista;
Begin
 Randomize;
 CrearlistaAgregarAdelante(L);
 ImprimirLista(L);
 writeln('se imprimio la primer lista');
 writeln();
 CrearListaAgregarAtras(L2);
 ImprimirLista(L2);
 writeln('se imprimio la segunda lista');
 writeln();
 EliminarElemento(L2);
 writeln();
 ImprimirLista(L2);
 writeln('se volvio a imprimir la segunda lista');
 CrearListaOrdenada(L3);
 writeln();
 ImprimirLista(L3);
 writeln('se imprimio la tercer lista');
 writeln();
 EliminarElementoConOrden(L3);
 writeln();
 ImprimirLista(L3);
 writeln('se volvio a imprimir la tercer lista');
 Readln;
End.
