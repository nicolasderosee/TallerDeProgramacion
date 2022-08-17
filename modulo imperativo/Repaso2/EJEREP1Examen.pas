Program repaso1;
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
   writeln ('nivel de sintomatologia', a^.dato.nivel);
   writeln ('codigo de ciudad', a^.dato.codCiu);
   enorden (a^.HD);
 end;
end;

Procedure BuscarInfectado(a:arbol; elem:integer; var i:infectado); // devuelve un infectado que tiene el dni ingresado. recorre de forma acotada/eficiente
begin
 if(a<>nil) then begin
   if(a^.dato.dni = elem) then i:= a^.dato
   else
      if(elem < a^.dato.dni) then BuscarInfectado(a^.Hi,elem,i)
      else BuscarInfectado(a^.HD,elem,i);
 end;
end;

function VerMax(a:arbol): integer; // busca el infectado con el dni mas grande. recorre de forma acotada/eficiente
begin
 if(a=nil) then Vermax:= -1
 else begin
   if(a^.HD = nil) then
     Vermax:= a^.dato.dni
   else
      VerMax:= Vermax(a^.HD)
 end;
end;


procedure Recorrer(a:arbol; var cant:integer);  // cuenta la cantidad de infectados asintomaticos que hay en la estructura. recorre de forma completa
begin
 if(a<>nil) then begin
   if(a^.dato.nivel = 1) then
     cant:= cant + 1;
   Recorrer(a^.Hi,cant);
   Recorrer(a^.HD,cant);
 end;
end;

var a:arbol; dni, vmax, cant:integer; i:infectado;
Begin
 cant:=0;
 a:=nil;
 CrearABB(a);
 writeln('informacion de los infectados:');
 EnOrden(a);
 writeln();
 write('ingrese el dni del infectado que quiera buscar:');
 readln(dni);
 BuscarInfectado(a,dni,i);
 writeln();
 writeln('informacion del infectado con dicho dni:');
 writeln('dni:', i.dni);
 writeln('nombre:', i.nom);
 writeln('nivel de sintomatologia:', i.nivel);
 writeln('codigo de ciudad:', i.codCiu);
 writeln();
 vmax:= VerMax(a);
 if(vmax<>-1) then write ('el dni maximo del arbol es:', vmax)
 else writeln ('el arbol esta vacio');
 writeln();
 Recorrer(a,cant);
 writeln('cantidad de infectados asintomaticos: ', cant);
 readln;
End.



