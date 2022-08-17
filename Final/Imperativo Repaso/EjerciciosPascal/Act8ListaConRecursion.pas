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
 Readln;
End.
