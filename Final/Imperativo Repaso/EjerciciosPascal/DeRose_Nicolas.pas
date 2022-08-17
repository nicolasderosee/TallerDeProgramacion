Program DeRoseNicolas;
Const
 DimF = 12;
Type
 cadena15 = String[15];
 rango = 1..DimF;
 Permiso = record
    pat:cadena15;
    edad: integer;
    papeles: cadena15;
    mes:rango;
    permiso:boolean;
  end;

  Permi = record
     pat:cadena15;
     edad:integer;
     papeles:cadena15;
     permiso:boolean;
   end;
  lista=^nodo;
  nodo=record
    datos:permi;
    sig:lista;
  end;

 vector = Array [rango] of lista;

Procedure CrearVectorDeListas(var v:vector);

 Procedure inivec(var v:vector);
 var i:integer;
 begin
  for i:=1 to Dimf do
    v[i]:= NIL;
 end;

 Procedure LeerPermiso(var p:permiso);
 begin
  write('ingrese la edad del conductor:');
  readln(p.edad);
  if(p.edad<>0)then begin
    write('ingrese la patente del auto:');
    readln(p.pat);
    write('ingrese si tiene los papeles en regla:');
    readln(p.papeles);
    writeln('ingrese el mes:');
    writeln();
  end;
 end;

 Procedure CargarPermi(p:permiso; var p1:permi);
 begin
  p1.pat:=p.pat;
  p1.edad:=p.edad;
  p1.papeles:=p.papeles;
  p1.permiso:= p.permiso;
 end;


 Procedure InsertarEnLista(var pri:lista; elem:permi); {Lista ordenada por patente de auto}
 var ant, nue, act: lista;
 begin
  new (nue);
  nue^.datos:=elem;
  act :=pri;
  while (act<>NIL) and (act^.datos.pat < elem.pat) do begin
    ant := act;
    act := act^.sig ;
  end;
  if (act = pri)  then
    pri:= nue
  else
    ant^.sig:= nue;
  nue^.sig:= act ;
 end;

var p:permiso; p1:permi;
begin
 iniVec(v);
 LeerPermiso(p);
 p.permiso:= false;
 while(p.edad<>0) do begin
     if(p.permiso = false) then begin
          CargarPermi(p,p1);
          InsertarEnLista(v[p.mes],p1); {de esta forma enviandole p1 se carga en la lista los datos del permiso sin el mes}
          p.permiso:= true;
          LeerPermiso(p);
     end
     else
          writeln('no puede ingresar')
 end;
end;


var v:vector; sup,inf:integer;
Begin
   CrearVectorDeListas(v);
   writeln('Ingrese el valor superior del rango:');
   readln(sup);
   writeln('Ingrese el valor inferior del rango:');
   readln(inf);
   readln();
End.

