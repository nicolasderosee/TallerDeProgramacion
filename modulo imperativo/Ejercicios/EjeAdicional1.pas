Program EjeAdicional;
Const
 DimF = 7;
Type
 rango=1..Dimf;
 entrada=record
   dia:rango;
   codobra:integer;
   asiento:integer;
   monto:real;
 end;
 ent=record
   codobra:integer;
   asiento:integer;
   monto:real;
 end;
 nuevo=record
   codobra:integer;
   cantEvendidas:integer;
 end;
 lista=^nodo;
 nodo=record
  datos:ent;
  sig:lista;
 end;
 listaNueva=^nodoNuevo;
 nodoNuevo=record
  datos:nuevo;
  sig:listaNueva;
 end;

vector = Array [rango] of lista;


Procedure CrearVectorDeListas(var v:vector);

 Procedure inivec(var v:vector);
 var i:integer;
 begin
  for i:=1 to Dimf do
    v[i]:= NIL;
 end;

 Procedure LeerEntrada(var e:entrada);
 begin
  write('ingrese el codigo de obra:');
  readln(e.codobra);
  if(e.codobra<>0)then begin
    write('ingrese el dia de la funcion:');
    readln(e.dia);
    write('ingrese el asiento:');
    readln(e.asiento);
    write('ingrese el monto:');
    readln(e.monto);
    writeln();
  end;
 end;

 Procedure CargarEnt(e:entrada; var e1:ent);
 begin
  e1.codobra:=e.codobra;
  e1.asiento:=e.asiento;
  e1.monto:=e.monto;
 end;


 Procedure InsertarEnLista(var pri:lista; elem:ent); {Lista ordenada por codigo de obra}
 var ant, nue, act: lista;
 begin
  new (nue);
  nue^.datos:=elem;
  act :=pri;
  while (act<>NIL) and (act^.datos.codobra < elem.codobra) do begin
    ant := act;
    act := act^.sig ;
  end;
  if (act = pri)  then
    pri:= nue
  else
    ant^.sig:= nue;
  nue^.sig:= act ;
 end;

var e:entrada; e1:ent;
begin
 iniVec(v);
 LeerEntrada(e);
 while(e.codobra<>0) do begin
  CargarEnt(e,e1);
  InsertarEnLista(v[e.dia],e1); {de esta forma enviandole e1 se carga en la lista los datos de la entrada sin el dia}
  LeerEntrada(e);
 end;
end;

Procedure informar(v:vector);

 Procedure recorrerlista(L:lista);
 begin
  while(L<>NIL) do begin
    writeln('codigo de obra:',L^.datos.codobra);
    writeln('asiento:',L^.datos.asiento);
    writeln('monto:',L^.datos.monto:3:2);
    writeln();
   L:=L^.sig;
  end;
 end;

var i:integer;
begin
 for i:= 1 to Dimf do begin
  writeln('dia', i);
  recorrerlista(v[i]);
  writeln();
 end;
end;


Procedure MergeAcumulador(v:vector; var L:listaNueva);

   Procedure DeterminarMinimo(var v:vector; var min:entrada);
   var i:integer; posMin:integer;
   begin
      min.codobra:=999;
      for i:=1 to DimF do begin
         if (v[i]<>nil) and (v[i]^.datos.codobra<min.codobra) then begin
            min.codobra:=v[i]^.datos.codobra;
            posMin:=i;
         end;
      end;
      if(min.codobra<>999) then
         v[posMin]:=v[posMin]^.sig;
   end;

   Procedure AgregarAlFinal(var pri, ult:listaNueva; nuev:nuevo);
   var nue:listaNueva;
   begin
      new (nue);
      nue^.datos.codobra:= nuev.codobra;
      nue^.datos.cantEvendidas:= nuev.CantEvendidas;
      nue^.sig:= nil;
      if(pri <> nil)then
         ult^.sig:= nue
      else
         pri:= nue;
      ult:= nue;
   end;

var
   min:entrada; ult:listaNueva; actual:integer; total:integer; nuev:nuevo;
begin
   L:=nil; ult:=nil;
   DeterminarMinimo(v,min);
   while(min.codobra<>999) do begin
      actual:=min.codobra;
      total:=0;
      while(actual=min.codobra) do begin
         total:=total+1;
         DeterminarMinimo(v,min);
      end;
      nuev.codobra:=actual;
      nuev.cantEvendidas:=total;
      AgregarAlFinal(L,ult,nuev);
   end;
end;

Procedure ImprimirListaMerge(L:listaNueva);
Begin
 while (L<>nil) do begin
  writeln();
  writeln('codigo de obra:',L^.datos.codobra);
  writeln('cantidad de entradas vendidas' , L^.datos.cantEvendidas);
  L:=L^.sig;
  ImprimirListaMerge(L);
 end;
 readln;
end;


var
 v:vector; L:listaNueva;
begin
 CrearVectorDeListas(v);
 writeln();
 informar(v);
 MergeAcumulador(v,L);
 writeln();
 writeln('Lista del Merge Acumulador: ');
 ImprimirListaMerge(L);
 readln;
End.



