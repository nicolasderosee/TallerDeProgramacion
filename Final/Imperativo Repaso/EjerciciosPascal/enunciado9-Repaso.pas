program enunciado9;
const 
  dimf = 4;
type
  cadena10 = String [10];
  rango = 1..dimf;
  infectado = record
     dni: integer;
     nom:cadena10;
     nivel:rango;
     codCiu:integer;
  end;
  
  arbol= ^nodoA;
  nodoA = record
    dato: infectado;
    HI: arbol;
    HD: arbol;
  end;
  
  lista = ^nodo;
  nodo = record
     dato:integer;
     sig:lista;
  end;
  
procedure leerInfectado(var i:infectado);
begin 
  read(i.dni);
  if(i.dni <> 0) then begin 
     read(i.nom);
     read(i.nivel);
     read(i.codCiu);
  end;
end; 

procedure agregarArbol(var a:arbol; elem:infectado);
begin
  if(a=nil) then begin 
    new(a);
    a^.dato:= elem;
    a^.HI:= NIL;
    a^.HD:= NIL;
  end
  else 
    if(elem.dni < a^.dato.dni) then agregarArbol(a^.HI,elem)
    else agregarArbol(a^.HD,elem);   
end;

procedure cargarArbol(var a:arbol);
var i:infectado;
begin
  a:= nil;
  leerInfectado(i);
  while(i.dni<>0) do begin 
    agregarArbol(a,i);
    leerInfectado(i);
   end;
end;

procedure cambiarDNI(a:arbol;dni:integer);
begin
 if(a <> nil) then begin 
    if(dni = a^.dato.dni) and (a^.dato.nivel<4) then 
        a^.dato.nivel :=  a^.dato.nivel + 1
    else 
       if(a^.dato.nivel<4) then //significa que todavia no econtre el dni 
          if(dni < a^.dato.dni) then cambiarDNI(a^.HI,dni)
          else cambiarDNI(a^.HD,dni)
 end;
end;

procedure agregarAtras(var l,ult:lista; dni:integer);
var nue:lista;
begin
 new(nue);
 nue^.dato := dni;
 nue^.sig := nil;
 if(l <> nil) then 
    ult^.sig := nue
 else
    l:= nue;
 ult:= nue;
end;

procedure recorrer(a:arbol; var l:lista);
var ult:lista;
begin
  if(a <> nil) then 
     recorrer(a^.HI,l);
     if(a^.dato.nivel = 1) then 
       agregarAtras(l,ult,a^.dato.dni);
     recorrer(a^.HD,l);
end;

var a:arbol; unDNI:integer; l:lista;
begin
  l:=nil;
  cargarArbol(a);
  readln(unDNI);
  cambiarDNI(a,unDNI);
  recorrer(a,l);
End.
