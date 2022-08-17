Program ejerepaso5;
type
   cadena15 = String[15];
   rango = 1..4;
   infectado = record
       dni:integer;
       nom:cadena15;
       nivel:rango;
       codCiu:integer;
    end;
   arbol= ^nodoA;
   nodoA = record
      dato:infectado;
      HI:arbol;
      HD:arbol;
    end;
   lista=^nodo;
   nodo=record
      datos: infectado;
      sig: lista;
   end;


Procedure CrearABB(var a:arbol);

  Procedure LeerInfectado(var i:infectado);
  begin
    write('ingrese el dni del infectado:');
    readln(i.dni);
    if(i.dni<>0) then begin
      write('ingrese el nombre:');
      readln(i.nom);
      write('ingrese el nivel de sintomatologia:');
      readln(i.nivel);
      write('ingrese el codigo de ciudad:');
      readln(i.codCiu);
    end;
  end;

 Procedure Insertar(var a:arbol; i:infectado);
 begin
    if(a=nil) then begin
       new(a);
       a^.dato:=i;
       a^.HI:=nil;
       a^.HD:=nil;
    end
    else begin
      if (a^.dato.dni > i.dni) then
         insertar(a^.HI,i)
      else
         insertar(a^.HD,i);
    end;
 end;

var i:infectado;
begin
  LeerInfectado(i);
  writeln();
  while(i.dni<>0) do begin
     Insertar(a,i);
     LeerInfectado(i);
     writeln();
  end;
end;

procedure EnOrden(a:arbol);
begin
 if (a <> nil) then begin
   enorden (a^.HI);
   writeln();
   writeln ('dni:', a^.dato.dni);
   writeln ('nombre:', a^.dato.nom);
   writeln ('nivel de sintomatologia:', a^.dato.nivel);
   writeln ('codigo de ciudad', a^.dato.codCiu);
   enorden (a^.HD);
 end;
end;

Procedure BuscarInfectado(a:arbol; elem:integer); // incrementa el nivel de un infectado que tiene el dni ingresado. recorre de forma acotada/eficiente
begin
 if(a<>nil) then begin
   if(a^.dato.dni = elem) and (a^.dato.nivel <> 4) then begin
        a^.dato.nivel:= a^.dato.nivel + 1;
        writeln('el nivel de sintimatologia cambio a: ',  a^.dato.nivel);
   end
   else
      if(elem < a^.dato.dni) then BuscarInfectado(a^.Hi,elem)
      else BuscarInfectado(a^.HD,elem);
 end;
end;


procedure Recorrer(a:arbol; var L:lista);  // recorre todo el arbol buscando infectados asintomaticos para despues ir agregandolos a una nueva lista

    Procedure AgregarAdelante(var L:lista; elem:infectado);
    var nue:lista;
    begin
      New(nue);
      nue^.datos:=elem;
      nue^.sig:=L;
      L:=nue;
    end;

begin
 if(a<>nil) then begin
   if(a^.dato.nivel = 1) then
     AgregarAdelante(L,a^.dato);
   Recorrer(a^.Hi,L);
   Recorrer(a^.HD,L);
 end;
end;

procedure ImprimirLista(L:lista);
begin
 while(L<>NIL) do begin
  writeln();
  writeln('dni: ', L^.datos.dni);
  writeln('nombre: ' ,  L^.datos.nom);
  writeln('nivel:' ,  L^.datos.nivel);
  writeln('codigo de ciudad: ' ,  L^.datos.codCiu);
  L:=L^.sig;
 end;
end;


var a:arbol; dni: integer; L:lista;
Begin
 L:=nil;
 a:=nil;
 CrearABB(a);
 writeln('informacion de los infectados:');
 EnOrden(a);
 writeln();
 write('ingrese el dni de un infectado:');
 readln(dni);
 BuscarInfectado(a,dni);
 writeln();
 Recorrer(a,L);
 writeln('nueva lista con todos los infectados asintomaticos');
 ImprimirLista(L);
 readln();
end.

