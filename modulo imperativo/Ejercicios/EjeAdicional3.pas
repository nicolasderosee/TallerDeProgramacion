Program EjeAdiciona3;
Type
  rango=2018..2018;
  cadena20=String[20];
  auto=record
    pat:integer;
    anioFabric:rango;
    marca:cadena20;
    modelo:cadena20;
  end;
  arbol= ^nodoA;
  nodoA = Record
    dato:auto;
    HI:arbol;
    HD:arbol;
  end;

Procedure CrearABB(var a:arbol);

 Procedure LeerAuto(var au:auto);
 begin
   write('ingrese la patente del auto:');
   readln(au.pat);
   if(au.pat<>-1) then begin
      write('ingrese el año de fabricacion:');
      readln(au.anioFabric);
      write('ingrese la marca:');
      readln(au.marca);
      write('ingrese el modelo:');
      readln(au.modelo);
      writeln();
   end;
 end;

 Procedure Insertar(var a:arbol; elem:auto);
 begin
  if(a=nil) then begin
   new(a);
   a^.dato:=elem;
   a^.HI:=nil;
   a^.HD:=nil;
  end
  else begin
   if (a^.dato.pat > elem.pat) then
     insertar(a^.HI,elem)
   else
     insertar(a^.HD,elem);
  end;
 end;

var au:auto;
begin
  LeerAuto(au);
  While(au.pat<>-1) do begin
   Insertar(a,au);
   LeerAuto(au);
  end;
end;

procedure EnOrden(a:arbol); //SUBÁRBOL IZQUIERDO - RAÍZ - SUBÁRBOL DERECHO
begin
 if (a <> nil) then begin
   enorden (a^.HI);
   writeln ('patente del auto:',a^.dato.pat);
   writeln ('anio de fabricacion:',a^.dato.anioFabric);
   writeln ('marca:',a^.dato.marca);
   writeln ('modelo:',a^.dato.modelo);
   writeln();
   enorden (a^.HD);
 end;
end;

Procedure Contar(a:arbol;dato:cadena20; var cant:integer);
begin
    if(a=nil) then cant:=0;
    while(a<>nil) do begin
        if(dato = a^.dato.marca) then
           cant:= cant + 1;
        if(dato < a^.dato.marca)then
            Contar(a^.HI,dato,cant)
        else
            Contar(a^.HD,dato,cant);
    end;
end;


var a:arbol; m:cadena20; cant:integer;
Begin
  a:=nil;
  CrearABB(a);
  writeln();
  writeln('Informacion de los autos en venta:');
  EnOrden(a);
  writeln();
  write('ingrese una marca de auto:');
  readln(m);
  cant:=0;
  Contar(a,m,cant);
  if(cant=0) then writeln ('no existe la marca ingresada:')
  else writeln('cantidad de autos de la marca ingresada:', cant);
  Readln;
End.


