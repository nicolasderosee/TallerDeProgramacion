Program DeRoseNicolas;
type
   cliente = record
       cod:integer;
       dni:integer;
       puntos:integer;
    end;
   arbol= ^nodoA;
   nodoA = record
      dato:cliente;
      HI:arbol;
      HD:arbol;
    end;
   lista=^nodo;
   nodo=record
      datos: integer;
      sig: lista;
   end;

Procedure CrearABB(var a:arbol);

  Procedure LeerCliente(var c:cliente);
  begin
    write('ingrese los puntos acumulados del cliente:');
    readln(c.puntos);
    if(c.puntos<>0) then begin
      write('ingrese el codigo del cliente:');
      readln(c.cod);
      write('ingrese el dni:');
      readln(c.dni);
    end;
  end;

 Procedure Insertar(var a:arbol; c:cliente);   //ordenada por dni
 begin
    if(a=nil) then begin
       new(a);
       a^.dato:=c;
       a^.HI:=nil;
       a^.HD:=nil;
    end
    else begin
      if (a^.dato.dni > c.dni) then
         insertar(a^.HI,c)
      else
         insertar(a^.HD,c);
    end;
 end;

var c:cliente;
begin
  LeerCliente(c);
  writeln();
  while(c.puntos<>0) do begin
     Insertar(a,c);
     LeerCliente(c);
     writeln();
  end;
end;

procedure EnOrden(a:arbol);
begin
 if (a <> nil) then begin
   enorden (a^.HI);
   writeln();
   writeln('puntos:', a^.dato.puntos);
   writeln ('nombre:', a^.dato.cod);
   writeln ('dni:', a^.dato.dni);
   enorden (a^.HD);
 end;
end;

Procedure BuscarCliente(a:arbol; dni:integer; puntos:integer);
begin
 if(a<>nil) then begin
   if(a^.dato.dni = dni) then
         a^.dato.puntos:= a^.dato.puntos + puntos
   else
      if(dni < a^.dato.dni) then BuscarCliente(a^.Hi,dni,puntos)
      else BuscarCliente(a^.HD,dni,puntos);
 end;
end;


procedure NuevaLista(a:arbol; var L:lista; p:integer);

    Procedure AgregarAdelante(var L:lista; elem:integer);
    var nue:lista;
    begin
      New(nue);
      nue^.datos:=elem;
      nue^.sig:=L;
      L:=nue;
    end;

var cod:integer;
begin
 if(a<>nil) then begin
   if(a^.dato.puntos < p) then begin
       cod:= a^.dato.cod;
       AgregarAdelante(L,cod);
   end;
   NuevaLista(a^.Hi,L,p);
   NuevaLista(a^.HD,L,p);
 end;
end;

procedure ImprimirLista(L:lista);
begin
 while(L<>NIL) do begin
  writeln();
  writeln('codigo de cliente: ', L^.datos);
  L:=L^.sig;
 end;
end;

var a:arbol; dni,puntos,p:integer; L:lista;
Begin
     L:=nil;
     a:=nil;
     CrearABB(a);
     EnOrden(a);
     writeln();
     writeln('ingrese un dni de un cliente:');
     readln(dni);
     writeln('ingrese los puntos acumulados del cliente durante el dia:');
     readln(puntos);
     BuscarCliente(a,dni,puntos);
     writeln();
     writeln('ingrese una cantidad de puntos acumulados:');
     readln(p);
     NuevaLista(a,L,p);
     ImprimirLista(L);
     Readln();
End.

