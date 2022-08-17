Program ArbolBinario;
Type
  // Arbol de enteros
  arbol= ^nodoA;
  nodoA = Record
    dato: integer;
    HI: arbol;
    HD: arbol;
  end;

  // Lista de Arboles
  listaNivel = ^nodoN;
  nodoN = record
    info: arbol;
    sig: listaNivel;
  end;


//Devuelve la cantidad de elementos de una lista L
function ContarElementos (l: listaNivel): integer;
var c: integer;
begin
 c:= 0;
 While (l <> nil) do begin
   c:= c+1;
   l:= l^.sig;
 end;
 contarElementos := c;
end;

// Agrega los elementos a la lista en el orden en que se leyeron
Procedure AgregarAtras (var l, ult: listaNivel; a:arbol);
var nue:listaNivel;
begin
 new (nue);
 nue^.info := a;
 nue^.sig := nil;
 if l= nil then l:= nue
 else ult^.sig:= nue;
 ult:= nue;
end;


//Muestra los datos del arbol a por niveles
Procedure imprimirpornivel(a: arbol);
var
   l, aux, ult: listaNivel;
   nivel, cant, i: integer;
begin
   l:= nil;
   if(a <> nil)then begin
                 nivel:= 0;
                 AgregarAtras (l,ult,a);
                 while (l<> nil) do begin
                    nivel := nivel + 1;
                    cant:= ContarElementos(l);
                    write ('Nivel ', nivel, ': ');
                    for i:= 1 to cant do begin
                      write (l^.info^.dato, ' - ');
                      if (l^.info^.HI <> nil) then agregarAtras (l,ult,l^.info^.HI);
                      if (l^.info^.HD <> nil) then agregarAtras (l,ult,l^.info^.HD);
                      aux:= l;
                      l:= l^.sig;
                      dispose (aux);
                    end;
                    writeln;
                 end;
   end;
end;


Procedure CrearABB(var a:arbol);

 Procedure Insertar(var a:arbol; num:integer);
 begin
  if(a=nil) then begin
   new(a);
   a^.dato:=num;
   a^.HI:=nil;
   a^.HD:=nil;
  end
  else begin
   if (a^.dato>num) then
     insertar(a^.HI,num)
   else
     insertar(a^.HD,num);
  end;
 end;

var valor:integer;
begin
  write('ingrese un numero:');
  readln(valor);
  While(valor<>-1) do begin
   Insertar(a,valor);
   write('ingrese un numero:');
   readln(valor)
  end;
end;


//SUBÁRBOL IZQUIERDO - RAÍZ - SUBÁRBOL DERECHO
procedure EnOrden(a:arbol);
begin
 if (a <> nil) then begin
   enorden (a^.HI);
   writeln (a^.dato);
   enorden (a^.HD);
 end;
end;

//RAÍZ - SUBÁRBOL IZQUIERDO - SUBÁRBOL DERECHO
procedure PreOrden(a:arbol);
begin
 if (a <> nil) then begin
   writeln (a^.dato);
   Preorden (a^.HI);
   Preorden (a^.HD);
 end;
end;

//SUBÁRBOL IZQUIERDO - SUBÁRBOL DERECHO - RAÍZ
procedure PostOrden(a:arbol);
begin
 if (a <> nil) then begin
   PostOrden (a^.HI);
   PostOrden (a^.HD);
   writeln (a^.dato);
 end;
end;

Procedure busqueda (a:arbol);

 Function Buscar(a:arbol;d:integer):arbol;
 begin
    if(a=nil) then Buscar:=nil
    else
      if(d = a^.dato) then
        Buscar:= a
      else begin
        if(d < a^.dato)then
            Buscar:= Buscar(a^.HI,d)
        else
            Buscar:= Buscar(a^.HD,d);
      end;
 end;

var dato:integer; a1:arbol;
begin
   write('ingrese el dato que quiere buscar en el arbol:');
   readln(dato);
   a1:= Buscar(a,dato);
   writeln();
   If(a1 = nil) then  writeln('no se encontro el dato ingresado')
   else writeln ('se encontro el dato ingresado');
end;


procedure VerValoresEnRango(a:arbol; inf,sup: integer);
begin
  if(a<>nil) then begin
    if (a^.dato >= inf) then begin
       if (a^.dato <= sup) then begin
            write(a^.dato,' - ');
            VerValoresEnRango (a^.HI, inf, sup);
            VerValoresEnRango(a^.HD, inf, sup);
       end
       else
          VerValoresEnRango (a^.HI, inf, sup);
    end
    else VerValoresEnRango (a^.HD, inf, sup);
  end;
end;


Function Vermin (a:arbol): integer;
begin
 if (a=nil) then Vermin:=-1
 else begin
   if (a^.HI = nil) then
     Vermin:= a^.dato
   else
     Vermin:=Vermin(a^.HI)
 end;
end;


function VerMax(a:arbol): integer;
begin
 if(a=nil) then Vermax:= -1
 else begin
   if(a^.HD = nil) then
     Vermax:= a^.dato
   else
      VerMax:= Vermax(a^.HD)
 end;
end;

{PROGRAMA PRINCIPAL}

var a:arbol; var valorini,valorfin,vmin,vmax:integer;
Begin
 a:=nil;
 Randomize;
 CrearABB(a);
 writeln();
 imprimirpornivel(a);
 writeln();
 writeln('Arbol impreso en orden:');
 EnOrden(a);
 writeln();
 writeln();
 writeln('Arbol impreso en pre orden:');
 PreOrden(a);
 writeln();
 writeln();
 writeln('Arbol impreso en post orden:');
 PostOrden(a);
 writeln();
 Busqueda(a);
 writeln();
 write('ingrese el valor inicial del rango:');
 readln(valorini);
 writeln();
 write('ingrese el valor final del rango:');
 readln(valorfin);
 writeln();
 write('valores dentro del rango:');
 VerValoresEnRango(a,valorini,valorfin);
 writeln();
 vmin:=VerMin(a);
 writeln();
 if(vmin<>-1) then write ('el valor minimo del arbol es:', vmin)
 else writeln ('el arbol esta vacio');
 writeln();
 vmax:= VerMax(a);
 if(vmax<>-1) then write ('el valor maximo del arbol es:', vmax)
 else writeln ('el arbol esta vacio');
 readln();
End.
