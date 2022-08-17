Program Merge4Listass;
Const
 DimF = 4;
Type
 rango=1..DimF;
 libro=record
  codISBN:integer;
 end;
 
 lista=^nodo;
 nodo=record
  datos:libro;
  sig:lista;
 end;

 vector = Array [rango] of lista;

Procedure CrearVector4Listas(var v:vector);

 Procedure CrearListaOrdenada(var L:lista);

   Procedure InsertarEnLista(var pri:lista; elem:libro);
   var ant, nue, act: lista;
   begin
    new (nue);
    nue^.datos:=elem;
    act:=pri;
    while (act<>NIL) and (act^.datos.codISBN < elem.codISBN) do begin
      ant:= act;
      act:= act^.sig ;
    end;
    if (act = pri)  then
      pri:= nue
    else
      ant^.sig:= nue;
    nue^.sig:= act ;
   end;

 var li:libro;
 begin
  L:=nil;
  li.codISBN:=random(11);
  while(li.codISBN<>0) do begin
    InsertarEnLista(L,li);
    li.codISBN:=random(11);
  end;
 end;

var i:integer;
begin
for i:= 1 to DimF do
  CrearListaOrdenada(v[i]);
end;

Procedure imprimir4listas(L:lista);
begin
 while(L<>NIL) do begin
  writeln(L^.datos.codISBN);
  L:=L^.sig;
 end;
end;

Procedure informar(v:vector);
 var j:integer;
begin
 for j:= 1 to DimF do begin
  writeln('Lista:',j);
  imprimir4listas(v[j]);
  writeln();
 end;
end;


Procedure Merge4(v:vector; var L:lista);

 Procedure DeterminarMinimo(v:vector; var min:libro);
 var i,posmin:rango;
 begin
  min.codISBN:=9999;
  for i:= 1 to dimF do begin
   if (v[i]<>NIL) and (v[i]^.datos.codISBN < min.codISBN) then begin
       min.codISBN:= v[i]^.datos.codISBN;
       posmin:= i;
   end;
  end;
  if (min.codISBN<>9999) then
     v[posMin]:=v[posMin]^.sig;
 end;

 Procedure AgregarAlFinal(var pri,ult:lista; elem:libro);
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

var min:libro; ult:lista;
begin
 L:=nil; ult:=nil;
 DeterminarMinimo(v,min);
 while(min.codISBN<>9999) do begin
  AgregarAlFinal(L,ult,min);
  DeterminarMinimo(v,min);
 end;
end;

Procedure ImprimirNuevaLista(L:lista);
begin
 while(L<>NIL) do begin
  writeln(L^.datos.codISBN,'');
  L:=L^.sig;
 end;
end;


var
 v:vector; L:lista;
Begin
 Randomize;
 CrearVector4Listas(v);
 informar(v);
 Merge4(v,L);
 writeln();
 writeln('Nueva lista con todos los elementos de las 4 listas ');
 ImprimirNuevaLista(L);
 readln;
End.

