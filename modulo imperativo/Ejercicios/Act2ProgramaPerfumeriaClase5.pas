Program Act2PerfumeriaClase5;
Const
 DimF = 5;
Type
 rango=1..DimF;
 venta=record
  codvent:integer;
  codprod:integer;
  cantvendida:integer;
 end;
 nuevo=record
  codprod:integer;
  cantvendida:integer;
 end;
 lista=^nodo;
 nodo=record
  datos:venta;
  sig:lista;
 end;
 listaNueva=^nodoNuevo;
 nodoNuevo=record
  datos:nuevo;
  sig:listaNueva;
 end;

 vector = Array [rango] of lista;


Procedure CrearVector5Listas(var v:vector);

 Procedure CrearListaOrdenada(var L:lista);

   Procedure LeerVenta(var vent:venta);
   begin
     write('ingrese el codigo del producto:');
     readln(vent.codprod);
     if(vent.codprod<>-1) then begin
        write('ingrese el codigo de venta:');
        readln(vent.codvent);
        write('ingrese la cantidad vendida:');
        readln(vent.cantvendida);
     end;
     writeln();
   end;

   Procedure InsertarEnLista(var pri:lista; elem:venta); {lista ordenada por codigo de producto}
   var ant, nue, act: lista;
   begin
    new (nue);
    nue^.datos:=elem;
    act:=pri;
    while (act<>NIL) and (act^.datos.codprod < elem.codprod) do begin
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
  LeerVenta(vent);
  while(vent.codprod<>-1) do begin
    InsertarEnLista(L,vent);
    LeerVenta(vent);
  end;
 end;

var i:integer;
begin
for i:= 1 to DimF do
  CrearListaOrdenada(v[i]);
end;


Procedure informar(v:vector);

 Procedure imprimir5listas(L:lista);
 begin
  while(L<>NIL) do begin
   writeln('codigo del producto:', L^.datos.codprod);
   writeln('codigo de la venta:', L^.datos.codvent);
   writeln('cantidad vendida:', L^.datos.cantvendida);
   writeln();
   L:=L^.sig;
  end;
 end;

var j:integer;
begin
 for j:= 1 to DimF do begin
  writeln('Lista:',j);
  imprimir5listas(v[j]);
  writeln();
 end;
end;

Procedure Merge5(v:vector; var L:lista);

 Procedure DeterminarMinimo(var v:vector; var min:venta);
 var i,posmin:integer;
 begin
  min.codprod:=9999;
  for i:= 1 to dimF do begin
   if (v[i]<>NIL) and (v[i]^.datos.codprod < min.codprod) then begin
       min.codprod:= v[i]^.datos.codprod;
       min.codvent:= v[i]^.datos.codvent;
       posmin:= i;
   end;
  end;
  if (min.codprod<>9999) then
     v[posMin]:=v[posMin]^.sig;
 end;

 Procedure AgregarAlFinal(var pri,ult:lista; elem:venta); {Nueva lista ordenada por codigo de producto}
 var nue:lista;
 begin
   new (nue);
   nue^.datos:= elem;
   nue^.sig:= NIL;
   if(pri <> NIL)then
       ult^.sig := nue
   else
       pri:= nue;
   ult:= nue;
 end;

var min:venta; ult:lista;
begin
 L:=nil; ult:=nil;
 DeterminarMinimo(v,min);
 while(min.codprod<>9999) do begin
  AgregarAlFinal(L,ult,min);
  DeterminarMinimo(v,min);
 end;
end;


Procedure ImprimirNuevaLista(L:lista);
begin
 while(L<>NIL) do begin
  writeln('codigo del producto:', L^.datos.codprod);
  writeln('codigo de la venta:', L^.datos.codvent);
  writeln();
  L:=L^.sig;
 end;
end;


Procedure MergeAcumulador(v:vector; var L:listaNueva);

   Procedure DeterminarMinimo(var v:vector; var min:venta);
   var i:integer; posMin:integer;
   begin
      min.codprod:=999;
      for i:=1 to DimF do begin
         if (v[i]<>nil) and (v[i]^.datos.codprod < min.codprod) then begin
            min.codprod:=v[i]^.datos.codprod;
            min.cantvendida:=v[i]^.datos.cantvendida;
            posMin:=i;
         end;
      end;
      if(min.codprod<>999) then
         v[posMin]:=v[posMin]^.sig;
   end;

   Procedure AgregarAlFinal(var pri, ult:listaNueva; nuev:nuevo);
   var nue:listaNueva;
   begin
      new (nue);
      nue^.datos.codprod:= nuev.codprod;
      nue^.datos.cantvendida:= nuev.cantvendida;
      nue^.sig:= nil;
      if(pri <> nil)then
         ult^.sig:= nue
      else
         pri:= nue;
      ult:= nue;
   end;

var
   min:venta; ult:listaNueva; actual:integer; total:integer; nuev:nuevo;
begin
   L:=nil;
   DeterminarMinimo(v,min);
   while(min.codprod<>999) do begin
      actual:=min.codprod;
      total:=0;
      while (min.codprod<>999) and (actual=min.codprod) do begin
         total:=total+min.cantvendida;
         DeterminarMinimo(v,min);
      end;
      nuev.codprod:=actual;
      nuev.cantvendida:=total;
      AgregarAlFinal(L,ult,nuev);
   end;
end;

Procedure ImprimirListaMergeAcu(L:listaNueva);
begin
 while(L<>NIL) do begin
  writeln('codigo del producto:', L^.datos.codprod);
  writeln('cantidad vendida:', L^.datos.cantvendida);
  writeln();
  L:=L^.sig;
 end;
end;

var
 v:vector; L:lista; Lnuev:ListaNueva;
Begin
 Randomize;
 CrearVector5Listas(v);
 writeln();
 informar(v);
 Merge5(v,L);
 writeln();
 writeln('Nueva lista con todos los elementos de las 5 listas ');
 writeln();
 ImprimirNuevaLista(L);
 writeln();
 MergeAcumulador(v,Lnuev);
 writeln('Lista del Merge Acumulador: ');
 ImprimirListaMergeAcu(Lnuev);
 readln;
End.
