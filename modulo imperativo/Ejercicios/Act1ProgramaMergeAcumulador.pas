Program MergeAcumuladorr;
Const
 DimF = 4;
Type
 r1=1..31;
 r2=1..12;
 rango=1..Dimf;
 consumo=record
   tipo:integer;
   fecha:r1;
   monto:real;
 end;
 nuevo=record
   tipo:r2;
   monto:real;
 end;
 lista=^nodo;
 nodo=record
  datos:consumo;
  sig:lista;
 end;
 listaNueva=^nodoNuevo;
 nodoNuevo=record
  datos:nuevo;
  sig:listaNueva;
 end;

 vector = Array [rango] of lista;

Procedure CrearVector4Listas(var v:vector);

 Procedure CrearListaOrdenada(var L:lista);

   Procedure InsertarEnLista(var pri:lista; elem:consumo);
   var ant, nue, act: lista;
   begin
    new (nue);
    nue^.datos:=elem;
    act:=pri;
    while (act<>NIL) and (act^.datos.tipo < elem.tipo) do begin
      ant:= act;
      act:= act^.sig ;
    end;
    if (act = pri)  then
      pri:= nue
    else
      ant^.sig:= nue;
    nue^.sig:= act ;
   end;

 var c:consumo;
 begin
  L:=nil;
  c.tipo:=random(13);
  while(c.tipo<>12) do begin
    c.fecha:= random(32);
    c.monto:= random(1000);
    InsertarEnLista(L,c);
    c.tipo:=random(13);
  end;
 end;

var i:integer;
begin
for i:= 1 to DimF do
  CrearListaOrdenada(v[i]);
end;


Procedure informar(v:vector);

 Procedure imprimir4listas(L:lista);
 begin
  while(L<>NIL) do begin
    writeln('tipo de consumo:',L^.datos.tipo);
    writeln('fecha:',L^.datos.fecha);
    writeln('monto del gasto:',L^.datos.monto :3:0);
    writeln();
    L:=L^.sig;
  end;
 end;

var j:integer;
begin
 for j:= 1 to DimF do begin
   writeln();
   writeln('Lista:', j);
   imprimir4listas(v[j]);
 end;
end;


Procedure MergeAcumulador(v:vector; var L:listaNueva);

   Procedure DeterminarMinimo(var v:vector; var min:consumo);
   var i:integer; posMin:integer;
   begin
      min.tipo:=999;
      for i:=1 to DimF do begin
         if (v[i]<>nil) and (v[i]^.datos.tipo<min.tipo) then begin
            min.tipo:=v[i]^.datos.tipo;
            min.monto:=v[i]^.datos.monto;{se podría hacer min:=v[i]^.datos. y se ahorra el asignar dato a dato}
            posMin:=i;
         end;
      end;
      if(min.tipo<>999) then
         v[posMin]:=v[posMin]^.sig;
   end;

   Procedure AgregarAlFinal(var pri, ult:listaNueva; nuev:nuevo);
   var nue:listaNueva;
   begin
      new (nue);
      nue^.datos.tipo:= nuev.tipo;
      nue^.datos.monto:= nuev.monto;
      nue^.sig:= nil;
      if(pri <> nil)then
         ult^.sig:= nue
      else
         pri:= nue;
      ult:= nue;
   end;

var
   min:consumo; ult:listaNueva; actual:integer; total:real; nuev:nuevo;
begin
   L:=nil;
   DeterminarMinimo(v,min);
   while(min.tipo<>999) do begin
      actual:=min.tipo;
      total:=0;
      while (actual=min.tipo) do begin
         total:=total+min.monto;
         DeterminarMinimo(v,min);
      end;
      nuev.tipo:=actual;
      nuev.monto:=total;
      AgregarAlFinal(L,ult,nuev);
   end;
end;

Procedure ImprimirListaMerge(L:listaNueva);
Begin
 while (L<>nil) do begin
  writeln();
  writeln('tipo de consumo:',L^.datos.tipo);
  writeln('monto total gastado en el tipo de consumo ' , L^.datos.tipo, ' entre toda la familia:',L^.datos.monto:3:2);
  writeln();
  L:=L^.sig;
 end;
 readln;
end;


var
 v:vector; Lnuev:listaNueva;
Begin
 CrearVector4Listas(v);
 informar(v);
 MergeAcumulador(v,Lnuev);
 writeln('Lista del Merge Acumulador: ');
 ImprimirListaMerge(Lnuev);
 readln;
End.

