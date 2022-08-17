Program ejeRepaso1;
const
 dimf = 7;
type
 rango = 1..dimf;
 entrada = record 
   dia: rango;
   codObra: integer;
   asiento: integer;
   monto: real;
 end;
 
 subEntrada = record
    codObra:integer;
    asiento:integer;
    monto:real;
 end;
 
 lista = ^nodo;
 nodo = record 
    dato:subEntrada;
    sig:lista;
 end;
 
 vecListas = array [rango] of lista;


Procedure inicializar (var v:vecListas);
var i:integer;
begin 
  for i:= 1 to dimf do 
     v[i]:= nil;
end;


Procedure leerEntrada(var e:entrada);
begin
   write('ingrese el codigo de la obra:');
   readln(e.codObra);
   if(e.codObra <> 0) then begin 
      write('ingrese el dia de la obra:');
      readln(e.dia);
      write('ingrese el numero de asiento:');
      readln(e.asiento);
      write('ingrese el costo de la entrada:');
      readln(e.monto);
      writeln();
    end;
end;

procedure insertarOrdenado(var L:lista; e:entrada); 
var nue,ant,act:lista;
begin
  act:=L;
  new(nue);
  nue^.dato.codObra:=e.codObra;
  nue^.dato.asiento:=e.asiento;
  nue^.dato.monto:=e.monto;
  nue^.sig:=nil;
  while((act <> nil) and (act^.dato.codObra < e.codObra)) do begin
    ant:=act;
    act:=act^.sig;
  end;
  if(act=L)then
    L:=nue
  else
    ant^.sig:=nue;
  nue^.sig:=act;
end;


Procedure cargarVectorDeListas(var v:vecListas);
var e:entrada;
begin
 leerEntrada(e);
 while (e.codObra <> 0) do begin 
     insertarOrdenado (v[e.dia],e);
     leerEntrada(e);
 end;
end;

Procedure informarLista(L:lista);
begin 
  while (L <> nil) do begin 
     writeln();
     writeln('codigo de la obra:', L^.dato.codObra);
     writeln('monto total de la obra:', L^.dato.monto:0:2);
     L:= L^.sig;
  end;
end;

Procedure informarVectorListas(v:vecListas);
var i:rango;
begin
  for i:= 1 to dimf do begin
    writeln();
    writeln('lista:', i);
    while(v[i] <> nil) do begin 
       writeln();
       writeln('codigo de la obra:', v[i]^.dato.codObra);
       writeln('numero de asiento:', v[i]^.dato.asiento);
       writeln('costo de la entrada:', v[i]^.dato.monto:0:2);
       v[i]:= v[i]^.sig;
    end;
  end;
end;


procedure agregarAtras(var l:lista; var ult:lista; codObra:integer; montoTotal:real);
var nue:lista;
begin
  new(nue);
  nue^.dato.codObra:=codObra;
  nue^.dato.monto:=montoTotal;
  nue^.sig:=nil;
  if (l = nil) then
     l:=nue
  else
     ult^.sig:=nue;
  ult:=nue;
end;
 

procedure minimo(var v:vecListas; var codMin:integer; var costo:real);
var indiceMin,i:integer;
begin
  codMin:=9999; indiceMin:=-1;
  for i:= 1 to dimf do 
    if(v[i] <> nil)then 
      if(v[i]^.dato.codObra < codMin) then begin
        indiceMin:=i;
        codMin:=v[i]^.dato.codObra;
      end;
  if(indiceMin <> -1) then begin
    costo:= v[indiceMin]^.dato.monto;
    v[indiceMin]:= v[indiceMin]^.sig;
  end;
end;


procedure mergeAcumulador(v:vecListas; var ListaNueva:lista);
var codMin,actual:integer; monto,montoTotal:real; ult:lista;
begin
  ListaNueva:=nil;
  minimo(v,codMin,monto);
  while(codMin<>9999)do begin
    actual:=codMin; montoTotal:=0;
    while((codMin<>9999) and (actual=codMin)) do begin
      montoTotal:= montoTotal + monto;
      minimo(v,codMin,monto);
    end;
    agregarAtras(ListaNueva,ult,actual,montoTotal);
  end;
end;


var v:vecListas; Lnueva:lista;
Begin
 inicializar(v);
 cargarVectorDeListas(v);
 informarVectorListas(v);
 mergeAcumulador(v,Lnueva);
 informarLista(Lnueva);
 readln; 
End.
