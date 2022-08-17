Program x;
const 
  dimf = 20;
type
  rango = 1..dimf;
  compra = record
     cod:integer;
     dni:integer;
     fecha:integer;
     monto:real;
     puesto:rango;
  end;
  
  subCompra = record 
     cod:integer;
     dni:integer;
     fecha:integer;
     monto:real;
  end;
  
  lista = ^nodo;
  nodo = record
     dato: subCompra;
     sig: lista;
  end;
  
  arbol = ^nodo2;
  nodo2 = record
     dato: subCompra;
     HI: arbol;
     HD: arbol;
  end;
  
  vector = array [rango] of lista;
  
      
Procedure inicializarVector(var v:vector);
var i:integer;
begin 
  for i:= 1 to dimf do
     v[i]:= nil;
end; 

Procedure leerCompra(var c:compra);
begin 
  write('ingrese dni del cliente:');
  readln(c.dni);
  if(c.dni <> 0) then begin 
      write('ingrese el codigo del cliente:');
      readln(c.cod);
      write('ingrese la fecha:');
      readln(c.fecha);
      write('ingrese el monto gastado:');
      readln(c.monto);
      write('ingrese el numero de puesto donde fue atendido:');
      readln(c.puesto);
      writeln();
  end;
end;


procedure insertarOrdenado(var L:lista; c:compra); 
var nue,ant,act:lista;
begin
  act:= L;
  new(nue);
  nue^.dato.dni:=c.dni;
  nue^.dato.cod:=c.cod;
  nue^.dato.fecha:=c.fecha;
  nue^.dato.monto:=c.monto;
  nue^.sig:=nil;
  while((act <> nil) and (act^.dato.dni < c.dni)) do begin
    ant:=act;
    act:=act^.sig;
  end;
  if(act=L)then
    L:=nue
  else
    ant^.sig:=nue;
  nue^.sig:=act;
end;

Procedure cargarCompras(var v:vector);
var c:compra;
begin
  leerCompra(c);
  while(c.dni <> 0) do begin 
       insertarOrdenado(v[c.puesto], c);
       leerCompra(c);
  end;
end;


Procedure informarVectorListas(v:vector);
var i:rango;
begin
  for i:= 1 to dimf do begin
    writeln();
    writeln('puesto:', i);
    while(v[i] <> nil) do begin 
       writeln();
       writeln('dni del cliente:', v[i]^.dato.dni);
       writeln('codigo de cliente:', v[i]^.dato.cod);
       writeln('fecha:', v[i]^.dato.fecha);
       writeln('monto gastado:', v[i]^.dato.monto:0:2);
       v[i]:= v[i]^.sig;
    end;
  end;
end;


Procedure agregarArbol(var a:arbol; cod:integer; montoT:real);
begin
  if(a = nil) then begin 
    new(a);
    a^.dato.cod:= cod;
    a^.dato.monto:= montoT;
    a^.HI:= nil;
    a^.HD:= nil;
  end
  else 
    if(cod < a^.dato.cod) then 
       agregarArbol(a^.HI,cod,montoT)
    else
       agregarArbol(a^.HD,cod,montoT);
end;



Procedure minimo (var v:vector; var dniMin:integer; var cod:integer; var monto:real);
var i,posMin:integer;
begin
  dniMin:= 9999; posMin:=-1;
  for i:= 1 to dimf do begin 
     if(v[i] <> nil) then 
        if(v[i]^.dato.dni < dniMin) then begin 
           posMin:= i;
           dniMin:= v[i]^.dato.dni;
        end;
  end;
  if(posMin  <> -1) then begin 
     cod := v[posMin]^.dato.cod;
     monto := v[posMin]^.dato.monto;
     v[posMin] := v[posMin]^.sig; 
  end;
end;


Procedure merge(v:vector; var a:arbol);
var monto,montoMax:real; actual,minDni,cod,codAct:integer; 
begin
   a:=nil; 
   minimo(v,minDni,cod,monto);
   while(minDni <> 9999) do begin 
      actual:= minDni; 
      codAct:= cod;
      montoMax:= -1;
      while((minDni <> 9999) and (actual = minDni)) do begin 
          if(monto > montoMax) then 
            montoMax := monto;
          minimo(v,minDni,cod,monto);
      end;
      agregarArbol(a,codAct,montoMax);
   end;
end;


//SUBÁRBOL IZQUIERDO - RAÍZ - SUBÁRBOL DERECHO
Procedure EnOrden(a:arbol);
begin
 if (a <> nil) then begin
   enorden (a^.HI);
   writeln();
   writeln ('codigo de cliente:', a^.dato.cod);
   writeln ('monto mayor:', a^.dato.monto:0:2);
   enorden (a^.HD);
 end;
end;


Function montoMayor(a:arbol; cod:integer):real;
begin 
  if(a = nil) then 
    montoMayor := -1
  else 
    if(cod = a^.dato.cod) then 
       montoMayor := a^.dato.monto
    else
       if(cod < a^.dato.cod) then 
          montoMayor:= montoMayor(a^.HI,cod)
       else
          montoMayor:= montoMayor(a^.HD,cod);
end;

Var v:vector; abb:arbol; cod:integer; montoMax:real;
  
Begin
  inicializarVector(v);
  cargarCompras(v);
  informarVectorListas(v);
  merge(v,abb);
  writeln();
  writeln('arbol ordenado por codigo de cliente con su monto total gastado:');
  EnOrden(abb);
  writeln();
  write('ingrese un codigo de cliente:');
  readln(cod);
  montoMax:= montoMayor(abb,cod);
  if(montoMax <> -1) then writeln('monto mayor:', montoMax:0:2)
  else writeln('el codigo de cliente ingresado no existe');
End.
