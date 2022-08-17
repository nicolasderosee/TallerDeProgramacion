Program Perfumeria2;
Const
 DimF = 5;
Type
 rango=1..DimF;
 venta=record
  codVent:integer;
  codProd:integer;
  cantVendi:integer;
 end;
 lista=^nodo;
 nodo=record
  datos:venta;
  sig:lista;
 end;

 vector = Array [rango] of lista;

Procedure CrearVector5Listas(var v:vector);

 Procedure CrearListaOrdenada(var L:lista);

   Procedure LeerVenta(var vent:venta);
   begin
     write('ingrese el codigo del producto:');
     readln(vent.codProd);
     if(vent.codprod<>-1) then begin
        write('ingrese el codigo de venta:');
        readln(vent.codVent);
        write('ingrese la cantidad vendida:');
        readln(vent.cantVendi);
     end;
     writeln();
   end;

   Procedure InsertarEnLista(var pri:lista; elem:venta);
   var ant, nue, act: lista;
   begin
    new (nue);
    nue^.datos:=elem;
    act:=pri;
    while (act<>NIL) and (act^.datos.codProd < elem.codProd) do begin
      ant:= act;
      act:= act^.sig ;
    end;
    if (act = pri)  then
      pri:= nue
    else
      ant^.sig:= nue;
    nue^.sig:= act ;
   end;

 var vent:venta;
 begin
  L:=nil;
  leerVenta(vent);
  while(vent.codProd<>-1) do begin
    InsertarEnLista(L,vent);
    leerVenta(vent);
  end;
 end;

var i:rango;
begin
for i:= 1 to DimF do
  CrearListaOrdenada(v[i]);
end;


Procedure informar(v:vector);

 Procedure imprimir5listas(L:lista);
 begin
    while(L<>NIL) do begin
      writeln('codigo de producto:', L^.datos.codProd);
      writeln('codigo de la venta:', L^.datos.codVent);
      writeln('cantidad vendida:', L^.datos.cantVendi);
      writeln();
      L:=L^.sig;
    end;
 end;

var j:rango;
begin
 for j:= 1 to DimF do begin
   writeln('Lista:',j);
   imprimir5listas(v[j]);
   writeln();
 end;
end;


Procedure Merge5(v:vector; var L:lista);

 Procedure DeterminarMinimo(var v:vector; var min:venta);
 var i,posmin:rango;
 begin
  min.codProd:=9999;
  for i:= 1 to dimF do begin
   if (v[i]<>NIL) and (v[i]^.datos.codProd < min.codProd) then begin
       min:= v[i]^.datos;
       posmin:= i;
   end;
  end;
  if (min.codProd<>9999) then
     v[posMin]:=v[posMin]^.sig;
 end;

 Procedure AgregarAlFinal(var pri,ult:lista; elem:venta);
 var nue:lista;
 begin
  new (nue);
  nue^.datos:= elem;
  nue^.sig:= NIL;
  if(pri <> Nil)then
    ult^.sig := nue
  else
    pri:= nue;
  ult:= nue;
 end;

var min:venta; ult:lista;
begin
 L:=nil; ult:=nil;
 DeterminarMinimo(v,min);
 while(min.codProd<>9999) do begin
  AgregarAlFinal(L,ult,min);
  DeterminarMinimo(v,min);
 end;
end;

Procedure ImprimirNuevaLista(L:lista);
begin
 while(L<>NIL) do begin
   writeln(L^.datos.codVent,'');
   writeln(L^.datos.codProd,'');
   writeln(L^.datos.cantVendi,'');
   writeln();
   L:=L^.sig;
 end;
end;


var
 v:vector; L:lista;
Begin
 CrearVector5Listas(v);
 writeln();
 informar(v);
 Merge5(v,L);
 writeln();
 writeln('Nueva lista con todos los elementos de las 5 listas ');
 writeln();
 ImprimirNuevaLista(L);
 readln;
End.

