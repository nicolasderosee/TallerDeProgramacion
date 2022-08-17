Program ejeRepaso4;
const
   DimF = 7;
Type
   rango=1..DimF;
   entrada=record
      dia:rango;
      codObra:integer;
      asiento:integer;
      monto:real;
    end;
   ent=record
      codObra:integer;
      asiento:integer;
      monto:real;
    end;
   nuevo=record
       codObra:integer;
       cant:integer;
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


procedure CrearVectorDeListas (var v:vector);

   procedure inivec(var v:vector);
   var i:integer;
   begin
       for i:=1 to Dimf do
          v[i]:= NIL;
   end;

   procedure LeerEntrada(var e:entrada);
   begin
      write('Ingrese el codigo de la obra:');
      readln(e.codObra);
      if(e.codObra<>0) then begin
         write('Ingrese el dia de la funcion:');
         readln(e.dia);
         write('Ingrese el numero de asiento:');
         readln(e.asiento);
         write('Ingrese el monto:');
         readln(e.monto);
         writeln();
     end
   end;

  Procedure CargarEnt(e:entrada; var e1:ent);
  begin
     e1.codObra:=e.codObra;
     e1.asiento:=e.asiento;
     e1.monto:=e.monto;
  end;

  Procedure InsertarEnLista(var pri:lista; elem:ent); //ordenada por cod de obra de forma ascendente
  var ant, nue, act: lista;
  begin
    new (nue);
    nue^.datos:=elem;
    act :=pri;
    while (act<>NIL) and (act^.datos.codObra < elem.codObra) do begin
        ant := act;
        act := act^.sig ;
    end;
    if (act = pri)  then pri:= nue
    else ant^.sig:= nue;
    nue^.sig:= act;
  end;


var e:entrada; e1:ent;
begin
   inivec(v);
   LeerEntrada(e);
   while(e.codObra<>0) do begin
      CargarEnt(e,e1);
      InsertarEnLista(v[e.dia],e1); {de esta forma enviandole e1 se carga en la lista los datos de la entrada sin el dia}
      LeerEntrada(e);
   end;
end;


procedure ImprimirVectorDeListas(v:vector);
  Procedure recorrerlista(L:lista);
  begin
     while(L<>NIL) do begin
        writeln('codigo de obra:', L^.datos.codObra);
        writeln('asiento:', L^.datos.asiento);
        writeln('monto:',  L^.datos.monto:3:2);
        L:=L^.sig;
        writeln();
     end;
  end;

var i:integer;
begin
 for i:= 1 to Dimf do begin
  writeln('dia ' , i);
  recorrerlista(v[i]);
  writeln();
 end;
end;


Procedure MergeAcumulador(v:vector; var L:listaNueva);

   Procedure DeterminarMinimo(var v:vector; var min:ent);
   var i:integer; posMin:integer;
   begin
      min.codObra:=999;
      for i:=1 to DimF do begin
         if (v[i]<>nil) and (v[i]^.datos.codObra<min.codObra) then begin
            min:=v[i]^.datos; {se podría hacer min:=v[i]^.datos. y se ahorra el asignar dato a dato}
            posMin:=i;
         end;
      end;
      if(min.codObra<>999) then
         v[posMin]:=v[posMin]^.sig;
   end;

   Procedure AgregarAlFinal(var pri, ult:listaNueva; nuev:nuevo);
   var nue:listaNueva;
   begin
      new (nue);
      nue^.datos.codObra:= nuev.codObra;
      nue^.datos.cant:= nuev.cant;
      nue^.sig:= nil;
      if(pri <> nil)then
         ult^.sig:= nue
      else
         pri:= nue;
      ult:= nue;
   end;

var
   min:ent; ult:listaNueva; actual:integer; total:integer; nuev:nuevo;
begin
   L:=nil;
   DeterminarMinimo(v,min);
   while(min.codObra<>999) do begin
      actual:=min.codObra;
      total:=0;
      while (actual=min.codObra) do begin
         total:=total+1;
         DeterminarMinimo(v,min);
      end;
      nuev.codObra:=actual;
      nuev.cant:=total;
      AgregarAlFinal(L,ult,nuev);
   end;
end;

procedure ImprimirListaMerge(L:listaNueva);
begin
   if (L<>NIL) then begin
     writeln;
     writeln('cantidad de entradas vendidas en la obra con codigo ', L^.datos.codObra , ':', L^.datos.cant);
     L:=L^.sig;
     ImprimirListaMerge(L);
   end;
end;

var
 v:vector; Lnuev:listaNueva;
begin
 CrearVectorDeListas(v);
 writeln();
 ImprimirVectorDeListas(v);
 MergeAcumulador(v,Lnuev);
 writeln('Lista del Merge Acumulador: ');
 ImprimirListaMerge(Lnuev);
 readln;
end.

