program enunciado10;
type
  cadena10 = String [10];
  auto = record
     patente: cadena10;
     edad: integer;
     papeles: integer;
  end;
  
  arbol= ^nodoA;
  
  nodoA = record
    dato: auto;
    HI: arbol;
    HD: arbol;
  end;


Procedure CrearABB(var a:arbol);

 Procedure leerAuto(var a:auto);
 begin 
    writeln('ingrese la edad del conductor:');
    readln(a.edad);
    if (a.edad <> 0) then begin 
       writeln('ingrese la patente del auto');
       readln(a.patente);
       writeln('ingrese 1 si el conductor tiene papeles en regla o 0 de lo contrario:');
       readln(a.papeles);
    end;
 end;

 Procedure Insertar(var a:arbol; elem:auto; var estaba:boolean);
 begin
  if(a=nil) then begin
   new(a);
   a^.dato:=elem;
   a^.HI:=nil; a^.HD:=nil;
   estaba := false; 
  end
  else begin
   if(elem.patente = a^.dato.patente) then 
        estaba:= true 
   else 
      if (elem.patente < a^.dato.patente) then
           insertar(a^.HI,elem,estaba)
      else
           insertar(a^.HD,elem,estaba);
  end;
 end;
 
var au:auto; estaba:boolean;
begin
  leerAuto(au);
  While(au.edad <> 0) do begin
    Insertar(a,au,estaba);
    if(estaba = true) then begin 
       writeln();
       writeln ('no puede pasar porque ya uso su permiso');
    end;
    leerAuto(au);
  end;
end;


function cantConductoresRango (a:arbol; inf,sup:integer): integer;
var cant:integer;
begin
  if(a = nil) then  
     cantConductoresRango := 0
  else begin
    if (a^.dato.edad >= inf) and (a^.dato.edad <= sup) then 
            cant := 1 
    else cant := 0;
    cantConductoresRango := cant + cantConductoresRango(a^.HI, inf, sup) + cantConductoresRango(a^.HD, inf, sup);
  end;
end;


Function Vermin (a:arbol): arbol;
begin
 if (a=nil) then 
        Vermin:=nil
 else begin
   if (a^.HI = nil) then
        Vermin:= a
   else
     Vermin:=Vermin(a^.HI)
 end;
end;

procedure EnOrden(a:arbol);
begin
 if (a <> nil) then begin
   enorden (a^.HI);
   writeln('patente:', a^.dato.patente);
   writeln('edad del conductor', a^.dato.edad);
   writeln('papeles:',  a^.dato.papeles);
   enorden (a^.HD);
 end;
end;

Var 
  abb:arbol; inf,sup,cant:integer; 
Begin
  abb := nil;
  crearABB(abb);
  writeln('arbol generado:');
  EnOrden(abb);
  writeln('ingrese el limite inferior de edad:');
  readln(inf);
  writeln('ingrese el limite superior de edad:');
  readln(sup);
  cant := cantConductoresRango(abb,inf,sup);
  writeln ('cantidad de conductores dentro del rango de edad: ', cant);
  writeln();
  verMin(abb);
  if(abb <> nil) then 
     writeln('datos del auto con menor patente: ', abb^.dato.patente, ', ', abb^.dato.edad, ', ', abb^.dato.papeles)
  else writeln('el arbol esta vacio');
End.
